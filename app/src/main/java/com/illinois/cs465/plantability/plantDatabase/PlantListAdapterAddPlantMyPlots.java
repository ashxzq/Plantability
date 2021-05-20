package com.illinois.cs465.plantability.plantDatabase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.illinois.cs465.plantability.MyPlots_4x4_AddPlant;
import com.illinois.cs465.plantability.MyPlots_6x8_AddPlant;
import com.illinois.cs465.plantability.MyPlots_4x4_Base;
import com.illinois.cs465.plantability.MyPlots_6x8_Base;
import com.illinois.cs465.plantability.R;
import com.illinois.cs465.plantability.plotDatabase.Plot;
import com.illinois.cs465.plantability.plotDatabase.PlotDatabase;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlantListAdapterAddPlantMyPlots extends RecyclerView.Adapter<PlantListAdapterAddPlantMyPlots.MyViewHolder> {
    private Context context;
    private List<Plant> plantList;

    public PlantListAdapterAddPlantMyPlots(Context context) {
        this.context = context;
    }

    public void setPlantList(List<Plant> plantList) {
        this.plantList = plantList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlantListAdapterAddPlantMyPlots.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_plots_add_plant_recycler_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantListAdapterAddPlantMyPlots.MyViewHolder holder, int position) {
        Plant curPlant = this.plantList.get(position);
        holder.plantName.setText(curPlant.plantName);
        holder.position.setText(String.valueOf(position)); // Used to hold position value to pass correct plant intent

        int imgId = context.getResources().getIdentifier(curPlant.plantImage, "drawable", context.getPackageName());
        holder.plantImage.setImageResource(imgId);
    }

    @Override
    public int getItemCount() {
        return this.plantList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView position;
        TextView plantName;
        ImageView plantImage;

        public MyViewHolder(View view) {
            super(view);
            position = view.findViewById(R.id.position);
            plantName = view.findViewById(R.id.plantName);
            plantImage = view.findViewById(R.id.plantImageRecycler);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent previousIntent = ((Activity) context).getIntent();
                    String plotName = previousIntent.getStringExtra("plot_name");
                    String editingTileId = previousIntent.getStringExtra("editing_tile_id");

                    // Get current plot
                    PlotDatabase plotDatabase = PlotDatabase.getPlotDatabaseInstance(context);
                    List<Plot> plots = plotDatabase.plotDao().getAllPlots();
                    Plot plot = null;
                    for (int i = 0; i < plots.size(); i++) {
                        if (plots.get(i).plotName.equals(plotName)) {
                            plot = plots.get(i);
                            break;
                        }
                    }
                    if (plot == null) {
                        return;
                    }
                    // Get selected plant
                    int plantIdx = Integer.parseInt(position.getText().toString());
                    Plant plant = plantList.get(plantIdx);

                    // Update the plot's stored image for the previously clicked tile "editing_tile_id"
                    String[] prevTileData = plot.getTileData(editingTileId);

                    // Remove old plot version from DB
                    plotDatabase.plotDao().deletePlot(plot);
                    //Log.e("Plantlistadapter", "Tile id: " + editingTileId + ", plantName: " + plant.plantName + ", prev1:" + prevTileData[1]);
                    plot.putTileData(editingTileId, plant.plantName, prevTileData[1]);
                    //Log.e("After put", "4_1 plantName:" + plot.tile_4_1_plant_name + "4_1sun: " + plot.tile_4_1_border_sun);
                    // Insert new plot version to DB
                    plotDatabase.plotDao().insertPlot(plot);

                    // Determine which plot page to start based on plot dimensions
                    if (plot.plotHeight == 4 && plot.plotWidth == 4) {
                        Intent intent = new Intent(context, MyPlots_4x4_AddPlant.class);
                        intent.putExtra("plot_name", previousIntent.getStringExtra("plot_name"));
                        context.startActivity(intent);
                    }else if (plot.plotHeight == 8 && plot.plotWidth == 6) {
                        Intent intent = new Intent(context, MyPlots_6x8_AddPlant.class);
                        intent.putExtra("plot_name", previousIntent.getStringExtra("plot_name"));
                        context.startActivity(intent);
                    }

                    ((Activity) context).finish();
                }
            });
        }
    }
}
