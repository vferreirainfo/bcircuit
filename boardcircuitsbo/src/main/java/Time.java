/**
 * Created by vitor on 12-12-2016.
 */

public class Time {

    // a class to set what is Time
    //Time has ms, s, min, hour, days, weeks, months, and year ... and even so

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




}
