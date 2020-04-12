import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GUI{
	
	private static JPanel panel;
	private static JFrame frame;
	
	public GUI() {
		
		frame = new JFrame("NecessitiesNeededNow");
		frame.setSize(1100, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel header = new JPanel();
		header.setBackground(Color.WHITE);
		header.setLayout(new BorderLayout());
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		SpringLayout layout = new SpringLayout();
		panel.setLayout(layout);
		panel.setBorder(new EmptyBorder(50, 0, 0, 0));

		
		// Welcome Label
		JLabel welcome = new JLabel("NecessitiesNeededNow", SwingConstants.CENTER);
		welcome.setBorder(new EmptyBorder(30,0, 40,0));
		welcome.setFont(new Font("Arial", Font.BOLD, 50));
		header.add(welcome);
		
		
		// First Name Label
		JLabel firstNameLabel = new JLabel("First name");
		firstNameLabel.setForeground(new Color(143, 143, 143));
		layout.putConstraint(SpringLayout.WEST, firstNameLabel, 220, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, firstNameLabel, 5, SpringLayout.NORTH, panel);
		panel.add(firstNameLabel);
		
		// First Name Field
		JTextField firstNameText = new JTextField(15);
		layout.putConstraint(SpringLayout.WEST, firstNameText, 210, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, firstNameText, 20, SpringLayout.NORTH, firstNameLabel);
		firstNameText.setBorder(BorderFactory.createCompoundBorder(firstNameText.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		panel.add(firstNameText);
		
		// Last Name Label
		JLabel lastNameLabel = new JLabel("Last name");
		lastNameLabel.setForeground(new Color(143, 143, 143));
		layout.putConstraint(SpringLayout.WEST, lastNameLabel, 250, SpringLayout.WEST, firstNameLabel);
		layout.putConstraint(SpringLayout.NORTH, lastNameLabel, 5, SpringLayout.NORTH, panel);
		panel.add(lastNameLabel);
		
		// Last Name Field
		JTextField lastNameText = new JTextField(15);
		layout.putConstraint(SpringLayout.WEST, lastNameText, 250, SpringLayout.WEST, firstNameText);
		layout.putConstraint(SpringLayout.NORTH, lastNameText, 20, SpringLayout.NORTH, lastNameLabel);
		lastNameText.setBorder(BorderFactory.createCompoundBorder(lastNameText.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		panel.add(lastNameText);
		
		// Email Label
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setForeground(new Color(143, 143, 143));
		layout.putConstraint(SpringLayout.WEST, emailLabel, 250, SpringLayout.WEST, lastNameLabel);
		layout.putConstraint(SpringLayout.NORTH, emailLabel, 5, SpringLayout.NORTH, panel);
		panel.add(emailLabel);
		
		// Email Field
		JTextField emailText = new JTextField(15);
		layout.putConstraint(SpringLayout.WEST, emailText, 250, SpringLayout.WEST, lastNameText);
		layout.putConstraint(SpringLayout.NORTH, emailText, 20, SpringLayout.NORTH, emailLabel);
		emailText.setBorder(BorderFactory.createCompoundBorder(emailText.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		panel.add(emailText);
		
		//panel.add(new JSeparator(SwingConstants.HORIZONTAL));

		// Address Label
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setForeground(new Color(143, 143, 143));
		layout.putConstraint(SpringLayout.WEST, addressLabel, 220, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, addressLabel, 100, SpringLayout.NORTH, emailText);
		panel.add(addressLabel);
		
		// Address Field
		JTextField addressText = new JTextField(35);
		layout.putConstraint(SpringLayout.WEST, addressText, 210, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, addressText, 20, SpringLayout.NORTH, addressLabel);
		addressText.setBorder(BorderFactory.createCompoundBorder(addressText.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		panel.add(addressText);
		
		// Apartment/Suite Label
		JLabel apartmentLabel = new JLabel("Apt/Suite");
		apartmentLabel.setForeground(new Color(143, 143, 143));
		layout.putConstraint(SpringLayout.WEST, apartmentLabel, 505, SpringLayout.WEST, addressText);
		layout.putConstraint(SpringLayout.NORTH, apartmentLabel, 100, SpringLayout.NORTH, emailText);
		panel.add(apartmentLabel);
		
		// Apartment/Suite Field
		JTextField apartmentText = new JTextField(15);
		layout.putConstraint(SpringLayout.WEST, apartmentText, 500, SpringLayout.WEST, addressText);
		layout.putConstraint(SpringLayout.NORTH, apartmentText, 20, SpringLayout.NORTH, apartmentLabel);
		apartmentText.setBorder(BorderFactory.createCompoundBorder(apartmentText.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		panel.add(apartmentText);

		// City Label
		JLabel cityLabel = new JLabel("City");
		cityLabel.setForeground(new Color(143, 143, 143));
		layout.putConstraint(SpringLayout.WEST, cityLabel, 220, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, cityLabel, 60, SpringLayout.NORTH, addressText);
		panel.add(cityLabel);

		// City Field
		JTextField cityText = new JTextField(15);
		layout.putConstraint(SpringLayout.WEST, cityText, 210, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, cityText, 20, SpringLayout.NORTH, cityLabel);
		cityText.setBorder(BorderFactory.createCompoundBorder(cityText.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		panel.add(cityText);
		
		// State Label
		JLabel stateLabel = new JLabel("State");
		stateLabel.setForeground(new Color(143, 143, 143));
		layout.putConstraint(SpringLayout.WEST, stateLabel, 250, SpringLayout.WEST, cityLabel);
		layout.putConstraint(SpringLayout.NORTH, stateLabel, 60, SpringLayout.NORTH, addressText);
		panel.add(stateLabel);
		
		// State Field
		JTextField stateText = new JTextField(15);
		layout.putConstraint(SpringLayout.WEST, stateText, 250, SpringLayout.WEST, cityText);
		layout.putConstraint(SpringLayout.NORTH, stateText, 20, SpringLayout.NORTH, stateLabel);
		stateText.setBorder(BorderFactory.createCompoundBorder(stateText.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		panel.add(stateText);
		
		// Zip Code Label
		JLabel zipCodeLabel = new JLabel("Zip Code");
		zipCodeLabel.setForeground(new Color(143, 143, 143));
		layout.putConstraint(SpringLayout.WEST, zipCodeLabel, 250, SpringLayout.WEST, stateLabel);
		layout.putConstraint(SpringLayout.NORTH, zipCodeLabel, 60, SpringLayout.NORTH, apartmentText);
		panel.add(zipCodeLabel);
		
		// Zip Code Field
		JTextField zipCodeText = new JTextField(15);
		layout.putConstraint(SpringLayout.WEST, zipCodeText, 250, SpringLayout.WEST, stateText);
		layout.putConstraint(SpringLayout.NORTH, zipCodeText, 20, SpringLayout.NORTH, stateLabel);
		zipCodeText.setBorder(BorderFactory.createCompoundBorder(zipCodeText.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		panel.add(zipCodeText);
		
		
		// Submit
		JButton submitButton = new JButton("Submit");
		layout.putConstraint(SpringLayout.WEST, submitButton, 275, SpringLayout.WEST, stateText);
		layout.putConstraint(SpringLayout.NORTH, submitButton, 100, SpringLayout.NORTH, zipCodeText);
		submitButton.setForeground(Color.WHITE);
		submitButton.setBackground(new Color(0, 194, 77));
		submitButton.setOpaque(true);
		submitButton.setBorderPainted(false);
		submitButton.setPreferredSize(new Dimension(170, 30));



//		button.addActionListener(new GUI());
		panel.add(submitButton);
		
		
		frame.add(header, BorderLayout.PAGE_START);
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true); // Make sure to setVisible AFTER adding everything otherwise get error
		
	}

}
