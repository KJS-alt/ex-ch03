package com.kim.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        String result = "";

        list.sort((Comparator<String>) (str1, str2) -> str1.compareTo(str2));

        for (String item : list) {
            result += item + " ";
        }

        return result;
    }


    public String ex332(){

        List<String> list = new ArrayList<>();

        list.add("public");
        list.add("static");
        list.add("void");

        StringBuilder result = new StringBuilder();

        list.stream().forEach(str -> {
            System.out.println(str);
            result.append(str).append(" ");
        });
        return result.toString().trim();

    }

    public String ex333(){

        Integer[] integerArray = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        List<Integer> list = Arrays.asList(integerArray);

        List<Integer> evenList = new ArrayList<>();
        String result = "";


        for (int i = 0; i < list.size(); i++) {
            Integer number = list.get(i);
            if (number % 2 == 0) {
                evenList.add(number);
            }
        }
        for (int i = 0; i < evenList.size(); i++) {
            System.out.println((evenList.get(i)));
            result += evenList.get(i) + " ";
        }
        return result;
    }

    public String ex335(){
        Integer[] integerArray = new Integer[]{1,2,3,4,5};
        List<Integer> list = Arrays.asList(integerArray);
        StringBuilder result = new StringBuilder();

        list.stream().forEach(value -> {
            System.out.println(value);
            result.append(value).append(" ");
        });
        return result.toString().trim();
    }

    public String ex336(){
        Integer[] integerArray = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        List<Integer> list = Arrays.asList(integerArray);
        StringBuilder result = new StringBuilder();

        List<Integer> evenList = list.stream()
                .filter(value -> value % 2 == 0)
                .collect(Collectors.toList());
        evenList.stream().forEach(value -> {
            result.append(value).append(" ");
        });
        return result.toString().trim();
    }

    public String ex337(){
        Integer[] integerArray = new Integer[]{1,1,1,1,2,2,2,3,3,4};
        List<Integer> list = Arrays.asList(integerArray);
        StringBuilder result = new StringBuilder();
        List<Integer> distinctList = list.stream()
                .distinct()
                .toList();
        distinctList.stream().forEach(value -> {
            result.append(value).append(" ");
        });
        return result.toString().trim();
    }

    public String ex338(){
        String[] lowercaseArray = new String[]{"public", "static", "void"};
        List<String> lowercaseList = Arrays.asList(lowercaseArray);
        StringBuilder result = new StringBuilder();
        List<String> uppercaseList = lowercaseList.stream()
                .map(value -> value.toUpperCase()).toList();
        uppercaseList.stream().forEach(value -> result.append(value).append(" "));
        return result.toString().trim();

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


