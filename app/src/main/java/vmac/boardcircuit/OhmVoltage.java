package vmac.boardcircuit;


import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.boardBO.Resistor;
import com.example.OhmAnalyser;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.InputStream;

public class OhmVoltage extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */






    private GoogleApiClient client;
    private InputStream gifInputStream;
    private Movie gifMovie;
    private int movieWidth, movieHeight;
    private long movieDuration;
    private long movieStart;
    float valueA, valueR;
    float originalValueA, originalValueR; // Estas duas variaveis irao guardar a conversao se         String voltagem;
    Resistor r = new Resistor();
    Result result= new Result();

    String voltagem;
    //para volts e amperes

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    Thread splashTread;


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


        //gifInputStream = this.getResources().openRawResource(R.drawable.wait);
        gifInputStream = findViewById(R.id.img1).getResources().openRawResource(R.drawable.wait);
        gifMovie = Movie.decodeStream(gifInputStream);
        movieWidth = gifMovie.width();
        movieHeight = gifMovie.height();
        movieDuration = gifMovie.duration();


        String resisitorOptionSelect, ampereOptionSelect; // ira ser guardada a grandeza da
        /// resistencia e da corrente


        EditText mEdit, mEditI;
        TextView outputResult;
        Spinner virtualSpinnerR, virtualSpinnerA;


        virtualSpinnerR = (Spinner) findViewById(R.id.ohmType);
        resisitorOptionSelect = virtualSpinnerR.getSelectedItem().toString();


        virtualSpinnerA = (Spinner) findViewById(R.id.AmpereType);
        ampereOptionSelect = virtualSpinnerA.getSelectedItem().toString();

        mEdit = (EditText) findViewById(R.id.ohmInput);

        valueR = Float.parseFloat(mEdit.getText().toString());


        originalValueR = OhmAnalyser.ConvertToOhm(valueR, resisitorOptionSelect); // Este metodo faz a conversao
        r.setResistenceValue(originalValueR);
        // da resistencia para ohms brutos e devolve o resultado para a variavel originalValueR

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
        findViewById(R.id.img1).setVisibility(View.VISIBLE);
        //findViewById(R.id.waitMessage).setVisibility(View.VISIBLE);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        RelativeLayout l = (RelativeLayout) findViewById(R.id.content_ohm_voltage);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();

        //iv.clearAnimation();
        //iv.startAnimation(anim);




        /*
                           */
        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    voltagem=Float.toString(OhmAnalyser.DeterminaTensao(r, originalValueA));


                    Intent intent = new Intent(OhmVoltage.this,Result.class);//new splash screen result
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    result.setKey("V");
                    result.setGrandeza("V");
                    result.setValorVoltagem(Double.valueOf(voltagem));
                    //result.ShowVoltage(intent);
                    startActivity(intent);


                } catch (InterruptedException e) {

                } finally {

                    //Splashscreen.this.finish();
                }

            }
        };
        splashTread.start();


        //outputResult = (TextView) findViewById(R.id.resultMessage);
        //outputResult.setText("Valor da voltagem: {0} v "+voltagem, TextView.BufferType.NORMAL);
        // do nothing

    }



    public int getMovieWidth()
    {
        return movieWidth;
    }
    public int getMovieHeight()
    {
        return movieHeight;
    }
    public long getMovieDuration()
    {
        return movieDuration;
    }

    public void onDraw(Canvas canvas) {
        long now = SystemClock.uptimeMillis();

        if (movieStart == 0) {
            movieStart = now;
        }
        if (gifMovie != null) {
            int dur = gifMovie.duration();
            if (dur == 0) {
                dur = 1000;
            }
            int relTime = (int) ((now - movieStart) % dur);
            gifMovie.setTime(relTime);
            gifMovie.draw(canvas, 0, 0);

        }
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

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


}
