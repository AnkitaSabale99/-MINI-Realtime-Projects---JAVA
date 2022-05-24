import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.Color;
class ChangeColour extends Applet implements ActionListener
{
Frame f;
/* public void init()
{
f.setbackground(Color.pink);
}
*/

Button b1,b2,b3,b4,b5,b6;
ChangeColour()
{
f=new Frame("Colour");

b1=new Button("red");
b2=new Button("yellow");
b3=new Button("green");

b4=new Button("blue");
b5=new Button("orange");
b6=new Button("cyan");

f.setVisible(true);
f.setSize(400,400);
f.setLayout(new FlowLayout());
f.setBackground(Color.black);

f.add(b1);
f.add(b2);
f.add(b3);
f.add(b4);
f.add(b5);
f.add(b6);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource().equals(b1))
{
f.setBackground(Color.red);
}
if(e.getSource().equals(b2))
{
f.setBackground(Color.yellow);
}
if(e.getSource().equals(b3))
{
f.setBackground(Color.green);
}
if(e.getSource().equals(b4))
{
f.setBackground(Color.blue);
}
if(e.getSource().equals(b5))
{
f.setBackground(Color.orange);
}
if(e.getSource().equals(b6))
{
f.setBackground(Color.cyan);
}
}
public static void main(String...aa)
{
new ChangeColour();
}
}