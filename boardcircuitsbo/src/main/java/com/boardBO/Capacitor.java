package com.boardBO;

/**
 * Created by VMAC Personal on 01-12-2016.
 */

public class Capacitor {

    float valor;
    float tolerance;
    String reference;
    int[] malhaPertencente;// ou pertence a um, ou a outro ou a ambos
    static int potencia;
    static int corrente;
    static int voltagem;

    public Capacitor ()
    {

    }
    public Capacitor (float val, String refer)
    {
        valor = val;
        reference = refer;
    }


    public int[] getMeshArray ()
    {
        return malhaPertencente;

    }

    public void setMeshArray(int [] meshArray)
    {
        this.malhaPertencente = meshArray;
    }

    public float getValueCapacitor(){
        return valor;
    }

    public void setValueCapacitor(float val)
    {
        this.valor = val;
    }


    public float getToleranceValue()
    {
        return tolerance;
    }
    public void setToleranceValue(float tol)
    {
        this.tolerance=tol;
    }


    /**
     * Created by vitor on 01-12-2016.
     */

    public static class FonteCorrente {

        float valorCorrente; //valor de corrente que a fonte fornece
        String referencia;
        int[] malhaPertencente;// ou pertence a um, ou a outro ou a ambos

        public FonteCorrente()
        {

        }
        public FonteCorrente (float valorCorrente, String ref, int [] mesh)
        {
            this.valorCorrente = valorCorrente;
            this.referencia = ref;
            this.malhaPertencente = mesh;
        }

        public String getReference ()
        {
            return referencia;
        }
        public void setReference(String ref)
        {
            this.referencia = ref;
        }

        public int [] getMesh ()
        {
            return malhaPertencente;
        }
        public void setMesh (int [] meshOfComponent)
        {
            this.malhaPertencente = meshOfComponent;
        }
    }
}
