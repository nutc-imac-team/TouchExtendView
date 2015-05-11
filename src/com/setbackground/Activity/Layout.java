package com.setbackground.Activity;

import com.example.com.setbackground.R;
import com.setbackground.Controller.TouchExtendView;
import com.setbackground.Controller.MainParentLayout;

import android.content.Context;
import android.widget.RelativeLayout;

public class Layout extends MainParentLayout {

	public Layout(Context context) {
		super(context);
	}

	protected void init() {
		LayoutParams LP = getLayoutParams(WH.getW(50),WH.getH(50));
		LP.addRule(RelativeLayout.CENTER_IN_PARENT);
		TouchExtendView gg = new TouchExtendView(context);
		gg.setBackgroundWidth(50);
		gg.setBackgroundHeight(50);
		gg.setBackgroundBitmap(R.drawable.usericon);
		gg.setLayoutParams(LP);
		this.addView(gg);
	}
}
