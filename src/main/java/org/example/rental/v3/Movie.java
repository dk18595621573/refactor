package org.example.rental.v3;

import lombok.Data;
import org.example.rental.v3.price.Price;
import org.example.rental.v3.price.impl.ChildrensPrice;
import org.example.rental.v3.price.impl.NewReleasePrice;
import org.example.rental.v3.price.impl.RegularPrice;

/**
 * 影片类.
 *
 * @author duk
 * @date 2024-04-21 下午2:27
 */
@Data
public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    /** 名称 */
    private String title;

    /** 价格信息 */
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        switch (priceCode) {
            case REGULAR:
                this.price = new RegularPrice();
                break;
            case CHILDRENS:
                this.price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                this.price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Invalid price code: " + priceCode);
        }
    }

    /**
     * 获取对应的价格
     * @param daysRented 租期
     * @return 最终价格
     */
    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    /**
     * 获取积分
     * @param daysRented 租期
     * @return 积分
     */
    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }

}
