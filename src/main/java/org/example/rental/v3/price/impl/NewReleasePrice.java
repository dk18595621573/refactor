package org.example.rental.v3.price.impl;

import org.example.rental.v3.Movie;
import org.example.rental.v3.price.Price;

/**
 * 新片价格.
 *
 * @author duk
 * @date 2024-04-22 下午6:42
 */
public class NewReleasePrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}
