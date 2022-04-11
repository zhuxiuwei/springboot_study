package com.xiuwei.boot.mapper;

import com.xiuwei.boot.bean.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper //不加这个启动会报错：Field departmentMapper in com.xiuwei.boot.service.DepartmentService required a bean of type 'com.xiuwei.boot.mapper.DepartmentMapper' that could not be found.
public interface DepartmentMapper {
    Department getDeptById(Integer id);
}
