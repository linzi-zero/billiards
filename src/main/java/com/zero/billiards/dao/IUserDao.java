package com.zero.billiards.dao;
import java.util.List;

import com.zero.billiards.dataobject.po.TUser;

public interface IUserDao {
    
    public void save(TUser user);
    
    public void delete(int id);
    
    public void update(TUser user);
    
    public List<TUser> query();
    
    public TUser get(int id);

    public TUser get(String userName,String password);

	public List<TUser> findExcludeByUsername(String userName);
	
	public TUser getUser(String realName, String password);

	public TUser getByUserName(String userName);
}