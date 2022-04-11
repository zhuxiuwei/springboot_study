package com.xiuwei.boot.service;

import com.xiuwei.boot.bean.Department;
import com.xiuwei.boot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    public Department getDeptById(Integer id){
        return departmentMapper.getDeptById(id);
    }
}