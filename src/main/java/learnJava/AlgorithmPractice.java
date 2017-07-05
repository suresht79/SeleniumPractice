package learnJava;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class AlgorithmPractice {

	
	public static void main (String[] args){
		int marks[][]={{50,60,55,67,70},{62,65,70,70,81},{72,66,77,80,69}};
		for(int i =0;i<marks.length;i++){
			System.out.println("going into row:" + i);
			for(int j=0;j<5;j++){
				System.out.println(marks[i][j]);
			}
		}
		
		
	}
	
	private static void  findDuplicateCharInString(){
		String var = "suresh";

		char[] charArray = var.toCharArray();
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0;i<charArray.length;i++){
			if(map.containsKey(charArray[i])){
				int val=map.get(charArray[i]);
				val=val+1;
				map.put(charArray[i], val);
			}
			else{
				map.put(charArray[i], 1);
			}
		}
		
		System.out.println(map);
	}
}
