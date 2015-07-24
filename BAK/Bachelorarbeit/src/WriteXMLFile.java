import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class WriteXMLFile {



	
	public static void main(String argv[]) throws SAXException, IOException, XPathExpressionException {
		 
		  try {
	 
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Patient");
			doc.appendChild(rootElement);
			
			// set attribute to root element
			Attr attr = doc.createAttribute("xmlns");
			attr.setValue("http://hl7.org/fhir");
			rootElement.setAttributeNode(attr);
			//rootElement.setAttribute("xmlns", "http://hl7.org/fhir");
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("fhirPatient.xml"));
	 
			// Output to console for testing
			//StreamResult result = new StreamResult(System.out);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
			transformer.transform(source, result);
			
			System.out.println("File saved!");
			 		
			NodeCreator.createElement("identifier");
			NodeCreator.createElement("name");
			NodeCreator.createSubElement("family", "name");
			NodeCreator.createSubElement("given", "name");
			NodeCreator.createSubElement("given", "name");
			NodeCreator.createElement("telecom");
			NodeCreator.createElement("gender");
			NodeCreator.createElement("birthDate");
			NodeCreator.createElement("deceased");
			NodeCreator.createElement("address");
			NodeCreator.createElement("maritalStatus");
			NodeCreator.createElement("multipleBirth");
			NodeCreator.createElement("photo");
			NodeCreator.createElement("contact");
			NodeCreator.createSubElement("relationship", "contact");
			NodeCreator.createSubElement("name", "contact");
			NodeCreator.createSubElement("telecom", "contact");
			NodeCreator.createSubElement("address", "contact");
			NodeCreator.createSubElement("gender", "contact");
			NodeCreator.createSubElement("organization", "contact");
			NodeCreator.createSubElement("period", "contact");
			NodeCreator.createElement("animal");
			NodeCreator.createSubElement("species", "animal");
			NodeCreator.createSubElement("breed", "animal");
			NodeCreator.createSubElement("genderStatus", "animal");
			NodeCreator.createElement("communication");
			NodeCreator.createSubElement("language", "communication");
			NodeCreator.createSubElement("preferred", "communication");
			NodeCreator.createElement("careProvider");
			NodeCreator.createElement("managingOrganization");
			NodeCreator.createElement("link");
			NodeCreator.createSubElement("other", "link");
			NodeCreator.createSubElement("type", "link");
			NodeCreator.createElement("active");
			
			
			
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
		}
}
