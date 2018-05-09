package TCP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PublicKey;
import java.awt.event.ActionEvent;

public class server {

	private JFrame frame;
    public ServerSocket servers;
    public Socket socket;
    DataInputStream input;
	DataOutputStream output;
	String s;
	String s1;
	int a,b,tong;
	String s2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					server window = new server();
					window.frame.setVisible(true);
					window.frame.setTitle("Server");
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
	public void servers() {
		try {
			servers = new ServerSocket(1009);
			socket = servers.accept();
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
			s = input.readLine();
			s1 = input.readLine();
			a = Integer.parseInt(s);
			b = Integer.parseInt(s1);
			tong = a + b;
			s2 = String.valueOf(tong);
			output.writeBytes(s2);
			input.close();
			socket.close();
			output.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public server() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 452, 144);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				servers();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(48, 10, 337, 70);
		frame.getContentPane().add(btnNewButton);
	}

}
