package com.obo.plugrxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by obo on 15/12/23.
 */


public class RxJavaTest {
    public static void main(String []args) {
//        basic();
//        simple1();
        System.out.println(012);

    }
    
    static void basic() {
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> sub) {
                        sub.onNext("Hello, world!");
                        sub.onNext("asdkoerld!");
                        sub.onCompleted();
                    }
                }
        );
        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) { System.out.println(s); }

            @Override
            public void onCompleted() { }

            @Override
            public void onError(Throwable e) { }
        };

        myObservable.subscribe(mySubscriber);
    }


    static void simple1() {

        Observable<String> myObservable = Observable.just("Hello, world!");

        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        };

        myObservable.subscribe(onNextAction);

    }

//    static void simple2() {
//        Observable.just("Hello, world!")
//                .subscribe(s -> System.out.println(s));
//    }

}
