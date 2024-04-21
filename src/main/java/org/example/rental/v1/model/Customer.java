package org.example.rental.v1.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 顾客.
 *
 * @author duk
 * @date 2024-04-21 下午3:46
 */
@Getter
@Slf4j
public class Customer {

    /** 名称 */
    @Setter
    private String name;

    /** 租借集合 */
    private final List<Rental> rentals = new ArrayList<>();

    /**
     * 增加租借记录
     * @param rental 租赁信息
     */
    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    /**
     * 执行逻辑
     */
    public void statement() {

        // 总金额
        double totalAmount = 0;
        // 常客积分
        int frequentRenterPoints = 0;

        log.info("出租人:{}", getName());

        // 循环
        for (Rental each : rentals) {
            // 本次总金额
            double thisAmount = 0;
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    // 普通片
                    thisAmount += 2;
                    if (each.getDaysRented() > 2) {
                        thisAmount += each.getDaysRented() - 2;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    // 新片
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    // 儿童片
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
                default:
                    break;
            }
            // 累计常客积分
            frequentRenterPoints ++;
            // 新电影增加常客积分
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1) {
                frequentRenterPoints ++;
            }

            // 打印借贷记录
            log.info("租赁名称:{}, 租赁金额:{}", each.getMovie().getTitle(), thisAmount);

            totalAmount += thisAmount;
        }
        log.info("欠金额:{}", totalAmount);
        log.info("客户积分增加:{} 积分", frequentRenterPoints);
    }

}
