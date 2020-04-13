package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DataStructures.Map;

public class AddClientPanel extends JPanel{

	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtPhoneNumber;
	private JTextField txtEmail;
	
	JButton btnClear = new JButton("Clear");
	JButton btnSubmit = new JButton("Submit");
	JButton btnMainMenu = new JButton("Main Menu");
	//Add list to select trainer from
	
	public AddClientPanel(Map clients) {
		setLayout(new BorderLayout());

		JPanel form = new JPanel();

		form.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, }));
		
		
		JLabel lblAddClient = new JLabel("Add your imformation for being a client");
		add(lblAddClient, BorderLayout.NORTH);
		
		JLabel lblFirstName = new JLabel("First Name");
		form.add(lblFirstName, "4, 2, right, default");
		txtFirstName = new JTextField();
		form.add(txtFirstName, "6, 2, fill, default");
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		form.add(lblLastName, "4, 4, right, default");
		txtLastName = new JTextField();
		form.add(txtLastName, "6, 4, fill, default");
		txtLastName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		form.add(lblEmail, "4, 6, right, default");
		txtEmail = new JTextField();
		form.add(txtEmail, "6, 6, fill, default");
		txtEmail.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		form.add(lblAddress, "4, 8, right, default");
		txtAddress = new JTextField();
		form.add(txtAddress, "6, 8, fill, default");
		txtAddress.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		form.add(lblPhoneNumber, "4, 10, right, default");
		txtPhoneNumber = new JTextField();
		form.add(txtPhoneNumber, "6, 10, fill, default");
		txtPhoneNumber.setColumns(10);
		
		ButtonListener bl = new ButtonListener();
		btnSubmit.addActionListener(bl);
		btnClear.addActionListener(bl);
		btnMainMenu.addActionListener(bl);

		form.add(btnSubmit, "6, 12");
		form.add(btnClear, "6, 14");

		add(form, BorderLayout.CENTER);

		form.add(btnMainMenu, "6, 16");
		
		
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
	
	
}