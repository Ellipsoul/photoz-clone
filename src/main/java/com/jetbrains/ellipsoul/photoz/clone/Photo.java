package com.jetbrains.ellipsoul.photoz.clone;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotEmpty;

public class Photo {
  private String id;

  // Ensure that this is not empty
  @NotEmpty
  private String fileName;

  @NotEmpty
  private String contentType;

  // Really simple byte array for the photo itself
  @JsonIgnore // Prevents sending super long byte array for JSON requests
  private byte[] data;

  public Photo() {}

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

  public byte[] getData() {
    return this.data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }


  public String getContentType() {
    return this.contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }
}
