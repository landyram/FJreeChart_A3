package org.jfree.data;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RangeExpandToIncludeTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {}

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  void testExpandToIncludePositiveGreater() {
    Range range = new Range(1, 2);

    Range actual = Range.expandToInclude(range, 3);
    Range expected = new Range(1, 3);

    assertAll(
        () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
        () -> assertEquals(expected.getUpperBound(), actual.getUpperBound()),
        () -> assertEquals(expected, actual));
  }

  @Test
  void testExpandToIncludePositiveLesser() {
    Range range = new Range(5, 7);
    Range actual = Range.expandToInclude(range, 3);
    Range expected = new Range(3, 7);

    assertAll(
        () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
        () -> assertEquals(expected.getUpperBound(), actual.getUpperBound()),
        () -> assertEquals(expected, actual));
  }

  @Test
  void testExpandToIncludeNegativeGreater() {
    Range range = new Range(-10, -5);
    Range actual = Range.expandToInclude(range, -1);
    Range expected = new Range(-10, -1);

    assertAll(
        () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
        () -> assertEquals(expected.getUpperBound(), actual.getUpperBound()),
        () -> assertEquals(expected, actual));
  }

  @Test
  void testExpandToIncludeNull() {
    Range range = null;
    Range actual = Range.expandToInclude(range, 3);
    Range expected = new Range(3, 3);

    assertAll(
        () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
        () -> assertEquals(expected.getUpperBound(), actual.getUpperBound()),
        () -> assertEquals(expected, actual));
  }

  @Test
  void testExpandToIncludeMatch1() {
    Range range = new Range(0, 0);
    Range actual = Range.expandToInclude(range, 7);
    Range expected = new Range(0, 7);

    assertAll(
        () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
        () -> assertEquals(expected.getUpperBound(), actual.getUpperBound()),
        () -> assertEquals(expected, actual));
  }

  @Test
  void testExpandToIncludeMatch2() {
    Range range = new Range(1, 1);
    Range actual = Range.expandToInclude(range, 1);
    Range expected = new Range(1, 1);

    assertAll(
        () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
        () -> assertEquals(expected.getUpperBound(), actual.getUpperBound()),
        () -> assertEquals(expected, actual));
  }
}
