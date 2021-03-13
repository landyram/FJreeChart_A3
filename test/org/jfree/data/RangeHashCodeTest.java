package org.jfree.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RangeHashCodeTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {}

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  public void testHashCode() {
    Range r1 = new Range(1.0, 100.0);
    Range r2 = new Range(1.0, 100.0);
    assertEquals(r1.hashCode(), r2.hashCode());

    r1 = new Range(-100.0, 1.0);
    r2 = new Range(-100.0, 1.0);
    assertEquals(r1.hashCode(), r2.hashCode());

    // test Ranges with one equal bound.
    r1 = new Range(10.0, 20.0);
    r2 = new Range(0.0, 20.0);
    assertFalse(r1.hashCode() == r2.hashCode());

    r1 = new Range(0.0, 10.0);
    r2 = new Range(0.0, 20.0);
    assertFalse(r1.hashCode() == r2.hashCode());
  }

  @Test
  public void testHashCodePositive() {
    Range r1 = new Range(1.0, 10.0);
    Range r2 = new Range(1.0, 10.0);
    assertEquals(r1.hashCode(), r2.hashCode());
  }

  @Test
  public void testHashCodeNegative() {
    Range r1 = new Range(-10.0, 1.0);
    Range r2 = new Range(-10.0, 1.0);
    assertEquals(r1.hashCode(), r2.hashCode());
  }

  @Test
  public void testHashCodeNegative2() {
    Range r1 = new Range(-10.0, -1.0);
    Range r2 = new Range(-10.0, -1.0);
    assertEquals(r1.hashCode(), r2.hashCode());
  }

  @Test
  public void testHashCodeOneBound() {
    Range r1 = new Range(10.0, 20.0);
    Range r2 = new Range(0.0, 20.0);
    assertFalse(r1.hashCode(), r2.hashCode());
  }

  @Test
  public void testHashCodeOneBound2() {
    Range r1 = new Range(0.0, 10.0);
    Range r2 = new Range(0.0, 10.0);
    assertFalse(r1.hashCode(), r2.hashCode());
  }
}
