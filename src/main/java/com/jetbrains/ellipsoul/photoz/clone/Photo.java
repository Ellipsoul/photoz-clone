package com.jetbrains.ellipsoul.photoz.clone;

public class Photo {
  private String id;
  private String fileName;

  // Raw data

  public Photo(String id, String fileName) {
    this.id = id;
    this.fileName = fileName;
  }


  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFileName() {
    return this.fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

}
