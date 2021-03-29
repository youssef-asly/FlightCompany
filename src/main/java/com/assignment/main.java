package com.assignment;

import java.util.logging.Logger;
import java.io.IOException;
import java.util.logging.*;
public class main {
    public static void main(String[] args) {
        TicketLogger ticketLogger=new TicketLogger();
        TicketsList ticketsList = new TicketsList();
        CouponsList couponsList = new CouponsList();
        ticketLogger.LogToFile(Level.INFO,"created the TicketsList and CouponsList DBs");
        ticketsList.FillDB();//Create hardcoded data that will act as your datasource
        couponsList.FillDB();//Create hardcoded data that will act as your datasource
        ticketLogger.LogToFile(Level.INFO,"Filled the TicketsList and CouponsList DBs");
        ticketLogger.LogToFile(Level.INFO, String.valueOf(ticketsList.validateTicket(120)));//this should print true
        ticketLogger.LogToFile(Level.INFO, String.valueOf(ticketsList.validateTicket(120)));//this should print true,this time from cache
        ticketLogger.LogToFile(Level.INFO, String.valueOf(ticketsList.validateTicket(1)));//this should print false
        ticketLogger.LogToFile(Level.INFO,ticketsList.viewDB());
        ticketLogger.LogToFile(Level.INFO, String.valueOf(ticketsList.validateBaggage(221,"HAIFA")));//should return false
        ticketLogger.LogToFile(Level.INFO, String.valueOf(ticketsList.validateBaggage(225,"CHICAGO")));//should return true
        ticketLogger.LogToFile(Level.INFO, String.valueOf(ticketsList.validateBaggage(230,null)));//should return false
        ticketLogger.LogToFile(Level.INFO, String.valueOf(ticketsList.validateBaggage(230,"BARCELONA")));//should return true
        ticketLogger.LogToFile(Level.INFO, String.valueOf(ticketsList.validateBaggage(330,"BARCELONA")));//should return true
        ticketLogger.LogToFile(Level.INFO,ticketsList.viewDB());
        Ticket ticket = ticketsList.getTicket(132);
        ticketLogger.LogToFile(Level.INFO,couponsList.viewCoupons());
        if (ticket.equals(null)){
            ticketLogger.LogToFile(Level.INFO,"the ticket does not exist");
        }else {
            ticketLogger.LogToFile(Level.INFO, "the content of the ticket is " + ticket.toString());
        }
        ticket = ticketsList.getTicket(132);
        if (ticket.equals(null)){
            ticketLogger.LogToFile(Level.INFO,"the ticket does not exist");
        }else {
            ticket.setPrice( couponsList.validateCoupon(322, ticket.getPrice()));
            ticketLogger.LogToFile(Level.INFO, "the content of the ticket is " + ticket.toString());
            ticket.setPrice( couponsList.validateCoupon(422, ticket.getPrice()));
            ticketLogger.LogToFile(Level.INFO, "the content of the ticket is " + ticket.toString());
        }
        Ticket t= ticket; //ticket copy constructor
        ticketLogger.LogToFile(Level.INFO, "the content of the ticket is " + ticket.toString());
        int identical=ticket.compareTo(t);
        ticketLogger.LogToFile(Level.INFO, "check if tickets are identical " + identical);
        Coupon c = couponsList.getCoupon(322);
        Coupon c1 = c;//coupon copy constructor
        identical=c.compareTo(c1);
        ticketLogger.LogToFile(Level.INFO, "check if coupons are identical " + identical);
        TicketsList ticketsList1  = ticketsList;//ticketsList copy constructor
        identical=ticketsList.compareTo(ticketsList1);
        ticketLogger.LogToFile(Level.INFO, "check if ticketsList are identical " + identical);
        CouponsList couponsList1  = couponsList;//couponsList copy constructor
        identical=couponsList.compareTo(couponsList1);
        ticketLogger.LogToFile(Level.INFO, "check if couponsList are identical " + identical);
    }
}