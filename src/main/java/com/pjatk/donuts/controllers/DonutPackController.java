package com.pjatk.donuts.controllers;

import com.pjatk.donuts.entities.DonutPack;
import com.pjatk.donuts.services.DonutPackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/donut-pack")
public class DonutPackController {
  private final DonutPackService donutPackService;

  public DonutPackController(DonutPackService donutPackService) {
    this.donutPackService = donutPackService;
  }

  @GetMapping("/example")
  public ResponseEntity<DonutPack> getExample() {
    return ResponseEntity.ok(this.donutPackService.getExample());
  }

  @GetMapping("/example-with-name")
  public ResponseEntity<DonutPack> getExampleWithName(@RequestParam String name) {
    return ResponseEntity.ok(this.donutPackService.getExampleWithName(name));
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<Optional<DonutPack>> getById(@PathVariable("id") Integer id) {
    return ResponseEntity.ok(this.donutPackService.getById(id));
  }

  @GetMapping("/all")
  public ResponseEntity<List<DonutPack>> getAll() {
    return ResponseEntity.ok(this.donutPackService.getAll());
  }
}
