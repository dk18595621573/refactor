package org.example.rental.v2;

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

        log.info("出租人:{}", getName());

        // 循环
        for (Rental each : rentals) {
            // 打印借贷记录
            log.info("租赁名称:{}, 租赁金额:{}", each.getMovie().getTitle(), each.getCharge());
        }

        log.info("欠金额:{}", this.getTotalCharge());
        log.info("客户积分增加:{} 积分", this.getTotalFrequentRenterPoints());
    }

    /**
     * 获取总租赁金额
     * @return 金额
     */
    public double getTotalCharge() {
        double result = 0;
        for (Rental each : this.rentals) {
            result += each.getCharge();
        }
        return result;
    }

    /**
     * 获取总积分
     * @return 积分
     */
    public double getTotalFrequentRenterPoints() {
        double result = 0;
        for (Rental each : this.rentals) {
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}
