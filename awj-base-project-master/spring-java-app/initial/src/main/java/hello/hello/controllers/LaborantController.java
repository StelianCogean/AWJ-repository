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
public class LaborantController {
  private List<Laborant> laboranti = new ArrayList<Laborant>();
LaborantController() {
    Laborant p1 = new Laborant(1, "John", "awj", 6);
    Laborant p2 = new Laborant(2, "Paul","ac", 5);
    Laborant p3 = new Laborant(3, "Kevin", "ms", 8);

    laboranti.add(p1);
    laboranti.add(p2);
    laboranti.add(p3);
  }

  @RequestMapping(value="/Laborant", method = RequestMethod.GET)
  public List<Laborant> index() {
    return this.laboranti;
  }

  @RequestMapping(value="/Laborant/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Laborant p : this.laboranti) {
      if(p.getId() == id) {
        return new ResponseEntity<Laborant>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Laborant/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Laborant p : this.laboranti) {
      if(p.getId() == id) {
        this.laboranti.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

@RequestMapping(value="/Laborant/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    int j=0;
    for(Laborant p : this.laboranti) {
      if(p.getId() == id) {
       j++
      }
    }
   
      Laborant p= new laboranti(i+1,name,materie,nrGrupe);
        laboranti.add(p);
        return this.laboranti;

  }


}
