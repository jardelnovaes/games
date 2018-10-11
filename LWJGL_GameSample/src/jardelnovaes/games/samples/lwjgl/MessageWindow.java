package jardelnovaes.games.samples.lwjgl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MessageWindow extends JFrame {

	private JPanel contentPane;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void mainXX(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageWindow frame = new MessageWindow();
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
	public MessageWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lbl = new JLabel();
		contentPane.add(lbl);
		setContentPane(contentPane);
		setTitle("Game information system");
	}
	
	public void showMessage(String text){
		
		//MessageWindow frame = new MessageWindow();
		
		//frame.setVisible(true);
		lbl.setText(text);
		this.setVisible(true);
	}
	
	public void close(){
		lbl.setText("");
		this.setVisible(false);
	}

}
