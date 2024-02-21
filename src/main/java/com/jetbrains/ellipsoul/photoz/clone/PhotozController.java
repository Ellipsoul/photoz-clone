package com.jetbrains.ellipsoul.photoz.clone;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


// Look for any rest controllers inside the application, if yes then create an instance of this controller
@RestController
public class PhotozController {
  private Map<String, Photo> db = new HashMap<>() {{
    put("1", new Photo("1", "hello.jpg"));
  }};

  @GetMapping("/") // Executed by spring whenever we hit the home path with a get method
  public String hello() {
    return "Hello World!";
  }

  @GetMapping("/photoz") // Retrieves all photos
  public Collection<Photo> getPhotoz() {
    return db.values();
  }

  @GetMapping("/photoz/{id}") // Matches the function's parameter
  public Photo getMethodName(@PathVariable String id) {
    Photo photo = db.get(id);
    if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    return photo;
  }
}
