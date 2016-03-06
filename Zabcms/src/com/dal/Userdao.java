package com.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Userdto;
public class Userdao {
	

	

		private Database_Controller databaseController = Database_Controller.getDatabase_Controller();

		public int create() {
			Connection conn = null;
			PreparedStatement stmt = null;
            
			try {
				conn = databaseController.getConnection();
				stmt = conn.prepareStatement("insert into users(username,password,email,fullname) values(?,?,?,?)");
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
				stmt = conn.prepareStatement("update users set username=?, fullname=?, email=?, password=? "+
	                    		" where id=?");
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
				stmt = conn.prepareStatement("delete from users where id=?");
				final int result = stmt.executeUpdate();
				return result;

			} catch (final Exception e) {
				e.printStackTrace();
				return 0;
			} finally {
				databaseController.close(stmt, conn);
			}
		}

		public Userdto retrieve() {
			final Userdto users = new Userdto();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet result = null;
			
			try {
				conn = databaseController.getConnection();
				stmt = conn.prepareStatement("select * from users where id =?");
				result = stmt.executeQuery();
				while (result.next()) {

					users.setFull_name(result.getString("fullname"));
					users.setId(result.getInt("id"));

				}
				return users;
			} catch (final Exception e) {
				e.printStackTrace();
				return users;
			} finally {
				databaseController.close(result, stmt, conn);
			}
		}

	}


