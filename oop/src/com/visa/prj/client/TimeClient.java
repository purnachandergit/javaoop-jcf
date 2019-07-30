package com.visa.prj.client;

import com.visa.prj.entity.Time;

public class TimeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time t1= new Time(4,30);
		Time t2= new Time(3,45);
		Time t3= Time.addtime(t1,t2);
		System.out.println(t3.getHour()+":"+t3.getMinute()); //8 : 15
		Time t4=t1.addtime(t2);
		System.out.println(t4.getHour()+":"+t4.getMinute());//8: 15

	}
}
