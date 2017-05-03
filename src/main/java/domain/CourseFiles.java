package com.swust.domain;

public class CourseFiles {
    private Integer id;
    private String filesPath;
    private String description;
	private Boolean typeid;
    private Integer cId;
    
    private String fileName;

    public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilesPath() {
        return filesPath;
    }

    public void setFilesPath(String filesPath) {
        this.filesPath = filesPath == null ? null : filesPath.trim();
    }

    public Boolean getTypeid() {
        return typeid;
    }

    public void setTypeid(Boolean typeid) {
        this.typeid = typeid;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }
    
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}