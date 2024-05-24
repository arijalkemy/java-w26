package com.bootcamp.course.mapper;

import com.bootcamp.course.dto.MentorDTO;
import com.bootcamp.course.entity.Mentor;
import org.modelmapper.ModelMapper;

import java.util.List;

public class MentorMapper {

    public static MentorDTO mentorToMentorDTO (Mentor mentor) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(mentor, MentorDTO.class);
    }

    public static Mentor mentorDTOToMentor (MentorDTO mentorDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(mentorDTO, Mentor.class);
    }

    public static List<MentorDTO> mentorListToMentorDTOList (List<Mentor> mentorList) {
        return mentorList.stream()
                .map(MentorMapper::mentorToMentorDTO)
                .toList();
    }

}
