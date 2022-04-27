package com.xiuwei.boot;

import com.xiuwei.boot.bean.User2;
import com.xiuwei.boot.mapper.User2Mapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
/**
 * 测试类必须和java src代码在同一个包下（这里的com.xiuwei.boot）才能正常启动容器，运行test
 * 原理目前还不了解。
 */
public class MyTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    User2Mapper user2Mapper;    //有警告'Could not autowire, no beans of User2Mapper found'但是可忽略。不知道为啥。。。。

    @Autowired
    StringRedisTemplate stringRedisTemplate;    //链接redis进行CRUD操作

    @Autowired
    RedisConnectionFactory redisConnectionFactory;   //用于查看客户端类型

    @Test
    void contextLoads() {

        //#60. 测试数据库连接配置ok
        Long aLong = jdbcTemplate.queryForObject("select count(*) from tbl_employee", Long.class);
        log.info("记录总数：{}",aLong);

        //#61 测试连接阿里druid连接池，而不是默认的HikariDataSource连接池
        log.info("数据库连接池类型:{}", dataSource.getClass()); //应该打印：数据库连接池类型:class com.alibaba.druid.pool.DruidDataSource
    }

    //63 mybatis plus CRUD test
    @Test
    void testUser2Mapper(){
        User2 user2 = user2Mapper.selectById(1);
        log.info("user2：{}", user2);
    }

    //70 数据访问-redis
    @Test
    void testRedis(){
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        //设置值
        String v = "v1";
        stringStringValueOperations.set("k1", v);
        //取出值
        assert (stringStringValueOperations.get("k1").equals(v));

        //查看客户端类型，是jedis还是lettuce
        //jedis: org.springframework.data.redis.connection.jedis.JedisConnectionFactory
        //lettuce: org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
        System.out.println(redisConnectionFactory.getClass().getName());
    }
}
