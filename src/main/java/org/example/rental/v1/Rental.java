package org.example.rental.v1;

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

}
