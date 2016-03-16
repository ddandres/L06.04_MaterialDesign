package online.dsic.l0604_materialdesign.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import online.dsic.l0604_materialdesign.R;

/**
 *
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
     * Determine
     */
    public void buttonClicked(View view) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        switch(view.getId()) {
            case R.id.bLinearVertical:
                intent.putExtra("mode", LINEAR_VERTICAL);
                break;
            case R.id.bLinearHorizontal:
                intent.putExtra("mode", LINEAR_HORIZONTAL);
                break;
            case R.id.bGridVertical:
                intent.putExtra("mode", GRID_VERTICAL);
                break;
            case R.id.bGridHorizontal:
                intent.putExtra("mode", GRID_HORIZONTAL);
                break;
            case R.id.bStaggeredVertical:
                intent.putExtra("mode", STAGGERED_VERTICAL);
                break;
            case R.id.bStaggeredHorizontal:
                intent.putExtra("mode", STAGGERED_HORIZONTAL);
                break;
        }
        startActivity(intent);
    }
}
