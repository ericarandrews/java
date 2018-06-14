//CS111B

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickCountFrame extends JFrame 
{
	private int count;
	private JLabel label;

	public ClickCountFrame() 
	{
		super("Click Count Frame");
		this.setSize(250, 100);
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		// Initialize the instance variables
		count = 0;
		label = new JLabel();
		this.updateLabelText();

		// Create a button
		JButton increment = new JButton("Increment");
		JButton decrement = new JButton("Decrement");

		// Add the label and button to the frame
		this.getContentPane().add(increment);
		this.getContentPane().add(decrement);
		this.getContentPane().add(label);

		// Create the listener 
		increment.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							count++;
							updateLabelText();
						}});

		decrement.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							count--;
							updateLabelText();
						}});				
	}

	private void updateLabelText() 
	{
		String labelText = "Click Count: " + count;
		this.label.setText(labelText);
	}
}

