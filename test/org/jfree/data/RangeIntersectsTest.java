package org.jfree.data;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RangeIntersectsTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {}

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  public void testNoIntersects() {
    Range r1 = new Range(0.0, 1.0);

    assertAll(
        () -> assertFalse(r1.intersects(-2.0, -1.0)),
        () -> assertFalse(r1.intersects(-2.0, 0.0)),
        () -> assertFalse(r1.intersects(1.0, 1.1)));
  }

  @Test
  public void testIntersects() {
    Range r1 = new Range(0.0, 1.0);
    assertAll(
        () -> assertTrue(r1.intersects(-2.0, 0.5)),
        () -> assertTrue(r1.intersects(-2.0, 1.0)),
        () -> assertTrue(r1.intersects(-2.0, 1.5)),
        () -> assertTrue(r1.intersects(0.0, 0.5)),
        () -> assertTrue(r1.intersects(0.0, 1.0)),
        () -> assertTrue(r1.intersects(0.0, 1.5)),
        () -> assertTrue(r1.intersects(0.5, 0.6)),
        () -> assertTrue(r1.intersects(0.5, 1.0)),
        () -> assertTrue(r1.intersects(0.5, 1.5)));
  }
}
