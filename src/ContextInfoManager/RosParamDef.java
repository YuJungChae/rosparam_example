package ContextInfoManager;

import java.util.ArrayList;

public class RosParamDef {
	
	public static enum Key{
		WEATHER("context/weather"), TIME("context/time"),
		LIKE("context/like"), DISLIKE("context/dislike"), PREFERENCE("context/preference"),
		UNCOMFORTABLE("context/uncomforable"), IMPOSSIBLE("context/impossible"),
		LIKEABILITY("context/likeability"), SERVICE("context/service");
		
		
		private String value;
		
		Key(String value)
		{
			this.value = value;
		}
		
		public String getStr()
		{
			return value;
		}
		
		static public ArrayList<String> getKeyList()
		{
			ArrayList<String> keyList=new ArrayList<String>();
			for(Key key: RosParamDef.Key.values())
			{
				keyList.add(key.getStr());
			}
			return keyList;
		} 
		
	}

}
