package com.bootcamp.course.service.impl;

import com.bootcamp.course.dto.TeacherDTO;
import com.bootcamp.course.exception.NotFoundException;
import com.bootcamp.course.mapper.TeacherMapper;
import com.bootcamp.course.repository.ITeacherRepository;
import com.bootcamp.course.service.ITeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {

    private final ITeacherRepository teacherRepository;
    private final String NAME_ENTITY = "teacher";

    public TeacherServiceImpl(ITeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public TeacherDTO findById(Long id) {
        return TeacherMapper.teacherToTeacherDTO(teacherRepository.findById(id).orElseThrow(
                () -> new NotFoundException(NAME_ENTITY)));
    }

    @Override
    public List<TeacherDTO> findAll() {
        return TeacherMapper.teacherListToTeacherDTOList(teacherRepository.findAll());
    }

    @Override
    public TeacherDTO save(TeacherDTO teacherDTO) {
        return TeacherMapper.teacherToTeacherDTO(
                teacherRepository.save(TeacherMapper.teacherDTOToTeacher(teacherDTO)));
    }

    @Override
    public TeacherDTO update(Long id, TeacherDTO teacherDTO) {
        validate(id);
        teacherDTO.setId(id);
        return TeacherMapper.teacherToTeacherDTO(
                teacherRepository.save(TeacherMapper.teacherDTOToTeacher(teacherDTO)));
    }

    @Override
    public void delete(Long id) {
        validate(id);
        teacherRepository.deleteById(id);
    }

    private void validate(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new NotFoundException(NAME_ENTITY);
        }
    }
}
