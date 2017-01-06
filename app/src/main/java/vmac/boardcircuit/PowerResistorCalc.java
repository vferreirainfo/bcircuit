package vmac.boardcircuit;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.boardBO.Resistor;
import com.example.ElectricalMeansure;
import com.example.OhmAnalyser;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PowerResistorCalc extends AppCompatActivity {

    float finalResult;
    double resistorValue, currentValue;
    String resisitorOptionSelect, ampereOptionSelect; // ira ser guardada a grandeza da
    private final int SPLASH_DISPLAY_LENGTH = 5000; //tempo de duraçao do splashscreen "thuderstorm"
    Resistor newResistor;
    TextView outputResult;
    String powerS;
    String output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_resistor_calc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Determinar Potencia (Resistencia)");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });
    }
    public void startAnimations()
    {

        final float originalValueA, originalValueR;
         /// resistencia e da corrente
        EditText mEdit, mEditI;
        Spinner virtualSpinnerR, virtualSpinnerA;



        mEdit = (EditText) findViewById(R.id.resistorPowerInput);
        mEditI = (EditText) findViewById(R.id.currentPowerInput);


        resistorValue = Integer.valueOf(mEdit.getText().toString());
        currentValue = Integer.valueOf(mEditI.getText().toString());

        virtualSpinnerR = (Spinner) findViewById(R.id.resistorPowerType);
        virtualSpinnerA = (Spinner) findViewById(R.id.currentPowerType);

        resisitorOptionSelect = virtualSpinnerR.getSelectedItem().toString();
        ampereOptionSelect = virtualSpinnerA.getSelectedItem().toString();

        originalValueR = OhmAnalyser.ConvertToOhm((float)resistorValue, resisitorOptionSelect);
        originalValueA = OhmAnalyser.ConvertToAmpere((float)currentValue, ampereOptionSelect);

        newResistor = new Resistor();
        newResistor.setResistenceValue(originalValueR); // set the value in "ohm's"


        //tudo o que aparece no formulario deve ser invisivel ... inclusive o botao
        //calcular
        findViewById(R.id.resistorPowerInput).setVisibility(View.INVISIBLE);
        findViewById(R.id.resistorPowerText).setVisibility(View.INVISIBLE);
        findViewById(R.id.resistorPowerType).setVisibility(View.INVISIBLE);
        findViewById(R.id.currentPowerType).setVisibility(View.INVISIBLE);
        findViewById(R.id.currentPowerText).setVisibility(View.INVISIBLE);
        findViewById(R.id.currentPowerInput).setVisibility(View.INVISIBLE);
        findViewById(R.id.button).setVisibility(View.INVISIBLE);


        new Handler().postDelayed(new Runnable(){


            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                outputResult = (TextView) findViewById(R.id.resultMessage);
                powerS=Float.toString(OhmAnalyser.DeterminaPotenciaResistor(newResistor,originalValueA));
                // determinar se temos por exemplo mv, v ou kv)
                DecimalFormat df = new DecimalFormat("#######.00");
                df.setRoundingMode(RoundingMode.UP);
                output= ElectricalMeansure.ConvertMeansure(Double.valueOf(powerS),2);
                //outputResult.setText("Resultado: "+Math.ceil(Double.valueOf(output))+"V");
                outputResult.setText("Resultado: "+output+"V");
                findViewById(R.id.img1).setVisibility(View.INVISIBLE);
                findViewById(R.id.resultMessage).setVisibility(View.VISIBLE);
            }
        }, SPLASH_DISPLAY_LENGTH);
        findViewById(R.id.img1).setVisibility(View.VISIBLE);







    }

}
