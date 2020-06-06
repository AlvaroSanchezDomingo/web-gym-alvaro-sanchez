package controllers;
import models.Member;

import play.Logger;
import play.mvc.Controller;
import java.util.ArrayList;
import java.util.List;

public class Settings extends Controller {
    public static void index() {
        Logger.info("Rendering settings");
        Member member = Accounts.getLoggedInMember();
        render("settings.html", member);
    }
    public static void name(String name) {
        Member member = Accounts.getLoggedInMember();
        member.setName(name);
        member.save();
        Logger.info ("Updating name in member to "+ member.getName());
        redirect("/settings");
    }
    public static void gender(String gender) {
        Member member = Accounts.getLoggedInMember();
        member.setGender(gender);
        member.save();
        Logger.info ("Updating name in member to "+ member.getGender());
        redirect("/settings");
    }
    public static void address(String address) {
        Member member = Accounts.getLoggedInMember();
        member.setAddress(address);
        member.save();
        Logger.info ("Updating name in address to "+ member.getAddress());
        redirect("/settings");
    }
}