package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Member extends Model
{


  public String name;
  public String gender;
  public String email;
  public String password;
  public String address;
  public double height;
  public double startingweight;



  @OneToMany(cascade = CascadeType.ALL)
  public List<Assessment> assessments = new ArrayList<Assessment>();




    public Member(String name, String gender, String email, String password, String address, double height, double startingweight)
  {
    this.name = name;
    this.gender = gender;
    this.email = email;
    this.password = password;
    this.address = address;
    this.height = height;
    this.startingweight = startingweight;

  }



  public static Member findByEmail(String email)
  {
    return find("email", email).first();
  }

  public boolean checkPassword(String password)
  {
    return this.password.equals(password);
  }

  public double getHeight() {
      return height;
  }

  public String getGender() {
      return gender;
  }
  public String getName() {
      return name;
  }
  public String getAddress() {
      return address;
  }
  public void setName(String name) {
    this.name = name;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}