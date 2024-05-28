package com.mlfc.service.Impl;

import com.mlfc.common.MyCustomException;
import com.mlfc.mapper.RootCourseMapper;
import com.mlfc.entity.Course;
import com.mlfc.service.RootCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Slf4j
@Service
@Transactional
public class RootCourseServiceImpl implements RootCourseService {

    @Autowired
    private RootCourseMapper rootCourseMapper;


    @Override
    public void addRootCoursePublic(Course course) throws MyCustomException {
        if(rootCourseMapper.isCourseExist(course.getCourseId())){
            log.error("课程id已存在");
            throw new MyCustomException("课程id已存在");
        }
        rootCourseMapper.addCoursePublic(course);
        log.info("添加课程成功");
    }

    @Override
    public void deleteRootCourse(Integer id) throws MyCustomException {
        if(!rootCourseMapper.isCourseExist(id)){
            log.error("课程不存在");
            throw new MyCustomException("课程不存在");
        }
        rootCourseMapper.deleteRootCourse(id);
        log.info("删除课程成功");
    }

    @Override
    public void updateRootCourse(Course course) throws MyCustomException {
        if(!rootCourseMapper.isCourseExist(course.getCourseId())){
            log.error("课程不存在");
            throw new MyCustomException("课程不存在");
        }
        rootCourseMapper.updateRootCourse(course);
        log.info("修改课程成功");
    }

    @Override
    public void addRootCoursePrivate(Course course) throws MyCustomException {
        if(rootCourseMapper.isCourseExist(course.getCourseId())){
            log.error("课程id已存在");
            throw new MyCustomException("课程id已存在");
        }
        rootCourseMapper.addCoursePrivate(course);
        log.info("添加课程成功");
    }
}
