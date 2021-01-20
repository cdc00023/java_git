package com.swcodingschool.guibasic;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtUserPWD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// 데이터베이스연결
					if (DBUtil.dbconn == null) DBUtil.DBConnect();

					Login frame = new Login();
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
	public Login() {
		setTitle("Login Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Simple Login Demo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(87, 21, 259, 40);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setBounds(97, 97, 73, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(97, 129, 57, 15);
		contentPane.add(lblNewLabel_2);

		txtUserName = new JTextField();
		txtUserName.setBounds(182, 94, 164, 23);
		contentPane.add(txtUserName);
		txtUserName.setColumns(20);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 데이터베이스연결
				if (DBUtil.dbconn == null)
					DBUtil.DBConnect();
				// 입력된 유저아이디와 비밀번호를 가져온다.
				String username = txtUserName.getText();
				String userpwd = new String(txtUserPWD.getPassword());
				// 입력된 아이디와 비번확인
//				System.out.println(userid);
//				System.out.println(userpwd);
				
				// 유저아이디와 비밀번호를 사용하여 데이터베이스 조회
				// SELECT 속성리스트[* all 모든 속성] 
				// FROM 테이블이름
				// WHERE 조건
				
				// sql 구문 구성
				String sql = "SELECT * FROM tbluser WHERE username=? AND userpwd=?";
				
				try {
					// prepared statement는 sql 구문을 좀더 단순하게 구성할 수 있도록 한다.
					PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
					pstmt.setString(1, username); // userid 변수값으로 sql구문의 첫번째 ? 에 대입
					pstmt.setString(2, userpwd);// userpwd 변수값으로 sql구문의 두번째 ? 에 대입
					
					// 최종 완성된 질의구문을 실행하고 그 결과를 ResultSet으로 받아온다.
					ResultSet rs = pstmt.executeQuery();
					
					// resultset rs내에는 검색된 결과값들이 들어있는데...
					if(rs.next()) { // 해당 계정이 있으면, 정상 로그인
						rs.close();
						pstmt.close();
						//System.out.println("로그인성공");
						// 애플리케이션을 띄워준다.
						// 로그인창을 닫고....
						dispose();
						if(username.equals("admin")) {
							UserManager usermanager = new UserManager();
							usermanager.setVisible(true);
						}else {
							BookInfo apphome = new BookInfo(); // 새 프레임을 생성하고
							apphome.setVisible(true); // 프레임을 보이도록 한다.
						}
					}else {// 해당 계정이 없음
						//System.out.println("아이디와 비번을 다시 확인해주세요.");
						JOptionPane.showMessageDialog(null, "아이디와 비번을 다시 확인해주세요.");
					}
				}catch(SQLException elogin) {
					System.out.println("[MyMSG]SQL Exception Error : " + elogin.getMessage());
					elogin.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(273, 180, 73, 23);
		contentPane.add(btnLogin);

		txtUserPWD = new JPasswordField();
		txtUserPWD.setBounds(182, 125, 164, 23);
		contentPane.add(txtUserPWD);
		
		JButton btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();//현재 창을 닫고
				Join join = new Join();//새 창 객체 생성
				join.setVisible(true);//새 창 객체를 보이도록 
			}
		});
		btnJoin.setBounds(180, 180, 73, 23);
		contentPane.add(btnJoin);
	}
}