package Users;

import java.awt.*;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersXml {
	@XmlElement(name="user")

	private ArrayList<UserXml> user ;

	public ArrayList<UserXml> getUser() {
		return user;
	}

	public void setUser(ArrayList<UserXml> user) {
		this.user = user;
	}
	

}
