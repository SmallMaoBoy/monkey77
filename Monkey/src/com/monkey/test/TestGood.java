package com.monkey.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.monkey.json.Good;
import com.monkey.utils.ConnUtils;
import com.monkey.utils.PropertiesUtil;

public class TestGood {

	public static void main(String[] s) {
		testgetGoods();
	}

	public static void testgetGoods() {
		String url = PropertiesUtil.getValue("BaseUrl");
		url = url + "GoodAction_getDefalutGoods?page=1&oerderType=0";
		System.out.println("---------url:"+url);
		String str = null;
		try {
			str = ConnUtils.conn(url);
			System.out.println("--------str:"+str);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// String fullFileName = "D:/Ada/monkey77/Monkey/src/good.json";
		//
		// File file = new File(fullFileName);
		// Scanner scanner = null;
		// StringBuilder buffer = new StringBuilder();
		// try {
		// scanner = new Scanner(file, "utf-8");
		// while (scanner.hasNextLine()) {
		// buffer.append(scanner.nextLine());
		// }
		//
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		//
		// } finally {
		// if (scanner != null) {
		// scanner.close();
		// }
		// }
		// System.out.println("-------"+buffer.toString());
		Gson gson = new Gson();
		List<Good> goods = gson.fromJson(str, new TypeToken<List<Good>>() {
		}.getType());
		System.out.println("-----goods" + goods);

		ArrayList<String> names = new ArrayList<String>();

		for (int i = 0; i < goods.size(); i++) {
			String name = goods.get(i).getName();
			names.add(name);
		}
		System.out.println(names);
	}

}
