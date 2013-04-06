package com.spartanapps.westminsterConfession;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.SimpleAdapter;

public class chapterchooser extends ListActivity {
	
	//ArrayList holds the data (as HashMaps) to load into the ListView
		ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
		//SimpleAdapter does the work to load the data in to the ListView
		private SimpleAdapter sa;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	  //HashMap links each line of data to the correct TextView
        HashMap<String,String> item;
        for(int i=0;i<StatesAndCapitals.length;i++){
          item = new HashMap<String,String>();
          item.put( "line1", StatesAndCapitals[i][0]);
          item.put( "line2", StatesAndCapitals[i][1]);
          list.add( item );
        }
        
        sa = new SimpleAdapter(this, list,
        	    R.layout.list_item,
        	    new String[] { "line1","line2" },
        	    new int[] {R.id.line_a, R.id.line_b});
        
        setListAdapter(sa);
        
        ListView lv = getListView();
        
        // listening to single list item on click
        lv.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        	  //Log.v("",Integer.toString(position));
        	// selected item
              //String chapter = ((TextView) view).getText().toString();
           // Launching new Activity on selecting single List Item
              Intent i = new Intent();
              // sending data to new activity
              i.putExtra("chapterChosen", position);
             //
              setResult(Activity.RESULT_OK, i);
              finish();
          }
        }); 
        
        
	}
	@Override
	public boolean onCreateOptionsMenu( Menu menu )
	{
		getMenuInflater().inflate( R.menu.chapter_chooser, menu );
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#d7d8d9")));
		bar.setDisplayHomeAsUpEnabled(true);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
        case android.R.id.home:
        	Intent intent = new Intent(this,MainActivity.class);
        	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(intent);
        	break;
        	default:
        		return super.onOptionsItemSelected(item);
			}
		return true;
	}
	private String[][] StatesAndCapitals =
		{{"Chapter 1","Of The Holy Scripture"},
		{"Chapter 2","Of God, and of the Holy Trinity"},
		{"Chapter 3","Of God\'s Eternal Decree"},
		{"Chapter 4","Of Creation"},
		{"Chapter 5","Of Providence"},
		{"Chapter 6","Of the Fall of Man, of Sin, and of the Punishment Thereof"},
		{"Chapter 7","Of God\'s Covenant with Man"},
		{"Chapter 8","Of Christ the Mediator"},
		{"Chapter 9","Of Free Will"},
		{"Chapter 10","Of Effectual Calling"},
		{"Chapter 11","Of Justification"},
		{"Chapter 12","Of Adoption"},
		{"Chapter 13","Of Sanctification"},
		{"Chapter 14","Of Saving Faith"},
		{"Chapter 15","Of Repentance unto Life"},
		{"Chapter 16","Of Good Works"},
		{"Chapter 17","Of the Perseverance of the Saints"},
		{"Chapter 18","Of the Assurance of Grace and Salvation"},
		{"Chapter 19","Of the Law of God"},
		{"Chapter 20","Of Christian Liberty, and Liberty of Conscience"},
		{"Chapter 21","Of Religious Worship, and the Sabbath Day"},
		{"Chapter 22","Of Lawful Oaths and Vows"},
		{"Chapter 23","Of the Civil Magistrate"},
		{"Chapter 24","Of Marriage and Divorce"},
		{"Chapter 25","Of the Church"},
		{"Chapter 26","Of the Communion of Saints"},
		{"Chapter 27","Of the Sacraments"},
		{"Chapter 28","Of Baptism"},
		{"Chapter 29","Of the Lord\'s Supper"},
		{"Chapter 30","Of Church Censures"},
		{"Chapter 31","Of Synods and Councils"},
		{"Chapter 32","Of the State of Men after Death, and of the Resurrection of the Dead"},
		{"Chapter 33","Of the Last Judgment"}};

}
