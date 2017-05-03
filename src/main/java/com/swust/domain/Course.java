package com.swust.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Course implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6570145198230545572L;

	private Integer id;

    private String name;
    //使用 注解 ，格式换时间。同时 讲String --》Date
    @DateTimeFormat(pattern="yyyy-MM-dd:HH:mm")
    private Date startTime;
    @DateTimeFormat(pattern="yyyy-MM-dd:HH:mm")
    private Date endTime;

    private String longTime;

    private Integer courseNumber;
    private Integer kindsId;

    private String perTime;
    
    private String description;
    
   
   
    

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
    
    
    public String getStartTime() {
    	SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
    	String startTimeStr = simpleDateFormat.format(startTime);
        return startTimeStr;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    
    public String getEndTime() {
    	SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
    	String endTimeStr = simpleDateFormat.format(endTime);
    	
        return endTimeStr;
    }
    
      

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLongTime() {
        return longTime;
    }

    public void setLongTime(String longTime) {
        this.longTime = longTime == null ? null : longTime.trim();
    }

    public Integer getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(Integer courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getPerTime() {
        return perTime;
    }

    public void setPerTime(String perTime) {
        this.perTime = perTime == null ? null : perTime.trim();
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getKindsId() {
		return kindsId;
	}

	public void setKindsId(Integer kindsId) {
		this.kindsId = kindsId;
	}



	
    
    
}