package gk.robopedassampel.jaringan;

import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import gk.robopedassampel.Konstan;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.Converter;

/**
 * Created by Kucing Imut on 8/7/15.
 */
public class SpiceRetrofitServis extends RetrofitGsonSpiceService {

    private OkHttpClient okhttpklien;



    @Override
    public void onCreate() {
        super.onCreate();

        addRetrofitInterface(APICodepolit.class);
    }

    @Override
    protected String getServerUrl() {

        return Konstan.ALAMATSERVER;
    }



    @Override
    protected RestAdapter.Builder createRestAdapterBuilder() {
        super.createRestAdapterBuilder();

        okhttpklien = new OkHttpClient();
        okhttpklien.setConnectTimeout(10, TimeUnit.SECONDS);
        okhttpklien.setReadTimeout(10, TimeUnit.SECONDS);
        okhttpklien.setReadTimeout(10, TimeUnit.SECONDS);

        RestAdapter.Builder adapterbuilder = new RestAdapter.Builder();
        adapterbuilder.setClient(new OkClient(okhttpklien));
        adapterbuilder.setEndpoint(Konstan.ALAMATSERVER);
        adapterbuilder.setConverter(new StrKonverter());


        return adapterbuilder;
    }

    @Override
    protected Converter createConverter() {
        super.createConverter();

        return new StrKonverter();
    }


}
