package org.jfree.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RangeGetLengthTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {}

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  public void testLength() {
    Range r1 = new Range(0.0, 10.0);
    assertEquals(10.0, r1.getLength());
  }

  @Test
  public void testEqualLength() {
    Range r1 = new Range(10.0, 10.0);
    assertEquals(0.0, r1.getLength());
  }

  @Test
  public void testMaxLength() {
    Range r1 = new Range(0.0, Double.MAX_VALUE);
    assertEquals(Double.MAX_VALUE, r1.getLength());
  }
}
