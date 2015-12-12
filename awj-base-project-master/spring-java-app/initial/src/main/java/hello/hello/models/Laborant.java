package hello;

import java.util.List;
import java.util.ArrayList;

public class  {
  private String name;
  private int id;
  private int materie;
  private int nrGrupe;
  public Laborant() {}

  public Laborant(int id, String name, String materie , int nrGrupe, ) {
      this.name = name;
      this.id = id;
      this.materie=materie;
      this.nrGrupe=nrGrupe;
  }

  public String getName() {
      return this.name;

  }
  public String getmaterie() {
      return this.materie;
      
  }
  public String getnrGrupe() {
      return this.nrGrupe;
  }

  public void setName(String name){
      this.name=name;
  }



  public int getId() {
    return this.id;
  }
}
