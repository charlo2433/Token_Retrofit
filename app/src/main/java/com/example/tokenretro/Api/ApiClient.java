package com.example.tokenretro.Api;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

        private static Retrofit retrofit;
        private static final String BASE_URL = "http://coffeemateweb.herokuapp.com/";

        public static Retrofit getRetrofitInstance() {
            if (retrofit == null) {
                retrofit = new retrofit2.Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(getUnsafeOkHttpClient())
                        .build();
            }
            return retrofit;
        }

        private static OkHttpClient getUnsafeOkHttpClient() {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor(message -> Log.d("HTTP", "log: " + message));
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            Interceptor interceptor = chain -> {
                final Request request = chain.request().newBuilder()
                        .build();
                return chain.proceed(request);
            };

            try {
                // Create a trust manager that does not validate certificate chains
                final TrustManager[] trustAllCerts = new TrustManager[]{
                        new X509TrustManager() {
                            @Override
                            public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                            }

                            @Override
                            public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                            }

                            @Override
                            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                return new java.security.cert.X509Certificate[]{};
                            }
                        }
                };

                // Install the all-trusting trust manager
                final SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
                // Create an ssl socket factory with our all-trusting manager
                final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
                ConnectionPool pool = new ConnectionPool(500, 600, TimeUnit.SECONDS);

                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                builder.sslSocketFactory(sslSocketFactory);
                builder.hostnameVerifier((hostname, session) -> true);

                builder.addInterceptor(interceptor);

                builder.addInterceptor(logging);
                builder.connectionPool(pool);
                builder.readTimeout(600, TimeUnit.SECONDS);
                builder.connectTimeout(600, TimeUnit.SECONDS);
                return builder.build();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
