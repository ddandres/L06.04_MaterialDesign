/*
 * Copyright (c) 2016. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.dadm.l0604_materialdesign.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import labs.dadm.l0604_materialdesign.R;

/**
 * Gives access to an activity showing a RecyclerView with different LayoutManager.
 */
public class MainActivity extends AppCompatActivity {

    // Constants used to determine how to display the View on the RecyclerView
    public static final int LINEAR_VERTICAL = 0;
    public static final int LINEAR_HORIZONTAL = 1;
    public static final int GRID_VERTICAL = 2;
    public static final int GRID_HORIZONTAL = 3;
    public static final int STAGGERED_VERTICAL = 4;
    public static final int STAGGERED_HORIZONTAL = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Starts the activity with different configurations.
     */
    public void buttonClicked(View view) {

        Intent intent = new Intent(this, RecyclerViewActivity.class);
        // Determine what to do depending on the Button clicked
        switch (view.getId()) {

            // LinearLayoutManager, vertical scroll
            case R.id.bLinearVertical:
                intent.putExtra("mode", LINEAR_VERTICAL);
                break;

            // LinearLayoutManager, horizontal scroll
            case R.id.bLinearHorizontal:
                intent.putExtra("mode", LINEAR_HORIZONTAL);
                break;

            // GridLayoutManager, vertical scroll
            case R.id.bGridVertical:
                intent.putExtra("mode", GRID_VERTICAL);
                break;

            // GridLayoutManager, horizontal scroll
            case R.id.bGridHorizontal:
                intent.putExtra("mode", GRID_HORIZONTAL);
                break;

            // StaggeredGridLayoutManager, vertical scroll
            case R.id.bStaggeredVertical:
                intent.putExtra("mode", STAGGERED_VERTICAL);
                break;

            // StaggeredGridLayoutManager, horizontal scroll
            case R.id.bStaggeredHorizontal:
                intent.putExtra("mode", STAGGERED_HORIZONTAL);
                break;
        }
        // Launch the activity containing the RecyclerView
        startActivity(intent);
    }
}
