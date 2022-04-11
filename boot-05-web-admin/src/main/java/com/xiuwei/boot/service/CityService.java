package com.xiuwei.boot.service;

import com.xiuwei.boot.bean.City;
import com.xiuwei.boot.bean.Department;
import com.xiuwei.boot.mapper.CityMapper;
import com.xiuwei.boot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    CityMapper cityMapper;

    public City getById(Long id){
        return cityMapper.getById(id);
    }

    public void saveCity(City city) {
        cityMapper.insert(city);
    }
}