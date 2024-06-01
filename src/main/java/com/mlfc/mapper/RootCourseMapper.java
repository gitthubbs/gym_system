package com.mlfc.mapper;

import com.mlfc.entity.Course;
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

    @Delete("<script>" +
            "DELETE FROM public_timetable WHERE course_id IN " +
            "<foreach item='itemId' collection='courseIds' open='(' separator=',' close=')'>" +
            "#{itemId}" +
            "</foreach>" +
            "</script>")
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
    Boolean isCourseIdExist(@Param("courseId") Integer courseId);

    @Select("SELECT EXISTS(SELECT 1 FROM public_timetable WHERE week = #{course.week} AND time = #{course.time} AND teacher_id = #{course.teacherId} ")
    Boolean isCourseExistByTeacher(@Param("course") Course course);

    @Select("SELECT EXISTS(SELECT 1 FROM public_timetable WHERE week = #{course.week} AND time = #{course.time} AND classroom = #{course.classroom} ")
    Boolean isCourseExistByClassroom(@Param("course") Course course);

    @Update("update public_timetable set booked = #{course.booked}")
    void ClearBooked();

    @Delete("DELETE FROM personal_timetable")
    void ClearPersonal();
}
