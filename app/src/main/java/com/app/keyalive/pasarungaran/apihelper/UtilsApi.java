package com.app.keyalive.pasarungaran.apihelper;

/**
 * Created by keyalive on 24/01/2018.
 */

public class UtilsApi {
//    public static  final String BASE_URL_API="http://127.0.0.1/pasar/";
    public static  final String BASE_URL_API="http://192.168.97.15/pasar/";
    public  static ApiService getAPIService(){
        return  RetrofitClient.getClient(BASE_URL_API).create(ApiService.class);
    }
}
