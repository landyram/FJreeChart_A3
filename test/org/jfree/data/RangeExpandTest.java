package org.jfree.data;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RangeExpandTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {}

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  void testExpandDocExample() {
    Range range = new Range(2, 6);

    Range actual = Range.expand(range, 0.25, 0.5);
    Range expected = new Range(1, 8);

    assertAll(
        () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
        () -> assertEquals(expected.getUpperBound(), actual.getUpperBound()),
        () -> assertEquals(expected, actual));
  }

  @Test
  void testExpandPositiveNoPercent() {
    Range range = new Range(0, 7);

    Range actual = Range.expand(range, 0, 0);
    Range expected = new Range(0, 7);

    assertAll(
        () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
        () -> assertEquals(expected.getUpperBound(), actual.getUpperBound()),
        () -> assertEquals(expected, actual));
  }

  @Test
  void testExpandFullPercent() {
    Range range = new Range(-6, -2);

    Range expected = new Range(-10, 2);
    Range actual = Range.expand(range, 1.00, 1.00);

    assertAll(
        () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
        () -> assertEquals(expected.getUpperBound(), actual.getUpperBound()),
        () -> assertEquals(expected, actual));
  }

  @Test
  void testExpandNegativePositive() {
    Range range = new Range(-6, 6);

    Range expected = new Range(-9, 12);
    Range actual = Range.expand(range, 0.25, 0.5);

    assertAll(
        () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
        () -> assertEquals(expected.getUpperBound(), actual.getUpperBound()),
        () -> assertEquals(expected, actual));
  }

  @Test
  void testExpandMatchingRangeValue() {
    Range range = new Range(1, 1);

    Range expected = new Range(1, 1);
    Range actual = Range.expand(range, 0.3, 0.75);

    assertAll(
        () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
        () -> assertEquals(expected.getUpperBound(), actual.getUpperBound()),
        () -> assertEquals(expected, actual));
  }

  @Test
  void testExpandNull() {
    Range range = null;

    assertThrows(InvalidParameterException.class, () -> Range.expand(range, 0.25, 0.5));
  }
}
