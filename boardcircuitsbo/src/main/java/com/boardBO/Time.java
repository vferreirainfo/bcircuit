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
    int hours;
    int years;


    int secondsInterval [] = {0-60}; //
    int minutesInterval [] = {0-60};
    int hoursInterval [] = {0-24};



    public void Time(){

    }
    public void Time (int dias)
    {
        days=dias;
    }
    public void Time (int segundos, int minutos)
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

        if(days>=0)
        {
            return days;
        }
        else // nao faz sentido existir dias negativos
            return -1;

    }
    public void setDias(int day)
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

    public int getMonth()
    {
        return months;
    }
    public void setMonth(int month)
    {
        months=month;
    }

    public int getSecond() {

        if(seconds>=0 && seconds<=60)
            return seconds;
        else
            return -1;
    }

    public void setSecond(int second)
    {
        seconds=second;
    }

    public int getMinutes()
    {
        if(minutes>0&&minutes<=60)
            return minutes;
        else
            return -1; //nao existem minutos negativos
    }

    public void setMinutes(int min)
    {
      minutes=min;
    }


    public int getHours()
    {
        if(hours>0 && hours<=24) // 1 dia
           return hours;
        else
            return -1;
    }

    public void setHours(int hour)
    {
        hours=hour;
    }

}
