package cat.bcn.apparca.usuari.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import cat.bcn.apparca.usuari.R;

public class PayActivity extends Activity  {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_layout);
    }

	@Override
	protected void onStart() {
		super.onStart();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
	}
	
	public void onClick(View v) {
		findViewById(R.id.pay_linear1).setVisibility(View.GONE);
		findViewById(R.id.pay_linear2).setVisibility(View.VISIBLE);
	}

}