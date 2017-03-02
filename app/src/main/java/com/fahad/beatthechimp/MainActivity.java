package com.fahad.beatthechimp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.fahad.beatthechimp.adapter.GridAdapter;
import com.fahad.beatthechimp.adapter.OnItemClickListener;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

  private static final String TAG = MainActivity.class.getSimpleName();
  private int counter = 1;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    GridAdapter gridAdapter = new GridAdapter(getApplicationContext());

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.numbergrid);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new GridLayoutManager(this, 7));
    recyclerView.setAdapter(gridAdapter);
    gridAdapter.setOnItemClickListener(this);
  }

  @Override public void onClick(View view, int position, String value) {
    if(counter == Integer.parseInt(value)){
      Toast.makeText(this, "Position: " + position+" Value: "+value, Toast.LENGTH_SHORT).show();
      ++counter;
    }
    else{
      Toast.makeText(this, "Wrong Order", Toast.LENGTH_SHORT).show();
    }
  }
}
