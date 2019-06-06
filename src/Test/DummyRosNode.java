package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ros.namespace.GraphName;
import org.ros.node.ConnectedNode;
import org.ros.node.Node;
import org.ros.node.NodeMain;

import ContextInfoManager.RosParamConsumer;
import ContextInfoManager.RosParamDef;
import ContextInfoManager.RosParamDef.Key;
import ContextInfoManager.RosParamRegister;


public class DummyRosNode implements NodeMain{

	@Override
	public void onStart(ConnectedNode connectedNode) {
		
		register(connectedNode);		
		consumer(connectedNode);
		
		
		//Register should remove all parameters when it was finished.

		onDestroyParam(connectedNode);
		consumer(connectedNode);
		
		
		
	}
	
	private void register(ConnectedNode connectedNode)
	{
		System.out.println("\n--------Regist all parameters---------");
		RosParamRegister register = new RosParamRegister(connectedNode);
		register.setWeather("Good");
		
		register.setTime("Day");
		
		List<String> likeThings  = Arrays.asList("Cat", "Dog");
		register.setLike(likeThings);
		
		List<String> dislikeThings  = Arrays.asList("Fruit");
		register.setDisLike(dislikeThings);
		
		Map<String, Boolean> preference = new HashMap<String, Boolean>();
		preference.put("Dog", true);
		preference.put("Fruit", false);
		register.setPreference(preference);

		List<String> uncomfortable  = Arrays.asList("Chewing");
		register.setUncomfortable(uncomfortable);
		
		List<String> impossible  = Arrays.asList("Eat");
		register.setImpossible(impossible);
		
		Map<String, Boolean> likeability = new HashMap<String, Boolean>();
		likeability.put("Doctor", false);
		likeability.put("Granddaughter", true);
		register.setLikeability(likeability);
		
		List<String> service  = Arrays.asList("Alarm");
		register.setRobotService(service);
	}
	
	private void consumer(ConnectedNode connectedNode) 
	{
		System.out.println("\n--------Take all parameters---------");
		RosParamConsumer consumer = new RosParamConsumer(connectedNode);
		if(consumer.isParamAll() == true)
		{
			System.out.println("Ros::Weather: " + consumer.getWeather());
			System.out.println("Ros::Time: " + consumer.getTime());
			System.out.println("ROS::LikeThings: " + consumer.getLike());
			System.out.println("ROS::DisLikeThings: " + consumer.getDisLike());
			System.out.println("ROS::Preference: " + consumer.getPreference());
			System.out.println("ROS::Unconfortable: " + consumer.getUncomfortable());	
			System.out.println("ROS::Impossible: " + consumer.getImpossible());	
			System.out.println("ROS::Likeability: " + consumer.getLikeability());	
			System.out.println("ROS::Service: " + consumer.getRobotService());
		}
		else
		{
			System.out.println("Empty");
		}
		
	}
	
	private void onDestroyParam(ConnectedNode connectedNode)
	{
		System.out.println("\n--------Delete all parameters---------");
		RosParamRegister register = new RosParamRegister(connectedNode);
		register.delAllParam();
	}
	
	

	@Override
	public void onShutdown(Node node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onShutdownComplete(Node node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Node node, Throwable throwable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GraphName getDefaultNodeName() {
		return GraphName.of("Test/DummyRosNode");
	}

}
