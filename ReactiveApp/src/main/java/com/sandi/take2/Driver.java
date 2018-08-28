package com.sandi.take2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.ToDoubleFunction;

import io.reactivex.Observable;

public class Driver {

	public static List<Data> datas = Collections.synchronizedList(new ArrayList<Data>());
	
	public static void main(String[] args) throws IOException {
		//convert list into observable
		Observable<Data> observable = Observable.fromIterable(datas);
		SimpleObserver simpleObserver = new SimpleObserver();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Data data = null;
		String productName = null;
		double price = 0.0;
		System.out.println("Reactive style using rxjava");
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
			
			observable.subscribe(simpleObserver);
		}
	}

}
