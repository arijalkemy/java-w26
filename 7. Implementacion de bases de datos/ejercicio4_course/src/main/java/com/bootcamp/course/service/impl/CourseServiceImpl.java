package com.bootcamp.course.service.impl;

import com.bootcamp.course.dto.CourseDTO;
import com.bootcamp.course.exception.NotFoundException;
import com.bootcamp.course.mapper.CourseMapper;
import com.bootcamp.course.repository.ICourseRepository;
import com.bootcamp.course.service.ICourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    private final ICourseRepository courseRepository;
    private final String NAME_ENTITY = "course";

    public CourseServiceImpl(ICourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseDTO findById(Long id) {
        return CourseMapper.courseToCourseDTO(courseRepository.findById(id).orElseThrow(
                () -> new NotFoundException(NAME_ENTITY)));
    }

    @Override
    public List<CourseDTO> findAll() {
        return CourseMapper.courseListToCourseDTOList(courseRepository.findAll());
    }

    @Override
    public CourseDTO save(CourseDTO courseDTO) {
        return CourseMapper.courseToCourseDTO(
                courseRepository.save(CourseMapper.courseDTOToCourse(courseDTO)));
    }

    @Override
    public CourseDTO update(Long id, CourseDTO courseDTO) {
        validate(id);
        courseDTO.setId(id);
        return CourseMapper.courseToCourseDTO(
                courseRepository.save(CourseMapper.courseDTOToCourse(courseDTO)));
    }

    @Override
    public void delete(Long id) {
        validate(id);
        courseRepository.deleteById(id);
    }

    private void validate(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new NotFoundException(NAME_ENTITY);
        }
    }
}
