package cat.bcn.apparca.agent.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;
import cat.bcn.apparca.agent.R;
/***
 * Main activity. Used as dashboard to access all options
 * @author sergi
 *
 */
public class MainActivity extends Activity implements OnClickListener {
    private LinearLayout optionVerifyCar;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        findViews();
        setListeners();
    }
    
    /***
     * Setups all pointers to views
     */
    private void findViews() {
    	optionVerifyCar=(LinearLayout) findViewById(R.id.VerifyCar);
    	
    }
    
    /***
     * Setups the appropiate listeners to this activity
     */
    private void setListeners() {
    	optionVerifyCar.setOnClickListener(this);
    }

	public void onClick(View v) {
		if (v.getId()==R.id.VerifyCar) {
			scanCode();

		}
	}
	
	public void scanCode() {
		Intent scanIntent = new Intent("com.google.zxing.client.android.SCAN");
		startActivityForResult(scanIntent, 0);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		// handle the scanned ID_car code
		
			if (resultCode == RESULT_OK) {
				String carId = intent.getStringExtra("SCAN_RESULT");
				Intent verifyCarIntent=new Intent(this, VerifyCarActivity.class);
				verifyCarIntent.putExtra(VerifyCarActivity.CAR_ID, carId);
				startActivity(verifyCarIntent);
			}
		
		
		
	}
}