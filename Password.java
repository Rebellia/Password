import java.awt.*; //to use images
import javax.swing.*; //to use JComponents
import java.awt.event.*; //to have event listeners

public class Password
{
	
	public static void main(String[] args)
	{	
		final String password = "hello";
		JFrame pFrame = new JFrame("Password Access");
		
		
		
		//Set up the panel for the password
		JPanel pPanel = new JPanel();
		JLabel request = new JLabel("Enter Password");
		JLabel error = new JLabel("");
		JTextField inputField = new JTextField();
		JButton submit = new JButton("Click");
		
		pPanel.setLayout(new GridLayout(4, 1));
		pPanel.add(request);
		pPanel.add(error);
		pPanel.add(inputField);
		pPanel.add(submit);
		
		
		
		
		//Set up panel for successful login
		JPanel successPanel = new JPanel();
		JLabel successLabel = new JLabel("Congratulations! You've entered the correct password!");
		JButton backwards = new JButton("Back to the start");
		successPanel.add(successLabel);
		successPanel.add(backwards);
		
		//create the panel that will hold all the other panels
		JPanel panels = new JPanel(new CardLayout());
		panels.add(pPanel, "pPanel");
		panels.add(successPanel, "sPanel");
		
		
		//Create ButtonListener class for click
		class PasswordListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				CardLayout layout = (CardLayout)(panels.getLayout());
				JButton command = (JButton)event.getSource();
				if (command == submit)
				{
					String input = inputField.getText();
					if (input.equals(password))
					{
						layout.show(panels, "sPanel");
						inputField.setText("");
						error.setText("");
					}
					else
					{
						error.setForeground(Color.red);
						error.setText("WRONG");
						inputField.setText("");
					}
				}
			}
			
		}//end of PasswordListener class
		
		class ButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				CardLayout layout = (CardLayout)(panels.getLayout());
				JButton command = (JButton)event.getSource();
				if (command == backwards)
				{
					layout.show(panels, "pPanel");
				}
			}
		}//end of ButtonListener class
		
		//Add ActionListener AFTER creating the class (you'll get an error if you do it beforehand)
		submit.addActionListener(new PasswordListener());
		backwards.addActionListener(new ButtonListener());
		
		pFrame.add(panels);
		
		
		//pFrame.setSize(800, 600);
		pFrame.pack(); //The size of the frame is based on need
		pFrame.setResizable(false);
		pFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pFrame.setVisible(true); //lets the window actually be seen
	} //end of method
	
	
}//end of class