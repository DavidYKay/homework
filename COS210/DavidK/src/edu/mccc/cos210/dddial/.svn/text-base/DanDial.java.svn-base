package edu.mccc.cos210.dddial;
import java.awt.*;
import java.awt.AWTEvent.*;
import javax.swing.*;
import javax.swing.event.*;
import com.cbthinkx.util.Debug;
import java.util.*;
public class DanDial extends DDDial {
    public DanDial(BoundedRangeModel model) {
        super(model);
        ArrayList<SuperTicks> superTicks = new ArrayList<SuperTicks>();
        superTicks.add( new SuperTicks( 135, Color.RED));
        superTicks.add( new SuperTicks( 180, Color.GREEN));
        superTicks.add( new SuperTicks( 270, Color.BLUE));
        setSuperTicks(superTicks);
        //setAngleStart(60);
        //setAngleExtent(180);
        setAngleStart(0);
        setAngleExtent(90);
        setOpaque(false);
        //setNeedleStart(45);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
