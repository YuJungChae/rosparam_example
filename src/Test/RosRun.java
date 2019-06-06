package Test;


public class RosRun {

	public static void main(String[] args) {
		RosRun rosRun=new RosRun();
			
		 String[] dummy={"Test.DummyRosNode"};	 
	 
		 try {
	         org.ros.RosRun.main(dummy);
	         }  catch(Exception e) {
	        	 System.out.println("Test::RosRun Fail..");
	         }

	}

}
