package pcamov01cv.sonidosanimales.view;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;

import pcamov01cv.sonidosanimales.R;

public class ActivityShareFacebook extends AppCompatActivity {
    CallbackManager callbackManager;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_facebook);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        showToolbar(getResources().getString(R.string.app_name), true);

        final String nombre = getIntent().getStringExtra("nombre");

        final String imagen = getIntent().getStringExtra("imagen");
        ImageView viewImage = (ImageView) findViewById(R.id.shareFoto);
        Picasso.with(this).load(imagen).into(viewImage);

        Button sonido = (Button) findViewById(R.id.shareSonido);
        sonido.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int sonido = getIntent().getIntExtra("sonido", 0);
                mediaPlayer = MediaPlayer.create(v.getContext(), sonido);
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
            }
        });

        Button compartir = (Button) findViewById(R.id.login_button);
        compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbackManager = CallbackManager.Factory.create();
                LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
                loginButton.setReadPermissions("email");
                loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }



    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
