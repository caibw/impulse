package com.impulse.controller;

import static com.google.common.collect.Maps.newHashMap;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;
import springfox.petstore.model.Pet;

@RestController
public class CategoryController {

  @RequestMapping(value = "/category/Resource", method = RequestMethod.GET)
  public ResponseEntity<String> search(@RequestParam(value = "someEnum") final Category someEnum) {
    return ResponseEntity.ok(someEnum.name());
  }

  @RequestMapping(value = "/category/map", method = RequestMethod.GET)
  public Map<String, Map<String, Pet>> map() {
    return newHashMap();
  }

  @RequestMapping(value = "/category/{id}", method = RequestMethod.POST)
  public ResponseEntity<Void> someOperation(@PathVariable final long id,
      @RequestBody final int userId) {
    return ResponseEntity.ok(null);
  }

  @RequestMapping(value = "/category/{id}/{userId}", method = RequestMethod.POST)
  public ResponseEntity<Void> ignoredParam(@PathVariable final long id,
      @PathVariable @ApiIgnore final int userId) {
    return ResponseEntity.ok(null);
  }

  @RequestMapping(value = "/category/{id}/map", method = RequestMethod.POST)
  public ResponseEntity<Void> map(@PathVariable final String id,
      @RequestParam final Map<String, String> test) {
    return ResponseEntity.ok(null);
  }

  @RequestMapping(value = "/categories", method = RequestMethod.POST)
  public ResponseEntity<List<Category>> map(final String[] categories) {
    return ResponseEntity.ok(null);
  }

  private enum Category {

    ONE, TWO, THREE

  }

}
