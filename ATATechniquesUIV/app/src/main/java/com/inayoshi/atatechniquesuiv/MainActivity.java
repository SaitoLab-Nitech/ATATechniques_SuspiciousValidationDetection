package com.inayoshi.atatechniquesuiv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ContentFrameLayout;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;

import com.inayoshi.atatechniquesuiv.controldependencies.CDBitmapPixel;
import com.inayoshi.atatechniquesuiv.controldependencies.CDClipboardLength;
import com.inayoshi.atatechniquesuiv.controldependencies.CDDirectBuffer;
import com.inayoshi.atatechniquesuiv.controldependencies.CDFileLastModified;
import com.inayoshi.atatechniquesuiv.controldependencies.CDFileLength;
import com.inayoshi.atatechniquesuiv.controldependencies.CDFileShellHybrid;
import com.inayoshi.atatechniquesuiv.controldependencies.CDLookupTable;
import com.inayoshi.atatechniquesuiv.controldependencies.CDShellCommand;
import com.inayoshi.atatechniquesuiv.controldependencies.CDTextScaling;
import com.inayoshi.atatechniquesuiv.controldependencies.CDTimekeeper;
import com.inayoshi.atatechniquesuiv.controldependencies.CountToX;
import com.inayoshi.atatechniquesuiv.controldependencies.ExceptionError;
import com.inayoshi.atatechniquesuiv.controldependencies.RemoteControl;
import com.inayoshi.atatechniquesuiv.controldependencies.RemoteDex;
import com.inayoshi.atatechniquesuiv.controldependencies.SimpleEncoding;
import com.inayoshi.atatechniquesuiv.directassignments.FileLastModified;
import com.inayoshi.atatechniquesuiv.directassignments.FileShellHybrid;
import com.inayoshi.atatechniquesuiv.directassignments.ShellCommand;
import com.inayoshi.atatechniquesuiv.directassignments.TextScaling;
import com.inayoshi.atatechniquesuiv.memoryoperations.BitmapPixel;
import com.inayoshi.atatechniquesuiv.memoryoperations.ClipboardLength;
import com.inayoshi.atatechniquesuiv.memoryoperations.FileLength;
import com.inayoshi.atatechniquesuiv.memoryoperations.ReverseDirectBuffer;
import com.inayoshi.atatechniquesuiv.memoryoperations.ReverseLookupTable;
import com.inayoshi.atatechniquesuiv.timingchannels.TCCountToX;
import com.inayoshi.atatechniquesuiv.timingchannels.TCExceptionError;
import com.inayoshi.atatechniquesuiv.timingchannels.TCFileShellHybrid;
import com.inayoshi.atatechniquesuiv.timingchannels.TCRemoteDex;
import com.inayoshi.atatechniquesuiv.timingchannels.TCShellCommand;
import com.inayoshi.atatechniquesuiv.timingchannels.TCSimpleEncoding;
import com.inayoshi.atatechniquesuiv.timingchannels.Timekeeper;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "ATATechniquesUIV";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.input);
        final Button button = findViewById(R.id.button);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("password", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user", "secret");
        editor.commit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput(editText.getText().toString());
            }
        });
    }

    private void validateInput(String srcTainted) {

        File filesDir = getFilesDir();
        TextView textView = findViewById(R.id.test);
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        // TAINT SOURCE (User Input)
        Log.i(TAG, "[source] tainted value: " + srcTainted);

        // ATA TECHNIQUES
        String srcUntainted = "";
        //// Test
        //srcUntainted = testTechnique(srcTainted);

        //// Direct-assignment (DA) flows: 4 techniques
        //srcUntainted = ShellCommand.trick(srcTainted);
        //srcUntainted = FileShellHybrid.trick(srcTainted, filesDir);
        //srcUntainted = TextScaling.trick(srcTainted, textView);
        //srcUntainted = FileLastModified.trick(srcTainted, filesDir);

        //// Memory-operation (MO) flows: 5 techniques
        //srcUntainted = FileLength.trick(srcTainted, filesDir);
        //srcUntainted = ClipboardLength.trick(srcTainted, clipboardManager);
        //srcUntainted = BitmapPixel.trick(srcTainted);
        //srcUntainted = ReverseDirectBuffer.trick(srcTainted);
        //srcUntainted = ReverseLookupTable.trick(srcTainted);

        //// Control-dependence (CD) flows: 15 techniques
        //srcUntainted = SimpleEncoding.trick(srcTainted);
        //srcUntainted = CountToX.trick(srcTainted);
        //srcUntainted = ExceptionError.trick(srcTainted);
        //srcUntainted = CDShellCommand.trick(srcTainted);
        //srcUntainted = CDFileShellHybrid.trick(srcTainted);
        //srcUntainted = CDTimekeeper.trick(srcTainted);
        //srcUntainted = CDFileLength.trick(srcTainted, filesDir);
        //srcUntainted = CDClipboardLength.trick(srcTainted, clipboardManager);
        //srcUntainted = CDBitmapPixel.trick(srcTainted);
        //srcUntainted = CDDirectBuffer.trick(srcTainted);
        //srcUntainted = CDTextScaling.trick(srcTainted, textView);
        //srcUntainted = CDFileLastModified.trick(srcTainted, filesDir);
        //srcUntainted = CDLookupTable.trick(srcTainted);
        srcUntainted = RemoteControl.trick(srcTainted);
        //srcUntainted = RemoteDex.trick(srcTainted);

        //// Timing-channel (TC) flows: 7 techniques
        //srcUntainted = TCSimpleEncoding.trick(srcTainted);
        //srcUntainted = TCCountToX.trick(srcTainted);
        //srcUntainted = TCExceptionError.trick(srcTainted);
        //srcUntainted = TCShellCommand.trick(srcTainted);
        //srcUntainted = TCFileShellHybrid.trick(srcTainted, filesDir);
        //srcUntainted = Timekeeper.trick(srcTainted);
        //srcUntainted = TCRemoteDex.trick(srcTainted);

        // TAINT SINK
        Log.i(TAG, "[sink] untainted value:" + srcUntainted);
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("password", Context.MODE_PRIVATE);
        String userPassword = sharedPreferences.getString("user", "non_exist");

        if (srcUntainted.equals(userPassword) || srcUntainted.equals("master")) {
            Toast.makeText(getApplicationContext(), "Authentication succeeded", Toast.LENGTH_LONG).show();
            textView.setText("Succeeded");
        } else{
            Toast.makeText(getApplicationContext(), "Authentication failed", Toast.LENGTH_LONG).show();
            textView.setText("Failed");
        }
    }

    private String testTechnique(String in) { return in; }
}