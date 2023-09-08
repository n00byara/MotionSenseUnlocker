package ru.n00byara.motionsenseunlocker.components.xposed.mods;

import java.util.ArrayList;

import ru.n00byara.motionsenseunlocker.components.xposed.mods.oslo.service.OsloEnableDetector;
import ru.n00byara.motionsenseunlocker.components.xposed.mods.oslo.service.actions.MediaPlayerAction;
import ru.n00byara.motionsenseunlocker.components.xposed.mods.settings.aware.AwareHelper;

public class ModPacks {
    public static ArrayList<Class<? extends XposedModPack>> getMods(String packageName) {
        ArrayList<Class<? extends XposedModPack>> modPacks = new ArrayList<>();

        switch (packageName) {
            case Constants.OSLO_PACKAGE:
                modPacks.add(MediaPlayerAction.class);
                modPacks.add(OsloEnableDetector.class);
                break;
            case Constants.SETTINGS_PACKAGE:
                modPacks.add(AwareHelper.class);
                break;
        }

        return modPacks;
    }
}
