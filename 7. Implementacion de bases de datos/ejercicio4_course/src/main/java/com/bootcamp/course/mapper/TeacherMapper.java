package com.bootcamp.course.mapper;

import com.bootcamp.course.dto.TeacherDTO;
import com.bootcamp.course.entity.Teacher;
import org.modelmapper.ModelMapper;

import java.util.List;

public class TeacherMapper {

    public static TeacherDTO teacherToTeacherDTO (Teacher teacher) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(teacher, TeacherDTO.class);
    }

    public static Teacher teacherDTOToTeacher (TeacherDTO teacherDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(teacherDTO, Teacher.class);
    }

    public static List<TeacherDTO> teacherListToTeacherDTOList (List<Teacher> teacherList) {
        return teacherList.stream()
                .map(TeacherMapper::teacherToTeacherDTO)
                .toList();
    }

}
