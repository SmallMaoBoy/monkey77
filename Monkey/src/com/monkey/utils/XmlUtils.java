package com.monkey.utils;



import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class XmlUtils {

	//保存数据
	public static void saveData(Context context, String fileName, Map<String, Object> datas) {
		SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		Set<Entry<String, Object>> entrySet = datas.entrySet();
		for (Entry<String, Object> e : entrySet) {
			if (e.getValue() instanceof String) {
				editor.putString(e.getKey(), (String) e.getValue());
			} else if (e.getValue() instanceof Boolean) {
				editor.putBoolean(e.getKey(), (boolean) e.getValue());
			} else if (e.getValue() instanceof Integer) {
				editor.putInt(e.getKey(), (int) e.getValue());
			}
		}
		editor.commit();
	}

	//保存数据
	public static void saveData(Context context, String fileName, String key, String value) {
		SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString(key, value);
		
		editor.commit();
	}

	public static void saveData(Context context, String fileName, String key, boolean value) {
		SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	//读取数据
	public static String readStringData(Context context, String fileName, String key) {
		SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
		return sp.getString(key, "");
	}
	public static boolean readBooleanData(Context context, String fileName, String key) {
		SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
		return sp.getBoolean(key, false);
	}
}
