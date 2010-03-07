package edu.mccc.cos210.dddial;
import java.awt.*;
import javax.swing.*;
import com.cbthinkx.util.Debug;
import java.util.*;
public class DaveDial extends DDDial {
    public DaveDial(BoundedRangeModel model) {
        super(model);
        //180 degree dial
        setRound(false);

        ArrayList<SuperTicks> superTicks = new ArrayList<SuperTicks>();
        superTicks.add( new SuperTicks(135, Color.RED));
        superTicks.add( new SuperTicks(180, Color.GREEN));
        superTicks.add( new SuperTicks(90, Color.BLUE));
        superTicks.add( new SuperTicks(270, Color.GREEN));
        setSuperTicks(superTicks);
        //setAngleStart(0);
        //setAngleExtent(270);
        setAngleStart(90);
        setAngleExtent(270);
        setOpaque(false);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
