package chapter4;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Created by xdcao on 2017/4/2.
 */
public class PatternResolverTest {

    @Test
    public void getResources() throws Throwable{
        ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();

        Resource[] resources=resolver.getResources("classpath*:");
        Assert.assertNotNull(resources);
        for (Resource resource:resources){
            System.out.println(resource.getDescription());
        }
    }

}
