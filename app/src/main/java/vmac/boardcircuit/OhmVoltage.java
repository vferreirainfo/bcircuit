package vmac.boardcircuit;


import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.boardBO.Resistor;
import com.example.ElectricalMeansure;
import com.example.OhmAnalyser;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class OhmVoltage extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */






    private GoogleApiClient client;

    float valueA, valueR;
    float originalValueA, originalValueR; // Estas duas variaveis irao guardar a conversao se         String current;
    Resistor r = new Resistor();
    Result result= new Result();
    private final int SPLASH_DISPLAY_LENGTH = 5000; //tempo de duraçao do splashscreen "thuderstorm"
    String voltagem;
    TextView outputResult;
    String output;
    //para volts e amperes

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }




    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ohm_voltage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Determinar voltagem");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
         //apenas se clicar no butao calcular


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void startAnimations(View view) {

        String resisitorOptionSelect, ampereOptionSelect; // ira ser guardada a grandeza da
        /// resistencia e da corrente
        EditText mEdit, mEditI;
        Spinner virtualSpinnerR, virtualSpinnerA;


        virtualSpinnerR = (Spinner) findViewById(R.id.ohmType);
        resisitorOptionSelect = virtualSpinnerR.getSelectedItem().toString();


        virtualSpinnerA = (Spinner) findViewById(R.id.AmpereType);
        ampereOptionSelect = virtualSpinnerA.getSelectedItem().toString();

        mEdit = (EditText) findViewById(R.id.ohmInput);
        valueR = Float.parseFloat(mEdit.getText().toString());


        originalValueR = OhmAnalyser.ConvertToOhm(valueR, resisitorOptionSelect); // Este metodo faz a conversao
        r.setResistenceValue(originalValueR);
        // da resistencia para ohms brutos e devolve o resultado para a variavel originalValueF

        mEditI = (EditText) findViewById(R.id.AmpereInput);
        valueA = Float.parseFloat(mEditI.getText().toString());

        originalValueA = OhmAnalyser.ConvertToAmpere(valueA, ampereOptionSelect);


        //tudo o que aparece no formulario deve ser invisivel ... inclusive o botao
        //calcular
        findViewById(R.id.AmpereInput).setVisibility(View.INVISIBLE);
        findViewById(R.id.resisitorText).setVisibility(View.INVISIBLE);
        findViewById(R.id.ohmInput).setVisibility(View.INVISIBLE);
        findViewById(R.id.ohmType).setVisibility(View.INVISIBLE);
        findViewById(R.id.ampereText).setVisibility(View.INVISIBLE);
        findViewById(R.id.AmpereType).setVisibility(View.INVISIBLE);
        findViewById(R.id.button).setVisibility(View.INVISIBLE);

        //findViewById(R.id.waitMessage).setVisibility(View.VISIBLE);


        new Handler().postDelayed(new Runnable(){


            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                outputResult = (TextView) findViewById(R.id.resultMessage);
                voltagem=Float.toString(OhmAnalyser.DeterminaTensao(r, originalValueA));
                // determinar se temos por exemplo mv, v ou kv)
                DecimalFormat df = new DecimalFormat("#######.00");
                df.setRoundingMode(RoundingMode.UP);
                output= ElectricalMeansure.ConvertMeansure(Double.valueOf(voltagem),2);
                //outputResult.setText("Resultado: "+Math.ceil(Double.valueOf(output))+"V");
                outputResult.setText("Resultado: "+output+"V");
                findViewById(R.id.img1).setVisibility(View.INVISIBLE);
                findViewById(R.id.resultMessage).setVisibility(View.VISIBLE);
            }
        }, SPLASH_DISPLAY_LENGTH);
        findViewById(R.id.img1).setVisibility(View.VISIBLE);



        //outputResult = (TextView) findViewById(R.id.resultMessage);
        //outputResult.setText("Valor da current: {0} v "+current, TextView.BufferType.NORMAL);
        // do nothing

    }




    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("OhmVoltage Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }


}
