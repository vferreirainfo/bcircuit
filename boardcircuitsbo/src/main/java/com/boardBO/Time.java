package com.boardBO;

/**
 * Created by vitor on 12-12-2016.
 */

public class Time {

    // a class to set what is com.boardBO.Time
    //com.boardBO.Time has ms, s, min, hour, days, weeks, months, and year ... and even so

    float ms; // for example 0.50 ms is 1/2 of 1 second
    int seconds;
    int minutes;
    int days;
    int weeks;
    int months;
    int years;


    int secondsInterval [] = {0-60}; //
    int minutesInterval [] = {0-60};
    int hoursInterval [] = {0-24};



    public void Time(){

    }
    public void Time(int dias)
    {
        days=dias;
    }
    public void Time(int segundos, int minutos)
    {
        seconds=segundos;
        minutes = minutos;
    }
    public void Time (float msI, int segundo, int minutos)
    {
        seconds=segundo;
        minutes = minutos;
        ms=msI;

    }



    public int getDias()
    {
        return days;
    }
    public int setDias(int day)
    {
        days=day;
    }
    public int getWeek()
    {
        return weeks;
    }
    public void setWeek(int week)
    {
        weeks=week;
    }


}
