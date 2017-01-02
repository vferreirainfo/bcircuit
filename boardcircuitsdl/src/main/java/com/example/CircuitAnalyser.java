package com.example;

import com.boardBO.FonteTensao;
import com.boardBO.Resistor;

import java.sql.Time;

/**
 * Created by vitor on 11-12-2016.
 */

public class CircuitAnalyser {


    //Esta classe sera responsavel por realizar tarefas em circuitos. Como:

    //Calcular correntes nas malhas
    //Calcular Ct (Capacitancia total de um circuito)
    //Calcular a tensao de determinado componente num circuito complexo
    //(...)


    double[] values;
    int count, countII;
    double totalCapacitance = 0, sumDenominator = 0; /* somar "all" denominador n em 1/n */
    double saveValueF;
    static double intValueF;
    static double intValueH;

    public float totalSerieCapacitanceCalculator(String[] v, String[] meansures) {
        //passar todos os valores de String [] v para [] values
        for (count = 0; count < values.length; count++) {
            for (countII = 0; countII < v.length; countII++) {
                values[count] = Double.valueOf(v[countII]);
            }
        }

        //Calcular ...
        //Formula: 1/ (1/C1+1/C2+1/C3+ ... 1/CN)
        //Converter tudo para Fahrads
        for (int j = 0; j < values.length; j++) {
            //A for cycle for meansures
            for (int k = 0; k < meansures.length; k++) {
                //converter valores para F
                saveValueF = this.convertToFahrad(values[j], meansures[k]);
                //Somar todos os valores
                //saveValueF ... converte tudo para FAHRAD
                sumDenominator = sumDenominator + (1 / saveValueF);
            }
        }

        //Resultado FINAL

        // Ct = 1/sumDenominator

        totalCapacitance = 1 / sumDenominator;
        return (float) totalCapacitance;

    }


    public float energyCalculator(float power, FonteTensao tensao, Time t)
    {
        int LENGTH=1500;
        float result=0;

        return result;
    }
    public static float condutanceCalculator(Resistor res)
    {
        float valueR, result;
        valueR = res.getResistenceValue();
        result = 1/valueR;
        return result;
    }
    public float condutanceCalc(Resistor r)
    {
        float valueR, result;
        valueR = r.getResistenceValue();
        result = 1/valueR;
        return result;
    }

    private static double convertToFahrad(double value, String meansure)
    {
        if (meansure.equals("pF"))
        {
            intValueF = (double) value * Math.pow(10, -12);
        }
        else if(meansure.equals("nF"))
        {
            intValueF = (double) value * Math.pow(10,-9);
        }
        else if(meansure.equals("µF"))
        {
            intValueF = (double) value * Math.pow(10,-6);
        }
        else if(meansure.equals("mF"))
        {
            intValueF = (double) value * Math.pow(10,-3);
        }
        else if(meansure.equals("F"))
        {
            intValueF = (double) value * Math.pow(10,0);
        }
        else if(meansure.equals("kF"))
        {
            intValueF = (double) value*Math.pow(10,3);
        }
        else if(meansure.equals("MF"))
        {
            intValueF = (double) value*Math.pow(10,6);
        }
        else if(meansure.equals("GF"))
        {
            intValueF = (double) value*Math.pow(10,9);
        }
        else if(meansure.equals("TF"))
        {
            intValueF = (double) value*Math.pow(10,12);
        }

        return intValueF;
    }

    public static double ConvertToHenry (double value, String meansure)
    {
        if(meansure.equals("pH"))
        {
            intValueH = (double) value*Math.pow(10,-12);
        }
        else if (meansure.equals("nH"))
        {
            intValueH = (double) value*Math.pow(10,-9);
        }
        else if(meansure.equals("µH"))
        {
            intValueH = (double) value*Math.pow(10,-6);
        }
        else if(meansure.equals("mH"))
        {
            intValueH = (double) value*Math.pow(10,-3);
        }
        else if(meansure.equals("H"))
        {
            intValueH = (double) value*Math.pow(10,0);
        }
        else if(meansure.equals("kH"))
        {
            intValueH = (double) value*Math.pow(10,3);
        }
        else if(meansure.equals("MH"))
        {
            intValueH = (double) value*Math.pow(10,6);
        }
        else if (meansure.equals("GH"))
        {
            intValueH = (double) value*Math.pow(10,9);
        }
        else if (meansure.equals("TH"))
        {
            intValueH = (double) value*Math.pow(10,12);
        }
        return intValueH;
    }
}
