package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class ProfesorController {
  private List<Profesor> Profesori = new ArrayList<Profesor>();

  ProfesorController() {
    Profesor p1 = new Profesor(1, "John",23,5);
    Profesor p2 = new Profesor(2, "Paul",44,2);
    Profesor p3 = new Profesor(3, "Paula",100,1);

    Profesori.add(p1);
    Profesori.add(p2);
    Profesori.add(p3);
  }

  @RequestMapping(value="/Profesor", method = RequestMethod.GET)
  public List<Profesor> index() {
    return this.Profesori;
  }

  @RequestMapping(value="/Profesor/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Profesor p : this.Profesori) {
      if(p.getId() == id) {
        return new ResponseEntity<Profesor>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Profesor/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Profesor p : this.Profesori) {
      if(p.getId() == id) {
        this.Profesori.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}