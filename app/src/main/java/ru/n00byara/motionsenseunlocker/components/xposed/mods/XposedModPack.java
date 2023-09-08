package ru.n00byara.motionsenseunlocker.components.xposed.mods;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

public abstract class XposedModPack {
    public abstract void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable;
}