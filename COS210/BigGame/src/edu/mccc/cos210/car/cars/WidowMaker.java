    package edu.mccc.cos210.car.cars;
    import java.awt.*;
    import java.awt.geom.*;
    import javax.swing.*;
    import edu.mccc.cos210.car.*;
    import com.cbthinkx.util.Debug;
    import java.awt.font.*;
    public class WidowMaker extends Car {
           protected void paintTop(JPanel jp, Graphics2D g2d, AffineTransform at) {
                   Debug.println("MyCar:paintTop()");
                   //Frame of car
                   Path2D p2d = new Path2D.Double();
                   p2d.moveTo(-0.5, 1.15);
                   p2d.quadTo(-0.15, 1.25, -0.3, 1.2);
                   p2d.quadTo(0.0, 1.3, 0.3, 1.2);
                   p2d.quadTo(0.15, 1.25, 0.5, 1.15);
                   p2d.lineTo(0.5, -1.05);
                   p2d.quadTo(0.0, -1.1, -0.5, -1.05);
                   p2d.closePath();
                   Shape s = p2d.createTransformedShape(at);
                   g2d.setPaint(Color.YELLOW);
                   g2d.fill(s);
                   //Windows
                   //Front
                   p2d = new Path2D.Double();
                   p2d.moveTo(-0.4, 0.55);
                   p2d.quadTo(0.0, 0.7, 0.4, 0.55);
                   p2d.lineTo(0.3, 0.4);
                   p2d.lineTo(-0.3, 0.4);
                   p2d.closePath();
                   s = p2d.createTransformedShape(at);
                   g2d.setPaint(Color.BLACK);
                   g2d.fill(s);
                   //Top Right
                   p2d = new Path2D.Double();
                   p2d.moveTo(-0.4, 0.5);
                   p2d.lineTo(-0.35, 0.3);
                   p2d.lineTo(-0.35, 0.0);
                   p2d.lineTo(-0.4, 0.0);
                   p2d.closePath();
                   s = p2d.createTransformedShape(at);
                   g2d.setPaint(Color.BLACK);
                   g2d.fill(s);
                   //Bottom Right
                   p2d = new Path2D.Double();
                   p2d.moveTo(-0.4, -0.6);
                   p2d.lineTo(-0.35, -0.5);
                   p2d.lineTo(-0.35, -0.1);
                   p2d.lineTo(-0.4, -0.1);
                   p2d.closePath();
                   s = p2d.createTransformedShape(at);
                   g2d.setPaint(Color.BLACK);
                   g2d.fill(s);;
                   //Top Left
                   p2d = new Path2D.Double();
                   p2d.moveTo(0.4, 0.5);
                   p2d.lineTo(0.35, 0.3);
                   p2d.lineTo(0.35, 0.0);
                   p2d.lineTo(0.4, 0.0);
                   p2d.closePath();
                   s = p2d.createTransformedShape(at);
                   g2d.setPaint(Color.BLACK);
                   g2d.fill(s);
                   //Bottom Left
                   p2d = new Path2D.Double();
                   p2d.moveTo(0.4, -0.6);
                   p2d.lineTo(0.35, -0.5);
                   p2d.lineTo(0.35, -0.1);
                   p2d.lineTo(0.4, -0.1);
                   p2d.closePath();
                   s = p2d.createTransformedShape(at);
                   g2d.setPaint(Color.BLACK);
                   g2d.fill(s);
                   //Back
                   p2d = new Path2D.Double();
                   p2d.moveTo(-0.3, -0.45);
                   p2d.lineTo(0.3, -0.45);
                   p2d.lineTo(0.4, -0.7);
                   p2d.quadTo(0.0, -.8, -0.4, -0.7);
                   p2d.closePath();
                   s = p2d.createTransformedShape(at);
                   g2d.setPaint(Color.BLACK);
                   g2d.fill(s);
                   //Right Light
                   p2d = new Path2D.Double();
                   p2d.moveTo(-0.5, 1.1);
                   p2d.quadTo(-0.4, 1.2, -0.2, 1.15);
                   p2d.closePath();
                   s = p2d.createTransformedShape(at);
                   g2d.setPaint(Color.WHITE);
                   g2d.fill(s);
                   //Left Light
                   p2d = new Path2D.Double();
                   p2d.moveTo(0.5, 1.1);
                   p2d.quadTo(0.4, 1.2, 0.2, 1.15);
                   p2d.closePath();
                   s = p2d.createTransformedShape(at);
                   g2d.fill(s);
                   //Details
                   p2d = new Path2D.Double();
                   p2d.moveTo(-0.5, -1.03);
                   p2d.quadTo(0.0, -1.08, 0.5, -1.03);
                   p2d.moveTo(-0.4, -1.05);
                   p2d.lineTo(-0.4, -0.7);
                   p2d.moveTo(0.4, -1.05);
                   p2d.lineTo(0.4, -0.7);
                   p2d.moveTo(-0.3, -0.45);
                   p2d.lineTo(-0.3, 0.4);
                   p2d.moveTo(0.3, -0.45);
                   p2d.lineTo(0.3, 0.4);
                   p2d.moveTo(-0.3, -0.05);
                   p2d.lineTo(-0.5, -0.05);
                   p2d.moveTo(0.3, -0.05);
                   p2d.lineTo(0.5, -0.05);
                   p2d.moveTo(-0.4, 0.55);
                   p2d.lineTo(-0.4, 1.1);
                   p2d.lineTo(0.4, 1.1);
                   p2d.lineTo(0.4, 0.55);
                   p2d.moveTo(-0.3, 0.6);
                   p2d.lineTo(-0.2, 1.15);
                   p2d.quadTo(0.0, 1.1, 0.2, 1.15);
                   p2d.lineTo(0.3, 0.6);
                   s = p2d.createTransformedShape(at);
                   g2d.setPaint(Color.GRAY);
                   g2d.draw(s);
                   p2d = new Path2D.Double();
                   p2d.moveTo(-0.2, 1.15);
                   p2d.quadTo(0.0, 1.1, 0.2, 1.15);
                   p2d.quadTo(0.15, 1.2, 0.2, 1.17);
                   p2d.quadTo(0.0, 1.25, -0.2, 1.17);
                   p2d.quadTo(-0.15, 1.2, -0.2, 1.15);
                   s = p2d.createTransformedShape(at);
                   g2d.setPaint(Color.GRAY);
                   g2d.fill(s);
                   //sign
                   p2d = new Path2D.Double();
                   p2d.moveTo(-0.2, 0.2);
                   p2d.lineTo(0.2, 0.2);
                   p2d.lineTo(0.2, 0.1);
                   p2d.lineTo(-0.2, 0.1);
                   p2d.closePath();
                   s = p2d.createTransformedShape(at);
                   g2d.setPaint(Color.WHITE);
                   g2d.fill(s);
                   g2d.setPaint(Color.LIGHT_GRAY);
                   g2d.draw(s);
                   checkerboard(g2d, at, 2, 40, 0.05, 2.15, -0.45, 1.1);
                   checkerboard(g2d, at, 2, 40, 0.05, 2.15, 0.5, 1.1);
                   //Right mirror
                   p2d = new Path2D.Double();
                   p2d.moveTo(-0.55, 0.55);
                   p2d.lineTo(-0.4, 0.55);
                   p2d.lineTo(-0.4, 0.5);
                   p2d.lineTo(-0.55, 0.5);
                   p2d.closePath();
                   s = p2d.createTransformedShape(at);
                   g2d.setPaint(Color.YELLOW);
                   g2d.fill(s);
                   //Left mirror
                   p2d = new Path2D.Double();
                   p2d.moveTo(0.55, 0.55);
                   p2d.lineTo(0.4, 0.55);
                   p2d.lineTo(0.4, 0.5);
                   p2d.lineTo(0.55, 0.5);
                   p2d.closePath();
                   s = p2d.createTransformedShape(at);
                   g2d.fill(s);
           }
           protected void paintSide(JPanel jp, Graphics2D g2d, AffineTransform at) {
                   Debug.println("MyCar:paintSide()");
                   //Frame of car
                   Path2D p2d = new Path2D.Double();
                   p2d.moveTo(0.0, 0.1);
                   p2d.lineTo(0.50, 0.1);
                   p2d.quadTo(0.55, 0.2, 0.675, 0.2);
                   p2d.quadTo(0.75, 0.2, 0.8, 0.1);
                   p2d.lineTo(0.9, 0.1);
                   p2d.quadTo(0.925, 0.2, 0.9, 0.25);
                   p2d.lineTo(0.88, 0.25);
                   p2d.quadTo(0.90, 0.4, 0.75, 0.4);
                   p2d.lineTo(0.3, 0.425);
                   p2d.lineTo(0.1, 0.6);
                   p2d.lineTo(-0.4, 0.6);
                   p2d.lineTo(-0.65, 0.415);
                   p2d.lineTo(-1.0, 0.4);
                   p2d.lineTo(-1.0, 0.225);
                   p2d.lineTo(-1.025, 0.225);
                   p2d.quadTo(-1.05, 0.15, -1.025, 0.1);
                   p2d.lineTo(-0.8, 0.1);
                   p2d.quadTo(-0.75, 0.2, -0.625, 0.2);
                   p2d.quadTo(-0.55, 0.2, -0.5, 0.1);
                   p2d.closePath();
                   Shape s = p2d.createTransformedShape(at);
                   g2d.setPaint(Color.YELLOW);
                   g2d.fill(s);
                   g2d.setPaint(Color.BLACK);
                   g2d.draw(s);
                   //rear window
                   p2d = new Path2D.Double();
                   p2d.moveTo(-0.535, 0.4);
                   p2d.lineTo(-0.36 ,0.55);
                   p2d.lineTo(-0.15, 0.55);
                   p2d.lineTo(-0.15, 0.4);
                   p2d.closePath();
                   s = p2d.createTransformedShape(at);
                   g2d.setPaint(Color.BLACK);
                   g2d.fill(s);
                   //front window
                   p2d = new Path2D.Double();
                   p2d.moveTo(0.23, 0.4);
                   p2d.lineTo(0.08, 0.55);
                   p2d.lineTo(-0.1, 0.55);
                   p2d.lineTo(-0.1, 0.4);
                   p2d.closePath();
                   s = p2d.createTransformedShape(at);
                   g2d.setPaint(Color.BLACK);
                   g2d.fill(s);
                   checkerboard(g2d, at, 60, 2, 1.85, 0.05, 0.855, 0.375);
                   //details
                   p2d = new Path2D.Double();
                   p2d.moveTo(-0.125, 0.6);
                   p2d.lineTo(-0.125, 0.1);
                   p2d.moveTo(-0.52, 0.15);
                   p2d.lineTo(0.52, 0.15);
                   p2d.moveTo(0.3, 0.425);
                   p2d.lineTo(0.3,0.1);
                   p2d.moveTo(-0.65, 0.4);
                   p2d.lineTo(-0.65, 0.25);
                   p2d.quadTo(-0.575, 0.25, -0.5, 0.15);
                   s = p2d.createTransformedShape(at);
                   g2d.setPaint(Color.GRAY);
                   g2d.draw(s);
                   TextLayout tx = new TextLayout(
                           "TAXI",
                           g2d.getFont().deriveFont(10.0f),
                           g2d.getFontRenderContext()
                   );
                   AffineTransform t = new AffineTransform();
                   t.translate(-0.05, 0.225);
                   t.scale( -1.0, 1.0 );
                   t.scale(0.01, 0.01);
                   t.rotate(-Math.PI);
                   t.translate(0.0, 0.0);
                   s = tx.getOutline(t);
                   s = at.createTransformedShape(s);
                   g2d.setPaint(Color.BLACK);
                   g2d.fill(s);
                   p2d = new Path2D.Double();
                   p2d.moveTo(0.0, 0.6);
                   p2d.lineTo(-0.02, 0.65);
                   p2d.lineTo(-0.07, 0.65);
                   p2d.lineTo(-0.09, 0.6);
                   p2d.closePath();
                   s = p2d.createTransformedShape(at);
                   g2d.setPaint(Color.WHITE);
                   g2d.fill(s);
                   g2d.setPaint(Color.BLACK);
                   g2d.draw(s);
                   p2d = new Path2D.Double();
                   p2d.moveTo(-1.0, 0.225);
                   p2d.lineTo(-0.95, 0.225);
                   p2d.quadTo(-0.94, 0.34, -1.0, 0.4);
                   p2d.closePath();
                   s = p2d.createTransformedShape(at);
                   g2d.setPaint(Color.RED);
                   g2d.fill(s);
                   g2d.setPaint(Color.BLACK);
                   g2d.draw(s);
                   p2d = new Path2D.Double();
                   p2d.moveTo(0.88, 0.25);
                   p2d.quadTo(0.91, 0.36, 0.75, 0.32);
                   p2d.lineTo(0.75, 0.25);
                   p2d.closePath();
                   s = p2d.createTransformedShape(at);
                   g2d.setPaint(Color.WHITE);
                   g2d.fill(s);
                   g2d.setPaint(Color.BLACK);
                   g2d.draw(s);

                   wheel(g2d, at, 0.12, 10, -0.77, 0.0);
                   wheel(g2d, at, 0.12, 10, 0.53, 0.0);
           }
           private void checkerboard(Graphics2D g2d, AffineTransform at, int rows, int columns, double height, double width, double topRightX, double topRightY){
                   Path2D p2d;
                   double xTScale = 0.0;
                   double yTScale = 0.0;
                   double xBScale = 0.0;
                   double yBScale = 0.0;
                   double cellWidth = width / columns;
                   double cellHeight = height / rows;
                   for (int x = 0; x < columns; x++){
                           for (int y = 0; y < rows; y++){
                                   xTScale = topRightX - (y * cellHeight);
                                   yTScale = topRightY - (x * cellWidth);
                                   xBScale = xTScale - cellHeight;
                                   yBScale = yTScale - cellWidth;
                                   p2d = new Path2D.Double();
                                   p2d.moveTo(xTScale, yTScale);
                                   p2d.lineTo(xTScale, yBScale);
                                   p2d.lineTo(xBScale, yBScale);
                                   p2d.lineTo(xBScale, yTScale);
                                   p2d.closePath();
                                   Shape s = p2d.createTransformedShape(at);
                                   if (x % 2 == y % 2){
                                           g2d.setPaint(Color.BLACK);
                                           g2d.fill(s);
                                   }
                           }
                   }
           }
           public void wheel(Graphics2D g2d, AffineTransform at, double radius, int num, double topLeftX, double topLeftY){
                   double sX = 0;
                   double sY = 0;
                   double diameter = 2.0 * radius;
                   double Cx = topLeftX - radius;
                   double Cy = topLeftY + radius;
                   Shape s = new Ellipse2D.Double(
                           topLeftX,
                           topLeftY,
                           diameter,
                           diameter
                   );
                   s = at.createTransformedShape(s);
                   g2d.setColor(Color.BLACK);
                   g2d.fill(s);
                   s = new Ellipse2D.Double(
                           topLeftX + (radius * 0.2),
                           topLeftY + (radius * 0.2),
                           diameter * 0.8,
                           diameter * 0.8
                   );
                   s = at.createTransformedShape(s);
                   g2d.setColor(Color.LIGHT_GRAY);
                   g2d.fill(s);
                   s = new Ellipse2D.Double(
                           topLeftX + (radius * 0.8),
                           topLeftY + (radius * 0.8),
                           diameter * 0.2,
                           diameter * 0.2
                   );
                   s = at.createTransformedShape(s);
                   g2d.setColor(Color.BLACK);
                   g2d.fill(s);
                   for (int x = 0; x < num; x++){
                           sX = (Cx + diameter -(radius * 0.1)) + ((radius * 0.6) * Math.cos(((2.0 * Math.PI) / num) * x));
                           sY = (Cy - (radius * 0.1)) + ((radius * 0.6) * Math.sin(((2.0 * Math.PI) / num) * x));
                           s = new Ellipse2D.Double(
                                   sX,
                                   sY,
                                   diameter / num,
                                   diameter / num
                           );
                           s = at.createTransformedShape(s);
                           g2d.setColor(Color.BLACK);
                           g2d.fill(s);
                   }
           }

           public void paintShifter(JPanel jp, Graphics2D g2d, int gear, int maxGear) {
                   Debug.println("MyCar:paintShifter()");
                   String value = String.valueOf(gear);
                   String maxValue = String.valueOf(maxGear);
                   int w = SwingUtilities.computeStringWidth(
                           g2d.getFontMetrics(),
                           value
                   );
                   g2d.setPaint(Color.BLACK);
                   g2d.drawString(
                           value,
                           jp.getWidth() / 2 - w / 2,
                           jp.getHeight() / 2 + 8
                   );
           }
    }
