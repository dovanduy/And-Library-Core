package com.rz.librarycore.database;

import android.content.Context;
import android.content.res.AssetManager;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XMLFeedParser {
    private Context context;
    private XmlPullParserFactory xmlFactoryObject;
    private XmlPullParser xmlPullParser;
    private InputStream inputStream;
    private String xmlFilePath;
    private boolean isXMLStringNull = false;

    public XMLFeedParser(Context argContext) {
        this.context = argContext;
        isXMLStringNull = false;
    }

    /**
     * Function used to fetch an XML file from assets folder
     *
     * @param argFileName - XML file name to convert it to String
     * @return - return XML in String form
     */
    public String onReadAssetsFile(String argFileName) {
        String xmlString = null;
        AssetManager assetManager = context.getAssets();
        try {
            InputStream inputStream = assetManager.open(argFileName);
            int length = inputStream.available();
            byte[] byteArray = new byte[length];
            inputStream.read(byteArray);
            inputStream.close();
            xmlString = new String(byteArray);
            //String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return xmlString;
        //https://itekblog.com/load-your-custom-xml-from-resources-android/
        //http://www.vogella.com/tutorials/AndroidXML/article.html
    }

    public XMLFeedParser onXMLPrepareItems(String argXMLString) {
        //String xmlString = onReadAssetsFile(argFileName);
        //System.out.println("XML_DATA: " + xmlString);
        if (isNullOrEmpty(argXMLString)) {
            isXMLStringNull = true;
            return this;
        }
        try {
            xmlFactoryObject = XmlPullParserFactory.newInstance();
            xmlPullParser = xmlFactoryObject.newPullParser();
            xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            //xmlPullParser.setInput(xmlString, null);
            InputStream inputStream = new ByteArrayInputStream(argXMLString.getBytes("UTF8"));
            xmlPullParser.setInput(inputStream, null);
            inputStream.close();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    //|------------------------------------------------------------|

    public List<Map<String, String>> getXMLParsedItems(List<String> argKeyList, String argItemStartingEndingTag) {
        int eventType;
        List<Map<String, String>> listXMLItems = new ArrayList<>();
        Map<String, String> mapXMLItem = new HashMap<>();
        if (isXMLStringNull) {
            return listXMLItems;
        }
        try {
            eventType = xmlPullParser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String xmlTagName = null;
                String TAG_XML_ITEM_STARTING_ENDING = argItemStartingEndingTag;
                //String name = argXmlPullParser.getName();
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        //products = new ArrayList();
                        listXMLItems.clear();
                        break;
                    case XmlPullParser.START_TAG:
                        xmlTagName = xmlPullParser.getName();
                        //LogWriter.Log("TAG_NAME: " + xmlTagName);
                        if (xmlTagName.equals(TAG_XML_ITEM_STARTING_ENDING)) {
                            mapXMLItem = new HashMap<>();
                        } else {
                            //int rid = resources.getIdentifier(packageName + ":raw/" + fileName, null, null);
                            //String key = argKeyList();
                            /*if (tagName.equals(TAG_XML_LAT)) {
                                strXmlText = argXmlPullParser.nextText();
                            }*/
                            //LogWriter.Log("TAG_NAME_OUTER: " + xmlTagName);
                            if (containsListKey(argKeyList, xmlTagName)) {
                                //LogWriter.Log("TAG_NAME_INNER: " + xmlTagName);
                                String strXmlText = xmlPullParser.nextText();
                                strXmlText = strXmlText.replaceAll("\\s+", " ").trim();
                                //For left trim:
                                strXmlText = strXmlText.replaceAll("^\\s+", "");
                                //For right trim:
                                strXmlText = strXmlText.replaceAll("\\s+$", "");
                                strXmlText = strXmlText.trim();
                                //LogWriter.Log("TAG_VALUE: ->" + strXmlText + "<-");
                                mapXMLItem.put(xmlTagName, strXmlText);
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        xmlTagName = xmlPullParser.getName();
                        if (xmlTagName.equalsIgnoreCase(TAG_XML_ITEM_STARTING_ENDING) && listXMLItems != null) {
                            listXMLItems.add(mapXMLItem);
                        }
                        break;
                }
                eventType = xmlPullParser.next();
            }
            //parsingComplete = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //printProducts(products);
            /*TextView txtView = (TextView) findViewById(R.id.textView1);
            txtView.setText("Name : " + a + "\nPrice : " + b + "\nDescription : "
                    + c + "\nCalories : " + d);*/
        //adapterLvTeam.notifyDataSetChanged();
        //this.taskHandelListener.setOnTaskEndListener(lstLocationPoints);
        return listXMLItems;
    }

    //|------------------------------------------------------------|
    public boolean containsListKey(List<String> argKeyList, String argSearchKey) {
        for (String item : argKeyList) {
            argSearchKey = argSearchKey.toLowerCase();
            if (item.trim().toLowerCase().contains(argSearchKey))
                return true;
        }
        return false;
    }

    //|------------------------------------------------------------|
    public String getXMLTagByAttributes(String argXMLString, String argXMLTag, String argXMLAttribute, String argXMLAttributeValue) {
        if (isNullOrEmpty(argXMLString)) {
            return null;
        }
        //https://stackoverflow.com/questions/11863038/how-to-get-the-attribute-value-of-an-xml-node-using-java
        InputSource inputSource = new InputSource(new StringReader(argXMLString));
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setCoalescing(true);
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputSource);
            NodeList nodeList = document.getElementsByTagName(argXMLTag); //drawer_menu_group
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node currentItem = nodeList.item(i);
                String key = currentItem.getAttributes().getNamedItem(argXMLAttribute).getNodeValue(); //category
                //System.out.println(key);
                if (key.equalsIgnoreCase(argXMLAttributeValue)) { //App Self System
                    //System.out.println("NODE: " + currentItem.toString());
                    return getNodeToXMLString(currentItem);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //|------------------------------------------------------------|
    private String getNodeListToXMLString(NodeList argNodeList) {
        NodeList nodeList = argNodeList;
        DOMSource domSource = new DOMSource();
        StringWriter stringWriter = new StringWriter();
        StreamResult streamResult = new StreamResult(stringWriter);
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            //transformer.transform(new DOMSource(nodeList), new StreamResult(stringWriter));
            //serializer.transform(new DOMSource(soaphead.item(0)), new StreamResult(sw));
            for (int i = 0; i < nodeList.getLength(); ++i) {
                domSource.setNode(nodeList.item(i));
                transformer.transform(domSource, streamResult);
            }
            /*String result = stringWriter.toString();
            System.out.println("XML_DATA: " + result);*/
            return stringWriter.toString();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getNodeToXMLString(Node argNode) {
        Node node = argNode;
        DOMSource domSource = new DOMSource();
        StringWriter stringWriter = new StringWriter();
        StreamResult streamResult = new StreamResult(stringWriter);
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            //transformer.transform(new DOMSource(nodeList), new StreamResult(stringWriter));
            //serializer.transform(new DOMSource(soaphead.item(0)), new StreamResult(sw));
            transformer.transform(new DOMSource(node), new StreamResult(stringWriter));
            /*for (int i = 0; i < nodeList.getLength(); ++i) {
                domSource.setNode(nodeList.item(i));
                transformer.transform(domSource, streamResult);
            }*/
            //String result = stringWriter.toString();
            //System.out.println("XML_DATA: " + result);
            return stringWriter.toString();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }

    //|------------------------------------------------------------|
    public static boolean isNullOrEmpty(String argValue) {
        if (argValue == null) {
            return true;
        }
        if (argValue.trim().isEmpty()) {
            return true;
        }
        if (argValue.equalsIgnoreCase("null")) {
            return true;
        }
        return false;
    }

    //|------------------------------------------------------------|
    public void onDocumentBuilderFactory(String argXmlString) {
        //https://stackoverflow.com/questions/14236767/sax-parsing-how-to-fetch-child-nodes
        InputSource inputSource = new InputSource(new StringReader(argXmlString));
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setCoalescing(true);
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputSource);
            NodeList nodeList = document.getElementsByTagName("drawer_menu_group");
            DOMSource domSource = new DOMSource();
            StringWriter stringWriter = new StringWriter();
            StreamResult streamResult = new StreamResult(stringWriter);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            //transformer.transform(new DOMSource(nodeList), new StreamResult(stringWriter));
            //serializer.transform(new DOMSource(soaphead.item(0)), new StreamResult(sw));
            for (int i = 0; i < nodeList.getLength(); ++i) {
                domSource.setNode(nodeList.item(i));
                transformer.transform(domSource, streamResult);
            }
            String result = stringWriter.toString();
            System.out.println("XML_DATA: " + result);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
    //|------------------------------------------------------------|
}


/*
<?xml version="1.0" encoding="utf-8"?>
<word_book_arabic_to_bangal>
    <word_list subjective_category="BANK_MANAGER">
        <word_item>
            <audio_file>amake_bolun</audio_file>
            <main_word>আমাকে দেখুন</main_word>
            <secondary_word>(কুললি)</secondary_word>
        </word_item>
        <word_item>
            <audio_file>apnar_vai_acen_ki</audio_file>
            <main_word>আপনার ভাই আছেন কি?</main_word>
            <secondary_word>(হাল আখুকা মাওজুদ)</secondary_word>
        </word_item>
    </word_list>
    <word_list subjective_category="PASSPORT_OFFICE">
        <word_item>
            <audio_file>amake_bolun</audio_file>
            <main_word>করিম কোথায় যাচ্ছ</main_word>
            <secondary_word>(আইনা তাযহাবু, ইয়া করিম)</secondary_word>
        </word_item>
        <word_item>
            <audio_file>amake_bolun</audio_file>
            <main_word>পাসপোর্ট অফিসে যাচ্ছি</main_word>
            <secondary_word>(ইলা মাকতাবেল জাওয়ায)</secondary_word>
        </word_item>
    </word_list>
</word_book_arabic_to_bangal>
XMLFeedParser xmlFeedParser = new XMLFeedParser(context);
String xmlStr = xmlFeedParser.onReadAssetsFile("db_dir/word_book_arabic_to_bangal.xml");
String xmlTag = "word_list";
String xmlAttr = "subjective_category";
String xmlAttrValue = "BANK_MANAGER";
xmlStr = xmlFeedParser.getXMLTagByAttributes(xmlStr, xmlTag, xmlAttr, xmlAttrValue);
List<String> listXMLTags = new ArrayList<>();
listXMLTags.add("audio_file");
listXMLTags.add("main_word");
listXMLTags.add("secondary_word");
String xmlItemStartingTag = "word_item";
List<Map<String, String>> listItems = xmlFeedParser.onXMLPrepareItems(xmlStr)
        .getXMLParsedItems(listXMLTags, xmlItemStartingTag);
for (Map<String, String> listItem : listItems) {
    for (Map.Entry<String, String> entry : listItem.entrySet()) {
        String key = entry.getKey();
        String value = entry.getValue();
        System.out.println("XML_KEY: " + key + " - VALUE: " + value);
    }
}
*/