package com.project.demo.controller;

import com.project.demo.entity.CourseSchedule;
import com.project.demo.service.CourseScheduleService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 选课课表：(CourseSchedule)表控制层
 *
 */
@RestController
@RequestMapping("/course_schedule")
public class CourseScheduleController extends BaseController<CourseSchedule, CourseScheduleService> {

    /**
     * 选课课表对象
     */
    @Autowired
    public CourseScheduleController(CourseScheduleService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(course_schedule_id) AS max FROM "+"`course_schedule`";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = ("SELECT count(*) count FROM `course_information` INNER JOIN `course_schedule` ON course_information.course_no=course_schedule.course_no WHERE course_information.number_of_people_remaining < course_schedule.confirm_the_number_of_people AND course_schedule.course_schedule_id="+max).replaceAll("&#60;","<");
        select = service.runCountSql(sql);
        Integer count = Integer.valueOf(String.valueOf(select.getSingleResult()));
        if(count>0){
            sql = "delete from "+"course_schedule"+" WHERE "+"course_schedule_id"+" ="+max;
            select = service.runCountSql(sql);
            select.executeUpdate();
            return error(30000,"剩余人数不足！");
        }
        sql = "UPDATE `course_information` INNER JOIN `course_schedule` ON course_information.course_no=course_schedule.course_no SET course_information.number_of_people_remaining= course_information.number_of_people_remaining - course_schedule.confirm_the_number_of_people WHERE course_schedule.course_schedule_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
