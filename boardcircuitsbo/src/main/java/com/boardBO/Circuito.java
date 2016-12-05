package com.boardBO;

/**
 * Created by vitor on 01-12-2016.
 */

public class Circuito {

    Resistor [] res;
    Capacitor [] cap;
    FonteTensao[] fontesT;
    //FonteCorrente[] fontesC;


    public Circuito(){ }
    public Circuito (Resistor [] r, Capacitor [] capac)
    {
        this.res=r;
        this.cap = capac;
    }



    public Resistor [] getResistorsArray()
    {
        return res;
    }
    public void setResistorsArray(Resistor [] r)
    {
        this.res=r;
    }

    public Capacitor [] getCapacitorsArray()
    {
        return cap;
    }
    public void setCapacitorsArray(Capacitor [] c)
    {
        this.cap=c;
    }

    public FonteTensao [] getVoltFont ()
    {
        return fontesT;
    }
    public void setVoltFont (FonteTensao [] ft)
    {
        this.fontesT = ft;
    }



}
