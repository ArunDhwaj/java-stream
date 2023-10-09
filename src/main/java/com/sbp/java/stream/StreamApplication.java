package com.sbp.java.stream;

import com.sbp.java.stream.poc.GroupingByPoc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class StreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamApplication.class, args);
		log.info("Java Stream POC");

		GroupingByPoc groupingByPoc = new GroupingByPoc();
		groupingByPoc.groupBy();
	}

}
