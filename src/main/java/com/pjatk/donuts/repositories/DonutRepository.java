package com.pjatk.donuts.repositories;

import com.pjatk.donuts.entities.Donut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonutRepository extends JpaRepository<Donut, Integer> {}
