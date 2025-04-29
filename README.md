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

## cannot unlock with fingerprint after using the app
At first, I considered this a bug 🐛 — or at least unexpected behavior — but now I actually see it more as a feature ✨:

The device is locked as a device admin, which means you have to unlock it using your PIN or pattern.

While this can be a bit annoying at times, it ensures that no one 🕵️‍♂️ can unlock your phone just by pressing your finger on the sensor.

## build
can also be tested with docker
```
docker run -it --rm ubuntu bash
```
build steps

install dependencies
```
apt install git openjdk-17-jdk-headless google-android-cmdline-tools-13.0-installer --update
update-alternatives --set java /usr/lib/jvm/java-17-openjdk-amd64/bin/java
```

license agreements
```
sdkmanager --licenses
```
clone
```
git clone https://github.com/AlBundy33/ScreenLock.git
cd ScreenLock
```
build
```
ANDROID_HOME=/usr/lib/android-sdk ./gradlew build
```
