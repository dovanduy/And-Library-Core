package com.rz.usagesexampl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rz.usagesexampl.done.jxml.XMLFeedParser;
import com.rz.usagesexampl.working.caching.MemoryCache;
import com.rz.usagesexampl.working.utils.AppUtils;
import com.rz.usagesexampl.working.utils.Utils;

import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

/**
 * <h1>ActSplash</h1>
 * <p>
 * Use for object memory cache
 * </p>
 *
 * @author Rz Rasel (Md. Rashed - Uz - Zaman)
 * @version 100.00.01
 * @since 2018-12-17
 */

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
        onUseMemoryCache();
    }

    private void onUseMemoryCache() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Value001");
        arrayList.add("Value002");
        arrayList.add("Value003");
        arrayList.add("Value004");
        arrayList.add("Value005");
        String cacheKey = "cacheKey";
        try {
            MemoryCache.setCache(context, cacheKey, arrayList);
            ArrayList<String> arrayList1 = (ArrayList<String>) MemoryCache.getCache(context, cacheKey);
            System.out.println("SIZE: " + arrayList1.size());
            MemoryCache.onDeleteCache(context, cacheKey);
            MemoryCache.onClearAll(context);
        } catch (IOException ex) {
            //ex.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            //ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            //ex.printStackTrace();
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
