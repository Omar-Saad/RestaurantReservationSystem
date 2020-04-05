package Tables;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="tables")
@XmlAccessorType(XmlAccessType.FIELD)
public class TablesXml {
	@XmlElement(name="table")
	
private ArrayList<TableXml> table = new ArrayList<TableXml>();

	public ArrayList<TableXml> getTable() {
		return table;
	}

	public void setTable(ArrayList<TableXml> table) {
		this.table = table;
	}
	

}
