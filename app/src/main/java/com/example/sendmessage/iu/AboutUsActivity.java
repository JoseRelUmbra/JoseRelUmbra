package com.example.sendmessage.iu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.sendmessage.R;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class AboutUsActivity extends AppCompatActivity {
    private static final String TAG = "SendMessageProject";
    private AboutUsActivity binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AboutView view = AboutBuilder.with(this)
                .setPhoto(R.mipmap.profile_picture)
                .setCover(R.mipmap.profile_cover)
                .setName("Jose Manuel Relaño Valls")
                .setSubTitle("Mobile Developer")
                .setBrief("I'm warmed of mobile technologies. Ideas maker, curious and nature lover.")
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                //.addGooglePlayStoreLink("8002078663318221363")
                .addGitHubLink("Error")
                //.addFacebookLink("user")
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();

        setContentView(view);
        Log.i(TAG, "AboutUsActivity -> onCreate()");
    }
    //region Métodos del ciclo de la vida

    @Override
    protected void onStart() {
        super.onStart();
        //Ciclo de vida de las activities
        Log.i(TAG, "AboutUsActivity -> onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "AboutUsActivity -> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "AboutUsActivity -> onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "AboutUsActivity -> onDestroy()");
    }

    //endregion
}