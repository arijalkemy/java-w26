package com.bootcamp.course.service.impl;

import com.bootcamp.course.dto.MentorDTO;
import com.bootcamp.course.exception.NotFoundException;
import com.bootcamp.course.mapper.MentorMapper;
import com.bootcamp.course.repository.IMentorRepository;
import com.bootcamp.course.service.IMentorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorServiceImpl implements IMentorService {

    private final IMentorRepository mentorRepository;
    private final String NAME_ENTITY = "mentor";

    public MentorServiceImpl(IMentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    @Override
    public MentorDTO findById(Long id) {
        return MentorMapper.mentorToMentorDTO(mentorRepository.findById(id).orElseThrow(
                () -> new NotFoundException(NAME_ENTITY)));
    }

    @Override
    public List<MentorDTO> findAll() {
        return MentorMapper.mentorListToMentorDTOList(mentorRepository.findAll());
    }

    @Override
    public MentorDTO save(MentorDTO mentorDTO) {
        return MentorMapper.mentorToMentorDTO(
                mentorRepository.save(MentorMapper.mentorDTOToMentor(mentorDTO)));
    }

    @Override
    public MentorDTO update(Long id, MentorDTO mentorDTO) {
        validate(id);
        mentorDTO.setId(id);
        return MentorMapper.mentorToMentorDTO(
                mentorRepository.save(MentorMapper.mentorDTOToMentor(mentorDTO)));
    }

    @Override
    public void delete(Long id) {
        validate(id);
        mentorRepository.deleteById(id);
    }

    private void validate(Long id) {
        if (!mentorRepository.existsById(id)) {
            throw new NotFoundException(NAME_ENTITY);
        }
    }
}
