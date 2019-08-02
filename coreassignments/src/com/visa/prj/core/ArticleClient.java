package com.visa.prj.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.visa.prj.entity.Article;

public class ArticleClient {

	public static void main(String[] args) {
		List<Article> articles = new ArrayList<>();
		articles.add(new Article("NoDBA",561,"bliki",Arrays.asList("nosql","people","orm")));
		articles.add(new Article("Infodesk",1145,"bliki",Arrays.asList("nosql","writing")));
		articles.add(new Article("OrmHate",1718,"bliki",Arrays.asList("nosql","orm")));
		articles.add(new Article("ruby",1313,"article",Arrays.asList("ruby")));
		articles.add(new Article("DDD_Aggregate",482,"bliki",Arrays.asList("nosql","ddd")));
		
		printTotalWordCount(articles); // 5219
		printArticlesByType(articles); //{bliki:4, article: 1}
		
		// use flatMap, Function.identity and groupingby and Collectors.counting to solve this
		printTagCount(articles); // nosql: 4, ruby : 1, 
	}

	private static void printTagCount(List<Article> articles) {
		List<String> list=articles.stream().flatMap(p->p.getTags().stream()).collect(Collectors.toList());
		Map<String,Long> map1=list.stream().collect(Collectors.groupingBy(p->p,Collectors.counting()));
		System.out.println(map1);
        
	}
		

	private static void printArticlesByType(List<Article> articles) {
		Map<String,List<Article>> map1=articles.stream().collect(Collectors.groupingBy(p->p.getType()));
		Set<String> keys=map1.keySet();
		for (String string : keys) {
			System.out.println(string + "  "+ map1.get(string).size());
		}
		
	}

	private static void printTotalWordCount(List<Article> articles) {
		int count=articles.stream().map(p->p.getWords()).reduce(0,(p1,p2)-> p1+p2);
		System.out.println(count);
	}

}
