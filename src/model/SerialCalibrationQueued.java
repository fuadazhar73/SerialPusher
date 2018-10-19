/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author bachtiar
 */

public class SerialCalibrationQueued   {

 
  private Integer id;  
  private String uploaded;  
  private String shiftStart;  
  private String shiftFinish; 
  private String unitId;  
  private String calNum;
  private String shiftNet;  
  private String shiftGross;  
  private String endNetTotal; 
  private String endTotalizer;  
  private String deliveries;

  public SerialCalibrationQueued() {
  }

  public SerialCalibrationQueued(Integer id) {
    this.id = id;
  }

  public SerialCalibrationQueued(Integer id, String uploaded, String shiftStart, String shiftFinish, String unitId, String calNum, String shiftNet, String shiftGross, String endNetTotal, String endTotalizer, String deliveries) {
    this.id = id;
    this.uploaded = uploaded;
    this.shiftStart = shiftStart;
    this.shiftFinish = shiftFinish;
    this.unitId = unitId;
    this.calNum = calNum;
    this.shiftNet = shiftNet;
    this.shiftGross = shiftGross;
    this.endNetTotal = endNetTotal;
    this.endTotalizer = endTotalizer;
    this.deliveries = deliveries;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUploaded() {
    return uploaded;
  }

  public void setUploaded(String uploaded) {
    this.uploaded = uploaded;
  }

  public String getShiftStart() {
    return shiftStart;
  }

  public void setShiftStart(String shiftStart) {
    this.shiftStart = shiftStart;
  }

  public String getShiftFinish() {
    return shiftFinish;
  }

  public void setShiftFinish(String shiftFinish) {
    this.shiftFinish = shiftFinish;
  }

  public String getUnitId() {
    return unitId;
  }

  public void setUnitId(String unitId) {
    this.unitId = unitId;
  }

  public String getCalNum() {
    return calNum;
  }

  public void setCalNum(String calNum) {
    this.calNum = calNum;
  }

  public String getShiftNet() {
    return shiftNet;
  }

  public void setShiftNet(String shiftNet) {
    this.shiftNet = shiftNet;
  }

  public String getShiftGross() {
    return shiftGross;
  }

  public void setShiftGross(String shiftGross) {
    this.shiftGross = shiftGross;
  }

  public String getEndNetTotal() {
    return endNetTotal;
  }

  public void setEndNetTotal(String endNetTotal) {
    this.endNetTotal = endNetTotal;
  }

  public String getEndTotalizer() {
    return endTotalizer;
  }

  public void setEndTotalizer(String endTotalizer) {
    this.endTotalizer = endTotalizer;
  }

  public String getDeliveries() {
    return deliveries;
  }

  public void setDeliveries(String deliveries) {
    this.deliveries = deliveries;
  }  
}
