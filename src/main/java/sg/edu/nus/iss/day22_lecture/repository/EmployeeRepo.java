package sg.edu.nus.iss.day22_lecture.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day22_lecture.model.Employee;

@Repository
public interface EmployeeRepo {

    List<Employee> retrieveEmployeeList();
}
