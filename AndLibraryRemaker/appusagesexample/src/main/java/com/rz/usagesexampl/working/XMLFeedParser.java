package com.rz.usagesexampl.working;

import android.content.Context;

import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class XMLFeedParser {
    private C0368b f1115b;

    public XMLFeedParser(Context argContext) {
        this.f1115b = new C0368b(argContext);
    }

    public String onReadAssetsFile(String argFileName) throws IOException {
        return this.f1115b.m1399a(argFileName);
    }

    public XMLFeedParser onXMLPrepareItems(String argXMLString) throws IOException, XmlPullParserException {
        this.f1115b.m1402b(argXMLString);
        return this;
    }

    public List<Map<String, String>> getXMLParsedItems(List<String> argKeyList, String argItemStartingEndingTag) throws Exception {
        return this.f1115b.m1401a(argKeyList, argItemStartingEndingTag);
    }

    public String getXMLTagByAttributes(String argXMLString, String argXMLTag, String argXMLAttribute, String argXMLAttributeValue) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        return this.f1115b.m1400a(argXMLString, argXMLTag, argXMLAttribute, argXMLAttributeValue);
    }
}
