import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// http://www.mkyong.com/tutorials/java-xml-tutorials/

public class Index {

    public void readTestFile () {
         try {
             File xmlFile = new File("tests/index.xml");
             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
             DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
             Document doc = dBuilder.parse(xmlFile);
             doc.getDocumentElement().normalize();
             System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
             NodeList nList = doc.getElementsByTagName("Snapshot");
             System.out.println("----------------------------");
             for (int temp = 0; temp < nList.getLength(); temp++) {

                 Node nNode = nList.item(temp);

                 System.out.println("\nCurrent Element :" + nNode.getNodeName());

                 if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                     Element eElement = (Element) nNode;

                     System.out.println("ID : " + eElement.getElementsByTagName("ID").item(0).getTextContent());
                     System.out.println("TimeStamp : " + eElement.getElementsByTagName("TimeStamp").item(0).getTextContent());
                     System.out.println("Commentar : " + eElement.getElementsByTagName("Commentar").item(0).getTextContent());

                 }
             }



         }


         catch (Exception e) {
             e.printStackTrace();
         }
    }


    public void writeTestFile(){

        try {
            File xmlFile = new File("tests/index.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            Node listOfSnapshots = doc.getElementsByTagName("ListOfSnapshots").item(0);

            // append a new node to ListOfSnapshots
            Element test = doc.createElement("test");
            test.appendChild(doc.createTextNode("test"));
            listOfSnapshots.appendChild(test);


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("tests/index.xml"));
            transformer.transform(source, result);

            System.out.println("Done");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
