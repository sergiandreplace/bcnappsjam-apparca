package cat.bcn.apparca.agent.ui;

import cat.bcn.apparca.agent.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class VerifyCarActivity extends Activity {

	private boolean isScanned = false;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		findViews();
		setListeners();
		scanCode();

	}

	/***
	 * Setups all pointers to views
	 */
	private void findViews() {

	}

	/***
	 * Setups the appropiate listeners to this activity
	 */
	private void setListeners() {

	}

	public void onClick(View v) {
		if (v.getId() == R.id.VerifyCar) {

		}
	}

	public void scanCode() {
		Intent intent = new Intent("com.google.zxing.client.android.SCAN");
		startActivityForResult(intent, 0);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		// handle the scanned ID_car code
		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				String carId = intent.getStringExtra("SCAN_RESULT");
				Toast.makeText(this, carId, Toast.LENGTH_LONG).show();

			}
		}
	}
}
