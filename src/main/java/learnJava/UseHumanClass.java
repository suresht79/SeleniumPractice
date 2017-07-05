package learnJava;

import java.util.ArrayList;
import java.util.Date;

public class UseHumanClass {
	

	 public static void main(String[] args) {
		 
		 
		 
		 User deepti = new User();
		 User deepali=deepti;
		 deepti.name="Deepti Tiwari";
		 deepti.color="black";
		 deepti.eyeColor="white";
		 deepti.height=5.4;
		 deepti.relegion="hindu";
		 System.out.println(deepti);
		 
		 
		 
		 
		 
		 Car deeptiCar = new Car();
		 deeptiCar.color="Red";
		 deeptiCar.model="Accord";
		 deeptiCar.year= 2006;
		 System.out.println(deeptiCar);
		 
		 
		 
		 //User Suresh
		 User suresh = new User();
		 
		 suresh.name="Suresh Tiwari";
		 suresh.eyeColor="black";
		 suresh.race="Asian";
		 suresh.height=5.11;
		 suresh.relegion="Hindu";
		 
		 //Suresh Car
		 Car sureshCar = new Car();
		 sureshCar.color="Red";
		 sureshCar.model="Nissan";
		 sureshCar.year= 2013;
		 suresh.car=sureshCar;
		 
		 //Suresh Jobs
		 Job sureshJob1 = new Job();
		 sureshJob1.currentJob=true;
		 sureshJob1.employer="TCS";
		 sureshJob1.salary=10000.00;
		 
		 Job sureshJob2 = new Job();
		 sureshJob2.currentJob=false;
		 sureshJob2.employer="Verizon";
		 sureshJob2.salary=8000.00;
		
		 ArrayList sureshJobs = new ArrayList();
		 sureshJobs.add(sureshJob1);
		 sureshJobs.add(sureshJob2);
		 
		 //System.out.println(sureshJobs);
		 
		 suresh.jobs=sureshJobs;
		 
		 Job currentJob = giveUserCurrentJob(suresh);
		 System.out.println("Current Job:" + currentJob);
		 System.out.println("All Jobs:" + suresh.jobs);
		 
		 
		 System.out.println(suresh);
		 
		 Date date = new Date();

	      // display time and date using toString()
	      System.out.println(date.toString());
		 
	 }

	private static Job giveUserCurrentJob(User user) {
		//Print Suresh Current Job
		 for (Job job: user.jobs){
			 if(job.currentJob==true){
				 return job;
			 }
		 }
		 return null;
	}
	

}
