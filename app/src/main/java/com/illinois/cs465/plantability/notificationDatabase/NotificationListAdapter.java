package com.illinois.cs465.plantability.notificationDatabase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//import com.illinois.cs465.plantability.MyPlants_PlantDetails;
import com.illinois.cs465.plantability.MyPlots_4x4_Base;
import com.illinois.cs465.plantability.R;
import com.illinois.cs465.plantability.notificationDatabase.Notification;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationListAdapter extends RecyclerView.Adapter<NotificationListAdapter.MyViewHolder> {
    private Context context;
    private List<Notification> notificationList;

    public NotificationListAdapter(Context context) {
        this.context = context;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NotificationListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notifications_recycler_row, parent, false);

        return new NotificationListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationListAdapter.MyViewHolder holder, int position) {
        Notification curNotif = this.notificationList.get(position);
        holder.notificationName.setText(curNotif.eventTitle);
        holder.position.setText(String.valueOf(position)); // Used to hold position value to pass correct plant intent
        String start_date = curNotif.startMonth + "/" + curNotif.startDay + "/" + curNotif.startYear;
        holder.notificationDate.setText(start_date);

        // Add icons
        if (curNotif.eventType.equals("Start Seeds")) {
            holder.notificationIcon.setImageResource(R.drawable.planting_seeds);
        } else if (curNotif.eventType.equals("Harvest Plant")) {
            holder.notificationIcon.setImageResource(R.drawable.harvest_icon);
        } else if (curNotif.eventType.equals("Water")) {
            holder.notificationIcon.setImageResource(R.drawable.water_drop);
        } else if (curNotif.eventType.equals("Weed")) {
            holder.notificationIcon.setImageResource(R.drawable.scissor);
        }

        // Set checked-ness of box
        // TODO Need to change db to fix this likely
        // WHY DON'T YOU WORKKKK!?!?!
        if (curNotif.doneFlag.equals("True")){
//            Toast.makeText(context, "Equals works true", Toast.LENGTH_SHORT).show();
            holder.notificationImage.setImageResource(R.drawable.box_ticked);
        }
        else if (curNotif.doneFlag.equals("False")){
//            Toast.makeText(context, "Equals works false", Toast.LENGTH_SHORT).show();
            holder.notificationImage.setImageResource(R.drawable.box_unticked);
        }
        else {
            Toast.makeText(context, "Other issue...", Toast.LENGTH_SHORT).show();
            holder.notificationImage.setImageResource(R.drawable.box_unticked);
        }
    }

    @Override
    public int getItemCount() {
        return this.notificationList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView position;
        TextView notificationName;
        TextView notificationDate;
        ImageView notificationImage;
        ImageView notificationIcon;

        public MyViewHolder(View view) {
            super(view);
            position = view.findViewById(R.id.position);
            notificationName = view.findViewById(R.id.notificationName);
            notificationDate = view.findViewById(R.id.notificationDate);
            notificationImage = view.findViewById(R.id.notificationImageRecycler);
            notificationIcon = view.findViewById(R.id.notificationIcon);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = Integer.parseInt(position.getText().toString());

                    Notification notification = notificationList.get(id);
                    NotificationDatabase notificationDatabase = NotificationDatabase.getNotificationDatabaseInstance(context);

//                  Set done_flag to opposite
                    if (notification.doneFlag.equals("True")) {
                        notification.doneFlag = "False";
                        notificationDatabase.notificationDao().insertNotification(notification);
                        // TODO Test if this duplication is necessary
                        notificationImage.setImageResource(R.drawable.box_unticked);
                    } else if (notification.doneFlag.equals("False")) {
                        notification.doneFlag = "True";
                        notificationDatabase.notificationDao().insertNotification(notification);
                        // TODO Test if this duplication is necessary
                        notificationImage.setImageResource(R.drawable.box_ticked);
                    } else {
                        Toast.makeText(context, "Issue with done_flag in notification", Toast.LENGTH_SHORT).show();
                        notificationImage.setImageResource(R.drawable.box_ticked);
                    }

//                    TODO ??? need this? Then how to get plant info from notification?
//                    Intent intent = new Intent(context, MyPlants_PlantDetails.class);
//                    intent.putExtra("id", id);
//                    intent.putExtra("plant_name", plant.plantName);
//                    intent.putExtra("plant_image", plant.plantImage);
//                    intent.putExtra("seed_depth", plant.seedDepth);
//                    intent.putExtra("seed_spacing", plant.seedSpacing);
//                    intent.putExtra("row_spacing", plant.rowSpacing);
//                    intent.putExtra("plants_per_square_foot", plant.plantsPerSquareFoot);
//                    intent.putExtra("start_date", plant.startDate);
//                    intent.putExtra("days_to_harvest", plant.daysToHarvest);
//                    intent.putExtra("sun_level", plant.sunLevel);
//                    intent.putExtra("num_waterings_per_week", plant.numWateringTimesPerWeek);
//                    intent.putExtra("amount_water_per_week", plant.amountWaterPerWeek);
//                    intent.putExtra("num_weedings_per_week", plant.numWeedingTimesPerWeek);
//                    intent.putExtra("plant_notes", plant.plantNotes);
//                    context.startActivity(intent);
                }
            });
        }
    }
}
