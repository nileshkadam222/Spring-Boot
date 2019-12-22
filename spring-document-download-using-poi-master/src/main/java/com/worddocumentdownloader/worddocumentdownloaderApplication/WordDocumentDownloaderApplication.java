package com.worddocumentdownloader.worddocumentdownloaderApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com")
public class WordDocumentDownloaderApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(WordDocumentDownloaderApplication.class, args);
	}

}
