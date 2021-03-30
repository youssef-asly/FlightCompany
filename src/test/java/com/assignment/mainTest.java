package com.assignment;
import org.junit.Assert;
import org.junit.Test;


public class mainTest {
    @Test
    public void validateTicket() {
        //a. Check if ticket is available
        TicketsList ticketsList = new TicketsList();
        ticketsList.FillDB();//Create hardcoded data that will act as your datasource

        Assert.assertEquals(true, ticketsList.validateTicket(120));
        Assert.assertEquals(true, ticketsList.validateTicket(120));
        Assert.assertEquals(false, ticketsList.validateTicket(10));
    }
    @Test
    public void validateBaggage() {
        TicketsList ticketsList = new TicketsList();
        ticketsList.FillDB();//Create hardcoded data that will act as your datasource

        Assert.assertEquals(false, ticketsList.validateBaggage(221,"HAIFA"));//should return false
        Assert.assertEquals(true, ticketsList.validateBaggage(225,"CHICAGO"));//should return true
        Assert.assertEquals(false,ticketsList.validateBaggage(230,null));//should return false
        Assert.assertEquals(true, ticketsList.validateBaggage(230,"BARCELONA"));//should return true
        Assert.assertEquals(false, ticketsList.validateBaggage(330,"BARCELONA"));//should return false
    }
    @Test
    public void validateCoupon() {
        TicketsList ticketsList = new TicketsList();
        ticketsList.FillDB();//Create hardcoded data that will act as your datasource
        CouponsList couponsList = new CouponsList();
        couponsList.FillDB();//Create hardcoded data that will act as your datasource
        Assert.assertNotEquals(100.0,couponsList.validateCoupon(320,100.0));
        Assert.assertEquals(221.0,couponsList.validateCoupon(340, 221.0),0.04);
    }
}