package com.example.assignment2_soap;


import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


@WebService(serviceName = "Fibonacci Numbers Service")
public class Assignment2SoapWS {
	
	
	@WebMethod(operationName = "Fibonacci")
	public static int[] fibonacci() {
		
		int[] fibonacciArray = new int[10];
		fibonacciArray[0] = 0;
		fibonacciArray[1] = 1;
		
		for (int i = 2;
			 i < 10;
			 i++) {
			fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
		}
		
		return fibonacciArray;
		
	}
	
	
	@WebMethod(operationName = "Download")
	public static @XmlMimeType("application/octet-stream") DataHandler download() {
		
		DataSource dataSource = new FileDataSource(new File("src/main/resources/SampleFile.txt"));
		return new DataHandler(dataSource);
		
	}
	
	
	@WebMethod(operationName = "Upload")
	public static void upload(@WebParam(name = "file") DataHandler file) throws IOException {
		
		InputStream inputStream = file.getInputStream();
		byte[] bytes = new byte[100000];
		while ((inputStream.read(bytes)) != -1) {
		}
		
		try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/SampleFileDownloaded.txt")) {
			fileOutputStream.write(bytes);
			fileOutputStream.flush();
		}
		
	}
	
	
}