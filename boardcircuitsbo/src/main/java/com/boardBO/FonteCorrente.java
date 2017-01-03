package com.boardBO;

/**
 * Created by vitor on 02-01-2017.
 */

public class FonteCorrente {

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
