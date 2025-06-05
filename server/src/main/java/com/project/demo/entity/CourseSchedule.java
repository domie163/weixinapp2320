package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 选课课表：(CourseSchedule)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "CourseSchedule")
public class CourseSchedule implements Serializable {

    // CourseSchedule编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_schedule_id")
    private Integer course_schedule_id;

    // 课程编号
    @Basic
    private String course_no;
    // 课程名称
    @Basic
    private String course_name;
    // 封面
    @Basic
    private String cover;
    // 课程类型
    @Basic
    private String course_type;
    // 上课时间
    @Basic
    private String class_time;
    // 上课地点
    @Basic
    private String class_location;
    // 教师用户
    @Basic
    private Integer teacher_user;
    // 教师姓名
    @Basic
    private String teacher_name;
    // 学生用户
    @Basic
    private Integer student_users;
    // 学生姓名
    @Basic
    private String student_name;
    // 确认人数
    @Basic
    private String confirm_the_number_of_people;



    // 审核状态
    @Basic
    private String examine_state;







    @Basic
    @Column(name = "user_id")
    private Integer userId;

    // 审核回复
    @Basic
    private String examine_reply;



    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
