package com.dexter;

import java.time.LocalTime;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DummyServiceImplDev implements DummyService{

	@Override
	public String getTime() {
		return "Server Time (India/Kolkata) "+LocalTime.now();
	}

}
