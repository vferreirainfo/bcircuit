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

public class DC_Power extends AppCompatActivity {



    TextView outputResult;
    String textPower;
    String power;
    String output;
    private final int SPLASH_DISPLAY_LENGTH = 5000;
    float getValueVolts, convertToV;
    float getValueAmpere, convertToA;
    Resistor r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dc__power);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Potencia DC");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void calculateDCPower(View v)
    {

        //get values for voltage and for current
        //get values for meansures of voltage and current
        //for that we need 4 double variables and two edittext


        //also for that we'll need two spinners and two strings

        //Maybe we need to convert to A or V if kA, mA or kV mV

        EditText edtI = (EditText) findViewById(R.id.voltsInput);
        EditText edtII = (EditText) findViewById(R.id.currentInput);

        String meansureInV, meansureInA;
        Spinner spI= (Spinner) findViewById(R.id.dcVoltsType);
        Spinner spII = (Spinner) findViewById(R.id.dcCurrentType);

        meansureInV = spI.getSelectedItem().toString();
        meansureInA = spII.getSelectedItem().toString();







        getValueVolts = Float.valueOf(edtI.getText().toString());
        getValueAmpere = Float.valueOf(edtII.getText().toString());

        //Converter qualquer grand de voltagem para o valor correspondente em Volts
        convertToV = OhmAnalyser.ConvertToVolts(getValueVolts,meansureInV);

        //E o mesmo para a corrente
        convertToA = OhmAnalyser.ConvertToAmpere(getValueAmpere,meansureInA);

        //preçiamos de saber o valor da resistencia
        //r=u/i
        r = new Resistor();
        float valueResistor;


        valueResistor = convertToV / convertToA;
        r.setResistenceValue(valueResistor);




        //tudo o que aparece no formulario deve ser invisivel ... inclusive o botao
        //calcular
        findViewById(R.id.dcCurrentText).setVisibility(View.INVISIBLE);
        findViewById(R.id.dcVoltsText).setVisibility(View.INVISIBLE);
        findViewById(R.id.voltsInput).setVisibility(View.INVISIBLE);
        findViewById(R.id.dcVoltsType).setVisibility(View.INVISIBLE);
        findViewById(R.id.currentInput).setVisibility(View.INVISIBLE);
        findViewById(R.id.dcCurrentType).setVisibility(View.INVISIBLE);
        findViewById(R.id.button).setVisibility(View.INVISIBLE);

        //findViewById(R.id.waitMessage).setVisibility(View.VISIBLE);



        new Handler().postDelayed(new Runnable(){


            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                outputResult = (TextView) findViewById(R.id.resultMessage);
                power=Float.toString(OhmAnalyser.DeterminaPotenciaResistor(r,convertToA));
                // determinar se temos por exemplo mv, v ou kv)
                DecimalFormat df = new DecimalFormat("#######.00");
                df.setRoundingMode(RoundingMode.UP);
                output= ElectricalMeansure.ConvertMeansure(Double.valueOf(power),2);
                //outputResult.setText("Resultado: "+Math.ceil(Double.valueOf(output))+"V");
                outputResult.setText("Resultado da potencia: "+output+"w");
                findViewById(R.id.img1).setVisibility(View.INVISIBLE);
                findViewById(R.id.resultMessage).setVisibility(View.VISIBLE);
            }
        }, SPLASH_DISPLAY_LENGTH);
        findViewById(R.id.img1).setVisibility(View.VISIBLE);







    }

}
