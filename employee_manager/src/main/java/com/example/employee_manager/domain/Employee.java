package com.example.employee_manager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "user_name", unique = true)
    private String userName;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "img_url")
    private String imgUrl;
    @Column(name = "citizen_id", unique = true)
    private String citzenId;
    @Column(name = "birthday")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthday;
    @Column(name = "sex")
    private int sex;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "nation")
    private String nation;
    @Column(name = "address")
    private String address;
    @Column(name = "issued_on")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date issuedOn;
    @Column(name = "issued_by")
    private String issueBy;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "start_work")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date startWork;
    @Column(name = "end_work")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date endWork;
    @Column(name = "coefficients_salary")
    private float coefficientsSalary;
    @Column(name = "education")
    private String education;
    @Column(name = "role")
    private String role;
    @Column(name = "access_token")
    private String accessToken;
    @Column(name = "status")
    private int status;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createdDate;
    @Column(name = "last_modified_by")
    private String lastModifiedBy;
    @Column(name = "last_modified_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date lastModifiedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id")
    private Position position;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Certificate> certificateList = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Experience> exp = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Skill> skill = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Notification> notification = new ArrayList<>();

    @OneToMany(mappedBy = "employeeLeader")
    @JsonIgnore
    private List<Project> projectList = new ArrayList<>();

    public Employee() {
    }

    public Employee(int id, String userName, String email, String password, String firstName, String lastName, String imgUrl, String citzenId, Date birthday, int sex, String nationality, String nation, String address, Date issuedOn, String issueBy, String phoneNumber, Date startWork, Date endWork, float coefficientsSalary, String education, String role, String accessToken, int status, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate, Department department, Position position, List<Certificate> certificateList, List<Experience> exp, List<Skill> skill, List<Notification> notification) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imgUrl = imgUrl;
        this.citzenId = citzenId;
        this.birthday = birthday;
        this.sex = sex;
        this.nationality = nationality;
        this.nation = nation;
        this.address = address;
        this.issuedOn = issuedOn;
        this.issueBy = issueBy;
        this.phoneNumber = phoneNumber;
        this.startWork = startWork;
        this.endWork = endWork;
        this.coefficientsSalary = coefficientsSalary;
        this.education = education;
        this.role = role;
        this.accessToken = accessToken;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
        this.department = department;
        this.position = position;
        this.certificateList = certificateList;
        this.exp = exp;
        this.skill = skill;
        this.notification = notification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCitzenId() {
        return citzenId;
    }

    public void setCitzenId(String citzenId) {
        this.citzenId = citzenId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getIssuedOn() {
        return issuedOn;
    }

    public void setIssuedOn(Date issuedOn) {
        this.issuedOn = issuedOn;
    }

    public String getIssueBy() {
        return issueBy;
    }

    public void setIssueBy(String issueBy) {
        this.issueBy = issueBy;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getStartWork() {
        return startWork;
    }

    public void setStartWork(Date startWork) {
        this.startWork = startWork;
    }

    public Date getEndWork() {
        return endWork;
    }

    public void setEndWork(Date endWork) {
        this.endWork = endWork;
    }

    public float getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(float coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Certificate> getCertificateList() {
        return certificateList;
    }

    public void setCertificateList(List<Certificate> certificateList) {
        this.certificateList = certificateList;
    }

    public List<Experience> getExp() {
        return exp;
    }

    public void setExp(List<Experience> exp) {
        this.exp = exp;
    }

    public List<Skill> getSkill() {
        return skill;
    }

    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }

    public List<Notification> getNotification() {
        return notification;
    }

    public void setNotification(List<Notification> notification) {
        this.notification = notification;
    }
}
