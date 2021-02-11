package com.example.testapp;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


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
        setupButtons();

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

    private void setupButtons() {
        table1 = findViewById(R.id.table1);
        table1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Point point = getPointOfView(table1);
                System.out.println("view point x,y (" + point.x + ", " + point.y + ")");
            }
        });
        table2 = findViewById(R.id.table2);
        table2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Point point = getPointOfView(table2);
                System.out.println("view point x,y (" + point.x + ", " + point.y + ")");
            }
        });
        table3 = findViewById(R.id.table3);
        table3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Point point = getPointOfView(table3);
                System.out.println("view point x,y (" + point.x + ", " + point.y + ")");
            }
        });
        table4 = findViewById(R.id.table4);
        table4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Point point = getPointOfView(table4);
                System.out.println("view point x,y (" + point.x + ", " + point.y + ")");
            }
        });
        table5 = findViewById(R.id.table5);
        table5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Point point = getPointOfView(table5);
                System.out.println("view point x,y (" + point.x + ", " + point.y + ")");
            }
        });
        table6 = findViewById(R.id.table6);
        table6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Point point = getPointOfView(table6);
                System.out.println("view point x,y (" + point.x + ", " + point.y + ")");
            }
        });
        table7 = findViewById(R.id.table7);
        table7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Point point = getPointOfView(table7);
                System.out.println("view point x,y (" + point.x + ", " + point.y + ")");
            }
        });
        table8 = findViewById(R.id.table8);
        table8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Point point = getPointOfView(table8);
                System.out.println("view point x,y (" + point.x + ", " + point.y + ")");
            }
        });
        table9 = findViewById(R.id.table9);
        table9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Point point = getPointOfView(table1);
                System.out.println("view point x,y (" + point.x + ", " + point.y + ")");
            }
        });
        table10 = findViewById(R.id.table10);
        table10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Point point = getPointOfView(table10);
                System.out.println("view point x,y (" + point.x + ", " + point.y + ")");
            }
        });
        table11 = findViewById(R.id.table11);
        table11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Point point = getPointOfView(table11);
                System.out.println("view point x,y (" + point.x + ", " + point.y + ")");
            }
        });
        table12 = findViewById(R.id.table12);
        table12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Point point = getPointOfView(table12);
                System.out.println("view point x,y (" + point.x + ", " + point.y + ")");
            }
        });
        table13 = findViewById(R.id.table13);
        table13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Point point = getPointOfView(table13);
                System.out.println("view point x,y (" + point.x + ", " + point.y + ")");
            }
        });
        table14 = findViewById(R.id.table14);
        table14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Point point = getPointOfView(table14);
                System.out.println("view point x,y (" + point.x + ", " + point.y + ")");
            }
        });
    }

    private Point getPointOfView(Button view) {
        int[] location = new int[2];
        view.getLocationInWindow(location);
        return new Point(location[0], location[1]);
    }
}