package com.gsm.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<G> {

    public void add(G g);

    public void mod(G g);

    public void del(Serializable cid);

    public G get(Serializable cid);

    public List<G> query(G g);
}
