package com.sandi.take2;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SimpleObserver implements Observer<Data>{

	@Override
	public void onSubscribe(Disposable d) {
		
	}

	@Override
	public void onNext(Data t) {
		System.out.println(t.getProductName() +" : "+ t.getPrice());
	}

	@Override
	public void onError(Throwable e) {
		
	}

	@Override
	public void onComplete() {
			System.out.println("added variables "+Driver.datas.stream().mapToDouble(e -> e.getPrice()).sum());
			System.out.println("------------------------onCompleted--------------------------------------");
	}

}
