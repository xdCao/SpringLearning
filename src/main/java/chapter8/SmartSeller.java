package chapter8;

import org.springframework.stereotype.Service;

/**
 * Created by xdcao on 2017/4/17.
 */
public class SmartSeller implements Seller {
    @Override
    public void sell(String goods) {
        System.out.println("sell ing ...");
    }
}
