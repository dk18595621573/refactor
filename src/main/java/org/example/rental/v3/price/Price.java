package org.example.rental.v3.price;

/**
 * 价格状态.
 *
 * @author duk
 * @date 2024-04-22 下午4:26
 */
public abstract class Price {

    /**
     * 价格代码
     * @return 价格代码
     */
    public abstract int getPriceCode();

    /**
     * 价格获取
     * @param daysRented 租期
     * @return 价格
     */
    public abstract double getCharge(int daysRented);

    /**
     * 获取积分
     * @param daysRented 租期
     * @return 积分
     */
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }

}
