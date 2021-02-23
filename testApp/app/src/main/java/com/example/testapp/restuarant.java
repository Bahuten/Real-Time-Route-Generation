package com.example.testapp;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Point;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
    private Button table1, table2, table3, table4, table5, table6, table7, table8, table9, table10, table11, table12, table13, table14, bar, office, toilet, exit_door;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restuarant);
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
                    Toast.makeText(restuarant.this, "Something went wrong:" + " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    call.cancel();
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                runOnUiThread(() -> {
                    try {
                        //Toast.makeText(restuarant.this, response.body().string(), Toast.LENGTH_LONG).show();
                        System.out.println(response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        });
    }

    private void routeJSON(String data) throws JSONException {
        JSONObject route = new JSONObject();
        JSONArray nodes = new JSONArray();
        nodes.put(data);
        route.put("Nodes", nodes);
    }

    private void Actions() {
        table1 = findViewById(R.id.table1);
        table1.setOnClickListener(v -> {
            try {
                routeJSON("()");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        table2 = findViewById(R.id.table2);
        table2.setOnClickListener(v -> {
            try {
                routeJSON("()");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        table3 = findViewById(R.id.table3);
        table3.setOnClickListener(v -> {
            try {
                routeJSON("()");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        table4 = findViewById(R.id.table4);
        table4.setOnClickListener(v -> {
            try {
                routeJSON("()");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        table5 = findViewById(R.id.table5);
        table5.setOnClickListener(v -> {
            try {
                routeJSON("()");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        table6 = findViewById(R.id.table6);
        table6.setOnClickListener(v -> {
            try {
                routeJSON("()");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        table7 = findViewById(R.id.table7);
        table7.setOnClickListener(v -> {
            try {
                routeJSON("()");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        table8 = findViewById(R.id.table8);
        table8.setOnClickListener(v -> {
            try {
                routeJSON("()");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        table9 = findViewById(R.id.table9);
        table9.setOnClickListener(v -> {
            try {
                routeJSON("()");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        table10 = findViewById(R.id.table10);
        table10.setOnClickListener(v -> {
            try {
                routeJSON("()");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        table11 = findViewById(R.id.table11);
        table11.setOnClickListener(v -> {
            try {
                routeJSON("()");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        table12 = findViewById(R.id.table12);
        table12.setOnClickListener(v -> {
            try {
                routeJSON("()");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        table13 = findViewById(R.id.table13);
        table13.setOnClickListener(v -> {
            try {
                routeJSON("()");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        table14 = findViewById(R.id.table14);
        table14.setOnClickListener(v -> {
            try {
                routeJSON("()");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        bar = findViewById(R.id.bar);
        bar.setOnClickListener(v -> {
            try {
                routeJSON("()");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        office = findViewById(R.id.office);
        office.setOnClickListener(v -> {
            try {
                routeJSON("()");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        exit_door = findViewById(R.id.exit);
        exit_door.setOnClickListener(v -> {
            try {
                routeJSON("()");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        toilet = findViewById(R.id.toilet);
        toilet.setOnClickListener(v -> {
            try {
                routeJSON("()");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    private Point getPointOfView(Button view) {
        int[] location = new int[2];
        view.getLocationInWindow(location);
        return new Point(location[0], location[1]);
    }
}