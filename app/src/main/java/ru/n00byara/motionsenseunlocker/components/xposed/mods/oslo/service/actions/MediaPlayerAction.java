package ru.n00byara.motionsenseunlocker.components.xposed.mods.oslo.service.actions;

import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import ru.n00byara.motionsenseunlocker.components.xposed.mods.XposedModPack;

public class MediaPlayerAction extends XposedModPack {
    private Class<?> MediaPlayerAction;

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        MediaPlayerAction = XposedHelpers.findClass("com.google.oslo.service.actions.MediaPlayerAction", lpparam.classLoader);

        XposedHelpers.findAndHookMethod(MediaPlayerAction, "isSupportedApp", String.class, XC_MethodReplacement.returnConstant(true));
    }
}
