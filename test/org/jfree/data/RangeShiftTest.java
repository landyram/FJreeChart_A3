package org.jfree.data;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RangeShiftTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {}

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  public void testShift() {
    Range r1 = new Range(10.0, 20.0);
    Range r2 = Range.shift(r1, 20.0);
    assertEquals(30.0, r2.getLowerBound(), 0.001);
    assertEquals(40.0, r2.getUpperBound(), 0.001);
  }

  @Test
  public void testShiftNegative0X() {
    Range r1 = new Range(0.0, 100.0);
    Range r2 = Range.shift(r1, -50.0, true);
    assertEquals(-50.0, r2.getLowerBound(), 0.001);
    assertEquals(50.0, r2.getUpperBound(), 0.001);
  }

  @Test
  public void testShiftNegative0X2() {
    Range r1 = new Range(-10.0, 20.0);
    Range r2 = Range.shift(r1, -30.0, true);
    assertEquals(-40.0, r2.getLowerBound(), 0.001);
    assertEquals(-10.0, r2.getUpperBound(), 0.001);
  }

  @Test
  public void testShiftPositive0X() {
    Range r1 = new Range(-10.0, 20.0);
    Range r2 = Range.shift(r1, 20.0, true);
    assertEquals(10.0, r2.getLowerBound(), 0.001);
    assertEquals(40.0, r2.getUpperBound(), 0.001);
  }

  @Test
  public void testShiftZeroValue() {
    Range r1 = new Range(0.0, 0.0);
    Range r2 = Range.shift(r1, 0.0, false);
    assertAll(
        () -> assertEquals(0.0, r2.getLowerBound(), 0.0),
        () -> assertEquals(0.0, r2.getUpperBound(), 0.0));
  }

  @Test
  public void testShift0X() {
    Range r1 = new Range(-10.0, 20.0);
    Range r2 = Range.shift(r1, 20.0, false);
    assertEquals(0.0, r2.getLowerBound(), 0.001);
    assertEquals(40.0, r2.getUpperBound(), 0.001);
  }

  @Test
  public void testShift0X2() {
    Range r1 = new Range(-10.0, 20.0);
    Range r2 = Range.shift(r1, -30.0, false);
    assertEquals(-40.0, r2.getLowerBound(), 0.001);
    assertEquals(0.0, r2.getUpperBound(), 0.001);
  }

  @Test
  public void testShift0Delta() {
    Range r1 = new Range(-10.0, 20.0);
    // Range r2 = Range.shift(r1, -30.0, false);
    Range r2 = Range.shift(r1, 0.0);
    assertEquals(r1, r2);
  }
}
