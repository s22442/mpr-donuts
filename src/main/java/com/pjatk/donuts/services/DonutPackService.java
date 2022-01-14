package com.pjatk.donuts.services;

import com.pjatk.donuts.entities.DonutPack;
import com.pjatk.donuts.enums.DonutPackShape;
import com.pjatk.donuts.repositories.DonutPackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonutPackService {
  private final DonutPackRepository donutPackRepository;
  private final DonutService donutService;

  public DonutPackService(DonutPackRepository donutPackRepository, DonutService donutService) {
    this.donutPackRepository = donutPackRepository;
    this.donutService = donutService;
  }

  public DonutPack getExample() {
    return new DonutPack(
        null,
        "Example square 3-pack with a single Example Donut",
        DonutPackShape.SQUARE,
        "#ff00aa",
        3,
        List.of(this.donutService.getExample()));
  }

  public DonutPack getExampleWithName(String name) {

    return new DonutPack(
        null, name, DonutPackShape.SQUARE, "#ff00aa", 3, List.of(this.donutService.getExample()));
  }

  public Optional<DonutPack> getById(Integer id) {
    return this.donutPackRepository.findById(id);
  }

  public List<DonutPack> getAll() {
    return this.donutPackRepository.findAll();
  }
}
