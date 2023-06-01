package com.example.employee_manager.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "leader_id")
    private int leaderId;
    @Column(name = "part") //vi tri lam viec
    private String part;
    @Column(name = "scale") // so luong nguoi tham gia du an
    private int scale;
    @Column(name = "language")
    private String language;
    @Column(name = "framework")
    private String framework;
    @Column(name = "content")
    private String content;
    @Column(name = "description")
    private String description;
    @Column(name = "url")
    private String url;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "status")
    private int status;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "last_modified_by")
    private String lastModifiedBy;
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "leader_id", insertable = false, updatable = false)
    private Employee employeeLeader;

    public Project(int id, String name, int leaderId, String part, int scale, String language, String framework, String content, String description, String url, Date startDate, Date endDate, int status, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate, List<Employee> employeeList, Employee employeeLeader) {

        this.id = id;
        this.name = name;
        this.leaderId = leaderId;
        this.part = part;
        this.scale = scale;
        this.language = language;
        this.framework = framework;
        this.content = content;
        this.description = description;
        this.url = url;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
        this.employeeLeader = employeeLeader;
    }

    public Project() {
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

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public Employee getEmployeeLeader() {
        return employeeLeader;
    }

    public void setEmployeeLeader(Employee employeeLeader) {
        this.employeeLeader = employeeLeader;
    }
}
