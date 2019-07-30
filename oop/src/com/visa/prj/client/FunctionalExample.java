package com.visa.prj.client;

@FunctionalInterface
interface Computation{
	int compute(int x,int y);//only one method to be implemented in functional interface
}

public class FunctionalExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computation c1=new Computation() {
			@Override
			public int compute(int x, int y) {
				return x+y;
			}
		};
		doTask(c1,4,5);
		Computation c2=new Computation() {
			@Override
			public int compute(int x, int y) {
				return x-y;
			}
		};
		doTask(c2,4,5);
		
		Computation c3=(int x,int y)->{
			return x*y;
		};
		doTask(c3,5,6);
		Computation c4=(x,y)->{ //these are valid for functional interfaces only;
			return x*y;
		};
		doTask(c4,5,4);
		Computation c5=(x,y)->x*y;
		doTask(c5,6,3);
		

	}
	private static void doTask(Computation c,int x,int y)
	{
		System.out.println(c.compute(x, y));
	}

}
