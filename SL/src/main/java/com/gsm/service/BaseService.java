package com.gsm.service;

import com.gsm.entity.SysUser;

import java.io.Serializable;
import java.util.List;

public interface BaseService<G> {

    public void add(G g);

    public void mod(G g);

    public void del(Serializable cid);

    public G get(Serializable cid);

    public List<G> query();

    public List<G> query(G g);

//    public PageInfo<G> query(G g, int pageNo, int pageSize);
}



