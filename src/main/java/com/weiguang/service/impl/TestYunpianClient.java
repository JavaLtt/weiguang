/**
 * 
 */
package com.weiguang.service.impl;

import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.constant.YunpianConstant;
import org.junit.After;
import org.junit.Before;
import org.springframework.stereotype.Component;

/**
 * @author dzh
 * @date Nov 18, 2016 7:58:27 PM
 * @since 1.2.0
 */
@Component
public class TestYunpianClient implements YunpianConstant {

	public static final String TESTKEY = "f6947db1a5b6edf15acfe15bf18a301d";//keyid

	YunpianClient clnt;

	@Before
	public void init() {
		clnt = new YunpianClient(TestYunpianClient.TESTKEY,
				TestYunpianClient.class.getResourceAsStream("/yunpian_online.properties")).init();
	}

	@After
	public void close() {
		clnt.close();
	}

}