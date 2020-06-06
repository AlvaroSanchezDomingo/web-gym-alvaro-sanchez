package models;

import play.db.jpa.Model;

import javax.persistence.Entity;



@Entity
public class Trainer extends Model
{
  public String name;
  public String gender;
  public String email;
  public String password;
  public String address;


    public Trainer(String name, String gender, String email, String password, String address)
  {
    this.name = name;
    this.gender = gender;
    this.email = email;
    this.password = password;
    this.address = address;
  }

  public static Trainer findByEmail(String email)
  {
    return find("email", email).first();
  }

  public boolean checkPassword(String password)
  {
    return this.password.equals(password);
  }

}