package com.example.demo.controller.service;

import com.example.demo.controller.ExController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ExService {

	private static final Logger log = LoggerFactory.getLogger(ExService.class);

	public String sayHello(String hi) {
		String msg = hi + "좋은날";
		System.out.println(msg);
		log.info(msg);
		log.debug(msg);
		return msg;
	}

	public String ex321() {
		int number = 1;
		String result = "";
		
        if (number == 1) {
        	result = "if 블록입니다.";
        } else if (number == 2) {
        	result = "else if 블록입니다.";
        } else {
        	result = "else 블록입니다.";
        }
        log.info(result);
		return result;
	}
	public String ex322() {
		String result = "";
		int[] array = {1,2,3,4,5};
		for (int i = 0; i < array.length; i++) {
			result += "(i = " + array[i] + ") ";
		} return result; 
	}
	
	public String ex323() {
		int[] array = {1,2,3,4,5};
		String result = "";
		int i = 0;
		
		while (i < array.length) {
			result += "i = " + array[i];
			i++;
		} return result;
	}
	
	public interface Car{ public String getColor();}
	public class Sonata implements Car{
		public Sonata() {
			log.info("=== 출고 === Sonata");
		}
		@Override
		public String getColor() {
			return "=== 색상:RED === Sonata";
		}
	}
	public class K5 implements Car{
		public K5() {
			log.info("=== 출고 === K5");
		}
		public String getColor() {
			return "=== 색상:YELLOW === K5";
		}
	}
	public String ex324() {
		Car car1 = new Sonata();
		String re1 = car1.getColor();
		Car car2 = new K5();
		String re2 = car2.getColor();

		String result = re1 + "<br>" + re2 + "<br>" + "차 두 대를 출고하였음";
		return result;
	}
	
	public String ex325() {
		List list = new ArrayList<Integer>();
		String result = "";
		
		list.add(1);
		list.add(2);
		list.add(3);
		
		result = list.get(1).toString();
		log.info(result);
		
		return result;
	}
	
	public String ex326() {
		List list = new ArrayList<String>();
		
		list.add("public");
		list.add("static");
		list.add("void");
		String result = "";
		
		for (int i = 0; i < list.size(); i++) {
			result += list.get(i) + " ";
		}
		
		log.info(result);
		list.remove(1);
		int voidIndex = list.indexOf("void");
		return result + "<br> void의 index = " + voidIndex;
	}
	
	public String ex327() {
		String str1 = new String("is same?");
		String str2 = new String("is same?");
		
		boolean result = str1 == str2;
		
		return String.valueOf(result);
	}
	
	public String ex331() {
		List<String> list = new ArrayList<>();
		
		list.add("public");
		list.add("static");
		list.add("void");
		
		list.sort((Comparator<String>) (str1, str2) -> str1.compareTo(str2));

		String result = "";
		for (String item : list) {
			result += item + " ";
		}
		return result.trim();
	}
	
//	public String ex332() {
//		List list = new ArrayList<String>();
//		
//		list.add("public");
//		list.add("static");
//		list.add("void");
//		
//		list.stream().forEach(str -> System.out.println(str));
//	}
}


