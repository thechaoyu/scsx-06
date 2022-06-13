package com.gsm.service.impl;

import com.gsm.dao.SysUserDao;
import com.gsm.entity.SysUser;
import com.gsm.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service("SysUserService")
public class SysUserServiceImpl implements SysUserService {


    //自动注入
    @Resource
    private SysUserDao SysUserDao;


    @Override
    public void add(SysUser SysUser) {

    }

    @Override
    public void mod(SysUser SysUser) {

    }

    @Override
    public void del(Serializable cid) {

    }

    @Override
    public SysUser get(Serializable cid) {
        return null;
    }

    @Override
    public List<SysUser> query() {
        List<SysUser> list = SysUserDao.query(new SysUser());
        System.out.println("数据"+list);
        return list;
    }

    @Override
    public List<SysUser> query(SysUser SysUser) {
        return null;
    }
}
