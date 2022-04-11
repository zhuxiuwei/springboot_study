package com.xiuwei.boot.mapper;

import com.xiuwei.boot.bean.City;
import com.xiuwei.boot.bean.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

    /** 用此注解方式，连mapper文件都省了 */
    @Select("select * from city where id=#{id}")
    City getById(Long id);

    /** 也可以混合方式，继续用mapper文件。适用sql非常复杂的情况 */
    //用注解的写法也可以：
    @Insert("insert into city(`name`,`state`,`country`) values (#{name},#{state},#{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")   //用于捕获新添加数据的id，返回给前端。
    void insert(City city);

}
