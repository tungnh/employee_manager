package com.example.employee_manager.service.dto;

import com.example.employee_manager.domain.Employee;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CertificateDTO {
    private int id;
    private String name;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date issueDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;
    private String createdBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;
    private String lastModifiedBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastModifiedDate;
    private int employeeId;

    public CertificateDTO() {
    }

    public CertificateDTO(int id, String name, String description, Date issueDate, Date expirationDate, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate, int employeeId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
