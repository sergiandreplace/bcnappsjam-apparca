package cat.bcn.apparca.usuari.map;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import cat.bcn.apparca.usuari.R;
import es.tempos21.android.mapslibrary.overlays.T21BalloonBaseAdapter;

public class ParquimeterBalloonAdapter extends
		T21BalloonBaseAdapter<Parquimeter> {

	public ParquimeterBalloonAdapter(Context context) {
		super(context, R.layout.parquimeter_balloon);
	}

	@Override
	protected View getBalloonView(View v, Parquimeter p) {
		TextView address = (TextView) v.findViewById(R.id.address);
		address.setText(p.getAddress());
		setUpCloseButton(v);

		return v;
	}

	/**
	 * Sets up the close button of the balloon.
	 * 
	 * @param view
	 *            The balloon view.
	 */
	private void setUpCloseButton(View view) {
		ImageButton close = (ImageButton) view.findViewById(R.id.close);
		close.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				closeBalloon();
			}
		});
	}
}
