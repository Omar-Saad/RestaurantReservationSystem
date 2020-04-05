package Dishes;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="dishes")
@XmlAccessorType(XmlAccessType.FIELD)

public class DishesXml {
	@XmlElement(name="dish")
	private ArrayList<DishXml> dish=new ArrayList<DishXml>();

	public ArrayList<DishXml> getDish() {
		return dish;
	}

	public void setDish(ArrayList<DishXml> dish) {
		this.dish = dish;
	}
	
	
	

}
