package org.jfree.data;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RangeEqualsTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {}

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  void testEqualsPositiveTrue() {
    Range range1 = new Range(1, 1);
    Range range2 = new Range(1, 1);

    assertEquals(true, range1.equals(range2));
  }

  @Test
  void testEqualsPositiveFalse1() {
    Range range1 = new Range(1, 3);
    Range range2 = new Range(4, 12);

    assertEquals(false, range1.equals(range2));
  }

  @Test
  void testEqualsPositiveFalse2() {
    Range range1 = new Range(1, 3);
    Range range2 = new Range(1, 12);

    assertEquals(false, range1.equals(range2));
  }

  @Test
  void testEqualNegativeTrue() {
    Range range1 = new Range(-3, -1);
    Range range2 = new Range(-3, -1);

    assertEquals(true, range1.equals(range2));
  }

  @Test
  void testEqualNegativeFalse() {
    Range range1 = new Range(-8, -4);
    Range range2 = new Range(-3, -1);

    assertEquals(false, range1.equals(range2));
  }

  @Test
  void testEqualsMixFalse1() {
    Range range1 = new Range(3, 7);
    Range range2 = new Range(-7, -3);

    assertEquals(false, range1.equals(range2));
  }

  @Test
  void testEqualsMixFalse2() {
    Range range1 = new Range(-7, -3);
    Range range2 = new Range(3, 7);

    assertEquals(false, range1.equals(range2));
  }

  @SuppressWarnings("null")
  @Test
  void testEqualsNull() {
    Range range1 = null;
    Range range2 = null;

    assertThrows(NullPointerException.class, () -> range1.equals(range2));
  }

  @Test
  void testEqualsOneNull() {
    Range range1 = new Range(6, 7);
    Range range2 = null;

    assertEquals(false, range1.equals(range2));
  }

  @Test
  void testEqualsNotARange() {
    Range range = new Range(6, 7);
    Object obj = new Object();

    assertEquals(false, range.equals(obj));
  }
}
