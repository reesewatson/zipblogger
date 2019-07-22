package com.zipcode.zipblogger;

import com.zipcode.zipblogger.RESTControllers.HomeController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.validation.constraints.AssertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZipbloggerApplicationTests {

	//Test functionality of HomeController method
	@Test
	public void testApp() {
		HomeController hc = new HomeController();
		String actual = hc.home();
		assertEquals(actual, "Zip Blogger here! On call and on duty with zippy and nifty blog posts to spur on your coding journey!");
	}

	@Test
	public void contextLoads() {
	}
}
