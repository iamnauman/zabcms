package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.model.Documentsdto;
public class Documentsdao {
	

	
		

		

			private Database_Controller databaseController = Database_Controller.getDatabase_Controller();

			public int create() {
				Connection conn = null;
				PreparedStatement stmt = null;
	            
				try {
					conn = databaseController.getConnection();
					stmt = conn.prepareStatement("insert into documents(documentsid,documentname,documentsmaterial) values(?,?,?)");
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
					stmt = conn.prepareStatement("update documents set documentsid=?, documentname=?, documentmaterial=?"+
		                    		" where documentid=?");
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
					stmt = conn.prepareStatement("delete from documents where documentid=?");
					final int result = stmt.executeUpdate();
					return result;

				} catch (final Exception e) {
					e.printStackTrace();
					return 0;
				} finally {
					databaseController.close(stmt, conn);
				}
			}

			public Documentsdto retrieve() {
				final Documentsdto documents = new Documentsdto();
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet result = null;
				
				try {
					conn = databaseController.getConnection();
					stmt = conn.prepareStatement("select * from documents where documentid =?");
					result = stmt.executeQuery();
					while (result.next()) {

						documents.setDocumentname(result.getString("documentname"));
						documents.setDocumentsid(result.getInt("documentid"));
						documents.setDocumentsmaterial(result.getBlob("documentmaterial"));
					}
					return documents;
				} catch (final Exception e) {
					e.printStackTrace();
					return documents;
				} finally {
					databaseController.close(result, stmt, conn);
				}
			}

		}




