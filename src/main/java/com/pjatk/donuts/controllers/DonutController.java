package com.pjatk.donuts.controllers;

import com.pjatk.donuts.entities.Donut;
import com.pjatk.donuts.enums.DonutFilling;
import com.pjatk.donuts.enums.DonutIcing;
import com.pjatk.donuts.enums.DonutShape;
import com.pjatk.donuts.services.DonutService;
import com.sun.net.httpserver.Authenticator.Success;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/donut")
public class DonutController {
  private final DonutService donutService;

  public DonutController(DonutService donutService) {
    this.donutService = donutService;
  }

  @GetMapping("/example")
  public ResponseEntity<Donut> getExample() {
    return ResponseEntity.ok(this.donutService.getExample());
  }

  @GetMapping("/example-with-name")
  public ResponseEntity<Donut> getExampleWithName(@RequestParam String name) {
    return ResponseEntity.ok(this.donutService.getExampleWithName(name));
  }

  @GetMapping("/new")
  public ResponseEntity<Donut> getNew(
      @RequestParam String name,
      @RequestParam DonutShape shape,
      @RequestParam DonutFilling filling,
      @RequestParam DonutIcing icing,
      @RequestParam double weightInGrams,
      @RequestParam double calorieCount,
      @RequestParam boolean isGlutenFree) {
    // example url:
    // /donut/new?name=example&shape=ROUND&filling=ROSE&icing=PINK&weightInGrams=200&calorieCount=700&isGlutenFree=false
    return ResponseEntity.ok(
        this.donutService.getNew(
            name, shape, filling, icing, weightInGrams, calorieCount, isGlutenFree));
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<Optional<Donut>> getById(@PathVariable("id") Integer id) {
    return ResponseEntity.ok(this.donutService.getById(id));
  }

  @GetMapping("/all")
  public ResponseEntity<List<Donut>> getAll() {
    return ResponseEntity.ok(this.donutService.getAll());
  }

  @GetMapping("/delete/{id}")
  public ResponseEntity<Success> deleteById(@PathVariable("id") Integer id) {
    this.donutService.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
