package com.example.sendmessage.iu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sendmessage.R;
import com.example.sendmessage.data.pojo.Message;
import com.example.sendmessage.databinding.ActivitySendmessageBinding;

/**
 * Pide al usuario el nombre del destinatario y un mensaje a enviar
 *
 * @author Jose Manuel Relaño Valls
 * @version 1.0
 * @see android.app.Activity
 */
public class SendMessageActivity extends AppCompatActivity {

    private static final String TAG = "SendMessageProject";
    private ActivitySendmessageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySendmessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);


        //Método onClick para el botón y recoger el dato con un evento creado en una clase anónima o delegado que escuchará la petición
        //Con esto le digo al bnoton que cuando se haga click sobre él delega a la clase que tiene un evento que avisará al botón.
        /*binding.btSend.setOnClickListener(view -> {
            sendMessage();
        });*/
        Log.d(TAG, "SendMessageActivity -> onCreateC()");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_about)
            showAboutUs(); {
            return true;
        }
    }

    /*
    Este método inicia la activity AboutUs, es un Intent explícito.
    * */
    private void showAboutUs() {
        Intent intent = new Intent(this, AboutUsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, "SendMessageActivity -> onResume()");
    }


    //region Métodos del ciclo de la vida

    @Override
    protected void onStart() {
        super.onStart();
        //Ciclo de vida de las activities
        Log.i(TAG, "SendMessageActivity -> onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMessageActivity -> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "SendMessageActivity -> onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "SendMessageActivity -> onDestroy()");
    }
    //endregion

    /*Este método es el que utilizamos en la propiedad
     *android:onClick dentro del componente Button btSend
     * @param view
     */
    public void getOnclick(View view) {
        switch (view.getId()) {
            case R.id.btSend:
                sendMessage();
                break;
            case R.id.action_about:
                break;

        }
    }

    /*
     *Este método crea el Intent con los datos que pasa la actividad SendActivity a ViewActivity
     */
    private void sendMessage() {
        //1.1.-Contenedor o Bundle para añadir los datos.
        Bundle bundle = new Bundle();
        bundle.putString("user", binding.edUser.getText().toString());
        bundle.putString("message", binding.edMessage.getText().toString());

        //1.1.1.-Ejemplo con dos variables String
        //bundle.putString("user", binding.edUSer).getText().toString)
        //bundle.putString("message", binding.edMessage).getText().toString)

        //1.1.2.-Ejemplo con la clase messaje pojo
        Message message = new Message();
        message.setUser(binding.edUser.getText().toString());
        message.setMessage(binding.edMessage.getText().toString());
        bundle.putSerializable("message", (message));

        //1.2.- Se crea el mensaje o Intent explícito ya que se conoce la Actividad origen y la de destino
        Intent intent = new Intent(this, ViewMessageActivity.class);
        intent.putExtras(bundle);
        //Entra en el ciclo de vida de la activity.
        startActivity(intent);
    }

}