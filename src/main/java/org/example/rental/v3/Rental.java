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
        return movie.getCharge(this.daysRented);
    }

    /**
     * 获取积分
     * @return 积分
     */
    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(this.daysRented);
    }

}
