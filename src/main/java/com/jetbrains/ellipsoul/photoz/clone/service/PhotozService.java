package com.jetbrains.ellipsoul.photoz.clone.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.jetbrains.ellipsoul.photoz.clone.model.Photo;
import com.jetbrains.ellipsoul.photoz.clone.repository.PhotozRepository;

@Service // Instantiate this class when the application starts up
public class PhotozService {
  private final PhotozRepository photozRepository;

  public PhotozService(PhotozRepository photozRepository, Map<String,Photo> db) {
    this.photozRepository = photozRepository;
  }

  public Iterable<Photo> get() {
    return photozRepository.findAll();
  }

  @SuppressWarnings("null")
  public Photo get(Integer id) {
    return photozRepository.findById(id).orElse(null);
  }

  @SuppressWarnings("null")
  public void remove(Integer id) {
    photozRepository.deleteById(id);
  }

  public Photo save(String fileName, String contentType, byte[] data) {
    Photo photo = new Photo();

    // Set file name, content type, and the photo byte data
    photo.setFileName(fileName);
    photo.setContentType(contentType);
    photo.setData(data);
    photozRepository.save(photo);

    return photo;
  }

}
