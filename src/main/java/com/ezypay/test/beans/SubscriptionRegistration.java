package com.ezypay.test.beans;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDate;

public class SubscriptionRegistration {
    private List<Subscription> subscriptionRecords;
    List<String> strDays = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday", "Sunday" );
    private static SubscriptionRegistration subReg = null;

    public SubscriptionRegistration(){
        subscriptionRecords = new ArrayList<Subscription>();
    }

    public static SubscriptionRegistration  getInstance() {

        if(subReg == null) {
            subReg = new SubscriptionRegistration();
            return subReg;
        }
        else {
            return subReg;
        }
    }

    public void add(Subscription std) {
        if (std.getType()=="DAILY"){
            subscriptionRecords.add(std);
        }
        if(std.getType()=="WEEKLY"){
            int day = 0;
            if(!strDays.contains(std.getDays())) {
                subscriptionRecords.add(std);
            } else {
                System.out.print("Error! Invalid day: ");
            }
        }
        if (std.getType()=="MONTHLY"){
            if(!isInteger(std.getDays(),10)) {
                System.out.print("Error! Invalid date: ");
            } else {
                subscriptionRecords.add(std);
            }
        }
        //Parsing the date
        LocalDate startDate = LocalDate.parse(std.getStartDate());
        LocalDate endDate = LocalDate.parse(std.getEndDate());
        Period subscriptionPeriod = Period.between(startDate, endDate);
        int months = subscriptionPeriod.getMonths();
        if(months>3){
            System.out.print("Error! Subscription's maximum duration can be of 3 months");
        }

    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }
    public List<Subscription> getSubscriptionRecords() {
        return subscriptionRecords;
    }
}
