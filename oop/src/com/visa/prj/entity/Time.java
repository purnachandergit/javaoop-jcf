package com.visa.prj.entity;

public class Time {
	private int  hour,minute;
    public Time()
    {
	  
    }
    public Time(int h,int min)
    {
    	this.hour=h;
    	this.minute=min;
    }
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public Time addtime(Time a)
	{
		int minutes=a.getMinute()+this.getMinute();
		int hours=0;
		hours+=minutes/60;
		minutes=(minutes%60);
		hours+=(a.getHour()+this.getHour());
		Time c= new Time(hours,minutes);
		return c;
	}
	public static Time addtime(Time a,Time b)
	{
		int minutes=a.getMinute()+b.getMinute();
		int hours=0;
		hours+=minutes/60;
		minutes=(minutes%60);
		hours+=(a.getHour()+b.getHour());
		Time c= new Time(hours,minutes);
		return c;
	}
				
				
				
				
				
				
				
		
}

