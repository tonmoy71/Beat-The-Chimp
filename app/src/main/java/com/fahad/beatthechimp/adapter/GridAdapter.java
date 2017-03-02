package com.fahad.beatthechimp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fahad.beatthechimp.R;
import com.fahad.beatthechimp.model.Data;
import java.util.List;

/**
 * Created by fahad on 2/28/17.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

  private Context gridContext;
  private Data dataGrid = new Data(12);
  private List<String> number = dataGrid.getGrid();
  private OnItemClickListener clickListener;

  public GridAdapter(Context context) {
    gridContext = context;
  }

  public void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
    this.clickListener = onItemClickListener;
  }

  private Context getContext() {
    return gridContext;
  }

  @Override public GridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    Context context = parent.getContext();
    LayoutInflater inflater = LayoutInflater.from(context);
    View numberView = inflater.inflate(R.layout.number, null);
    GridAdapter.ViewHolder viewHolder = new ViewHolder(context, numberView);
    return viewHolder;
  }

  @Override public void onBindViewHolder(GridAdapter.ViewHolder holder, int position) {
    String num = number.get(position);
    Integer flag = Integer.parseInt(num);
    if (flag != -10) {
      TextView textView = holder.numberTextView;
      textView.setText(num);
    } else {
      TextView textView = holder.numberTextView;
      textView.setVisibility(View.GONE);
      textView.setClickable(false);
    }
  }

  @Override public int getItemCount() {
    return number.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView numberTextView;
    private Context context;

    public ViewHolder(Context context, View itemView) {

      super(itemView);
      this.context = context;
      this.numberTextView = (TextView) itemView.findViewById(R.id.number);
      itemView.setOnClickListener(this);
    }

    @Override public void onClick(View v) {
      int position = getLayoutPosition();
      if (position != RecyclerView.NO_POSITION) {
        clickListener.onClick(v, position);
      }
    }
  }
}