/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bachtiar
 */
@Entity
@Table(name = "serial_calibration_uploaded")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "SerialCalibrationUploaded.findAll", query = "SELECT s FROM SerialCalibrationUploaded s")
  , @NamedQuery(name = "SerialCalibrationUploaded.findById", query = "SELECT s FROM SerialCalibrationUploaded s WHERE s.id = :id")
  , @NamedQuery(name = "SerialCalibrationUploaded.findByUploaded", query = "SELECT s FROM SerialCalibrationUploaded s WHERE s.uploaded = :uploaded")
  , @NamedQuery(name = "SerialCalibrationUploaded.findByShiftStart", query = "SELECT s FROM SerialCalibrationUploaded s WHERE s.shiftStart = :shiftStart")
  , @NamedQuery(name = "SerialCalibrationUploaded.findByShiftFinish", query = "SELECT s FROM SerialCalibrationUploaded s WHERE s.shiftFinish = :shiftFinish")
  , @NamedQuery(name = "SerialCalibrationUploaded.findByUnitId", query = "SELECT s FROM SerialCalibrationUploaded s WHERE s.unitId = :unitId")
  , @NamedQuery(name = "SerialCalibrationUploaded.findByCalNum", query = "SELECT s FROM SerialCalibrationUploaded s WHERE s.calNum = :calNum")
  , @NamedQuery(name = "SerialCalibrationUploaded.findByShiftNet", query = "SELECT s FROM SerialCalibrationUploaded s WHERE s.shiftNet = :shiftNet")
  , @NamedQuery(name = "SerialCalibrationUploaded.findByShiftGross", query = "SELECT s FROM SerialCalibrationUploaded s WHERE s.shiftGross = :shiftGross")
  , @NamedQuery(name = "SerialCalibrationUploaded.findByEndNetTotal", query = "SELECT s FROM SerialCalibrationUploaded s WHERE s.endNetTotal = :endNetTotal")
  , @NamedQuery(name = "SerialCalibrationUploaded.findByEndTotalizer", query = "SELECT s FROM SerialCalibrationUploaded s WHERE s.endTotalizer = :endTotalizer")
  , @NamedQuery(name = "SerialCalibrationUploaded.findByDeliveries", query = "SELECT s FROM SerialCalibrationUploaded s WHERE s.deliveries = :deliveries")})
public class SerialCalibrationUploaded implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @Column(name = "uploaded")
  private String uploaded;
  @Basic(optional = false)
  @Column(name = "shift_start")
  private String shiftStart;
  @Basic(optional = false)
  @Column(name = "shift_finish")
  private String shiftFinish;
  @Basic(optional = false)
  @Column(name = "unit_id")
  private String unitId;
  @Basic(optional = false)
  @Column(name = "cal_num")
  private String calNum;
  @Basic(optional = false)
  @Column(name = "shift_net")
  private String shiftNet;
  @Basic(optional = false)
  @Column(name = "shift_gross")
  private String shiftGross;
  @Basic(optional = false)
  @Column(name = "end_net_total")
  private String endNetTotal;
  @Basic(optional = false)
  @Column(name = "end_totalizer")
  private String endTotalizer;
  @Basic(optional = false)
  @Column(name = "deliveries")
  private String deliveries;

  public SerialCalibrationUploaded() {
  }

  public SerialCalibrationUploaded(Integer id) {
    this.id = id;
  }

  public SerialCalibrationUploaded(Integer id, String uploaded, String shiftStart, String shiftFinish, String unitId, String calNum, String shiftNet, String shiftGross, String endNetTotal, String endTotalizer, String deliveries) {
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
