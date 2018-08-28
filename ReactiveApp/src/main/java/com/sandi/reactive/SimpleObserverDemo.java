package com.sandi.reactive;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SimpleObserverDemo implements Observer<String>{

	public void onSubscribe(Disposable d) {
		System.out.println("onSubscribe "+d);
		//d.dispose();
	}

	public void onNext(String t) {
		System.out.println("onNext "+t);
	}

	public void onError(Throwable e) {
		System.out.println("onError"+e);
	}

	public void onComplete() {
		System.out.println("onComplete");
	}

}
