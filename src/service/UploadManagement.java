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

  private void calibrationDataUpload() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(DbConnection.MYSQL_URL, DbConnection.MYSQL_UNAME, DbConnection.MYSQL_PASSWORD);

      String query = QueryManagement.SELECT_UPLOAD_CALIBRATION;

      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);

      while (rs.next()) {
        SerialCalibrationUploaded serialData = new SerialCalibrationUploaded();

        int id = rs.getInt("id");

        //serialData.setId(rs.getInt("id"));
        serialData.setUploaded(rs.getString(2));
        serialData.setShiftStart(rs.getString(3));
        serialData.setShiftFinish(rs.getString(4));
        serialData.setUnitId(rs.getString(5));
        serialData.setSaleNumber(rs.getString(6));
        serialData.setMeterNumber(rs.getString(7));
        serialData.setCalNum(rs.getString(8));
        serialData.setShiftNet(rs.getString(9));
        serialData.setShiftGross(rs.getString(10));
        serialData.setEndNetTotal(rs.getString(11));
        serialData.setEndTotalizer(rs.getString(12));
        serialData.setDeliveries(rs.getString(13));

        sendCalbrationData(id, serialData);
      }
      conn.close();

    } catch (SQLException ex) {
      Logger.getLogger(SerialUploader.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public List<SerialCalibrationQueued> checkPendingCalib() {
    List<SerialCalibrationQueued> listData = new ArrayList<>();
    String queueResults = QueryManagement.SELECT_UPLOAD_CALIBRATION;
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(DbConnection.MYSQL_URL, DbConnection.MYSQL_UNAME, DbConnection.MYSQL_PASSWORD);
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(queueResults);
      while (rs.next()) {
        SerialCalibrationQueued sdq = new SerialCalibrationQueued();

        sdq.setId(rs.getInt(1));
        sdq.setUploaded(rs.getString(2));
        sdq.setShiftStart(rs.getString(3));
        sdq.setShiftFinish(rs.getString(4));
        sdq.setUnitId(rs.getString(5));
        sdq.setSaleNumber(rs.getString(6));
        sdq.setMeterNumber(rs.getString(7));
        sdq.setCalNum(rs.getString(8));
        sdq.setShiftNet(rs.getString(9));
        sdq.setShiftGross(rs.getString(10));
        sdq.setEndNetTotal(rs.getString(11));
        sdq.setEndTotalizer(rs.getString(12));
        sdq.setDeliveries(rs.getString(13));
        listData.add(sdq);
        if (listData.isEmpty() == false) {

          calibrationDataUpload();
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

  private void sendCalbrationData(int id, SerialCalibrationUploaded sdu) {

    String linex = "";
    StringBuilder sbx = new StringBuilder();
    CloseableHttpClient clientx = HttpClients.createDefault();
    HttpPost postx = new HttpPost(Strings.POST_CALIB_CLOUD);

    try {
      List<NameValuePair> nameValuePairs = new ArrayList<>(1);
      nameValuePairs.add(new BasicNameValuePair("uploaded", sdu.getUploaded()));
      nameValuePairs.add(new BasicNameValuePair("shift-start", sdu.getShiftStart()));
      nameValuePairs.add(new BasicNameValuePair("shift-finish", sdu.getShiftFinish()));
      nameValuePairs.add(new BasicNameValuePair("unit-id", sdu.getUnitId()));
      nameValuePairs.add(new BasicNameValuePair("sale-number", sdu.getSaleNumber()));
      nameValuePairs.add(new BasicNameValuePair("meter-number", sdu.getMeterNumber()));
      nameValuePairs.add(new BasicNameValuePair("cal-num", sdu.getCalNum()));
      nameValuePairs.add(new BasicNameValuePair("shift-net", sdu.getShiftNet()));
      nameValuePairs.add(new BasicNameValuePair("shift-gross", sdu.getShiftGross()));
      nameValuePairs.add(new BasicNameValuePair("end-net-total", sdu.getEndNetTotal()));
      nameValuePairs.add(new BasicNameValuePair("end-totalizer", sdu.getEndTotalizer()));
      nameValuePairs.add(new BasicNameValuePair("deliveries", sdu.getDeliveries()));
      SerialData serialData = new SerialData();
      nameValuePairs.add(new BasicNameValuePair("data-state", serialData.getDataState()));

      postx.setEntity(new UrlEncodedFormEntity(nameValuePairs));
      HttpResponse responsex = clientx.execute(postx);
      try (BufferedReader rdx = new BufferedReader(new InputStreamReader(responsex.getEntity().getContent()))) {
        while ((linex = rdx.readLine()) != null) {
          System.out.println(linex);
          sbx.append(linex);
        }
        int a = responsex.getStatusLine().getStatusCode();
        System.out.println("--> " + a + " OK");
        postx.releaseConnection();
      }
      clientx.close();

    } catch (IOException | PatternSyntaxException e) {
      System.out.println(Strings.INFO_NO_INTERNET);
    } finally {
      if (sbx.toString().trim().equalsIgnoreCase("CALIB SUCCESS")) {
        System.out.println("End Totalizer Delivered");
        FM.flagCalibUploaded(id);
      }
      if (sbx.toString().trim().equalsIgnoreCase("CALIB FAILED")) {
        System.out.println("but sumething wrong on server side !!");
      }
    }
  }

}
