
package com.userexperiorlib.react;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.bridge.JavaScriptModule;
import com.userexperior.UserExperior;
import com.userexperior.utilities.SecureViewBucket;

public class RNUserExperiorPackage implements ReactPackage {
	
	public RNUserExperiorPackage() {}

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();

        modules.add(new RNUserExperiorModule(reactContext));

        return modules;
    }

    // Deprecated RN 0.47
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }

    private class RNUserExperiorModule extends ReactContextBaseJavaModule {

        RNUserExperiorModule(ReactApplicationContext reactContext) {
            super(reactContext);
        }

        @Override
        public String getName() {
            return "UserExperior";
        }

        @ReactMethod
        public void startRecording(String ueSdkAppVersionKey) {
            try {
                UserExperior.startRecording(getReactApplicationContext(), ueSdkAppVersionKey);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @ReactMethod
        public void stopRecording() {
            try {
                UserExperior.stopRecording();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @ReactMethod
        public void pauseRecording() {
            try {
                UserExperior.pauseRecording();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @ReactMethod
        public void resumeRecording() {
            try {
                UserExperior.resumeRecording();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @ReactMethod
        public void setUserIdentifier(String userIdentifier) {
            try {
                UserExperior.setUserIdentifier(userIdentifier);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @ReactMethod
        public void setCustomTag(String customTag, String type){
            try {
                UserExperior.setCustomTag(customTag, type);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @ReactMethod
        public void startScreen(String screenName) {
            try {
                UserExperior.startScreen(screenName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @ReactMethod
        public void startTimer(String timerName) {
            try {
                UserExperior.startTimer(timerName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @ReactMethod
        public void endTimer(String timerName) {
            try {
                UserExperior.endTimer(timerName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @ReactMethod
        public void setDeviceLocation(double latitude, double longitude) {
            try {
                UserExperior.setDeviceLocation(latitude, longitude);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		
		@ReactMethod
        public void addInSecureViewBucket(final int id) {
            UIManagerModule uiManager = getReactApplicationContext().getNativeModule(UIManagerModule.class);
            uiManager.addUIBlock(new UIBlock() {
                @Override
                public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                    try {
                        View view = nativeViewHierarchyManager.resolveView(id);
                        if (view != null){
                            SecureViewBucket.addInSecureViewBucket(view);
                        }
                    } catch(Exception e) {
                        Log.d("UserExperior", "addInSecureViewBucket: can't find view by id: " + id);
                    }
                }
            });
        }

        @ReactMethod
        public void removeFromSecureViewBucket(final int id) {
            UIManagerModule uiManager = getReactApplicationContext().getNativeModule(UIManagerModule.class);
            uiManager.addUIBlock(new UIBlock() {
                @Override
                public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                    try {
                        View view = nativeViewHierarchyManager.resolveView(id);
                        if (view != null){
                            SecureViewBucket.removeFromSecureViewBucket(view);
                        }
                    } catch(Exception e) {
                        Log.d("UserExperior", "removeFromSecureViewBucket: can't find view by id: " + id);
                    }
                }
            });
        }
    }
}