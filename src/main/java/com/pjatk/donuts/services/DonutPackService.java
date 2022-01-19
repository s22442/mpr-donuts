package com.pjatk.donuts.services;

import com.pjatk.donuts.entities.Donut;
import com.pjatk.donuts.entities.DonutPack;
import com.pjatk.donuts.enums.DonutPackShape;
import com.pjatk.donuts.repositories.DonutPackRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

  public DonutPack getNew(String name, DonutPackShape shape, String color, int donutCapacity) {
    DonutPack newDonutPack =
        new DonutPack(null, name, shape, color, donutCapacity, new ArrayList<>());

    this.donutPackRepository.save(newDonutPack);

    return newDonutPack;
  }

  public Optional<DonutPack> getById(Integer id) {
    return this.donutPackRepository.findById(id);
  }

  public List<DonutPack> getAll() {
    return this.donutPackRepository.findAll();
  }

  public void addDonutToDonutPack(Integer donutPackId, Integer donutId)
      throws IllegalStateException {
    DonutPack donutPack = this.getById(donutPackId).orElseThrow(IllegalStateException::new);
    Donut donut = this.donutService.getById(donutId).orElseThrow(IllegalStateException::new);

    if (donutPack.getDonutCapacity() <= donutPack.getDonutCount()) {
      throw new IllegalStateException();
    }

    donutPack.addDonut(donut);

    this.donutPackRepository.save(donutPack);
  }
}
