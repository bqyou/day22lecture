package sg.edu.nus.iss.day22_lecture.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day22_lecture.model.Dependent;
import sg.edu.nus.iss.day22_lecture.model.Employee;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> retrieveEmployeeList() {
        String selectSQL = "select e.id emp_id, e.first_name, e.last_name, e.salary, " +
                "d.id dep_id, d.dependent_name dep_name, d.relationship, d.birthdate " +
                "from employee e " +
                "inner join dependent d " +
                "on e.id = d.employee_id ";

        return jdbcTemplate.query(selectSQL, new ResultSetExtractor<List<Employee>>() {

            @Override
            public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Employee> employees = new ArrayList<Employee>();
                // Set<Integer> uniqueEmployee = new HashSet<Integer>();

                while (rs.next()) {
                    Employee emp = new Employee();
                    emp.setId(rs.getInt("emp_id"));
                    emp.setFirstName(rs.getString("first_name"));
                    emp.setLastName(rs.getString("last_name"));
                    emp.setSalary(rs.getInt("salary"));
                    emp.setDependents(new ArrayList<Dependent>());

                    Dependent dep = new Dependent();
                    dep.setId(rs.getInt("dep_id"));
                    dep.setFullname(rs.getString("dep_name"));
                    dep.setRelationship(rs.getString("relationship"));
                    dep.setBirthDate(rs.getDate("birthdate"));

                    // if (!uniqueEmployee.contains(rs.getInt("emp_id"))) {
                    // employees.add(emp);
                    // } else {

                    // }
                    // uniqueEmployee.add(rs.getInt("emp_id"));

                    if (employees.size() == 0) {
                        emp.getDependents().add(dep);
                        employees.add(emp);
                    } else {
                        List<Employee> elist = employees.stream()
                                .filter(e -> e.getId() == emp.getId())
                                .collect(Collectors.toList());
                        if (elist.size() == 0) {
                            emp.getDependents().add(dep);
                            employees.add(emp);
                        } else {
                            int idx = employees.indexOf(elist.get(0));
                            if (idx >= 0) {
                                employees.get(idx).getDependents().add(dep);
                            }
                        }
                    }
                }
                return employees;
            }
        });
    }
}
