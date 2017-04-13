package chapter6;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Created by xdcao on 2017/4/13.
 */
public class ChartBeanBeanInfo extends SimpleBeanInfo {

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor titlePositionDescriptor=new PropertyDescriptor("titlePosition",ChartBean.class);
            titlePositionDescriptor.setPropertyEditorClass(TitlePositionEditor.class);
            return new PropertyDescriptor[]{titlePositionDescriptor};
        } catch (IntrospectionException e) {
            e.printStackTrace();
            return null;
        }
    }
}
