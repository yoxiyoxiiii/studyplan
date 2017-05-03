package com.swust.domain;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3267779680891917504L;

	private Integer id;

//    @NotEmpty(message="{user.username.isNotNull}")//使用JSR-303标准校验
    @NotEmpty(message="用户名不能为空！")
    private String username;

    @NotEmpty(message="密码不能为空！")
    private String password;

    private Integer groupid;

    private String studyNumber;

    private String classes;

    private String realname;
    
    private String image;
    
    
    private Map<String,Object> map=new HashMap<String,Object>();
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getStudyNumber() {
        return studyNumber;
    }

    public void setStudyNumber(String studyNumber) {
        this.studyNumber = studyNumber == null ? null : studyNumber.trim();
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes == null ? null : classes.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }
    
    public Map<String,Object> getMap(){
    	return map;
    }

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
    
    
}