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

    public Capacitor() {

    }

    public Capacitor(float val, String refer) {
        valor = val;
        reference = refer;
    }


    public int[] getMeshArray() {
        return malhaPertencente;

    }

    public void setMeshArray(int[] meshArray) {
        this.malhaPertencente = meshArray;
    }

    public float getValueCapacitor() {
        return valor;
    }

    public void setValueCapacitor(float val) {
        this.valor = val;
    }


    public float getToleranceValue() {
        return tolerance;
    }

    public void setToleranceValue(float tol) {
        this.tolerance = tol;
    }


    /**
     * Created by vitor on 01-12-2016.
     */

}