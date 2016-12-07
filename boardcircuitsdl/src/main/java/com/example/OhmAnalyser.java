package com.example;

import com.boardBO.FonteTensao;
import com.boardBO.Resistor;

/**
 * Created by vitor on 02-12-2016.
 */

public class OhmAnalyser {

    // one resistence with 'x' ohm
    // one power source7

    static Resistor res;
    static FonteTensao t;


    public OhmAnalyser()
    {

    }

    public OhmAnalyser(FonteTensao fonte)
    {
        t=fonte;
    }
    public OhmAnalyser(Resistor r)
    {
        res=r;
    }

    public static float DeterminaTensao (Resistor r, float corrente)
    {
        float tensao, rValue;
        rValue = r.getResistenceValue();
        tensao=rValue*corrente;
        return tensao;
    }
    public static float DeterminaResistencia (FonteTensao t,float corrente)
    {
        float tensao, result;
        tensao=t.getFontVolts();// devolve a quantidade de volts da tensao
        result = tensao/corrente;
        return result;
    }

    //O metodo abaixo converte a medida inserida em unType, e seu valor para volts
    public static float ConvertToVolts(float value, String unType)
    {

        double valueToV=0;
        if(unType=="pV")
            valueToV = (double)value*Math.pow(10,-12);
        else if(unType=="nV")
            valueToV = (double)value*Math.pow(10,-9);
        else if(unType=="µV")
            valueToV = (double)value*Math.pow(10,-6);
        else if(unType=="mV")
            valueToV = (double)value*Math.pow(10,-3);
        else if(unType=="kV")
            valueToV = (double)value*Math.pow(10,3);
        else if(unType=="MV")
            valueToV = (double)value*Math.pow(10,6);
        else if(unType=="TV")
            valueToV = (double)value*Math.pow(10,9);
        else if(unType=="TV")
            valueToV = (double)value*Math.pow(10,12);

        return (float)valueToV;

    }

    public static float ConvertToAmpere(float value, String unType)
    {

        double valueToV=0;
        if(unType=="pA")
            valueToV = (double)value*Math.pow(10,-12);
        else if(unType=="nA")
            valueToV = (double)value*Math.pow(10,-9);
        else if(unType=="µA")
            valueToV = (double)value*Math.pow(10,-6);
        else if(unType=="mA")
            valueToV = (double)value*Math.pow(10,-3);
        else if(unType=="kA")
            valueToV = (double)value*Math.pow(10,3);
        else if(unType=="MA")
            valueToV = (double)value*Math.pow(10,6);
        else if(unType=="GA")
            valueToV = (double)value*Math.pow(10,9);
        else if(unType=="TA")
            valueToV = (double)value*Math.pow(10,12);

        return (float)valueToV;

    }

    public static float ConvertToOhm(float value, String unType)
    {

            double valueToOhm =0;
            if(unType=="pΩ")
                valueToOhm = (double)value*Math.pow(10,-12);
            else if(unType=="nΩ")
                valueToOhm = (double)value*Math.pow(10,-9);
            else if(unType=="µΩ")
                valueToOhm = (double)value*Math.pow(10,-6);
            else if(unType=="mΩ")
                valueToOhm = (double)value*Math.pow(10,-3);
            else if(unType=="kΩ")
                valueToOhm = (double)value*Math.pow(10,3);
            else if(unType=="MΩ")
                valueToOhm = (double)value*Math.pow(10,6);
            else if(unType=="GΩ")
                valueToOhm = (double)value*Math.pow(10,9);
            else if(unType=="TΩ")
                valueToOhm = (double)value*Math.pow(10,12);

            return (float) valueToOhm;

    }
}
