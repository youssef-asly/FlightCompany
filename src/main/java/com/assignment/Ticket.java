package com.assignment;

public class Ticket implements Comparable<Ticket> {
    //fields
    private Integer ticketID;
    private String baggage;
    private Integer destination;
    private Double price;
    //constructor
    public Ticket(Integer ticketID, String baggage, Integer destination, Double price) {
        this.ticketID = ticketID;
        this.baggage = baggage;
        this.destination = destination;
        this.price=price;
    }
    //copy constructor
    public Ticket(Ticket ticket) {
        this.ticketID = ticket.getTicketID();
        this.baggage = ticket.getBaggage();
        this.destination = ticket.getDestination();
        this.price=ticket.getPrice();
    }
    //getters
    public Integer getTicketID() { return ticketID; }
    public Integer getDestination() {
        return destination;
    }
    public String getBaggage() { return baggage; }
    public Double getPrice() {
        return price;
    }
    
    //setters
    public void setTicketID(Integer ticketID) {
        this.ticketID = ticketID;
    }
    public void setDestination(Integer destination) {
        this.destination = destination;
    }
    public void setBaggage(String baggage) {
        this.baggage = baggage;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    //override toString method
    public String toString(){
        return "Ticket ID is: "+getTicketID()+" ,baggage is: "+getBaggage()+" ,destination is: "+getDestination()+" ,price is: "+getPrice();
    }
    
    //overwritten and implemented compareTo method
    @Override
    public int compareTo(Ticket o) {
        if (o.getTicketID()== getTicketID() && o.getDestination()==getDestination()){
            return 0;
        }
        return 1;
    }
}
