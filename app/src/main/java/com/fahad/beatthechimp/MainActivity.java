package com.fahad.beatthechimp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.fahad.beatthechimp.adapter.GridAdapter;
import com.fahad.beatthechimp.adapter.OnItemClickListener;
import com.fahad.beatthechimp.model.Data;
import com.fahad.beatthechimp.utility.Constant;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Data dataGrid = new Data(Constant.Difficulty.LEVEL_ONE);
    private int counter = 1;
    private GridAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridAdapter = new GridAdapter(getApplicationContext(), dataGrid);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.numbergrid);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 7));
        recyclerView.setAdapter(gridAdapter);
        gridAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view, int position, String value) {

        if (counter == Integer.parseInt(value)) {
            Toast.makeText(this, "Position: " + position + " Value: " + value, Toast.LENGTH_SHORT).show();
            counter++;
            gridAdapter.setDataSet(position, Constant.Value.INFS);
        } else if (Integer.parseInt(value) == Constant.Value.INF) {
            Toast.makeText(this, "Click on a cell", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Position: " + position + " Wrong Order", Toast.LENGTH_SHORT).show();
        }
        if (Integer.parseInt(value) == Constant.Difficulty.LEVEL_ONE) {
            if(counter == Integer.parseInt(value)){
                Toast.makeText(this, "Congratulation!", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
