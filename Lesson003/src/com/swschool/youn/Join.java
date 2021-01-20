package com.swschool.youn;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Join extends JFrame {

	private JPanel contentPane;
	private JTextField t_id;
	private JTextField t_name;
	private JTextField t_email;
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
					Join frame = new Join();
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
	public Join() {
		setTitle("SIMEPLE MEMO - Join");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Join");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel.setBounds(341, 10, 25, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PW");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_1.setBounds(12, 75, 25, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(12, 38, 25, 15);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("NAME");
		lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(12, 114, 36, 15);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("E-MEIL");
		lblNewLabel_1_3.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(12, 150, 50, 15);
		contentPane.add(lblNewLabel_1_3);
		
		t_id = new JTextField();
		t_id.setBounds(72, 35, 155, 21);
		contentPane.add(t_id);
		t_id.setColumns(10);
		
		t_name = new JTextField();
		t_name.setColumns(10);
		t_name.setBounds(72, 111, 155, 21);
		contentPane.add(t_name);
		
		t_email = new JTextField();
		t_email.setColumns(10);
		t_email.setBounds(72, 147, 155, 21);
		contentPane.add(t_email);
		
		JButton tb_join = new JButton("JOIN");
		tb_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if (DB.dbconn == null) DB.DBConnect();
			b_id = t_id.getText();
			b_pw = t_pw.getText();
			b_name = t_name.getText();
			b_email = t_email.getText();
			
			String pw = new String(t_pw.getPassword());
			
			String sql = "INSERT INTO t_user(b_id, b_pw, b_name, b_email) VALUES(?,?,?,?)";
				
			try {				
				PreparedStatement pstmt = DB.dbconn.prepareStatement(sql);
				pstmt.setString(1, b_id); 
				pstmt.setString(2, b_pw);
				pstmt.setString(3, b_name);
				pstmt.setString(4, b_email);

				// update()문을 실행하면 영향 받은 레크드의 갯수를 반환한다.
				int rs = pstmt.executeUpdate();
				if (rs == 1) {
					JOptionPane.showMessageDialog(null, "정상적으로 저장하였습니다.");
					// 현재 창을 닫고 로그인 창으로 이동
					dispose();
					Login login = new Login();
					login.setVisible(true);
				}

			} catch (SQLException esave) {
				System.out.println("[MyMSG]SQL Exception Error : " + esave.getMessage());
				esave.printStackTrace();
			}
		}
	
});
		tb_join.setFont(new Font("굴림", Font.BOLD, 16));
		tb_join.setBounds(239, 110, 127, 57);
		contentPane.add(tb_join);
		
		t_pw = new JPasswordField();
		t_pw.setBounds(72, 72, 155, 21);
		contentPane.add(t_pw);
		
		JButton tb_reset = new JButton("Reset");
		tb_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t_id.setText("");
				t_pw.setText("");
				t_name.setText("");
				t_email.setText("");
				
			}
		});
		tb_reset.setFont(new Font("굴림", Font.BOLD, 16));
		tb_reset.setBounds(239, 69, 127, 34);
		contentPane.add(tb_reset);
		
		JButton btnNewButton = new JButton("Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();//현재 창을 닫고
				Login login = new Login();//새 창 객체 생성
				login.setVisible(true);//새 창 객체를 보이도록 
			}
		});	
		
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 12));
		btnNewButton.setBounds(307, 35, 59, 23);
		contentPane.add(btnNewButton);
	}
}
