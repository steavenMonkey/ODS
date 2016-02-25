package test.com.manyouyou.ordersystem.utils;

import org.junit.Assert;
import org.junit.Test;

import com.manyouyou.ordersystem.utils.StringUtil;

public class StringUtilTestCase {

	@Test
	public void testEncode() {
		String str = "sss";
		System.out.println(StringUtil.encode(str));
	}

	@Test
	public void testDecode() {
		String str = "c3Nz";
		String ret = StringUtil.decode(str);
		Assert.assertTrue("the tow str is the same", ret.equals("sss"));
	}

}
