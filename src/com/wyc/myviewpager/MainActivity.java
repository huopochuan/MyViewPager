package com.wyc.myviewpager;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends FragmentActivity {
	
	private ViewPager viewpager1;
	private ViewPager viewpager2;
	private ImageView[] images;

	
	private List<Fragment> fragments;
	private String[] texts={
	    "锄禾日当午","汗滴禾下土","谁知盘中餐","粒粒皆辛苦"	
	};
	private int ImagePic[]={
			R.drawable.frame_view1,
			R.drawable.frame_view2,
			R.drawable.frame_view4,
			R.drawable.frame_view3
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewpager1=(ViewPager)this.findViewById(R.id.viewpager1);
		viewpager2=(ViewPager)this.findViewById(R.id.viewpager2);
		

		fragments=new ArrayList<Fragment>();
		for(int i=0;i<texts.length;i++){
		        
			 OutFragment fragment=new OutFragment(texts[i]);
			 fragments.add(fragment);
			
		}
		images=new ImageView[ImagePic.length];
		
		for(int i=0;i<ImagePic.length;i++){
			images[i]=new ImageView(this);
			images[i].setBackgroundResource(ImagePic[i]);
		}
	     //内部ViewPager
		viewpager2.setAdapter(new MypagerAdapter());
		viewpager2.addOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				
				viewpager1.setCurrentItem(arg0);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			
	           int width=viewpager1.getWidth();
				
			 	viewpager1.scrollTo((int)(width*arg0+width*arg1), 0);
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
			
				
			}
		});
		 //外部ViewPager
		viewpager1.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
		viewpager1.addOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				
				viewpager2.setCurrentItem(arg0);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
		          //arg0当前滑动界面
				 //arg1当页面前滑动百分比
				 //arg2当前页面滑动像素
				
				//Log.v("onPageScrolled", "arg0"+arg0+"arg1"+arg1+"arg2"+arg2);
				int width=viewpager2.getWidth();
				
			 	viewpager2.scrollTo((int)(width*arg0+width*arg1), 0);
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			
			}
		});
	}
	
	public class MypagerAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			
			return images.length;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
		
			return arg0==arg1;
		}
	  @Override
	   public Object instantiateItem(ViewGroup container, int position) {
		  ((ViewPager)container).addView(images[position % images.length]);
		    return images[position];
		 
	   }
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			((ViewPager)container).removeView(images[position % images.length]);
		
		}
		
		
	} 
	public class MyFragmentPagerAdapter extends FragmentPagerAdapter{

		public MyFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
		
		}

		@Override
		public Fragment getItem(int arg0) {
		
			return fragments.get(arg0);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return fragments.size();
		}

		

	
	}
}
