package com.demo.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.demo.web.model.Alien;

public class AlienDao {

	public Alien getAlien(int aid) {
		Alien a = new Alien();
//		a.setAid(1);
//		a.setAname("Teena");
//		a.setTech("QA");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "christal");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from alien where aid=" + aid);

			if (rs.next()) {
				a.setAid(rs.getInt("aid"));
				a.setAname(rs.getString("aname"));
				a.setTech(rs.getString("tech"));
			}
		} catch (Exception e) {
			e.getStackTrace();
		}

		return a;
	}
}
