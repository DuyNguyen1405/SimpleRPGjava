package layout;

public class Controller {
	private Layout layout;
	private static void createAndShowGUI()  {
		 
        JFrame frame1 = new JFrame("JAVA");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        JButton button = new JButton(" Test");
        //Add action listener to button
        button.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button");
            }
        });      
 
        frame1.getContentPane().add(button);
        frame1.pack();
        frame1.setVisible(true);
    }
	
    public static void main(String[] args) {
    	createAndShowGUI();
    }
}
