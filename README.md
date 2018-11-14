# And-Library-Core
And Library Core

https://android.jlelse.eu/publish-multi-module-android-libraries-on-jitpack-339213f6224c


<a href='https://bintray.com/rzrasel/android-core-library-center/android-core-library?source=watch' alt='Get automatic notifications about new "android-core-library" versions'><img src='https://www.bintray.com/docs/images/bintray_badge_color.png'></a>
[ ![Download](https://api.bintray.com/packages/rzrasel/android-core-library-center/android-core-library/images/download.svg) ](https://bintray.com/rzrasel/android-core-library-center/android-core-library/_latestVersion)
[![](https://jitpack.io/v/rzrasel/And-Library-Core.svg)](https://jitpack.io/#rzrasel/And-Library-Core)

<!--
<a href="https://www.w3schools.com">
<img border="0" alt="W3Schools" src="logo_w3s.gif" width="100" height="100">
</a>
[![](https://jitpack.io/v/rzrasel/And-Library-Core.svg)](https://jitpack.io/#rzrasel/And-Library-Core)

<a href="https://github.com/rzrasel/And-Library-Core" target="_blank">Hello, world!</a>
[link](url){:target="_blank"}
[Link](https://github.com/rzrasel/And-Library-Core "title" target="_blank")
-->

### GIT Command
```git_command
git init
git remote add origin https://github.com/rzrasel/And-Library-Core.git
git remote -v
git fetch && git checkout master
git add .
git commit -m "Add Readme & Git Commit File"
git pull
git push --all
```

### Installation
Maven Repositories Installation

### Add Maven Repositories
```maven_repositories
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

### Add Android Dependencies
```android_dependencies
dependencies {
    implementation 'com.github.rzrasel:And-Library-Core:V-201802.01.4'
}
```

### Add Android .AAR File
```android_repositories
allprojects {
   repositories {
      jcenter()
      flatDir {
        dirs 'libs'
      }
   }
}
```
```android_dependencies
dependencies {
    implementation(name:'librarycore', ext:'aar')
}
```
https://mobikul.com/manually-include-external-aar-file/
How to get server response time using PHP
```android_server_response_time
https://stackoverflow.com/questions/34059737/how-to-get-server-response-time-using-php
<?php
//http://tech.fireflake.com/2008/09/17/using-php-to-check-response-time-of-http-server/
// check responsetime for a webbserver
function pingDomain($domain){
    $starttime = microtime(true);
    // supress error messages with @
    $file      = @fsockopen($domain, 80, $errno, $errstr, 10);
    $stoptime  = microtime(true);
    $status    = 0;

    if (!$file){
        $status = -1;  // Site is down
    }
    else{
        fclose($file);
        $status = ($stoptime - $starttime) * 1000;
        $status = floor($status);
    }
    return $status;
}
?>
```











Download
--------

Maven Repositories
```maven
allprojects {
    repositories {
        maven { url 'https://dl.bintray.com/rzrasel/android-core-library-center' }
    }
}
```

Download the latest JAR or grab via Maven:
```xml
<dependency>
    <groupId>com.adept.archery</groupId>
    <artifactId>and-core-library</artifactId>
    <version>100.00.01</version>
    <type>pom</type>
</dependency>
```
or Gradle:
```groovy
implementation 'com.adept.archery:and-core-library:100.00.01'
```

Usage
-----

In your Activity

```java
import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rz.logwriter.LogWriter;

public class ActSplash extends AppCompatActivity {
    private Activity activity;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);
        activity = this;
        context = this;
        LogWriter.Log("Test Log");
    }
}
```