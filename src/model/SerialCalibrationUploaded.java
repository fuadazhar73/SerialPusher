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
public class SerialCalibrationUploaded {

  private Integer id;
  private String uploaded;
  private String shiftStart;
  private String shiftFinish;
  private String unitId;
  private String saleNumber;
  private String meterNumber;
  private String calNum;
  private String shiftNet;
  private String shiftGross;
  private String endNetTotal;
  private String endTotalizer;
  private String deliveries;

  public SerialCalibrationUploaded() {
  }

  public SerialCalibrationUploaded(Integer id) {
    this.id = id;
  }

  public SerialCalibrationUploaded(String saleNumber, String meterNumber, Integer id, String uploaded, String shiftStart, String shiftFinish, String unitId, String calNum, String shiftNet, String shiftGross, String endNetTotal, String endTotalizer, String deliveries) {
    this.id = id;
    this.uploaded = uploaded;
    this.shiftStart = shiftStart;
    this.shiftFinish = shiftFinish;
    this.unitId = unitId;
    this.saleNumber = saleNumber;
    this.meterNumber = meterNumber;
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

  public String getSaleNumber() {
    return saleNumber;
  }

  public void setSaleNumber(String saleNumber) {
    this.saleNumber = saleNumber;
  }

  public String getMeterNumber() {
    return meterNumber;
  }

  public void setMeterNumber(String meterNumber) {
    this.meterNumber = meterNumber;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof SerialCalibrationUploaded)) {
      return false;
    }
    SerialCalibrationUploaded other = (SerialCalibrationUploaded) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "model.SerialCalibrationUploaded[ id=" + id + " ]";
  }

}
