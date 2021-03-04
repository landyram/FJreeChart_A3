package org.jfree.data;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RangeConstraintTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {}

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  void testConstrainPositive() {
    Range range = new Range(3, 10);

    double actual = range.constrain(4);

    assertEquals(4, actual);
  }

  @Test
  void testConstrainPositiveUpperOutBound() {
    Range range = new Range(4, 20);

    double actual = range.constrain(30);

    assertEquals(20, actual);
  }

  @Test
  void testConstrainPositiveLowerOutBound() {
    Range range = new Range(3, 4);

    double actual = range.constrain(1);

    assertEquals(3, actual);
  }

  @Test
  void testConstrainPositiveMatching() {
    Range range = new Range(2, 2);

    double actual = range.constrain(2);

    assertEquals(2, actual);
  }

  @Test
  void testConstrainNegative() {
    Range range = new Range(-12, -5);

    double actual = range.constrain(-8);

    assertEquals(-8, actual);
  }

  @Test
  void testConstrainNegativeUpperOutBound() {
    Range range = new Range(-12, -5);

    double actual = range.constrain(-1);

    assertEquals(-5, actual);
  }

  @Test
  void testConstrainNegativeLowerOutBound() {
    Range range = new Range(-3, -2);

    double actual = range.constrain(-7);

    assertEquals(-3, actual);
  }

  @Test
  void testConstrainMix() {
    Range range = new Range(-4, 1);

    double actual = range.constrain(-3);

    assertEquals(-3, actual);
  }

  @Test
  void testConstrainMixLowerOutBound() {
    Range range = new Range(-2, 1);

    double actual = range.constrain(-3);

    assertEquals(-2, actual);
  }

  @Test
  void testConstrainMixUpperOutBound() {
    Range range = new Range(-2, 1);

    double actual = range.constrain(3);

    assertEquals(1, actual);
  }

  @Test
  void testConstrainNull() {
    Range range = null;

    assertThrows(NullPointerException.class, () -> range.constrain(10));
  }
}
