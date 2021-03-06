package com.lixiaodao.dubbotest.demo.consumer;

import org.junit.Test;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.lixiaodao.dubbotest.demo.api.Hello;

public class DubboConsumerTest {
	
	@Test
	public void testConsumer(){
		ApplicationConfig application = new ApplicationConfig();
		application.setName("yyy");
		 
		RegistryConfig registry = new RegistryConfig();
		registry.setAddress("zookeeper://10.1.200.134:2181");
		 
		 
		ReferenceConfig<Hello> reference = new ReferenceConfig<Hello>();
		reference.setApplication(application);
		reference.setRegistry(registry); 
		reference.setInterface(Hello.class);
		reference.setVersion("1.0.0");
		 
		Hello xxxService = reference.get();
		
		xxxService.sayHello();
		
	}
	
	@Test
	public void testConsumerLocal(){
		ApplicationConfig application = new ApplicationConfig();
		application.setName("yyy");
		 
		RegistryConfig registry = new RegistryConfig();
		registry.setAddress("N/A");
		 
		 
		ReferenceConfig<Hello> reference = new ReferenceConfig<Hello>();
		reference.setApplication(application);
		reference.setRegistry(registry); 
		reference.setInterface(Hello.class);
		reference.setVersion("1.0.0");
		reference.setProtocol("injvm");
		 
		Hello xxxService = reference.get();
		
		xxxService.sayHello();
		
	}
}
