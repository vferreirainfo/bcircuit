package vmac.boardcircuit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class TypeCTotal extends AppCompatActivity {

    int quantidadeCapacitors; //em serie ou paralelo
    EditText myQuanty;




    public void serieCapacitor (View v)
    {

        Bundle b = new Bundle();
        String s;
        myQuanty = (EditText) findViewById(R.id.condensadorInput);
        s= myQuanty.getText().toString();
        quantidadeCapacitors = Integer.parseInt(s.trim()); //obter a quantidade de condensadores e
        b.putInt("_serie",quantidadeCapacitors);
        // converter para inteiro ... este cast e obrigatorio ser feito
        Intent serieIntent = new Intent(this, CTotalSerie.class);
        serieIntent.putExtras(b);
        startActivity(serieIntent);


        //serie.CalculateCapacSerial(serieIntent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_ctotal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Selecçao tipo de calculo CT");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



}
