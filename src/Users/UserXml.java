package Users;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)

public class UserXml {
	
	@XmlElement(name="name")
	private String name;
	@XmlElement(name="role")
	private String role;
	@XmlElement(name="username")
	private String username;
	@XmlElement(name="password")
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	



}
