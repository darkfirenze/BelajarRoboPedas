package gk.robopedassampel.jaringan;


import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Kucing Imut on 8/7/15.
 */



public interface APICodepolit {


    //http://www.codepolitan.com/api/posts/latest/post/1
    @GET("/api/posts/latest/post/1")
    String getJSONBeritaHalaman();


}
