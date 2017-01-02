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

import com.boardBO.FonteTensao;
import com.example.ElectricalMeansure;
import com.example.OhmAnalyser;

public class OhmResistor extends AppCompatActivity {


    float valueA, valueF;
    float originalValueA, originalValueF; // Estas duas variaveis irao guardar a conversao se         String current;
    FonteTensao font = new FonteTensao();//
    Result result= new Result();
    private final int SPLASH_DISPLAY_LENGTH = 5000;
    String resistence;
    TextView outputResult;
    String output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ohm_resistor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Determinar resistencia");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

    public void startAnimations(View view) {

        String fontOptionSelect, ampereOptionSelect; // ira ser guardada a grandeza da
        /// resistencia e da corrente
        EditText mEdit, mEditI;
        Spinner virtualSpinnerF, virtualSpinnerA;


        virtualSpinnerF = (Spinner) findViewById(R.id.voltType);
        fontOptionSelect = virtualSpinnerF.getSelectedItem().toString();


        virtualSpinnerA = (Spinner) findViewById(R.id.AmpereType);
        ampereOptionSelect = virtualSpinnerA.getSelectedItem().toString();

        mEdit = (EditText) findViewById(R.id.voltInput);
        valueF = Float.parseFloat(mEdit.getText().toString());


        originalValueF = OhmAnalyser.ConvertToVolts(valueF, fontOptionSelect); // Este metodo faz a conversao
        font.setFontVolts(originalValueF);
        // da resistencia para ohms brutos e devolve o resultado para a variavel originalValueF

        mEditI = (EditText) findViewById(R.id.AmpereInput);
        valueA = Float.parseFloat(mEditI.getText().toString());

        originalValueA = OhmAnalyser.ConvertToAmpere(valueA, ampereOptionSelect);


        //tudo o que aparece no formulario deve ser invisivel ... inclusive o botao
        //calcular
        findViewById(R.id.AmpereInput).setVisibility(View.INVISIBLE);
        findViewById(R.id.voltText).setVisibility(View.INVISIBLE);
        findViewById(R.id.voltInput).setVisibility(View.INVISIBLE);
        findViewById(R.id.voltType).setVisibility(View.INVISIBLE);
        findViewById(R.id.ampereText).setVisibility(View.INVISIBLE);
        findViewById(R.id.AmpereType).setVisibility(View.INVISIBLE);
        findViewById(R.id.button).setVisibility(View.INVISIBLE);

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
