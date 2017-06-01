package tr.com.assignment.department;

import org.springframework.stereotype.Repository;

import tr.com.assignment.base.AbstractDao;

@Repository("departmentDAO")
public class DepartmentDAO extends AbstractDao<Integer, Department> {
 
    public Department findById(Integer id) {
    	Department department = getByKey(id);
        return department;
    }
 
    public Boolean save(Department department) {
		Boolean result = persist(department);
		return result;
    }
}