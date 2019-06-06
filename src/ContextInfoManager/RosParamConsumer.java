package ContextInfoManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ros.node.ConnectedNode;
import org.ros.node.parameter.ParameterTree;

public class RosParamConsumer {
	
	private ConnectedNode mNode;
	private ParameterTree mParam;
	
	public RosParamConsumer(ConnectedNode connectedNode) {
		mNode = connectedNode;
		mParam = mNode.getParameterTree();
	}
	
	public String getTime()
	{		
		return mParam.getString(RosParamDef.Key.TIME.getStr());
	}
	
	public String getWeather()
	{		
		return mParam.getString(RosParamDef.Key.WEATHER.getStr());
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getLike()
	{
		return (List<String>) mParam.getList(RosParamDef.Key.LIKE.getStr());
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getDisLike()
	{
		return (List<String>) mParam.getList(RosParamDef.Key.DISLIKE.getStr());
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Boolean> getPreference()
	{
		return (Map<String, Boolean>) mParam.getMap(RosParamDef.Key.PREFERENCE.getStr());
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getUncomfortable()
	{
		return (List<String>) mParam.getList(RosParamDef.Key.UNCOMFORTABLE.getStr());
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getImpossible()
	{
		return (List<String>) mParam.getList(RosParamDef.Key.IMPOSSIBLE.getStr());
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Boolean> getLikeability()
	{
		return (Map<String, Boolean>) mParam.getMap(RosParamDef.Key.LIKEABILITY.getStr());
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getRobotService()
	{
		return (List<String>) mParam.getList(RosParamDef.Key.SERVICE.getStr());
	}
	
	public boolean isParamAll() 
	{
		ArrayList<String> keyList = RosParamDef.Key.getKeyList();
		for(String key: keyList)
		{
			if(mParam.has(key) == false)
				return false;
		}
		
		return true;
	}

}
