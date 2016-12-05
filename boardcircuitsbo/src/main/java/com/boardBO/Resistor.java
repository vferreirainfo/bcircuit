package com.boardBO;


enum TypeOfResistor
{
    CarbonComposition,
    CarbonFilm,
    Ceramic,
    Chip_Resistor_TFMF,
    Chip_resistor_TF,
}
public class Resistor {

    //Variables

    float valor;
    float tolerancia;
    String reference;
    int[] malhaPertencente;// ou pertence a um, ou a outro ou a ambos
    static int potencia;
    static int corrente;
    static int voltagem;
    //TypeResistor tipo;


    //Construtors


    public Resistor ()
    {

    }
    public Resistor (float val, float tol, String refer)
    {
        valor = val;
        tol = tolerancia;
        reference = refer;
    }




    //property ... get and set is a little diffrent from C# programming language
    public float getResistenceValue()
    {
        return valor;
    }
    public void setResistenceValue(float v)
    {
        this.valor=v;
    }
    public float getResistenceTolerance()
    {
        return tolerancia;
    }
    public void setResistenceTolerance (float tol)
    {
        this.tolerancia=tol;
    }

    public String getReference ()
    {
        return reference;
    }
    public void setReference (String reference)
    {
        this.reference=reference;
    }

    public int [] getMeshArray()
    {
        return malhaPertencente;
    }
    public void setMeshArray (int [] circuitMesh)
    {
        this.malhaPertencente = circuitMesh;
    }




    //Methods
    public static boolean checkResistorTolerance(float t)
    {
        if ((int)t == 0 || t == 0.1 || t == 0.2 || (int)t == 1 || (int)t == 2
                || (int)t == 5 || (int)t == 10)
            return true;//Tolerance typed in t should correspond to 1 of
            //// those values here tested with if struct

        else
            return false; //Otherwise value, it may return false
    }
}
