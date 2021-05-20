package com.illinois.cs465.plantability.plotDatabase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.illinois.cs465.plantability.MyPlots_4x4_Base;
import com.illinois.cs465.plantability.MyPlots_6x8_Base;
import com.illinois.cs465.plantability.MyPlots_Base;
import com.illinois.cs465.plantability.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlotListAdapter extends RecyclerView.Adapter<PlotListAdapter.MyViewHolder> {
    private Context context;
    private List<Plot> plotList;

    public PlotListAdapter(Context context) {
        this.context = context;
    }

    public void setPlotList(List<Plot> plotList) {
        this.plotList = plotList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlotListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_plots_recycler_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlotListAdapter.MyViewHolder holder, int position) {
        Plot curPlot = this.plotList.get(position);
        holder.plotName.setText(curPlot.plotName);
        holder.position.setText(String.valueOf(position)); // Used to hold position value to pass correct plot intent

    }

    @Override
    public int getItemCount() {
        return this.plotList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView position;
        TextView plotName;
        Button deletePlotButton;

        public MyViewHolder(View view) {
            super(view);
            position = view.findViewById(R.id.position);
            plotName = view.findViewById(R.id.plotName);
            deletePlotButton = view.findViewById(R.id.deletePlotButton);

            // Delete plot when delete button is clicked
            deletePlotButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = Integer.parseInt(position.getText().toString());
                    Plot plot = plotList.get(id);
                    PlotDatabase plotDatabase = PlotDatabase.getPlotDatabaseInstance(context);
                    plotDatabase.plotDao().deletePlot(plot);
                    context.startActivity(new Intent(context, MyPlots_Base.class));
                    ((Activity) context).finish();
                }
            });

            // Start plot activity if other parts of row are clicked
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int id = Integer.parseInt(position.getText().toString());
                    Plot plot = plotList.get(id);

                    if (plot.plotWidth == 4 && plot.plotHeight == 4) {
                        Intent intent = new Intent(context, MyPlots_4x4_Base.class);
                        intent.putExtra("plot_name", plot.plotName);
                        context.startActivity(intent);

                    } else if(plot.plotWidth == 6 && plot.plotHeight == 8) {
                        Intent intent = new Intent(context, MyPlots_6x8_Base.class);
                        intent.putExtra("plot_name", plot.plotName);
                        context.startActivity(intent);
                    }
                    ((Activity) context).finish();
                }
            });
        }
    }
}
