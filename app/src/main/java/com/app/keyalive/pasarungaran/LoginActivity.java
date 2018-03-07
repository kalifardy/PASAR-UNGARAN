package com.app.keyalive.pasarungaran;

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

import com.app.keyalive.pasarungaran.apihelper.ApiService;
import com.app.keyalive.pasarungaran.apihelper.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout til2;
    EditText username;
    TextInputLayout til3;
    EditText password;
    Button login;
    ProgressDialog loading;

    Context mContext;
    ApiService mApiService;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        mContext = this;
//        mApiService = UtilsApi.getAPIService();
//        initComponents();

//        til2 = findViewById(R.id.til2);
//        username = findViewById(R.id.edt_username);
//        til3 = findViewById(R.id.til3);
//        password = findViewById(R.id.edt_password);
        login = findViewById(R.id.login);
//        register = findViewById(R.id.register);
//
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
//                if(username.getText().toString().length()==0){
//                    //jika form Email belum di isi / masih kosong
//                    username.setError("Username diperlukan!");
//                }else if(password.getText().toString().length()==0) {
//                    //jika form Passwrod belum di isi / masih kosong
//                    password.setError("Password diperlukan!");
//                } else {
//                    loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
//                    requestLoading();
//                }
            }
        });
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
//                startActivity(i);
//            }
//        });
//    }
//
//    private void initComponents() {
//    }
//
//    private void requestLoading() {
//            mApiService.loginRequest(username.getText().toString(), password.getText().toString())
//                    .enqueue(new Callback<ResponseBody>() {
//                        @Override
//                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                            if (response.isSuccessful()){
//                              loading.dismiss();
//                                try {
//                                    JSONObject jsonRESULTS = new JSONObject(response.body().string());
//                                    if (jsonRESULTS.getString("error").equals("false")){
//                                        // Jika login berhasil maka data nama yang ada di response API
//                                        // akan diparsing ke activity selanjutnya.
//                                        Toast.makeText(mContext, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
//                                        String nama = jsonRESULTS.getJSONObject("user").getString("nama");
//                                        Intent intent = new Intent(mContext, MainActivity.class);
//                                        intent.putExtra("result_nama", nama);
//                                        startActivity(intent);
//                                        finish();
//                                    } else {
//                                        // Jika login gagal
//                                        String error_message = jsonRESULTS.getString("error_msg");
//                                        Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
//                                    }
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                            } else {
//                                loading.dismiss();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<ResponseBody> call, Throwable t) {
//                            Log.e("debug", "onFailure: ERROR > " + t.toString());
//                            loading.dismiss();
//                        }
//                    });
//
//        }
//
//    @Override
//    public void onBackPressed() {
//        finish();
//    }
    }
}
