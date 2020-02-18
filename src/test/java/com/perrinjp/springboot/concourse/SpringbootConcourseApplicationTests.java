package com.perrinjp.springboot.concourse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.perrinjp.tutorial.internalization.MvcConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = MvcConfig.class) 
public class SpringbootConcourseApplicationTests {

	@Test
	public void contextLoads() {
	}

}
