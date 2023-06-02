package com.example.employee_manager.service.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class EmployeeDTO {
    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private String imgUrl;
    private String password;
    private String email;
    private String citizenId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private int sex;
    private String nationality;
    private String nation;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date issuedOn;
    private String issueBy;
    private String phoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startWork;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endWork;
    private float coefficientsSalary;
    private String education;
    private String role;
    private String accessToken;
    private int status;
    private String createdBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;
    private String lastModifiedBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastModifiedDate;

    private int departmentId;
    private int positionId;
    private List<Integer> certificateId;
    private List<Integer> experienceId;
    private List<Integer> skillId;
    private String departmenName;
    private String positionName;
    public EmployeeDTO() {
    }

    public EmployeeDTO(int id, String userName, String firstName, String lastName, String imgUrl, String password, String email, String citizenId, Date birthday, int sex, String nationality, String nation, String address, Date issuedOn, String issueBy, String phoneNumber, Date startWork, Date endWork, float coefficientsSalary, String education, String role, String accessToken, int status, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate, int departmentId, int positionId, List<Integer> certificateId, List<Integer> experienceId, List<Integer> skillId, String departmenName, String positionName) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imgUrl = imgUrl;
        this.password = password;
        this.email = email;
        this.citizenId = citizenId;
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
        this.departmentId = departmentId;
        this.positionId = positionId;
        this.certificateId = certificateId;
        this.experienceId = experienceId;
        this.skillId = skillId;
        this.departmenName = departmenName;
        this.positionName = positionName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
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

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public List<Integer> getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(List<Integer> certificateId) {
        this.certificateId = certificateId;
    }

    public List<Integer> getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(List<Integer> experienceId) {
        this.experienceId = experienceId;
    }

    public List<Integer> getSkillId() {
        return skillId;
    }

    public void setSkillId(List<Integer> skillId) {
        this.skillId = skillId;
    }

    public String getDepartmenName() {
        return departmenName;
    }

    public void setDepartmenName(String departmenName) {
        this.departmenName = departmenName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
