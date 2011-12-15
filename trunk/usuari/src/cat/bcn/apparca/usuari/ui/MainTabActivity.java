package cat.bcn.apparca.usuari.ui;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import cat.bcn.apparca.usuari.Constants;
import cat.bcn.apparca.usuari.R;

public class MainTabActivity extends TabActivity {

	private final static String TAG = Constants.TAG;
	private final static String CLASS_NAME = MainTabActivity.class
			.getSimpleName() + " :: ";

	static private TabHost mTabHost;
	private Resources mResources;
	static private Activity startActivity = null;

	private int mPosition = 0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabhost);

		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		if (extras != null) {
			mPosition = extras.getInt(Constants.EXTRA_TAB_POSITION, 0);
		}
		Log.d(TAG, CLASS_NAME + "mPosition: " + mPosition);

		setupViews();
	}

	/**
	 * Load view elements
	 */
	private void setupViews() {
		mTabHost = getTabHost();
		mResources = getResources();
		// addTabMain();
		addTabProcess();
		addTabProfile();
		addTabInfo();
		mTabHost.setCurrentTab(mPosition);
	}

	private void addTabProcess() {
		Intent intent = new Intent(Constants.INTENT_PAY_ACTIVITY);
		String title = mResources.getString(R.string.geoposition);
		TabSpec spec = mTabHost.newTabSpec(title);
		spec.setIndicator(createTabView(this, R.drawable.ico_car));
		spec.setContent(intent);
		mTabHost.addTab(spec);
	}

	private void addTabProfile() {
		Intent intent = new Intent(Constants.INTENT_PROFILE);
		String title = mResources.getString(R.string.profile);
		TabSpec spec = mTabHost.newTabSpec(title);
		spec.setIndicator(createTabView(this, R.drawable.ico_micuenta));
		spec.setContent(intent);
		mTabHost.addTab(spec);
	}

	private void addTabInfo() {
		Intent intent = new Intent(Constants.INTENT_INFO);
		String title = mResources.getString(R.string.info);
		TabSpec spec = mTabHost.newTabSpec(title);
		spec.setIndicator(createTabView(this, R.drawable.ico_info));
		spec.setContent(intent);
		mTabHost.addTab(spec);
	}

	private View createTabView(final Context context, final int resourceId) {
		View view = LayoutInflater.from(context)
				.inflate(R.layout.tabs_bg, null);
		ImageView iv = (ImageView) view.findViewById(R.id.tab_icon);
		Drawable drawable = mResources.getDrawable(resourceId);
		iv.setImageDrawable(drawable);
		return view;
	}
}
