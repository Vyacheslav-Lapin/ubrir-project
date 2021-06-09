package ru.vlapin.experiments.ubrirproject.controller.jackson;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlapin.experiments.ubrirproject.model.jackson.DefaultJacksonDemoBean;

@RestController
@RequestMapping("jackson")
public class JacksonDemoController {

  @NotNull
  @PostMapping("default")
  public ResponseEntity<DefaultJacksonDemoBean> defaultJacksonExample(
      @RequestBody DefaultJacksonDemoBean demoBean) {
    return ResponseEntity.ok(demoBean);
  }
}
