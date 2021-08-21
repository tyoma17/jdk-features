package com.tyoma17.money;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class MonetaryAmountTest {


    @Test
    void instanceCreation() {

        CurrencyUnit euro = Monetary.getCurrency("EUR");

        // default factory
        MonetaryAmount monetaryAmount = Monetary.getDefaultAmountFactory()
                .setCurrency(euro)
                .setNumber(99.99)
                .create();
        assertEquals("EUR 99.99", monetaryAmount.toString());

        // Money
        Money money = Money.of(17.50, euro);
        assertEquals("EUR 17.50", money.toString());

        // FastMoney
        FastMoney fastMoney = FastMoney.of(7.99, euro);
        assertEquals("EUR 7.99", fastMoney.toString());
    }

    @Test
    void equality() {

        MonetaryAmount euro = Monetary.getDefaultAmountFactory()
                .setCurrency("EUR")
                .setNumber(1)
                .create();
        assertFalse(euro.equals(FastMoney.of(1, "EUR")));

        Money ruble = Money.of(1, "RUB");
        assertTrue(ruble.equals(Money.of(1, "RUB")));
    }

    @Test
    void add() {

        MonetaryAmount oneEuro23 = Money.of(1.23, "EUR");
        MonetaryAmount threeEuros56 = Money.of(3.56, "EUR");
        assertEquals("EUR 4.79", oneEuro23.add(threeEuros56).toString());
    }

    @Test
    void subtract() {

        MonetaryAmount oneEuro23 = Money.of(1.23, "EUR");
        MonetaryAmount threeEuros56 = Money.of(3.56, "EUR");
        assertEquals("EUR 2.33", threeEuros56.subtract(oneEuro23).toString());
    }

    @Test
    void multiply() {

        MonetaryAmount oneEuro23 = Money.of(1.23, "EUR");
        assertEquals("EUR 3.69", oneEuro23.multiply(3).toString());
    }

    @Test
    void divide() {

        MonetaryAmount threeEuros33 = Money.of(3.33, "EUR");
        assertEquals("EUR 1.11", threeEuros33.divide(3).toString());
    }

    @Test
    void rounding() {

        MonetaryAmount amount = Money.of(123.45678, "EUR");
        MonetaryAmount roundedAmount = amount.with(Monetary.getDefaultRounding());
        assertEquals("EUR 123.46", roundedAmount.toString());
    }

    @Test
    void formatting() {

        MonetaryAmount euro = Money.of(1, "EUR");
        MonetaryAmountFormat formatRu = MonetaryFormats.getAmountFormat(new Locale("RU"));

        String ruFormatted = formatRu.format(euro);
        assertEquals("1,00 EUR", ruFormatted);
    }
}
