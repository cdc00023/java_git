package com.swschool.youn;

//메인메뉴 화면

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
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField t_sharch;
	private JTable t_memo;
	private JTextField t_f;
	
	DefaultTableModel model;
	
	private String b_id;
	private String b_pw;
	private String b_memo;
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
					Home frame = new Home("");
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
	public Home(String usrname) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			b_name = usrname; 
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
		
		t_sharch = new JTextField();
		
		t_sharch.setBounds(12, 42, 305, 21);
		contentPane.add(t_sharch);
		t_sharch.setColumns(10);
		
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
		
		JButton tb_new = new JButton("저 장");
		tb_new.setFont(new Font("굴림", Font.BOLD, 12));
		tb_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				String sql = "INSERT INTO t_memo(b_name, b_memo) VALUES(?, ?)";
				String b_memo = t_f.getText();
				
				
				try {
					PreparedStatement pstmt = DB.dbconn.prepareStatement(sql);
					pstmt.setString(1, b_name);	
					pstmt.setString(2, b_memo);		
					
					pstmt.execute();
					LoadTbl();
					
				}catch(SQLException einsert) {
					JOptionPane.showMessageDialog(null, "Insertion 오류가 발생하였습니다.");
					einsert.printStackTrace();
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
				
				String sql = "UPDATE t_memo SET b_memo=? WHERE b_number = ? ";
				String b_memo = t_f.getText();
				
				try {
					PreparedStatement pstmt = DB.dbconn.prepareStatement(sql);
					pstmt.setString(3, b_memo);
					
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
		t_f.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			t_f.setText("");	
			}
		});
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
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(12, 73, 396, 181);
		contentPane.add(scroll);
		
		t_memo = new JTable();
		t_memo.addMouseListener(new MouseAdapter() {
			@Override						
			public void mouseClicked(MouseEvent e) {
				int row = t_memo.getSelectedRow();
				userid4update = Integer.parseInt(t_memo.getModel().getValueAt(row, 0).toString());	
				//setTxtField(userid4update);
			}
		});
		scroll.setViewportView(t_memo);
	}
	
	private void LoadTbl() {
		// 데이터베이스 연결이 안되어 있으면 연결
		if (DB.dbconn == null)
			DB.DBConnect();

		model = new DefaultTableModel();
		model.addColumn("number");
		model.addColumn("name");
		model.addColumn("memo");

		String sql = "SELECT * FROM t_memo";

		try {
			PreparedStatement pstmt = DB.dbconn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] { 
						rs.getInt(1), // number
						rs.getString(2), // name
						rs.getString(3), // memo

				});
			} // end of while
			
			rs.close();
			pstmt.close();

			t_memo.setModel(model);
			t_memo.setAutoResizeMode(0);
			t_memo.getColumnModel().getColumn(0).setPreferredWidth(80);
			t_memo.getColumnModel().getColumn(1).setPreferredWidth(80);
			t_memo.getColumnModel().getColumn(2).setPreferredWidth(235);

			// JOptionPane.showMessageDialog(null, "테이블을 로딩하였습니다.");

		} catch (SQLException srce) {
			JOptionPane.showMessageDialog(null, "테이블 로딩 중 오류가 발생하였습니다.");
			srce.printStackTrace();
		}
	}// end of LoadTbl
	
	
}
