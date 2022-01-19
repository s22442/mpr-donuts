package com.pjatk.donuts.controllers;

import com.pjatk.donuts.entities.DonutPack;
import com.pjatk.donuts.enums.DonutPackShape;
import com.pjatk.donuts.services.DonutPackService;
import com.sun.net.httpserver.Authenticator;
import org.springframework.http.HttpStatus;
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

  @GetMapping("/new")
  public ResponseEntity<DonutPack> getNew(
      @RequestParam String name,
      @RequestParam DonutPackShape shape,
      @RequestParam String color,
      @RequestParam int donutCapacity) {
    // example url:
    // /donut-pack/new?name=example&shape=SQUARE&color=blue&donutCapacity=10
    return ResponseEntity.ok(this.donutPackService.getNew(name, shape, color, donutCapacity));
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<Optional<DonutPack>> getById(@PathVariable("id") Integer id) {
    return ResponseEntity.ok(this.donutPackService.getById(id));
  }

  @GetMapping("/all")
  public ResponseEntity<List<DonutPack>> getAll() {
    return ResponseEntity.ok(this.donutPackService.getAll());
  }

  @GetMapping("/edit/{donutPackId}/add/{donutId}")
  public ResponseEntity<Authenticator> addDonutToDonutPack(
      @PathVariable("donutPackId") Integer donutPackId, @PathVariable("donutId") Integer donutId) {

    try {
      this.donutPackService.addDonutToDonutPack(donutPackId, donutId);
      return ResponseEntity.ok().build();
    } catch (IllegalStateException e) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
  }
}
