package com.cas;

import org.apache.shiro.crypto.hash.ConfigurableHashService;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

/**
 * 加密测试 <br>
 * 版权：Copyright (c) 2016-2019<br>
 * 作者：孙常军<br>
 * 版本：1.0<br>
 * 创建日期：2019年3月31日<br>
 */
public class PasswordSaltTest {
	private String staticSalt = ".";
	private String algorithmName = "MD5";
	private String encodedPassword = "123456";
	private String dynaSalt = "test";

	@Test
	public void test() throws Exception {
		ConfigurableHashService hashService = new DefaultHashService();
		hashService.setPrivateSalt(ByteSource.Util.bytes(this.staticSalt));
		hashService.setHashAlgorithmName(this.algorithmName);
		hashService.setHashIterations(2);
		HashRequest request = new HashRequest.Builder().setSalt(dynaSalt).setSource(encodedPassword).build();
		String res = hashService.computeHash(request).toHex();
		System.out.println(res);
	}
}
