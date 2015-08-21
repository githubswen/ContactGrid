package com.swen.example.contactgrid;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Contact> mDataSet;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mDataSet = new ArrayList<Contact>();
		addDummyData();
		setContentView(R.layout.activity_main);
		mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
		mRecyclerView.setHasFixedSize(true);
		
		//always call layout manager
		mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
		mRecyclerView.setLayoutManager(mLayoutManager);
		
		//set the adapter
		mAdapter = new MyAdapter(mDataSet);
		mRecyclerView.setAdapter(mAdapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void addDummyData() {
		Contact swen = new Contact("John", "6041234567");
		Contact angie = new Contact("Jane", "6041234567");
		Contact alex = new Contact("James", "7781234567");
		Contact titi = new Contact("Jeff", "6041234567");
		Contact turbo = new Contact("Jordy", "6041234567");

		mDataSet.add(swen);
		mDataSet.add(angie);
		mDataSet.add(alex);
		mDataSet.add(titi);
		mDataSet.add(turbo);
	}
}
