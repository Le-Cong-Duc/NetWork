package File;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class CreateFile extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					CreateFile frame = new CreateFile();
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
	public CreateFile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Folder");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(28, 27, 84, 32);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(111, 29, 290, 32);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(this);
		btnOpen.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOpen.setBounds(411, 29, 89, 32);
		contentPane.add(btnOpen);

		JLabel lblFileName = new JLabel("File Name");
		lblFileName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFileName.setBounds(28, 91, 84, 32);
		contentPane.add(lblFileName);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(111, 93, 290, 32);
		contentPane.add(textField_1);

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(this);
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCreate.setBounds(411, 93, 89, 32);
		contentPane.add(btnCreate);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		if (ac.equals("Open")) {
			
		JFileChooser filechooser = new JFileChooser();   //JFileChooser - cho phép chọn 1 thư mục
		filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 	//JFileChooser.DIRECTORIES_ONLY - chỉ cho phép người dùng chọn thư mục, không thể chọn tập tin
		 int result = filechooser.showOpenDialog(this); //showOpenDialog - hiển thị hộp thoại chọn thư mục 
		 
		 if(result == JFileChooser.APPROVE_OPTION) { //  nếu người dùng chọn 1 thư mục - (APPROVE_OPTION)
			 String path = filechooser.getSelectedFile().getAbsolutePath(); //để lấy đường dẫn tuyệt đối của File - (AbsolutePath)
			 textField.setText(path);
		 }
		}
		
		else if(ac.equals("Create")) {
			String path = textField.getText()+"/"+textField_1.getText();
			File file = new File(path);
			if(textField_1.getText().trim().length()==0) {  //trim() - dùng để loại bỏ ký tự trống
				JOptionPane.showMessageDialog(this, "Chua nhap ten file !");
			}
			else if (file.exists()) {
				JOptionPane.showMessageDialog(this, "Tap tin da ton tai !");				
			}
			else {
				try {
					file.createNewFile();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Khong the tao duoc tap tin !");
				}
			}
		}
	}
}
