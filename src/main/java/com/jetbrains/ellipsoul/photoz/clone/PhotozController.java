package com.jetbrains.ellipsoul.photoz.clone;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;


// Look for any rest controllers inside the application, if yes then create an instance of this controller
@RestController
public class PhotozController {
  private final PhotozService photozService;

  public PhotozController(PhotozService photozService) {
    this.photozService = photozService;
  }

  // Basic request
  @GetMapping("/") // Executed by spring whenever we hit the home path with a get method
  public String hello() {
    return "Hello World!";
  }

  // List all photoz
  @GetMapping("/photoz") // Retrieves all photos
  public Collection<Photo> getPhotoz() {
    return photozService.get();
  }

  // Get a specific photo
  @GetMapping("/photoz/{id}") // Matches the function's parameter
  public Photo getPhoto(@PathVariable String id) {
    Photo photo = photozService.get(id);
    if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    return photo;
  }

  // Delete a specific photo
  @DeleteMapping("/photoz/{id}") // Matches the function's parameter
  public Photo deletePhoto(@PathVariable String id) {
    Photo photo = photozService.remove(id);
    if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    return photo;
  }

  // Add a photo
  @PostMapping("/photoz")
  public Photo addPhoto(@RequestPart("data") MultipartFile file) throws IOException{
    // Update database with the photo
    return photozService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
  }
}
