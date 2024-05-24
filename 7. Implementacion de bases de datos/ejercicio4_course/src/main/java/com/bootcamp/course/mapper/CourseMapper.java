package com.bootcamp.course.mapper;

import com.bootcamp.course.dto.CourseDTO;
import com.bootcamp.course.entity.Course;
import com.bootcamp.course.entity.Teacher;
import org.modelmapper.ModelMapper;

import java.util.List;

public class CourseMapper {

    public static CourseDTO courseToCourseDTO (Course course) {
        ModelMapper modelMapper = new ModelMapper();
        CourseDTO courseDTO = modelMapper.map(course, CourseDTO.class);
        if (course.getTeacher() != null)
            courseDTO.setTeacherId(course.getTeacher().getId());
        if (course.getMentorList() != null)
            courseDTO.setMentorList(MentorMapper.mentorListToMentorDTOList(course.getMentorList()));

        return courseDTO;
    }

    public static Course courseDTOToCourse (CourseDTO courseDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Course course = modelMapper.map(courseDTO, Course.class);
        if (courseDTO.getTeacherId() != null)
            course.setTeacher(Teacher.builder().id(courseDTO.getTeacherId()).build());

        return course;
    }

    public static List<CourseDTO> courseListToCourseDTOList (List<Course> courseList) {
        return courseList.stream()
                .map(CourseMapper::courseToCourseDTO)
                .toList();
    }

}
