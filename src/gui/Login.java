package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import Dishes.DishXml;
import Restaurnt.RestaurantXml;
import Tables.TableXml;
import Users.UserXml;
import inheritance.Cooker;
import inheritance.Customer;
import inheritance.Manager;
import inheritance.User;
import inheritance.Waiter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.UIManager;
import java.awt.Window.Type;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField pass;
	 private RestaurantXml restaurant;
	 private JPanel panel;
	 private JButton btnLogin;
	 private JPanel panel_1;
	 private JTextArea txtUsername;
	 
		ArrayList<User> allusers = new ArrayList<>();
		ArrayList<TableXml > table = new ArrayList<TableXml>();
		ArrayList<DishXml>dish =new ArrayList<DishXml>();
		ArrayList<UserXml> user= new ArrayList<UserXml>();
		Customer customer;



	public RestaurantXml getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantXml restaurant) {
		this.restaurant = restaurant;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws JAXBException 
	 */
	
	
	
	public void LoadFile() throws JAXBException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(RestaurantXml.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		 restaurant = (RestaurantXml) unmarshaller.unmarshal(new File ("input.xml"));
		user =restaurant.getUsers().getUser();
		table=restaurant.getTables().getTable();
		dish=restaurant.getDishes().getDish();
		
		for (UserXml u : user) {
			if(u.getRole().equals("Manager"))
					{
				Manager m = new Manager(u.getUsername(),u.getName(),u.getPassword());
				allusers.add(m);
				
					}
			else if(u.getRole().equals("Client"))
			{
		 customer = new Customer(u.getUsername(),u.getName(),u.getPassword());
		allusers.add(customer);
		
			}
			else if(u.getRole().equals("Waiter"))
			{
		Waiter m = new Waiter(u.getUsername(),u.getName(),u.getPassword());
		allusers.add(m);
		
			}
			else if(u.getRole().equals("Cooker"))
			{
		Cooker m = new Cooker(u.getUsername(),u.getName(),u.getPassword());
		allusers.add(m);
		
			}


			
		
			
			
		}
		
	}
	
	

	public Login() throws JAXBException {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("Restaurant manger System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		
		panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 384, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login form");
		lblLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(22, 11, 116, 30);
		panel.add(lblLogin);
		
		panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.darkShadow"));
		panel_1.setBounds(0, 47, 384, 254);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(10, 63, 82, 25);
		lblUsername.setHorizontalTextPosition(SwingConstants.CENTER);
		panel_1.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(10, 118, 82, 25);
		panel_1.add(lblPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBackground(new Color(100, 149, 237));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(202, 171, 76, 25);
		panel_1.add(btnLogin);
		
		txtUsername = new JTextArea();
		txtUsername.setBounds(126, 65, 125, 22);
		panel_1.add(txtUsername);
		
		pass = new JPasswordField();
		pass.setBounds(126, 122, 152, 20);
		panel_1.add(pass);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = txtUsername.getText();
				String password = pass.getText();
				User CurrentUser = null;
				for(int i = 0; i<allusers.size();i++)
				{
					if(allusers.get(i).getUsername().equals(username))
						if(allusers.get(i).getPassword().equals(password))
						{
							

							CurrentUser=allusers.get(i);
							break;
						}
						
				}
				
				if(CurrentUser!=null)
				{
					if(CurrentUser instanceof Customer) {
						
						CustomerForm c;
						customer.setName(CurrentUser.getName());
						try {
							c = new CustomerForm(restaurant,customer);
							c.setVisible(true);
							setVisible(false);
						} catch (JAXBException e) {
							e.printStackTrace();
						}
						
						
					
						}
					
					else if(CurrentUser instanceof Manager)
					{
						ManagerForm m =new ManagerForm(restaurant);
						m.setVisible(true);
						setVisible(false);
					}
					
					else if(CurrentUser instanceof Waiter)
					{
						WaiterForm w =new WaiterForm(restaurant);
						w.setVisible(true);
						setVisible(false);
					}
					
					else if(CurrentUser instanceof Cooker)
					{
						CookerForm w =new CookerForm(restaurant);
						w.setVisible(true);
						setVisible(false);
					}
					
					

				}
				else
					JOptionPane.showMessageDialog(null, "Wrong usernamr or password . try again");

				
				
				
				
			}

		
		});
	LoadFile();
	}
}
