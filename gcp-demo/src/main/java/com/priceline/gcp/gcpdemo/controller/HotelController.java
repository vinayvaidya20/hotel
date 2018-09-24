package com.priceline.gcp.gcpdemo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<HotelResponse> addHotel(@RequestBody HotelRequest hotel) {
		HotelResponse hotelResponse =new HotelResponse();
		HttpStatus httpStatus = HttpStatus.OK;
		PreparedStatement statement;
		try {
			statement = GcpDemoApplication.getConnection().prepareStatement("insert into Hotel values(?,?,?,?,?)");
			statement.setInt(1,hotel.getHotelId());//1 specifies the first parameter in the query  
			statement.setString(2,hotel.getHotelName()); 
			statement.setString(3,hotel.getDescription()); 
			statement.setString(4,hotel.getHotelMinRate()); 
			statement.setString(5,hotel.getHotelCity()); 
			statement.execute(); 
			hotelResponse.setCode("201");
			hotelResponse.setMessage("Hotel Information Added");
			hotelResponse.setType("CREATED");
		} catch (SQLException e) {
			hotelResponse.setCode("500");
			hotelResponse.setMessage("Internal Error");
			hotelResponse.setType("ERROR");
			 httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		ResponseEntity<HotelResponse> responseEntity = new ResponseEntity<>(hotelResponse, httpStatus);
		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<HotelFetchResponse> getHotel(@PathVariable int id) throws SQLException {
		HotelFetchResponse hotelFetchResponse = new HotelFetchResponse();
		
		String selectSQL = "SELECT * FROM Hotel WHERE HotelId = ?";
		PreparedStatement preparedStatement = GcpDemoApplication.getConnection().prepareStatement(selectSQL);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			hotelFetchResponse.setId(rs.getInt("HotelId"));
			hotelFetchResponse.setDescription(rs.getString("Description"));
			hotelFetchResponse.setHotelCity(rs.getString("City"));
			hotelFetchResponse.setHotelMinRate(rs.getString("MinRate"));
			hotelFetchResponse.setHotelName(rs.getString("HotelName"));
		}
		ResponseEntity<HotelFetchResponse> responseEntity = new ResponseEntity<>(hotelFetchResponse,HttpStatus.OK);
		return responseEntity;
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String getResult() throws SQLException {
	
		return "SUCCESS1";
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
