package com.jklinson.fisatarticles.globals;

/**
 * This is a custom log class that will manage logs in the project. Using the <b>disableLog()</b> all the logs can be disabled in the project during the production stage
 * <b> enableLog()</b> will allow to enable the logs , by default the logs will be visible.<br>
 * **/
import android.util.Log;

public class Logger {
	private static boolean logflag = true;
	private static String TAG = "Logger";

	/**
	 * print log for info/error/debug/warn/verbose
	 *
	 * @param type
	 *            : <br>
	 *            Log.INFO <br>
	 *            Log.ERROR <br>
	 *            Log.DEBUG <br>
	 *            Log.WARN <br>
	 *            Log.VERBOSE
	 * */
	public static void show(int type, String tag, String msg) {
		if (logflag)
			switch (type) {
			case Log.INFO:
				Log.i(tag, msg);
				break;
			case Log.ERROR:
				Log.e(tag, msg);
				break;
			case Log.DEBUG:
				Log.d(tag, msg);
				break;
			case Log.WARN:
				Log.w(tag, msg);
				break;
			case Log.VERBOSE:
				Log.v(tag, msg);
				break;
			default:
				break;
			}
	}

	/** printStackTrace for exception **/
	public static void show(Exception exception) {
		try {
			if (logflag)
				exception.printStackTrace();
		} catch (NullPointerException e) {
			Logger.show(e);
		}
	}

	public static boolean enableLog() {
		logflag = true;
		return logflag;
	}

	public static boolean disableLog() {
		logflag = false;
		return logflag;
	}

	public static void showHeapSize() {
		show(Log.INFO, TAG, "Heap size: " + Runtime.getRuntime().maxMemory());
	}
}
