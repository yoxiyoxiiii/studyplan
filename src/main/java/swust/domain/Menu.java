package com.swust.domain;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable{
    
	private static final long serialVersionUID = -235414362772699228L;

	private Integer id;

    private String name;

    private String url;

    private Integer upid;

    private Byte level;
    
    /**
     * 子菜单
     */
    private List<Menu> childs;
    /**
     * 上级菜单
     */
    private Menu parent;
    

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getUpid() {
        return upid;
    }

    public void setUpid(Integer upid) {
        this.upid = upid;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

	public List<Menu> getChilds() {
		return childs;
	}

	public void setChilds(List<Menu> childs) {
		this.childs = childs;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	
	
	
    
    
}