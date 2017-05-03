package com.swust.domain;

import java.io.Serializable;

public class Department implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -4515793251916137303L;

	private Integer id;

    private String name;

    private String description;

    private Integer upid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getUpid() {
        return upid;
    }

    public void setUpid(Integer upid) {
        this.upid = upid;
    }
}