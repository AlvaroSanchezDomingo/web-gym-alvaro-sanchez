package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Assessment extends Model
{
  private String date;
  private double weight;
  private double chest;
  private double thigh;
  private double upperArm;
  private double waist;
  private double hips;
  private String comment;




  public Assessment(double weight, double chest, double thigh, double upperArm, double waist, double hips, String date)
  {
    this.weight = weight;
    this.chest = chest;
    this.thigh = thigh;
    this.upperArm = upperArm;
    this.waist = waist;
    this.hips = hips;
    this.comment = "No comment yet";
    this.date = date;
  }


  //-------
  //getters
  //-------
  public double getWeight() {
    return weight;
  }
  public double getChest() {
    return chest;
  }
  public double getThigh() {
    return thigh;
  }
  public double getUpperArm() {
    return upperArm;
  }
  public double getWaist() {
    return waist;
  }
  public double getHips() {
    return hips;
  }
  public String getComment() {
    return comment;
  }
  public String getDate() {
    return date;
  }

  //-------
  //setters
  //-------
  public void setWeight(double weight) {
    this.weight = weight;
  }
  public void setChest(double chest) {
    this.chest = chest;
  }
  public void setThigh(double thigh) {
    this.thigh = thigh;
  }
  public void setUpperArm(double upperArm) {
    this.upperArm = upperArm;
  }
  public void setWaist(double waist) {
    this.waist = waist;
  }
  public void setHips(double hips) {
    this.hips = hips;
  }
  public void setComment(String comment) {
    this.comment = comment;
  }
  public void setDate(String date) {
    this.date = date;
  }
}
