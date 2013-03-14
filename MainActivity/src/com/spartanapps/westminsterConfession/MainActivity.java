package com.spartanapps.westminsterConfession;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.TextView;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Resources res = getResources();
		String[] chapterNumbers = res.getStringArray(R.array.chapterNumbers);
		String[] chapterTitles = res.getStringArray(R.array.chapterTitles);
		String[] chapterText = res.getStringArray(R.array.chapterText);
    	((TextView)findViewById (R.id.chapterNumber)).setText (chapterNumbers[0]);
    	((TextView)findViewById (R.id.chapterTitle)).setText (chapterTitles[0]);
    	((TextView)findViewById (R.id.content)).setText (chapterText[0]);
	}
	
	@Override
	public boolean onCreateOptionsMenu( Menu menu )
	{
		getMenuInflater().inflate( R.menu.activity_main, menu );
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#d7d8d9")));
		return true;
	}
	int counter = 0;
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Resources res = getResources();
		String[] chapterNumbers = res.getStringArray(R.array.chapterNumbers);
		String[] chapterTitles = res.getStringArray(R.array.chapterTitles);
		String[] chapterText = res.getStringArray(R.array.chapterText);
		ScrollView myview;
		myview = (ScrollView)findViewById(R.id.myview);
    	myview.scrollTo(0,0);
		// Handle item selection
	    switch (item.getItemId()) {
	        case R.id.chapterincrease:
	        	TextView et = (TextView)findViewById(R.id.chapterNumber);
	        	counter = Integer.parseInt(et.getText().toString());
	        	if (counter < (chapterText.length)) {
	        		((TextView)findViewById (R.id.chapterNumber)).setText (chapterNumbers[counter]);
		    		((TextView)findViewById (R.id.chapterTitle)).setText (chapterTitles[counter]);
		    		((TextView)findViewById (R.id.content)).setText (chapterText[counter]);
		    		return true;
	        	} else {
	        		//counter = 2;
	        		return false;
	        	}      	
	    		
	    		
	        case R.id.chapterdecrease:
	  
	        	
	        	Log.v("",Integer.toString(counter));
	            if (counter > 0) {
	            	if(counter == 33) {
	            		counter = 32;
	            	}
	            	counter --;
	            	((TextView)findViewById (R.id.chapterNumber)).setText (chapterNumbers[counter]);
		    		((TextView)findViewById (R.id.chapterTitle)).setText (chapterTitles[counter]);
		    		((TextView)findViewById (R.id.content)).setText (chapterText[counter]);
		            return true;
	            } else {
	            	Log.v("","test");
	            	return false;
	            }
	    		
	        case R.id.Chapter:
	        	Intent myIntent = new Intent(MainActivity.this, chapterchooser.class);
	        	startActivityForResult(myIntent,1);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == Activity.RESULT_OK) {
			int chapterNumber = data.getIntExtra("chapterChosen",0);
			counter = chapterNumber;
			Log.v("",Integer.toString(chapterNumber));
			Resources res = getResources();
			String[] chapterNumbers = res.getStringArray(R.array.chapterNumbers);
			String[] chapterTitles = res.getStringArray(R.array.chapterTitles);
			String[] chapterText = res.getStringArray(R.array.chapterText);
	    	((TextView)findViewById (R.id.chapterNumber)).setText (chapterNumbers[chapterNumber]);
	    	((TextView)findViewById (R.id.chapterTitle)).setText (chapterTitles[chapterNumber]);
	    	((TextView)findViewById (R.id.content)).setText (chapterText[chapterNumber]);
		}

	}// on activityresult
	

}
