package com.lambton.androidcapstoneapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class SamplesActivity extends MainActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("ALL SAMPLES");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = this;
        setContentView(R.layout.activity_samples);
        recyclerView = (RecyclerView) findViewById(R.id.recylerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getAllData();
        /*listItems = new ArrayList<>();
        for(int j = 0; j<10; j++){
            ListItem i = new ListItem("batu", "mehmet", "tech", "22-22-22");
            listItems.add(i);
        }
        adapter = new MyAdapter(listItems,this);
        recyclerView.setAdapter(adapter);*/
    }

    @Override
    public boolean onSupportNavigateUp(){
        intent = new Intent(context,HomeActivity.class);
        //remove all previous stack activities
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return true;
    }

    private void getAllData() {
        RequestParams params = new RequestParams();
        Log.d("Data Parameters",params.toString()+"");
        WebReq.get(context, "sample_batches", params, new SamplesActivity.ResponseHandler());
    }

    private class ResponseHandler extends JsonHttpResponseHandler {
        @Override
        public void onStart() {
            super.onStart();
        }

        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
            super.onSuccess(statusCode, headers, response);
            Log.d("response ",response.toString()+" ");
            try {
                    JSONArray data = response.getJSONArray("data");
                    listItems = new ArrayList<>();
                for(int i=0; i<data.length(); i++) {
                        JSONObject datas = data.getJSONObject(i);
                        ListItem item =  new ListItem("Batch Name: " + datas.getString("batch_name"),"Client: " + datas.getString("client"),"Submitted By: " + datas.getString("submitted_by"), "Due Date: " + datas.getString("due_date"));
                        System.out.println(item.getDue_date());
                        listItems.add(item);
                    }
                    adapter = new MyAdapter(listItems,context);
                    recyclerView.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
            super.onFailure(statusCode, headers, responseString, throwable);
        }

        @Override
        public void onFinish() {
            super.onFinish();
        }
    }
}
