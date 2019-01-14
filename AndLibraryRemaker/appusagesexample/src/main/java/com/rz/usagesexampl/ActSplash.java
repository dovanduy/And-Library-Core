package com.rz.usagesexampl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.rz.usagesexampl.hardware.DeviceInfo;
import com.rz.usagesexampl.imagepicker.CRUDPathManager;
import com.rz.usagesexampl.imagepicker.DirectoryPathManager;
import com.rz.usagesexampl.imagepicker.ImageManager;
import com.rz.usagesexampl.imagepicker.ImagePickerManager;
import com.rz.usagesexampl.imagepicker.exception.CoreException;

import java.util.ArrayList;
import java.util.HashMap;

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
    private Button sysBtnCamera, sysBtnGallery;
    private ImageView sysImageView;
    private ImageManager imageManager;
    private ImagePickerManager imagePickerManager;
    private ImagePickerManager.CameraManager cameraManager;
    private ImagePickerManager.GalleryManager galleryManager;
    private String saveImageName, fileFullPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);
        activity = this;
        context = this;
        CLASS_NAME = this.getClass().getName();
        //onUseMemoryCache();
        /*HashMap<String, String> allMappedValue = new DeviceInfo(activity, context).getAllMappedValue();
        System.out.println(allMappedValue.toString());*/
        /*Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        startActivity(intent);*/
        //|------------------------------------------------------------|
        sysBtnCamera = (Button) findViewById(R.id.sysBtnCamera);
        sysBtnGallery = (Button) findViewById(R.id.sysBtnGallery);
        sysImageView = (ImageView) findViewById(R.id.sysImageView);
        sysBtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View argView) {
                System.out.println("CLICKED");
                try {
                    cameraManager.open();
                } catch (CoreException ex) {
                    ex.printStackTrace();
                }
            }
        });
        sysBtnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View argView) {
                System.out.println("CLICKED");
                try {
                    galleryManager.open();
                } catch (CoreException ex) {
                    ex.printStackTrace();
                }
            }
        });
        /*DirectoryPathManager directoryPathManager = new DirectoryPathManager(context)
                .withDirectory(".test")
                .withPackage(false);
        System.out.println("DIRECTORY_SYSTEM: " + directoryPathManager.getSystemDirectory());
        System.out.println("DIRECTORY_CACHE: " + directoryPathManager.getCacheDirectory());
        try {
            //CRUDPathManager.onCreateDirectories(context, directoryPathManager.getSystemDirectory());
            CRUDPathManager.onCreateDirectories(context, directoryPathManager.getCacheDirectory());
        } catch (CoreException ex) {
            ex.printStackTrace();
            System.out.println("ERROR_TYPE: " + ex.getErrorType().toString());
        }*/
        /*DirectoryPathManager directoryPathManager = new DirectoryPathManager(context)
                .withDirectory("test")
                .withPackage(false);*/
        try {
            imageManager = new ImageManager(context);
            imageManager.setExternalPath("test", true);
            //imageManager.setCachePath("test");
            System.out.println("DIRECTORY_SYSTEM: " + imageManager.getWorkingDirectory());
        } catch (CoreException ex) {
            //ex.printStackTrace();
        }
        imagePickerManager = new ImagePickerManager(context);
        try {
            cameraManager = imagePickerManager.getCameraManager();
        } catch (CoreException ex) {
            ex.printStackTrace();
        }
        try {
            galleryManager = imagePickerManager.getGalleryManager();
        } catch (CoreException ex) {
            ex.printStackTrace();
        }
        /*if (galleryManager == null) {
            System.out.println("GALLERY_MANAGER_NULL");
        } else {
            System.out.println("GALLERY_MANAGER");
        }*/
        //galleryManager = imagePickerManager.getGalleryManager();
        System.out.println("DIRECTORY: " + imageManager.getWorkingDirectory());
        //saveImageName = imageManager.getNewImageName("Test Image", ImageManager.ImageFormat.PNG);
        //saveImageName = saveImageName.replaceAll("[\\s|-]+", "-");
        //System.out.println("NEW_IMAGE_NAME:---------------- " + saveImageName);
        //|------------------------------------------------------------|
    }

    @Override
    protected void onActivityResult(int argRequestCode, int argResultCode, Intent argData) {
        //Bundle bundle = argData.getExtras();
        //System.out.println("BUNDLE: " + bundle.size());
        Bitmap bitmap = null;
        if (argRequestCode == cameraManager.CAMERA_REQUEST) {
            try {
                bitmap = cameraManager.onActivityResult(argRequestCode, argResultCode, argData);
            } catch (CoreException ex) {
                ex.printStackTrace();
            }
        } else if (argRequestCode == galleryManager.GALLERY_REQUEST) {
            try {
                bitmap = galleryManager.onActivityResult(argRequestCode, argResultCode, argData);
            } catch (CoreException ex) {
                ex.printStackTrace();
            }
        }
        if (bitmap != null) {
            onSaveMediaImage(bitmap);
        }
        //super.onActivityResult(argRequestCode, argResultCode, argData);
    }

    private void onSaveMediaImage(Bitmap argBitmap) {
        if (argBitmap != null) {
            if (fileFullPath != null) {
                try {
                    CRUDPathManager.deleteFile(context, fileFullPath);
                } catch (CoreException ex) {
                    ex.printStackTrace();
                }
            }
            saveImageName = imageManager.getNewImageName("Test Image", ImageManager.ImageFormat.PNG);
            System.out.println("NEW_IMAGE_NAME: " + saveImageName);
            try {
                imageManager.withBitmap(argBitmap)
                        .withName(saveImageName)
                        .withQuality(100)
                        .withCompressFormat(Bitmap.CompressFormat.PNG)
                        .withWidth(500)
                        .withResize()
                        .write();
                fileFullPath = imageManager.getReferFullFilePath();
                System.out.println("FULL_FILE_PATH: " + fileFullPath);
                Bitmap bitmap = imageManager.getBitmapFromPath(fileFullPath);
                if (bitmap != null) {
                    sysImageView.setImageBitmap(bitmap);
                }
            } catch (CoreException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void onUseMemoryCache() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Value001");
        arrayList.add("Value002");
        arrayList.add("Value003");
        arrayList.add("Value004");
        arrayList.add("Value005");
        String cacheKey = "cacheKey";
        /*try {
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
        }*/
    }

    private void onAppUtils() {
        /*AppUtils.getAppVersion(context);
        AppUtils.getAppVersionCode(context);
        AppUtils.logDebug("TAG", "MESSAGE");
        AppUtils.getDisplaySize(context);
        AppUtils.isURLAvailable("URL");*/
    }
}
//https://github.com/bintray/gradle-bintray-plugin/issues/88
//https://stackoverflow.com/questions/33668021/bintray-unable-to-upload-files-maven-group-artifact-or-version-defined-in-the
//https://www.petrikainulainen.net/programming/gradle/getting-started-with-gradle-creating-a-multi-project-build/
//https://docs.gradle.org/current/userguide/maven_plugin.html
//https://stackoverflow.com/questions/45078381/gradle-library-with-multiple-modules
