package com.tyoma17.money;

import org.junit.jupiter.api.Test;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.UnknownCurrencyException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CurrencyUnitTest {

    @Test
    void currencyUnit() {

        CurrencyUnit euro = Monetary.getCurrency("EUR");
        assertEquals("EUR", euro.getCurrencyCode());
        assertEquals(978, euro.getNumericCode());
        assertEquals(2, euro.getDefaultFractionDigits());
    }

    @Test
    void unknownCurrency() {
        assertThrows(UnknownCurrencyException.class, () -> Monetary.getCurrency("RUBLE"));
    }
}
