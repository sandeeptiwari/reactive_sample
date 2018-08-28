package com.sandi.reactive;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class SimpleDemo {
	
	public static void main(String...args) {
		List<String> shapeList = Arrays.asList("rectangle", "square", "triangle");
		Observable<String> observableString = Observable.fromIterable(shapeList);
		
		//subscribe to the subject( being observe)
		observableString.subscribe(new SimpleObserverDemo());
	}

}
