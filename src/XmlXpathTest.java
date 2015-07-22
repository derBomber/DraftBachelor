
    import java.io.FileInputStream;

    import javax.xml.parsers.SAXParser;
    import javax.xml.parsers.SAXParserFactory;

    import org.xml.sax.InputSource;
    import org.xml.sax.XMLReader;

    public class XmlXpathTest {

        public static void main(String[] args) throws Exception {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            XMLReader xr = sp.getXMLReader();

            xr.setContentHandler(new FragmentContentHandler(xr));
            xr.parse(new InputSource(new FileInputStream("ELGA-e-Medikation_5-Medikationsliste.xml")));
        }
    }


