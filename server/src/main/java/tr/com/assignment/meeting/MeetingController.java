package tr.com.assignment.meeting;

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
public class MeetingController {
	
	@Autowired
    private MeetingService service;

	@GetMapping("/meetings")
    public ResponseEntity<List<Meeting>> getMeetings() {
		List<Meeting> meetings = this.service.list();
    	return new ResponseEntity<>(meetings, HttpStatus.OK);
    }
    
    @GetMapping(value = "/meetings/{id}")
    public ResponseEntity<Meeting> getMeetingById(@PathVariable("id") Integer id) {
    	Meeting meeting = this.service.findById(id);
    	
    	if(meeting == null){
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}else{
    		return new ResponseEntity<>(meeting, HttpStatus.OK);
    	}      	
    }
    
    @PostMapping(value = "/meetings")
	public ResponseEntity<Meeting> addMeeting(@RequestBody Meeting meeting) {
    	this.service.saveMeeting(meeting);
		return new ResponseEntity<>(meeting, HttpStatus.CREATED);
	}
    
    @PutMapping(value = "/meetings/{id}")
	public ResponseEntity<Meeting> updateMeeting(@RequestBody Meeting meeting) {
    	this.service.updateMeeting(meeting);
		return new ResponseEntity<>(meeting, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/meetings/{id}")
	public ResponseEntity<Void> deleteMeeting(@PathVariable("id") Integer id) {
		this.service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}    
}