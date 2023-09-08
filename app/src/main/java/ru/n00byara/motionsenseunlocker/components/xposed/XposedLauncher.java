package ru.n00byara.motionsenseunlocker.components.xposed;

import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import ru.n00byara.motionsenseunlocker.components.xposed.mods.ModPacks;
import ru.n00byara.motionsenseunlocker.components.xposed.mods.XposedModPack;

public class XposedLauncher {
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        for (Class<? extends XposedModPack> mod : ModPacks.getMods(lpparam.packageName)) {
            try {
                XposedModPack instance = mod.getConstructor().newInstance();
                instance.handleLoadPackage(lpparam);
            } catch (Throwable T) {
                XposedBridge.log("Start Error in " + mod.getName());
                XposedBridge.log(T);
            }
        }
    }
}