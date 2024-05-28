package com.mlfc.mapper;

import com.mlfc.entity.Course;
import com.mlfc.entity.CourseCount;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RootCourseMapper {

    @Insert("insert into public_timetable (course_id , course_name , week , time , teacher_id , teacher_name , classroom , total , booked)"+
    "values (#{course.courseId} , #{course.courseName} , #{course.week} , #{course.time} , #{course.teacherId} , #{course.teacherName} , #{course.classroom} , #{course.total} , #{course.booked})")
    void addCoursePublic(@Param("course") Course course);

    @Insert("insert into personal_timetable (course_id , course_name , week , time , teacher_name , classroom)"+
            "values (#{course.courseId} , #{course.courseName} , #{course.week} , #{course.time} , #{course.teacherName} , #{course.classroom})")
    void addCoursePrivate(@Param("course") Course course);

    @Delete("delete from public_timetable where course_id = #{courseId}")
    void deleteRootCourse(@Param("courseId") Integer courseId);

    @Update("delete from public_timetable where course_id in (#{courseIds})")
    void deleteRootCourseMultiple(@Param("courseIds") List<Integer> courseIds);

    @Update("update public_timetable set course_name = #{course.courseName}," +
            " week = #{course.week}," +
            " time = #{course.time}," +
            " teacher_id = #{course.teacherId}," +
            " teacher_name = #{course.teacherName}," +
            " classroom = #{course.classroom}," +
            " total = #{course.total}," +
            " booked = #{course.booked}" +
            " where course_id = #{course.courseId}")
    void updateRootCourse(@Param("course") Course course);

    @Select("SELECT EXISTS(SELECT 1 FROM public_timetable WHERE course_id = #{course.courseId})")
    Boolean isCourseExist(@Param("courseId") Integer courseId);



}
