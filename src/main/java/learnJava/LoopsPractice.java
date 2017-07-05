package learnJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.graphbuilder.math.func.SumFunction;

public class LoopsPractice {
	

	public static void main(String[] args) {
		
		//deeptiArraylistandForLoopPractice();
		//arrayListPractice();
		//mapPractice();
		//arrayPractice();
		forEachLoopPractice();
		
	}
	
	
	public static void forEachLoopPractice(){
		Integer[] arrayValues =  new Integer[4];
		arrayValues[0]=1;
		arrayValues[1]=2;
		arrayValues[2]=3;
		arrayValues[3]=5;
		
		for(Integer value: arrayValues){
			System.out.println(value);
		}
		
	}
	
	public static void arrayPractice(){
		Integer[] array =  new Integer[4];
		array[0]=1;
		array[1]=2;
		array[2]=3;
		array[3]=5;
		
		for(int i=0;i<5;i++){
			System.out.println(array[i]);
		}
		
	}

	private static void arrayListPractice() {// TODO Auto-generated method stub
		 ArrayList<Integer> calculation= new ArrayList();
		 calculation.add(2);
		 calculation.add(4);
		 calculation.add(6);
		 calculation.add(8);
		 
		 System.out.println(calculation.get(0) + calculation.get(3) + calculation.get(2) +  calculation.get(1));
		 
		 System.out.println("running for loop");
		 
		 Integer sum=0;
		 
		 for(int i=0;i<calculation.size();i++){
			 //System.out.println(i + "-" + calculation.get(index));
			 System.out.println("value" + calculation.get(i));
			 sum=sum + calculation.get(i);
			 System.out.println("sum" + sum);
		 }
		 
		 System.out.println("running while loop");
		 
		 int j=0;
		 sum=0;
		 while(j<calculation.size()){
			 System.out.println(j);
		 
			 sum=sum + calculation.get(j);
			 System.out.println("sum:" + sum);
			 j=j+1;
		 }
		 
		 System.out.println("running do while loop");
		 j=6;
		 sum=0;
		 do{
			 System.out.println(j);
		 
			 //sum=sum + calculation.get(j);
			 System.out.println("sum:" + sum);
			 j=j+1;
		 }while(j<calculation.size());


		 
	}
		
		
		
		private static void mapPractice(){
			HashMap<String, String> sureshMap = new HashMap<String, String>();
			
			sureshMap.put("name", "Suresh Tiwari");
			sureshMap.put("flyingFrom", "Delhi");
			sureshMap.put("flyingTo", "Mumbai");
			sureshMap.put("flyingDate", "12-Jun-2017");
			sureshMap.put("returnDate", "13-Jun-2017");
			
			//System.out.println(sureshMap);
			
			HashMap<String, String> deeptiMap = new HashMap<String, String>();
			
			deeptiMap.put("name", "Deepti Tiwari");
			deeptiMap.put("flyingFrom", "Cal");
			deeptiMap.put("flyingTo", "USA");
			deeptiMap.put("flyingDate", "12-Jun-2017");
			deeptiMap.put("returnDate", "13-Jun-2017");
			
			//System.out.println(deeptiMap);
			
			ArrayList<HashMap<String, String>> flightdata = new ArrayList();
			flightdata.add(sureshMap);
			flightdata.add(deeptiMap);
			
			
			
			 for (int i=0;i<flightdata.size();i++){
			
				HashMap<String, String>  tempMap = flightdata.get(i);
			 
				  System.out.println("flightdata:" + tempMap);
				 
			 }
				
			
			 
		
			 }
			
		
		
		
	private static void deeptiArraylistandForLoopPractice() {

		ArrayList<Integer> salary = new ArrayList();
		salary.add(3000);
		salary.add(4000);
		salary.add(8000);
		salary.add(7000);
		System.out.println(salary.size());

		for (int i = 0; i <= salary.size() - 1; i++) {

			if (salary.get(i) < 5000) {
				System.out.println("Poor Employee " + salary.get(i));
			} else {
				System.out.println("Rich Employee " + salary.get(i));
			}
		}
		
		ArrayList<Integer> salary1;
		salary1= salary;
		System.out.println("salary:" + salary);
		System.out.println("salary1:" + salary1);
		
	}
				
			
			

	
		

	
	
}
