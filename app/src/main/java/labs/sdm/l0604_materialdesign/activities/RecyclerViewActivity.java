/*
 * Copyright (c) 2016. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.sdm.l0604_materialdesign.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import labs.sdm.l0604_materialdesign.R;
import labs.sdm.l0604_materialdesign.adapters.CustomRecyclerAdapter;
import labs.sdm.l0604_materialdesign.pojo.Item;

/**
 * Displays a list of custom Items using different elements from Material Design:
 *   FloatingActionButton just displays a SnackBar with an associated action,
 *   which scrolls the list to the first element.
 *   CoordinatorLayout coordinates the FloatingActionButton and SnackBar,
 *   so they do not overlap and the SnackBar can be dismissed by swiping.
 *   Items are represented by CardView.
 *   RecyclerView displays an ArrayList<Item> as a vertical/horizontal Linear/Grid/StaggeredGridLayout.
 */
public class RecyclerViewActivity extends AppCompatActivity {

    // Hold references to View objects
    CoordinatorLayout coordinator;
    RecyclerView recycler;
    // Data source to be displayed
    ArrayList<Item> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        // Get a reference to the custom ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        // Replace the default ActionBar (there should be none) by this ToolBar
        setSupportActionBar(toolbar);

        // Get a reference to the CoordinatorLayout
        coordinator = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        // Get a reference to the RecyclerView
        recycler = (RecyclerView) findViewById(R.id.recycler);

        // Create and set the LayoutManager according to user's selection
        RecyclerView.LayoutManager manager = null;
        // Information about the required LayoutManager is sent as an Extra within the Intent
        switch (getIntent().getIntExtra("mode", MainActivity.LINEAR_VERTICAL)) {

            // LinearLayout, vertical scroll
            case MainActivity.LINEAR_VERTICAL:
                manager = new LinearLayoutManager(this);
                break;

            // LinearLayout, horiontal scroll
            case MainActivity.LINEAR_HORIZONTAL:
                manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
                break;

            // GridLayout, vertical scroll, 2 columns
            case MainActivity.GRID_VERTICAL:
                manager = new GridLayoutManager(this, 2);
                break;

            // GridLayout, horizontal scroll, 4 rows
            case MainActivity.GRID_HORIZONTAL:
                manager = new GridLayoutManager(this, 4, GridLayoutManager.HORIZONTAL, false);
                break;

            // StaggeredGridLayout, vertical scroll, 2 columns
            case MainActivity.STAGGERED_VERTICAL:
                manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                break;

            // StaggeredGridLayout, horizontal scroll, 3 rows
            case MainActivity.STAGGERED_HORIZONTAL:
                manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL);
                break;
        }
        // Associate the LayoutManager to the RecyclerView
        recycler.setLayoutManager(manager);

        // Populate the data source with data (done by code)
        data = generateData();
        /**
         * Create a custom adapter to associate the data source to the View in charge of displaying them.
         * This particular constructor takes also an onClickListener as a parameter,
         * to react to clicks on RecyclerViews items.
         */
        CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(data, new CustomRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(int position) {
                Snackbar.make(coordinator, data.get(position).getText(), Snackbar.LENGTH_SHORT).show();
            }
        });
        // Assciate the adapter to the RecyclerView
        recycler.setAdapter(adapter);

        // Get a reference to the FloatingActionButton
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabMessage);
        // Clicking the FAB just displays a notification to the user
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a SnackBar to display the notification
                Snackbar snackbar = Snackbar.make(coordinator, R.string.message, Snackbar.LENGTH_INDEFINITE);
                // Associate an action to the SnackBar
                snackbar.setAction(R.string.message, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Scrolls to the first position of the RecyclerView
                        recycler.smoothScrollToPosition(0);
                    }
                });
                // Display the SnackBar
                snackbar.show();
            }
        });

    }

    /**
     * Populates an ArrayList<Item> with elements to be displayed on the RecyclerView.
     */
    private ArrayList<Item> generateData() {
        ArrayList<Item> result = new ArrayList<>();
        result.add(new Item("Add", android.R.drawable.ic_menu_add));
        result.add(new Item("Call", android.R.drawable.ic_menu_call));
        result.add(new Item("Camera", android.R.drawable.ic_menu_camera));
        result.add(new Item("Delete", android.R.drawable.ic_menu_delete));
        result.add(new Item("Edit", android.R.drawable.ic_menu_edit));
        result.add(new Item("Gallery", android.R.drawable.ic_menu_gallery));
        result.add(new Item("Compass", android.R.drawable.ic_menu_compass));
        result.add(new Item("Help", android.R.drawable.ic_menu_help));
        result.add(new Item("My Location", android.R.drawable.ic_menu_mylocation));
        result.add(new Item("Preferences", android.R.drawable.ic_menu_preferences));
        result.add(new Item("Rotate", android.R.drawable.ic_menu_rotate));
        result.add(new Item("Save", android.R.drawable.ic_menu_save));
        result.add(new Item("Search", android.R.drawable.ic_menu_search));
        result.add(new Item("Share", android.R.drawable.ic_menu_share));
        result.add(new Item("Upload", android.R.drawable.ic_menu_upload));
        result.add(new Item("View", android.R.drawable.ic_menu_view));
        result.add(new Item("Zoom", android.R.drawable.ic_menu_zoom));
        result.add(new Item("More", android.R.drawable.ic_menu_more));
        result.add(new Item("Sort by Size", android.R.drawable.ic_menu_sort_by_size));
        result.add(new Item("Recent History", android.R.drawable.ic_menu_recent_history));
        result.add(new Item("My Places", android.R.drawable.ic_menu_myplaces));
        result.add(new Item("Map Mode", android.R.drawable.ic_menu_mapmode));
        result.add(new Item("Revert", android.R.drawable.ic_menu_revert));
        result.add(new Item("Slideshow", android.R.drawable.ic_menu_slideshow));
        result.add(new Item("Sort Alphabetically", android.R.drawable.ic_menu_sort_alphabetically));
        result.add(new Item("Send", android.R.drawable.ic_menu_send));
        return result;
    }

}