package com.mlfc.service.Impl;

import com.mlfc.common.MyCustomException;
import com.mlfc.mapper.RootCourseMapper;
import com.mlfc.entity.Course;
import com.mlfc.service.RootCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@Transactional
public class RootCourseServiceImpl implements RootCourseService {

    @Autowired
    private RootCourseMapper rootCourseMapper;


    @Override
    public void addRootCoursePublic(Course course) throws MyCustomException {
        if(rootCourseMapper.isCourseExistByClassroom(course)){
            log.error("该教室此时间有课");
            throw new MyCustomException("该教室此时间有课");
        }
        if(rootCourseMapper.isCourseExistByTeacher(course )){
            log.error("该老师此时间有课");
            throw new MyCustomException("该老师此时间有课");
        }
        rootCourseMapper.addCoursePublic(course);
        log.info("添加课程成功");
    }

    @Override
    public void deleteRootCourse(Integer id) throws MyCustomException {
        if(!rootCourseMapper.isCourseIdExist(id)){
            log.error("课程不存在");
            throw new MyCustomException("课程不存在");
        }
        rootCourseMapper.deleteRootCourse(id);
        log.info("删除课程成功");
    }

    @Override
    public void deleteRootCourseMultiple(List<Integer> courseIds) {
        rootCourseMapper.deleteRootCourseMultiple(courseIds);
        log.info("删除课程成功");
    }

    @Override
    public void updateRootCourse(Course course) throws MyCustomException {
        if(!rootCourseMapper.isCourseIdExist(course.getCourseId())){
            log.error("课程不存在");
            throw new MyCustomException("课程不存在");
        }
        if(rootCourseMapper.isCourseExistByClassroom(course)){
            log.error("该教室此时间有课");
            throw new MyCustomException("该教室此时间有课");
        }
        if(rootCourseMapper.isCourseExistByTeacher(course )){
            log.error("该老师此时间有课");
            throw new MyCustomException("该老师此时间有课");
        }
        rootCourseMapper.updateRootCourse(course);
        log.info("修改课程成功");
    }

    @Override
    public void addRootCoursePrivate(Course course) throws MyCustomException {
        if(rootCourseMapper.isCourseExistByClassroom(course)){
            log.error("该教室此时间有课");
            throw new MyCustomException("该教室此时间有课");
        }
        if(rootCourseMapper.isCourseExistByTeacher(course )){
            log.error("该老师此时间有课");
            throw new MyCustomException("该老师此时间有课");
        }
        rootCourseMapper.addCoursePrivate(course);
        log.info("添加课程成功");
    }
}
