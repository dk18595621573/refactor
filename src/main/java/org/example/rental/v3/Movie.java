package org.example.rental.v3;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 影片类.
 *
 * @author duk
 * @date 2024-04-21 下午2:27
 */
@Data
@AllArgsConstructor
public class Movie {

    public static final int CHILDRENS = 2;
    public static final int  REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    /** 名称 */
    private String title;

    /** 价格(代号) */
    private int priceCode;

    /**
     * 获取对应的价格
     * @param daysRented 租期
     * @return 最终价格
     */
    public double getCharge(int daysRented) {
        double result = 0;
        switch (this.getPriceCode()) {
            case org.example.rental.v2.Movie.REGULAR:
                // 普通片
                result += 2;
                if (daysRented > 2) {
                    result += daysRented - 2;
                }
                break;
            case org.example.rental.v2.Movie.NEW_RELEASE:
                // 新片
                result += daysRented * 3;
                break;
            case org.example.rental.v2.Movie.CHILDRENS:
                // 儿童片
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * 获取积分
     * @param daysRented 租期
     * @return 积分
     */
    public int getFrequentRenterPoints(int daysRented) {
        if (this.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1) {
            // 新片并且租赁超过1天增加两积分
            return 2;
        } else {
            return 1;
        }
    }

}
