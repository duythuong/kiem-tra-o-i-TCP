package TCP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class client {

	public JFrame frame;

	Socket socket;
	DataInputStream input;
	DataOutputStream output;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	String t ;
	String t1 ;
	String t2 ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					client window = new client();
					window.frame.setVisible(true);
					window.frame.setTitle("Client");
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public void client() {
		try {
			socket = new Socket("localhost", 1009);
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
			t = textField.getText();
			t1 = textField_1.getText();
			output.writeBytes(t+"\n");
			output.writeBytes(t1+"\n");
			String s2 = input.readLine();
			textField_2.setText(s2);
			socket.close();
			input.close();
			output.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 661, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirstNumber = new JLabel("First number");
		lblFirstNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFirstNumber.setBounds(10, 35, 112, 37);
		frame.getContentPane().add(lblFirstNumber);
		
		textField = new JTextField();
		textField.setBounds(185, 39, 312, 37);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSecondNumber = new JLabel("Second number");
		lblSecondNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSecondNumber.setBounds(10, 107, 148, 37);
		frame.getContentPane().add(lblSecondNumber);
		
		JLabel lblResultFromServer = new JLabel("Result from server");
		lblResultFromServer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblResultFromServer.setBounds(10, 178, 177, 37);
		frame.getContentPane().add(lblResultFromServer);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(185, 107, 312, 37);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(185, 178, 312, 37);
		frame.getContentPane().add(textField_2);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				client();
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSend.setBounds(520, 37, 101, 37);
		frame.getContentPane().add(btnSend);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBounds(520, 178, 101, 37);
		frame.getContentPane().add(btnExit);
	}
}
