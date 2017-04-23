/**
 *  HomeView.java 
 *  
 *  Purpose: Displays the Home Screen of the application.
 *
 *  HomeView contains the UI elements(buttons): 
 *  	- showAd(): to request the YuMe SDK to play a prefetched (or) streaming ad, if available.
 *  
 *  When HomeView activity get started ( onCreate() is where initialize HomeView activity) immediately initializes the YuMe SDK and it requires Domain ID. 
 *  Based on the configuration and ad params settings, the SDK initializes all the necessary components. 
 *  For pre-fetch mode, a new Ad Request will be made and assets will be cached.
 *  
 *  When the showAd() button is tapped, whenever an ad needs to be played.
 *  In streaming mode, it renders the ad immediately (if an ad is available).
 *  In pre-fetch mode, it renders the ad if a cached ad is readily available for playing.
 *    
 *  � 2014 YuMe, Inc. All rights reserved. 
 */

package com.me.obo.yumedemo.zissampleapp;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.me.obo.yumedemo.R;

public class HomeView extends Activity {
	
	/** Logging TAG used for console logging */
	String TAG = "YuMeAndroidZISSampleApp";
	
	/** YuMeInterface handle */
	YuMeInterface yumeInterface;
	
	/** handles to the UI elements */
    private Button showAdBtn;
    private TextView appVersionLabel;
    
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.homeview);
        
        /* create the YuMeInterface object */
        yumeInterface = YuMeInterface.getYuMeInterface();
        
        /* set the Main view handle in YuMeInterface object */
        yumeInterface.setHomeView(this);
        
        /* initialize the YuMeSDK */
 		boolean bInitSuccess = yumeInterface.initYuMeSDK();
 	    if(!bInitSuccess) {
 	    	Utils.displayShortToastMsg(getBaseContext(), "Error Initializing YuMe SDK.");
    		Log.e(TAG, "Error Initializing YuMe SDK.");
    	}
 	    
    	appVersionLabel = (TextView)this.findViewById(R.id.labelVersion);
    	String version = "version " + 111 + "_" + yumeInterface.getVersion() + ")";
    	appVersionLabel.setText(version);
    	
    	showAdBtn = (Button)this.findViewById(R.id.btnShowAd);
 	    showAdBtn.setOnClickListener(onShowAdBtnClicked);
		GradientDrawable gd1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] {0x000000FF, 0xFF000000});
		gd1.setCornerRadius(10.0f); 	    
 	    showAdBtn.setBackground(gd1); 	    
    }
    
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
    	super.onConfigurationChanged(newConfig);
    }
    
	@Override
	protected void onPause() {
		super.onPause();
		
		if(isFinishing()) {
			/* de-initialize the YuMe SDK */
			yumeInterface.deInitYuMeSDK();
			
			/* yumeInterface clean-up */
			yumeInterface.cleanUp();
			
			/* clean-up the toast messages, if any */
			Utils.removeToastMsg();
		}
	}
	
	/**
	 * Listens for the showAd button click event.
	 */
    public OnClickListener onShowAdBtnClicked = new OnClickListener() {
		@Override
		public void onClick(View v) {
			boolean retVal = yumeInterface.sdkIsAdAvailable();
			if (retVal) {
				handleShowAdBtnClick();
			} else {
				Toast.makeText(HomeView.this,"广告没有准备好",Toast.LENGTH_SHORT).show();
			}
		}
		
		/* handle the showAd button click - open the ad view */
		private void handleShowAdBtnClick() {
			Intent intent = new Intent(HomeView.this, AdView.class);
			startActivity(intent);
		}
    };
    
    /**
	 * Gets the Application context.
	 * @return The Application context.
	 */	
    public Context getAppContext() {
    	return this.getApplicationContext();
    }
    
    /**
  	 * Gets the Activity context.
  	 * @return The current Activity context.
  	 */	
  	public Context getActivityContext() {
      	return this;
  	}
    
	  
}
