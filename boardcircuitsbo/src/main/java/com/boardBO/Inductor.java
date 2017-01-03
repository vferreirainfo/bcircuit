package com.boardBO;

/**
 * Created by vitor on 02-01-2017.
 */

public class Inductor {

    float henryValue; //The L
    float lenght; //The l
    float area; // the A
    float permiability; //the miu
    float numberEnrolamments; //The N

    // L=N2 * miu * A /l

    public Inductor(float henryVal)
    {
        henryValue = henryVal;
    }
    public Inductor (float lenghtOfInductor, float areaInduct, float permiabilityInduct, float numberEnroll)
    {
        lenght = lenghtOfInductor;
        area = areaInduct;
        permiability = permiabilityInduct;
        numberEnrolamments = numberEnroll;
    }

    public void setHenryValue(float henryVal)
    {
        henryValue = henryVal;
    }
    public float getHenryValue()
    {
        return henryValue;
    }
    public void setLenghtValue(float lenghtInd)
    {
        lenght=lenghtInd;
    }
    public float getLenghtValue()
    {
        return lenght;
    }

    public void setAreaValue(float areaInduct) {
        area=areaInduct;
    }
    public float getAreaValue()
    {
        return area;
    }


}
