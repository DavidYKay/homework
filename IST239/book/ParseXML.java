import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ParseXML {
  public static void main(String[] args)
      throws ParserConfigurationException, IOException, SAXException,
             XPathExpressionException {
    DocumentBuilderFactory dbFactory =
      DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();

    File file = new File("listing12_1.xml");
    Document document = docBuilder.parse(file);

    XPathFactory xpFactory = XPathFactory.newInstance();
    XPath xPath = xpFactory.newXPath();

    int numberOfStudents = Integer.parseInt(xPath.evaluate(
      "count(/students/student)", document));

    for (int i = 1; i <= numberOfStudents; i++) {
      System.out.println("Student " + i + ": ");
      System.out.println("\tSSN: " + xPath.evaluate(
        "/students/student[" + i + "]/ssn", document));
      System.out.println("\tName: " + xPath.evaluate(
        "/students/student[" + i + "]/firstname", document) + " " +
        xPath.evaluate("/students/student[" + i + "]/mi", document) +
        " " + xPath.evaluate("/students/student[" + i + "]/lastname",
        document));
      System.out.println("\tBirthdate: " + xPath.evaluate(
        "/students/student[" + i + "]/birthdate", document));
      System.out.println("\tAddress: " + xPath.evaluate(
        "/students/student[" + i + "]/street", document));
      System.out.println("\tZip: " + xPath.evaluate(
        "/students/student[" + i + "]/zipcode", document));
      System.out.println("\tPhone: " + xPath.evaluate(
        "/students/student[" + i + "]/phone", document));
    }
  }
}
