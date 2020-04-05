package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dishes.DishXml;
import Restaurnt.RestaurantXml;
import Tables.TableXml;
import Users.UserXml;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CookerForm extends JFrame {

	private JPanel contentPane;
	private JTable CookTable;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public CookerForm(RestaurantXml restaurant) {
		setTitle("Cooker dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		ArrayList<UserXml> user = restaurant.getUsers().getUser();

		ArrayList<TableXml> table = restaurant.getTables().getTable();
		ArrayList<DishXml> dish = restaurant.getDishes().getDish();
		
		JPanel panelCooker = new JPanel();
		panelCooker.setBounds(0, 0, 554, 369);
		contentPane.add(panelCooker);
		panelCooker.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 455, 185);
		panelCooker.add(scrollPane);
		
		CookTable = new JTable();
		CookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Table number", "Order"
			}
		));
		scrollPane.setViewportView(CookTable);
		CookTable.setRowHeight(40);
		
		DefaultTableModel model = (DefaultTableModel) CookTable.getModel();
		Object TableNum;
		for (TableXml t : table) {
			if(t.isReserved()) {
				
				ArrayList<Object> order = new ArrayList<Object>();

				TableNum = t.getTableNumber();
				//int k =0;
				//model.addRow(new Object[] {0,""});
				//model.setValueAt(t.getTableNumber(),k ,0);

				for(int j=0;j<t.getOrderDatas().size();j++)
				{

					order.add( t.getOrderDatas().get(j).getName());
					//model.setValueAt(""+t.getOrderDatas().get(j).getName()+"\n",k,1);
					//k++;
					
					
				}
				model.addRow(new Object[] {TableNum,order});
				
				
				
			}
			
		}
		

		
		JLabel lblWaiterForm_1 = new JLabel("Cooker dashboard");
		lblWaiterForm_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblWaiterForm_1.setForeground(Color.BLUE);
		lblWaiterForm_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblWaiterForm_1.setBounds(44, 11, 421, 41);
		panelCooker.add(lblWaiterForm_1);
		
		JLabel lblNewLabel = new JLabel("Today's Cooks :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 79, 170, 26);
		panelCooker.add(lblNewLabel);
		

		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout ?");
				if (choice == JOptionPane.YES_OPTION)
				{
					setVisible(false);
					Login.main(new String[] {});
				}
			}
		});
		btnNewButton_1.setBounds(25, 332, 98, 26);
		panelCooker.add(btnNewButton_1);
	}
}
