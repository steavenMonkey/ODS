package example.porperties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class ChangeProValue {
	
	public Map<String,String> loadProperties(){
		Map<String, String> res = new ConcurrentHashMap<String, String>();
		
		Properties pro = getPro();
		
		Iterator<Entry<Object, Object>> iter = pro.entrySet().iterator();
		while(iter.hasNext()){
			Entry<Object, Object> entry = iter.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			value = changeValue(value, "eos", "asp");
			res.put(key, value);
		}
		
		return res;
	}
	
	private Properties getPro(){
		Properties pro = new Properties();
		InputStream in = ChangeProValue.class.getResourceAsStream("test.properties");
		try {
			pro.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}
	
	public String changeValue(String value, String tobeChange, String nvalue){
		if(value.contains(tobeChange)){
			value = value.replaceAll(tobeChange, nvalue);
		}
		return value;
	}
	
	
	public void storeProperties(Map<String,String> pros){
		
		StringBuffer bf = new StringBuffer();
		for(String key : pros.keySet()){
			String value = pros.get(key);
			bf.append(key + "=" + value);
			bf.append("\n");
		}
		
		OutputStreamWriter osw = null;
		try {
			osw = new OutputStreamWriter(
						new FileOutputStream("/Users/weixin/workspace/eclipse_4.4.1_luna/workspace/spdb/example-training/src/example/porperties/test.properties"), "UTF-8");
			osw.write(bf.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(null != osw){
				try {
					osw.flush();
					osw.close();
				} catch (IOException e) {
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		ChangeProValue cp = new ChangeProValue();
		Map<String, String> pros = cp.loadProperties();
		cp.storeProperties(pros);
//		String t = "ddeos";
//		t = t.replaceAll("eos", "aps");
//		System.out.println(t);
	}
	
}
