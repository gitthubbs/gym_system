package com.mlfc.service;

import com.mlfc.common.MyCustomException;
import com.mlfc.entity.Course;

import java.util.List;

public interface RootCourseService {

    void addRootCoursePublic(Course course) throws MyCustomException;

    void deleteRootCourse(Integer id) throws MyCustomException;

    void deleteRootCourseMultiple(List<Integer> courseIds) throws MyCustomException;

    void updateRootCourse(Course course) throws MyCustomException;

    void addRootCoursePrivate(Course course) throws MyCustomException;
}
