
# react-native-user-experior

## Getting started

`$ npm install react-native-userexperior --save`

### Mostly automatic installation

`$ react-native link react-native-userexperior`

### Manual installation

#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-user-experior` and add `RNUserExperior.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNUserExperior.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNUserExperiorPackage;` to the imports at the top of the file
  - Add `new RNUserExperiorPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-userexperior'
  	project(':react-native-userexperior').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-userexperior/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-userexperior')
  	```


## Usage
```javascript
import RNUserExperior from 'react-native-userexperior';

// TODO: What to do with the module?
RNUserExperior;
```
  