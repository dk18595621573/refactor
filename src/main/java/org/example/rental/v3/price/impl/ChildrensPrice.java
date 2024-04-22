package org.example.rental.v3.price.impl;

import org.example.rental.v3.Movie;
import org.example.rental.v3.price.Price;

/**
 * 儿童片价格.
 *
 * @author duk
 * @date 2024-04-22 下午6:37
 */
public class ChildrensPrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}
