package com.bizTrack;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tempController {

  @RequestMapping(method = RequestMethod.GET , value = "/temp")
  public String status() {
    return "temp success";
  }

}
