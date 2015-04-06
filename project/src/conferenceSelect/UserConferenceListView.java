package conferenceSelect;

import java.util.ArrayList;

import mainActivity.MainActivity;
import pages.Info;
import pages.Login;

import com.example.project.R;

import server.API;
import utils.Utils;
import Params.Conference;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class UserConferenceListView extends ListActivity {

	ArrayList<ConferenceItem> userConferences;

	@Override
     protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 	userConferences = Utils.GetUserConference(Conference.getUserConferences());
	         //1. pass context and data to the custom adapter
	        ConferenceAdapter adapter = new ConferenceAdapter(this, userConferences );
	        setListAdapter(adapter);
	        
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(),"Connecting To: " + userConferences.get(position).getLabel() , Toast.LENGTH_LONG).show();
		Conference.SetConference(API.GetConferenceInfo(userConferences.get(position).getId()));
   	 	Intent intent = new Intent(UserConferenceListView.this, MainActivity.class);
   	 	startActivity(intent);
		super.onListItemClick(l, v, position, id);
	}
}
