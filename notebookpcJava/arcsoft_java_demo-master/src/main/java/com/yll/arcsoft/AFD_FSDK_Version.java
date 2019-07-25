package com.yll.arcsoft;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class AFD_FSDK_Version extends Structure {
    public int lCodebase;
    public int lMajor;
    public int lMinor;
    public int lBuild;
    public String Version;
    public String BuildDate;
    public String CopyRight;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList(new String[] { "lCodebase", "lMajor", "lMinor", "lBuild", "Version", "BuildDate", "CopyRight" });
    }
}
