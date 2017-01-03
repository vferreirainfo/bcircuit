package vmac.boardcircuit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class MeshRequire extends AppCompatActivity {

    private int numberOfMeshs;
    private EditText input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesh_require);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void createFormulary (View v)
    {

        input= (EditText) findViewById(R.id.meshInput);
        numberOfMeshs = Integer.valueOf(input.getText().toString());
        Bundle bun = new Bundle();
        bun.putInt("_num",numberOfMeshs);
        Intent newAct = new Intent(this, MeshFormulary.class);
        startActivity(newAct);

    }

}
