package cat.bcn.apparca.agent.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
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
			Intent verifyCarIntent=new Intent(this, VerifyCarActivity.class);
			startActivity(verifyCarIntent);
		}
	}
}