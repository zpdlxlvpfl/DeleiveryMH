package com.hwyj.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static {
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("org.mariadb.jdbc.Driver"); //mariadb
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void testConnectionMySQL() {
		
		try (Connection con =
			 DriverManager.getConnection("jdbc:log4jdbc:mariadb://192.168.0.36:3306/testdb",
					 "delivery","1234")) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}		
	}
	


}
