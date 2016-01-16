package hello;

import java.util.List;
import java.util.ArrayList;

public class Student {
  private String name;
  private int id;
  private float medie;
  private String grupa;
  public Student() {}

  public Student(int id, String name, float medie, String grupa) {
      this.name = name;
      this.id = id;
      this.medie=medie;
      this.grupa=grupa;
  }

  public String getName() {
      return this.name;

  }
  public float getMedie() {
      return this.medie;
      
  }
  public String getGrupa() {
      return this.grupa;
  }

  public void setName(String name){
      this.name=name;
  }
  public void setGrupa(String grupa){
      this.grupa=grupa;
  }
  public void setMedie(float medie){
      this.medie=medie;
  }



  public int getId() {
    return this.id;
  }
}
