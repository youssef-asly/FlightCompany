package com.assignment;

import java.util.ArrayList;

public class CouponsList implements Comparable<CouponsList> {
    //field
    private ArrayList<Coupon> databaseOfCoupons;
    //constructor
    public CouponsList() {
        this.databaseOfCoupons = new ArrayList<>();
    }
    //copy constructor
    public CouponsList(CouponsList couponsList) {
        try{
            if (!couponsList.getDatabaseOfCoupons().isEmpty()) {
                this.databaseOfCoupons = new ArrayList<>();
                for (Coupon C : couponsList.databaseOfCoupons) {
                    this.databaseOfCoupons.add(new Coupon(C));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //getter
    public ArrayList<Coupon> getDatabaseOfCoupons() {
        return databaseOfCoupons;
    }
    public Coupon getCoupon(Integer couponID){
        for (Coupon coupon : getDatabaseOfCoupons()) {
            if (coupon.getCouponID().equals(couponID)) {
                return getDatabaseOfCoupons().get(getDatabaseOfCoupons().indexOf(coupon));
            }
        }
        return null;
    }
    //setter
    public void databaseOfCoupons(ArrayList<Coupon> databaseOfCoupons) {
        this.databaseOfCoupons = databaseOfCoupons;
    }
    //Create hardcoded data that will act as your datasource (no need to run external/internal databases).
    public void FillDB(){
        databaseOfCoupons.add(new Coupon(320));
        databaseOfCoupons.add(new Coupon(321));
        databaseOfCoupons.add(new Coupon(322));
        databaseOfCoupons.add(new Coupon(323));
        databaseOfCoupons.add(new Coupon(324));
        databaseOfCoupons.add(new Coupon(325));
        databaseOfCoupons.add(new Coupon(326));
        databaseOfCoupons.add(new Coupon(327));
        databaseOfCoupons.add(new Coupon(328));
        databaseOfCoupons.add(new Coupon(329));
        databaseOfCoupons.add(new Coupon(330));
    }
    //the below method needs a coupon ID and a price of tickets
    // if the coupon is valid the returned value is the new price after the discount
    //else it will return the initial price it got
    public Double validateCoupon(Integer couponID,Double Price){
        for (Coupon C : getDatabaseOfCoupons() ) {
            if (C.getCouponID().equals(couponID)) {
                System.out.println("the coupon "+couponID+" is valid");
                Integer r= ((int) (Math.random()*100));
                System.out.println("the new price is "+r+"% of the original price");
                return Price*r/100;
            }
        }
        System.out.println("the coupon "+couponID+" is not valid");
        return Price;
    }
    //prints the DB of coupons
    public String viewCoupons(){
        return getDatabaseOfCoupons().toString();
    }
    public String toString(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("the current database of Coupons is the below:\n");
        for (Coupon C : getDatabaseOfCoupons()) {
            stringBuilder.append(C.toString()).append("\n");
        }
        return String.valueOf(stringBuilder);
    }

    @Override
    public int compareTo(CouponsList couponsList) {
        if (getDatabaseOfCoupons().size() != couponsList.getDatabaseOfCoupons().size()){
            return 1;
        }
        for (int i=0;i<getDatabaseOfCoupons().size();i++)
        {
            if (getDatabaseOfCoupons().get(i).compareTo(couponsList.getDatabaseOfCoupons().get(i)) == 1){
                return 1;
            }
        }
        return 0;
    }
}
