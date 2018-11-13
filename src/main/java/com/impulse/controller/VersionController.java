package com.impulse.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.boot.info.GitProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {
  @Autowired
  private ProjectInfoAutoConfiguration infor;

  @RequestMapping(value = "/version", method = RequestMethod.GET)
  public Map<String, String> test() throws Exception {
    final GitProperties gitProperties = this.infor.gitProperties();
    final Map<String, String> result = new HashMap<>();
    gitProperties.forEach(e -> result.put(e.getKey(), e.getValue()));
    return result;
  }
}
