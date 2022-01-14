package com.pjatk.donuts.services;

import com.pjatk.donuts.entities.Donut;
import com.pjatk.donuts.enums.DonutFilling;
import com.pjatk.donuts.enums.DonutIcing;
import com.pjatk.donuts.enums.DonutShape;
import com.pjatk.donuts.repositories.DonutRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonutService {
  private final DonutRepository donutRepository;

  public DonutService(DonutRepository donutRepository) {
    this.donutRepository = donutRepository;
  }

  public Donut getExample() {
    return new Donut(
        null,
        "Example Donut",
        DonutShape.ROUND,
        DonutFilling.ROSE,
        DonutIcing.CYAN,
        100,
        350,
        false);
  }

  public Donut getExampleWithName(String name) {
    return new Donut(
        null, name, DonutShape.ROUND, DonutFilling.ROSE, DonutIcing.CYAN, 100, 350, false);
  }

  public Donut getNew(
      String name,
      DonutShape shape,
      DonutFilling filling,
      DonutIcing icing,
      double weightInGrams,
      double calorieCount,
      boolean isGlutenFree) {
    Donut newDonut =
        new Donut(null, name, shape, filling, icing, weightInGrams, calorieCount, isGlutenFree);

    this.donutRepository.save(newDonut);

    return newDonut;
  }

  public Optional<Donut> getById(Integer id) {
    return this.donutRepository.findById(id);
  }

  public List<Donut> getAll() {
    return this.donutRepository.findAll();
  }

  public void deleteById(Integer id) {
    this.donutRepository.deleteById(id);
  }
}
