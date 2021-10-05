package com.example.sendmessage.iu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sendmessage.data.pojo.Message;
import com.example.sendmessage.databinding.ActivityViewMessageBinding;

public class ViewMessageActivity extends AppCompatActivity {

    private ActivityViewMessageBinding binding;
    private static final String TAG = "SendMessageProject";
    private static String mensj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //1.-Recoger el Intent que nos ha enviado la Activity SendMessageActivity
        Intent intent = getIntent();
        //2.- Recoger el objeto Bundle con el mismo método que se ha introducido en el Intent
        Bundle bundle = intent.getExtras();
        //3.-Asignar cada cadena a sus componentes
        binding.tvParaQuien.setText("Destinatario: "+bundle.getString("user"));
        binding.tvDescripcion.setText(bundle.getString("message"));
        Log.i(TAG, "ViewMessageActivity -> onCreate()");

        //4.- Recoger objeto.
        Intent intent1 = getIntent();
        Bundle bundle1 = intent1.getExtras();
        //Desserializar
        Message msj = (Message) bundle1.getSerializable("message");
        binding.msjRecibido.setText("mensaje: " + msj.getMessage());

    }

    //region Métodos del ciclo de la vida

    @Override
    protected void onStart() {
        super.onStart();
        //Ciclo de vida de las activities
        Log.i(TAG, "ViewMessageActivity -> onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ViewMessageActivity -> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "ViewMessageActivity -> onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "ViewMessageActivity -> onDestroy()");
    }

    //endregion
}