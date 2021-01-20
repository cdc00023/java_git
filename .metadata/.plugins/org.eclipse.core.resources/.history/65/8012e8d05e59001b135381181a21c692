package com.swcodingschool.guibasic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class CFirst extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CFirst frame = new CFirst();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CFirst() {
		setTitle("First Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("처음 만드는 프레임");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("a고속도로", Font.BOLD, 20));
		lblNewLabel.setBounds(169, 24, 385, 81);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(194, 147, 215, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(84, 212, 131, 43);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(294, 212, 206, 43);
		contentPane.add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(78, 276, 115, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(294, 276, 121, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setBounds(80, 320, 135, 23);
		contentPane.add(tglbtnNewToggleButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(294, 305, 171, 90);
		contentPane.add(textArea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(431, 155, 123, 21);
		contentPane.add(passwordField);
	}
}
