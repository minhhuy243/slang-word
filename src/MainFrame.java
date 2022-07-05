import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame {
	private JTextField txtAsd;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 19));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(724, 115, 502, 515);
		
		JLabel lblNewLabel = new JLabel("abc");
		lblNewLabel.setBounds(262, 10, 545, 41);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblNewLabel_2 = new JLabel("Keyword:");
		lblNewLabel_2.setBounds(29, 116, 98, 23);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JLabel lblNewLabel_2_1 = new JLabel("abc: ...................................");
		lblNewLabel_2_1.setBounds(272, 61, 508, 31);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(801, 61, 131, 31);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(527, 115, 141, 31);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBounds(137, 166, 131, 31);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JButton btnNewButton_2 = new JButton("History");
		btnNewButton_2.setBounds(306, 166, 131, 31);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JLabel lblNewLabel_2_2 = new JLabel("Keyword:");
		lblNewLabel_2_2.setBounds(29, 236, 98, 23);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		txtAsd = new JTextField();
		txtAsd.setBounds(137, 116, 368, 29);
		txtAsd.setText("asd");
		txtAsd.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtAsd.setColumns(10);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Keyword:");
		lblNewLabel_2_2_1.setBounds(29, 280, 98, 23);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JButton btnNewButton_1_1 = new JButton("Search");
		btnNewButton_1_1.setBounds(137, 331, 131, 31);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JButton btnNewButton_1_2 = new JButton("Search");
		btnNewButton_1_2.setBounds(443, 331, 131, 31);
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JButton btnNewButton_1_3 = new JButton("Search");
		btnNewButton_1_3.setBounds(286, 331, 131, 31);
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		textField = new JTextField();
		textField.setBounds(137, 233, 531, 29);
		textField.setText("asd");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField.setColumns(10);
		
		JTable table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "AAA", null},
				{"2", "22", null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(null);
		getContentPane().add(btnNewButton_2);
		getContentPane().add(comboBox);
		getContentPane().add(lblNewLabel_2_1);
		getContentPane().add(btnNewButton_1_1);
		getContentPane().add(btnNewButton_1_2);
		getContentPane().add(btnNewButton_1_3);
		getContentPane().add(lblNewLabel_2_2_1);
		getContentPane().add(textField);
		getContentPane().add(lblNewLabel_2);
		getContentPane().add(txtAsd);
		getContentPane().add(lblNewLabel_2_2);
		getContentPane().add(btnNewButton_1);
		getContentPane().add(scrollPane);
		getContentPane().add(lblNewLabel);
		getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setText("asd");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_1.setColumns(10);
		textField_1.setBounds(137, 277, 531, 29);
		getContentPane().add(textField_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(29, 372, 639, 331);
		getContentPane().add(panel);
		
		JButton btnNewButton_1_2_1 = new JButton("Search");
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_1_2_1.setBounds(908, 653, 131, 31);
		getContentPane().add(btnNewButton_1_2_1);
		this.setBounds(100, 100, 1250, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		initialize();
	}
}
