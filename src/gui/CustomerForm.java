package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dishes.DishXml;
import Restaurnt.RestaurantXml;
import Tables.OrderData;
import Tables.TableXml;
import Users.UserXml;
import inheritance.Customer;
import inheritance.User;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultListModel;

import java.awt.Font;
import java.awt.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class CustomerForm extends JFrame {

	private JPanel contentPane;

	// private Restaurant restaurant ;

	private JTextField txtReataurantMangerSystem;
	private JTextField txtShowOrderPrice;
	private JTextField txtShowTotalTaxPrice;
	private JTextField txtShowTotalPrice;
	private JTextField txtCustomerForm;
	private JTextField txtSeats;
	private JList list;
	private JComboBox comboBox;
	private JButton btnAvailable;
	private JPanel OrderPanel;
	private JPanel ReservePanel;
	private int TableNum = 0;
	private JTable table_Main_Course;
	private JTable table_Appetizer;
	private JTable table_Desert;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws JAXBException
	 */
	public CustomerForm(RestaurantXml restaurant, Customer customer) throws JAXBException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		ArrayList<UserXml> user = restaurant.getUsers().getUser();

		ArrayList<TableXml> table = restaurant.getTables().getTable();
		ArrayList<DishXml> dish = restaurant.getDishes().getDish();

		OrderPanel = new JPanel();
		OrderPanel.setForeground(Color.BLACK);
		OrderPanel.setBounds(0, 0, 737, 483);
		contentPane.add(OrderPanel);
		OrderPanel.setLayout(null);
		OrderPanel.setVisible(false);
		txtReataurantMangerSystem = new JTextField();
		txtReataurantMangerSystem.setForeground(Color.BLACK);
		txtReataurantMangerSystem.setHorizontalAlignment(SwingConstants.CENTER);
		txtReataurantMangerSystem.setEditable(false);
		txtReataurantMangerSystem.setFont(new Font("Traditional Arabic", Font.BOLD, 38));
		txtReataurantMangerSystem.setText("Customer Form\r\n");
		txtReataurantMangerSystem.setBounds(152, 11, 441, 51);
		OrderPanel.add(txtReataurantMangerSystem);
		txtReataurantMangerSystem.setColumns(10);

		JPanel MainCoursePanel = new JPanel();
		MainCoursePanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		MainCoursePanel.setBounds(20, 73, 329, 191);
		OrderPanel.add(MainCoursePanel);
		MainCoursePanel.setLayout(null);

		JLabel lblMainCourse = new JLabel("Main Course");
		lblMainCourse.setBounds(122, 11, 92, 14);
		lblMainCourse.setForeground(Color.RED);
		lblMainCourse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMainCourse.setHorizontalAlignment(SwingConstants.CENTER);
		MainCoursePanel.add(lblMainCourse);

		JLabel lblTaxesWill = new JLabel("15% taxes will be added");
		lblTaxesWill.setBounds(90, 167, 147, 14);
		MainCoursePanel.add(lblTaxesWill);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 309, 126);
		MainCoursePanel.add(scrollPane);

		table_Main_Course = new JTable();
		table_Main_Course.setFont(new Font("Tahoma", Font.BOLD, 11));
		table_Main_Course
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Name", "Price", "Enter Quantity" }) {
					Class[] columnTypes = new Class[] { String.class, Double.class, Double.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}

					boolean[] columnEditables = new boolean[] { false, false, true };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		scrollPane.setViewportView(table_Main_Course);

		JPanel AppetizerPanel = new JPanel();
		AppetizerPanel.setLayout(null);
		AppetizerPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		AppetizerPanel.setBounds(380, 73, 329, 191);
		OrderPanel.add(AppetizerPanel);

		JLabel lblUrse = new JLabel("Appetizer");
		lblUrse.setHorizontalAlignment(SwingConstants.CENTER);
		lblUrse.setForeground(Color.RED);
		lblUrse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUrse.setBounds(122, 11, 92, 17);
		AppetizerPanel.add(lblUrse);

		JLabel lblTaxesWill_1 = new JLabel("10% taxes will be added");
		lblTaxesWill_1.setBounds(93, 166, 147, 14);
		AppetizerPanel.add(lblTaxesWill_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 39, 309, 116);
		AppetizerPanel.add(scrollPane_1);

		table_Appetizer = new JTable();
		table_Appetizer.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_Appetizer
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Name", "Price", "Enter Quantity" }) {
					Class[] columnTypes = new Class[] { String.class, Double.class, Double.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}

					boolean[] columnEditables = new boolean[] { false, true, true };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		scrollPane_1.setViewportView(table_Appetizer);

		JPanel MainCoursePanel_1 = new JPanel();
		MainCoursePanel_1.setLayout(null);
		MainCoursePanel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		MainCoursePanel_1.setBounds(20, 290, 329, 182);
		OrderPanel.add(MainCoursePanel_1);

		JLabel lblDesert = new JLabel("Desert");
		lblDesert.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesert.setForeground(Color.RED);
		lblDesert.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDesert.setBounds(122, 11, 92, 14);
		MainCoursePanel_1.add(lblDesert);

		JLabel lblTaxesWill_3 = new JLabel("20% taxes will be added");
		lblTaxesWill_3.setBounds(84, 157, 147, 14);
		MainCoursePanel_1.add(lblTaxesWill_3);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 36, 309, 110);
		MainCoursePanel_1.add(scrollPane_2);

		table_Desert = new JTable();
		table_Desert
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Name", "Price", "Enter Quantity" }) {
					Class[] columnTypes = new Class[] { String.class, Double.class, Double.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}

					boolean[] columnEditables = new boolean[] { false, false, true };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		table_Desert.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane_2.setViewportView(table_Desert);
		table_Desert.setRowHeight(20);
		table_Appetizer.setRowHeight(20);
		table_Main_Course.setRowHeight(20);
		JLabel lblMainCourseTotal = new JLabel("Total order price");
		lblMainCourseTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMainCourseTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainCourseTotal.setBounds(380, 290, 147, 19);
		OrderPanel.add(lblMainCourseTotal);

		txtShowOrderPrice = new JTextField();
		txtShowOrderPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtShowOrderPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtShowOrderPrice.setColumns(10);
		txtShowOrderPrice.setBackground(Color.WHITE);
		txtShowOrderPrice.setBounds(599, 289, 75, 20);
		OrderPanel.add(txtShowOrderPrice);

		JLabel lblTotalTaxPrice = new JLabel("Total tax price");
		lblTotalTaxPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalTaxPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalTaxPrice.setBounds(380, 339, 147, 19);
		OrderPanel.add(lblTotalTaxPrice);

		txtShowTotalTaxPrice = new JTextField();
		txtShowTotalTaxPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtShowTotalTaxPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtShowTotalTaxPrice.setColumns(10);
		txtShowTotalTaxPrice.setBackground(Color.WHITE);
		txtShowTotalTaxPrice.setBounds(599, 340, 75, 20);
		OrderPanel.add(txtShowTotalTaxPrice);

		JButton btnTotalPrice = new JButton("Total price");
		btnTotalPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ArrayList<Dish> dish = restaurant.getDishes().getDish();
				double OrderPrice = 0;
				double TaxPrice = 0;
				double TotalPrice, MainCoursePrice = 0, AppetizerPrice = 0, DessertPrice = 0;
				DefaultTableModel model = (DefaultTableModel) table_Main_Course.getModel();
				DefaultTableModel mode2 = (DefaultTableModel) table_Appetizer.getModel();
				DefaultTableModel mode3 = (DefaultTableModel) table_Desert.getModel();

				for (int i = 0; i < model.getRowCount(); i++) {
					try {

						MainCoursePrice += ((Double) model.getValueAt(i, 2)) * ((Double) model.getValueAt(i, 1));
					} catch (Exception e) {
						// TODO: handle exception
					}

				}
				for (int i = 0; i < mode2.getRowCount(); i++) {
					try {

						AppetizerPrice += ((Double) mode2.getValueAt(i, 2)) * ((Double) mode2.getValueAt(i, 1));
					} catch (Exception e) {
						// TODO: handle exception
					}

				}
				for (int i = 0; i < mode3.getRowCount(); i++) {
					try {

						DessertPrice += ((Double) mode3.getValueAt(i, 2)) * ((Double) mode3.getValueAt(i, 1));
					} catch (Exception e) {
						// TODO: handle exception
					}

				}

				OrderPrice = MainCoursePrice + AppetizerPrice + DessertPrice;
				txtShowOrderPrice.setText("" + OrderPrice);
				TaxPrice = MainCoursePrice * 0.15 + DessertPrice * 0.2 + AppetizerPrice * 0.1;
				txtShowTotalTaxPrice.setText("" + TaxPrice);
				TotalPrice = OrderPrice + TaxPrice;
				txtShowTotalPrice.setText("" + TotalPrice);

			}
		});
		btnTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTotalPrice.setBounds(448, 424, 96, 23);
		OrderPanel.add(btnTotalPrice);

		JLabel lblTotalPrice = new JLabel("Total price");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalPrice.setBounds(380, 392, 147, 19);
		OrderPanel.add(lblTotalPrice);

		txtShowTotalPrice = new JTextField();
		txtShowTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtShowTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtShowTotalPrice.setColumns(10);
		txtShowTotalPrice.setBackground(Color.WHITE);
		txtShowTotalPrice.setBounds(599, 393, 75, 20);
		OrderPanel.add(txtShowTotalPrice);

		JButton btnSave = new JButton("Save order");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					JAXBContext context = JAXBContext.newInstance(RestaurantXml.class);

					ArrayList<OrderData> orderDatas = new ArrayList<OrderData>();
					DefaultTableModel model = (DefaultTableModel) table_Main_Course.getModel();
					DefaultTableModel mode2 = (DefaultTableModel) table_Appetizer.getModel();
					DefaultTableModel mode3 = (DefaultTableModel) table_Desert.getModel();

					int i = 0;
					double q = 0;

					for (i = 0; i < model.getRowCount(); i++) {
						try {
							q = (double) model.getValueAt(i, 2);
						} catch (Exception e) {
							q = 0;
						}
						for (int j = 0; j < q; j++) {
							OrderData orderData = new OrderData();

							orderData.setName((String) model.getValueAt(i, 0));

							orderDatas.add(orderData);

						}

					}

					for (i = 0; i < mode2.getRowCount(); i++) {
						try {
							q = (double) mode2.getValueAt(i, 2);
						} catch (Exception e) {
							q = 0;
						}
						for (int j = 0; j < q; j++) {
							OrderData orderData = new OrderData();

							orderData.setName((String) mode2.getValueAt(i, 0));

							orderDatas.add(orderData);

						}

					}
					for (i = 0; i < mode3.getRowCount(); i++) {
						try {
							q = (double) mode3.getValueAt(i, 2);
						} catch (Exception e) {
							q = 0;
						}
						for (int j = 0; j < q; j++) {
							OrderData orderData = new OrderData();

							orderData.setName((String) mode3.getValueAt(i, 0));

							orderDatas.add(orderData);

						}

					}

					double TotalPrice = 0;
					try {
						TotalPrice = Double.parseDouble(txtShowTotalPrice.getText());

						Marshaller marshaller = context.createMarshaller();
						for (i = 0; i < table.size(); i++) {
							if ((table.get(i).getTableNumber()) == TableNum) {
								restaurant.getTables().getTable().get(i).setReserved(true);
								restaurant.getTables().getTable().get(i).setTotalPrice(TotalPrice);

								restaurant.getTables().getTable().get(i).setOrderDatas(orderDatas);
								restaurant.getTables().getTable().get(i).setName(customer.getName());

								marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
								marshaller.marshal(restaurant, new File("input.xml"));

								JOptionPane.showMessageDialog(null, "Order saved succesfully");
								break;
							}
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "You must press total price first ");

					}
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSave.setBounds(599, 424, 100, 23);
		OrderPanel.add(btnSave);

		JLabel lblClickHereTo = new JLabel(" Click here to make another order ");
		lblClickHereTo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClickHereTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to make a new order ?");
				if (choice == JOptionPane.YES_OPTION) {
					try {
						CustomerForm c = new CustomerForm(restaurant, customer);
						c.setVisible(true);
						setVisible(false);
					} catch (JAXBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
		lblClickHereTo.setBounds(437, 458, 237, 14);
		OrderPanel.add(lblClickHereTo);

		JLabel lblLogout = new JLabel("press here to Logout");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout ?");
				if (choice == JOptionPane.YES_OPTION) {
					Login.main(new String[] {});
					setVisible(false);
				}
			}
		});
		lblLogout.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setBounds(601, 9, 118, 14);
		OrderPanel.add(lblLogout);
		ReservePanel = new JPanel();
		ReservePanel.setBounds(0, 0, 737, 483);
		contentPane.add(ReservePanel);
		ReservePanel.setLayout(null);

		txtCustomerForm = new JTextField();
		txtCustomerForm.setText("Customer Form");
		txtCustomerForm.setHorizontalAlignment(SwingConstants.CENTER);
		txtCustomerForm.setForeground(Color.BLACK);
		txtCustomerForm.setFont(new Font("Traditional Arabic", Font.BOLD, 38));
		txtCustomerForm.setEditable(false);
		txtCustomerForm.setColumns(10);
		txtCustomerForm.setBounds(156, 11, 437, 51);
		ReservePanel.add(txtCustomerForm);

		JLabel lblWelcome = new JLabel("Welcome, " + customer.getName());
		lblWelcome.setForeground(Color.RED);
		lblWelcome.setFont(new Font("Traditional Arabic", Font.BOLD, 26));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(10, 98, 374, 46);
		ReservePanel.add(lblWelcome);

		JLabel lblNewLabel_3 = new JLabel("Enter number of seats :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(10, 155, 246, 22);
		ReservePanel.add(lblNewLabel_3);

		txtSeats = new JTextField();
		txtSeats.setText("0");
		txtSeats.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtSeats.setHorizontalAlignment(SwingConstants.CENTER);
		txtSeats.setBounds(329, 155, 97, 22);
		ReservePanel.add(txtSeats);
		txtSeats.setColumns(10);

		btnAvailable = new JButton("Check Availabilty");

		btnAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int SeatsNum;

				try {

					int j = 0;
					SeatsNum = Integer.parseInt(txtSeats.getText());
					boolean Smoking = false;
					if (comboBox.getSelectedIndex() == 0)
						Smoking = true;
					int flag = 0;

					DefaultListModel listt = new DefaultListModel();
					for (int i = 0; i < table.size(); i++) {
						if ((table.get(i).getNumberOfSeats() == SeatsNum)
								&& ((table.get(i).isSmoking() == Smoking) || (comboBox.getSelectedIndex() == 2))) {

							if (!table.get(i).isReserved()) {
								TableNum = table.get(i).getTableNumber();
								listt.add(j, "Table number : " + table.get(i).getTableNumber() + "   Number of seats : "
										+ table.get(i).getNumberOfSeats() + "   Type : " + comboBox.getSelectedItem());
								j++;
								list.setModel(listt);
								flag = 1;
							}

						}
					}
					if (flag == 0) {
						JOptionPane.showMessageDialog(null, "Sorry, No tables available for your choice");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "You entered wrong value.Please try again");
				}

			}
		});
		btnAvailable.setBackground(Color.DARK_GRAY);
		btnAvailable.setForeground(Color.WHITE);
		btnAvailable.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAvailable.setBounds(504, 181, 143, 22);
		ReservePanel.add(btnAvailable);

		JLabel lblNewLabel_3_1 = new JLabel("Table place :");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1.setBounds(10, 211, 246, 22);
		ReservePanel.add(lblNewLabel_3_1);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Smoking", "Non-Smoking", "Any" }));
		comboBox.setSelectedIndex(0);
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(329, 211, 115, 26);
		ReservePanel.add(comboBox);

		list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.setBounds(48, 264, 408, 160);
		ReservePanel.add(list);

		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!list.isSelectionEmpty()) {

					DefaultTableModel model = (DefaultTableModel) table_Main_Course.getModel();
					DefaultTableModel mode2 = (DefaultTableModel) table_Appetizer.getModel();
					DefaultTableModel mode3 = (DefaultTableModel) table_Desert.getModel();

					Object name, price;

					for (int i = 0; i < dish.size(); i++)

					{
						if (dish.get(i).getType().equals("main_course")) {
							name = dish.get(i).getName();
							price = dish.get(i).getPrice();

							model.addRow(new Object[] { name, price });

						} else if (dish.get(i).getType().equals("appetizer")) {
							name = dish.get(i).getName();
							price = dish.get(i).getPrice();

							mode2.addRow(new Object[] { name, price });

						} else if (dish.get(i).getType().equals("desert")) {
							name = dish.get(i).getName();
							price = dish.get(i).getPrice();

							mode3.addRow(new Object[] { name, price });

						}
					}

					OrderPanel.setVisible(true);
					ReservePanel.setVisible(false);
				}

				else {
					JOptionPane.showMessageDialog(null, "You have to choose a table first");
				}
			}
		});
		btnNext.setBounds(550, 449, 97, 23);
		ReservePanel.add(btnNext);

		JButton btnLogout = new JButton("Log out");
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout ?");
				if (choice == JOptionPane.YES_OPTION) {
					Login.main(new String[] {});
					setVisible(false);
				}
			}
		});
		btnLogout.setBounds(56, 451, 89, 23);
		ReservePanel.add(btnLogout);

	}
}
