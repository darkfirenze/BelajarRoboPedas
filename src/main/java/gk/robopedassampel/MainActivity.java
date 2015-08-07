package gk.robopedassampel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import gk.robopedassampel.jaringan.SpiceRetrofitServis;
import gk.robopedassampel.jaringan.StrRetrofitSpiceRequest;

public class MainActivity extends AppCompatActivity {



    private SpiceManager pedasmanager = new SpiceManager(SpiceRetrofitServis.class);

    private StrRetrofitSpiceRequest rekuesString;

    private TextView tekshasil;
    private Button tombolpedas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rekuesString = new StrRetrofitSpiceRequest("ambil awalan");

        tekshasil = (TextView) findViewById(R.id.tekshasil);
        tombolpedas = (Button) findViewById(R.id.tombolpedas);
        tombolpedas.setOnClickListener(listenerpedas);



    }


    @Override
    protected void onStart() {
        super.onStart();

        pedasmanager.start(MainActivity.this);

    }


    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        pedasmanager.shouldStop();
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

        return super.onOptionsItemSelected(item);
    }




    private class ListenerPermintaan implements RequestListener<String> {


        @Override
        public void onRequestFailure(SpiceException spiceException) {

        }

        @Override
        public void onRequestSuccess(String s) {

            Log.w("HASIL PERMINTAAN","HASIL PERMINTAAN PEDAS " + s);
            tekshasil.setText(s);
        }
    }


    View.OnClickListener listenerpedas = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            pedasmanager.execute(rekuesString, new ListenerPermintaan());
        }
    };























}
