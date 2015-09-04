package com.wyc.myviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OutFragment extends Fragment{
	private String text;
	private TextView tv;
	public OutFragment(String text){
		this.text=text;
	}

  @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	
	  View v=inflater.inflate(R.layout.fragment_out, container, false);
	  tv=(TextView)v.findViewById(R.id.tv);
	  tv.setText(text);
	   return v;
   }
}
