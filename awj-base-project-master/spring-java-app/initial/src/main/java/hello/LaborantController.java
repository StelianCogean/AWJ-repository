
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
public class LaborantController {
  private List<Laborant> laboranti = new ArrayList<Laborant>();

  LaborantController() {
    Laborant p1 = new Laborant(1, "John","mate",4);
    Laborant p2 = new Laborant(2, "Paula","romana",3);
    Laborant p3 = new Laborant(3, "Laur","Sport",8);

    laboranti.add(p1);
    laboranti.add(p2);
    laboranti.add(p3);
  }

  @RequestMapping(value="/laborant", method = RequestMethod.GET)
  public List<Laborant> index() {
    return this.laboranti;
  }

@RequestMapping(value="/laborant", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Laborant p) {
  laboranti.add(p);
  
    return new ResponseEntity<Laborant>(p, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/laborant/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Laborant p : this.laboranti) {
      if(p.getId() == id) {
        return new ResponseEntity<Laborant>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/laborant/{id}/{nume}", method = RequestMethod.PUT)
  public List<Laborant> update(@PathVariable("id") int id,@PathVariable("nume") String nume){
    for(Laborant p : this.laboranti){
      if(p.getId() == id)     {
      p.setName(nume);
      }
    }
    return this.laboranti;
  }
  
  @RequestMapping(value="/laborant/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Laborant p : this.laboranti) {
      if(p.getId() == id) {
        this.laboranti.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}

