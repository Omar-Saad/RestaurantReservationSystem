package Tables;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="table")
@XmlAccessorType(XmlAccessType.FIELD)
public class TableXml {
	@XmlElement(name="number")
	private int TableNumber;
	@XmlElement(name="number_of_seats")
	private int NumberOfSeats;
	@XmlElement(name="smoking")
	boolean Smoking;
	@XmlElement(name="reserved")
	boolean reserved;
	@XmlElement(name="order")
	private ArrayList<OrderData>   orderDatas ;
	@XmlElement(name="customer_name")
	private String name;
	@XmlElement(name="total_price")
	private double TotalPrice;
	
	public int getTableNumber() {
		return TableNumber;
	}
	public void setTableNumber(int tableNumber) {
		TableNumber = tableNumber;
	}
	public int getNumberOfSeats() {
		return NumberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		NumberOfSeats = numberOfSeats;
	}
	public boolean isSmoking() {
		return Smoking;
	}
	public void setSmoking(boolean smoking) {
		Smoking = smoking;
	}
	public boolean isReserved() {
		return reserved;
	}
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	public ArrayList<OrderData> getOrderDatas() {
		return orderDatas;
	}
	public void setOrderDatas(ArrayList<OrderData> orderDatas) {
		this.orderDatas = orderDatas;
	}
	public double getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		TotalPrice = totalPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

	
	
}
