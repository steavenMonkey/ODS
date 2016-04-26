package test.com.manyouyou.ordersystem.utils;

import com.manyouyou.ordersystem.utils.StringUtil;

public class Base64EncoderTestcase {
	
	public static void main(String[] args) {
		String str = StringUtil.encode("primeton:primeton4cloud");
		System.out.println(str);
	}
}
