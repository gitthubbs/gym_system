package com.mlfc.controller;

import com.mlfc.common.MyCustomException;
import com.mlfc.common.Rest;
import com.mlfc.entity.Course;
import com.mlfc.service.RootCourseService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        log.info("删除课程:{}", courseId);
        rootCourseService.deleteRootCourse(courseId);
        return Rest.success("删除课程成功");
    }

    @PutMapping("/update")
    public Rest<String> updateCourse(@RequestBody Course course) throws MyCustomException {
        log.info("更新课程:{}",course);
        rootCourseService.updateRootCourse(course);
        return Rest.success("更新课程成功");
    }
}
