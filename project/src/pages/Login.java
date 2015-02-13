package pages;

import mainActivity.MainActivity;

import com.example.project.R;
import com.example.project.R.id;
import com.example.project.R.layout;
import com.example.project.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {
	EditText email;
	EditText Password;
	Button login;
	Button facebookLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		getActionBar().hide();
		setContentView(R.layout.activity_login);
		setOnclickListeners();
	}

	private void setOnclickListeners() {
		 login = (Button) findViewById(R.id.btLogin);
		 facebookLogin = (Button) findViewById(R.id.btLinkedinLogin);
		 login.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Intent intent = new Intent(Login.this, MainActivity.class);
	            	 startActivity(intent);
	             }
	         });
		 facebookLogin.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 // Perform action on click
             }
         });
	}
	
	
	
	


}
