package com.pc.model;

/**
 * Created by PC on 2017/7/27.
 */
public class SysUser {
    private Integer id;
    private String username;
    private String password;

    public SysUser(SysUser user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.id = user.getId();
    }
    public SysUser(Integer id,String username,String password){
        this.username = username;
        this.password = password;
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
