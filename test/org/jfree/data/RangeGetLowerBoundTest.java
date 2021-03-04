package org.jfree.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RangeGetLowerBoundTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {}

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  public void testLowerBound() {
    Range r1 = new Range(0.0, 10.0);
    assertEquals(r1.getLowerBound(), 0.0);
  }

  @Test
  public void testLowerEquals() {
    Range r1 = new Range(10.0, 10.0);
    assertEquals(r1.getLowerBound(), 10.0);
  }

  @Test
  public void testNegativeLower() {
    Range r1 = new Range(-10.0, 10.0);
    assertEquals(r1.getLowerBound(), -10.0);
  }
}
