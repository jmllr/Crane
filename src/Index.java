import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.junit.Test;
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

    /*
    * TODOs:
    * - Implement adding of a new snapshot
    * - Implement extracting of a snapshot information for a given ID
    * - Implement function which creates a folder with the given name
    * - Implement a function which copies files from one folder to another
    * - Implement JUNIT tests for all small functions
    *
    * */

    public int add(int a, int b) {
        return a + b;
    }

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
            Element snapshot = doc.createElement("Snapshot");
            Element ID = doc.createElement("ID");
            ID.appendChild(doc.createTextNode("4"));
            snapshot.appendChild(ID);
            Element TimeStamp = doc.createElement("TimeStamp");
            TimeStamp.appendChild(doc.createTextNode("2013-04-07"));
            snapshot.appendChild(TimeStamp);
            Element Commentar = doc.createElement("Commentar");
            Commentar.appendChild(doc.createTextNode("tu-tu-tu-tu"));
            snapshot.appendChild(Commentar);
            listOfSnapshots.appendChild(snapshot);

            //update an ID of a last snapshot

            Node lastID = doc.getElementsByTagName("LastID").item(0);
            lastID.setTextContent("4");



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

    public void extractInformation(String ident)  {

        try  {
            File xmlFile = new File("tests/index.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            //System.out.println("Snapshot " + ident + ":");
            NodeList IDList = doc.getElementsByTagName("ID");
            int flag = 0;
            for (int temp = 0; temp < IDList.getLength(); temp++) {
                if (ident.equals(IDList.item(temp).getTextContent()))   {

                    System.out.println("Snapshot " + ident + ":");
                         Node parentNode = IDList.item(temp).getParentNode();
                         NodeList nList = parentNode.getChildNodes();
                    for (int i = 0; i < nList.getLength(); i++) {
                      System.out.println(nList.item(i).getNodeName() + ": " + nList.item(i).getTextContent());
                        flag = 1;
                    }
                }

            }
            if (flag == 0)   {
                System.out.println("Snapshot with ID "+ ident + " doesn't exists");
            }

            //String ID = doc.getElementsByTagName("ID").item(1).getTextContent();

            //System.out.println(ID);

        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

}
