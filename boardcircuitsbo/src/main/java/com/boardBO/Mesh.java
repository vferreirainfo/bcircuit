package com.boardBO;

/**
 * Created by vitor on 02-01-2017.
 */

public class Mesh {


    // A class that defines mesh
    //What is a mesh

    Resistor [] resistencia; //A mesh may contain one or more resistors
    Capacitor [] cond; // A mesh may contain one or more capacitors
    FonteTensao [] fTensao; //it could include one or more by each mesh
    FonteCorrente [] fCorrente;
    Inductor [] induct; //It could include some inductors

    public Mesh (FonteTensao [] fonte, Resistor [] res)
    {
        fTensao=fonte;
        resistencia = res;
    }
    public Mesh (FonteCorrente [] fontC, Resistor [] res)
    {
        fCorrente = fontC;
        resistencia = res;

    }
    public Mesh(FonteCorrente [] fontC, Capacitor [] capac)
    {
        fCorrente = fontC;
        cond = capac;
    }
    public Mesh (FonteCorrente [] fontC, Resistor [] res, Capacitor [] capac)
    {
        fCorrente = fontC;
        cond = capac;
        resistencia = res;
    }
    public Mesh(FonteCorrente [] fontC, FonteTensao [] fontT, Resistor [] res)
    {
        fCorrente = fontC;
        fTensao=fontT;
        resistencia = res;
    }
    public void setFonteTensaoInMesh (FonteTensao [] tensao)
    {
        fTensao = tensao;
    }
    public FonteTensao [] getFonteTensaoInMesh ()
    {
        return fTensao;
    }

    public void setResistenciaInMesh (Resistor [] res)
    {
        resistencia = res;
    }
    public Resistor [] getResistencia()
    {
        return resistencia;
    }
    public void setCapacitorInMesh (Capacitor [] condensador)
    {
        cond=condensador;
    }
    public Capacitor [] getCapacitorInMesh()
    {
        return cond;
    }
    public void setFonteCorrenteInMesh (FonteCorrente [] fontC)
    {
        fCorrente = fontC;
    }
    public FonteCorrente [] getFonteCorrenteInMesh()
    {
        return fCorrente;
    }
}


