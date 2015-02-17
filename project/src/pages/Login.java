package pages;

import com.example.project.R;

import conferenceSelect.UserConferenceListView;
import DB.Queries;
import Params.Params;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {
	EditText email;
	Button login;
	Button btLinkdinLogin;
	EditText etEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		getActionBar().hide();
		setContentView(R.layout.activity_login);
		setOnclickListeners();
		etEmail = (EditText)findViewById(R.id.ETemail);  
	}

	private void setOnclickListeners() {
		 login = (Button) findViewById(R.id.btLogin);
		 btLinkdinLogin = (Button) findViewById(R.id.btLinkedinLogin);
		 
		 login.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Params.setUsersConferences(Queries.GetAllUserConferences(etEmail.getText().toString()));
	            	 Intent intent = new Intent(Login.this, UserConferenceListView.class);
	            	 startActivity(intent);
	             }
	         });
		 btLinkdinLogin.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 // Perform action on click
             }
         });
	}
	
	
	
	


}
