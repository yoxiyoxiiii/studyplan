package com.swust.domain;

import java.io.Serializable;

public class Menu_Role implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2485802724459575026L;

	private Integer id;

    private Integer mid;

    private Integer groupid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }
}