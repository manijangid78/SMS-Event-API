package com.example.BackendAPI;

import com.example.BackendAPI.service.AppService;
import com.example.BackendAPI.service.IntervalProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class BackendApiApplication implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(BackendApiApplication.class, args);
	}

	@Autowired
	AppService service;

	@Override
	public void run(String... args) throws Exception {
		service.removeEvent("1222");
		Timer timer = new Timer();
		TimerTask task = new IntervalProcess(service);
		timer.schedule(task, 2000, 5000);  // 2000 - delay (can set to 0 for immediate execution), 5000 is a frequency
	}
}
