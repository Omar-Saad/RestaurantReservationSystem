package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Restaurnt.RestaurantXml;
import Tables.TableXml;
import Users.UserXml;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import Dishes.DishXml;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class WaiterForm extends JFrame {

	private JPanel contentPane;
	private JPanel ReservaitionsPanel;
	private JTable ReservationTable;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public WaiterForm(RestaurantXml restaurant) {
		setTitle("Waiter dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		ArrayList<UserXml> user = restaurant.getUsers().getUser();

		ArrayList<TableXml> table = restaurant.getTables().getTable();
		ArrayList<DishXml> dish = restaurant.getDishes().getDish();
		
		ReservaitionsPanel = new JPanel();
		ReservaitionsPanel.setBounds(0, 0, 600, 376);
		contentPane.add(ReservaitionsPanel);
		ReservaitionsPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 113, 329, 220);
		ReservaitionsPanel.add(scrollPane);
		
		ReservationTable = new JTable();
		ReservationTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer name", "Table number"
			}
		));
		scrollPane.setViewportView(ReservationTable);
		ReservationTable.setRowHeight(30);
		ReservaitionsPanel.setVisible(true);
		JButton btnNewButton = new JButton("Cancel reservation");
		DefaultTableModel model = (DefaultTableModel) ReservationTable.getModel();
	Object TableNum,name;
		for (TableXml t : table) {
			if(t.isReserved()==true) {
			TableNum = t.getTableNumber();
			name = t.getName();
			model.addRow(new Object[] {name,TableNum});
		}}
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) ReservationTable.getModel();
				int choice = 5;
				try {
				 choice = ReservationTable.getSelectedRow();}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "You must select a row first");
				}
					Object TableNum =  model.getValueAt(choice, 1);
				for (TableXml t : table) {
					if(TableNum.equals( t.getTableNumber()))
					{
						t.setReserved(false);
						t.setOrderDatas(null);
						t.setTotalPrice(0);
						t.setName(null);
						
						try {
							JAXBContext jaxbContext = JAXBContext.newInstance(RestaurantXml.class);
							Marshaller marshaller = jaxbContext.createMarshaller();
							marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
							marshaller.marshal(restaurant, new File("input.xml"));
							model.removeRow(choice);
							
							JOptionPane.showMessageDialog(null, "Reservation cancelled successfully");
						} catch (JAXBException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
						
					
				}
			}
		});
		btnNewButton.setBounds(447, 294, 141, 39);
		ReservaitionsPanel.add(btnNewButton);
		
		JLabel lblWaiterForm_1 = new JLabel("Waiter dashboard");
		lblWaiterForm_1.setForeground(Color.BLUE);
		lblWaiterForm_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblWaiterForm_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblWaiterForm_1.setBounds(85, 12, 421, 41);
		ReservaitionsPanel.add(lblWaiterForm_1);
		
		JLabel lblNewLabel = new JLabel("Today's reservations :");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(39, 75, 170, 26);
		ReservaitionsPanel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout ?");
				if(choice==JOptionPane.YES_OPTION)
				{
					Login.main(new String [] {});
					setVisible(false);
				}
			}
		});
		btnNewButton_1.setBounds(39, 338, 98, 26);
		ReservaitionsPanel.add(btnNewButton_1);
	}
}
