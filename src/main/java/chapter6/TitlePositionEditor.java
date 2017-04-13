package chapter6;

import java.beans.PropertyEditorSupport;

/**
 * Created by xdcao on 2017/4/13.
 */
public class TitlePositionEditor extends PropertyEditorSupport {

    private String[] options={"Left","Center","Right"};

    public String[] getTags(){
        return options;
    }

    @Override
    public String getJavaInitializationString() {
        return ""+getValue();
    }

    @Override
    public String getAsText() {
        int value=(Integer)getValue();
        return options[value];
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        for(int i=0;i<options.length;i++){
            if (options[i].equals(text)){
                setValue(i);
                return;
            }
        }
    }
}
