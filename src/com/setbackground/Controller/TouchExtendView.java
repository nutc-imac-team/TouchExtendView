package com.setbackground.Controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

public class TouchExtendView extends View {
	private Context context;
	private float BackgroundWidth = 0;
	private float BackgroundHeight = 0;
	private int DWidth;
	private int DHeight;
	private int flag = -1;
	private Bitmap ImageBG;

	public TouchExtendView(Context context) {
		super(context);
		this.context = context;
		init();
	}

	private void init() {

	};

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		this.DWidth = getWidth();
		this.DHeight = getHeight();

		if (flag != -1) {
			setbitmap(flag);
		}
		canvas.drawBitmap(ImageBG, getXPoint(), getYPoint(), new Paint());
	}

	// 讓使用者設定圖片寬的比例
	public void setBackgroundWidth(int size) {
		this.BackgroundWidth = size;
	}

	// 計算使用者設定的寬佔整個layout的寬度
	private float getBackgroundWidth() {
		return ((float) DWidth / (float) (100 / BackgroundWidth));
	}

	// 讓使用者設定圖片高的比例
	public void setBackgroundHeight(int size) {
		this.BackgroundHeight = size;
	}

	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		if(ImageBG!=null)ImageBG=null;
		System.gc();
	}
	
	// 計算使用者設定的高佔整個layout的高度
	private float getBackgroundHeight() {
		return ((float) DHeight / (float) (100 / BackgroundHeight));
	}

	// 計算圖片x軸開始畫的點
	private float getXPoint() {
		return ((float) DWidth - (float) getBackgroundWidth()) / 2;
	}

	// 計算圖片y軸開始畫的點
	private float getYPoint() {
		return ((float) DHeight - (float) getBackgroundHeight()) / 2;
	}

	public void setBackgroundBitmap(int res) {
		this.flag = res;
		invalidate();
	}

	public void setbitmap(int res) {
		Bitmap obitmap = BitmapFactory.decodeResource(getResources(), res);
		int obitmapwidth = obitmap.getWidth();
		int obitmapheight = obitmap.getHeight();
		Matrix matrix = new Matrix();
		matrix.postScale((float) getBackgroundWidth() / (float) obitmapwidth,
				(float) getBackgroundHeight() / (float) obitmapheight);
		ImageBG = Bitmap.createBitmap(obitmap, 0, 0, obitmapwidth,
				obitmapheight, matrix, true);
		flag = -1;
	}
}
