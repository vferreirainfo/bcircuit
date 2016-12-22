package vmac.boardcircuit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CTotalSerie extends AppCompatActivity {


    int numCapacSerie;

    int MAXIMUM_COMPONENTS = 30;
    boolean methodCalc;
    EditText [] textInputs = new EditText[MAXIMUM_COMPONENTS];
    TextView [] textView = new TextView[MAXIMUM_COMPONENTS];
    Spinner[] capacMeansure = new Spinner[MAXIMUM_COMPONENTS];


    //Variables for startAnimationMethod
    int LENGTH=1500;
    //EditText [] capacInputs = new EditText[MAXIMUM_COMPONENTS];
    //Spinner [] meansureInputs = new Spinner[MAXIMUM_COMPONENTS];
    String [] condValues = new String[MAXIMUM_COMPONENTS];
    String [] meansureValues = new String [MAXIMUM_COMPONENTS];



    //int variables to apply in for cycles
    int i,j,k, returnMethod=0;
    String [] getValueOfMeansure, getValueOfCapacitor = new String [MAXIMUM_COMPONENTS];
    public int getNumCapacSerie()
    {
        return numCapacSerie;
    }
    public void setNumCapacSerie(int numeroCondensadores)
    {
        numCapacSerie = numeroCondensadores;
    }


    public int CalculateCapacSerial(Intent serieIntent)
    {
        try {
            startActivity(serieIntent);

            if (getNumCapacSerie() <= MAXIMUM_COMPONENTS) {

                // i<-0; i<-10; increment
                for (i = 0; i < textInputs.length; i++) {
                    while (i < getNumCapacSerie()) {
                        //set visible each one
                        if(i==0) {
                            textInputs[i] = (EditText) findViewById(R.id.c1Input);
                            textInputs[i].setVisibility(View.VISIBLE);
                            //get the current value of text
                            getValueOfCapacitor[i] = textInputs[i].getText().toString();
                        }
                        if(i==1)
                        {
                            textInputs[i] = (EditText) findViewById(R.id.c2Input);
                            textInputs[i].setVisibility(View.VISIBLE);
                            //get the current value of text
                            getValueOfCapacitor[i] = textInputs[i].getText().toString();
                        }
                        if(i==2)
                        {
                            textInputs[i] = (EditText) findViewById(R.id.c3Input);
                            textInputs[i].setVisibility(View.VISIBLE);
                            //get the current value of text
                            getValueOfCapacitor[i] = textInputs[i].getText().toString();
                        }
                        if(i==3)
                        {
                            textInputs[i] = (EditText) findViewById(R.id.c4Input);
                            textInputs[i].setVisibility(View.VISIBLE);
                            //get the current value of text
                            getValueOfCapacitor[i] = textInputs[i].getText().toString();
                        }
                        if (i==4)
                        {
                            textInputs[i] = (EditText) findViewById(R.id.c5Input);
                            textInputs[i].setVisibility(View.VISIBLE);
                            //get the current value of text
                            getValueOfCapacitor[i] = textInputs[i].getText().toString();
                        }

                    }



                }
                for (j = 1; j <= textView.length-1; j++) {
                    while (j <= getNumCapacSerie()) {
                        //set visible each one
                        textView[j].setVisibility(View.VISIBLE);
                    }

                }
                for (k=1; k<=capacMeansure.length-1; k++)
                {
                    while(k<=getNumCapacSerie())
                    {
                        //set visible each one
                        capacMeansure[k].setVisibility(View.VISIBLE);

                        //get selected item
                        getValueOfMeansure[k-1]= capacMeansure[k].getSelectedItem().toString();
                    }
                }

            }
            returnMethod += 1;
        }
        catch (NullPointerException ex)
        {
            returnMethod=0;
        }

        return returnMethod;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctotal_serie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void startAnimations(View v)
    {
        //obter array de valores (de cada condensador) e de meansures
        int fCount=0, sCount=0;

        for(fCount=0; fCount<condValues.length; fCount++)
        {

            for (int k=0; k<textInputs.length; k++)
            {
                condValues[fCount] = textInputs[k].getText().toString();
            }

        }
        for(sCount=0; sCount<meansureValues.length; sCount++)
        {
            for(int j=0; j<capacMeansure.length; j++)
            {
                meansureValues[sCount] = capacMeansure[j].getSelectedItem().toString();
            }
        }



    }

}
