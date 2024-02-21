package com.jetbrains.ellipsoul.photoz.clone.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jetbrains.ellipsoul.photoz.clone.model.Photo;
import com.jetbrains.ellipsoul.photoz.clone.service.PhotozService;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class DownloadController {
  private final PhotozService photozService;

  public DownloadController(PhotozService photozService) {
    this.photozService = photozService;
  }

  @GetMapping("/download/{id}")
  public ResponseEntity<byte[]> downloadPhoto(@PathVariable String id) {
    // Retrieve the photo from the database
    Photo photo = photozService.get(id);
    if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    // Prepare HTTP headers and photo data
    byte[] data = photo.getData();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.valueOf(photo.getContentType()));

    // Set so that photo is downloaded instead of opened in a new tab
    ContentDisposition build = ContentDisposition.builder("attachment").filename(photo.getFileName()).build();
    headers.setContentDisposition(build);

    return new ResponseEntity<>(data, headers, HttpStatus.OK);
  }
}
