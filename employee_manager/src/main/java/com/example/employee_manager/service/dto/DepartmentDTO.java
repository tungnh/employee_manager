package com.example.employee_manager.service.dto;

import com.example.employee_manager.domain.Employee;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepartmentDTO {
    private int id;
    private int parentId;
    private int leaderId;
    private int subLeaderId;
    private String name;
    private String description;
    private int status;
    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;

    public DepartmentDTO() {
    }

    public DepartmentDTO(int id, int parentId, int leaderId, int subLeaderId, String name, String description, int status, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
        this.id = id;
        this.parentId = parentId;
        this.leaderId = leaderId;
        this.subLeaderId = subLeaderId;
        this.name = name;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }

    public int getSubLeaderId() {
        return subLeaderId;
    }

    public void setSubLeaderId(int subLeaderId) {
        this.subLeaderId = subLeaderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

}
