package vmac.boardcircuit;

import android.content.Intent;
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

import com.boardBO.FonteTensao;
import com.example.ElectricalMeansure;
import com.example.OhmAnalyser;

public class EnergyCalc extends AppCompatActivity {


    float valueT, valueW;
    float originalValueT, originalValueW; // Estas duas variaveis irao guardar a conversao se         String current;
    FonteTensao font = new FonteTensao();//
    Result result= new Result();
    private final int SPLASH_DISPLAY_LENGTH = 5000;
    String resistence;
    TextView outputResult;
    String output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energy_calc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Calculadora (Energia consumida)");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void checkDCPower(View v)
    {
        Intent dcForm = new Intent(this,DC_Power.class);
        startActivity(dcForm);
    }

    public void calculateEnergy(View v)
    {
        String powerOptionSelect, timeOptionSelect; // ira ser guardada a grandeza da
        /// resistencia e da corrente
        EditText mEdit, mEditI;
        Spinner virtualSpinnerP, virtualSpinnerT;


        virtualSpinnerP = (Spinner) findViewById(R.id.wattType);
        powerOptionSelect = virtualSpinnerP.getSelectedItem().toString();


        virtualSpinnerT = (Spinner) findViewById(R.id.timeType);
        timeOptionSelect = virtualSpinnerT.getSelectedItem().toString();

        mEdit = (EditText) findViewById(R.id.wattInput);
        valueW = Float.parseFloat(mEdit.getText().toString());


        originalValueW = OhmAnalyser.ConvertToVolts(valueW, powerOptionSelect); // Este metodo faz a conversao
        // da resistencia para ohms brutos e devolve o resultado para a variavel originalValueF

        mEditI = (EditText) findViewById(R.id.timeInput);
        valueT = Float.parseFloat(mEditI.getText().toString());

        originalValueT = OhmAnalyser.ConvertToAmpere(valueT, timeOptionSelect);


        //tudo o que aparece no formulario deve ser invisivel ... inclusive o botao
        //calcular
        findViewById(R.id.powerText).setVisibility(View.INVISIBLE);
        findViewById(R.id.wattInput).setVisibility(View.INVISIBLE);
        findViewById(R.id.wattType).setVisibility(View.INVISIBLE);
        findViewById(R.id.timeText).setVisibility(View.INVISIBLE);
        findViewById(R.id.timeInput).setVisibility(View.INVISIBLE);
        findViewById(R.id.timeType).setVisibility(View.INVISIBLE);
        findViewById(R.id.button).setVisibility(View.INVISIBLE);
        findViewById(R.id.button2).setVisibility(View.INVISIBLE);

        //findViewById(R.id.waitMessage).setVisibility(View.VISIBLE);


        new Handler().postDelayed(new Runnable(){


            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                outputResult = (TextView) findViewById(R.id.resultMessage);
                resistence =Float.toString(OhmAnalyser.DeterminaResistencia(font, originalValueA));
                // determinar se temos por exemplo mv, v ou kv)

                output= ElectricalMeansure.ConvertMeansure(Double.valueOf(resistence),2);
                outputResult.setText("Resultado: "+output+"Ω");
                findViewById(R.id.img1).setVisibility(View.INVISIBLE);
                findViewById(R.id.resultMessage).setVisibility(View.VISIBLE);
                findViewById(R.id.buttonShowC).setVisibility(View.VISIBLE);
            }
        }, SPLASH_DISPLAY_LENGTH);
        findViewById(R.id.img1).setVisibility(View.VISIBLE);



        //outputResult = (TextView) findViewById(R.id.resultMessage);
        //outputResult.setText("Valor da current: {0} v "+current, TextView.BufferType.NORMAL);
        // do nothing

    }

}
