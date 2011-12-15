package cat.bcn.apparca.usuari.ui;

import android.os.Bundle;
import cat.bcn.apparca.usuari.R;
import cat.bcn.apparca.usuari.map.Parquimeter;
import cat.bcn.apparca.usuari.map.ParquimeterBalloonAdapter;

import com.google.android.maps.MapView;

import es.tempos21.android.mapslibrary.activity.T21MapActivity;
import es.tempos21.android.mapslibrary.location.T21LocationProvider;
import es.tempos21.android.mapslibrary.location.T21LocationProvider.OnLocationUpdateListener;
import es.tempos21.android.mapslibrary.overlays.T21BalloonBaseAdapter;
import es.tempos21.android.mapslibrary.overlays.T21ItemizedOverlay.ITEMS_FADING_LEVEL;
import es.tempos21.android.mapslibrary.overlays.T21ItemsManager;
import es.tempos21.android.mapslibrary.utils.T21MapsUtils;

public class ApparcaMapActivity extends T21MapActivity<Parquimeter> implements OnLocationUpdateListener  {
    
	private MapView mMapView;
	private T21LocationProvider mLocationProvider;
	private T21ItemsManager<T21BalloonBaseAdapter<Parquimeter>> mItemsManager;
	private ParquimeterBalloonAdapter mBalloonAdapter;
	
	private boolean mIsFirstLocationUpdate = true;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);
        
        mMapView = (MapView) findViewById(R.id.mapview);
        setMapView(mMapView);
    }

	@SuppressWarnings("unchecked")
	@Override
	protected void onStart() {
		super.onStart();
		
		if (mLocationProvider == null) {
        	mLocationProvider = T21LocationProvider.getInstance();
        }
        
		if (mBalloonAdapter == null) {
			mBalloonAdapter = new ParquimeterBalloonAdapter(this);
		}
		
        if (mItemsManager == null) {
        	mItemsManager = getItemsManager();
        	mItemsManager.setFadingEffectLevel(ITEMS_FADING_LEVEL.FADE_ALPHA_SIZE);
        	mItemsManager.setBallonViewAdapter(mBalloonAdapter);
        	
        	getParquimeters();
        }
        
		mLocationProvider.requestLocationUpdates(this, this, R.drawable.location_pin);
	}
	
	private void getParquimeters() {
		final String[] latitudes = getResources().getStringArray(R.array.latitudes);
		final String[] longitudes = getResources().getStringArray(R.array.longitudes);
		final String[] addresses = getResources().getStringArray(R.array.addresses);
		
		final int count = Math.min(latitudes.length, longitudes.length);
		Parquimeter p = null;
		for (int i = 0; i < count; i++) {
			p = new Parquimeter();
			
			p.setLatitude(Double.parseDouble(latitudes[i]));
			p.setLongitude(Double.parseDouble(longitudes[i]));
			p.setAddress(addresses[i]);
			mItemsManager.addItem(p);
		}
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		
		mLocationProvider.stopLocationUpdates();
	}

	public void onLocationUpdate() {
		updateMyLocation();
		
		if (mIsFirstLocationUpdate) {
			mIsFirstLocationUpdate = false;
			mMapView.getController().setZoom(17);
			mMapView.getController().animateTo(T21MapsUtils.getGeoPointFromLocation(mLocationProvider.getLastLocation()));
		}
	}

	@Override
	public void onBalloonClick(Parquimeter item) {
		super.onBalloonClick(item);
	}

	@Override
	public void onItemClick(Parquimeter item) {
		super.onItemClick(item);
	}
	
	
}