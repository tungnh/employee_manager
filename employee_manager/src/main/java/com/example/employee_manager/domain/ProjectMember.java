//package com.example.employee_manager.domain;
//
//
//import javax.persistence.*;
//import java.util.Date;
//@Entity
//@Table(name = "project_member")
//public class ProjectMember {
//    @EmbeddedId
//    private ProjectMemberId id;
//    @Column(name = "start_date")
//    private Date startDate;
//    @Column(name = "end_date")
//    private Date endDate;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @MapsId("employee_id")
//    @JoinColumn(name = "employee_id")
//    private Employee employee;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @MapsId("project_id")
//    @JoinColumn(name = "project_id")
//    private Project project;
//}
