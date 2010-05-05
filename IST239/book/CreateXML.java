import javax.xml.parsers.*;
import java.io.*;
import java.util.*;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.Document;
import org.w3c.dom.Comment;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.ls.LSSerializer;

public class CreateXML {
  public static void main(String[] args) throws
      ParserConfigurationException, IOException {
    DocumentBuilderFactory dbFactory =
      DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
    Document document = docBuilder.newDocument();

    // Create a comment
    Comment comment = document.createComment("XML document for books");
    document.appendChild(comment);

    // Create the books element as the root
    Element booksElement = document.createElement("books");
    document.appendChild(booksElement);

    // Create elements for the first book
    Element bookElement = document.createElement("book");
    bookElement.setAttribute("num", "1");
    Element titleElement = document.createElement("title");
    Text titleText = document.createTextNode("Java Programming");
    Element publisherElement = document.createElement("publisher");
    Text publisherText = document.createTextNode("Prentice Hall");

    // Add elements for the first book
    booksElement.appendChild(bookElement);
    bookElement.appendChild(titleElement);
    titleElement.appendChild(titleText);
    bookElement.appendChild(publisherElement);
    publisherElement.appendChild(publisherText);

    // Create elements for the second book
    Element bookElement2 = document.createElement("book");
    bookElement2.setAttribute("num", "2");
    Element titleElement2 = document.createElement("title");
    Text titleText2 = document.createTextNode("Java Programming");
    Element publisherElement2 = document.createElement("publisher");
    Text publisherText2 = document.createTextNode("Prentice Hall");

    // Add elements for the second book
    booksElement.appendChild(bookElement2);
    bookElement2.appendChild(titleElement2);
    titleElement2.appendChild(titleText2);
    bookElement2.appendChild(publisherElement2);
    publisherElement2.appendChild(publisherText2);

    // Serialize a DOM document to an XML as a string
    DOMImplementation impl = document.getImplementation();
    DOMImplementationLS implLS =
      (DOMImplementationLS) impl.getFeature("LS", "3.0");
    LSSerializer serializer = implLS.createLSSerializer();
    String out = serializer.writeToString(document);
    System.out.println(out);

    // Write XML to a text file
    Formatter output = new Formatter("temp.xml");
    output.format("%s", out);
    output.close();
  }
}
