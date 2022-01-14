package com.pjatk.donuts.entities;

import com.pjatk.donuts.enums.DonutFilling;
import com.pjatk.donuts.enums.DonutIcing;
import com.pjatk.donuts.enums.DonutShape;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Donut {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;
  private DonutShape shape;
  private DonutFilling filling;
  private DonutIcing icing;
  private double weightInGrams;
  private double calorieCount;
  private boolean isGlutenFree;

  public Donut() {}

  public Donut(
      Integer id,
      String name,
      DonutShape shape,
      DonutFilling filling,
      DonutIcing icing,
      double weightInGrams,
      double calorieCount,
      boolean isGlutenFree) {
    this.id = id;
    this.name = name;
    this.shape = shape;
    this.filling = filling;
    this.icing = icing;
    this.weightInGrams = weightInGrams;
    this.calorieCount = calorieCount;
    this.isGlutenFree = isGlutenFree;
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

  public DonutShape getShape() {
    return shape;
  }

  public void setShape(DonutShape shape) {
    this.shape = shape;
  }

  public DonutFilling getFilling() {
    return filling;
  }

  public void setFilling(DonutFilling filling) {
    this.filling = filling;
  }

  public DonutIcing getIcing() {
    return icing;
  }

  public void setIcing(DonutIcing icing) {
    this.icing = icing;
  }

  public double getWeightInGrams() {
    return weightInGrams;
  }

  public void setWeightInGrams(double weightInGrams) {
    this.weightInGrams = weightInGrams;
  }

  public double getCalorieCount() {
    return calorieCount;
  }

  public void setCalorieCount(double calorieCount) {
    this.calorieCount = calorieCount;
  }

  public boolean isGlutenFree() {
    return isGlutenFree;
  }

  public void setGlutenFree(boolean glutenFree) {
    isGlutenFree = glutenFree;
  }
}
