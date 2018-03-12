package com.app.keyalive.pasarungaran.Layout;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.keyalive.pasarungaran.R;
import com.app.keyalive.pasarungaran.apihelper.ApiService;
import com.app.keyalive.pasarungaran.apihelper.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

     TextInputLayout til2;
     EditText edtUsername;
     EditText edtEmail;
     TextInputLayout til3;
     EditText edtPassword;
     Button register;
    ProgressDialog loading;
    Context mContext;
    ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mContext = this;
        mApiService = UtilsApi.getAPIService();
        til2 = findViewById(R.id.til2);
        edtUsername = findViewById(R.id.edt_username);
        edtEmail = findViewById(R.id.edt_email);
        til3 = findViewById(R.id.til3);
        edtPassword = findViewById(R.id.edt_password);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtUsername.getText().toString().length()==0){
                    //jika form Email belum di isi / masih kosong
                    edtUsername.setError("Username diperlukan!");
                }else if(edtEmail.getText().toString().length()==0){
                    //jika form Username belum di isi / masih kosong
                    edtEmail.setError("Email diperlukan!");
                }else if(edtPassword.getText().toString().length()==0) {
                    //jika form Passwrod belum di isi / masih kosong
                    edtPassword.setError("Password diperlukan!");
                } else {
                    loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                    requestRegister();
                }
            }
        });
    }

    private void requestRegister() {
        loading = ProgressDialog.show(mContext, null, "Harap Tunggu", true, false);
        mApiService.registerRequest(
                edtUsername.getText().toString(),
                edtEmail.getText().toString(),
                edtPassword.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Log.i("debug", "onResponse: BERHASIL");
                            loading.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
//                                JSONObject user = jsonRESULTS.optJSONObject("user");
//                                String nama = user.optString("nama");
                                if (jsonRESULTS.getString("error").equals("false")){
                                    Toast.makeText(mContext, "BERHASIL REGISTRASI", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(mContext, LoginActivity.class));
                                    loading.dismiss();
                                } else {
                                    String error_message = jsonRESULTS.getString("error_msg");
                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Log.i("debug", "onResponse: GA BERHASIL");
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.getMessage());
                        loading.dismiss();
                        Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
    }



}
