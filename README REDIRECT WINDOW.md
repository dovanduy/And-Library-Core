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

### Code Usages
```code_usages
private void onRedirectWindow() {
    Bundle bundle = new Bundle();
    RedirectWindow redirectWindow = RedirectWindow.getInstance(activity, context);
    redirectWindow.withBundle(bundle)
            .withFlag()
            .disposeWindow()
            .run(ActTestTwo.class);
    redirectWindow.withBundle(bundle)
            .withFlag()
            .disposeWindow()
            .run(ActTestTwo.class, 5000);
    redirectWindow.withBundle(bundle)
            .withFlag()
            .disposeWindow()
            .run(ActTestTwo.class, 5000, new RedirectWindow.OnEventListener() {
                @Override
                public boolean onDependencyWait() {
                    return isDependencyWait;
                }
            });
    new Handler().postDelayed(new Runnable() {
        public void run() {
            isDependencyWait = true;
        }
    }, 10000);
}
```