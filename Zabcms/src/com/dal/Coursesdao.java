package com.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Coursesdto;
public class Coursesdao {
	

		

			private Database_Controller databaseController = Database_Controller.getDatabase_Controller();

			public int create() {
				Connection conn = null;
				PreparedStatement stmt = null;

				try {
					conn = databaseController.getConnection();
					stmt = conn.prepareStatement("insert into courses(coursenumber,coursename) values(?,?)");
					final int result = stmt.executeUpdate();
					return result;

				} catch (final Exception e) {
					e.printStackTrace();
					return 0;
				} finally {
					databaseController.close(stmt, conn);
				}
			}

			public int update() {
				Connection conn = null;
				PreparedStatement stmt = null;

				try {
					conn = databaseController.getConnection();
					stmt = conn.prepareStatement("update courses set coursename=? "+
	                    		" where coursenumber=?");
					final int result = stmt.executeUpdate();
					return result;

				} catch (final Exception e) {
					e.printStackTrace();
					return 0;
				} finally {
					databaseController.close(stmt, conn);
				}
			}

			public int delete() {
				Connection conn = null;
				PreparedStatement stmt = null;

				try {
					conn = databaseController.getConnection();
					stmt = conn.prepareStatement("delete from courses where coursenumber=?");
					final int result = stmt.executeUpdate();
					return result;

				} catch (final Exception e) {
					e.printStackTrace();
					return 0;
				} finally {
					databaseController.close(stmt, conn);
				}
			}

			public Coursesdto retrieve() {
				final Coursesdto courses = new Coursesdto();
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet result = null;
				try {
					conn = databaseController.getConnection();
					stmt = conn.prepareStatement("select * from courses where coursenumber=?");
					result = stmt.executeQuery();
					while (result.next()) {

						courses.setCoursename(result.getString("coursename"));
						courses.setCoursenumber(result.getString("coursenumber"));

					}
					return courses;
				} catch (final Exception e) {
					e.printStackTrace();
					return courses;
				} finally {
					databaseController.close(result, stmt, conn);
				}
			}

		}




