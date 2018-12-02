package com.rz.usagesexampl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rz.usagesexampl.done.jxml.XMLFeedParser;
import com.rz.usagesexampl.working.utils.AppUtils;

import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;


public class ActSplash extends AppCompatActivity {
    private Activity activity;
    private Context context;
    private String CLASS_NAME;
    private boolean isDependencyWait = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);
        activity = this;
        context = this;
        CLASS_NAME = this.getClass().getName();
        try {
            onReadXML(context);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void onReadXML(Context argContext) throws IOException, ParserConfigurationException, SAXException, XmlPullParserException, Exception {
        /*try {
            onReadXML(context);
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/
        XMLFeedParser xmlFeedParser = new XMLFeedParser(argContext);
        String xmlStr = xmlFeedParser.onReadAssetsFile("db_dir/test.xml");
        //|------------------------------------------------------------|
        //|------------------------------------------------------------|
        /*List<String> listXMLTagsTemp = new ArrayList<>();
        listXMLTagsTemp.add("audio_file");
        listXMLTagsTemp.add("main_word");
        listXMLTagsTemp.add("secondary_word");
        String xmlItemStartingTagTemp = "word_item";*/
        List<Map<String, String>> listItemsTemp = xmlFeedParser.withTag("audio_file")
                .withTag("main_word")
                .withTag("secondary_word")
                .withAttribute("length")
                .withAttribute("section")
                .onXMLPrepareItems(xmlStr)
                .getXMLParsedItems("word_item");
        List<Map<String, String>> listItemsAttr = xmlFeedParser.getAttributeItems();
        System.out.println("XML_TAG_LIST: " + listItemsTemp);
        System.out.println("XML_ATTR_LIST: " + listItemsAttr);
        //|------------------------------------------------------------|
        //|------------------------------------------------------------|
        List<String> listXMLTagsTemp = new ArrayList<>();
        listXMLTagsTemp.add("audio_file");
        listXMLTagsTemp.add("main_word");
        listXMLTagsTemp.add("secondary_word");
        String xmlItemStartingTagTemp = "word_item";
        List<Map<String, String>> listItemsTemp01 = xmlFeedParser.onXMLPrepareItems(xmlStr)
                .getXMLParsedItems(listXMLTagsTemp, xmlItemStartingTagTemp);
        System.out.println("XML_TAG_LIST: " + listItemsTemp01);
        //|------------------------------------------------------------|
        //|------------------------------------------------------------|
        //System.out.println("INIT_VALUE: " + xmlStr);
        String xmlTag = "word_list";
        String xmlAttr = "subjective_category";
        String xmlAttrValue = "BANK_MANAGER";
        xmlStr = xmlFeedParser.getXMLByTagAttribute(xmlStr, xmlTag, xmlAttr, xmlAttrValue);
        //System.out.println("ATTRIBUTE_VALUE: " + xmlStr);
        List<String> listXMLTags = new ArrayList<>();
        listXMLTags.add("audio_file");
        listXMLTags.add("main_word");
        listXMLTags.add("secondary_word");
        String xmlItemStartingTag = "word_item";
        List<Map<String, String>> listItems = xmlFeedParser.onXMLPrepareItems(xmlStr)
                .getXMLParsedItems(listXMLTags, xmlItemStartingTag);
        System.out.println("LIST: " + listItems.toString());
        for (Map<String, String> listItem : listItems) {
            for (Map.Entry<String, String> entry : listItem.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                System.out.println("XML_KEY: " + key + " - VALUE: " + value);
            }
        }
    }

    private void onAppUtils() {
        AppUtils.getAppVersion(context);
        AppUtils.getAppVersionCode(context);
        AppUtils.logDebug("TAG", "MESSAGE");
        AppUtils.getDisplaySize(context);
        AppUtils.isURLAvailable("URL");
    }
}
//https://github.com/bintray/gradle-bintray-plugin/issues/88
//https://stackoverflow.com/questions/33668021/bintray-unable-to-upload-files-maven-group-artifact-or-version-defined-in-the
//https://www.petrikainulainen.net/programming/gradle/getting-started-with-gradle-creating-a-multi-project-build/
//https://docs.gradle.org/current/userguide/maven_plugin.html
//https://stackoverflow.com/questions/45078381/gradle-library-with-multiple-modules
