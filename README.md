# And-Library-Core-V-201712.0.1
And Library Core V-201712.0.1

<a href="https://jitpack.io/#rzrasel/And-Library-Core">
<img border="0" alt="W3Schools" src="https://jitpack.io/v/rzrasel/And-Library-Core.svg">
</a>
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
    compile 'com.github.rzrasel:And-Library-Core:V-201712.0.1'
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