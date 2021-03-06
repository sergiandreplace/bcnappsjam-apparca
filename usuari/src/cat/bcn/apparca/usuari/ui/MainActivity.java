package cat.bcn.apparca.usuari.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import cat.bcn.apparca.usuari.Constants;
import cat.bcn.apparca.usuari.R;

public class MainActivity extends Activity {

	private LinearLayout btStartProcess;
	private LinearLayout btStartInfo;
	private LinearLayout btStartProfile;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		setupViews();
	}

	/**
	 * Load view elements
	 */
	private void setupViews() {
		btStartProcess = (LinearLayout) findViewById(R.id.btStartProcess);
		btStartInfo = (LinearLayout) findViewById(R.id.btStartInfo);
		btStartProfile = (LinearLayout) findViewById(R.id.btStartProfile);
		btStartProcess.setOnClickListener(startListener);
		btStartInfo.setOnClickListener(infoListener);
		btStartProfile.setOnClickListener(profileListener);
	}

	private OnClickListener startListener = new OnClickListener() {

		public void onClick(View v) {
			startWorkflow(Constants.TAB_PROCESS);
		}
	};

	private OnClickListener infoListener = new OnClickListener() {

		public void onClick(View v) {
			startWorkflow(Constants.TAB_INFO);
		}
	};

	private OnClickListener profileListener = new OnClickListener() {

		public void onClick(View v) {
			startWorkflow(Constants.TAB_PROFILE);
		}
	};

	private void startWorkflow(int position) {
		Intent intent = new Intent(Constants.INTENT_MAIN_ACTIVITY);
		intent.putExtra(Constants.EXTRA_TAB_POSITION, position);
		// startActivityForResult(intent, requestCode);
		startActivity(intent);
	}
}