package vmac.boardcircuit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CapacitorInsert extends AppCompatActivity {

    EditText [] edit = new EditText[50];
    TextView [] txtView = new TextView[50];
    Spinner [] grandezaCapac = new Spinner[50];
    int numCacacSerie;
    //Intent intent = new Intent(this,)

    public void insertSerieCapacitors(int numCapacS)
    {
        if(numCapacS<=50) {
            for (int j = 0; j < txtView.length; j++) {

                while (j < 10) {
                    edit[j].setVisibility(View.VISIBLE);
                    edit[j].setText("Condensador "+j+1+":");
                }
                if(j>=10) {
                    //new Intent and new code
                    break;
                }

            }
            for (int i = 0; i < edit.length; i++) {
                //limit that number ... allow only insert 10 by form
                while (i < 10) {
                    edit[i].setVisibility(View.VISIBLE);


                }
                if(i>=10) {
                    //new Intent and new code
                break;
                }
            }
            for (int k = 0; k <grandezaCapac.length; k++) {
                while (k < 10) {
                    //grandezaCapac[k].
                    

                }
                if (k >= 10) {
                    //new Intent and new code
                    break;
                }
            }
        }
        else if(numCapacS>50)
        {

        }
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capacitor_insert);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Inserir condensadores (em serie)");

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
