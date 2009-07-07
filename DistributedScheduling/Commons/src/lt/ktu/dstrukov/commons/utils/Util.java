package lt.ktu.dstrukov.commons.utils;


import java.io.StringWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Util {
	
	public static String ObjectToString(Object o){
		
		XStream xstream = new XStream(new DomDriver());
		StringWriter w = new StringWriter(10000);
		xstream.toXML(o, w);
		return w.toString();
	}
	
	
	public static Object StringToObject(String o){
		XStream xstream = new XStream(new DomDriver());
		return xstream.fromXML(o);
	}
	
	

}
