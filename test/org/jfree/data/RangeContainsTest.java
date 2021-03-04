package org.jfree.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RangeContainsTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {}

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  void testContainsPositive1() {
    Range range = new Range(3, 9);

    boolean actual = range.contains(6);

    assertEquals(true, actual);
  }

  @Test
  void testContainsPositive2() {
    Range range = new Range(3, 9);

    boolean actual = range.contains(10);

    assertEquals(false, actual);
  }

  @Test
  void testContainsPositive3() {
    Range range = new Range(3, 3);

    boolean actual = range.contains(3);

    assertEquals(true, actual);
  }

  @Test
  void testContainsPositive4() {
    Range range = new Range(3, 6);

    boolean actual = range.contains(1);

    assertEquals(false, actual);
  }

  @Test
  void testContainsNegative1() {
    Range range = new Range(-12, -5);

    boolean actual = range.contains(-8);

    assertEquals(true, actual);
  }

  @Test
  void testContainsNegative2() {
    Range range = new Range(-12, -5);

    boolean actual = range.contains(-13);

    assertEquals(false, actual);
  }

  @Test
  void testContainsNegative3() {
    Range range = new Range(-12, -5);

    boolean actual = range.contains(-1);

    assertEquals(false, actual);
  }

  @Test
  void testContainsNegative4() {
    Range range = new Range(-5, -5);

    boolean actual = range.contains(-5);

    assertEquals(true, actual);
  }
}
