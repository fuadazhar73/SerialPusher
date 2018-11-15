/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.SerialData;

/**
 *
 * @author bachtiar
 */
public class Strings {
  
  public static final String SITE_ID = "JATINEGARA";
  
  public static final String POST_CLOUD = "http://128.199.213.155/dfm/serial.php";
  public static final String POST_CALIB_CLOUD = "http://128.199.213.155/dfm/serial_calibration.php";
  public static final String POST_LOCAL = "http://localhost/dfmStandart/serial.php";
  public static final String POST_CALIB_LOCAL = "http://localhost/dfmStandart/serial_calibration.php";
  
  
  public static final String FLAG_QUEUED = "\nQueued..";
  
  public static final String SERIAL_DOWNLOADED = "Reading data ..";
 
  public static final String INFO_READY_TO_UPLOAD = "\nReady to push..";
  public static final String INFO_NO_INTERNET = "No internet present !!!";
}
