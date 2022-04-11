package com.xiuwei.boot.mapper;

import com.xiuwei.boot.bean.City;
import com.xiuwei.boot.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

    @Select("select * from city where id=#{id}")
    City getById(Long id);
}
