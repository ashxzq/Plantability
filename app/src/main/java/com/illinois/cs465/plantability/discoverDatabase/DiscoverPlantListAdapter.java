package com.illinois.cs465.plantability.discoverDatabase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.illinois.cs465.plantability.Discover_PlantDetails;
import com.illinois.cs465.plantability.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DiscoverPlantListAdapter extends RecyclerView.Adapter<DiscoverPlantListAdapter.MyViewHolder> {
    private Context context;
    private List<DiscoverPlant> plantList;

    public DiscoverPlantListAdapter(Context context) {
        this.context = context;
    }

    public void setPlantList(List<DiscoverPlant> plantList) {
        this.plantList = plantList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DiscoverPlantListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discover_recycler_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscoverPlantListAdapter.MyViewHolder holder, int position) {
        DiscoverPlant curPlant = this.plantList.get(position);
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
                    int id = Integer.parseInt(position.getText().toString());

                    DiscoverPlant plant = plantList.get(id);

                    Intent intent = new Intent(context, Discover_PlantDetails.class);
                    intent.putExtra("id", id);
                    intent.putExtra("plant_name", plant.plantName);
                    intent.putExtra("plant_image", plant.plantImage);
                    intent.putExtra("seed_depth", plant.seedDepth);
                    intent.putExtra("seed_spacing", plant.seedSpacing);
                    intent.putExtra("row_spacing", plant.rowSpacing);
                    intent.putExtra("plants_per_square_foot", plant.plantsPerSquareFoot);
                    intent.putExtra("start_date", plant.startDate);
                    intent.putExtra("days_to_harvest", plant.daysToHarvest);
                    intent.putExtra("sun_level", plant.sunLevel);
                    intent.putExtra("num_waterings_per_week", plant.numWateringTimesPerWeek);
                    intent.putExtra("amount_water_per_week", plant.amountWaterPerWeek);
                    intent.putExtra("num_weedings_per_week", plant.numWeedingTimesPerWeek);
                    intent.putExtra("plant_notes", plant.plantNotes);

                    context.startActivity(intent);
                }
            });
        }
    }
}
