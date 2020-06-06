package controllers;
import models.Member;
import models.Trainer;
import models.Assessment;
import play.Logger;
import play.mvc.Controller;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Dashboard extends Controller {
  public static void index() {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    List<Assessment> assessments = member.assessments;
    double bmi=0;
    boolean isIdealBodyWeight=false;
    String determineBMICategory="no assessments yet";
    if(assessments.size()>0){
      bmi = GymUtility.calculateBMI(member, assessments.get(assessments.size()-1));
      isIdealBodyWeight = GymUtility.isIdealBodyWeight(member, assessments.get(assessments.size()-1));
      determineBMICategory = GymUtility.determineBMICategory(bmi);
    }
    render("dashboard.html", member, bmi, isIdealBodyWeight, determineBMICategory);
  }

  public static void deletemember (Long id)
  {
    Logger.info("Deleting a member" + id);
    Member member = Member.findById(id);
    member.delete();
    redirect ("/dashboard/trainer");
  }
  public static void deleteassessment (Long id, Long assessmentid)
  {
    Member member = Member.findById(id);
    Assessment assessment = Assessment.findById(assessmentid);
    Logger.info ("Removing assessment" + assessment.id);
    member.assessments.remove(assessment);
    member.save();
    assessment.delete();
    List<Assessment> assessments = member.assessments;
    double bmi=0;
    boolean isIdealBodyWeight=false;
    String determineBMICategory="no assessments yet";
    if(assessments.size()>0){
      bmi = GymUtility.calculateBMI(member, assessments.get(assessments.size()-1));
      isIdealBodyWeight = GymUtility.isIdealBodyWeight(member, assessments.get(assessments.size()-1));
      determineBMICategory = GymUtility.determineBMICategory(bmi);
    }

    render("dashboardtrainer.html", member, bmi, isIdealBodyWeight, determineBMICategory);
  }
  public static void deleteownassessment (Long id)
  {
    Member member = Accounts.getLoggedInMember();
    Assessment assessment = Assessment.findById(id);
    Logger.info ("Removing assessment" + assessment.id);
    member.assessments.remove(assessment);
    member.save();
    assessment.delete();
    redirect("/dashboard");
  }

  public static void trainer() {
    Logger.info("Rendering Dashboard for trainer");
    Trainer trainer = Accounts.getLoggedInTrainer();
    List<Member> members = Member.findAll();;
    render("trainermain.html", members, trainer);
  }
  public static void member(Long id) {
    Member member = Member.findById(id);
    List<Assessment> assessments = member.assessments;
    double bmi=0;
    boolean isIdealBodyWeight=false;
    String determineBMICategory="no assessments yet";
    if(assessments.size()>0){
      bmi = GymUtility.calculateBMI(member, assessments.get(assessments.size()-1));
      isIdealBodyWeight = GymUtility.isIdealBodyWeight(member, assessments.get(assessments.size()-1));
      determineBMICategory = GymUtility.determineBMICategory(bmi);
    }
    Logger.info ("Member id = " + id);
    render("dashboardtrainer.html", member, bmi, isIdealBodyWeight, determineBMICategory);
  }

  public static void addassessment(double weight, double chest, double thigh, double upperarm, double waist, double hips){
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formattedDate = myDateObj.format(myFormatObj);
    System.out.println("After formatting: " + formattedDate);
    Logger.info ("Adding a new assessment");
    Member member = Accounts.getLoggedInMember();
    Assessment assessment = new Assessment(weight,chest,thigh, upperarm, waist, hips, formattedDate);
    member.assessments.add(assessment);
    member.save();
    redirect("/dashboard");
  }

  public static void update(Long id, Long assessmentid, String comment){
    Member member = Member.findById(id);
    Assessment assessment = Assessment.findById(assessmentid);
    int index = member.assessments.indexOf(assessment);
    assessment.setComment(comment);
    member.assessments.set(index, assessment);
    Logger.info ("Updating comment in an assessment"+index);
    member.save();
    List<Assessment> assessments = member.assessments;
    double bmi=0;
    boolean isIdealBodyWeight=false;
    String determineBMICategory="no assessments yet";
    if(assessments.size()>0){
      bmi = GymUtility.calculateBMI(member, assessments.get(assessments.size()-1));
      isIdealBodyWeight = GymUtility.isIdealBodyWeight(member, assessments.get(assessments.size()-1));
      determineBMICategory = GymUtility.determineBMICategory(bmi);
    }
    render("dashboardtrainer.html", member, bmi, isIdealBodyWeight, determineBMICategory);
  }

}

