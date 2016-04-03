package layout;

	import java.awt.*;
	import java.io.IOException;

import javax.swing.*;
import character.*;
	public class Layout extends JFrame {
		
		/**
		 * 
		 */
		private static JButton b1;
		private static JButton b2;
		private static JButton up;
		private static JButton down;
		private static JButton left;
		private static JButton right;

		private Container controls;
		private static JTable table;
		private static Object oldPos;
		private static int x;
		private static int y;

		public Layout(){
			this.b1 = new JButton("A");
			this.b2 = new JButton("B");
			this.up = new JButton("^");
			this.down = new JButton("v");
			this.left = new JButton("<");
			this.right = new JButton(">");

			this.controls = new Container();
			this.table = new JTable();
			this.oldPos = new Object();

			this.x = 4;
			this.y = 0;
		}


	    public Object getOldPos() {
			return oldPos;
		}


		public static JTable getTable() {
			return table;
		}


		public static void setTable(JTable table) {
			Layout.table = table;
		}


		public void setOldPos(Object oldPos) {
			this.oldPos = oldPos;
		}


		public JButton getB1() {
			return b1;
		}


		public void setB1(JButton b1) {
			this.b1 = b1;
		}


		public JButton getB2() {
			return b2;
		}


		public int getX() {
			return x;
		}


		public void setX(int x) {
			this.x = x;
		}


		public int getY() {
			return y;
		}


		public void setY(int y) {
			this.y = y;
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


		public void addComponentsToPane(final Container pane, Layout layout) throws IOException, InterruptedException {
	  
	        JButton b = new JButton("zxczxczxczxc");
	        Dimension buttonSize = b.getPreferredSize();
	        //bigGrid.setPreferredSize(new Dimension((int)(buttonSize.getWidth()),(int)(buttonSize.getHeight())+200));
	        controls.setPreferredSize(new Dimension((int)(buttonSize.getWidth())+250,(int)(buttonSize.getHeight())+250)); 
	        //Add buttons to experiment with Grid Layout
	        //controls.setSize(width, height);e
	        controls.add(b1);
	        controls.add(b2);
	        controls.add(up);
	        controls.add(down);
	        controls.add(left);
	        controls.add(right);
	        	        
	        Insets insets = pane.getInsets();
	        Dimension size = b1.getPreferredSize();
	        b1.setBounds(185 + insets.left, 180 + insets.bottom,  size.width, size.height);
	        size = b2.getPreferredSize();
	        b2.setBounds(245 + insets.left, 180 + insets.bottom, size.width, size.height);
	        size = up.getPreferredSize();
	        up.setBounds(60 + insets.left, 140 + insets.bottom, size.width, size.height);
	        size = down.getPreferredSize();
	        down.setBounds(60 + insets.left, 200 + insets.bottom, size.width, size.height);
	        size = left.getPreferredSize();
	        left.setBounds(10 + insets.left, 170 + insets.bottom, size.width, size.height);
	        size = right.getPreferredSize();
	        right.setBounds(110 + insets.left, 170 + insets.bottom, size.width, size.height);

	        Map map= new Map();

	        map.createMap("M1.txt");
	        String[][] test = map.getWords();
	        String[] column = {"0","1","2","3","4"};
	        table = new JTable(test,column);
	        
	        pane.add(table);
	        table.setSize(100, 80);
	        size = table.getPreferredSize();
	        table.setBounds(0 + insets.left, 0 + insets.bottom, size.width, size.height);
	        pane.add(controls);


	        player player = new player();
	        Controller control = new Controller();
	        
	        player.makeChar(x,y,table);
	        layout.setOldPos(player.getOldValue());
    	    control.press(layout);
	        }
	        	
	    
	     

	    private static void createAndShowGUI() throws IOException, InterruptedException {
	        //Create and set up the window.
	    	Layout frame = new Layout();
	    	frame.setTitle("Test");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //Set up the content pane.
	        frame.addComponentsToPane(frame.getContentPane(),frame);
	        frame.setSize(1500,700);
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
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        });
	    }
	}

