package rz.librarycore.langmap;

import java.util.HashMap;

public class AppLanguage {
    public static HashMap<String, HashMap<String, String>> languageMap = new HashMap<>();
    public static HashMap<String, HashMap<String, HashMap<String, String>>> languageMultiMap = new HashMap<>();

    public AppLanguage() {
        lanLoadBangla();
        lanLoadEnglish();
        lanLoadMultiBangla();
        lanLoadMultiEnglish();
    }

    private void lanLoadMultiBangla() {
        HashMap<String, HashMap<String, String>> keyTempMap = new HashMap<>();
        HashMap<String, String> propertyTempMap = new HashMap<>();
        propertyTempMap.put("multi_cow_type_holstein_friesian", "হলস্টিন ফ্রিজিয়ান");
        propertyTempMap.put("multi_cow_type_jersey", "জার্সি");
        propertyTempMap.put("multi_cow_type_pabna_breed", "পাবনাই");
        propertyTempMap.put("multi_cow_type_red_chittagong", "রেড চিটাগং");
        propertyTempMap.put("multi_cow_type_sahiwal", "শাহিওয়াল");
        keyTempMap.put("multi_cow_type", propertyTempMap);
        languageMultiMap.put(Name.BANGLA.getValue(), keyTempMap);
    }

    private void lanLoadMultiEnglish() {
        HashMap<String, HashMap<String, String>> keyTempMap = new HashMap<>();
        HashMap<String, String> propertyTempMap = new HashMap<>();
        propertyTempMap.put("multi_cow_type_holstein_friesian", "Holstein Friesian");
        propertyTempMap.put("multi_cow_type_jersey", "Jersey");
        propertyTempMap.put("multi_cow_type_pabna_breed", "Pabna Breed");
        propertyTempMap.put("multi_cow_type_red_chittagong", "Red Chittagong");
        propertyTempMap.put("multi_cow_type_sahiwal", "Sahiwal");
        keyTempMap.put("multi_cow_type", propertyTempMap);
        languageMultiMap.put(Name.ENGLISH.getValue(), keyTempMap);
    }

    private void lanLoadBangla() {
        HashMap<String, String> propertyTempMap = new HashMap<>();
        propertyTempMap.put("hint_text_bolus_id", "বোলাস আইডি");
        propertyTempMap.put("hint_text_cow_id", "গরুর আইডি");
        propertyTempMap.put("hint_text_cow_name", "গরুর নাম");
        propertyTempMap.put("hint_text_date_bolused", "বোলাস লাগানোর তারিখ");
        propertyTempMap.put("hint_text_password", "পাসওয়ার্ড");
        propertyTempMap.put("hint_text_user_name", "ব্যবহারকারীর নাম");
        propertyTempMap.put("label_age", "বয়স");
        propertyTempMap.put("label_bolused_date", "বোলাস লাগানোর তারিখ");
        propertyTempMap.put("label_btn_submit_login", "লগইন করুন");
        propertyTempMap.put("label_cow_id_ear_tag", "গরুর আইডি/কানে লাগানো ট্যাগ");
        propertyTempMap.put("label_cow_type", "গরুর ধরন");
        propertyTempMap.put("label_drawer_calving_info", "বাছুর সংক্রান্ত তথ্য");
        propertyTempMap.put("label_drawer_cow_info", "গাভী/ষাঁড় সম্পর্কিত তথ্য");
        propertyTempMap.put("label_drawer_dashboard", "ড্যাশবোর্ড");
        propertyTempMap.put("label_drawer_disease_info", "রোগ সম্পর্কিত তথ্য");
        propertyTempMap.put("label_drawer_health_and_vaccination_info", "গরুর স্বাস্থ্য ও টীকা প্রদান সম্পর্কিত তথ্য");
        propertyTempMap.put("label_drawer_insemination", "বীজ ভরন");
        propertyTempMap.put("label_drawer_insemination_info", "বীজ ভরন সংক্রান্ত তথ্য");
        propertyTempMap.put("label_drawer_log_out", "লগ আউট");
        propertyTempMap.put("label_drawer_milk_production_info", "দুধ উৎপাদন সম্পর্কিত তথ্য");
        propertyTempMap.put("label_drawer_project_info", "প্রকল্প সম্পর্কিত তথ্য");
        propertyTempMap.put("label_drawer_registration", "গাভী/ষাঁড় নিবন্ধন সিস্টেম");
        propertyTempMap.put("label_drawer_reproductive_health_info", "গাভী/ষাঁড়  প্রজনন স্বাস্থ্য সম্পর্কিত তথ্য");
        propertyTempMap.put("label_farm_name", "ফার্মের নাম");
        propertyTempMap.put("label_grid_bolus", "বোলাস");
        propertyTempMap.put("label_grid_bull", "ষাঁড়");
        propertyTempMap.put("label_grid_cow", "গাভী");
        propertyTempMap.put("label_grid_doctor", "ডাক্তার");
        propertyTempMap.put("label_grid_farmer", "খামারি");
        propertyTempMap.put("label_grid_user_manual", "ব্যবহার বিধি");
        propertyTempMap.put("label_month", "মাস");
        propertyTempMap.put("label_text_intro", "এর কার্যকরী স্পেসিফিকেশন \n পশু বীমা এবং  পশু পর্যবেক্ষণ প্ল্যাটফর্ম");
        propertyTempMap.put("label_tool_bar_title", "স্বাগতম");
        propertyTempMap.put("label_year", "বছর");
        languageMap.put(Name.BANGLA.getValue(), propertyTempMap);
    }

    private void lanLoadEnglish() {
        HashMap<String, String> propertyTempMap = new HashMap<>();
        propertyTempMap.put("hint_text_bolus_id", "Bolus ID");
        propertyTempMap.put("hint_text_cow_id", "Cow ID");
        propertyTempMap.put("hint_text_cow_name", "Cow Name");
        propertyTempMap.put("hint_text_date_bolused", "Date Bolused");
        propertyTempMap.put("hint_text_password", "Password");
        propertyTempMap.put("hint_text_user_name", "User Name");
        propertyTempMap.put("label_age", "Age");
        propertyTempMap.put("label_bolused_date", "Bolused Date");
        propertyTempMap.put("label_btn_submit_login", "Login");
        propertyTempMap.put("label_cow_id_ear_tag", "Cow Id/Ear Tag");
        propertyTempMap.put("label_cow_type", "Cow Type");
        propertyTempMap.put("label_drawer_calving_info", "Calving Information");
        propertyTempMap.put("label_drawer_cow_info", "Cow Info");
        propertyTempMap.put("label_drawer_dashboard", "Dashboard");
        propertyTempMap.put("label_drawer_disease_info", "Disease Information");
        propertyTempMap.put("label_drawer_health_and_vaccination_info", "Health and Vaccination Related Information");
        propertyTempMap.put("label_drawer_insemination", "Insemination");
        propertyTempMap.put("label_drawer_insemination_info", "Insemination Information");
        propertyTempMap.put("label_drawer_log_out", "Logout");
        propertyTempMap.put("label_drawer_milk_production_info", "Milk Production Related Information");
        propertyTempMap.put("label_drawer_project_info", "Project Information");
        propertyTempMap.put("label_drawer_registration", "Registration");
        propertyTempMap.put("label_drawer_reproductive_health_info", "Reproductive health for Cow/Bull");
        propertyTempMap.put("label_farm_name", "Farm Name");
        propertyTempMap.put("label_grid_bolus", "Bolus");
        propertyTempMap.put("label_grid_bull", "Bull");
        propertyTempMap.put("label_grid_cow", "Cow");
        propertyTempMap.put("label_grid_doctor", "Doctor");
        propertyTempMap.put("label_grid_farmer", "Farmer");
        propertyTempMap.put("label_grid_user_manual", "User Manual");
        propertyTempMap.put("label_month", "month");
        propertyTempMap.put("label_text_intro", "the Cattle Insurance and Well Being Monitoring Platform");
        propertyTempMap.put("label_tool_bar_title", "Welcome");
        propertyTempMap.put("label_year", "Year");
        languageMap.put(Name.ENGLISH.getValue(), propertyTempMap);
    }

    public String getValue(Name argName, String argKey) {
        if (isNullOrEmpty(argKey)) {
            return null;
        }
        if (languageMap.containsKey(argName.getValue())) {
            HashMap<String, String> propertyTempMap = languageMap.get(argName.getValue());
            if (propertyTempMap.containsKey(argKey)) {
                return propertyTempMap.get(argKey);
            }
        }
        return null;
    }

    public HashMap<String, String> getMultiValue(Name argName, String argKey) {
        if (isNullOrEmpty(argKey)) {
            return null;
        }
        HashMap<String, String> retVal = new HashMap<>();
        if (languageMap.containsKey(argName.getValue())) {
            HashMap<String, HashMap<String, String>> propertyTempMap = languageMultiMap.get(argName.getValue());
            if (propertyTempMap.containsKey(argKey)) {
                return propertyTempMap.get(argKey);
            }
        }
        return null;
    }

    public static boolean isNullOrEmpty(String argStr) {
        if (argStr == null) {
            return true;
        }
        if (argStr.isEmpty()) {
            return true;
        }
        return false;
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