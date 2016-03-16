package online.dsic.l0604_materialdesign.activities;

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

import online.dsic.l0604_materialdesign.R;
import online.dsic.l0604_materialdesign.adapters.CustomRecyclerAdapter;
import online.dsic.l0604_materialdesign.pojo.Item;

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

    CoordinatorLayout coordinator;
    RecyclerView recycler;
    ArrayList<Item> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        coordinator = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        recycler = (RecyclerView) findViewById(R.id.recycler);

        RecyclerView.LayoutManager manager = null;
        switch (getIntent().getIntExtra("mode", MainActivity.LINEAR_VERTICAL)) {
            case MainActivity.LINEAR_VERTICAL:
                manager = new LinearLayoutManager(this);
                break;
            case MainActivity.LINEAR_HORIZONTAL:
                manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
                break;
            case MainActivity.GRID_VERTICAL:
                manager = new GridLayoutManager(this, 2);
                break;
            case MainActivity.GRID_HORIZONTAL:
                manager = new GridLayoutManager(this, 4, GridLayoutManager.HORIZONTAL, false);
                break;
            case MainActivity.STAGGERED_VERTICAL:
                manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                break;
            case MainActivity.STAGGERED_HORIZONTAL:
                manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL);
                break;
        }
        recycler.setLayoutManager(manager);

        data = generateData();
        CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(data, new CustomRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(int position) {
                Snackbar.make(coordinator, data.get(position).getText(), Snackbar.LENGTH_SHORT).show();
            }
        });
        recycler.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabMessage);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(coordinator, R.string.message, Snackbar.LENGTH_INDEFINITE);
                snackbar.setAction(R.string.message, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        recycler.smoothScrollToPosition(0);
                    }
                });
                snackbar.show();
            }
        });

    }

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
