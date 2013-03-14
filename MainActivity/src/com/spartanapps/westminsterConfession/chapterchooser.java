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
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class chapterchooser extends ListActivity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	 // storing string resources into Array
        String[] chapterListView = getResources().getStringArray(R.array.chapterListView);
 
        // Binding resources Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, chapterListView));
        
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

}
