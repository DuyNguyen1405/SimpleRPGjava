package layout;

	import java.awt.*;
	import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import character.*;
	public class Layout extends JFrame {
		
		private JButton b1 = new JButton("one");
		private JButton b2 = new JButton("two");
		private JButton up = new JButton("^");
		private JButton down = new JButton("v");
		private JButton left = new JButton("<");
		private JButton right = new JButton(">");
		private JPanel bigGrid = new JPanel();
		private Container controls = new Container();
	     

	    public JButton getB1() {
			return b1;
		}


		public void setB1(JButton b1) {
			this.b1 = b1;
		}


		public JButton getB2() {
			return b2;
		}


		public void setB2(JButton b2) {
			this.b2 = b2;
		}


		public JButton getUp() {
			return up;
		}


		public void setUp(JButton up) {
			this.up = up;
		}


		public JButton getDown() {
			return down;
		}


		public void setDown(JButton down) {
			this.down = down;
		}


		public JButton getLeft() {
			return left;
		}


		public void setLeft(JButton left) {
			this.left = left;
		}


		public JButton getRight() {
			return right;
		}


		public void setRight(JButton right) {
			this.right = right;
		}


		public Container getControls() {
			return controls;
		}


		public void setControls(Container controls) {
			this.controls = controls;
		}


		public void addComponentsToPane(final Container pane) throws IOException {
	        
	        
	        bigGrid.setLayout(new GridLayout(5,5));
	        
	        //controls.setLayout(null);
	         
	        //Set up components preferred size
	        
	        JButton b = new JButton("Just fake button");
	        Dimension buttonSize = b.getPreferredSize();
	        bigGrid.setPreferredSize(new Dimension((int)(buttonSize.getWidth()),(int)(buttonSize.getHeight())+200));
	        controls.setPreferredSize(new Dimension((int)(buttonSize.getWidth())+200,(int)(buttonSize.getHeight())+150)); 
	        //Add buttons to experiment with Grid Layout
	        
	        controls.add(b1);
	        controls.add(b2);
	        controls.add(up);
	        controls.add(down);
	        controls.add(left);
	        controls.add(right);
	        
	        Insets insets = pane.getInsets();
	        Dimension size = b1.getPreferredSize();
	        b1.setBounds(185 + insets.left, 80 + insets.bottom,  size.width, size.height);
	        size = b2.getPreferredSize();
	        b2.setBounds(245 + insets.left, 80 + insets.bottom, size.width, size.height);
	        size = up.getPreferredSize();
	        up.setBounds(60 + insets.left, 40 + insets.bottom, size.width, size.height);
	        size = down.getPreferredSize();
	        down.setBounds(60 + insets.left, 100 + insets.bottom, size.width, size.height);
	        size = left.getPreferredSize();
	        left.setBounds(10 + insets.left, 70 + insets.bottom, size.width, size.height);
	        size = right.getPreferredSize();
	        right.setBounds(110 + insets.left, 70 + insets.bottom, size.width, size.height);
	        
//	        bigGrid.add(new JButton("Button 1"));
//	        bigGrid.add(new JButton("Button 2"));
//	        bigGrid.add(new JButton("Button 3"));
//	        bigGrid.add(new JButton("Long-Named Button 4"));
//	        bigGrid.add(new JLabel("5"));
	        
	         
	        pane.add(bigGrid, BorderLayout.NORTH);
	        pane.add(controls);
	        
	        Map map= new Map();
	        //map.addToGrid(2,3);
	        //map.setCharacterPosition(0, 0);
	        map.createMap();
	        //System.out.printl(map.words[1][4]);
	        Controller control = new Controller();
	        control.press(up);
	        
	    }
	     

	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method is invoked from the
	     * event dispatch thread.
	     * @throws IOException 
	     */
	    private static void createAndShowGUI() throws IOException {
	        //Create and set up the window.
	    	Layout frame = new Layout();
	    	frame.setTitle("Test1");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //Set up the content pane.
	        frame.addComponentsToPane(frame.getContentPane());
	        //Display the window.
	        Insets insets = frame.getInsets();
	        frame.setSize(300 + insets.left + insets.right, 425 + insets.top + insets.bottom);
	        frame.pack();
	        frame.setVisible(true);
	    }
	     
	    public static void main(String[] args) {

	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                try {
						createAndShowGUI();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        });
	    }
	}

