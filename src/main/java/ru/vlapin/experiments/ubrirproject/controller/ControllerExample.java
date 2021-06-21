package ru.vlapin.experiments.ubrirproject.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.vlapin.experiments.ubrirproject.dao.CatRepository;
import ru.vlapin.experiments.ubrirproject.model.Cat;

@RestController
@RequiredArgsConstructor
public class ControllerExample {

  CatRepository catRepository;

  @NotNull
  @SneakyThrows
  @Contract(pure = true)
  @GetMapping("example/{id}")
  public ResponseEntity<@NotNull Cat> getExampleById(@PathVariable @NotNull Integer id) {
    final List<Cat> all = catRepository.findAll();
    return ResponseEntity.ok(all.get(id));
  }
}
