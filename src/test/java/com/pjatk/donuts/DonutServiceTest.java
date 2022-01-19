package com.pjatk.donuts;

import com.pjatk.donuts.entities.Donut;
import com.pjatk.donuts.services.DonutService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DonutServiceTest {

  @InjectMocks private DonutService donutService;

  @Test
  void shouldGetExampleWithName() {
    String name = "example";

    Donut donut = this.donutService.getExampleWithName(name);

    assertThat(donut.getName()).isEqualTo(name);
  }
}
