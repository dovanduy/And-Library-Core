package com.rz.usagesexampl.working;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

import com.rz.usagesexampl.ActTestTwo;
import com.rz.usagesexampl.done.jxml.XMLFeedParser;
import com.rz.usagesexampl.done.log.LogWriter;
import com.rz.usagesexampl.done.redirect.RedirectWindow;
import com.rz.usagesexampl.done.jxml.JSONFastParser;

import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

public class Separator {
    private Activity activity;
    private Context context;
    private String CLASS_NAME = this.getClass().getName();
    private boolean isDependencyWait = false;

    public Separator(Activity argActivity, Context argContext) {
        activity = argActivity;
        context = argContext;
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

    private void onLog() {
        String TAG = "TEST_TAG";
        LogWriter.isDebug = true;
        LogWriter.Log("Test log log");
        LogWriter.Log(TAG, "Test log log");
        LogWriter.dLog("Test log d");
        LogWriter.dLog(TAG, "Test log d");
        LogWriter.eLog("Test log e");
        LogWriter.eLog(TAG, "Test log e");
        LogWriter.iLog("Test log i");
        LogWriter.iLog(TAG, "Test log i");
        LogWriter.vLog("Test log v");
        LogWriter.vLog(TAG, "Test log v");
        LogWriter.wtfLog("Test log wtf");
        LogWriter.wtfLog(TAG, "Test log wtf");
        LogWriter.isDebug = true;
        LogWriter.Write.Log(CLASS_NAME, "Test log log");
        LogWriter.Write.Log(CLASS_NAME, TAG, "Test log log");
        LogWriter.Write.dLog(CLASS_NAME, "Test log d");
        LogWriter.Write.dLog(CLASS_NAME, TAG, "Test log d");
        LogWriter.Write.eLog(CLASS_NAME, "Test log e");
        LogWriter.Write.eLog(CLASS_NAME, TAG, "Test log e");
        LogWriter.Write.iLog(CLASS_NAME, "Test log i");
        LogWriter.Write.iLog(CLASS_NAME, TAG, "Test log i");
        LogWriter.Write.vLog(CLASS_NAME, "Test log v");
        LogWriter.Write.vLog(CLASS_NAME, TAG, "Test log v");
        LogWriter.Write.wtfLog(CLASS_NAME, "Test log wtf");
        LogWriter.Write.wtfLog(CLASS_NAME, TAG, "Test log wtf");
    }

    private void onRedirectWindow() {
        Bundle bundle = new Bundle();
        /*RedirectWindow redirectWindow = RedirectWindow.getInstance(activity, context);
        redirectWindow.withBundle(bundle)
                .withFlag()
                .disposeWindow()
                .run(ActTestTwo.class, 5000);*/
        RedirectWindow redirectWindow = RedirectWindow.getInstance(activity, context);
        redirectWindow.withBundle(bundle)
                .withFlag()
                .disposeWindow()
                .run(ActTestTwo.class);
        redirectWindow.withBundle(bundle)
                .withFlag()
                .disposeWindow()
                .run(ActTestTwo.class, 5000);
        redirectWindow.withBundle(bundle)
                .withFlag()
                .disposeWindow()
                .run(ActTestTwo.class, 5000, new RedirectWindow.OnEventListener() {
                    @Override
                    public boolean onDependencyWait() {
                        return isDependencyWait;
                    }
                });
        new Handler().postDelayed(new Runnable() {
            public void run() {
                isDependencyWait = true;
            }
        }, 10000);
    }
}
