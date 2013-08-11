package com.zero.billiards.dataobject.param;


public class UserLoginParam {
    private String username;
    private String password;
    private int isCookie = 0;//保持登录状态
    
    public int getIsCookie() {
		return isCookie;
	}

	public void setIsCookie(int isCookie) {
		this.isCookie = isCookie;
	}
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}