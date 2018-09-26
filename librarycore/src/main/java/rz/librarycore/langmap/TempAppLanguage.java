package rz.librarycore.langmap;

import java.util.HashMap;

public class TempAppLanguage {
    public static HashMap<String, HashMap<String, String>> languageMap = new HashMap<>();
    /*HashMap<String, String> propertyTempMap = new HashMap<>();
    propertyTempMap.put("text_welcome_about", "About Bangladesh Ansar & VDP");
    languageMap.put(Name.BANGLA.getValue(), propertyTempMap);*/

    public static String getValue(Name argName, String argKey) {
        if (languageMap.containsKey(argName.getValue())) {
            HashMap<String, String> propertyTempMap = languageMap.get(argName.getValue());
            if (propertyTempMap.containsKey(argKey)) {
                return propertyTempMap.get(argKey);
            }
        }
        return null;
    }

    public enum Name {
        BANGLA("bn"), ENGLISH("en");
        private String value;

        Name(String argValue) {
            value = argValue;
        }

        public String getValue() {
            return value;
        }
    }
}
