package com.xiuwei.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiuwei.boot.bean.User2;
import com.xiuwei.boot.mapper.User2Mapper;
import com.xiuwei.boot.service.User2Service;
import org.springframework.stereotype.Service;

@Service
public class User2ServiceImpl extends ServiceImpl<User2Mapper, User2> implements User2Service {
}
