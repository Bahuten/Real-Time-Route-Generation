package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Point;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;
import okhttp3.*;

public class restuarant extends AppCompatActivity {
    private String url = "http://" + "10.0.2.2" + ":" + 5000 + "/route";
    private String postBodyString;
    private MediaType mediaType;
    private RequestBody requestBody;
    private Button table1, table2, table3, table4, table5, table6, table7, table8, table9, table10, table11, table12, table13, table14, bar, office, toilet, kitchen, exit_door;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restuarant);
        postRequest("your message: ",url);
        getCoords();


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
                    Toast.makeText(restuarant.this, "Something went wrong:" + " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    call.cancel();
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                runOnUiThread(() -> {
                    try {
                        Toast.makeText(restuarant.this, response.body().string(), Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        });
    }

    private void getCoords() {
        table1 = findViewById(R.id.table1);

        table1.setOnClickListener(v -> {
            Point point = getPointOfView(table1);
            System.out.println("view point x,y (" + point.x + ", " + point.y + ")");
        });
    }
    private Point getPointOfView(Button view) {
        int[] location = new int[2];
        view.getLocationInWindow(location);
        return new Point(location[0], location[1]);
    }
}