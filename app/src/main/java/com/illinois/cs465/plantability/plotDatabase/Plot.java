package com.illinois.cs465.plantability.plotDatabase;

import android.util.Log;

import java.util.Dictionary;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Plot {


    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "plot_name")
    public String plotName;
    @ColumnInfo(name = "plot_width")
    public int plotWidth;
    @ColumnInfo(name = "plot_height")
    public int plotHeight;


    // Row 1
    @ColumnInfo(name = "tile_1_1_img")
    public String tile_1_1_plant_name = "";
    @ColumnInfo(name = "tile_1_1_border_sun")
    public String tile_1_1_border_sun = "shade";

    @ColumnInfo(name = "tile_1_2_img")
    public String tile_1_2_plant_name = "";
    @ColumnInfo(name = "tile_1_2_border_sun")
    public String tile_1_2_border_sun = "shade";

    @ColumnInfo(name = "tile_1_3_img")
    public String tile_1_3_plant_name = "";
    @ColumnInfo(name = "tile_1_3_border_sun")
    public String tile_1_3_border_sun = "shade";

    @ColumnInfo(name = "tile_1_4_img")
    public String tile_1_4_plant_name = "";
    @ColumnInfo(name = "tile_1_4_border_sun")
    public String tile_1_4_border_sun = "shade";

    @ColumnInfo(name = "tile_1_5_img")
    public String tile_1_5_plant_name = "";
    @ColumnInfo(name = "tile_1_5_border_sun")
    public String tile_1_5_border_sun = "shade";

    @ColumnInfo(name = "tile_1_6_img")
    public String tile_1_6_plant_name = "";
    @ColumnInfo(name = "tile_1_6_border_sun")
    public String tile_1_6_border_sun = "shade";


    // Row 2
    @ColumnInfo(name = "tile_2_1_img")
    public String tile_2_1_plant_name = "";
    @ColumnInfo(name = "tile_2_1_border_sun")
    public String tile_2_1_border_sun = "shade";

    @ColumnInfo(name = "tile_2_2_img")
    public String tile_2_2_plant_name = "";
    @ColumnInfo(name = "tile_2_2_border_sun")
    public String tile_2_2_border_sun = "shade";

    @ColumnInfo(name = "tile_2_3_img")
    public String tile_2_3_plant_name = "";
    @ColumnInfo(name = "tile_2_3_border_sun")
    public String tile_2_3_border_sun = "shade";

    @ColumnInfo(name = "tile_2_4_img")
    public String tile_2_4_plant_name = "";
    @ColumnInfo(name = "tile_2_4_border_sun")
    public String tile_2_4_border_sun = "shade";

    @ColumnInfo(name = "tile_2_5_img")
    public String tile_2_5_plant_name = "";
    @ColumnInfo(name = "tile_2_5_border_sun")
    public String tile_2_5_border_sun = "shade";

    @ColumnInfo(name = "tile_2_6_img")
    public String tile_2_6_plant_name = "";
    @ColumnInfo(name = "tile_2_6_border_sun")
    public String tile_2_6_border_sun = "shade";


    // Row 3
    @ColumnInfo(name = "tile_3_1_img")
    public String tile_3_1_plant_name = "";
    @ColumnInfo(name = "tile_3_1_border_sun")
    public String tile_3_1_border_sun = "shade";

    @ColumnInfo(name = "tile_3_2_img")
    public String tile_3_2_plant_name = "";
    @ColumnInfo(name = "tile_3_2_border_sun")
    public String tile_3_2_border_sun = "shade";

    @ColumnInfo(name = "tile_3_3_img")
    public String tile_3_3_plant_name = "";
    @ColumnInfo(name = "tile_3_3_border_sun")
    public String tile_3_3_border_sun = "shade";

    @ColumnInfo(name = "tile_3_4_img")
    public String tile_3_4_plant_name = "";
    @ColumnInfo(name = "tile_3_4_border_sun")
    public String tile_3_4_border_sun = "shade";

    @ColumnInfo(name = "tile_3_5_img")
    public String tile_3_5_plant_name = "";
    @ColumnInfo(name = "tile_3_5_border_sun")
    public String tile_3_5_border_sun = "shade";

    @ColumnInfo(name = "tile_3_6_img")
    public String tile_3_6_plant_name = "";
    @ColumnInfo(name = "tile_3_6_border_sun")
    public String tile_3_6_border_sun = "shade";


    // Row 4
    @ColumnInfo(name = "tile_4_1_img")
    public String tile_4_1_plant_name = "";
    @ColumnInfo(name = "tile_4_1_border_sun")
    public String tile_4_1_border_sun = "shade";

    @ColumnInfo(name = "tile_4_2_img")
    public String tile_4_2_plant_name = "";
    @ColumnInfo(name = "tile_4_2_border_sun")
    public String tile_4_2_border_sun = "shade";

    @ColumnInfo(name = "tile_4_3_img")
    public String tile_4_3_plant_name = "";
    @ColumnInfo(name = "tile_4_3_border_sun")
    public String tile_4_3_border_sun = "shade";

    @ColumnInfo(name = "tile_4_4_img")
    public String tile_4_4_plant_name = "";
    @ColumnInfo(name = "tile_4_4_border_sun")
    public String tile_4_4_border_sun = "shade";

    @ColumnInfo(name = "tile_4_5_img")
    public String tile_4_5_plant_name = "";
    @ColumnInfo(name = "tile_4_5_border_sun")
    public String tile_4_5_border_sun = "shade";

    @ColumnInfo(name = "tile_4_6_img")
    public String tile_4_6_plant_name = "";
    @ColumnInfo(name = "tile_4_6_border_sun")
    public String tile_4_6_border_sun = "shade";


    // Row 5
    @ColumnInfo(name = "tile_5_1_img")
    public String tile_5_1_plant_name = "";
    @ColumnInfo(name = "tile_5_1_border_sun")
    public String tile_5_1_border_sun = "shade";

    @ColumnInfo(name = "tile_5_2_img")
    public String tile_5_2_plant_name = "";
    @ColumnInfo(name = "tile_5_2_border_sun")
    public String tile_5_2_border_sun = "shade";

    @ColumnInfo(name = "tile_5_3_img")
    public String tile_5_3_plant_name = "";
    @ColumnInfo(name = "tile_5_3_border_sun")
    public String tile_5_3_border_sun = "shade";

    @ColumnInfo(name = "tile_5_4_img")
    public String tile_5_4_plant_name = "";
    @ColumnInfo(name = "tile_5_4_border_sun")
    public String tile_5_4_border_sun = "shade";

    @ColumnInfo(name = "tile_5_5_img")
    public String tile_5_5_plant_name = "";
    @ColumnInfo(name = "tile_5_5_border_sun")
    public String tile_5_5_border_sun = "shade";

    @ColumnInfo(name = "tile_5_6_img")
    public String tile_5_6_plant_name = "";
    @ColumnInfo(name = "tile_5_6_border_sun")
    public String tile_5_6_border_sun = "shade";


    // Row 6
    @ColumnInfo(name = "tile_6_1_img")
    public String tile_6_1_plant_name = "";
    @ColumnInfo(name = "tile_6_1_border_sun")
    public String tile_6_1_border_sun = "shade";

    @ColumnInfo(name = "tile_6_2_img")
    public String tile_6_2_plant_name = "";
    @ColumnInfo(name = "tile_6_2_border_sun")
    public String tile_6_2_border_sun = "shade";

    @ColumnInfo(name = "tile_6_3_img")
    public String tile_6_3_plant_name = "";
    @ColumnInfo(name = "tile_6_3_border_sun")
    public String tile_6_3_border_sun = "shade";

    @ColumnInfo(name = "tile_6_4_img")
    public String tile_6_4_plant_name = "";
    @ColumnInfo(name = "tile_6_4_border_sun")
    public String tile_6_4_border_sun = "shade";

    @ColumnInfo(name = "tile_6_5_img")
    public String tile_6_5_plant_name = "";
    @ColumnInfo(name = "tile_6_5_border_sun")
    public String tile_6_5_border_sun = "shade";

    @ColumnInfo(name = "tile_6_6_img")
    public String tile_6_6_plant_name = "";
    @ColumnInfo(name = "tile_6_6_border_sun")
    public String tile_6_6_border_sun = "shade";


    // Row 7
    @ColumnInfo(name = "tile_7_1_img")
    public String tile_7_1_plant_name = "";
    @ColumnInfo(name = "tile_7_1_border_sun")
    public String tile_7_1_border_sun = "shade";

    @ColumnInfo(name = "tile_7_2_img")
    public String tile_7_2_plant_name = "";
    @ColumnInfo(name = "tile_7_2_border_sun")
    public String tile_7_2_border_sun = "shade";

    @ColumnInfo(name = "tile_7_3_img")
    public String tile_7_3_plant_name = "";
    @ColumnInfo(name = "tile_7_3_border_sun")
    public String tile_7_3_border_sun = "shade";

    @ColumnInfo(name = "tile_7_4_img")
    public String tile_7_4_plant_name = "";
    @ColumnInfo(name = "tile_7_4_border_sun")
    public String tile_7_4_border_sun = "shade";

    @ColumnInfo(name = "tile_7_5_img")
    public String tile_7_5_plant_name = "";
    @ColumnInfo(name = "tile_7_5_border_sun")
    public String tile_7_5_border_sun = "shade";

    @ColumnInfo(name = "tile_7_6_img")
    public String tile_7_6_plant_name = "";
    @ColumnInfo(name = "tile_7_6_border_sun")
    public String tile_7_6_border_sun = "shade";


    // Row 5
    @ColumnInfo(name = "tile_8_1_img")
    public String tile_8_1_plant_name = "";
    @ColumnInfo(name = "tile_8_1_border_sun")
    public String tile_8_1_border_sun = "shade";

    @ColumnInfo(name = "tile_8_2_img")
    public String tile_8_2_plant_name = "";
    @ColumnInfo(name = "tile_8_2_border_sun")
    public String tile_8_2_border_sun = "shade";

    @ColumnInfo(name = "tile_8_3_img")
    public String tile_8_3_plant_name = "";
    @ColumnInfo(name = "tile_8_3_border_sun")
    public String tile_8_3_border_sun = "shade";

    @ColumnInfo(name = "tile_8_4_img")
    public String tile_8_4_plant_name = "";
    @ColumnInfo(name = "tile_8_4_border_sun")
    public String tile_8_4_border_sun = "shade";

    @ColumnInfo(name = "tile_8_5_img")
    public String tile_8_5_plant_name = "";
    @ColumnInfo(name = "tile_8_5_border_sun")
    public String tile_8_5_border_sun = "shade";

    @ColumnInfo(name = "tile_8_6_img")
    public String tile_8_6_plant_name = "";
    @ColumnInfo(name = "tile_8_6_border_sun")
    public String tile_8_6_border_sun = "shade";

    // Returns String[] where String[0] == tile's plant name and String[1] == tile's border sun level
    public String[] getTileData(String tileId) {
        if (tileId.contains("_border")) {
            tileId = tileId.replace("_border", "");
        }
        String[] toReturn = new String[2];
        switch (tileId) {
            case "tile_1_1":
                toReturn[0] = tile_1_1_plant_name;
                toReturn[1] = tile_1_1_border_sun;
                break;
            case "tile_1_2":
                toReturn[0] = tile_1_2_plant_name;
                toReturn[1] = tile_1_2_border_sun;
                break;
            case "tile_1_3":
                toReturn[0] = tile_1_3_plant_name;
                toReturn[1] = tile_1_3_border_sun;
                break;
            case "tile_1_4":
                toReturn[0] = tile_1_4_plant_name;
                toReturn[1] = tile_1_4_border_sun;
                break;
            case "tile_1_5":
                toReturn[0] = tile_1_5_plant_name;
                toReturn[1] = tile_1_5_border_sun;
                break;
            case "tile_1_6":
                toReturn[0] = tile_1_6_plant_name;
                toReturn[1] = tile_1_6_border_sun;
                break;

            case "tile_2_1":
                toReturn[0] = tile_2_1_plant_name;
                toReturn[1] = tile_2_1_border_sun;
                break;
            case "tile_2_2":
                toReturn[0] = tile_2_2_plant_name;
                toReturn[1] = tile_2_2_border_sun;
                break;
            case "tile_2_3":
                toReturn[0] = tile_2_3_plant_name;
                toReturn[1] = tile_2_3_border_sun;
                break;
            case "tile_2_4":
                toReturn[0] = tile_2_4_plant_name;
                toReturn[1] = tile_2_4_border_sun;
                break;
            case "tile_2_5":
                toReturn[0] = tile_2_5_plant_name;
                toReturn[1] = tile_2_5_border_sun;
                break;
            case "tile_2_6":
                toReturn[0] = tile_2_6_plant_name;
                toReturn[1] = tile_2_6_border_sun;
                break;

            case "tile_3_1":
                toReturn[0] = tile_3_1_plant_name;
                toReturn[1] = tile_3_1_border_sun;
                break;
            case "tile_3_2":
                toReturn[0] = tile_3_2_plant_name;
                toReturn[1] = tile_3_2_border_sun;
                break;
            case "tile_3_3":
                toReturn[0] = tile_3_3_plant_name;
                toReturn[1] = tile_3_3_border_sun;
                break;
            case "tile_3_4":
                toReturn[0] = tile_3_4_plant_name;
                toReturn[1] = tile_3_4_border_sun;
                break;
            case "tile_3_5":
                toReturn[0] = tile_3_5_plant_name;
                toReturn[1] = tile_3_5_border_sun;
                break;
            case "tile_3_6":
                toReturn[0] = tile_3_6_plant_name;
                toReturn[1] = tile_3_6_border_sun;
                break;

            case "tile_4_1":
                toReturn[0] = tile_4_1_plant_name;
                toReturn[1] = tile_4_1_border_sun;
                break;
            case "tile_4_2":
                toReturn[0] = tile_4_2_plant_name;
                toReturn[1] = tile_4_2_border_sun;
                break;
            case "tile_4_3":
                toReturn[0] = tile_4_3_plant_name;
                toReturn[1] = tile_4_3_border_sun;
                break;
            case "tile_4_4":
                toReturn[0] = tile_4_4_plant_name;
                toReturn[1] = tile_4_4_border_sun;
                break;
            case "tile_4_5":
                toReturn[0] = tile_4_5_plant_name;
                toReturn[1] = tile_4_5_border_sun;
                break;
            case "tile_4_6":
                toReturn[0] = tile_4_6_plant_name;
                toReturn[1] = tile_4_6_border_sun;
                break;


            case "tile_5_1":
                toReturn[0] = tile_5_1_plant_name;
                toReturn[1] = tile_5_1_border_sun;
                break;
            case "tile_5_2":
                toReturn[0] = tile_5_2_plant_name;
                toReturn[1] = tile_5_2_border_sun;
                break;
            case "tile_5_3":
                toReturn[0] = tile_5_3_plant_name;
                toReturn[1] = tile_5_3_border_sun;
                break;
            case "tile_5_4":
                toReturn[0] = tile_5_4_plant_name;
                toReturn[1] = tile_5_4_border_sun;
                break;
            case "tile_5_5":
                toReturn[0] = tile_5_5_plant_name;
                toReturn[1] = tile_5_5_border_sun;
                break;
            case "tile_5_6":
                toReturn[0] = tile_5_6_plant_name;
                toReturn[1] = tile_5_6_border_sun;
                break;


            case "tile_6_1":
                toReturn[0] = tile_6_1_plant_name;
                toReturn[1] = tile_6_1_border_sun;
                break;
            case "tile_6_2":
                toReturn[0] = tile_5_2_plant_name;
                toReturn[1] = tile_6_2_border_sun;
                break;
            case "tile_6_3":
                toReturn[0] = tile_6_3_plant_name;
                toReturn[1] = tile_6_3_border_sun;
                break;
            case "tile_6_4":
                toReturn[0] = tile_6_4_plant_name;
                toReturn[1] = tile_6_4_border_sun;
                break;
            case "tile_6_5":
                toReturn[0] = tile_6_5_plant_name;
                toReturn[1] = tile_6_5_border_sun;
                break;
            case "tile_6_6":
                toReturn[0] = tile_6_6_plant_name;
                toReturn[1] = tile_6_6_border_sun;
                break;


            case "tile_7_1":
                toReturn[0] = tile_7_1_plant_name;
                toReturn[1] = tile_7_1_border_sun;
                break;
            case "tile_7_2":
                toReturn[0] = tile_7_2_plant_name;
                toReturn[1] = tile_7_2_border_sun;
                break;
            case "tile_7_3":
                toReturn[0] = tile_7_3_plant_name;
                toReturn[1] = tile_7_3_border_sun;
                break;
            case "tile_7_4":
                toReturn[0] = tile_7_4_plant_name;
                toReturn[1] = tile_7_4_border_sun;
                break;
            case "tile_7_5":
                toReturn[0] = tile_7_5_plant_name;
                toReturn[1] = tile_7_5_border_sun;
                break;
            case "tile_7_6":
                toReturn[0] = tile_7_6_plant_name;
                toReturn[1] = tile_7_6_border_sun;
                break;


            case "tile_8_1":
                toReturn[0] = tile_8_1_plant_name;
                toReturn[1] = tile_8_1_border_sun;
                break;
            case "tile_8_2":
                toReturn[0] = tile_8_2_plant_name;
                toReturn[1] = tile_8_2_border_sun;
                break;
            case "tile_8_3":
                toReturn[0] = tile_8_3_plant_name;
                toReturn[1] = tile_8_3_border_sun;
                break;
            case "tile_8_4":
                toReturn[0] = tile_8_4_plant_name;
                toReturn[1] = tile_8_4_border_sun;
                break;
            case "tile_8_5":
                toReturn[0] = tile_8_5_plant_name;
                toReturn[1] = tile_8_5_border_sun;
                break;
            case "tile_8_6":
                toReturn[0] = tile_8_6_plant_name;
                toReturn[1] = tile_8_6_border_sun;
                break;

            default:
                toReturn[0] = "";
                toReturn[1] = "shade";
                break;
        }
        //Log.e("returning get: ", toReturn[0] + " " + toReturn[1]);
        return toReturn;
    }

    // Sets a tile's plant name and border sun level
    public void putTileData(String tileId, String plantName, String borderSun) {
        if (tileId.contains("_border")) {
            tileId = tileId.replace("_border", "");
        }
        //Log.e("Put Tile Data", tileId + " " + plantName + " " + borderSun);
        switch (tileId) {
            case "tile_1_1":
                tile_1_1_plant_name = plantName;
                tile_1_1_border_sun = borderSun;
                break;
            case "tile_1_2":
                tile_1_2_plant_name = plantName;
                tile_1_2_border_sun = borderSun;
                break;
            case "tile_1_3":
                tile_1_3_plant_name = plantName;
                tile_1_3_border_sun = borderSun;
                break;
            case "tile_1_4":
                tile_1_4_plant_name = plantName;
                tile_1_4_border_sun = borderSun;
                break;
            case "tile_1_5":
                tile_1_5_plant_name = plantName;
                tile_1_5_border_sun = borderSun;
                break;
            case "tile_1_6":
                tile_1_6_plant_name = plantName;
                tile_1_6_border_sun = borderSun;
                break;

            case "tile_2_1":
                tile_2_1_plant_name = plantName;
                tile_2_1_border_sun = borderSun;
                break;
            case "tile_2_2":
                tile_2_2_plant_name = plantName;
                tile_2_2_border_sun = borderSun;
                break;
            case "tile_2_3":
                tile_2_3_plant_name = plantName;
                tile_2_3_border_sun = borderSun;
                break;
            case "tile_2_4":
                tile_2_4_plant_name = plantName;
                tile_2_4_border_sun = borderSun;
                break;
            case "tile_2_5":
                tile_2_5_plant_name = plantName;
                tile_2_5_border_sun = borderSun;
                break;
            case "tile_2_6":
                tile_2_6_plant_name = plantName;
                tile_2_6_border_sun = borderSun;
                break;

            case "tile_3_1":
                tile_3_1_plant_name = plantName;
                tile_3_1_border_sun = borderSun;
                break;
            case "tile_3_2":
                tile_3_2_plant_name = plantName;
                tile_3_2_border_sun = borderSun;
                break;
            case "tile_3_3":
                tile_3_3_plant_name = plantName;
                tile_3_3_border_sun = borderSun;
                break;
            case "tile_3_4":
                tile_3_4_plant_name = plantName;
                tile_3_4_border_sun = borderSun;
                break;
            case "tile_3_5":
                tile_3_5_plant_name = plantName;
                tile_3_5_border_sun = borderSun;
                break;
            case "tile_3_6":
                tile_3_6_plant_name = plantName;
                tile_3_6_border_sun = borderSun;
                break;

            case "tile_4_1":
                tile_4_1_plant_name = plantName;
                tile_4_1_border_sun = borderSun;
                break;
            case "tile_4_2":
                tile_4_2_plant_name = plantName;
                tile_4_2_border_sun = borderSun;
                break;
            case "tile_4_3":
                tile_4_3_plant_name = plantName;
                tile_4_3_border_sun = borderSun;
                break;
            case "tile_4_4":
                tile_4_4_plant_name = plantName;
                tile_4_4_border_sun = borderSun;
                break;
            case "tile_4_5":
                tile_4_5_plant_name = plantName;
                tile_4_5_border_sun = borderSun;
                break;
            case "tile_4_6":
                tile_4_6_plant_name = plantName;
                tile_4_6_border_sun = borderSun;
                break;

            case "tile_5_1":
                tile_5_1_plant_name = plantName;
                tile_5_1_border_sun = borderSun;
                break;
            case "tile_5_2":
                tile_5_2_plant_name = plantName;
                tile_5_2_border_sun = borderSun;
                break;
            case "tile_5_3":
                tile_5_3_plant_name = plantName;
                tile_5_3_border_sun = borderSun;
                break;
            case "tile_5_4":
                tile_5_4_plant_name = plantName;
                tile_5_4_border_sun = borderSun;
                break;
            case "tile_5_5":
                tile_5_5_plant_name = plantName;
                tile_5_5_border_sun = borderSun;
                break;
            case "tile_5_6":
                tile_5_6_plant_name = plantName;
                tile_5_6_border_sun = borderSun;
                break;


            case "tile_6_1":
                tile_6_1_plant_name = plantName;
                tile_6_1_border_sun = borderSun;
                break;
            case "tile_6_2":
                tile_6_2_plant_name = plantName;
                tile_6_2_border_sun = borderSun;
                break;
            case "tile_6_3":
                tile_6_3_plant_name = plantName;
                tile_6_3_border_sun = borderSun;
                break;
            case "tile_6_4":
                tile_6_4_plant_name = plantName;
                tile_6_4_border_sun = borderSun;
                break;
            case "tile_6_5":
                tile_6_5_plant_name = plantName;
                tile_6_5_border_sun = borderSun;
                break;
            case "tile_6_6":
                tile_6_6_plant_name = plantName;
                tile_6_6_border_sun = borderSun;
                break;


            case "tile_7_1":
                tile_7_1_plant_name = plantName;
                tile_7_1_border_sun = borderSun;
                break;
            case "tile_7_2":
                tile_7_2_plant_name = plantName;
                tile_7_2_border_sun = borderSun;
                break;
            case "tile_7_3":
                tile_7_3_plant_name = plantName;
                tile_7_3_border_sun = borderSun;
                break;
            case "tile_7_4":
                tile_7_4_plant_name = plantName;
                tile_7_4_border_sun = borderSun;
                break;
            case "tile_7_5":
                tile_7_5_plant_name = plantName;
                tile_7_5_border_sun = borderSun;
                break;
            case "tile_7_6":
                tile_7_6_plant_name = plantName;
                tile_7_6_border_sun = borderSun;
                break;


            case "tile_8_1":
                tile_8_1_plant_name = plantName;
                tile_8_1_border_sun = borderSun;
                break;
            case "tile_8_2":
                tile_8_2_plant_name = plantName;
                tile_8_2_border_sun = borderSun;
                break;
            case "tile_8_3":
                tile_8_3_plant_name = plantName;
                tile_8_3_border_sun = borderSun;
                break;
            case "tile_8_4":
                tile_8_4_plant_name = plantName;
                tile_8_4_border_sun = borderSun;
                break;
            case "tile_8_5":
                tile_8_5_plant_name = plantName;
                tile_8_5_border_sun = borderSun;
                break;
            case "tile_8_6":
                tile_8_6_plant_name = plantName;
                tile_8_6_border_sun = borderSun;
                break;
        }
    }

}
