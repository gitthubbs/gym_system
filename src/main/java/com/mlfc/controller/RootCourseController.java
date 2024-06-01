package com.mlfc.controller;

import com.mlfc.common.MyCustomException;
import com.mlfc.common.Rest;
import com.mlfc.entity.Course;
import com.mlfc.service.RootCourseService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rootcourse")
public class RootCourseController {

    @Autowired
    private RootCourseService rootCourseService;
    // 添加课程
    @PutMapping("/addpublic")
    public Rest<String> addCourse(@RequestBody Course course) throws MyCustomException {
        log.info("添加课程:{}",course);
        rootCourseService.addRootCoursePublic(course);
        return Rest.success("添加课程成功");
    }
    @PutMapping("/addprivate")
    public Rest<String> addCoursePrivate(@RequestBody Course course) throws MyCustomException {
        log.info("添加课程:{}",course);

        rootCourseService.addRootCoursePrivate(course);

        return Rest.success("添加课程成功");
    }
    @DeleteMapping("/delete/{courseId}")
    public Rest<String> deleteCourse(@PathVariable("courseId") Integer courseId) throws MyCustomException {
        if (courseId == null || courseId <= 0) {
            log.error("无效的课程 ID");
            throw new MyCustomException("无效的课程 ID");
        }
        log.info("删除课程:{}", courseId);
        rootCourseService.deleteRootCourse(courseId);
        return Rest.success("删除课程成功");
    }

    @PutMapping("/delete/batch")
    public Rest<String> deleteCourseMultiple(@RequestBody List<Integer> courseIds) throws MyCustomException {
        log.info("批量删除课程:{}", courseIds);
        rootCourseService.deleteRootCourseMultiple(courseIds);
        return Rest.success("批量删除课程成功");
    }

    @PutMapping("/update")
    public Rest<String> updateCourse(@RequestBody Course course) throws MyCustomException {
        log.info("更新课程:{}",course);
        rootCourseService.updateRootCourse(course);
        return Rest.success("更新课程成功");
    }

    @PutMapping("clear")
    public Rest<String> clearBooked() throws MyCustomException {
        log.info("清空已预约课程");
        rootCourseService.ClearBooked();
        return Rest.success("清空已预约课程成功");
    }

}
