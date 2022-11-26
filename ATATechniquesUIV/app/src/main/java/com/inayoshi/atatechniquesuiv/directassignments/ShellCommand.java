package com.inayoshi.atatechniquesuiv.directassignments;

import android.util.Log;

import com.inayoshi.atatechniquesuiv.MainActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShellCommand {
    public static String trick(String in) {
        String out = "";
        String[] cmd = new String[]{"/system/bin/sh", "-c", "echo "+in};
        Runtime runtime = Runtime.getRuntime();
        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(runtime.exec(cmd).getInputStream()));
            out = bufferedReader.readLine();
        } catch (Exception e) {
            Log.i(MainActivity.TAG, Log.getStackTraceString(e));
        }

        return out;
    }
}
