package ru.n00byara.motionsenseunlocker.components.xposed.mods.oslo.service;

import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import ru.n00byara.motionsenseunlocker.components.xposed.mods.XposedModPack;

public class OsloEnableDetector extends XposedModPack {
    private Class<?> OsloEnableDetector;
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        OsloEnableDetector = XposedHelpers.findClass("com.google.oslo.service.OsloEnableDetector", lpparam.classLoader);

        XposedHelpers.findAndHookMethod(OsloEnableDetector, "getAirplaneModeEnabled", XC_MethodReplacement.returnConstant(false));
        XposedHelpers.findAndHookMethod(OsloEnableDetector, "getBatterySaverEnabled", XC_MethodReplacement.returnConstant(false));
        XposedHelpers.findAndHookMethod(OsloEnableDetector, "getCountryOverride", XC_MethodReplacement.returnConstant(true));
    }
}
