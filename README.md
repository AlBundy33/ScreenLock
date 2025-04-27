# ScreenLock
Simple app to lock the screen because the power button on my Pixel 2 XL sometimes doesn't work.

## signed apk
Signing is needed if you want to install the apk on your device.

To sign the apk create a java-keystore with
```
keytool -genkeypair \
  -alias android \
  -keyalg RSA \
  -keysize 2048 \
  -validity 3650 \
  -keystore ~/signing.jks \
  -storepass foobar \
  -keypass foobar \
  -dname "CN=Your Name, OU=Your Unit, O=Your Organization, L=Your City, S=Your State, C=DE"
```

and edit your ~/.gradle/gradle.properties
```
android.injected.signing.store.file=/Users/your_username/signing.jks
android.injected.signing.key.alias=android
android.injected.signing.store.password=foobar
android.injected.signing.key.password=foobar
```

now you can run
```
gradle build
```
to create
```
./app/build/outputs/apk/release/app-release.apk
./app/build/outputs/apk/debug/app-debug.apk
```
to build only the app-release.apk run `gradle assembleRelease`
