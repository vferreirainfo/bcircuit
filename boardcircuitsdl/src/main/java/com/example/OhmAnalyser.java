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
}
