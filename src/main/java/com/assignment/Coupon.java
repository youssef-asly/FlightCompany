package com.assignment;

public class Coupon implements Comparable<Coupon>{
    //fields
    private Integer couponID;
    //constructor
    public Coupon(Integer couponID) {
        this.couponID = couponID;
    }
    //copy constructor
    public Coupon(Coupon coupon){
        try{
            this.couponID = coupon.getCouponID();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    //getter
    public Integer getCouponID() {
        return couponID;
    }
    //setter
    public void setCouponID(Integer couponID) {
        this.couponID = couponID;
    }
    //override to string method
    public String toString(){
        return "Coupon ID is: "+getCouponID();
    }
    //overwritten and implemented compareTo method
    public int compareTo(Coupon coupon) {
        if (coupon.getCouponID() == getCouponID()){
            return 0;
        }
        return 1;
    }
}
