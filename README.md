
# react-native-verify-installer

Android only React Native library to retrieve the source of installation for a given package name

## Getting started

`$ npm install react-native-verify-installer --save`

### Automatic installation

`$ react-native link react-native-verify-installer`

### Manual installation

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `com.vacuumdecay.verifypackage.RNVerifyInstallerPackage;` to the imports at the top of the file
  - Add `new RNVerifyInstallerPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-verify-installer'
  	project(':react-native-verify-installer').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-verify-installer/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      implementation project(':react-native-verify-installer')
  	```

## Usage
```javascript
import VerifyInstaller from 'react-native-verify-installer';

VerifyInstaller.getInstallerSource("com.android.chrome", source => {
      console.log(source);//Will return one of ['Play Store','Amazon Appstore','ADB','Unknown']
});
```
  