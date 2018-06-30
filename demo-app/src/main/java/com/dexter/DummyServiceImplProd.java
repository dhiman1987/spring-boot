package com.dexter;

import java.time.LocalTime;
import java.time.ZoneId;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class DummyServiceImplProd implements DummyService{

	@Override
	public String getTime() {
		return "Server Time (America/Los_Angeles) "+LocalTime.now(ZoneId.of("America/Los_Angeles"));
	}

}
