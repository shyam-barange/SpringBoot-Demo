package com.example.mongodb.springbootmongodb.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodb.springbootmongodb.model.Employee;
import com.example.mongodb.springbootmongodb.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeRepository empRepository;
	
	
	@GetMapping("/welcome/{name}")
	public String welcome(@PathVariable("name") String name) {
		return name+", Welcome to Xplorazzi..!!";
	}
	
	@PostMapping("/addEmployee")
	public String saveEmployee(@RequestBody Employee emp) {
		empRepository.save(emp);
		return "employee added successfully 3::"+emp.getId();
		
	}
	
	@GetMapping("/findAllEmployees")
	public List<Employee> getEmployees() {
		logger.info(" ------  Find All Employee.. ------ ");
		return empRepository.findAll();
	}

	@GetMapping("/findEmployee/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id) {
		logger.info(" ------  findEmployee.. ------ ");

		return empRepository.findById(id);
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		empRepository.deleteById(id);
		logger.info(" ------  deleteEmployee.. ------ ");

		return "Deleted Employee Successfully::"+id;
	}
	

}
