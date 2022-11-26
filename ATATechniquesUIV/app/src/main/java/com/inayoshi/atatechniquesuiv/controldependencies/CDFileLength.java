package com.inayoshi.atatechniquesuiv.controldependencies;

import android.util.Log;

import com.inayoshi.atatechniquesuiv.MainActivity;

import java.io.File;
import java.io.FileOutputStream;

public class CDFileLength {
    public static String trick(String in, File filesDir) {
        String out = "";
        String filename = "secret.txt";

        for (int i = 0; i < in.length(); i++) {
            String string = "";
            for (int j = 0; j < in.charAt(i); j++) {
                string = string + "A";
            }

            try {
                File file = new File(filesDir, filename);

                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(string.getBytes());

                out += (char) file.length();
                file.delete();
            } catch (Exception e) {
                Log.i(MainActivity.TAG, Log.getStackTraceString(e));
            }
        }

        return out;
    }
}
