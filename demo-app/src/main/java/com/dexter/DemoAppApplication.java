package com.dexter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootApplication
public class DemoAppApplication implements CommandLineRunner{

	@Autowired
	public MyService myService;

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(args.length==1) {
			System.out.println(myService.getMessage(args[0]));
		}else {
			System.out.println(myService.getMessage("World"));
		}

	}
}*/

@SpringBootApplication
public class DemoAppApplication{

	@Autowired
	public MyService myService;

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
	}
}