package ContextInfoManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ros.node.ConnectedNode;
import org.ros.node.parameter.ParameterTree;

public class RosParamRegister {
	
	private ConnectedNode mNode;
	private ParameterTree mParam;
	
	public RosParamRegister(ConnectedNode connectedNode) {
		mNode = connectedNode;
		mParam = mNode.getParameterTree();
	}
	
	public void setTime(String time)
	{
		mParam.set(RosParamDef.Key.TIME.getStr(), time);
	}
	
	public void setWeather(String weather)
	{
		mParam.set(RosParamDef.Key.WEATHER.getStr(), weather);
	}
	
	public void setLike(List<String> things)
	{
		mParam.set(RosParamDef.Key.LIKE.getStr(), things);
	}
	
	public void setDisLike(List<String> things)
	{
		mParam.set(RosParamDef.Key.DISLIKE.getStr(), things);
	}
	
	public void setPreference(Map<String, Boolean> things)
	{
		mParam.set(RosParamDef.Key.PREFERENCE.getStr(), things);
	}
	
	public void setUncomfortable(List<String> things)
	{
		mParam.set(RosParamDef.Key.UNCOMFORTABLE.getStr(), things);
	}
	
	public void setImpossible(List<String> things)
	{
		mParam.set(RosParamDef.Key.IMPOSSIBLE.getStr(), things);
	}
	
	public void setLikeability(Map<String, Boolean> things)
	{
		mParam.set(RosParamDef.Key.LIKEABILITY.getStr(), things);
	}
	
	public void setRobotService(List<String> things)
	{
		mParam.set(RosParamDef.Key.SERVICE.getStr(), things);
	}
	
	public void delAllParam()
	{
		ArrayList<String> keyList = RosParamDef.Key.getKeyList();
		for(String key: keyList)
		{
			if(mParam.has(key) == true)
				mParam.delete(key);
		}
	}

}
