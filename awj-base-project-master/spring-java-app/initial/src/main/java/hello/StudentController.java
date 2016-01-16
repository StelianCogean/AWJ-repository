package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;
@RestController
public class StudentController {
  private List<Student> studenti = new ArrayList<Student>();

StudentController() {
    Student p1 = new Student(1, "John", 9, "332AB");
    Student p2 = new Student(2, "Paul",6, "331AB");
    Student p3 = new Student(3, "Kevin", 8, "333AB");

    studenti.add(p1);
    studenti.add(p2);
    studenti.add(p3);
  }

  @RequestMapping(value="/student", method = RequestMethod.GET)
  public List<Student> index() {
    return this.studenti;
  }

 

  @RequestMapping(value="/Student/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Student p : this.studenti) {
      if(p.getId() == id) {
        this.studenti.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
@RequestMapping(value="/Student/{id},{name},{medie},{grupa}", method = RequestMethod.PUT)
  public List<Student> replace(@PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("medie") float medie,@PathVariable("grupa") String grupa) {
    for(Student p : this.studenti) {
      if(p.getId() == id) {
    p.setName(name);
    p.setMedie(medie);
    p.setGrupa(grupa);
    
   }
    }
  return this.studenti;
   
  }


}
