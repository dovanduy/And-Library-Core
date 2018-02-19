# And-Library-Core-V-201802.01.4
And Library Core V-201802.01.4

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
    compile 'com.github.rzrasel:And-Library-Core:V-201802.01.4'
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
    compile(name:'librarycore', ext:'aar')
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