package ru.n00byara.motionsenseunlocker.components.xposed;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XposedEntry implements IXposedHookLoadPackage {
    private XposedLauncher XposedLauncher = new XposedLauncher();

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (android.os.Build.VERSION.SDK_INT != 33) {
            XposedBridge.log("Android 13 supported only!");
            return;
        }

        XposedLauncher.handleLoadPackage(lpparam);
    }
}
