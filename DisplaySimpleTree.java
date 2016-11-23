// Code for popping up a window that displays a custom component
// in this case we are displaying a Binary Search tree  
// reference problem 4.38 of Weiss to compute tree node x,y positions

// input is a text file name that will form the Binary Search Tree

//     java DisplaySimpleTree textfile


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class DisplaySimpleTree extends JFrame {
  JScrollPane scrollpane;
  DisplayPanel panel;
  

  public DisplaySimpleTree(Tree t) {
    panel = new DisplayPanel(t);
    panel.setPreferredSize(new Dimension(500, 450));
    scrollpane = new JScrollPane(panel);
    getContentPane().add(scrollpane, BorderLayout.CENTER);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();  // cleans up the window panel
  }
  }


  class DisplayPanel extends JPanel {
     Tree t;
     int xs;
     int ys;

    public DisplayPanel(Tree t) {
      this.t = t; // allows dispay routines to access the tree
      setBackground(Color.white);
      setForeground(Color.black);
    }

    protected void paintComponent(Graphics g) {
      g.setColor(getBackground()); //colors the window
      g.fillRect(0, 0, getWidth(), getHeight());
      g.setColor(getForeground()); //set color and fonts
      Font MyFont = new Font("SansSerif",Font.PLAIN,10);
      g.setFont(MyFont);
      xs=30;   //where to start printing on the panel
      ys=20;
      g.drawString("Binary Search tree for the input string: \n",xs,ys);
      ys=ys+10;;
      int start=0;
      //  print input string on panel, 150 chars per line
      // if string longer than 23 lines don't print
      if(t.inputString.length()<23*150){
           while((t.inputString.length()-start)>150){
              g.drawString(t.inputString.substring(start,start+150),xs,ys);        
              start+=151;
              ys+=15;
           }
           g.drawString(t.inputString.substring(start,t.inputString.length()),xs,ys);
      }
      MyFont = new Font("SansSerif",Font.BOLD,30); //bigger font for tree
      g.setFont(MyFont);
      this.drawTree(g, t.root); // draw the tree
      revalidate(); //update the component panel
    }

      public void drawTree(Graphics g, Node root) {//actually draws the tree
      int dx, dy, dx2, dy2;
      int SCREEN_WIDTH=400; //screen size for panel
      int SCREEN_HEIGHT=350;
      int XSCALE, YSCALE;  
      XSCALE=(SCREEN_WIDTH/t.totalnodes); //scale x by total nodes in tree
      YSCALE=(SCREEN_HEIGHT-ys)/(t.maxheight+1); //scale y by tree height

      if (root != null) { // inorder traversal to draw each node
        drawTree(g, root.T_Son); // do left side of inorder traversal 
        dx = root.xpos * XSCALE; // get x,y coords., and scale them 
        dy = root.ypos * YSCALE +ys;
        String s = (String) root.a_value; //get the word at this node
        g.drawString(s, dx, dy); // draws the word
// this draws the lines from a node to its children, if any
        if(root.T_Son!=null){ //draws the line to left child if it exists
          dx2 = root.T_Son.xpos * XSCALE; 
          dy2 = root.T_Son.ypos * YSCALE +ys;
          g.drawLine(dx,dy,dx2,dy2);
        }
        if(root.T_Brother!=null){ //draws the line to right child if it exists
          dx2 = root.T_Brother.xpos * XSCALE;//get right child x,y scaled position
          dy2 = root.T_Brother.ypos * YSCALE + ys;
          g.drawLine(dx,dy,dx2,dy2);
        }
        drawTree(g, root.T_Brother); //now do right side of inorder traversal 
      }
    }
}