import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ressources.Patient;
import ressources.PatientBuilder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Anar on 7/26/15.
 */
public class MigrationPatient {


    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("/Users/Anar/IdeaProjects/DraftBachelor/ELGA-e-Medikation_5-Medikationsliste.xml"));
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();
            XPathExpression query = xpath.compile(Patient.ROOT);
            NodeList patientNodes = (NodeList) query.evaluate(doc, XPathConstants.NODESET);
            System.out.println("count  = " + patientNodes.getLength());
            ArrayList<Patient> patients = new ArrayList<>();


            XPathExpression prefixNameQuery = xpath.compile(Patient.NAME_PREFIX);
            XPathExpression prefixNameQuery2 = xpath.compile(Patient.NAME_PREFIX2);
            XPathExpression givenNameQuery = xpath.compile(Patient.NAME_GIVEN);
            XPathExpression givenNameQuery2 = xpath.compile(Patient.NAME_GIVEN2);
            XPathExpression familyNameQuery = xpath.compile(Patient.NAME_FAMILY);
            XPathExpression familyNameQuery2 = xpath.compile(Patient.NAME_FAMILY2);
            XPathExpression suffixNameQuery = xpath.compile(Patient.NAME_SUFFIX);
            XPathExpression suffixNameQuery2 = xpath.compile(Patient.NAME_SUFFIX2);
            XPathExpression streetQuery = xpath.compile(Patient.STREET);
            XPathExpression cityQuery = xpath.compile(Patient.CITY);
            XPathExpression postalQuery = xpath.compile(Patient.POSTAL);
            XPathExpression countryQuery = xpath.compile(Patient.COUNTRY);
            XPathExpression stateQuery = xpath.compile(Patient.STATE);
            XPathExpression idQuery = xpath.compile(Patient.ID);
            XPathExpression socialIdQuery = xpath.compile(Patient.SOCIAL_ID);
            XPathExpression telQuery = xpath.compile(Patient.TEL);
            XPathExpression emailQuery = xpath.compile(Patient.EMAIL);
            XPathExpression genderQuery = xpath.compile(Patient.GENDER);
            XPathExpression birthPlaceQuery = xpath.compile(Patient.BIRTH_PLACE);
            XPathExpression birthtimeQuery = xpath.compile(Patient.BIRTHTIME);
            XPathExpression maritalStatusQuery = xpath.compile(Patient.MARITALSTATUS);
            XPathExpression religiousQuery = xpath.compile(Patient.RELIGIOUS);
            XPathExpression guardianGivenNameQuery = xpath.compile(Patient.GUARDIAN_GIVEN_NAME);
            XPathExpression guardianFamilyNameQuery = xpath.compile(Patient.GUARDIAN_FAMILY_NAME);
            XPathExpression guardianStreetQuery = xpath.compile(Patient.GUARDIAN_STREET);
            XPathExpression guardianCityQuery = xpath.compile(Patient.GUARDIAN_CITY);
            XPathExpression guardianCountryQuery = xpath.compile(Patient.GUARDIAN_COUNTRY);
            XPathExpression guardianStateQuery = xpath.compile(Patient.GUARDIAN_STATE);
            XPathExpression guardianTelQuery = xpath.compile(Patient.GUARDIAN_TEL);

//            doc.getDocumentElement().normalize();


            for (int i = 0; i < patientNodes.getLength(); ++i) {
                Node patientNode = patientNodes.item(i);

                String prefixName = (String) prefixNameQuery.evaluate(patientNode,XPathConstants.STRING);
                String prefixName2 = (String) prefixNameQuery2.evaluate(patientNode,XPathConstants.STRING);
                String givenName = (String) givenNameQuery.evaluate(patientNode,XPathConstants.STRING);
                String givenName2 = (String) givenNameQuery2.evaluate(patientNode,XPathConstants.STRING);
                String familyName = (String) familyNameQuery.evaluate(patientNode,XPathConstants.STRING);
                String familyName2 = (String) familyNameQuery2.evaluate(patientNode,XPathConstants.STRING);
                String suffixName = (String) suffixNameQuery.evaluate(patientNode,XPathConstants.STRING);
                String suffixName2 = (String) suffixNameQuery2.evaluate(patientNode,XPathConstants.STRING);
                String street = (String) streetQuery.evaluate(patientNode, XPathConstants.STRING);
                String city = (String) cityQuery.evaluate(patientNode, XPathConstants.STRING);
                String country = (String) countryQuery.evaluate(patientNode, XPathConstants.STRING);
                String postal = (String) postalQuery.evaluate(patientNode, XPathConstants.STRING);
                String state = (String) stateQuery.evaluate(patientNode, XPathConstants.STRING);
                String id = (String) idQuery.evaluate(patientNode, XPathConstants.STRING);
                String socialId = (String) socialIdQuery.evaluate(patientNode, XPathConstants.STRING);
                String email = (String) emailQuery.evaluate(patientNode, XPathConstants.STRING);
                String tel = (String) telQuery.evaluate(patientNode, XPathConstants.STRING);
                String gender = (String) genderQuery.evaluate(patientNode, XPathConstants.STRING);
                String birthtime = (String) birthtimeQuery.evaluate(patientNode,XPathConstants.STRING);
                String birthPlace = (String) birthPlaceQuery.evaluate(patientNode, XPathConstants.STRING);
                String maritalStatus = (String) maritalStatusQuery.evaluate(patientNode, XPathConstants.STRING);
                String religiousStatus = (String) religiousQuery.evaluate(patientNode, XPathConstants.STRING);
                String guardianGivenName = (String) guardianGivenNameQuery.evaluate(patientNode, XPathConstants.STRING);
                String guardianFamilyName = (String) guardianFamilyNameQuery.evaluate(patientNode,XPathConstants.STRING);
                String guardianTel = (String) guardianTelQuery.evaluate(patientNode, XPathConstants.STRING);
                String guardianStreet = (String) guardianStreetQuery.evaluate(patientNode, XPathConstants.STRING);
                String guardianCity = (String) guardianCityQuery.evaluate(patientNode, XPathConstants.STRING);
                String guardianCountry = (String) guardianCountryQuery.evaluate(patientNode, XPathConstants.STRING);
                String guardianState = (String) guardianStateQuery.evaluate(patientNode, XPathConstants.STRING);


                Patient patient = new PatientBuilder()
                        .id(id).prefixName(prefixName).prefixName2(prefixName2).givenName(givenName).givenName2(givenName2).familyName(familyName)
                        .familyName2(familyName2).suffixName(suffixName).suffixName2(suffixName2).street(street).city(city).country(country)
                        .postal(postal).state(state).id(id).socialId(socialId).email(email).tel(tel).gender(gender).birthTime(birthtime)
                        .birthPlace(birthPlace).maritalStatus(maritalStatus).religion(religiousStatus).guardianGivenName(guardianGivenName)
                        .guardianFamilyName(guardianFamilyName).guardianTel(guardianTel).guardianStreet(guardianStreet).guardianCity(guardianCity)
                        .guardianCountry(guardianCountry).guardianState(guardianState)
                        .createPatient();
                patients.add(patient);

            }

            System.out.println("patient count = " + patients.size());
            printXml(patients);
        } catch (ParserConfigurationException | SAXException | XPathExpressionException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void printXml(ArrayList<Patient> patients) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        for (Patient patient : patients) {
            Element patientElement = doc.createElement("Patient");

            // ID
            Element id = doc.createElement("id");
            id.setAttribute("value", patient.getId());
            patientElement.appendChild(id);

            // Name
            Element name = doc.createElement("name");
            Element use = doc.createElement("use");
            use.setAttribute("value", patient.getPrefixName());
            Element family = doc.createElement("family");
            family.setAttribute("value", patient.getFamilyName());
            Element given1 = doc.createElement("given");
            given1.setAttribute("value", patient.getGivenName());
            Element given2 = doc.createElement("given");
            given2.setAttribute("value", patient.getGivenName2());

            name.appendChild(use);
            name.appendChild(family);
            name.appendChild(given1);
            name.appendChild(given2);
            patientElement.appendChild(name);

            //telecom
            Element telecom = doc.createElement("telecom");
            Element telSystem = doc.createElement("system");
            telSystem.setAttribute("value", "phone");
            Element telValue = doc.createElement("value");
            telValue.setAttribute("value", patient.getTel());
            Element telUse = doc.createElement("use");
            telUse.setAttribute("value", "work");

            telecom.appendChild(telSystem);
            telecom.appendChild(telValue);
            telecom.appendChild(telUse);
            patientElement.appendChild(telecom);

            //gender, birthday, deceasedBoolean
            Element gender = doc.createElement("gender");
            gender.setAttribute("value", patient.getGender());

            Element birthDate = doc.createElement("birthDate");
            birthDate.setAttribute("value", patient.getBirthTime());

            Element deceasedBoolean = doc.createElement("deceasedBoolean");
            deceasedBoolean.setAttribute("value", "False");

            patientElement.appendChild(gender);
            patientElement.appendChild(birthDate);

            //Address
            Element address = doc.createElement("address");
            Element addressUse = doc.createElement("use");
            addressUse.setAttribute("value", "home");
            Element addressLine = doc.createElement("line");
            addressLine.setAttribute("value", patient.getStreet());
            Element addressCity = doc.createElement("city");
            addressCity.setAttribute("value", patient.getCity());
            Element addressState = doc.createElement("state");
            addressState.setAttribute("value", patient.getState());
            Element addressPostal = doc.createElement("postal");
            addressPostal.setAttribute("value",patient.getPostal());

            address.appendChild(addressUse);
            address.appendChild(addressLine);
            address.appendChild(addressCity);
            address.appendChild(addressState);
            address.appendChild(addressPostal);
            patientElement.appendChild(address);






            doc.appendChild(patientElement);

        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("file.xml"));

        // Output to console for testing
        // StreamResult result = new StreamResult(System.out);

        transformer.transform(source, result);
    }

}
