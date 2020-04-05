package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dishes.DishXml;
import Restaurnt.RestaurantXml;
import Tables.OrderData;
import Tables.TableXml;
import Users.UserXml;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

public class ManagerForm extends JFrame {

	private JPanel contentPane;
	private JTable tableShowUsers;
	private JPanel panelManager;
	private JPanel panelShowUsers;
	private JButton btnLogOut;
	private JPanel panelReservedTables;
	private JTable ReservedTables;
	private JButton btnBack2;
	private JButton btnCancelReservation;
	private JLabel lblManagerDashboard_1;
	private JLabel lblManagerDashboard_2;
	private JLabel lblTodaysProfit;
	private JTextField txtProfit;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ManagerForm(RestaurantXml restaurant) {
		setTitle("Manager dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		ArrayList<UserXml> user = restaurant.getUsers().getUser();

		ArrayList<TableXml> table = restaurant.getTables().getTable();
		ArrayList<DishXml> dish = restaurant.getDishes().getDish();
		
		panelReservedTables = new JPanel();
		panelReservedTables.setBounds(0, 0, 561, 385);
		contentPane.add(panelReservedTables);
		panelReservedTables.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 63, 528, 243);
		panelReservedTables.add(scrollPane_1);
		
		ReservedTables = new JTable();
		ReservedTables.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Table number", "Customer name", "Order", "Amount paid"
			}
		));
		scrollPane_1.setViewportView(ReservedTables);
		ReservedTables.setRowHeight(40);
		
		btnBack2 = new JButton("Back");
		btnBack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelReservedTables.setVisible(false);
				panelManager.setVisible(true);
				DefaultTableModel model = (DefaultTableModel) ReservedTables.getModel();
				model.setRowCount(0);
			}
		});
		btnBack2.setBounds(293, 352, 89, 23);
		panelReservedTables.add(btnBack2);
		
		JLabel lblManagerDashboard = new JLabel("Manager dashboard");
		lblManagerDashboard.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblManagerDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagerDashboard.setBounds(111, 11, 324, 40);
		panelReservedTables.add(lblManagerDashboard);
		
		JButton btnLogOut_1 = new JButton("LOG OUT");
		btnLogOut_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout ?");
				if (choice == JOptionPane.YES_OPTION)
				{
					setVisible(false);
					Login.main(new String[] {});
				}
			}
		});
		btnLogOut_1.setBounds(21, 351, 89, 23);
		panelReservedTables.add(btnLogOut_1);
		
		btnCancelReservation = new JButton("Cancel Reservation");
		btnCancelReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) ReservedTables.getModel();
				int choice = 5;
				try {
				 choice = ReservedTables.getSelectedRow();}
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "You must select a row first");
				}
					Object TableNum =  model.getValueAt(choice, 0);
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
						} catch (JAXBException e1) {

						JOptionPane.showMessageDialog(null, "Error");
						}
						
					}
			}}
		});
		btnCancelReservation.setBounds(407, 351, 144, 23);
		panelReservedTables.add(btnCancelReservation);
		
		lblTodaysProfit = new JLabel("Today's profit :");
		lblTodaysProfit.setHorizontalAlignment(SwingConstants.CENTER);
		lblTodaysProfit.setForeground(Color.RED);
		lblTodaysProfit.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTodaysProfit.setBounds(21, 313, 132, 26);
		panelReservedTables.add(lblTodaysProfit);
		
		txtProfit = new JTextField();
		lblTodaysProfit.setLabelFor(txtProfit);
		txtProfit.setHorizontalAlignment(SwingConstants.CENTER);
		txtProfit.setFont(new Font("Dialog", Font.BOLD, 15));
		txtProfit.setColumns(10);
		txtProfit.setBounds(171, 318, 98, 20);
		panelReservedTables.add(txtProfit);
		
		panelManager = new JPanel();
		panelManager.setLayout(null);
		panelManager.setBounds(0, 0, 561, 385);
		contentPane.add(panelManager);
		panelManager.setVisible(true);
		
		
		JButton btnShowUsers = new JButton("SHOW USERS");
		btnShowUsers.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				panelShowUsers.setVisible(true);
				panelManager.setVisible(false);
				
			
				DefaultTableModel model = (DefaultTableModel) tableShowUsers.getModel();
				Object o,r;
				for (int i=0;i<user.size();i++)
				{
					o = user.get(i).getName();
					r = user.get(i).getRole();
					model.addRow(new Object[] {o,r});
				}
				
				
			}
			
		});
		btnShowUsers.setBounds(43, 184, 137, 88);
		
		panelManager.add(btnShowUsers);
		
		JButton btnReservedTables = new JButton("Show reserves tables");
		btnReservedTables.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReservedTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) ReservedTables.getModel();
				panelReservedTables.setVisible(true);
				panelManager.setVisible(false);
				
				
				Object TableNum,name,price;
				
			
				double TotalPrice = 0;
				for (TableXml t : table) {
					if(t.isReserved()) {
						ArrayList<Object> order = new ArrayList<Object>();
						TableNum = t.getTableNumber();
						name= t.getName();
						price=t.getTotalPrice();
						TotalPrice += t.getTotalPrice();
						for(int j=0;j<t.getOrderDatas().size();j++)
						{
							order.add( t.getOrderDatas().get(j).getName());
						}
						model.addRow(new Object[] {TableNum,name,order,price});
					
						
					}

				}
				
				txtProfit.setText(Double.toString( TotalPrice));
				
				
			}		
		});
		btnReservedTables.setBounds(236, 185, 155, 88);
		panelManager.add(btnReservedTables);
		
		lblManagerDashboard_1 = new JLabel("Manager dashboard");
		lblManagerDashboard_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagerDashboard_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblManagerDashboard_1.setBounds(115, 11, 324, 47);
		panelManager.add(lblManagerDashboard_1);
		
		JButton btnLogOut_2 = new JButton("LOG OUT");
		btnLogOut_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout ?");
				if (choice == JOptionPane.YES_OPTION)
				{
					setVisible(false);
					Login.main(new String[] {});
				}
			}
		});
		btnLogOut_2.setBounds(43, 350, 89, 23);
		panelManager.add(btnLogOut_2);
		
		panelShowUsers = new JPanel();
		panelShowUsers.setBounds(0, 0, 561, 385);
		contentPane.add(panelShowUsers);
		panelShowUsers.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 381, 229);
		panelShowUsers.add(scrollPane);
		
		tableShowUsers = new JTable();
		tableShowUsers.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"USER", "ROLE"
			}
		));
		scrollPane.setViewportView(tableShowUsers);
		tableShowUsers.setRowHeight(30);
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) tableShowUsers.getModel();
				model.setRowCount(0);
				panelManager.setVisible(true);
				panelShowUsers.setVisible(false);
			
			}
		});
		btnBack.setBounds(440, 351, 89, 23);
		panelShowUsers.add(btnBack);
		
		btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout ?");
				if (choice == JOptionPane.YES_OPTION)
				{
					setVisible(false);
					Login.main(new String[] {});
				}
			}
		});					
		btnLogOut.setBounds(327, 351, 89, 23);
		panelShowUsers.add(btnLogOut);
		
		lblManagerDashboard_2 = new JLabel("Manager dashboard");
		lblManagerDashboard_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagerDashboard_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblManagerDashboard_2.setBounds(105, 11, 324, 47);
		panelShowUsers.add(lblManagerDashboard_2);
		panelShowUsers.setVisible(false);
		
		
		panelShowUsers.setVisible(false);
		panelReservedTables.setVisible(false);
	}
}
