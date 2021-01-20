package com.swschool.youn;

//메인메뉴 화면

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
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField t_name;
	private JTable t_memo;
	private JTextField t_f;
	
	private String b_id;
	private String b_pw;
	private String b_name;
	private String b_email;	
	private int userid4update;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {

			LoadTbl();
			}
		});
				
		setTitle("SIMPLE MEMO - Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 388);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		t_name = new JTextField();
		t_name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(t_name + "님의 방문을 환영합니다.");		
			}
		});
		t_name.setBounds(12, 42, 305, 21);
		contentPane.add(t_name);
		t_name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel.setBounds(458, 9, 52, 21);
		contentPane.add(lblNewLabel);
		
		JButton tb_userEdit = new JButton("사용자 설정");
		tb_userEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();//현재 창을 닫고
				User user = new User();//새 창 객체 생성
				user.setVisible(true);//새 창 객체를 보이도록 
			}
		});	
		
		tb_userEdit.setFont(new Font("굴림", Font.BOLD, 12));
		tb_userEdit.setBounds(12, 9, 109, 23);
		contentPane.add(tb_userEdit);
		
		t_memo = new JTable();
		t_memo.setBounds(12, 73, 396, 181);
		contentPane.add(t_memo);
		
		JButton tb_new = new JButton("저 장");
		tb_new.setFont(new Font("굴림", Font.BOLD, 12));
		tb_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				b_name = t_name.getText();
				b_memo = t_memo.getText();
				
				if (DB.dbconn == null) DB.DBConnect();
				
				String sql = "INSERT INTO t_memo(b_name, b_memo) VALUES(?,?)";
				
				try {
					PreparedStatement pstmt = DB.dbconn.prepareStatement(sql);
					pstmt.setString(1, b_name);	
					pstmt.setString(2, b_memo);		
					
					pstmt.execute();
					LoadTbl();
					
				}catch(SQLException einsert) {
					JOptionPane.showMessageDialog(null, "Insertion 오류가 발생하였습니다.");
					//einsert.printStackTrace();
				}// end of try catch

			}
		});
		tb_new.setBounds(420, 300, 90, 39);
		contentPane.add(tb_new);
		
		JButton tb_de = new JButton("삭제");
		tb_de.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String sql = "DELETE FROM t_user WHERE d_number = ?";
				
				try {
					PreparedStatement pstmt = DB.dbconn.prepareStatement(sql);
					pstmt.setInt(1, userid4update);
					pstmt.execute();
					LoadTbl();
					
				}catch(SQLException eupdate) {
					JOptionPane.showMessageDialog(null, "Delete 오류가 발생하였습니다.");
					//einsert.printStackTrace();
				}// end of try catch
				

			}
		});	
				
				
		tb_de.setFont(new Font("굴림", Font.BOLD, 12));
		tb_de.setBounds(420, 73, 90, 23);
		contentPane.add(tb_de);
		
		JButton tb_up = new JButton("업데이트");
		tb_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "UPDATE t_user SET memo=? WHERE userid = ? ";
				
				try {
					PreparedStatement pstmt = DB.dbconn.prepareStatement(sql);
					System.out.println("Update");
					pstmt.setString(1, memo);
					
					pstmt.execute();
					LoadTbl();
					
				}catch(SQLException eupdate) {
					JOptionPane.showMessageDialog(null, "Update 오류가 발생하였습니다.");
					//einsert.printStackTrace();
				}// end of try catch

			}
		});
		tb_up.setFont(new Font("굴림", Font.BOLD, 12));
		tb_up.setBounds(420, 106, 90, 23);
		contentPane.add(tb_up);
		
		JButton tb_out = new JButton("Out");
		tb_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();//현재 창을 닫고
				Login login = new Login();//새 창 객체 생성
				login.setVisible(true);//새 창 객체를 보이도록 
			}
		});	
		tb_out.setFont(new Font("굴림", Font.BOLD, 12));
		tb_out.setBounds(451, 41, 60, 23);
		contentPane.add(tb_out);
		
		t_f = new JTextField();
		t_f.setFont(new Font("굴림", Font.BOLD, 12));
		t_f.setHorizontalAlignment(SwingConstants.CENTER);
		t_f.setText("글을 입력하세요");
		t_f.setBounds(12, 264, 396, 75);
		contentPane.add(t_f);
		t_f.setColumns(10);
		
		JButton tb_s = new JButton("검 색");
		tb_s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		tb_s.setFont(new Font("굴림", Font.BOLD, 12));
		tb_s.setBounds(329, 41, 79, 23);
		contentPane.add(tb_s);
		
		JButton tb_de_1 = new JButton("지우기");
		tb_de_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				t_f.setText("");

			}
		});
		tb_de_1.setFont(new Font("굴림", Font.BOLD, 12));
		tb_de_1.setBounds(420, 267, 90, 23);
		contentPane.add(tb_de_1);
	}
}
