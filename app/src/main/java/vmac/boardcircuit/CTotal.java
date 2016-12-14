package vmac.boardcircuit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class CTotal extends AppCompatActivity {


    Intent in = new Intent(this, CapacitorInsert.class);
    int numCapacParalelo, numeroCapacSerie;
    EditText condensadoresParalelo, condensadoresSerie;
    int LENGTH=1500; // sleep the software by 1.5 senconds


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctotal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Capacitancia Total");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void calcAndShowNewForm (View v)
    {
        condensadoresParalelo = (EditText) findViewById(R.id.capacitorParalelInput);
        numCapacParalelo = Integer.parseInt(condensadoresParalelo.getText().toString());

        condensadoresSerie = (EditText) findViewById(R.id.capactorSerialInput);
        numeroCapacSerie = Integer.parseInt(condensadoresParalelo.getText().toString());


    }

}
