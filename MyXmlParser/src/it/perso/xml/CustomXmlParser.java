package it.perso.xml;

import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class CustomXmlParser {
	
	private static String xmlString = 
            "<root>"
             +"<friendly>Hello, I'm friendly</friendly>"
             +"<url>http://localhost</url>"
           +"</root>";
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 String value = getXMLTagValue("friendly");
		    System.out.println(" getXMLTagValue ('friendly') : " + value);

		    String out = getXMLTagValueImproved("friendly");
		    System.out.println( " getXMLTagValueImproved('friendly') : " + out);
		    
		    String ret = getTag(xmlString, "friendly");
		    System.out.println( " getTag('friendly') : " + ret);
		    
		    
	}
	
	public static String getXMLTagValue(String tagName)
	{
	    String openTag = "<" + tagName + ">";
	    String closeTag = "</" + tagName + ">";
	    Pattern pattern = Pattern.compile(openTag + "(.*?)" + closeTag);
	    Matcher matcher = pattern.matcher(xmlString);
	    while (matcher.find())
	    {
	        return matcher.group().replaceAll(openTag, "").replace(closeTag, "");
	    }
	    return "N/A";
	}

	public static String getXMLTagValueImproved(String tagName) throws Exception {

	     InputSource is = new InputSource(new StringReader(xmlString));  
	     DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	     DocumentBuilder  dBuilder = dbFactory.newDocumentBuilder();;
	     Document  doc = dBuilder.parse(is);    
	     NodeList nl = doc.getDocumentElement().getElementsByTagName(tagName);
	    return nl.getLength() > 0 ? nl.item(0).getTextContent() : "N/A" ;
	}
	
	private static String getTag(String paramString1, String paramString2) {
	    int i = paramString2.length();
	    int j = paramString1.indexOf("<" + paramString2);
	    int k = j != -1 ? paramString1.indexOf(">", j) : -1;
	    int m = paramString1.indexOf("</" + paramString2 + ">");
	    if ((k == -1) || (m == -1)) {
	      return "";
	    }
	    return paramString1.substring(k + 1, m);
	  }

}
