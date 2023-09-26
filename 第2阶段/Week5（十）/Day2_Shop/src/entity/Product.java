package com.sample;


public class Product {

  private long pId;
  private long tId;
  private String pName;
  private java.sql.Date pTime;
  private String pImage;
  private double pPrice;
  private long pState;
  private String pInfo;


  public long getPId() {
    return pId;
  }

  public void setPId(long pId) {
    this.pId = pId;
  }


  public long getTId() {
    return tId;
  }

  public void setTId(long tId) {
    this.tId = tId;
  }


  public String getPName() {
    return pName;
  }

  public void setPName(String pName) {
    this.pName = pName;
  }


  public java.sql.Date getPTime() {
    return pTime;
  }

  public void setPTime(java.sql.Date pTime) {
    this.pTime = pTime;
  }


  public String getPImage() {
    return pImage;
  }

  public void setPImage(String pImage) {
    this.pImage = pImage;
  }


  public double getPPrice() {
    return pPrice;
  }

  public void setPPrice(double pPrice) {
    this.pPrice = pPrice;
  }


  public long getPState() {
    return pState;
  }

  public void setPState(long pState) {
    this.pState = pState;
  }


  public String getPInfo() {
    return pInfo;
  }

  public void setPInfo(String pInfo) {
    this.pInfo = pInfo;
  }

}
