/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import serialuploader.SerialUploader;
import util.DbConnection;

/**
 *
 * @author bachtiar
 */
public class FlagManagement {

    void flagUploaded(Long id) {
        String query = QueryManagement.FLAG_SERIAL_DATA_UPLOADED;
        Connection conn = null;

        try {

            conn = DriverManager.getConnection(DbConnection.MYSQL_URL, DbConnection.MYSQL_UNAME, DbConnection.MYSQL_PASSWORD);

            PreparedStatement insertUpload = conn.prepareStatement(query);

            insertUpload.setLong(1, id);
            insertUpload.executeUpdate();

        } catch (SQLException | NumberFormatException e) {
            System.out.println(e);
        } finally {
            try {
                conn.close();

            } catch (SQLException ex) {
                Logger.getLogger(SerialUploader.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
