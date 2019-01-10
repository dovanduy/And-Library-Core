package com.rz.usagesexampl.imagepicker;

import android.content.Context;
import android.os.Environment;

import java.io.File;

public class DirectoryPathManager {
    //DirectoryPathManager
    private Context context;
    private String fullAbsolutePath;
    private String rootDirectory;
    private String packageName = "";
    private String directory;
    private boolean isPrefixPackageName = true;

    public DirectoryPathManager(Context argContext) {
        context = argContext;
    }

    public DirectoryPathManager withPackage() {
        packageName = context.getPackageName();
        return this;
    }

    public DirectoryPathManager withPackage(boolean agrHaveDot) {
        packageName = context.getPackageName();
        if (agrHaveDot) {
            packageName = "." + context.getPackageName();
        }
        return this;
    }

    public DirectoryPathManager withDirectory(String argDirectoryName) {
        if (!isNullOrEmpty(argDirectoryName)) {
            directory = argDirectoryName;
        }
        return this;
    }

    public DirectoryPathManager isPostfixPackageName() {
        isPrefixPackageName = false;
        return this;
    }

    public String getSystemDirectory() {
        fullAbsolutePath = getSysRootDir();
        File file = null;
        if (isPrefixPackageName) {
            if (!isNullOrEmpty(packageName)) {
                file = new File(fullAbsolutePath, packageName);
                fullAbsolutePath = file.toString();
            }
            if (!isNullOrEmpty(directory)) {
                file = new File(fullAbsolutePath, directory);
                fullAbsolutePath = file.toString();
            }
        } else {
            if (!isNullOrEmpty(directory)) {
                file = new File(fullAbsolutePath, directory);
                fullAbsolutePath = file.toString();
            }
            if (!isNullOrEmpty(packageName)) {
                file = new File(fullAbsolutePath, packageName);
                fullAbsolutePath = file.toString();
            }
        }
        return fullAbsolutePath;
    }

    public String getCacheDirectory() {
        fullAbsolutePath = getCacheRootDir();
        File file = null;
        if (isPrefixPackageName) {
            if (!isNullOrEmpty(packageName)) {
                file = new File(fullAbsolutePath, packageName.replaceFirst(".", ""));
                fullAbsolutePath = file.toString();
            }
            if (!isNullOrEmpty(directory)) {
                file = new File(fullAbsolutePath, directory.replaceFirst(".", ""));
                fullAbsolutePath = file.toString();
            }
        } else {
            if (!isNullOrEmpty(directory)) {
                file = new File(fullAbsolutePath, directory.replaceFirst(".", ""));
                fullAbsolutePath = file.toString();
            }
            if (!isNullOrEmpty(packageName)) {
                file = new File(fullAbsolutePath, packageName.replaceFirst(".", ""));
                fullAbsolutePath = file.toString();
            }
        }
        return fullAbsolutePath;
    }
    /*private String getSysRootDirectory() {
        return getRootDir();
    }

    private String getSysDirectory() {
        //return rootDirectory + "/" + context.getPackageName();
        return getSysRootDirectory() + "/" + context.getPackageName();
    }*/


    private String getSysRootCacheDirectory() {
        //return getCacheRootDir();
        return "";
    }

    /*private String getSysCacheDirectory() {
        //return rootDirectory + "/" + context.getPackageName();
        return getSysRootCacheDirectory() + "/" + context.getPackageName();
    }*/

    public String getRootDirectory(String argDirectoryName) {
        /*if (argDirectoryName == null) {
            return getRootDirectory();
        } else if (argDirectoryName.trim().isEmpty()) {
            return getRootDirectory();
        } else {
            rootDirectory = getRootDir() + "/" + argDirectoryName;
            directory = rootDirectory;
        }*/
        /*FlyDirFileManager flyDirFileManager = new FlyDirFileManager();
        flyDirFileManager.makeDirs(directory);*/
        //return directory;
        return "";
    }

    /*protected String getRootCacheDirectory() {
        //setRootDirectory(getSysDirectory());
        rootDirectory = getSysRootCacheDirectory();
        directory = rootDirectory;
        //log("PRINT: " + directory);
        return directory;
    }*/

    protected String getRootCacheDirectory(String argDirectoryName) {
        /*if (argDirectoryName == null) {
            setRootCacheDirectory();
            return this;
        } else if (argDirectoryName.trim().isEmpty()) {
            setRootCacheDirectory();
            return this;
        } else {
            rootDirectory = getRootCacheDir() + "/" + argDirectoryName;
            directory = rootDirectory;
        }*/
        /*if (argDirectoryName == null) {
            return getRootCacheDirectory();
        } else if (argDirectoryName.trim().isEmpty()) {
            return getRootCacheDirectory();
        }
        rootDirectory = getCacheRootDir() + "/" + argDirectoryName;
        directory = rootDirectory;
        *//*FlyDirFileManager flyDirFileManager = new FlyDirFileManager();
        flyDirFileManager.makeDirs(directory);*//*
        //log("PRINT: " + directory);
        return directory;*/
        return null;
    }

    private String getSysRootDir() {
        return Environment.getExternalStorageDirectory() + "";
    }

    private String getCacheRootDir() {
        return context.getCacheDir() + "";
    }

    //|------------------------------------------------------------|
    private static boolean isNullOrEmpty(String argValue) {
        if (argValue == null) {
            return true;
        }
        argValue = argValue.replaceAll("\\s+", "");
        if (argValue.trim().isEmpty()) {
            return true;
        }
        if (argValue.equalsIgnoreCase("null")) {
            return true;
        }
        return false;
    }

    //|------------------------------------------------------------|
    private void log(String argMessage) {
        System.out.println("PathManager_DEBUG_LOG_PRINT: " + argMessage);
    }

    //|------------------------------------------------------------|
    public String getRequestRootPath(DirectoryPathManager argPathManager, String argStrPath) {
        return argPathManager.getRootCacheDirectory(argStrPath).toString();
    }

    public String getRequestCachePath(DirectoryPathManager argPathManager, String argStrPath) {
        return argPathManager.getRootCacheDirectory(argStrPath).toString();
    }
    //|------------------------------------------------------------|
}