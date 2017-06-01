package tr.com.assignment.employee;

import org.springframework.stereotype.Repository;

import tr.com.assignment.base.AbstractDao;

@Repository("employeeDAO")
public class EmployeeDAO extends AbstractDao<Integer, Employee> {
 
    public Employee findById(Integer id) {
    	Employee employee = getByKey(id);
        return employee;
    }
 
    public Boolean save(Employee employee) {
		Boolean result = persist(employee);
		return result;
    }
}