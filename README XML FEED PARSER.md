## Usages Of <b>XML Feed Parser</b>

### XML Type/Format:
```xml_type_format_xmlfeedparser_usages
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
```

### JAVA Code Usages:
```java_code_XMLFeedParser_usages
XMLFeedParser xmlFeedParser = new XMLFeedParser(context);
String xmlStr = xmlFeedParser.onReadAssetsFile("db_dir/test.xml");
//System.out.println("INIT_VALUE: " + xmlStr);
String xmlTag = "word_list";
String xmlAttr = "subjective_category";
String xmlAttrValue = "BANK_MANAGER";
xmlStr = xmlFeedParser.getXMLTagByAttributes(xmlStr, xmlTag, xmlAttr, xmlAttrValue);
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
```