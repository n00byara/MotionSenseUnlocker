package ru.n00byara.motionsenseunlocker.components.xposed;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Xposed implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (android.os.Build.VERSION.SDK_INT != 33) {
            XposedBridge.log("Android 13 supported only!");
            return;
        }

        if (lpparam.packageName.equals("com.google.oslo")) {
            XposedHelpers.findAndHookMethod("com.google.oslo.service.actions.MediaPlayerAction", lpparam.classLoader,"isSupportedApp", String.class, new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                    return true;
                }
            });

            Class<?> OsloEnableDetector = XposedHelpers.findClass("com.google.oslo.service.OsloEnableDetector", lpparam.classLoader);
            XposedHelpers.findAndHookMethod(OsloEnableDetector, "getAirplaneModeEnabled", new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                    return false;
                }
            });

            XposedHelpers.findAndHookMethod(OsloEnableDetector, "getBatterySaverEnabled", new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                    return false;
                }
            });

            XposedHelpers.findAndHookMethod(OsloEnableDetector, "getCountryOverride", new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                    return true;
                }
            });
        }

        if (lpparam.packageName.equals("com.android.settings")) {
            Class<?> AwareHelper = XposedHelpers.findClass("com.google.android.settings.aware.AwareHelper", lpparam.classLoader);

            XposedHelpers.findAndHookMethod(AwareHelper, "isAirplaneModeOn", new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                    return false;
                }
            });

            XposedHelpers.findAndHookMethod(AwareHelper, "isBatterySaverModeOn", new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                    return false;
                }
            });
        }
    }
}
