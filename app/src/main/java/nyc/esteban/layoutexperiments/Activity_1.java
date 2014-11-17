package nyc.esteban.layoutexperiments;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;


public class Activity_1 extends Activity {
    LinearLayout left_layout;
    LinearLayout right_layout;
    TextView left_current_weight;
    TextView right_current_weight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_1);

        left_layout = (LinearLayout)findViewById(R.id.leftLayout);
        right_layout = (LinearLayout)findViewById(R.id.rightLayout);


        left_current_weight = (TextView)findViewById(R.id.left_current_weight);
        right_current_weight= (TextView)findViewById(R.id.right_current_weight);

        SeekBar bar = (SeekBar)findViewById(R.id.seekBar_weight);
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            long left_weight;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            long left_weight = (seekBar.getProgress())/10;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


                Float left = seekBar.getProgress()/10F;
                Float right = (100 - seekBar.getProgress())/10F;
                Log.d("LayoutExperiments", "Left weight: "+ left + " Right weight: " + right );
                setLayoutWeights(left, right);
                left_current_weight.setText(""+left);
                right_current_weight.setText(""+ right);


            }
        });
    }

   public void setLayoutWeights(Float left, Float right){

       LinearLayout.LayoutParams left_params = new LinearLayout.LayoutParams(
               LinearLayout.LayoutParams.WRAP_CONTENT,
               LinearLayout.LayoutParams.MATCH_PARENT,
               left
       );
       left_layout.setLayoutParams(left_params);

       LinearLayout.LayoutParams right_params = new LinearLayout.LayoutParams(
               LinearLayout.LayoutParams.WRAP_CONTENT,
               LinearLayout.LayoutParams.MATCH_PARENT,
               right
       );
       right_layout.setLayoutParams(right_params);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
