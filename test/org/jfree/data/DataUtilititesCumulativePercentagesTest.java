package org.jfree.data;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataUtilititesCumulativePercentagesTest {

  private KeyedValues keyValueMock1;
  private KeyedValues keyValueMock2;
  private KeyedValues keyValueMock3;
  private KeyedValues keyValueMock4;

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {
    // mocks for KeyedValue Methods
    keyValueMock1 = mock(KeyedValues.class);
    keyValueMock2 = mock(KeyedValues.class);
    keyValueMock3 = mock(KeyedValues.class);
    keyValueMock4 = mock(KeyedValues.class);

    // keyedValue positive
    when(keyValueMock1.getItemCount()).thenReturn(3);

    when(keyValueMock1.getIndex(0)).thenReturn(0);
    when(keyValueMock1.getIndex(1)).thenReturn(1);
    when(keyValueMock1.getIndex(2)).thenReturn(2);

    when(keyValueMock1.getKey(0)).thenReturn(0);
    when(keyValueMock1.getKey(1)).thenReturn(1);
    when(keyValueMock1.getKey(2)).thenReturn(2);

    when(keyValueMock1.getValue(0)).thenReturn(5);
    when(keyValueMock1.getValue(1)).thenReturn(9);
    when(keyValueMock1.getValue(2)).thenReturn(2);

    // keyedValue negative
    when(keyValueMock2.getItemCount()).thenReturn(3);

    when(keyValueMock2.getIndex(0)).thenReturn(0);
    when(keyValueMock2.getIndex(1)).thenReturn(1);
    when(keyValueMock2.getIndex(2)).thenReturn(2);

    when(keyValueMock2.getKey(0)).thenReturn(0);
    when(keyValueMock2.getKey(1)).thenReturn(1);
    when(keyValueMock2.getKey(2)).thenReturn(2);

    when(keyValueMock2.getValue(0)).thenReturn(-4);
    when(keyValueMock2.getValue(1)).thenReturn(-6);
    when(keyValueMock2.getValue(2)).thenReturn(-5);

    // keyedValue mix
    when(keyValueMock3.getItemCount()).thenReturn(3);

    when(keyValueMock3.getIndex(0)).thenReturn(0);
    when(keyValueMock3.getIndex(1)).thenReturn(1);
    when(keyValueMock3.getIndex(2)).thenReturn(2);

    when(keyValueMock3.getKey(0)).thenReturn(0);
    when(keyValueMock3.getKey(1)).thenReturn(1);
    when(keyValueMock3.getKey(2)).thenReturn(2);

    when(keyValueMock3.getValue(0)).thenReturn(-4);
    when(keyValueMock3.getValue(1)).thenReturn(6);
    when(keyValueMock3.getValue(2)).thenReturn(5);
    // -4 + 6 + 5 = 7

    // keyedValue One value
    when(keyValueMock4.getItemCount()).thenReturn(1);

    when(keyValueMock4.getIndex(0)).thenReturn(0);

    when(keyValueMock4.getKey(0)).thenReturn(0);

    when(keyValueMock4.getValue(0)).thenReturn(10);
  }

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  void testCumulativePercentagesPositive() {
    KeyedValues actual = DataUtilities.getCumulativePercentages(keyValueMock1);

    assertAll(
        () -> assertEquals(5.0 / 16.0, actual.getValue(0).doubleValue(), 0.0001d),
        () -> assertEquals(((5.0 + 9.0) / 16.0), actual.getValue(1).doubleValue(), 0.0001d),
        () -> assertEquals(1.0, actual.getValue(2).doubleValue(), 0.1d));
  }

  @Test
  void testCumulativePercentagesNegative() {
    KeyedValues actual = DataUtilities.getCumulativePercentages(keyValueMock2);

    assertAll(
        () -> assertEquals((-4.0 / -15.0), actual.getValue(0).doubleValue(), 0.0001d),
        () -> assertEquals((-10.0 / -15.0), actual.getValue(1).doubleValue(), 0.0001d),
        () -> assertEquals(1.0, actual.getValue(2).doubleValue(), 0.1d));
  }

  @Test
  void testCumulativePercentagesMix() {
    KeyedValues actual = DataUtilities.getCumulativePercentages(keyValueMock3);

    assertAll(
        () -> assertEquals(-4.0 / 7, actual.getValue(0).doubleValue()),
        () -> assertEquals(2.0 / 7.0, actual.getValue(1).doubleValue(), 0.0001d),
        () -> assertEquals(1.0, actual.getValue(2).doubleValue()));
  }

  @Test
  void testCumulativePercentagesOneValue() {
    KeyedValues actual = DataUtilities.getCumulativePercentages(keyValueMock4);

    assertEquals(1.0, actual.getValue(0).doubleValue());
  }

  @Test
  void testCumulativePercentagesNull() {
    assertThrows(
        InvalidParameterException.class, () -> DataUtilities.getCumulativePercentages(null));
  }
}
