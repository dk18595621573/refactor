package org.example.rental.v3.price.impl;

import org.example.rental.v3.Movie;
import org.example.rental.v3.price.Price;

/**
 * 普通片价格.
 *
 * @author duk
 * @date 2024-04-22 下午6:39
 */
public class RegularPrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2) {
            result += daysRented - 2;
        }
        return result;
    }
}
