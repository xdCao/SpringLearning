package chapter8;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created by xdcao on 2017/4/17.
 */
@Aspect
public class EnableSellerAspect {

    @DeclareParents(value = "chapter7.NaiveWaiter",defaultImpl = SmartSeller.class)
    public Seller seller;

}
