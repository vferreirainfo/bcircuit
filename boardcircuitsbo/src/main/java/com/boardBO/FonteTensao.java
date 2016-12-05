package com.boardBO;

/**
 * Created by vitor on 01-12-2016.
 */

public class FonteTensao {

    float voltsValue;
    static float potenciaFonte;
    float toleranciaFonte;
    int[] malhaPertencente;// ou pertence a um, ou a outro ou a ambos
    String referencia;

    public FonteTensao()
    {
    }

    public FonteTensao(float valV)
    {
        voltsValue = valV;
    }

    public FonteTensao (float valV, String referenc)
    {
        voltsValue = valV;
        referencia = referenc;
    }


    public int [] getComponentIsFromMesh()
    {
       return malhaPertencente;
    }
    public void setComponentIsFromMesh(int [] meshFrom)
    {
        this.malhaPertencente = meshFrom; 
    }

    public String getReference()
    {
        return referencia;
    }
    public void setReference(String ref)
    {
        this.referencia = ref;
    }
    
    public float getFontVolts ()
    {
        return voltsValue;

    }
    public void setFontVolts (float volts)
    {
        voltsValue = volts;
    }


}
