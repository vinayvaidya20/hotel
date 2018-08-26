package com.priceline.gcp.gcpdemo.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.priceline.gcp.gcpdemo.GcpDemoApplication;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@RequestMapping(method = RequestMethod.POST, value = "/")
	public ResponseEntity<HotelResponse> addHotel(@RequestBody HotelRequest hotel) throws SQLException {
		HotelResponse hotelResponse =new HotelResponse();
		HttpStatus httpStatus = HttpStatus.OK;
		PreparedStatement statement = GcpDemoApplication.getConnection().prepareStatement("insert into Hotel values(?,?,?,?,?)");
		
		statement.setLong(1,hotel.getId());//1 specifies the first parameter in the query  
		statement.setString(2,hotel.getName()); 
		statement.setString(3,hotel.getDescription()); 
		statement.setString(4,hotel.getMinRate()); 
		statement.setString(5,hotel.getHotelCity()); 
		  
		boolean isExecuted=statement.execute();  
		if(isExecuted)
		{
			hotelResponse.setCode("201");
			hotelResponse.setMessage("Hotel Information Added");
			hotelResponse.setType("CREATED");;
		}
		else {
			hotelResponse.setCode("500");
			hotelResponse.setMessage("Internal Error");
			hotelResponse.setType("ERROR");
			 httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		ResponseEntity<HotelResponse> responseEntity = new ResponseEntity<>(hotelResponse, httpStatus);
		return responseEntity;
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/{name}")
	public String getGreeting(@PathVariable String name) throws SQLException {
		String lastNAME= "";
		  String instanceConnectionName = "gcp-example-demo:us-central1:demo-sql-instance";

	    // TODO: fill this in
	    // The database from which to list tables.
	    String databaseName = "TestDatabase";

	    String username = "proxyuser";

	    // TODO: fill this in
	    // This is the password that was set via the Cloud Console or empty if never set
	    // (not recommended).
	    String password = "password";

	    if (instanceConnectionName.equals("<insert_connection_name>")) {
	      System.err.println("Please update the sample to specify the instance connection name.");
	      System.exit(1);
	    }

	    if (password.equals("<insert_password>")) {
	      System.err.println("Please update the sample to specify the mysql password.");
	      System.exit(1);
	    }

	    //[START doc-example]
	    
	    String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/TestDatabase?useSSL=false";
		Connection connection1 = DriverManager.getConnection(jdbcUrl, username, password);
	   //[END doc-example]

	    try (Statement statement = connection1.createStatement()) {
	      ResultSet resultSet = statement.executeQuery("SHOW TABLES");
	      while (resultSet.next()) {
	        System.out.println(resultSet.getString(1));
	      }
	    }
	  
		
		
	    try (Statement statement = connection1.createStatement()) {
		      ResultSet resultSet = statement.executeQuery("select * from Persons");
		      while (resultSet.next()) {
		        System.out.println(resultSet.getInt(1));
		        lastNAME = resultSet.getString(2);
		        System.out.println(resultSet.getString(2));
		        System.out.println(resultSet.getString(3));
		      }
		    }
		return "Hello, "+name+" "+lastNAME;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String getResult() throws SQLException {
	
		return "SUCCESS";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/con")
	public String getResult1() throws SQLException {
		String lastNAME= "";
		  String instanceConnectionName = "gcp-example-demo:us-central1:demo-sql-instance";

	    // TODO: fill this in
	    // The database from which to list tables.
	    String databaseName = "TestDatabase";

	    String username = "proxyuser";

	    // TODO: fill this in
	    // This is the password that was set via the Cloud Console or empty if never set
	    // (not recommended).
	    String password = "password";

	    if (instanceConnectionName.equals("<insert_connection_name>")) {
	      System.err.println("Please update the sample to specify the instance connection name.");
	      System.exit(1);
	    }

	    if (password.equals("<insert_password>")) {
	      System.err.println("Please update the sample to specify the mysql password.");
	      System.exit(1);
	    }

	    //[START doc-example]
	    
	    String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/TestDatabase?useSSL=false";
		Connection connection2 = DriverManager.getConnection(jdbcUrl, username, password);
	   //[END doc-example]

		return "Hello, "+" "+connection2;
	}

}
