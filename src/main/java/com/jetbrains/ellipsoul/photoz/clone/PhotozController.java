package com.jetbrains.ellipsoul.photoz.clone;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


// Look for any rest controllers inside the application, if yes then create an instance of this controller
@RestController
public class PhotozController {
  private List<Photo> db = List.of(new Photo("1", "hello.jpg"));

  @GetMapping("/") // Executed by spring whenever we hit the home path with a get method
  public String hello() {
    return "Hello World!";
  }

  @GetMapping("/photoz")
  public List<Photo> getPhotoz() {
    return db;
  }
}
