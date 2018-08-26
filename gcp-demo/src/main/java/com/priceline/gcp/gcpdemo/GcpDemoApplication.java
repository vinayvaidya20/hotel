package com.priceline.gcp.gcpdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class GcpDemoApplication {
static	Connection connection = null;

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(GcpDemoApplication.class, args);

	    // TODO: fill this in
	    // The instance connection name can be obtained from the instance overview page in Cloud Console
	    // or by running "gcloud sql instances describe <instance> | grep connectionName".

	    // TODO: fill this in
	    // The database from which to list tables.
	    String databaseName = "TestDatabase";

	    String username = "proxyuser";

	    // TODO: fill this in
	    // This is the password that was set via the Cloud Console or empty if never set
	    // (not recommended).
	    String password = "password";

	  

	    if (password.equals("<insert_password>")) {
	      System.err.println("Please update the sample to specify the mysql password.");
	      System.exit(1);
	    }

	    //[START doc-example]
/*	    
	    String jdbcUrl = String.format(
	        "jdbc:mysql://127.0.0.1:3306/%s?cloudSqlInstance=%s"
	            + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false",
	        databaseName,
	        instanceConnectionName);*/
	    String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/TestDatabase?useSSL=false";
		 connection = DriverManager.getConnection(jdbcUrl, username, password);
	   //[END doc-example]

	    try (Statement statement = connection.createStatement()) {
	      ResultSet resultSet = statement.executeQuery("SHOW TABLES");
	      while (resultSet.next()) {
	        System.out.println(resultSet.getString(1));
	      }
	    }
	  }

	public static Connection getConnection() throws SQLException {

		return connection;
	}
	
	
	}

