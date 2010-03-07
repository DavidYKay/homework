package edu.mccc.cos210.dddial;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class TestModel extends DefaultBoundedRangeModel implements ActionListener {
    public TestModel(int value, int extent, int min, int max ) {
        super(value,  extent,  min,  max);
        Timer timer = new Timer(
            100, 
            this
        );
        timer.start();
    }
    private void increment() {
        setValue(
            getValue() + 1
        );
    }
    //Handle timer events
    public void actionPerformed(ActionEvent e) {
        System.out.println("Model tick: " + getValue());
        increment();
        fireStateChanged();
    }
}
