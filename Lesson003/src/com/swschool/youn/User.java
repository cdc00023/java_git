package com.swschool.youn;

//사용자 환경설정

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.swcordingschool.book.DBUtil;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class User extends JFrame {

	private JPanel contentPane;
	private JTextField t_name;
	private JTextField t_email;
	private JTable t_user;
	private JPasswordField t_pw;
	
	private String b_id;
	private String b_pw;
	private String b_name;
	private String b_email;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
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
	public User() {
		setTitle("SIMPLE MEMO - User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		t_name = new JTextField();
		t_name.setBounds(89, 26, 224, 21);
		contentPane.add(t_name);
		t_name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel.setBounds(387, 10, 35, 15);
		contentPane.add(lblNewLabel);
		
		JButton tb_edit = new JButton("Edit");
		tb_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "UPDATE tblUser SET b_name=?, b_pw=?, b_email=? WHERE b_id = ? ";
				String b_name = t_name.getText();
				String b_pw = t_pw.getText();
				String b_email = t_email.getText();
				
				try {
					PreparedStatement pstmt = DB.dbconn.prepareStatement(sql);
					
					pstmt.setString(2, b_name);
					pstmt.setString(3, b_pw);
					pstmt.setString(4, b_email);
					
					pstmt.execute();
					LoadTbl();
					
				}catch(SQLException eupdate) {
					JOptionPane.showMessageDialog(null, "Update 오류가 발생하였습니다.");
					//einsert.printStackTrace();
				}
				
			}
		});
		tb_edit.setFont(new Font("굴림", Font.BOLD, 16));
		tb_edit.setBounds(325, 185, 97, 66);
		contentPane.add(tb_edit);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_1.setBounds(23, 28, 45, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("E-mail");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(23, 113, 54, 15);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("PW");
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(42, 72, 35, 15);
		contentPane.add(lblNewLabel_1_1_1);
		
		t_email = new JTextField();
		t_email.setColumns(10);
		t_email.setBounds(89, 111, 224, 21);
		contentPane.add(t_email);
		
		JButton tb_out = new JButton("out");
		tb_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();//현재 창을 닫고
				Home home = new Home();//새 창 객체 생성
				home.setVisible(true);//새 창 객체를 보이도록 
			}
		});	
		
		tb_out.setFont(new Font("굴림", Font.BOLD, 12));
		tb_out.setBounds(351, 152, 71, 23);
		contentPane.add(tb_out);
		
		t_pw = new JPasswordField();
		t_pw.setBounds(89, 70, 224, 21);
		contentPane.add(t_pw);
		
		scrollPane_DataTbl.setColumnHeaderView(t_user);	
		
		JScrollPane scrollPane_DataTbl = new JScrollPane();
		scrollPane_DataTbl.setBounds(12, 154, 296, 97);
		contentPane.add(scrollPane_DataTbl);
		
		t_user = new JTable();
		t_userinfo.addMouseListener(new MouseAdapter() {		
		@Override
		public void mouseClicked(MouseEvent e) {

			int row = t_uerinfo.getSelectedRow();
			userid4update = Integer.parseInt(t_userinfo.getModel().getValueAt(row, 0).toString());
			setTxtField(userid4update);			
		}
	});	
	}
}//end of class