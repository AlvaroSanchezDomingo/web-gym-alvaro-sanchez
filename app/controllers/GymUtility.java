package controllers;
import java.lang.Math;

import models.Member;
import models.Assessment;

public class GymUtility {

     public static double calculateBMI(Member member, Assessment assessment){
         int valueI = (int)(assessment.getWeight()/ Math.pow(member.getHeight(),2)*100);
         double valueD = ((double)(valueI))/100;
         return valueD;
     }

     public static String determineBMICategory(double bmiValue){
             if(bmiValue<16){
                 return "SEVERELY UNDERWEIGHT";
             }else if(bmiValue>=16 && bmiValue<18.5){
                 return "UNDERWEIGHT";
             }else if(bmiValue>=18.5 && bmiValue<25){
                 return "NORMAL";
             }else if(bmiValue>=25 && bmiValue<30){
                 return "OVERWEIGHT";
             }else if(bmiValue>=30 && bmiValue<35){
                 return "MODERATELY OBESE";
             }else {
                 return "SEVERELY OBESE";
             }
     }

      public static boolean isIdealBodyWeight(Member member, Assessment assessment){
        double heightFeet= (member.getHeight()/0.3048);
        double extraInches =  (heightFeet-5)*12;
        float compareWeight = 0;
        if(member.getGender().equals("M")){
            if(heightFeet<5){
                if(assessment.getWeight()>(50.0-0.2) && assessment.getWeight()<(50.0+0.2) ){
                    return true;
                }
                else{
                    return false;
                }
            }
            else {
                compareWeight = (float)(50.0 + (2.3*extraInches));
                if(assessment.getWeight()>(compareWeight-0.2) && assessment.getWeight()<(compareWeight+0.2) ){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        else{
            if(heightFeet<5){
                if(assessment.getWeight()>(45.5-0.2) && assessment.getWeight()<(45.5+0.2) ){
                    return true;
                }
                else{
                    return false;
                }
            }
            else {
                compareWeight = (float)(45.5 + (2.3*extraInches));
                if(assessment.getWeight()>(compareWeight-0.2) && assessment.getWeight()<(compareWeight+0.2) ){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
      }

}
