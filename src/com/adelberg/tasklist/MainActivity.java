package com.adelberg.tasklist;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	Button enter_button;
	TextView task_list;
	EditText new_task;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button enter_button = (Button) findViewById(R.id.enter_task);
		enter_button.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				//Code to Create a New Task
				new_task = (EditText) findViewById(R.id.new_task);
				String newline = "\n";
				String task_data = new_task.getText().toString();
				Button delete = (Button) findViewById(R.id.delete_button);
				task_list = (TextView) findViewById(R.id.task_list);
				task_list.append(task_data + newline);
				
			}
		});
		
		
	}
	public void init(AttributeSet attrs)
	{
		TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.delete_button);
		
		//use array
		Log.i("test", array.getString(R.styleable.delete_button_android_text));
		
		//Don't forget this (I guess it's important
		array.recycle();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
