/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import model.SerialCalibrationQueued;
import model.SerialCalibrationUploaded;
import model.SerialData;
import model.SerialDataUploaded;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import serialuploader.SerialUploader;
import util.DbConnection;
import util.Strings;

/**
 *
 * @author bachtiar
 */
public class UploadManagement {

  FlagManagement FM = new FlagManagement();

  private void serialDataUpload() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(DbConnection.MYSQL_URL, DbConnection.MYSQL_UNAME, DbConnection.MYSQL_PASSWORD);

      String query = QueryManagement.SELECT_TABLE_TO_UPLOAD;

      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);

      while (rs.next()) {

        Long id = rs.getLong("ID");
        SerialDataUploaded serialData = new SerialDataUploaded();
        
        serialData.setIDstart(rs.getLong("ID_start"));
        serialData.setIDend(rs.getLong("ID_end"));
        serialData.setTicketNo(rs.getString("ticket_no"));
        serialData.setStart(rs.getString("start"));
        serialData.setFinish(rs.getString("finish"));
        serialData.setStartCount(rs.getString("start_count"));
        serialData.setStartCountUom(rs.getString("start_count_uom"));
        serialData.setEndCount(rs.getString("end_count"));
        serialData.setEndCountUom(rs.getString("end_count_uom"));
        serialData.setGrossDeliver(rs.getString("gross_deliver"));
        serialData.setGrossDeliverUom(rs.getString("gross_deliver_uom"));
        serialData.setAvgFlowRate(rs.getString("avg_flow_rate"));
        serialData.setAvgFlowRateUom(rs.getString("avg_flow_rate_uom"));
        serialData.setSaleNumber(rs.getString("sale_number"));
        serialData.setMeterNumber(rs.getString("meter_number"));
        serialData.setUnitId(rs.getString("unit_id"));
        serialData.setDuplicate(rs.getString("duplicate"));
        serialData.setOtherOne(rs.getString("other_one"));
        serialData.setOtherTwo(rs.getString("other_two"));
        serialData.setOtherThree(rs.getString("other_three"));
        serialData.setOtherFour(rs.getString("other_four"));
        serialData.setOtherFive(rs.getString("other_five"));
        serialData.setDataState(rs.getString("data_state"));

        sendData(id, serialData);
      }
      conn.close();

    } catch (SQLException ex) {
      Logger.getLogger(SerialUploader.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void sendData(Long id, SerialDataUploaded sdu) {

    String line = "";
    StringBuilder sb = new StringBuilder();
    CloseableHttpClient client = HttpClients.createDefault();
    HttpPost post = new HttpPost(Strings.POST_CLOUD);

    try {
      List<NameValuePair> nameValuePairs = new ArrayList<>(1);
      nameValuePairs.add(new BasicNameValuePair("site-id", Strings.SITE_ID));
      nameValuePairs.add(new BasicNameValuePair("start-id", sdu.getIDstart().toString()));
      nameValuePairs.add(new BasicNameValuePair("end-id", sdu.getIDend().toString()));
      nameValuePairs.add(new BasicNameValuePair("ticket-no", sdu.getTicketNo()));
      nameValuePairs.add(new BasicNameValuePair("start", sdu.getStart()));
      nameValuePairs.add(new BasicNameValuePair("finish", sdu.getFinish()));
      nameValuePairs.add(new BasicNameValuePair("start-count", sdu.getStartCount()));
      nameValuePairs.add(new BasicNameValuePair("start-count-uom", sdu.getStartCountUom()));
      nameValuePairs.add(new BasicNameValuePair("end-count", sdu.getEndCount()));
      nameValuePairs.add(new BasicNameValuePair("end-count-uom", sdu.getEndCountUom()));
      nameValuePairs.add(new BasicNameValuePair("gross-deliver", sdu.getGrossDeliver()));
      nameValuePairs.add(new BasicNameValuePair("gross-deliver-uom", sdu.getGrossDeliverUom()));
      nameValuePairs.add(new BasicNameValuePair("avg-flow-rate", sdu.getAvgFlowRate()));
      nameValuePairs.add(new BasicNameValuePair("avg-flow-rate-uom", sdu.getAvgFlowRateUom()));
      nameValuePairs.add(new BasicNameValuePair("after-avg-flow-rate", sdu.getAfterAvgFlowRate()));
      nameValuePairs.add(new BasicNameValuePair("sale-number", sdu.getSaleNumber()));
      nameValuePairs.add(new BasicNameValuePair("meter-number", sdu.getMeterNumber()));
      nameValuePairs.add(new BasicNameValuePair("unit-id", sdu.getUnitId()));
      nameValuePairs.add(new BasicNameValuePair("duplicate", sdu.getDuplicate()));
      nameValuePairs.add(new BasicNameValuePair("other-one", sdu.getOtherOne()));
      nameValuePairs.add(new BasicNameValuePair("other-two", sdu.getOtherTwo()));
      nameValuePairs.add(new BasicNameValuePair("other-three", sdu.getOtherThree()));
      nameValuePairs.add(new BasicNameValuePair("other-four", sdu.getOtherFour()));
      nameValuePairs.add(new BasicNameValuePair("other-five", sdu.getOtherFive()));
      nameValuePairs.add(new BasicNameValuePair("data-state", sdu.getDataState()));

      post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
      HttpResponse response = client.execute(post);
      try (BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
        while ((line = rd.readLine()) != null) {
          System.out.println(line);
          sb.append(line);
        }
        int a = response.getStatusLine().getStatusCode();
        System.out.println("--> " + a + " OK");
        post.releaseConnection();
      }
      client.close();

    } catch (IOException | PatternSyntaxException e) {
      System.out.println(Strings.INFO_NO_INTERNET);
    } finally {
      if (sb.toString().trim().equalsIgnoreCase("SERIAL SUCCESS")) {
        System.out.println("Gross Delivered");
        FM.flagUploaded(id);
      }
      if (sb.toString().trim().equalsIgnoreCase("SERIAL FAILED")) {
        System.out.println("Some errors on server side !! ");
      }
    }
  }

  public List<SerialDataUploaded> checkPendingUpload() {
    List<SerialDataUploaded> listData = new ArrayList<>();
    String queueResults = QueryManagement.SELECT_ALL_SERIAL_DATA_UPLOADED;
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(DbConnection.MYSQL_URL, DbConnection.MYSQL_UNAME, DbConnection.MYSQL_PASSWORD);
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(queueResults);
      while (rs.next()) {
        SerialDataUploaded sdr = new SerialDataUploaded();

        sdr.setUploaded(rs.getShort(1));
        sdr.setSiteId(rs.getString(2));
        sdr.setIDstart(rs.getLong(3));
        sdr.setIDend(rs.getLong(4));
        sdr.setDataState(rs.getString(5));
        sdr.setTicketNo(rs.getString(6));
        sdr.setStart(rs.getString(7));
        sdr.setFinish(rs.getString(8));
        sdr.setStartCount(rs.getString(9));
        sdr.setStartCountUom(rs.getString(10));
        sdr.setEndCount(rs.getString(11));
        sdr.setEndCountUom(rs.getString(12));
        sdr.setGrossDeliver(rs.getString(13));
        sdr.setGrossDeliverUom(rs.getString(14));
        sdr.setAvgFlowRate(rs.getString(15));
        sdr.setAvgFlowRateUom(rs.getString(16));
        sdr.setAfterAvgFlowRate(rs.getString(17));
        sdr.setSaleNumber(rs.getString(18));
        sdr.setMeterNumber(rs.getString(19));
        sdr.setUnitId(rs.getString(20));
        sdr.setDuplicate(rs.getString(21));
        sdr.setOtherOne(rs.getString(22));
        sdr.setOtherTwo(rs.getString(23));
        sdr.setOtherThree(rs.getString(24));
        sdr.setOtherFour(rs.getString(25));
        sdr.setOtherFive(rs.getString(26));
        listData.add(sdr);
        if (listData.isEmpty() == false) {

          serialDataUpload();
          return listData;

        } else {
          return listData;
        }

      }
    } catch (SQLException e) {
      System.out.println(e);
    } finally {
      try {
        conn.close();

      } catch (SQLException ex) {
        Logger.getLogger(SerialUploader.class
                .getName()).log(Level.SEVERE, null, ex);
      }
    }
    return listData;
  }
}