package com.setbackground.Controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.DisplayMetrics;

public class WH {
	private int DefaultWidth = 1280, DefaultHeight = 720,
			DefaultDensityDpi = 320;
	public int Width;
	public int Height;
	public int densityDpi;
	public static Typeface typeFace, typeFace2;
	private Context Context;

	// Width & Height
	public WH(Context Context) {
		this.Context = Context;
		if (typeFace == null|typeFace2 == null) {
			try {
				typeFace = Typeface.createFromAsset(Context.getAssets(),
						"fonts/TextType1.ttc");
				typeFace2 = Typeface.createFromAsset(Context.getAssets(),
						"fonts/BKANT.ttc");
			} catch (Exception e) {
			}
		}
		DisplayMetrics dm = new DisplayMetrics();
		((Activity) Context).getWindowManager().getDefaultDisplay()
				.getMetrics(dm);
		Width = dm.widthPixels;
		Height = dm.heightPixels;
		densityDpi = dm.densityDpi;
		// Log.e("",
		// dm.heightPixels+"--"+dm.widthPixels+"--"+dm.densityDpi+"--"+dm.density+"--"+dm.xdpi+"--"+dm.ydpi);
		// Toast.makeText(Context, ""+dm.densityDpi, Toast.LENGTH_LONG).show();
		// AlertDialog dialog = new AlertDialog.Builder(Context)
		// .setTitle("è§??åº¦æ¸¬è©?)
		// .setMessage("heightPixelsï¼? + dm.heightPixels + "\n" +
		// "widthPixelsï¼? + dm.widthPixels + "\n" +
		// "densityDpiï¼? + dm.densityDpi + "\n" +
		// "densityï¼? + dm.density + "\n" +
		// "xdpiï¼? + dm.xdpi + "\n" +
		// "ydpiï¼? + dm.ydpi)
		// .setPositiveButton("ç¢ºå?", new OnClickListener() {
		// public void onClick(DialogInterface dialog, int which) {
		// dialog.dismiss();
		// }
		// }).create();
		// dialog.show();
	}

	public int getW(double Per) {
		if (Per == -1)
			return -1;
		else if (Per == -2)
			return -2;
		return (int) ((Per > 100.0) ? Width : ((Width * Per) / 100));
	}

	public int getH(double Per) {
		if (Per == -1)
			return -1;
		else if (Per == -2)
			return -2;
		return (int) ((Per > 100.0) ? Height : ((Height * Per) / 100));
	}

	public int getCW(int W, double Per) {
		return (int) ((Per > 100.0) ? W : ((W * Per) / 100));
	}

	public int getCH(int H, double Per) {
		return (int) ((Per > 100.0) ? H : ((H * Per) / 100));
	}

	public Typeface getTypeface() {
		return typeFace;
	}

	public Typeface getTypeface2() {
		return typeFace2;
	}

	public int getTextSize(int size) {
		if (Width > DefaultWidth && Height > DefaultHeight
				&& densityDpi <= DefaultDensityDpi) {
			if (DisplayMetrics.DENSITY_LOW <= densityDpi
					&& DisplayMetrics.DENSITY_MEDIUM > densityDpi) {
				return size;
			} else if (DisplayMetrics.DENSITY_MEDIUM <= densityDpi
					&& DisplayMetrics.DENSITY_TV > densityDpi) {
				return size;
			} else if (DisplayMetrics.DENSITY_TV <= densityDpi
					&& DisplayMetrics.DENSITY_HIGH > densityDpi) {
				return size;
			} else if (DisplayMetrics.DENSITY_HIGH <= densityDpi
					&& DisplayMetrics.DENSITY_XHIGH > densityDpi) {
				return (int) (size * (0.68 * 2.2));
			} else if (DisplayMetrics.DENSITY_XHIGH <= densityDpi
					&& DisplayMetrics.DENSITY_XXHIGH > densityDpi) {
				return (int) (size * (1.5 * 1.2));
			}/*
			 * else if(DisplayMetrics.DENSITY_XXHIGH <= densityDpi &&
			 * DisplayMetrics.DENSITY_XXXHIGH > densityDpi){ return (int) (size
			 * *(1.5 * 2.2)); }
			 */else {
				return size;
			}
		}
		switch (densityDpi) {
		case DisplayMetrics.DENSITY_LOW:
			return size;
		case DisplayMetrics.DENSITY_MEDIUM:
			if (Width < DefaultWidth || Height < DefaultHeight) {
				if ((Width > 960 && Width <= 1120)
						&& (Height > 480 && Height <= 640)) {
					return (int) (size * 0.76);
				}
			}
			return size;
		case DisplayMetrics.DENSITY_TV:
			return size;
		case DisplayMetrics.DENSITY_HIGH:
			return (int) (size * 0.68);
		case DisplayMetrics.DENSITY_XHIGH:
			return size;
		case DisplayMetrics.DENSITY_XXHIGH:
			return (int) (size * 1.5);
			/*
			 * case DisplayMetrics.DENSITY_XXXHIGH: return (int) (size * 2.5);
			 */
		default:
			return (int) (size * 10);
		}
	}

}
