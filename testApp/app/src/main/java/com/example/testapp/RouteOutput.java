package com.example.testapp;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.JsonReader;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileReader;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RouteOutput extends AppCompatActivity {
    private String url = "http://" + "10.0.2.2" + ":" + 5000 + "/route";
    private String postBodyString;
    private MediaType mediaType;
    private RequestBody requestBody;
    private Button table1, table2, table3, table4, table5, table6, table7, table8, table9, table10, table11, table12, table13, table14, bar, office, toilet, kitchen, exit_door;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.route_output);
        postRequest("your message: ",url);
        Actions();
    }
    private RequestBody buildRequestBody(String msg) {
        postBodyString = msg;
        mediaType = MediaType.parse("text/plain");
        requestBody = RequestBody.create(postBodyString, mediaType);
        return requestBody;
    }

    private void postRequest(String message, String URL) {
        RequestBody requestBody = buildRequestBody(message);
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request
                .Builder()
                .post(requestBody)
                .url(URL)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
                runOnUiThread(() -> {
                    Toast.makeText(RouteOutput.this, "Something went wrong:" + " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    call.cancel();
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                runOnUiThread(() -> {
                    try {
                        Toast.makeText(RouteOutput.this, response.body().string(), Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        });
    }

    private void Actions() {
        table1 = findViewById(R.id.table1);
        table1.setOnClickListener(v -> {

        });
        table2 = findViewById(R.id.table2);
        table2.setOnClickListener(v -> {

        });
        table3 = findViewById(R.id.table3);
        table3.setOnClickListener(v -> {

        });
        table4 = findViewById(R.id.table4);
        table4.setOnClickListener(v -> {

        });
        table5 = findViewById(R.id.table5);
        table5.setOnClickListener(v -> {

        });
        table6 = findViewById(R.id.table6);
        table6.setOnClickListener(v -> {

        });
        table7 = findViewById(R.id.table7);
        table7.setOnClickListener(v -> {

        });
        table8 = findViewById(R.id.table8);
        table8.setOnClickListener(v -> {

        });
        table9 = findViewById(R.id.table9);
        table9.setOnClickListener(v -> {

        });
        table10 = findViewById(R.id.table10);
        table10.setOnClickListener(v -> {

        });
        table11 = findViewById(R.id.table11);
        table11.setOnClickListener(v -> {

        });
        table12 = findViewById(R.id.table12);
        table12.setOnClickListener(v -> {

        });
        table13 = findViewById(R.id.table13);
        table13.setOnClickListener(v -> {

        });
        table14 = findViewById(R.id.table14);
        table14.setOnClickListener(v -> {

        });
        bar = findViewById(R.id.bar);
        bar.setOnClickListener(v -> {

        });
        office = findViewById(R.id.office);
        office.setOnClickListener(v -> {

        });
        exit_door = findViewById(R.id.exit);
        exit_door.setOnClickListener(v -> {

        });
        toilet = findViewById(R.id.toilet);
        toilet.setOnClickListener(v -> {

        });
    }

    private Point getPointOfView(Button view) {
        int[] location = new int[2];
        view.getLocationInWindow(location);
        return new Point(location[0], location[1]);
    }
}