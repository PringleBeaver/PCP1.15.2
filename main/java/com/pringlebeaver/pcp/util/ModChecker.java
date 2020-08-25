package com.pringlebeaver.pcp.util;


import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoader;

public class ModChecker {

    public static Boolean isAutumnityLoaded;

    public ModChecker() {
        isAutumnityLoaded = ModList.get().isLoaded("autumnity");
    }

}
