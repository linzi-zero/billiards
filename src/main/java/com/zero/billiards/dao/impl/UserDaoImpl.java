package com.zero.billiards.dao.impl;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zero.billiards.dao.MyHibernateDaoSupport;
import com.zero.billiards.dao.IUserDao;
import com.zero.billiards.dataobject.po.TUser;

@Repository("userDao")        //声明此类为数据持久层的类
public class UserDaoImpl extends MyHibernateDaoSupport implements IUserDao {
    
    public void save(TUser user){
        super.getHibernateTemplate().save(user);
    }
    
    public void delete(int id){
        super.getHibernateTemplate().delete(super.getHibernateTemplate().load(TUser.class, id));
    }
    
    public void update(TUser user){
        super.getHibernateTemplate().update(user);
    }
    
    @SuppressWarnings("unchecked")
    public List<TUser> query(){
        return super.getHibernateTemplate().find("from TUser");
    }
    
    public TUser get(int id){
        return (TUser)super.getHibernateTemplate().get(TUser.class, id);
    }

	@SuppressWarnings("unchecked")
	public TUser get(String userName, String password) {
		List<TUser> users = super.getHibernateTemplate().find("from TUser where username=? and password=?",new String[]{ userName,password});
		if(users != null && users.size() == 1){
			return users.get(0);
		}
		return  null;
	}
	
	@SuppressWarnings("unchecked")
	public TUser getUser(String realName, String password) {
		List<TUser> users = super.getHibernateTemplate().find("from TUser where username=? and password=?", new String[]{realName,password});
		if(users != null && users.size() == 1){
			return users.get(0);
		}
		return  null;
	}

	@SuppressWarnings("unchecked")
	public List<TUser> findExcludeByUsername(String userName) {
		List<TUser> users = super.getHibernateTemplate().find("from TUser where username<>?", userName);
		return users;
	}

	public TUser getByUserName(String userName) {
		List<TUser> users = super.getHibernateTemplate().find("from TUser where username=?", userName);
		if(users != null && users.size() == 1){
			return users.get(0);
		}
		return null;
	}

}
