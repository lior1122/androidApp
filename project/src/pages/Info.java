package pages;

import com.example.project.R;
import com.example.project.R.layout;

import Params.Conference;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

public class Info extends Fragment {
	
	private TextView wellcome;
	private WebView map;
	 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		View view = inflater.inflate(R.layout.info, container, false);

		wellcome = (TextView) view.findViewById(R.id.tvWellcom);
		map.loadUrl("http://maps.googleapis.com/maps/api/staticmap?ll=36.97,%20-122&lci=bike&z=13&t=p&size=500x500&sensor=true");
		return view;

	}
 
}