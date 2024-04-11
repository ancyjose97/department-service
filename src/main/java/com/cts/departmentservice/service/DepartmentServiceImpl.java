package com.cts.departmentservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.cts.departmentservice.dto.DepartmentDto;
import com.cts.departmentservice.entity.Department;
import com.cts.departmentservice.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentRepository departmentRepository;
	
	private ModelMapper modelMapper;
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
		
		this.departmentRepository = departmentRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
	
		Department department = modelMapper.map(departmentDto, Department.class);
		
		Department saveDepartment = departmentRepository.save(department);
		
		return modelMapper.map(saveDepartment, DepartmentDto.class);
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		
		Department department = departmentRepository.findByDepartmentCode(departmentCode);
		
		DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getDepartmentName(), department.getDepartmentDescription(), department.getDepartmentCode());
		
		return departmentDto;
	}

}
