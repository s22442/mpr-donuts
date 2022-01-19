package com.pjatk.donuts.entities;

import com.pjatk.donuts.enums.DonutPackShape;

import javax.persistence.*;
import java.util.List;

@Entity
public class DonutPack {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;
  private DonutPackShape shape;
  private String color;
  private int donutCapacity;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Donut> donuts;

  public DonutPack() {}

  public DonutPack(
      Integer id,
      String name,
      DonutPackShape shape,
      String color,
      int donutCapacity,
      List<Donut> donuts) {
    this.id = id;
    this.name = name;
    this.shape = shape;
    this.color = color;
    this.donutCapacity = donutCapacity;
    this.donuts = donuts;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DonutPackShape getShape() {
    return shape;
  }

  public void setShape(DonutPackShape shape) {
    this.shape = shape;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getDonutCapacity() {
    return donutCapacity;
  }

  public void setDonutCapacity(int donutCapacity) {
    this.donutCapacity = donutCapacity;
  }

  public List<Donut> getDonuts() {
    return donuts;
  }

  public void setDonuts(List<Donut> donuts) {
    this.donuts = donuts;
  }

  public int getDonutCount() {
    return this.donuts.size();
  }

  public void addDonut(Donut donut) {
    this.donuts.add(donut);
  }
}
