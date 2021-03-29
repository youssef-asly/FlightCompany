package com.assignment;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicketLogger {
    private static final Logger LOGGER = Logger.getLogger(TicketLogger.class.getName());

    public TicketLogger() {
        Handler fileHandler  = null;
        try{
            //Creating consoleHandler and fileHandler
            fileHandler  = new FileHandler("./TicketLogger.log");
            //Assigning handlers to LOGGER object
            LOGGER.addHandler(fileHandler);
            //Setting levels to handlers and LOGGER
            fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);
            LOGGER.config("Configuration done.");
            LOGGER.log(Level.FINE, "Finer logged");
        }catch(IOException exception){
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", exception);
        }
    }
    public void LogToFile(Level level , String line){
        try {
            LOGGER.log(level, line);
        } catch (Exception exception){
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", exception);
        }
    }
}
