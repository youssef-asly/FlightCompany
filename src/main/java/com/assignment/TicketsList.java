package com.assignment;

import java.util.ArrayList;

public class TicketsList implements Comparable<TicketsList>{
    //fields
    private ArrayList<Ticket> databaseOfTickets;
    private ArrayList<Integer> cachedTicketIDs;
    private Integer MaxCacheSize;
    //constructor
    public TicketsList() {
        this.databaseOfTickets=new ArrayList<>();
        this.cachedTicketIDs = new ArrayList<>();
        this.MaxCacheSize=10;
    }
    //copy constructor
    public TicketsList(TicketsList ticketsList) {
        try{
            if (!ticketsList.getDatabaseOfTickets().isEmpty()) {
                this.databaseOfTickets = new ArrayList<>();
                for (Ticket T : ticketsList.getDatabaseOfTickets()) {
                    this.databaseOfTickets.add(new Ticket(T));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            if (!cachedTicketIDs.isEmpty()) {
                this.cachedTicketIDs = new ArrayList<>();
                for (Integer I : cachedTicketIDs) {
                    this.cachedTicketIDs.add(I);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.MaxCacheSize=ticketsList.getMaxCacheSize();
    }
    //getters
    public ArrayList<Ticket> getDatabaseOfTickets() { return databaseOfTickets; }
    public ArrayList<Integer> getCachedTicketIDs() {
        return cachedTicketIDs;
    }
    public Integer getMaxCacheSize() {
        return MaxCacheSize;
    }
    //getter that returns the ticket object by its ID
    public Ticket getTicket(Integer TicketID){
        for (Ticket T : getDatabaseOfTickets()) {
            if (T.getTicketID().equals(TicketID)) {
                return getDatabaseOfTickets().get(getDatabaseOfTickets().indexOf(T));
            }
        }
        return null;
    }
    //setters
    public void setDatabaseOfTickets(ArrayList<Ticket> databaseOfTickets) { this.databaseOfTickets = databaseOfTickets; }
    public void setCachedTicketIDs(ArrayList<Integer> cachedTicketIDs) {
        this.cachedTicketIDs = cachedTicketIDs;
    }
    public void setMaxCacheSize(Integer maxCacheSize) {
        MaxCacheSize = maxCacheSize;
    }

    //internal method to search if ticket is available in cache prior searching in DB as an optimization
    private boolean isCached(Integer TicketID){
        return cachedTicketIDs.contains(TicketID);
    }
    //internal method to search if ticket is available in cache prior searching in DB as an optimization
    //d. local in-memory cache mechanism, saving latest searched 100 ticketID
    //new search is added as the first element and the most important, if list already had MaxCacheSize ticketID, latest element is deleted
    //existing search will be moved to the first element
    private void updateCacheList(Integer TicketID) {
        if (cachedTicketIDs.contains(TicketID)){
            cachedTicketIDs.remove(TicketID);
        }else if (cachedTicketIDs.size() == MaxCacheSize){
            cachedTicketIDs.remove(cachedTicketIDs.size()-1);
        }
        cachedTicketIDs.add(0,TicketID);
    }

    //Create hardcoded data that will act as your datasource (no need to run external/internal databases).
    public void FillDB(){
        this.databaseOfTickets.add(new Ticket(120,"HONG KONG",220,220.0));
        this.databaseOfTickets.add(new Ticket(121,"KUALA LAMPUR",221,221.0));
        this.databaseOfTickets.add(new Ticket(122,"LOS ANGELES",222,222.0));
        this.databaseOfTickets.add(new Ticket(123,"LAS VEGAS",223,223.0));
        this.databaseOfTickets.add(new Ticket(124,"NEW YORK",224,224.0));
        this.databaseOfTickets.add(new Ticket(125,"CHICAGO",225,225.0));
        this.databaseOfTickets.add(new Ticket(126,"TEL AVIV",226,226.0));
        this.databaseOfTickets.add(new Ticket(127,"MADRID",227,227.0));
        this.databaseOfTickets.add(new Ticket(128,"LONDON",228,228.0));
        this.databaseOfTickets.add(new Ticket(129,"OHIO",229,229.0));
        this.databaseOfTickets.add(new Ticket(130,null,230,230.0));
        this.databaseOfTickets.add(new Ticket(131,null,231,231.0));
        this.databaseOfTickets.add(new Ticket(132,null,232,232.0));
        this.databaseOfTickets.add(new Ticket(133,null,233,233.0));
        this.databaseOfTickets.add(new Ticket(134,null,234,234.0));
        this.databaseOfTickets.add(new Ticket(135,null,235,235.0));
        updateCacheList(120);
        updateCacheList(121);
        updateCacheList(122);
        updateCacheList(123);
        updateCacheList(124);
        updateCacheList(125);
        updateCacheList(126);
        updateCacheList(127);
        updateCacheList(128);
        updateCacheList(129);
        updateCacheList(130);
        updateCacheList(131);
        updateCacheList(132);
        updateCacheList(133);
        updateCacheList(134);
        updateCacheList(135);
    }
    //a.Check if ticket is available, the first step to check in the cached list, if not available to search in DB, and update the cache with the current search
    public boolean validateTicket(Integer TicketID){
        if (isCached(TicketID)){
            System.out.println("the ticket ID " + TicketID + " is available, in this case the cache was helpful");
            updateCacheList(TicketID);
            return true;
        }else {
            for (Ticket T : getDatabaseOfTickets()) {
                if (T.getTicketID().equals(TicketID)) {
                    System.out.println("the ticket ID " + TicketID + " is available, the information was not in the cached list");
                    updateCacheList(TicketID);
                    return true;
                }
            }
            System.out.println("the ticket ID " + TicketID + " is not available");
            return false;
        }
    }
    //b. Provide baggage check in service,update ticket with baggage id, or add if it has not before
    public boolean validateBaggage(Integer  DestinationID,String BaggageID){
        if (BaggageID == null){
            System.out.println("there is no baggage to check in to the destination "+DestinationID);
            return false;
        }
        for (Ticket T : getDatabaseOfTickets()) {
            if (BaggageID.equals(T.getBaggage()) && (!T.getDestination().equals(DestinationID))){
                System.out.println("the check in did not succeed, the destination "+DestinationID+" does not match baggage ID "+ BaggageID);
                return false;
            }else if (BaggageID.equals(T.getBaggage()) && T.getDestination().equals(DestinationID)) {
                System.out.println("the check in succeeded baggage "+BaggageID+" will be sent to "+DestinationID);
                updateCacheList(T.getTicketID());
                return true;
            }
        }//this was added to update ticket with the baggage if it has not baggage before
         // the is a limitation that only the first occurance of that destination the did not have any baggage before will be updated
        for (Ticket T : getDatabaseOfTickets()) {
            if (T.getDestination().equals(DestinationID) && (T.getBaggage() == null)){
                System.out.println("the check in succeeded baggage "+BaggageID+" will be sent to "+DestinationID+" that does not have any baggage before");
                updateCacheList(T.getTicketID());
                T.setBaggage(BaggageID);
                getDatabaseOfTickets().set(getDatabaseOfTickets().indexOf(T),T);
                return true;
            }
        }
        System.out.println("the check in did not succeed, there is no ticket with the provided destination "+DestinationID+" or/and baggage id "+BaggageID);
        return false;
    }
    public String toString(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("the current database of Tickets is the below:\n");
        for (Ticket T : getDatabaseOfTickets()) {
            stringBuilder.append(T.toString()).append("\n");
        }
        return String.valueOf(stringBuilder);
    }
    public String viewDB(){
        return getDatabaseOfTickets().toString();
    }
    @Override
    public int compareTo(TicketsList ticketsList) {
        if (getDatabaseOfTickets().size() != ticketsList.getDatabaseOfTickets().size()){
            return 1;
        }
        for (int i=0;i<getDatabaseOfTickets().size();i++)
        {
            if (getDatabaseOfTickets().get(i).compareTo(ticketsList.getDatabaseOfTickets().get(i)) == 1){
                return 1;
            }
        }
        return 0;
    }
}

