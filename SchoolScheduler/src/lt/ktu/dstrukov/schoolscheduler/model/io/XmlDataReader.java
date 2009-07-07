package lt.ktu.dstrukov.schoolscheduler.model.io;

/**
 * Class XmlDataReader reads sheets, sheet names and sheet data.<br>
 * Last modified: April 05 2007 <br>
 * Status: Finished
 */
import java.io.File;
import java.io.Serializable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


public class XmlDataReader implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6059979576613556296L;
	private int row_count[], column_count[], sheet_count;
	private String  name[];
 
	private NodeList[] Data;
	
	XmlDataReader(String Path) {
		//this.Path =Path;
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(Path));
			doc.getDocumentElement().normalize();

			NodeList worksheets = doc.getElementsByTagName("Worksheet");
			sheet_count = worksheets.getLength();
			Data = new NodeList[sheet_count]; 
			row_count = new int[sheet_count];
			column_count = new int[sheet_count];
			name = new String[sheet_count];
			
			
			for (int i =0; i< sheet_count; i++){
				Node worksheet = worksheets.item(i);
				Element ws = (Element) worksheet;
				NodeList columns = ws.getElementsByTagName("Cell");
				NodeList rows = ws.getElementsByTagName("Row");
				row_count[i] = rows.getLength(); 
				column_count[i] = columns.getLength() / row_count[i] + 1;
				Data[i] = rows;
				name[i] = ws.getAttribute("ss:Name");
			}
			
		} catch (SAXParseException err) {
			System.out.println("** Parsing error" + ", line "
					+ err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println(" " + err.getMessage());
		}

		catch (SAXException e) {
			Exception x = e.getException();
			(x == null ? e : x).printStackTrace();
		}

		catch (Throwable t) {
			t.printStackTrace();
		}
	}


	public int getColumn_count(int SheetNr) {
		return column_count[SheetNr];
	}

	public NodeList getData(int SheetNr) {
		return Data[SheetNr];
	}

	public int getRow_count(int SheetNr) {
		return row_count[SheetNr];
	}

	public int getSheet_count() {
	
		return sheet_count;
	}

	public String getName(int SheetNr) {
		return name[SheetNr];
	}

}
