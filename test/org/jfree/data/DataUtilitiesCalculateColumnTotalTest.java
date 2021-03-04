package org.jfree.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataUtilitiesCalculateColumnTotalTest {
  private Values2D value;
  private Values2D value2;
  private Values2D value3;

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {
    // mocks for Values2D methods
    //  1  2  3  4
    //	5  6  7  8   	 // testing all positive
    //	9 10 11 12
    value = mock(Values2D.class);
    when(value.getColumnCount()).thenReturn(4);
    when(value.getRowCount()).thenReturn(3);
    when(value.getValue(0, 0)).thenReturn(1);
    when(value.getValue(0, 1)).thenReturn(2);
    when(value.getValue(0, 2)).thenReturn(3);
    when(value.getValue(0, 3)).thenReturn(4);
    when(value.getValue(1, 0)).thenReturn(5);
    when(value.getValue(1, 1)).thenReturn(6);
    when(value.getValue(1, 2)).thenReturn(7);
    when(value.getValue(1, 3)).thenReturn(8);
    when(value.getValue(2, 0)).thenReturn(9);
    when(value.getValue(2, 1)).thenReturn(10);
    when(value.getValue(2, 2)).thenReturn(11);
    when(value.getValue(2, 3)).thenReturn(12);

    //   1 -2  3 -4
    //	-5  6 -7  8   	 // testing for mixed numbers
    //	-9 -10 11 12
    value2 = mock(Values2D.class);
    when(value2.getColumnCount()).thenReturn(4);
    when(value2.getRowCount()).thenReturn(3);
    when(value2.getValue(0, 0)).thenReturn(1);
    when(value2.getValue(0, 1)).thenReturn(-2);
    when(value2.getValue(0, 2)).thenReturn(3);
    when(value2.getValue(0, 3)).thenReturn(-4);
    when(value2.getValue(1, 0)).thenReturn(-5);
    when(value2.getValue(1, 1)).thenReturn(6);
    when(value2.getValue(1, 2)).thenReturn(-7);
    when(value2.getValue(1, 3)).thenReturn(8);
    when(value2.getValue(2, 0)).thenReturn(-9);
    when(value2.getValue(2, 1)).thenReturn(-10);
    when(value2.getValue(2, 2)).thenReturn(11);
    when(value2.getValue(2, 3)).thenReturn(12);

    //  -1  -2  -3  -4
    //	-5  -6  -7  -8   	 // testing for all negative
    //	-9 -10 -11 -12
    value3 = mock(Values2D.class);
    when(value3.getColumnCount()).thenReturn(4);
    when(value3.getRowCount()).thenReturn(3);
    when(value3.getValue(0, 0)).thenReturn(-1);
    when(value3.getValue(0, 1)).thenReturn(-2);
    when(value3.getValue(0, 2)).thenReturn(-3);
    when(value3.getValue(0, 3)).thenReturn(-4);
    when(value3.getValue(1, 0)).thenReturn(-5);
    when(value3.getValue(1, 1)).thenReturn(-6);
    when(value3.getValue(1, 2)).thenReturn(-7);
    when(value3.getValue(1, 3)).thenReturn(-8);
    when(value3.getValue(2, 0)).thenReturn(-9);
    when(value3.getValue(2, 1)).thenReturn(-10);
    when(value3.getValue(2, 2)).thenReturn(-11);
    when(value3.getValue(2, 3)).thenReturn(-12);
  }

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  void testCalculateColumnTotal1() {
    double actual = DataUtilities.calculateColumnTotal(value, 0);
    assertEquals(15, actual);
  }

  @Test
  void testCalculateColumnTotal2() {
    double actual = DataUtilities.calculateColumnTotal(value, 1);
    assertEquals(18, actual);
  }

  @Test
  void testCalculateColumnTotal3() {
    double actual = DataUtilities.calculateColumnTotal(value, 2);
    assertEquals(21, actual);
  }

  @Test
  void testCalculateColumnTotal4() {
    double actual = DataUtilities.calculateColumnTotal(value, 3);
    assertEquals(24, actual);
  }

  @Test
  void testCalculateColumnTotal5() {
    double actual = DataUtilities.calculateColumnTotal(value2, 0);
    assertEquals(-13, actual);
  }

  @Test
  void testCalculateColumnTotal6() {
    double actual = DataUtilities.calculateColumnTotal(value2, 1);
    assertEquals(-6, actual);
  }

  /*Mix values*/

  @Test
  void testCalculateColumnTotal7() {
    double actual = DataUtilities.calculateColumnTotal(value2, 2);
    assertEquals(7, actual);
  }

  @Test
  void testCalculateColumnTotal8() {
    double actual = DataUtilities.calculateColumnTotal(value2, 3);
    assertEquals(13, actual);
  }

  /*Negative Values*/
  @Test
  void testCalculateColumnTotal9() {
    double actual = DataUtilities.calculateColumnTotal(value3, 0);
    assertEquals(-15, actual);
  }

  @Test
  void testCalculateColumnTotal10() {
    double actual = DataUtilities.calculateColumnTotal(value3, 1);
    assertEquals(-18, actual);
  }

  @Test
  void testCalculateColumnTotal11() {
    double actual = DataUtilities.calculateColumnTotal(value3, 2);
    assertEquals(-21, actual);
  }

  @Test
  void testCalculateColumnTotal12() {
    double actual = DataUtilities.calculateColumnTotal(value3, 3);
    assertEquals(-24, actual);
  }
}
