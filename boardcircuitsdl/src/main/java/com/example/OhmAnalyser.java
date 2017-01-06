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
    static double valueToOhm;
    static double valueToV;
    static double valueToA;
    static String grand;

    public OhmAnalyser() {

    }

    public OhmAnalyser(FonteTensao fonte) {
        t = fonte;
    }

    public OhmAnalyser(Resistor r) {
        res = r;
    }

    public static float DeterminaTensao(Resistor r, float corrente) {
        float tensao, rValue;
        rValue = r.getResistenceValue();
        tensao = rValue * corrente;
        return tensao;
    }

    public static float DeterminaResistencia(FonteTensao t, float corrente) {
        float tensao, result;
        tensao = t.getFontVolts();// devolve a quantidade de volts da tensao
        result = tensao / corrente;
        return result;
    }

    public static float DeterminaCorrente(FonteTensao t, Resistor r)
    {
        float corrente;
        corrente = t.getFontVolts()/r.getResistenceValue(); // I=U/R
        return corrente;
    }

    public static float DeterminaPotenciaResistor(Resistor r, float current)
    {
        double power;
        //p=r*i2
        power=r.getResistenceValue() * Math.pow(current,2);
        return (float) power;
    }

    //O metodo abaixo converte a medida inserida em unType, e seu valor para volts
    public static float ConvertToVolts(float value, String unType) {

        if (unType.equals("pV"))
            valueToV = (double) value * Math.pow(10, -12);
        else if (unType.equals("nV"))
            valueToV = (double) value * Math.pow(10, -9);
        else if (unType.equals("µV"))
            valueToV = (double) value * Math.pow(10, -6);
        else if (unType.equals("mV"))
            valueToV = (double) value * Math.pow(10, -3);
        else if(unType.equals("V"))
            valueToV = (double) value * Math.pow(10, 0);
        else if (unType.equals("kV"))
            valueToV = (double) value * Math.pow(10, 3);
        else if (unType.equals("MV"))
            valueToV = (double) value * Math.pow(10, 6);
        else if (unType.equals("TV"))
            valueToV = (double) value * Math.pow(10, 9);
        else if (unType.equals("TV"))
            valueToV = (double) value * Math.pow(10, 12);

        return (float) valueToV;

    }

    public static float ConvertToAmpere(float value, String unType) {


        if (unType.equals("pA"))
            valueToA = (double) value * Math.pow(10, -12);
        else if (unType.equals("nA"))
            valueToA = (double) value * Math.pow(10, -9);
        else if (unType.equals("µA"))
            valueToA = (double) value * Math.pow(10, -6);
        else if (unType.equals("mA"))
            valueToA = (double) value * Math.pow(10, -3);
        else if(unType.equals("A"))
            valueToA = (double) value * Math.pow(10, 0);
        else if (unType.equals("kA"))
            valueToA = (double) value * Math.pow(10, 3);
        else if (unType.equals("MA"))
            valueToA = (double) value * Math.pow(10, 6);
        else if (unType.equals("GA"))
            valueToA = (double) value * Math.pow(10, 9);
        else if (unType.equals("TA"))
            valueToA = (double) value * Math.pow(10, 12);

        return (float) valueToA;

    }

    public static float ConvertToOhm(float value, String unType) {


        if (unType.equals("pΩ"))
            valueToOhm = (double) value * Math.pow(10, -12);
        else if (unType.equals("nΩ"))
            valueToOhm = (double) value * Math.pow(10, -9);
        else if (unType.equals("µΩ"))
            valueToOhm = (double) value * Math.pow(10, -6);
        else if (unType.equals("mΩ"))
            valueToOhm = (double) value * Math.pow(10, -3);
        else if (unType.equals("kΩ"))
            valueToOhm = (double) value * Math.pow(10, 3);
        else if(unType.equals("Ω"))
            valueToOhm = (double) value * Math.pow(10, 0);
        else if (unType.equals("MΩ"))
            valueToOhm = (double) value * Math.pow(10, 6);
        else if (unType.equals("GΩ"))
            valueToOhm = (double) value * Math.pow(10, 9);
        else if (unType.equals("TΩ"))
            valueToOhm = (double) value * Math.pow(10, 12);

        return (float) valueToOhm;

    }


    public static String ConvertToOriginalVolt(float result) {

        int j = 0, k = 0, n = 13; //n = .000000000000
        int i = 0; //contadores
        //passar parameto para string ....
        String temp;
        temp = Float.toString(result);

        //obter tamanho da string ate ao ponto '.'
        while (i <= temp.length()) {
            if (temp.charAt(i) != '.') {
                i++;
            } else
                break;

        }
        //1000 ohm
        //10000 ohm

        while (j <= temp.length()) {
            if (temp.charAt(k) != 0) // o primeiro digito e difrente de 0
            {
                //Qual o tamanho de digitos ate ao ponto, determinado no while anterior??
                if (i > 3 && i < 6) {
                    grand = "k";
                    break;
                }
            } else if (temp.charAt(k) == 0) // o primeiro digito nao e difrerente de 0
            {
                //i++;//avançar while
                //k++; //avançar k
                //novo while
                while (n >= temp.length()) {
                    if (n != '.') //&& temp.charAt(n) != 0)// n nao e ponto e o caracter em n != 0
                        n--;
                    else
                        break;
                }

            }
        }
        return grand;

    }
}
