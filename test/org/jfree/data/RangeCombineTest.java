package org.jfree.data;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RangeCombineTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {}

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  void testCombinePositive1() {
    Range range1 = new Range(3, 5);
    Range range2 = new Range(1, 13);

    Range actual = Range.combine(range1, range2);
    Range expected = new Range(1, 13);

    assertEquals(expected, actual);
  }

  @Test
  void testCombinePositive2() {
    Range range1 = new Range(2, 7);
    Range range2 = new Range(1, 20);

    Range actual = Range.combine(range1, range2);
    Range expected = new Range(1, 20);

    assertEquals(expected, actual);
  }

  @Test
  void testCombinePositive3() {
    Range range1 = new Range(3, 5);
    Range range2 = new Range(3, 13);

    Range actual = Range.combine(range1, range2);
    Range expected = new Range(3, 13);

    assertEquals(expected, actual);
  }

  @Test
  void testCombinePositive4() {
    Range range1 = new Range(3, 15);
    Range range2 = new Range(1, 15);

    Range actual = Range.combine(range1, range2);
    Range expected = new Range(1, 15);

    assertEquals(expected, actual);
  }

  @Test
  void testCombinePositive5() {
    Range range1 = new Range(1, 14);
    Range range2 = new Range(5, 8);

    Range actual = Range.combine(range1, range2);
    Range expected = new Range(1, 14);

    assertEquals(expected, actual);
  }

  @Test
  void testCombinePositive6() {
    Range range1 = new Range(3, 5);
    Range range2 = new Range(3, 5);

    Range actual = Range.combine(range1, range2);
    Range expected = new Range(3, 5);

    assertEquals(expected, actual);
  }

  @Test
  void testCombineNegative1() {
    Range range1 = new Range(-5, -3);
    Range range2 = new Range(-5, -3);

    Range actual = Range.combine(range1, range2);
    Range expected = new Range(-5, -3);

    assertEquals(expected, actual);
  }

  @Test
  void testCombineNegative2() {
    Range range1 = new Range(-5, -3);
    Range range2 = new Range(-13, -5);

    Range actual = Range.combine(range1, range2);
    Range expected = new Range(-13, -3);

    assertEquals(expected, actual);
  }

  @Test
  void testCombineNegative3() {
    Range range1 = new Range(-8, -6);
    Range range2 = new Range(-9, -1);

    Range actual = Range.combine(range1, range2);
    Range expected = new Range(-9, -1);

    assertEquals(expected, actual);
  }

  @Test
  void testCombineMix1() {
    Range range1 = new Range(3, 5);
    Range range2 = new Range(-13, -3);

    Range actual = Range.combine(range1, range2);
    Range expected = new Range(-13, 5);

    assertEquals(expected, actual);
  }

  @Test
  void testCombineMix2() {
    Range range1 = new Range(-13, -3);
    Range range2 = new Range(3, 5);

    Range actual = Range.combine(range1, range2);
    Range expected = new Range(-13, 5);

    assertEquals(expected, actual);
  }

  @Test
  void testCombineNull1() {
    Range range1 = null;
    Range range2 = null;

    assertThrows(NullPointerException.class, () -> Range.combine(range1, range2));
  }

  @Test
  void testCombineNull2() {
    Range range1 = null;
    Range range2 = new Range(4, 6);

    Range actual = Range.combine(range1, range2);
    Range expected = new Range(4, 6);

    assertAll(
        () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
        () -> assertEquals(expected.getUpperBound(), actual.getUpperBound()),
        () -> assertEquals(expected, actual));
  }

  @Test
  void testCombineNull3() {
    Range range1 = new Range(3, 5);
    Range range2 = null;

    Range actual = Range.combine(range1, range2);
    Range expected = new Range(3, 5);

    assertAll(
        () -> assertEquals(expected.getLowerBound(), actual.getLowerBound()),
        () -> assertEquals(expected.getUpperBound(), actual.getUpperBound()),
        () -> assertEquals(expected, actual));
  }
}
