package com.sample;


public class Orders {

  private String oId;
  private long uId;
  private long aId;
  private double oCount;
  private java.sql.Timestamp oTime;
  private long oState;


  public String getOId() {
    return oId;
  }

  public void setOId(String oId) {
    this.oId = oId;
  }


  public long getUId() {
    return uId;
  }

  public void setUId(long uId) {
    this.uId = uId;
  }


  public long getAId() {
    return aId;
  }

  public void setAId(long aId) {
    this.aId = aId;
  }


  public double getOCount() {
    return oCount;
  }

  public void setOCount(double oCount) {
    this.oCount = oCount;
  }


  public java.sql.Timestamp getOTime() {
    return oTime;
  }

  public void setOTime(java.sql.Timestamp oTime) {
    this.oTime = oTime;
  }


  public long getOState() {
    return oState;
  }

  public void setOState(long oState) {
    this.oState = oState;
  }

}
