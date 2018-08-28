package com.sandi.take3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.ToDoubleFunction;

public class Driver {

	public static void main(String[] args) throws IOException {
		List<Data> datas = Collections.synchronizedList(new ArrayList<Data>());

		//reader input datas
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Data data = null;
		String productName = null;
		double price = 0.0;
		System.out.println("Reactive style");
		while(true) {
			System.out.println("Please enter name -> ");
			productName = reader.readLine();
			if(productName.equals("exit")) break;
			else if(productName.isEmpty()) continue;


			System.out.println("Please enter value -> ");
			try {
				price = Double.valueOf(reader.readLine());
			}catch (NumberFormatException e) {
			}

			data = new Data(price, productName);

			if(datas.contains(data))
				datas.get(datas.indexOf(data)).setPrice(data.getPrice());
			else
				datas.add(data);
			
			datas.stream().map(e -> e.getProductName() +" "+e.getPrice()).forEach(System.out::println);

			System.out.println(datas.stream().mapToDouble(value -> value.getPrice()).sum());
		}
	}

}
