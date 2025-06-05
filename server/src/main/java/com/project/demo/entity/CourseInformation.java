package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 课程信息：(CourseInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "CourseInformation")
public class CourseInformation implements Serializable {

    // CourseInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_information_id")
    private Integer course_information_id;

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
    // 剩余人数
    @Basic
    private Integer number_of_people_remaining;
    // 教师用户
    @Basic
    private Integer teacher_user;
    // 教师姓名
    @Basic
    private String teacher_name;
    // 课程介绍
    @Basic
    private String course_introduction;

    // 点击数
    @Basic
    private Integer hits;

    // 点赞数
    @Basic
    private Integer praise_len;





	// 计时器标题
	@Basic
	private String timer_title;

	// 计时开始时间
	@Basic
	private Timestamp timing_start_time;

	// 计时结束时间
	@Basic
	private Timestamp timing_end_time;


	// 限制次数
	@Basic
	private Integer limit_times;

    // 限制次数类型
    @Basic
    private Integer limit_type;





    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
