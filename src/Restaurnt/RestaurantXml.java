package Restaurnt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Dishes.DishesXml;
import Tables.TablesXml;
import Users.UsersXml;

@XmlRootElement(name = "restaurant")
@XmlAccessorType(XmlAccessType.FIELD)

public class RestaurantXml {
	@XmlElement(name="users")
	private UsersXml users=null;
	@XmlElement(name="tables")
	private TablesXml tables =null;
	@XmlElement(name="dishes")
	private DishesXml dishes=null;
	

	public UsersXml getUsers() {
		return users;
	}

	public void setUsers(UsersXml users) {
		this.users = users;
	}

	public TablesXml getTables() {
		return tables;
	}

	public void setTables(TablesXml tables) {
		this.tables = tables;
	}

	public DishesXml getDishes() {
		return dishes;
	}

	public void setDishes(DishesXml dishes) {
		this.dishes = dishes;
	}
	
	
	

}
