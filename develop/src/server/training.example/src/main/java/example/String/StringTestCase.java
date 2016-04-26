package example.String;

import org.junit.Test;

public class StringTestCase {
	
	@Test
	public void testValue(){
		String str = null;
		try {
			setValue(str);
			System.out.println(str);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void setValue(String str){
		str = "ss";
	}
}
