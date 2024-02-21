package com.jetbrains.ellipsoul.photoz.clone.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jetbrains.ellipsoul.photoz.clone.model.Photo;

@Service // Instantiate this class when the application starts up
public class PhotozService {
  // This is our in memory database for now
  private Map<String, Photo> db = new HashMap<>();

  public Collection<Photo> get() {
    return db.values();
  }

  public Photo get(String id) {
    return db.get(id);
  }

  public Photo remove(String id) {
    return db.remove(id);
  }

  public Photo save(String fileName, String contentType, byte[] data) {
    Photo photo = new Photo();

    // Generate an ID, set file name, content type, and the photo byte data
    photo.setId(UUID.randomUUID().toString()); // Generate a random UUID
    photo.setFileName(fileName);
    photo.setContentType(contentType);
    photo.setData(data);
    db.put(photo.getId(), photo);

    return photo;
  }

}
