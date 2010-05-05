import javax.xml.parsers.*;
import java.io.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ValidateXML {
  public static void main(String[] args)
      throws ParserConfigurationException, IOException, SAXException {
    DocumentBuilderFactory dbFactory =
      DocumentBuilderFactory.newInstance();
    dbFactory.setValidating(true);
    dbFactory.setIgnoringElementContentWhitespace(true);
    DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
    File file = new File("listing12_6.xml");
    Document document = docBuilder.parse(file);
  }
}
