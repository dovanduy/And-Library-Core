package com.library.utils;

import android.content.Context;
import android.content.res.AssetManager;

import com.rz.librarycore.log.LogWriter;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public class ReadLocalXML {
    private Context context;
    private XmlPullParserFactory xmlFactoryObject;
    private XmlPullParser xmlPullParser;
    private InputStream inputStream;
    private String xmlFilePath;

    public ReadLocalXML(Context argContext) {
        this.context = argContext;
    }

    public ReadLocalXML getAssetsXML(String argFileName) {
        String xmlString = onReadAssetsXML(argFileName);
        //LogWriter.Log("XML_DATA: " + xmlString);
        if (xmlString == null) {
            return this;
        }
        try {
            xmlFactoryObject = XmlPullParserFactory.newInstance();
            xmlPullParser = xmlFactoryObject.newPullParser();
            xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            //xmlPullParser.setInput(xmlString, null);
            InputStream inputStream = new ByteArrayInputStream(xmlString.getBytes("UTF8"));
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

    /**
     * Function used to fetch an XML file from assets folder
     *
     * @param argFileName - XML file name to convert it to String
     * @return - return XML in String form
     */
    private String onReadAssetsXML(String argFileName) {
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

    //|------------------------------------------------------------|
    public List<Map<String, String>> getXMLParsedItems(List<String> argKeyList, String argItemStartingEndingTag) {
        int eventType;
        List<Map<String, String>> listXMLItems = new ArrayList<>();
        Map<String, String> mapXMLItem = new HashMap<>();
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
}
//https://stackoverflow.com/questions/604424/how-to-get-an-enum-value-from-a-string-value-in-java
/*ReadLocalXML readLocalXML = new ReadLocalXML(context);
readLocalXML.getAssetsXML("app_settings/drawer_menu_manager.xml");
List<Map<String, String>> listItems = readLocalXML.getXMLParsedItems(listXMLTags, xmlItemStartingTag);
for (Map<String, String> map : listItems) {
    NavDrawerMenuTypes.MENU_TYPE menuType = null;
    NavDrawerMenuTypes.MENU_POSITION menuPosition = null;
    int menuIconId = 0;
    String xmlFormLabel = null;
    String xmlFormLabelTemp = null;
    boolean isMenuHeader = false;
    for (Map.Entry<String, String> entry : map.entrySet()) {
        String key = entry.getKey();
        String value = entry.getValue();
        if (key.equalsIgnoreCase("menu_typ")) {
            menuType = NavDrawerMenuTypes.MENU_TYPE.valueOf(value);
        } else if (key.equalsIgnoreCase("menu_icon")) {
            menuIconId = Utils.getDrawableId(context, value);
        } else if (key.equalsIgnoreCase("menu_label_text")) {
            if (!Utils.isNullOrEmpty(value)) {
                xmlFormLabel = value;
            }
        } else if (key.equalsIgnoreCase("menu_label_text_temp")) {
            if (!Utils.isNullOrEmpty(value)) {
                xmlFormLabelTemp = value;
            }
        } else if (key.equalsIgnoreCase("menu_position")) {
            menuPosition = NavDrawerMenuTypes.MENU_POSITION.valueOf(value);
        } else if (key.equalsIgnoreCase("menu_is_header")) {
            isMenuHeader = false;
            if (value.equalsIgnoreCase("true")) {
                isMenuHeader = true;
            }
        }
    }
    if (!Utils.isNullOrEmpty(xmlFormLabel)) {
        formLabel = UserSession.appSysLang.getValue(UserSession.appSysLangName, xmlFormLabel);
    } else {
        if (!Utils.isNullOrEmpty(xmlFormLabelTemp)) {
            formLabel = xmlFormLabelTemp;
        } else {
            formLabel = "Not found";
        }
    }
    LogWriter.Log("formLabel: >" + formLabel + "<");
    drawerItem = new ModelNavDrawerItem(menuType, menuIconId, formLabel, menuPosition, isMenuHeader);
    argModelDrawerItems.add(drawerItem);
}*/