package org.jfree.data;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RangeConstructorTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {}

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  void testConstructorPositive() {
    Range range = new Range(1, 3);

    assertAll(
        () -> assertEquals(1, range.getLowerBound()), () -> assertEquals(3, range.getUpperBound()));
  }

  @Test
  void testConstructorNegative() {
    Range range = new Range(-4, -3);

    assertAll(
        () -> assertEquals(-4, range.getLowerBound()),
        () -> assertEquals(-3, range.getUpperBound()));
  }

  @Test
  void testConstructorMix() {
    Range range = new Range(-4, 3);

    assertAll(
        () -> assertEquals(-4, range.getLowerBound()),
        () -> assertEquals(3, range.getUpperBound()));
  }

  @Test
  void testConstructorIllegal1() {
    assertThrows(IllegalArgumentException.class, () -> new Range(5, 3));
  }

  @Test
  void testConstructorIllegal2() {
    assertThrows(IllegalArgumentException.class, () -> new Range(-1, -9));
  }

  @Test
  void testConstructorIllegal3() {
    assertThrows(IllegalArgumentException.class, () -> new Range(4, -4));
  }
}
