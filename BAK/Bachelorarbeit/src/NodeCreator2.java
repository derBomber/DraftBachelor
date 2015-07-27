
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;


public class NodeCreator2 {
	/**
	 * Recursive method to create an element and, if necessary, its parents and siblings
	 * @param document
	 * @param xpath to single element
	 * @param value if null an empty element will be created
	 * @return the created Node
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	//public static Node addElementToParent(Document document, String xpath, String value) {
	public static Node addElementToParent(String xpath, String value) throws ParserConfigurationException, SAXException, IOException {
		System.out.println("adding Element: " + xpath + " -> " + value);
        
		final String ROOT = "Patient";
		Document document2 = DocumentHelper.createDocument(DocumentHelper.createElement(ROOT));
		
		String elementName = XPathUtils.getChildElementName(xpath);
		System.out.println("elementName:" + elementName);
		String parentXPath = XPathUtils.getParentXPath(xpath);
		System.out.println("partent:" + parentXPath);
		Node parentNode = ((Node) document2).selectSingleNode(parentXPath);
		System.out.println("parentNode:" + parentNode);
		if(parentNode == null) {	
			//parentNode = addElementToParent(document2, parentXPath, null);
			parentNode = addElementToParent(parentXPath, null);
		}
		
		// create younger siblings if needed
		Integer childIndex = XPathUtils.getChildElementIndex(xpath);
		if(childIndex > 1) {
			List<?> nodelist = ((Node) document2).selectNodes(XPathUtils.createPositionXpath(xpath, childIndex));
			// how many to create = (index wanted - existing - 1 to account for the new element we will create)
			int nodesToCreate = childIndex - nodelist.size() - 1;
			for(int i = 0; i < nodesToCreate; i++) {
				((Element)parentNode).addElement(elementName);
			}
		}
		
		// create requested element
		Element created = ((Element)parentNode).addElement(elementName);
		if(null != value) {
			created.addText(value);
			
		}
		
		System.out.println("doc2" + document2.getDocument().hasContent());
		printDoc(document2);
		return created;
	}
	
	private static void printDoc(Document document) {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("ISO-8859-1");
		StringWriter writer = new StringWriter();
		XMLWriter xmlwriter = new XMLWriter(writer, format);
		try {
			xmlwriter.write( document );
		} catch (IOException e) {
		}
	}
}
