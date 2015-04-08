package pages;

import java.util.EnumSet;

import server.GetUserParams;
import linkdin.Constants;

import com.example.project.R;
import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthService;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceFactory;
import com.google.code.linkedinapi.client.oauth.LinkedInRequestToken;
import com.google.code.linkedinapi.schema.Person;

import Params.User;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {
	private Button login;
	private Button btLinkdinLogin;
	private EditText etEmail;
	private ProgressDialog dialog;
	private LinkedInOAuthService oAuthService;
	private LinkedInApiClientFactory factory;
	private LinkedInRequestToken liToken;
	private LinkedInApiClient client;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		getActionBar().hide();
		setContentView(R.layout.activity_login);
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		setOnclickListeners();
		etEmail = (EditText)findViewById(R.id.ETemail); 
		dialog = new ProgressDialog(this);
	}

	private void setOnclickListeners() {
		 login = (Button) findViewById(R.id.btLogin);
		 btLinkdinLogin = (Button) findViewById(R.id.btLinkedinLogin);
		 
		 login.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	                 dialog.setMessage("Connecting. Please wait.");
	                 dialog.show();

					new GetUserParams(Login.this).execute(etEmail.getText().toString());

	             }
	         });
		 
		 
		 btLinkdinLogin.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
            	 setLinkdinApi();
             }
         });
	}
	
	
	private void setLinkdinApi(){
        oAuthService = LinkedInOAuthServiceFactory.getInstance().createLinkedInOAuthService(Constants.CONSUMER_KEY,Constants.CONSUMER_SECRET);
        factory = LinkedInApiClientFactory.newInstance(Constants.CONSUMER_KEY, Constants.CONSUMER_SECRET);
        liToken = oAuthService.getOAuthRequestToken(Constants.OAUTH_CALLBACK_URL);
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(liToken.getAuthorizationUrl()));
        startActivity(i);
 
	}
	
	@Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        String verifier = intent.getData().getQueryParameter("oauth_verifier");

        LinkedInAccessToken accessToken = oAuthService.getOAuthAccessToken(liToken, verifier);
            client = factory.createLinkedInApiClient(accessToken);
        // Now you can access login person profile details...

        Person profile = client.getProfileForCurrentUser(EnumSet.of(ProfileField.ID, ProfileField.FIRST_NAME,ProfileField.LAST_NAME, ProfileField.HEADLINE,ProfileField.PICTURE_URL));
        User.setUserParams(profile.getFirstName(), profile.getLastName(), profile.getHeadline(), profile.getPictureUrl());
        
      

    }
	
    public void StopDialog() {
        dialog.dismiss();
    }

    public void StopDialogWithError(String string) {
        StopDialog();
        showErrorDialog(string);
    }
    
    private void showErrorDialog(final String msg) {
        this.runOnUiThread((Runnable)new Runnable(){

            public void run() {
            	AlertDialog.Builder alertDialog = new AlertDialog.Builder(
            	        Login.this);
            	alertDialog.setTitle("Error");
            	alertDialog.setMessage(msg);
            	alertDialog.setPositiveButton("OK",
            	        new DialogInterface.OnClickListener() {
            	            public void onClick(DialogInterface dialog, int which) {
            	            }
            	        });
            	alertDialog.show();

            	
            }

        });
    }
	

}
