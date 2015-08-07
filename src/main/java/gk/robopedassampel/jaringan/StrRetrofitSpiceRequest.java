package gk.robopedassampel.jaringan;

import android.util.Log;

import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

/**
 * Created by Kucing Imut on 8/7/15.
 */
public class StrRetrofitSpiceRequest extends RetrofitSpiceRequest<String,APICodepolit> {


    public StrRetrofitSpiceRequest(String katakunci) {
        super(String.class, APICodepolit.class);

        Log.w("KATA KUNCI","kata kuncinya adalah " + katakunci);

    }


    @Override
    public String loadDataFromNetwork() throws Exception {

        String hasils = StrRetrofitSpiceRequest.this.getService().getJSONBeritaHalaman();

        return hasils;
    }
}
