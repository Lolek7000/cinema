package com.cinema.exceptions;

public class IncorrectAmountOfTicket extends RuntimeException{
    public IncorrectAmountOfTicket(int ticketAmount) {
        super("Given amount of ticket (" + ") is incorrect");
    }
}
