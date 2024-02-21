package com.jetbrains.ellipsoul.photoz.clone.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotEmpty;

// Marker annotation to map our Java class to the database table
@Table("PHOTOZ")
public class Photo {

  @Id // Tell Spring which one is the Id field
  private Integer id;

  // Ensure that this is not empty
  @NotEmpty
  private String fileName;

  @NotEmpty
  private String contentType;

  // Really simple byte array for the photo itself
  @Lob // Large object
  @JsonIgnore // Prevents sending super long byte array for JSON requests
  private byte[] data;

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
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
