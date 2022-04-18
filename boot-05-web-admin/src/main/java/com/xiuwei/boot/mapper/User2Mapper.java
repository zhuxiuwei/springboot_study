package com.xiuwei.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiuwei.boot.bean.User2;
import org.apache.ibatis.annotations.Mapper;

/**
 * #63 mybatis-plus CRUD。
 * BaseMapper已经实现了很多CURD方法（可以看源码）。
 * 只需要我们的Mapper继承 BaseMapper 就可以拥有crud能力
 */
@Mapper
public interface User2Mapper extends BaseMapper<User2> {

}
