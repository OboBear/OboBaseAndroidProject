# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/apple/Desktop/Workspace/android/SDK/android-sdk-macosx/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose
-dontoptimize
-dontpreverify
-keepattributes *Annotation*
-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService
-keepclasseswithmembernames class * {
    native <methods>;
}




# keep setters in Views so that animations can still work.
# see http://proguard.sourceforge.net/manual/examples.html#beans
-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}

# We want to keep methods in Activity that could be used in the XML attribute onClick
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keepclassmembers class * extends android.support.v7.app.AppCompatActivity {
   public void *(android.view.View);
}
# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepclassmembers class **.R$* {
    public static <fields>;
}

-keepclassmembers class * {
   private native <methods>;
   public native <methods>;
   protected native <methods>;
   public static native <methods>;
   private static native <methods>;
   static native <methods>;
   native <methods>;
    public void onEvent*(**);
}

# The support library contains references to newer platform versions.
# Don't warn about those in case this app is linking against an older
# platform version.  We know about them, and they are safe.

-dontwarn android.support.**
-keepattributes Signature


-keep class com.google.** { *; }
-dontwarn com.google.**


-keep class com.handmark.** { *; }
-dontwarn com.handmark.**


-keep class de.greenrobot.event.** { *;}
-keep class de.greenrobot.event.util.** { *; }
-keep class de.greenrobot.dao.** { *;}
-keep class de.greenrobot.dao.async.** { *;}
-keep class de.greenrobot.dao.identityscope.** { *;}
-keep class de.greenrobot.dao.internal.** { *;}
-keep class de.greenrobot.dao.query.** { *;}

## 友盟
-keepclassmembers class * {
   public <init> (org.json.JSONObject);
}

-keep public class [chiyun.com.hudandroid].R$*{
public static final int *;
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

#retrofit相关
-keep class com.squareup.** { *; }
-keep interface com.squareup.okhttp.** { *; }
-dontwarn com.squareup.**
-keepattributes *Annotation*
-keep class rx.** { *; }
-dontwarn rx.**
-dontwarn com.squareup.okhttp.**
-keep class javax.inject.** { *; }
-keep class retrofit.** { *; }
-keep class com.windthunder.server.** { *; }
-dontwarn retrofit.**

##高德相关
#-libraryjars libs/AMap_Android_3DMapSDK_V3.1.1.jar
#-libraryjars libs/AMap_Location_v2.1.0_20151202.jar
#-libraryjars libs/AMap_Navi_v1.6.0_20151229.jar
#-libraryjars libs/MapApiSearch.jar
#-libraryjars libs/MapApiServices.jar
-keep class vi.com.gdi.bgl.android.**{*;}
-keep class com.amap.** { *; }
-keep class com.autonavi.** { *; }
-keep class com.loc.** { *; }
-dontwarn com.amap.**
-dontwarn com.autonavi.**

#迅飞语音
-keep class com.iflytek.**{*;}
-dontwarn com.iflytek.**


-keepclassmembers class ** {
    public void onEvent*(**);
}