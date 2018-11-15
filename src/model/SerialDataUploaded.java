/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "serial_data_uploaded")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "SerialDataUploaded.findAll", query = "SELECT s FROM SerialDataUploaded s")
  , @NamedQuery(name = "SerialDataUploaded.findById", query = "SELECT s FROM SerialDataUploaded s WHERE s.id = :id")
  , @NamedQuery(name = "SerialDataUploaded.findByUploaded", query = "SELECT s FROM SerialDataUploaded s WHERE s.uploaded = :uploaded")
  , @NamedQuery(name = "SerialDataUploaded.findBySiteId", query = "SELECT s FROM SerialDataUploaded s WHERE s.siteId = :siteId")
  , @NamedQuery(name = "SerialDataUploaded.findByIDstart", query = "SELECT s FROM SerialDataUploaded s WHERE s.iDstart = :iDstart")
  , @NamedQuery(name = "SerialDataUploaded.findByIDend", query = "SELECT s FROM SerialDataUploaded s WHERE s.iDend = :iDend")
  , @NamedQuery(name = "SerialDataUploaded.findByDataState", query = "SELECT s FROM SerialDataUploaded s WHERE s.dataState = :dataState")
  , @NamedQuery(name = "SerialDataUploaded.findByTicketNo", query = "SELECT s FROM SerialDataUploaded s WHERE s.ticketNo = :ticketNo")
  , @NamedQuery(name = "SerialDataUploaded.findByStart", query = "SELECT s FROM SerialDataUploaded s WHERE s.start = :start")
  , @NamedQuery(name = "SerialDataUploaded.findByFinish", query = "SELECT s FROM SerialDataUploaded s WHERE s.finish = :finish")
  , @NamedQuery(name = "SerialDataUploaded.findByStartCount", query = "SELECT s FROM SerialDataUploaded s WHERE s.startCount = :startCount")
  , @NamedQuery(name = "SerialDataUploaded.findByStartCountUom", query = "SELECT s FROM SerialDataUploaded s WHERE s.startCountUom = :startCountUom")
  , @NamedQuery(name = "SerialDataUploaded.findByEndCount", query = "SELECT s FROM SerialDataUploaded s WHERE s.endCount = :endCount")
  , @NamedQuery(name = "SerialDataUploaded.findByEndCountUom", query = "SELECT s FROM SerialDataUploaded s WHERE s.endCountUom = :endCountUom")
  , @NamedQuery(name = "SerialDataUploaded.findByGrossDeliver", query = "SELECT s FROM SerialDataUploaded s WHERE s.grossDeliver = :grossDeliver")
  , @NamedQuery(name = "SerialDataUploaded.findByGrossDeliverUom", query = "SELECT s FROM SerialDataUploaded s WHERE s.grossDeliverUom = :grossDeliverUom")
  , @NamedQuery(name = "SerialDataUploaded.findByAvgFlowRate", query = "SELECT s FROM SerialDataUploaded s WHERE s.avgFlowRate = :avgFlowRate")
  , @NamedQuery(name = "SerialDataUploaded.findByAvgFlowRateUom", query = "SELECT s FROM SerialDataUploaded s WHERE s.avgFlowRateUom = :avgFlowRateUom")
  , @NamedQuery(name = "SerialDataUploaded.findByAfterAvgFlowRate", query = "SELECT s FROM SerialDataUploaded s WHERE s.afterAvgFlowRate = :afterAvgFlowRate")
  , @NamedQuery(name = "SerialDataUploaded.findBySaleNumber", query = "SELECT s FROM SerialDataUploaded s WHERE s.saleNumber = :saleNumber")
  , @NamedQuery(name = "SerialDataUploaded.findByMeterNumber", query = "SELECT s FROM SerialDataUploaded s WHERE s.meterNumber = :meterNumber")
  , @NamedQuery(name = "SerialDataUploaded.findByUnitId", query = "SELECT s FROM SerialDataUploaded s WHERE s.unitId = :unitId")
  , @NamedQuery(name = "SerialDataUploaded.findByDuplicate", query = "SELECT s FROM SerialDataUploaded s WHERE s.duplicate = :duplicate")
  , @NamedQuery(name = "SerialDataUploaded.findByOtherOne", query = "SELECT s FROM SerialDataUploaded s WHERE s.otherOne = :otherOne")
  , @NamedQuery(name = "SerialDataUploaded.findByOtherTwo", query = "SELECT s FROM SerialDataUploaded s WHERE s.otherTwo = :otherTwo")
  , @NamedQuery(name = "SerialDataUploaded.findByOtherThree", query = "SELECT s FROM SerialDataUploaded s WHERE s.otherThree = :otherThree")
  , @NamedQuery(name = "SerialDataUploaded.findByOtherFour", query = "SELECT s FROM SerialDataUploaded s WHERE s.otherFour = :otherFour")
  , @NamedQuery(name = "SerialDataUploaded.findByOtherFive", query = "SELECT s FROM SerialDataUploaded s WHERE s.otherFive = :otherFive")})
public class SerialDataUploaded implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Long id;
  @Column(name = "uploaded")
  private Short uploaded;
  @Column(name = "site_id")
  private String siteId;
  @Column(name = "ID_start")
  private Long iDstart;
  @Column(name = "ID_end")
  private Long iDend;
  @Column(name = "data_state")
  private String dataState;
  @Column(name = "ticket_no")
  private String ticketNo;
  @Column(name = "start")
  private String start;
  @Column(name = "finish")
  private String finish;
  @Column(name = "start_count")
  private String startCount;
  @Column(name = "start_count_uom")
  private String startCountUom;
  @Column(name = "end_count")
  private String endCount;
  @Column(name = "end_count_uom")
  private String endCountUom;
  @Column(name = "gross_deliver")
  private String grossDeliver;
  @Column(name = "gross_deliver_uom")
  private String grossDeliverUom;
  @Column(name = "avg_flow_rate")
  private String avgFlowRate;
  @Column(name = "avg_flow_rate_uom")
  private String avgFlowRateUom;
  @Column(name = "after_avg_flow_rate")
  private String afterAvgFlowRate;
  @Column(name = "sale_number")
  private String saleNumber;
  @Column(name = "meter_number")
  private String meterNumber;
  @Column(name = "unit_id")
  private String unitId;
  @Column(name = "duplicate")
  private String duplicate;
  @Column(name = "other_one")
  private String otherOne;
  @Column(name = "other_two")
  private String otherTwo;
  @Column(name = "other_three")
  private String otherThree;
  @Column(name = "other_four")
  private String otherFour;
  @Column(name = "other_five")
  private String otherFive;

  public SerialDataUploaded() {
  }

  public SerialDataUploaded(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Short getUploaded() {
    return uploaded;
  }

  public void setUploaded(Short uploaded) {
    this.uploaded = uploaded;
  }

  public String getSiteId() {
    return siteId;
  }

  public void setSiteId(String siteId) {
    this.siteId = siteId;
  }

  public Long getIDstart() {
    return iDstart;
  }

  public void setIDstart(Long iDstart) {
    this.iDstart = iDstart;
  }

  public Long getIDend() {
    return iDend;
  }

  public void setIDend(Long iDend) {
    this.iDend = iDend;
  }

  public String getDataState() {
    return dataState;
  }

  public void setDataState(String dataState) {
    this.dataState = dataState;
  }

  public String getTicketNo() {
    return ticketNo;
  }

  public void setTicketNo(String ticketNo) {
    this.ticketNo = ticketNo;
  }

  public String getStart() {
    return start;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public String getFinish() {
    return finish;
  }

  public void setFinish(String finish) {
    this.finish = finish;
  }

  public String getStartCount() {
    return startCount;
  }

  public void setStartCount(String startCount) {
    this.startCount = startCount;
  }

  public String getStartCountUom() {
    return startCountUom;
  }

  public void setStartCountUom(String startCountUom) {
    this.startCountUom = startCountUom;
  }

  public String getEndCount() {
    return endCount;
  }

  public void setEndCount(String endCount) {
    this.endCount = endCount;
  }

  public String getEndCountUom() {
    return endCountUom;
  }

  public void setEndCountUom(String endCountUom) {
    this.endCountUom = endCountUom;
  }

  public String getGrossDeliver() {
    return grossDeliver;
  }

  public void setGrossDeliver(String grossDeliver) {
    this.grossDeliver = grossDeliver;
  }

  public String getGrossDeliverUom() {
    return grossDeliverUom;
  }

  public void setGrossDeliverUom(String grossDeliverUom) {
    this.grossDeliverUom = grossDeliverUom;
  }

  public String getAvgFlowRate() {
    return avgFlowRate;
  }

  public void setAvgFlowRate(String avgFlowRate) {
    this.avgFlowRate = avgFlowRate;
  }

  public String getAvgFlowRateUom() {
    return avgFlowRateUom;
  }

  public void setAvgFlowRateUom(String avgFlowRateUom) {
    this.avgFlowRateUom = avgFlowRateUom;
  }

  public String getAfterAvgFlowRate() {
    return afterAvgFlowRate;
  }

  public void setAfterAvgFlowRate(String afterAvgFlowRate) {
    this.afterAvgFlowRate = afterAvgFlowRate;
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

  public String getUnitId() {
    return unitId;
  }

  public void setUnitId(String unitId) {
    this.unitId = unitId;
  }

  public String getDuplicate() {
    return duplicate;
  }

  public void setDuplicate(String duplicate) {
    this.duplicate = duplicate;
  }

  public String getOtherOne() {
    return otherOne;
  }

  public void setOtherOne(String otherOne) {
    this.otherOne = otherOne;
  }

  public String getOtherTwo() {
    return otherTwo;
  }

  public void setOtherTwo(String otherTwo) {
    this.otherTwo = otherTwo;
  }

  public String getOtherThree() {
    return otherThree;
  }

  public void setOtherThree(String otherThree) {
    this.otherThree = otherThree;
  }

  public String getOtherFour() {
    return otherFour;
  }

  public void setOtherFour(String otherFour) {
    this.otherFour = otherFour;
  }

  public String getOtherFive() {
    return otherFive;
  }

  public void setOtherFive(String otherFive) {
    this.otherFive = otherFive;
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
    if (!(object instanceof SerialDataUploaded)) {
      return false;
    }
    SerialDataUploaded other = (SerialDataUploaded) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "model.SerialDataUploaded[ id=" + id + " ]";
  }
  
}
