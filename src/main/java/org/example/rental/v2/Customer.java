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
     * 打印客户信息
     * @return 组装数据
     */
    public String printStatement() {
        StringBuilder sb = new StringBuilder("出租人:").append(getName()).append("\n");
        rentals.forEach(each -> sb.append("租赁名称:").append(each.getMovie().getTitle()).append(", 租赁金额:").append(each.getCharge()).append("\n"));
        sb.append("欠金额:").append(this.getTotalCharge());
        sb.append("客户积分增加:").append(this.getTotalFrequentRenterPoints()).append("积分");
        return sb.toString();
    }

    public String htmlStatement(){
        StringBuilder sb = new StringBuilder("<H1>出租人:<EM>").append(getName()).append("</EM></H1>\n");
        rentals.forEach(each -> sb.append("<H2>租赁名称:<EM>").append(each.getMovie().getTitle()).append("</EM>, 租赁金额:<EM>").append(each.getCharge()).append("</EM></H2>\n"));
        sb.append("<P>欠金额:").append(this.getTotalCharge()).append("</P>\n");
        sb.append("客户积分增加:<EM>").append(this.getTotalFrequentRenterPoints()).append("<EM>积分");
        return sb.toString();
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
