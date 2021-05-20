package com.illinois.cs465.plantability;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.illinois.cs465.plantability.plotDatabase.Plot;
import com.illinois.cs465.plantability.plotDatabase.PlotDatabase;

public class MyPlots_AddPlot extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_plots_add_plot);

        final EditText plotNameInput = (EditText) findViewById(R.id.plotNameInput);
        final EditText plotHeightInput = (EditText) findViewById(R.id.plotHeightInput);
        final EditText plotWidthInput = (EditText) findViewById(R.id.plotWidthInput);

        Button doneButton = (Button) findViewById(R.id.doneButton);
        Button backButton = (Button) findViewById(R.id.backButton);
        Button cancelButton = (Button) findViewById(R.id.cancelButton);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlotDatabase plotDatabase = PlotDatabase.getPlotDatabaseInstance(getApplicationContext());
                Plot plot = new Plot();
                // Set core plot data
                plot.plotName = plotNameInput.getText().toString();
                plot.plotHeight = Integer.parseInt(plotHeightInput.getText().toString());
                plot.plotWidth = Integer.parseInt(plotWidthInput.getText().toString());
                // Initialize plot tile data
                for (int i = 1; i <= plot.plotHeight; i++) {
                    for (int j = 1; j <= plot.plotWidth; j++) {
                        String curTileId = "tile_" + i + "_" + j;
                        // Initially, each tile is not associated with a plant (plantName = "") and has a black border (borderSun = 'shade')
                        plot.putTileData(curTileId, "", "shade");
                        //Log.e("filling tile: ", curTileId);
                    }
                }

                plotDatabase.plotDao().insertPlot(plot);

                startActivity(new Intent(getApplicationContext(), MyPlots_Base.class));
                finish();
            }
        });
        backButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backButton) {
            startActivity(new Intent(this, MyPlots_Base.class));
            finish();

        } else if (v.getId() == R.id.cancelButton) {
            startActivity(new Intent(this, MyPlots_Base.class));
            finish();

        }
    }
}