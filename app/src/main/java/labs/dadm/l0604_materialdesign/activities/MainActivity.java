/*
 * Copyright (c) 2016. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.dadm.l0604_materialdesign.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import labs.dadm.l0604_materialdesign.R;

// Gives access to an activity showing a RecyclerView with different LayoutManager.
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

        View.OnClickListener listener = v -> buttonClicked(v.getId());
        findViewById(R.id.bLinearVertical).setOnClickListener(listener);
        findViewById(R.id.bLinearHorizontal).setOnClickListener(listener);
        findViewById(R.id.bGridVertical).setOnClickListener(listener);
        findViewById(R.id.bGridHorizontal).setOnClickListener(listener);
        findViewById(R.id.bStaggeredVertical).setOnClickListener(listener);
        findViewById(R.id.bStaggeredHorizontal).setOnClickListener(listener);
    }

    // Starts the activity with different configurations.
    public void buttonClicked(int clickedButton) {

        Intent intent = new Intent(this, RecyclerViewActivity.class);
        // Determine what to do depending on the Button clicked
        if (clickedButton == R.id.bLinearVertical) {
            // LinearLayoutManager, vertical scroll
            intent.putExtra("mode", LINEAR_VERTICAL);
        } else if (clickedButton == R.id.bLinearHorizontal) {
            // LinearLayoutManager, horizontal scroll
            intent.putExtra("mode", LINEAR_HORIZONTAL);
        } else if (clickedButton == R.id.bGridVertical) {
            // GridLayoutManager, vertical scroll
            intent.putExtra("mode", GRID_VERTICAL);
        } else if (clickedButton == R.id.bGridHorizontal) {
            // GridLayoutManager, horizontal scroll
            intent.putExtra("mode", GRID_HORIZONTAL);
        } else if (clickedButton == R.id.bStaggeredVertical) {
            // StaggeredGridLayoutManager, vertical scroll
            intent.putExtra("mode", STAGGERED_VERTICAL);
        } else if (clickedButton == R.id.bStaggeredHorizontal) {
            // StaggeredGridLayoutManager, horizontal scroll
            intent.putExtra("mode", STAGGERED_HORIZONTAL);
        }
        // Launch the activity containing the RecyclerView
        startActivity(intent);
    }
}
