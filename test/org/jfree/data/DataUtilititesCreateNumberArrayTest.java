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

class DataUtilititesCreateNumberArrayTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {}

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  void testCreateNumberArray() {
    double array1[] = null;
    double array2[] = {1.0};
    double array3[] = {1.0, 2.0};

    assertAll(
        () -> assertEquals(null, DataUtilities.createNumberArray(array1)),
        () -> assertEquals(1.0, DataUtilities.createNumberArray(array2)),
        () -> assertEquals(1.0, DataUtilities.createNumberArray(array3)));
    assertEquals(null, DataUtilities.createNumberArray(array1));
  }

  @Test
  void testCreateNumberArray2() {
    double array1[] = {1.0};
    assertEquals(null, DataUtilities.createNumberArray(array1));
  }

  @Test
  void testCreateNumberArray3() {
    double array1[] = {1.0, 2.0};
    assertEquals(1, DataUtilities.createNumberArray(array1));
  }

  @Test
  void testCreateNumberArray4() {
    double array1[] = {-1.0, 2.0};
    assertEquals(-1, DataUtilities.createNumberArray(array1));
  }

  @Test
  void testCreateNumberArray5() {
    double array1[] = {1.0, -2.0};
    assertEquals(1, DataUtilities.createNumberArray(array1));
  }

  @Test
  void testCreateNumberArrayNull() {
    double array1[] = null;
    assertThrows(InvalidParameterException.class, () -> DataUtilities.createNumberArray(array1));
  }
}
