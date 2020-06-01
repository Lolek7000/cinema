package com.cinema.model;

// Robocza klasa

import java.util.List;

public class Calc {

    public static final double NORMAL_TICKET_PRICE = 20.00;
    public static final double HALF_TICKET_PRICE = 10.00;
    public static final double BIG_FAMILY_TICKET_PRICE = 10.00;
    public static final double GROUP_TICKET_PRICE = 15.00;

    public static double calcPrice(List<TicketAmount> ticketAmountList, SeanceType seanceType){
        double price = 0;
        for(int i=0;i<ticketAmountList.size();i++){
            double k=calcTypePrice(ticketAmountList.get(i).getTicketType());
            price+= k * ticketAmountList.get(i).getTicketAmount();
        }
        if(seanceType == SeanceType._3D) price*=1.5;

        return price;
    }
    private static double calcTypePrice(TicketType ticketType){
        if(ticketType==TicketType.FULL)return NORMAL_TICKET_PRICE;
        else if(ticketType==TicketType.HALF_PRICE)return HALF_TICKET_PRICE;
        else if(ticketType==TicketType.BIG_FAMILY)return BIG_FAMILY_TICKET_PRICE;
        else return GROUP_TICKET_PRICE;
    }
}
