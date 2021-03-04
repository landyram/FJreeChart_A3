package org.jfree.data;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataUtilitiesCreateNumberArray2DTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {}

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  void testCreateNumberArray2DPositiveValues() {
    double[][] data = new double[][] {{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}};

    Number[][] actual = DataUtilities.createNumberArray2D(data);
    Number[][] expected = new Number[][] {{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}};

    assertAll(
        () -> assertEquals(expected[0][0], actual[0][0]),
        () -> assertEquals(expected[0][1], actual[0][1]),
        () -> assertEquals(expected[0][2], actual[0][2]),
        () -> assertEquals(expected[1][0], actual[1][0]),
        () -> assertEquals(expected[1][1], actual[1][1]),
        () -> assertEquals(expected[1][2], actual[1][2]));
  }

  @Test
  void testCreateNumberArray2DNegativeValues() {
    double[][] data = new double[][] {{-1.0, -2.0, -3.0}, {-1.0, -2.0, -3.0}};

    Number[][] actual = DataUtilities.createNumberArray2D(data);
    Number[][] expected = new Number[][] {{-1.0, -2.0, -3.0}, {-1.0, -2.0, -3.0}};

    assertAll(
        () -> assertEquals(expected[0][0], actual[0][0]),
        () -> assertEquals(expected[0][1], actual[0][1]),
        () -> assertEquals(expected[0][2], actual[0][2]),
        () -> assertEquals(expected[1][0], actual[1][0]),
        () -> assertEquals(expected[1][1], actual[1][1]),
        () -> assertEquals(expected[1][2], actual[1][2]));
  }

  @Test
  void testCreateNumberArray2DMixValues() {
    double[][] data = new double[][] {{1.0, 2.0, 3.0}, {-1.0, -2.0, -3.0}};

    Number[][] actual = DataUtilities.createNumberArray2D(data);
    Number[][] expected = new Number[][] {{1.0, 2.0, 3.0}, {-1.0, -2.0, -3.0}};

    assertAll(
        () -> assertEquals(expected[0][0], actual[0][0]),
        () -> assertEquals(expected[0][1], actual[0][1]),
        () -> assertEquals(expected[0][2], actual[0][2]),
        () -> assertEquals(expected[1][0], actual[1][0]),
        () -> assertEquals(expected[1][1], actual[1][1]),
        () -> assertEquals(expected[1][2], actual[1][2]));
  }

  @Test
  void testCreateNumberArray2DNull() {
    double[][] data = null;

    assertThrows(InvalidParameterException.class, () -> DataUtilities.createNumberArray2D(data));
  }
}
