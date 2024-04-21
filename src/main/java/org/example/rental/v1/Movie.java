package org.example.rental.v1;

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

}
