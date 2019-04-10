package com.impulse.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {
  @Autowired
  private ProjectInfoAutoConfiguration infor;

  @RequestMapping(value = "/version", method = RequestMethod.GET)
  public Map<String, String> getVersionInfor() throws Exception {
    final BuildProperties buildProperties = this.infor.buildProperties();
    final Map<String, String> result = new HashMap<>();
    buildProperties.forEach(e -> result.put(e.getKey(), e.getValue()));
    return result;
  }
}

