package net.skhu.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.dto.DepartmentDto;
import net.skhu.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired DepartmentRepository departmentRepository;
    @Autowired ModelMapper modelMapper;

    public List<DepartmentDto> findAll() {
        return departmentRepository.findAll()
                  .stream()
                  .map(department -> modelMapper.map(department, DepartmentDto.class))
                  .collect(Collectors.toList());
    }

}

