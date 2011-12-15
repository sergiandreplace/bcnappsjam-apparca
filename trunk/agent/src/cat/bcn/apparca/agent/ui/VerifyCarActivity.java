package cat.bcn.apparca.agent.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cat.bcn.apparca.agent.R;
import cat.bcn.apparca.agent.bean.Car;
import cat.bcn.apparca.agent.data.CarsModel;

public class VerifyCarActivity extends Activity {

	public static final String CAR_ID = "Car_id";
	private Car car;
	private ImageView carPhoto;
	private TextView carBrand;
	private TextView carModel;
	private TextView carColor;
	private TextView wrongBox;
	private TextView okBox;

/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.verify_car);
		findViews();
		setListeners();
		getData();
		setData();

	}

	/***
	 * Setups all pointers to views
	 */
	private void findViews() {
		carPhoto=(ImageView) findViewById(R.id.carPhoto);
		carBrand=(TextView) findViewById(R.id.carBrand);
		carModel=(TextView) findViewById(R.id.carModel);
		carColor=(TextView) findViewById(R.id.carColor);
		wrongBox=(TextView) findViewById(R.id.wrongBox);
		okBox=(TextView) findViewById(R.id.okBox);
	}

	/***
	 * Setups the appropiate listeners to this activity
	 */
	private void setListeners() {

	}


	private void getData() {
		CarsModel carsModel=new CarsModel(this);
		car=carsModel.getCar(Integer.parseInt(getIntent().getExtras().getString(CAR_ID)));
	}
	
	private void setData() {
		carPhoto.setImageDrawable(car.getPhoto());
		carBrand.setText(car.getBrand());
		carModel.setText(car.getModel());
		carColor.setText(car.getColor());
		if (car.getId()>1) {
			wrongBox.setVisibility(View.VISIBLE);
			okBox.setVisibility(View.GONE);
		}else{
			wrongBox.setVisibility(View.GONE);
			okBox.setVisibility(View.VISIBLE);
		}
	}
	
}
