package hello;

import java.util.List;
import java.util.ArrayList;

public class Profesor {
  private String name;
  private int id;
  private int varsta;
  private int nrGrupe;
  public Profesor() {}

  public Profesor(int id, String name, int varsta, int nrGrupe) {
      this.name = name;
      this.id = id;
      this.varsta=varsta;
      this.nrGrupe=nrGrupe;
  }

  public String getName() {
      return this.name;

  }
  public int getvarsta() {
      return this.varsta;
      
  }
  public int getnrGrupe() {
      return this.nrGrupe;
  }

  public void setName(String name){
      this.name=name;
  }



  public int getId() {
    return this.id;
  }
}
