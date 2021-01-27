package com.swschool.youn;

//사용자 환경설정

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class User extends JFrame {

	private JPanel contentPane;
	private JTextField t_name;
	private JTextField t_email;
	private JTable t_user;
	private JPasswordField t_pw;
	
	
	DefaultTableModel model;
	
	private String b_id;
	private String b_pw;
	private String b_name;
	private String b_email;	
	private JTable tblUserinfo;
	private int userid4update;

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				LoadTbl();
			}
		});
		
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
				Home home = new Home("");//새 창 객체 생성
				home.setVisible(true);//새 창 객체를 보이도록 
			}
		});	
		
		tb_out.setFont(new Font("굴림", Font.BOLD, 12));
		tb_out.setBounds(351, 152, 71, 23);
		contentPane.add(tb_out);
		
		t_pw = new JPasswordField();
		t_pw.setBounds(89, 70, 224, 21);
		contentPane.add(t_pw);
		
		
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(12, 154, 296, 97);	
		contentPane.add(scroll);				
						
		tblUserinfo = new JTable();					
		tblUserinfo.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tblUserinfo.getSelectedRow();
				userid4update = Integer.parseInt(tblUserinfo.getModel().getValueAt(row, 0).toString());
			setTxtField(userid4update);			
		}

			
	});	
		tblUserinfo.setModel(new DefaultTableModel());
		scroll.setViewportView(tblUserinfo);
	}
	
	private void LoadTbl() {
		// 데이터베이스 연결이 안되어 있으면 연결
		if (DB.dbconn == null)
			DB.DBConnect();

		model = new DefaultTableModel();
		model.addColumn("name");
		model.addColumn("pw");
		model.addColumn("email");

		String sql = "SELECT * FROM t_user";

		try {
			PreparedStatement pstmt = DB.dbconn.prepareStatement(sql);			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] { 
						rs.getInt(2), // username
						rs.getString(3), // userpwd
						rs.getString(4), // useremail

				});
			} // end of while
		
			rs.close();
			pstmt.close();

			t_user.setModel(model);
			t_user.setAutoResizeMode(0);
			t_user.getColumnModel().getColumn(2).setPreferredWidth(50);
			t_user.getColumnModel().getColumn(3).setPreferredWidth(80);
			t_user.getColumnModel().getColumn(4).setPreferredWidth(80);
			
		
		} catch (SQLException srce) {
			JOptionPane.showMessageDialog(null, "테이블 로딩 중 오류가 발생하였습니다.");
			srce.printStackTrace();
		
		}
		
		
	}// end of LoadTbl
		
		private void setTxtField(int id) {
		
			String sql = "SELECT * FROM t_user WHERE b_id = ?";
			
			try {
				PreparedStatement pstmt = DB.dbconn.prepareStatement(sql);
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					t_name.setText(rs.getString(3)); // username
					t_pw.setText(rs.getString(2));   // userpwd
					t_email.setText(rs.getString(4)); 
					
				}// end of while
			}catch(SQLException eset) {
				JOptionPane.showMessageDialog(null, "해당 레코드 조회 중 오류가 발생하였습니다.");
				//eset.printStackTrace();
			}
			
			
	
	
	}//end of setTxtField	
}//end of class
