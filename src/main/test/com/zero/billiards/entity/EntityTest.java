package com.zero.billiards.entity;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.zero.billiards.dataobject.po.TUser;
import com.zero.billiards.util.*;

public class EntityTest {
    
    private Session session;
    
    @Before
    public void initSession(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    @Test    //测试添加用户
    public void testSave(){
        session.beginTransaction();
        TUser user = new TUser();
        user.setUsername("rongxh7");
        user.setPassword("blogjava");
        session.save(user);
        session.getTransaction().commit();
    }
    
    @Test    //测试查询用户列表
    @SuppressWarnings("unchecked")
    public void testQuery(){
        session.beginTransaction();
        Query query = session.createQuery("from User u");
        List<TUser> users = query.list();
        for(Iterator<TUser> it = users.iterator() ; it.hasNext() ; ){
            TUser user = it.next();
            System.out.println("username = " + user.getUsername());
        }
        session.beginTransaction().commit();
    }
    
    @Test    //测试查询单个用户
    public void testGet(){
        session.beginTransaction();
        TUser user = (TUser)session.get(TUser.class, 1);
        System.out.println("username = " + user.getUsername());
        session.getTransaction().commit();
    }
    
    @Test    //测试查询修改用户
    public void testUpdate(){
        session.beginTransaction();
        TUser user = (TUser)session.load(TUser.class, 1);
        user.setPassword("hello blogjava");
        session.update(user);
        session.getTransaction().commit();
    }
    
    @Test    //测试删除用户
    public void testDelete(){
        session.beginTransaction();
        session.delete(session.load(TUser.class, 1));
        session.getTransaction().commit();
    }

}
