/*
* Copyright (C) 2006 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.rz.librarycore.jxml;

import android.content.Context;

import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
/*
add a method - withTag
add a method - withStartTag
add a method - withAttribute
 */
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
//https://android--examples.blogspot.com/2017/03/android-xmlpullparser-to-parse-xml.html