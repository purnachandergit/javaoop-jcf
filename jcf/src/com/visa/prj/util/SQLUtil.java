package com.visa.prj.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.visa.prj.annotations.Column;
import com.visa.prj.annotations.Table;

public class SQLUtil {
	public static String generateCreateSQL(Class<?> clazz) {
		StringBuilder builder=new StringBuilder();
		Table t=clazz.getAnnotation(Table.class);
		if(t!=null) {
			builder.append("create table");
			builder.append(" ");
			builder.append("t.name()");
			builder.append("(");
		//not thread safe but we use here because we r using local variables only
			Method[] methods=clazz.getDeclaredMethods();
			for (Method method : methods) {
				if(method.getName().startsWith("get")) {
					Column c=method.getAnnotation(Column.class);
				    if(c!=null) {
				    	builder.append(c.name());
				    	builder.append(" ");
				    	builder.append(c.type());
				    	builder.append(", ");
				    }
				}
			
			}
		}
		builder.setCharAt(builder.lastIndexOf(","), (')'));
		
		
		
		return builder.toString();
	}
	public static String generateInsertSQL(Object obj) {
		StringBuilder builder=new StringBuilder();
		StringBuilder values=new StringBuilder();
		Table t=obj.getClass().getAnnotation(Table.class);
		if(t!=null) {
			builder.append("insert into");
			builder.append(" ");
			builder.append(t.name());
			builder.append(" (");
			values.append("values ");
			values.append("(");
		//not thread safe but we use here because we r using local variables only
			Method[] methods=obj.getClass().getDeclaredMethods();
			for (Method method : methods) {
				if(method.getName().startsWith("get")) {
					Column c=method.getAnnotation(Column.class);
				    if(c!=null) {
				    	builder.append(c.name()+",");
				    	try {
				    		if(c.type().startsWith("VARCHAR"))
				    		{
				    			values.append("'");
				    		}
							builder.append(method.invoke(obj).toString());
							if(c.type().startsWith("VARCHAR"))
				    		{
				    			values.append("'");
				    		}
							
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    	builder.append(" ");
				    	builder.append(",");
				    	values.append(" ");
				    	values.append(",");
				    }
				}
			
			}
		}
		builder.setCharAt(builder.lastIndexOf(","), (')'));
		
		return builder.toString();
	}

}
