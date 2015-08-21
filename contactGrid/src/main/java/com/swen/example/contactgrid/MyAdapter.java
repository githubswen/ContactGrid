package com.swen.example.contactgrid;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
	private ArrayList<Contact> mData;
	private Context mContext;
	
	public class MyViewHolder extends RecyclerView.ViewHolder {
		public TextView contactText;
		public ImageView contactImage;
		
		public MyViewHolder(View v) {
			super(v);
			contactText = (TextView) v.findViewById(R.id.contactTextView);
			contactImage = (ImageView) v.findViewById(R.id.contactImageView);
		}
	}
	
	public MyAdapter(ArrayList<Contact>dataSet) {
		mData = dataSet;
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return mData.size();
	}

	@Override
	public void onBindViewHolder(MyViewHolder vh, int position) {
		// TODO Auto-generated method stub
		final Contact ct = mData.get(position);
		vh.contactText.setText(ct.getName());
		vh.contactText.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String telNo = "tel:" + ct.getTelNo();
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse(telNo));
				mContext.startActivity(intent);
			}
			
		});
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// TODO Auto-generated method stub
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_tile, parent, false);
		MyViewHolder vh = new MyViewHolder(v);
		mContext = parent.getContext();
		return vh;
	}

}
