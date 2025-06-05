package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 课程类型：(CourseType)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "CourseType")
public class CourseType implements Serializable {

    // CourseType编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_type_id")
    private Integer course_type_id;

    // 课程类型
    @Basic
    private String course_type;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
