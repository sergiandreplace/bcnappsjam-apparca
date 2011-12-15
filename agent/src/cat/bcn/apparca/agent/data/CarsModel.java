package cat.bcn.apparca.agent.data;

import android.content.Context;
import cat.bcn.apparca.agent.R;
import cat.bcn.apparca.agent.bean.Car;
import cat.bcn.apparca.agent.bean.Cars;

public class CarsModel {
	
	private static Cars cars;
	private Context context;
	
	public CarsModel (Context context) {
		this.context=context;
		
		cars=new Cars();
		cars.add(new Car(1, "vermell", "7445-BCN","Seat","León",context.getResources().getDrawable(R.drawable.seatleon)));
		cars.add(new Car(2, "blau", "6743-MDR","Seat","1500",context.getResources().getDrawable(R.drawable.seat1500)));
		cars.add(new Car(3, "gris", "8232-SVL", "Citröen", "Xsara Picasso", context.getResources().getDrawable(R.drawable.picasso)));
		
	}
	
	public  Cars getCars() {
		return cars; 
	}
	
	public Car getCar(int id) {
		Car foundCar = null;
		for (Car car:cars) {
			if (car.getId()==id) {
				foundCar=car;
			}
		}
		return foundCar;
	}
}
