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

    //meses em dias

    //anos em dias
}
