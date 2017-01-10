package com.example;

import com.boardBO.Time;

/**
 * Created by vitor on 05-01-2017.
 */

public class TimeConvert {

    Time tempo;

    int horas;
    int minutes;
    int seconds;
    int days;
    int month;




    public int convertTimeDaysToHours(int numberDays)
    {
        for (int i=0; i<numberDays; i++)
        {
            horas+=24;
        }

        return horas;
    }
    public int convertTimeHoursToSeconds(int hours)
    {
        for (int i=0; i<hours; i++)
        {
            minutes+=60;
        }
        return minutes;
    }

    //minutos em segundos
    public int convertTimeMinutesToSeconds(int minutos)
    {
        //each minute is 60 seconds
        int temp=0;
        for (int i=0; i<minutos; i++)
        {
            temp+=60;
        }
        minutes = temp;
        return minutes;
    }
    //meses em dias
    public int convertMonthsInDays(int numberOfMounths)
    {
        for(int i=0; i<numberOfMounths; i++)
        {
            days+=30;
        }
        return days;
    }
    //anos em dias
}
