package com.swust.domain;

import java.io.Serializable;

public class Role_User implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1461480382305754665L;

	private Integer id;

    private Integer uid;

    private Integer rid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}