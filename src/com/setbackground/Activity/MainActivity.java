package com.setbackground.Activity;

import android.app.Activity;
import android.os.Bundle;

import com.setbackground.Controller.TouchExtendView;

public class MainActivity extends Activity {
	private TouchExtendView BGV;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new Layout(this));
	}
}
