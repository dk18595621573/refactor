package rental.v3;

import org.example.rental.v2.Customer;
import org.example.rental.v2.Movie;
import org.example.rental.v2.Rental;

/**
 * 测试.
 *
 * @author duk
 * @date 2024-04-21 下午4:57
 */
public class RentalTest {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName("张三");
        customer.addRental(new Rental(new Movie("大明王朝", Movie.CHILDRENS), 1));
        customer.addRental(new Rental(new Movie("仙剑奇侠传", Movie.NEW_RELEASE), 4));
        System.out.println(customer.htmlStatement());
    }
}
