import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import resource.Medication;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by Anar on 7/23/15.
 */
public class MigrationMedication {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("/Users/Anar/IdeaProjects/DraftBachelor/ELGA-e-Medikation_5-Medikationsliste.xml"));
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();
            XPathExpression query = xpath.compile(Medication.ROOT);
            NodeList medicationNodes = (NodeList) query.evaluate(doc, XPathConstants.NODESET);
            System.out.println("count  = " + medicationNodes.getLength());
            ArrayList<Medication> medications = new ArrayList<>();

            XPathExpression nameQuery = xpath.compile(Medication.NAME);
            XPathExpression codeQuery = xpath.compile(Medication.CODE);
            XPathExpression formQuery = xpath.compile(Medication.FORM);
            XPathExpression amountQuery = xpath.compile(Medication.AMOUNT);


            for (int i = 0; i < medicationNodes.getLength(); ++i) {
                Node medicationNode = medicationNodes.item(i);

                String name = (String) nameQuery.evaluate(medicationNode, XPathConstants.STRING);
                String code = (String) codeQuery.evaluate(medicationNode, XPathConstants.STRING);
                String form = (String) formQuery.evaluate(medicationNode, XPathConstants.STRING);
                String amount = (String) amountQuery.evaluate(medicationNode, XPathConstants.STRING);

                if (code != null && !code.isEmpty()) {
                    Medication.Product product = new Medication.Product(form, amount);
                    medications.add(new Medication(name, Long.parseLong(code), product));
                }
            }

            for (Medication medication : medications) {
                System.out.println("name = " + medication.getName() + ", code = " + medication.getCode());
            }
        } catch (ParserConfigurationException | SAXException | XPathExpressionException | IOException e) {
            e.printStackTrace();
        }
    }
}
