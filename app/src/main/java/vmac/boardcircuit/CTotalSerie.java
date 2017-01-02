package vmac.boardcircuit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

public class CTotalSerie extends AppCompatActivity {


    int numCapacSerie;

    int MAXIMUM_COMPONENTS = 30;
    boolean methodCalc;
    EditText[] textInputs = new EditText[MAXIMUM_COMPONENTS];
    TextView[] textView = new TextView[MAXIMUM_COMPONENTS];
    Spinner[] capacMeansure = new Spinner[MAXIMUM_COMPONENTS];


    //Variables for startAnimationMethod
    int LENGTH = 1500;
    //EditText [] capacInputs = new EditText[MAXIMUM_COMPONENTS];
    //Spinner [] meansureInputs = new Spinner[MAXIMUM_COMPONENTS];
    String[] condValues = new String[MAXIMUM_COMPONENTS];
    String[] meansureValues = new String[MAXIMUM_COMPONENTS];


    //int variables to apply in for cycles
    int i, j, k, returnMethod = 0;
    String[] getValueOfMeansure, getValueOfCapacitor = new String[MAXIMUM_COMPONENTS];


    public int getNumCapacSerie() {
        return numCapacSerie;
    }

    public void setNumCapacSerie(int numeroCondensadores) {
        numCapacSerie = numeroCondensadores;
    }


    /*
    public int CalculateCapacSerial() {

        Bundle bund = getIntent().getExtras();


        if (bund != null) {

            int getCapacitors;
            getCapacitors = bund.getInt("_serie");


            //Code that turn each component visible, and save the values and meansures
            // of each capacitor
            if (getCapacitors <= MAXIMUM_COMPONENTS) {

                // i<-0; i<-10; increment
                for (i = 0; i < textInputs.length; i++) {
                    if(i==9)
                        break;
                    while (i < getNumCapacSerie()) {
                        //set visible each one
                        if (i == 0) {
                            textInputs[i] = (EditText) findViewById(R.id.c1Input);
                            textInputs[i].setVisibility(View.VISIBLE);
                            //get the current value of text
                            getValueOfCapacitor[i] = textInputs[i].getText().toString();
                        }
                        if (i == 1) {
                            textInputs[i] = (EditText) findViewById(R.id.c2Input);
                            textInputs[i].setVisibility(View.VISIBLE);
                            //get the current value of text
                            getValueOfCapacitor[i] = textInputs[i].getText().toString();
                        }
                        if (i == 2) {
                            textInputs[i] = (EditText) findViewById(R.id.c3Input);
                            textInputs[i].setVisibility(View.VISIBLE);
                            //get the current value of text
                            getValueOfCapacitor[i] = textInputs[i].getText().toString();
                        }
                        if (i == 3) {
                            textInputs[i] = (EditText) findViewById(R.id.c4Input);
                            textInputs[i].setVisibility(View.VISIBLE);
                            //get the current value of text
                            getValueOfCapacitor[i] = textInputs[i].getText().toString();
                        }
                        if (i == 4) {
                            textInputs[i] = (EditText) findViewById(R.id.c5Input);
                            textInputs[i].setVisibility(View.VISIBLE);
                            //get the current value of text
                            getValueOfCapacitor[i] = textInputs[i].getText().toString();
                        }
                        if (i == 5) {
                            textInputs[i] = (EditText) findViewById(R.id.c6Input);
                            textInputs[i].setVisibility(View.VISIBLE);
                            //get the current value of text
                            getValueOfCapacitor[i] = textInputs[i].getText().toString();
                        }
                        if (i == 6) {
                            textInputs[i] = (EditText) findViewById(R.id.c7Input);
                            textInputs[i].setVisibility(View.VISIBLE);
                            //get the current value of text
                            getValueOfCapacitor[i] = textInputs[i].getText().toString();
                        }
                        if (i == 7) {
                            textInputs[i] = (EditText) findViewById(R.id.c8Input);
                            textInputs[i].setVisibility(View.VISIBLE);

                            getValueOfCapacitor[i] = textInputs[i].getText().toString();

                        }
                        if (i == 8) {
                            textInputs[i] = (EditText) findViewById(R.id.c9Input);
                            textInputs[i].setVisibility(View.VISIBLE);


                        }
                        if(i==9)
                            break;

                    }


                }
                for (j = 0; j <= textView.length; j++) {
                    if(j==9)
                        break;
                    while (j <= getNumCapacSerie()) {

                        if (j == 0) {
                            textView[j] = (TextView) findViewById(R.id.c1Text);
                            //set visible each one
                            textView[j].setVisibility(View.VISIBLE);
                        } else if (j == 1) {
                            textView[j] = (TextView) findViewById(R.id.c2Text);
                            //set visible each one
                            textView[j].setVisibility(View.VISIBLE);
                        } else if (j == 2) {
                            textView[j] = (TextView) findViewById(R.id.c3Text);
                            //set visible each one
                            textView[j].setVisibility(View.VISIBLE);
                        } else if (j == 3) {
                            textView[j] = (TextView) findViewById(R.id.c4Text);
                            //set visible each one
                            textView[j].setVisibility(View.VISIBLE);
                        } else if (j == 4) {
                            textView[j] = (TextView) findViewById(R.id.c5Text);
                            //set visible each one
                            textView[j].setVisibility(View.VISIBLE);
                        } else if (j == 5) {
                            textView[j] = (TextView) findViewById(R.id.c6Text);
                            //set visible each one
                            textView[j].setVisibility(View.VISIBLE);

                        } else if (j == 6) {
                            textView[j] = (TextView) findViewById(R.id.c7Text);
                            //set visible each one
                            textView[j].setVisibility(View.VISIBLE);

                        } else if (j == 7) {
                            textView[j] = (TextView) findViewById(R.id.c8Text);
                            //set visible each one
                            textView[j].setVisibility(View.VISIBLE);

                        } else if (j == 8) {
                            textView[j] = (TextView) findViewById(R.id.c9Text);
                            //set visible each one
                            textView[j].setVisibility(View.VISIBLE);

                        }
                        if(j==9)
                            break;
                    }

                }
                for (k = 0; k <= capacMeansure.length; k++) {
                    if(k==9)
                        break;
                    while (k <= getNumCapacSerie()) {
                        if (k == 0) {

                            capacMeansure[k] = (Spinner) findViewById(R.id.c1Type);
                            //set visible each one
                            capacMeansure[k].setVisibility(View.VISIBLE);
                            //get selected item
                            getValueOfMeansure[k] = capacMeansure[k].getSelectedItem().toString();
                        }
                        if (k == 1) {
                            capacMeansure[k] = (Spinner) findViewById(R.id.c2Type);
                            //set visible each one
                            capacMeansure[k].setVisibility(View.VISIBLE);
                            //get selected item
                            getValueOfMeansure[k] = capacMeansure[k].getSelectedItem().toString();
                        }
                        if (k == 2) {
                            capacMeansure[k] = (Spinner) findViewById(R.id.c3Type);
                            //set visible each one
                            capacMeansure[k].setVisibility(View.VISIBLE);
                            //get selected item
                            getValueOfMeansure[k] = capacMeansure[k].getSelectedItem().toString();
                        }
                        if (k == 3) {
                            capacMeansure[k] = (Spinner) findViewById(R.id.c4Type);
                            //set visible each one
                            capacMeansure[k].setVisibility(View.VISIBLE);
                            //get selected item
                            getValueOfMeansure[k] = capacMeansure[k].getSelectedItem().toString();
                        }
                        if (k == 4) {
                            capacMeansure[k] = (Spinner) findViewById(R.id.c5Type);
                            //set visible each one
                            capacMeansure[k].setVisibility(View.VISIBLE);
                            //get selected item
                            getValueOfMeansure[k] = capacMeansure[k].getSelectedItem().toString();
                        }
                        if (k == 5) {
                            capacMeansure[k] = (Spinner) findViewById(R.id.c6Type);
                            //set visible each one
                            capacMeansure[k].setVisibility(View.VISIBLE);
                            //get selected item
                            getValueOfMeansure[k] = capacMeansure[k].getSelectedItem().toString();
                        }
                        if (k == 6) {
                            capacMeansure[k] = (Spinner) findViewById(R.id.c7Type);
                            //set visible each one
                            capacMeansure[k].setVisibility(View.VISIBLE);
                            //get selected item
                            getValueOfMeansure[k] = capacMeansure[k].getSelectedItem().toString();
                        }
                        if (k == 7) {
                            capacMeansure[k] = (Spinner) findViewById(R.id.c8Type);
                            //set visible each one
                            capacMeansure[k].setVisibility(View.VISIBLE);
                            //get selected item
                            getValueOfMeansure[k] = capacMeansure[k].getSelectedItem().toString();
                        }
                        if (k == 8) {
                            capacMeansure[k] = (Spinner) findViewById(R.id.c9Type);
                            //set visible each one
                            capacMeansure[k].setVisibility(View.VISIBLE);
                            //get selected item
                            getValueOfMeansure[k] = capacMeansure[k].getSelectedItem().toString();
                        }
                        if(k==9)
                            break;
                    }
                }

                returnMethod += 1;


            }


        }
        return returnMethod;


    }

   */

    public void showFormulary() {
        //create 'n' TextViews

        RelativeLayout r = (RelativeLayout) findViewById(R.id.content_ctotal_serie);
        TableRow.LayoutParams lp = new TableRow.LayoutParams();
        Bundle bund = getIntent().getExtras();
        int margin=20;

        if (bund != null) {

            int getCapacitors;
            getCapacitors = bund.getInt("_serie");
            if (getCapacitors <= MAXIMUM_COMPONENTS) {

                //create 'n' table row

                for (int table = 0; table < getCapacitors-6; table++) {

                    TableRow tblRow = new TableRow(this);
                    //Add a layout margin top of 20dp
                    while(table<getCapacitors-5) //0 < 25
                    {

                        lp.setMargins(20,margin,50,10);
                        tblRow.setLayoutParams(lp);

                        TextView txt = new TextView(this);
                        txt.setText("Condensador " +table + 1);
                        txt.setId(table + 1);
                        tblRow.addView(txt);
                        EditText inputs = new EditText(this);
                        inputs.setId(table+1);
                        tblRow.addView(inputs);
                        Spinner meansure = new Spinner(this);
                        meansure.setId(table+1);
                        tblRow.addView(meansure);
                        r.addView(tblRow);
                        margin+=20;

                    }





                    /*
                    //inside create 'n' TextViews
                    for (int i = 0; i < getCapacitors; i++) {
                        TextView txt = new TextView(this);
                        txt.setText("Condensador " + i + 1);
                        txt.setId(i + 1);
                        tblRow.addView(txt);
                    }
                    //inside create 'n'
                    for (int j=0; j < getCapacitors; j++)
                    {
                        EditText inputs = new EditText(this);
                        inputs.setId(j+1);
                        tblRow.addView(inputs);
                    }
                    for (int k=0; k<getCapacitors; k++)
                    {
                        Spinner meansure = new Spinner(this);
                        meansure.setId(k+1);
                        tblRow.addView();
                    }
                    */
                }

            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctotal_serie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        showFormulary();
        //CalculateCapacSerial();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void startAnimations(View v) {
        //obter array de valores (de cada condensador) e de meansures
        int fCount = 0, sCount = 0;

        for (fCount = 0; fCount < condValues.length; fCount++) {

            for (int k = 0; k < textInputs.length; k++) {
                condValues[fCount] = textInputs[k].getText().toString();
            }

        }
        for (sCount = 0; sCount < meansureValues.length; sCount++) {
            for (int j = 0; j < capacMeansure.length; j++) {
                meansureValues[sCount] = capacMeansure[j].getSelectedItem().toString();
            }
        }


    }
}

