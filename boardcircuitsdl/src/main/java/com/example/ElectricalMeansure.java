package com.example;

/**
 * Created by vitor on 11-12-2016.
 */

public class ElectricalMeansure {


    private final static int PREFFIX_OFFSET=5;
    private final static String [] PREFIX_ARRAY={"f","p","n","µ","m", "", "k", "M","G","T"};

    //only to convert electrical meansures

    public ElectricalMeansure(){

    }
    public static String ConvertMeansure(double originalValue, int decimalP)
    {

        String value;
        if(originalValue==0) return String.format("%."+decimalP+"f",0.0);

        double posVal = (originalValue<0)? -originalValue:originalValue;
        double log10 = Math.log10(posVal);

        int count = (int) Math.floor(log10/3);
        int index = count + PREFFIX_OFFSET;

        originalValue /= Math.pow(10,count*3);

        if(index>=0 && index< PREFIX_ARRAY.length)
        {
            value=originalValue+" "+PREFIX_ARRAY[index];
            return value;
            //return String.format("e % d",originalValue,PREFIX_ARRAY[index]);

            //return Double.toString(originalValue);
        }
        else
        {
            //return Double.toString(originalValue);
            return Double.toString(originalValue);
        }
    }

}
