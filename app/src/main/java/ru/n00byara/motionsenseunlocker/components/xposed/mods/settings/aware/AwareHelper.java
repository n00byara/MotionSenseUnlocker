package ru.n00byara.motionsenseunlocker.components.xposed.mods.settings.aware;

import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import ru.n00byara.motionsenseunlocker.components.xposed.mods.XposedModPack;

public class AwareHelper extends XposedModPack {
    private Class<?> AwareHelper;
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        AwareHelper = XposedHelpers.findClass("com.google.android.settings.aware.AwareHelper", lpparam.classLoader);

        XposedHelpers.findAndHookMethod(AwareHelper, "isAirplaneModeOn", XC_MethodReplacement.returnConstant(false));
        XposedHelpers.findAndHookMethod(AwareHelper, "isBatterySaverModeOn", XC_MethodReplacement.returnConstant(false));
    }
}
