package com.sda.playermanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

	private static final Logger log = LogManager.getLogger(App.class);
	private static final String url = "jdbc:mysql://localhost:3306/players";
	private static final String user = "root";
	private static final String pass = "root";

	public static void main(String[] args){
		if (log.isDebugEnabled()) {
			log.info("main(): IN:");
		}
		System.out.println("Hello World!");

		App app = new App();
		app.parseAllPlayers();

		if (log.isDebugEnabled()) {
			log.info("main(): OUT:");
		}
	}

	public void parseAllPlayers() {
		if (log.isDebugEnabled()) {
			log.debug("parseAllPlayers():IN:");
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select 1");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (log.isDebugEnabled()) {
			log.debug("parseAllPlayers():OUT:");
		}
	}
}
