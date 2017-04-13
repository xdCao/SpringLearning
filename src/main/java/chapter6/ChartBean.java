package chapter6;

import javax.swing.*;

import static javax.swing.SwingConstants.CENTER;

/**
 * Created by xdcao on 2017/4/13.
 */
public class ChartBean extends JPanel {

    private int titlePosition=CENTER;
    private boolean inverse;

    public int getTitlePosition() {
        return titlePosition;
    }

    public boolean isInverse() {
        return inverse;
    }

    public void setTitlePosition(int titlePosition) {
        this.titlePosition = titlePosition;
    }

    public void setInverse(boolean inverse) {
        this.inverse = inverse;
    }
}
