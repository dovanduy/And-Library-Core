package com.rz.usagesexampl.working;

import android.content.Context;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

class C0368b {
    private Context f1108a;
    private XmlPullParserFactory f1109b;
    private XmlPullParser f1110c;
    private boolean f1111d = false;

    public C0368b(Context context) {
        this.f1108a = context;
        this.f1111d = false;
    }

    protected String m1399a(String str) throws IOException {
        try {
            InputStream open = this.f1108a.getAssets().open(str);
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return new String(bArr);
        } catch (IOException ex) {
            throw ex;
        }
    }

    protected C0368b m1402b(String str) throws XmlPullParserException, UnsupportedEncodingException, IOException {
        if (C0368b.m1398c(str)) {
            this.f1111d = true;
            return this;
        }
        try {
            this.f1109b = XmlPullParserFactory.newInstance();
            this.f1110c = this.f1109b.newPullParser();
            this.f1110c.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            InputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF8"));
            this.f1110c.setInput(byteArrayInputStream, null);
            byteArrayInputStream.close();
            return this;
        } catch (XmlPullParserException ex) {
            throw ex;
        } catch (UnsupportedEncodingException ex) {
            throw ex;
        } catch (IOException ex) {
            throw ex;
        }
    }

    protected List<Map<String, String>> m1401a(List<String> list, String str) throws Exception {
        List<Map<String, String>> arrayList = new ArrayList();
        Map hashMap = new HashMap();
        if (this.f1111d) {
            return arrayList;
        }
        try {
            int eventType = this.f1110c.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType != 0) {
                    switch (eventType) {
                        case XmlPullParser.START_DOCUMENT:
                            arrayList.clear();
                            break;
                        case XmlPullParser.START_TAG:
                            String name = this.f1110c.getName();
                            if (!name.equals(str)) {
                                if (m1397b(list, name)) {
                                    hashMap.put(name, this.f1110c.nextText().replaceAll("\\s+", " ").trim().replaceAll("^\\s+", "").replaceAll("\\s+$", "").trim());
                                    break;
                                }
                            }
                            hashMap = new HashMap();
                            break;
                        case XmlPullParser.END_TAG:
                            if (this.f1110c.getName().equalsIgnoreCase(str)) {
                                arrayList.add(hashMap);
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                }
                eventType = this.f1110c.next();
            }
            return arrayList;
        } catch (Exception ex) {
            throw ex;
        }
    }

    protected String m1400a(String str, String str2, String str3, String str4) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        if (C0368b.m1398c(str)) {
            return null;
        }
        InputSource inputSource = new InputSource(new StringReader(str));
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setCoalescing(true);
        try {
            NodeList elementsByTagName = newInstance.newDocumentBuilder().parse(inputSource).getElementsByTagName(str2);
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                Node item = elementsByTagName.item(i);
                if (item.getAttributes().getNamedItem(str3).getNodeValue().equalsIgnoreCase(str4)) {
                    return m1396a(item);
                }
            }
        } catch (ParserConfigurationException ex) {
            throw ex;
        } catch (SAXException ex) {
            throw ex;
        } catch (IOException ex) {
            throw ex;
        }
        return null;
    }

    private String m1396a(Node node) throws TransformerConfigurationException, TransformerException {
        DOMSource dOMSource = new DOMSource();
        Writer stringWriter = new StringWriter();
        StreamResult streamResult = new StreamResult(stringWriter);
        try {
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            newTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
            newTransformer.transform(new DOMSource(node), new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (TransformerConfigurationException ex) {
            throw ex;
        } catch (TransformerException ex) {
            throw ex;
        }
    }

    private boolean m1397b(List<String> list, String str) {
        for (String str2 : list) {
            str = str.toLowerCase();
            if (str2.trim().toLowerCase().contains(str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean m1398c(String str) {
        if (str == null) {
            return true;
        }
        str = str.replaceAll("\\s+", "");
        return str.trim().isEmpty() || str.equalsIgnoreCase("null");
    }
}
