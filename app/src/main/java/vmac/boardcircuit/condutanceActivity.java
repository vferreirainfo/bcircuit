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
import com.example.CircuitAnalyser;
import com.example.ElectricalMeansure;
import com.example.OhmAnalyser;

public class condutanceActivity extends AppCompatActivity {


    TextView finalResult;
    private final int SPLASH_DISPLAY_LENGTH = 5000;
    String condutance;
    String output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condutance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Determinar condutancia");

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
        Spinner meansures;
        String resistenceOptionSelect;
        float intactValueToOhm;

        final Resistor resistencia = new Resistor();
        EditText valueRInserted;


        valueRInserted = (EditText) findViewById(R.id.ohmInputCondutance);
        meansures = (Spinner)findViewById(R.id.ohmCondutanceType);

        //Obter valor de grandeza selecionado pelo utilizador
        resistenceOptionSelect = meansures.getSelectedItem().toString();

        //Definir que o identificador resistencia tem 'x' ohms
        resistencia.setResistenceValue(Float.valueOf(valueRInserted.getText().toString()));

        //Converter qualquer que seja o valor, para ohms
        intactValueToOhm = OhmAnalyser.ConvertToOhm(resistencia.getResistenceValue(), resistenceOptionSelect);

        //redefinir valor da resistencia
        resistencia.setResistenceValue(intactValueToOhm);


        //tudo o que aparece no formulario deve ser invisivel ... inclusive o botao
        //calcular
        findViewById(R.id.ohmInputCondutance).setVisibility(View.INVISIBLE);
        findViewById(R.id.ohmCondutanceType).setVisibility(View.INVISIBLE);
        findViewById(R.id.ohmResisitorCText).setVisibility(View.INVISIBLE);
        findViewById(R.id.buttonCondutanceCalc).setVisibility(View.INVISIBLE);


        new Handler().postDelayed(new Runnable(){


            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                finalResult = (TextView) findViewById(R.id.resultMessage);
                condutance=Float.toString(CircuitAnalyser.condutanceCalculator(resistencia));
                // determinar se temos por exemplo mv, v ou kv)

                output= ElectricalMeansure.ConvertMeansure(Double.valueOf(condutance),2);
                finalResult.setText("Resultado: "+output+"s");
                findViewById(R.id.img1).setVisibility(View.INVISIBLE);
                findViewById(R.id.resultMessage).setVisibility(View.VISIBLE);
            }
        }, SPLASH_DISPLAY_LENGTH);
        findViewById(R.id.img1).setVisibility(View.VISIBLE);



        //outputResult = (TextView) findViewById(R.id.resultMessage);
        //outputResult.setText("Valor da current: {0} v "+current, TextView.BufferType.NORMAL);
        // do nothing

    }

}
