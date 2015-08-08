import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Anar on 8/8/15.
 */
public class PatientMigrationHapi {
    public static void main(String[] args) {

        FhirContext context = FhirContext.forDstu2();
        //fhir context - most important thing for manipulating FHIR ressource data


        try {

            //genau das selbe wie beim PatientMigration class, es werden xpath queries erstellt damit man von XML daten kriegt
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("/Users/Anar/IdeaProjects/DraftBachelor/ELGA-e-Medikation_5-Medikationsliste.xml"));
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();
            XPathExpression query = xpath.compile(resource.Patient.ROOT);
            NodeList patientNodes = (NodeList) query.evaluate(doc, XPathConstants.NODESET);
            System.out.println("count  = " + patientNodes.getLength());
           // ArrayList<Patient> patients = new ArrayList<>();


            XPathExpression prefixNameQuery = xpath.compile(resource.Patient.NAME_PREFIX);
            XPathExpression prefixNameQuery2 = xpath.compile(resource.Patient.NAME_PREFIX2);
            XPathExpression givenNameQuery = xpath.compile(resource.Patient.NAME_GIVEN);
            XPathExpression givenNameQuery2 = xpath.compile(resource.Patient.NAME_GIVEN2);
            XPathExpression familyNameQuery = xpath.compile(resource.Patient.NAME_FAMILY);
            XPathExpression familyNameQuery2 = xpath.compile(resource.Patient.NAME_FAMILY2);
            XPathExpression suffixNameQuery = xpath.compile(resource.Patient.NAME_SUFFIX);
            XPathExpression suffixNameQuery2 = xpath.compile(resource.Patient.NAME_SUFFIX2);
            XPathExpression streetQuery = xpath.compile(resource.Patient.STREET);
            XPathExpression cityQuery = xpath.compile(resource.Patient.CITY);
            XPathExpression postalQuery = xpath.compile(resource.Patient.POSTAL);
            XPathExpression countryQuery = xpath.compile(resource.Patient.COUNTRY);
            XPathExpression stateQuery = xpath.compile(resource.Patient.STATE);
            XPathExpression idQuery = xpath.compile(resource.Patient.ID);
            XPathExpression socialIdQuery = xpath.compile(resource.Patient.SOCIAL_ID);
            XPathExpression telQuery = xpath.compile(resource.Patient.TEL);
            XPathExpression emailQuery = xpath.compile(resource.Patient.EMAIL);
            XPathExpression genderQuery = xpath.compile(resource.Patient.GENDER);
            XPathExpression birthPlaceQuery = xpath.compile(resource.Patient.BIRTH_PLACE);
            XPathExpression birthtimeQuery = xpath.compile(resource.Patient.BIRTHTIME);
            XPathExpression maritalStatusQuery = xpath.compile(resource.Patient.MARITALSTATUS);
            XPathExpression religiousQuery = xpath.compile(resource.Patient.RELIGIOUS);
            XPathExpression guardianGivenNameQuery = xpath.compile(resource.Patient.GUARDIAN_GIVEN_NAME);
            XPathExpression guardianFamilyNameQuery = xpath.compile(resource.Patient.GUARDIAN_FAMILY_NAME);
            XPathExpression guardianStreetQuery = xpath.compile(resource.Patient.GUARDIAN_STREET);
            XPathExpression guardianCityQuery = xpath.compile(resource.Patient.GUARDIAN_CITY);
            XPathExpression guardianCountryQuery = xpath.compile(resource.Patient.GUARDIAN_COUNTRY);
            XPathExpression guardianStateQuery = xpath.compile(resource.Patient.GUARDIAN_STATE);
            XPathExpression guardianTelQuery = xpath.compile(resource.Patient.GUARDIAN_TEL);

//            doc.getDocumentElement().normalize();

//daten werden extrahiert
            for (int i = 0; i < patientNodes.getLength(); ++i) {
                Node patientNode = patientNodes.item(i);

                String prefixName = (String) prefixNameQuery.evaluate(patientNode, XPathConstants.STRING);
                String prefixName2 = (String) prefixNameQuery2.evaluate(patientNode, XPathConstants.STRING);
                String givenName = (String) givenNameQuery.evaluate(patientNode, XPathConstants.STRING);
                String givenName2 = (String) givenNameQuery2.evaluate(patientNode, XPathConstants.STRING);
                String familyName = (String) familyNameQuery.evaluate(patientNode, XPathConstants.STRING);
                String familyName2 = (String) familyNameQuery2.evaluate(patientNode, XPathConstants.STRING);
                String suffixName = (String) suffixNameQuery.evaluate(patientNode, XPathConstants.STRING);
                String suffixName2 = (String) suffixNameQuery2.evaluate(patientNode, XPathConstants.STRING);
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
                String birthTime = (String) birthtimeQuery.evaluate(patientNode, XPathConstants.STRING);
                String birthPlace = (String) birthPlaceQuery.evaluate(patientNode, XPathConstants.STRING);
                String maritalStatus = (String) maritalStatusQuery.evaluate(patientNode, XPathConstants.STRING);
                String religiousStatus = (String) religiousQuery.evaluate(patientNode, XPathConstants.STRING);
                String guardianGivenName = (String) guardianGivenNameQuery.evaluate(patientNode, XPathConstants.STRING);
                String guardianFamilyName = (String) guardianFamilyNameQuery.evaluate(patientNode, XPathConstants.STRING);
                String guardianTel = (String) guardianTelQuery.evaluate(patientNode, XPathConstants.STRING);
                String guardianStreet = (String) guardianStreetQuery.evaluate(patientNode, XPathConstants.STRING);
                String guardianCity = (String) guardianCityQuery.evaluate(patientNode, XPathConstants.STRING);
                String guardianCountry = (String) guardianCountryQuery.evaluate(patientNode, XPathConstants.STRING);
                String guardianState = (String) guardianStateQuery.evaluate(patientNode, XPathConstants.STRING);

                //patient FHIR ressource wird erstellt
                Patient patient = new Patient();
                patient.addName().addFamily(familyName).addPrefix(prefixName).addGiven(givenName).addSuffix(suffixName);
                patient.addAddress().setCity(city).setPostalCode(postal).addLine(street).setCountry(country).setState(state);

                //kann sowohl als xml als auch als json encodet werden
                System.out.println(context.newXmlParser().encodeResourceToString(patient));//xml
                //System.out.println(context.newJsonParser().encodeResourceToString(patient)); //json

                // medication ressource sample
                // Medication medication = new Medication();
            }
        } catch (ParserConfigurationException | SAXException | XPathExpressionException | IOException e) {
            e.printStackTrace();
        }
    }
}
