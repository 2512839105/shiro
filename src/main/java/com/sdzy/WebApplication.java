package com.sdzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import com.asdzy.common.mybatisplus.MapperScan;

@SpringBootApplication
@ImportResource("classpath:conf/transaction.xml")
@MapperScan("${mybatis-plus.mapperScan}")
public class WebApplication extends SpringBootServletInitializer{

	public static void main(String[] args) { 
		System.out.println(System.currentTimeMillis()+"main....");  
		SpringApplication.run(WebApplication.class, args);	
	}	
	 @Override  
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
	       return application.sources(WebApplication.class);  
	  }  

}
 