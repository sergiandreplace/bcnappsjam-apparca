package cat.bcn.apparca.usuari.map;

import cat.bcn.apparca.usuari.R;

import com.google.android.maps.GeoPoint;

import es.tempos21.android.mapslibrary.overlays.T21AOverlayItem;

public class Parquimeter implements T21AOverlayItem {
	
	private final static int MAP_PIN = R.drawable.map_pin;
	
	private double mLatitude;
	private double mLongitude;
	private String mAddress;
	
	public Parquimeter() {
	}

	public double getLatitude() {
		return mLatitude;
	}

	public void setLatitude(double latitude) {
		this.mLatitude = latitude;
	}

	public double getLongitude() {
		return mLongitude;
	}

	public void setLongitude(double longitude) {
		this.mLongitude = longitude;
	}

	public String getAddress() {
		return mAddress;
	}

	public void setAddress(String address) {
		this.mAddress = address;
	}
	
	public int getMarkerId() {
		return MAP_PIN;
	}
	
	public GeoPoint getPoint() {
		return new GeoPoint((int) (mLatitude * 1E6), (int) (mLongitude * 1E6));
	}
	
}
