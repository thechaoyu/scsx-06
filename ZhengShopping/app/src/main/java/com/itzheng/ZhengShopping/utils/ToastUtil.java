package com.itzheng.ZhengShopping.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

	public static void showToast(Context context, String text) {
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}

}
