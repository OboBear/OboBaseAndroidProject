cd app/src/main/java
pwd
javah -jni com.obo.mydemos.ndk.NdkActivity
echo "create .h file"
mv com_obo_mydemos_ndk_NdkActivity.h ../jni/