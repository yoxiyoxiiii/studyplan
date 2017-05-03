package com.swust.domain;

import java.io.Serializable;

public class Teacher_Course implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8706079651922910722L;

	private Integer id;

    private Integer tid;

    private Integer cid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}