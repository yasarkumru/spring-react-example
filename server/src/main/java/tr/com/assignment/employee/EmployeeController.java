package tr.com.assignment.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
    private EmployeeService service;

	@GetMapping("/employees")
    public ResponseEntity<List<Employee>> employee() {
		List<Employee> employees = this.service.list();
    	return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    
    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
    	Employee employee = this.service.findById(id);
    	if(employee == null){
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}else{
    		return new ResponseEntity<>(employee, HttpStatus.OK);
    	}
    }
    
    @PostMapping(value = "/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
    	//TODO: check result
    	this.service.saveEmployee(employee);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}
    
    @PutMapping(value = "/employees/{id}")
	public ResponseEntity<Employee> updateEmployee( @RequestBody Employee employee) {
    	//TODO: check result    	
    	this.service.updateEmployee(employee);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/employees/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id) {
    	//TODO: check result		
		this.service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}