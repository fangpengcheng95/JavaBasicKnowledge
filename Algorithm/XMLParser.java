package com.fpc.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.ArrayUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser {
	public void getAllUserNames(String fileName) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		File file = new File(fileName);
		
		if ( file.exists() ) {
			Document doc = db.parse(file);
			Element docElement = doc.getDocumentElement();
			
			//Print root element of the document
			System.out.println("Root element of the document: " + docElement.getNodeName());
			
			NodeList studentList = docElement.getElementsByTagName("student");
			//Print total student elements in document
			System.out.println("Total students: " + studentList.getLength());
			
			if ( studentList != null && studentList.getLength() > 0 ) {
				for ( int i = 0 ; i < studentList.getLength() ; i++ ) {
					Node node = studentList.item(i);
					if ( node.getNodeType() == Node.ELEMENT_NODE ) {
						System.out.println("**********************************");
						Element element = (Element) node;
						NodeList nodeList = element.getElementsByTagName("name");
						System.out.println("Name : " + nodeList.item(0).getChildNodes().item(0).getNodeValue());
						
						nodeList = element.getElementsByTagName("grade");
						System.out.println("Grade : " + nodeList.item(0).getChildNodes().item(0).getNodeValue());
						
						nodeList = element.getElementsByTagName("age");
						System.out.println("Age : " + nodeList.item(0).getChildNodes().item(0).getNodeValue());
					} else {
						System.exit(1);
					}
				}
			}
		}
	}
	
	public static void main( String[] args )  {
		String[][] countries = { { "United States", "New York" }, { "United Kingdom", "London" },  
		        { "Netherland", "Amsterdam" }, { "Japan", "Tokyo" }, { "France", "Paris" } };  
		Map<Object, Object> countriesCapitical = ArrayUtils.toMap(countries);
		//traverse
		for ( Map.Entry<Object, Object> entry : countriesCapitical.entrySet()) {
			System.out.println(entry.getKey() + "   " + entry.getValue());
		}
		
	}
}
