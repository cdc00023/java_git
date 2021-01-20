package com.swcodingschool.guibasic;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Join extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPWD;
	private JPasswordField txtConfirm;
	private JTextField txtAddr;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	// ui에서 입력된 값을 취하기 위한 임시 변수
	private String username;
	private String userpwd;
	private String confirm;
	private String gender;
	private String addr;

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
		setTitle("Join Member");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Join as New Member");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(57, 35, 226, 37);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setBounds(12, 107, 85, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(12, 140, 85, 15);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Confirm");
		lblNewLabel_1_1_1.setBounds(12, 176, 85, 15);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Gender");
		lblNewLabel_1_1_1_1.setBounds(12, 215, 85, 15);
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setBounds(12, 253, 85, 15);
		contentPane.add(lblNewLabel_2);

		JRadioButton rdoMale = new JRadioButton("Male");
		rdoMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "M";
			}
		});
		buttonGroup.add(rdoMale);
		rdoMale.setBounds(111, 211, 62, 23);
		contentPane.add(rdoMale);

		JRadioButton rdoFemale = new JRadioButton("Female");
		rdoFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "F";
			}
		});
		buttonGroup.add(rdoFemale);
		rdoFemale.setBounds(194, 211, 85, 23);
		contentPane.add(rdoFemale);

		txtUserName = new JTextField();
		txtUserName.setBounds(101, 104, 226, 21);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		txtPWD = new JPasswordField();
		txtPWD.setBounds(101, 137, 226, 21);
		contentPane.add(txtPWD);

		txtConfirm = new JPasswordField();
		txtConfirm.setBounds(101, 173, 226, 21);
		contentPane.add(txtConfirm);

		txtAddr = new JTextField();
		txtAddr.setBounds(101, 250, 226, 21);
		contentPane.add(txtAddr);
		txtAddr.setColumns(10);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// UI 입력 요소들을 reset
				txtUserName.setText("");
				txtPWD.setText("");
				txtConfirm.setText("");
				buttonGroup.clearSelection();  // 라디오버튼 그룹 리셋
				txtAddr.setText("");
			}
		});
		btnReset.setBounds(101, 306, 97, 23);
		contentPane.add(btnReset);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 입력된 데이터 값을 db에 저장하는 과정
				// 데이터베이스 연결
				if (DBUtil.dbconn == null) DBUtil.DBConnect();
				// 입력된 값을 임시 변수로 변환
				username = txtUserName.getText();
				addr = txtAddr.getText();
				// 비밀번호 일치 여부 확인
				String userpwd = new String(txtPWD.getPassword());
				String confirm = new String(txtConfirm.getPassword());
//				System.out.println(userpwd);
//				System.out.println(confirm);
				if (!userpwd.equals(confirm)){
					txtPWD.setText("");
					txtConfirm.setText("");
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
				} else {
					// 입력된 값으로 sql구문 완성
					String sql = "INSERT INTO tbluser(username, userpwd, gender, addr) VALUES(?,?,?,?)";

					try {
						// prepared statement는 sql 구문을 좀더 단순하게 구성할 수 있도록 한다.
						PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
						pstmt.setString(1, username); // userid 변수값으로 sql구문의 첫번째 ? 에 대입
						pstmt.setString(2, userpwd);// userpwd 변수값으로 sql구문의 두번째 ? 에 대입
						pstmt.setString(3, gender);
						pstmt.setString(4, addr);

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
				}//end of else
			}
		});
		btnSave.setBounds(208, 306, 97, 23);
		contentPane.add(btnSave);
	}
}
