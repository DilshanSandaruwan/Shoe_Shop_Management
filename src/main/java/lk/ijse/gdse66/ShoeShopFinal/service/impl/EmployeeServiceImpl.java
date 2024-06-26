package lk.ijse.gdse66.ShoeShopFinal.service.impl;


import lk.ijse.gdse66.ShoeShopFinal.dto.EmployeeDTO;
import lk.ijse.gdse66.ShoeShopFinal.persistence.entity.Employee;
import lk.ijse.gdse66.ShoeShopFinal.persistence.repository.EmployeeRepository;
import lk.ijse.gdse66.ShoeShopFinal.service.EmployeeService;
import lk.ijse.gdse66.ShoeShopFinal.service.execption.DublicateRecordException;
import lk.ijse.gdse66.ShoeShopFinal.service.execption.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Dilshan Sandaruwan,
 * @Runtime version: 11.0.11+9-b1341.60 amd64
 **/
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream().map(
                employee -> modelMapper.map(employee, EmployeeDTO.class)
        ).toList();
    }

    @Override
    public EmployeeDTO getEmployeeDetails(String id) {
        if(!employeeRepository.existsByEmployeeCode(id)){
            throw new NotFoundException("Employee "+id+" Not Found!");
        }
        return modelMapper.map(employeeRepository.findByEmployeeCode(id), EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        if(employeeRepository.existsByEmployeeCode(employeeDTO.getEmployeeCode())){
            throw new DublicateRecordException("This Employee "+employeeDTO.getEmployeeCode()+" already exicts...");
        }
        return modelMapper.map(employeeRepository.save(modelMapper.map(
                employeeDTO, Employee.class)), EmployeeDTO.class
        );
    }

    @Override
    public void updateEmployee(String id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findByEmployeeCode(id);

        if(existingEmployee.getEmployeeName().isEmpty()){
            throw new NotFoundException("Employee ID"+ id + "Not Found...");
        }

        existingEmployee.setEmployeeName(employeeDTO.getEmployeeName());
        existingEmployee.setGender(employeeDTO.getGender());

        employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(String id) {
        if(!employeeRepository.existsByEmployeeCode(id)){
            throw  new NotFoundException("Employee ID"+ id + "Not Found...");
        }
        employeeRepository.deleteByEmployeeCode(id);
    }
}
