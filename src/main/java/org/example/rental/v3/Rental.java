package org.example.rental.v3;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 租赁类.
 *
 * @author duk
 * @date 2024-04-21 下午2:33
 */
@Data
@AllArgsConstructor
public class Rental {

    /** 影片 */
    private Movie movie;

    /** 租期 */
    private int daysRented;

    /**
     * 获取对应的价格
     * @return 最终价格
     */
    public double getCharge() {
        double result = 0;
        switch (this.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                // 普通片
                result += 2;
                if (this.getDaysRented() > 2) {
                    result += this.getDaysRented() - 2;
                }
                break;
            case Movie.NEW_RELEASE:
                // 新片
                result += this.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                // 儿童片
                result += 1.5;
                if (this.getDaysRented() > 3) {
                    result += (this.getDaysRented() - 3) * 1.5;
                }
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * 获取积分
     * @return 积分
     */
    public int getFrequentRenterPoints() {
        if (this.getMovie().getPriceCode() == Movie.NEW_RELEASE && this.getDaysRented() > 1) {
            // 新片并且租赁超过1天增加两积分
            return 2;
        } else {
            return 1;
        }
    }

}
