package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Departmentdto;

public class Departmentdao {
	private Database_Controller databaseController = Database_Controller.getDatabase_Controller();

	public int create() {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("insert into department(departmentid,departmentname) values(?,?)");
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
			stmt = conn.prepareStatement("update department  set  departmentname=?  where departmentid=?");
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
			stmt = conn.prepareStatement("delete from department where departmentid=?");
			final int result = stmt.executeUpdate();
			return result;

		} catch (final Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			databaseController.close(stmt, conn);
		}
	}

	public Departmentdto retrieve() {
		final Departmentdto departments = new Departmentdto();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("select * from department where departmentid=?");
			result = stmt.executeQuery();
			while (result.next()) {

				departments.setDepartmentname(result.getString("deparmentname"));
				departments.setDepartmentid(result.getInt("departmentid"));

			}
			return departments;
		} catch (final Exception e) {
			e.printStackTrace();
			return departments;
		} finally {
			databaseController.close(result, stmt, conn);
		}
	}

}






