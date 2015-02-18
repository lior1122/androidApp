package conferenceSelect;

import java.util.ArrayList;

import com.example.project.R;
import com.example.project.R.id;
import com.example.project.R.layout;

import utils.Utils;
import Params.Params;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class UserConferenceListView extends ListActivity {

	 private ListView listView;

	@Override
     protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 
	        // 1. pass context and data to the custom adapter
	        ConferenceAdapter adapter = new ConferenceAdapter(this, Utils.GetUserConference(Params.getUsersConferences()));
	 
	        //2. setListAdapter
	        setListAdapter(adapter);
         
	}
}
