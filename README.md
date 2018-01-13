# And-Library-Core-V-201712.0.1
And Library Core V-201712.0.1

[![](https://jitpack.io/v/rzrasel/And-Library-Core.svg)](https://jitpack.io/#rzrasel/And-Library-Core)

### GIT Command
```git_command
git init
git remote add origin https://github.com/rzrasel/And-Library-Core.git
git remote -v
git fetch && git checkout master
```

### Installation
Maven Repositories Installation

### Maven Repositories
```maven_repositories
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

### Android Dependencies
```android_dependencies
dependencies {
    compile 'com.github.rzrasel:And-Library-Core:V-201712.0.1'
}
```

### Android .AAR File
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
    compile(name:'webkul', ext:'aar')
}
```