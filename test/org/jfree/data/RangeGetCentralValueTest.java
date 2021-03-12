package org.jfree.data;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RangeGetCentralValueTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {}

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  void testCentralValuePositive1() {
    Range range = new Range(10, 20);

    double actual = range.getCentralValue();

    assertEquals(15, actual);
  }

  @Test
  void testCentralValuePositive2() {
    Range range = new Range(2, 2);

    double actual = range.getCentralValue();

    assertEquals(2, actual);
  }

  @Test
  void testCentralValuePositive3() {
    // newest
    Range range = new Range(0, 0);

    double actual = range.getCentralValue();

    assertEquals(0, actual);
  }

  @Test
  void testCentralValueNegative1() {
    Range range = new Range(-20, -10);

    double actual = range.getCentralValue();

    assertEquals(-15, actual);
  }

  @Test
  void testCentralValueNegative2() {
    // newest
    Range range = new Range(-3, -3);

    double actual = range.getCentralValue();

    assertEquals(-3, actual);
  }

  @Test
  void testCentralValueMix1() {
    Range range = new Range(-10, 10);

    double actual = range.getCentralValue();

    assertEquals(0, actual);
  }

  @Test
  void testCentralValueMix2() {
    // newest
    Range range = new Range(-5, 10);

    double actual = range.getCentralValue();

    assertEquals(2.5, actual);
  }

  @SuppressWarnings("null")
  @Test
  void testCentralValueNull() {
    Range range = null;

    assertThrows(NullPointerException.class, () -> range.getCentralValue());
  }
}
