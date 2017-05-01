package edu.uta.cse.proggen.classLevelElements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Aditya on 030, 30 Apr, 2017.
 */
public class ManifestGenerator {
    public ManifestGenerator(String path, int numberOfActivities) {
        File file = new File(path + ("AndroidManifest.xml"));
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(generateManifestTag());
            bufferedWriter.write(generateApplicationTag());
            for (int i = 0; i < numberOfActivities; i++) {
                bufferedWriter.write(generateActivityTag(i + 1));
            }
            bufferedWriter.write(closeApplicationTag());
            bufferedWriter.write(closeManifestTag());

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String closeManifestTag() {
        return "</manifest>";
    }

    private String closeApplicationTag() {
        return "</application>";
    }

    private String generateActivityTag(int activityNumber) {
        if (activityNumber - 1 == 0) {
            return "<activity android:name=\"com.advancedse.project.MainActivity" + activityNumber + "\">\n" +
                    "            <intent-filter>\n" +
                    "                <action android:name=\"android.intent.action.MAIN\" />\n" +
                    "\n" +
                    "                <category android:name=\"android.intent.category.LAUNCHER\" />\n" +
                    "            </intent-filter>\n" +
                    "        </activity>";
        } else return "<activity android:name=\"com.advancedse.project.MainActivity" + activityNumber + "\"/>\n";
    }

    private String generateApplicationTag() {
        return "    <application\n" +
                "        android:allowBackup=\"true\"\n" +
                "        android:icon=\"@mipmap/ic_launcher\"\n" +
                "        android:label=\"@string/app_name\"\n" +
                "        android:roundIcon=\"@mipmap/ic_launcher_round\"\n" +
                "        android:supportsRtl=\"true\"\n" +
                "        android:theme=\"@style/AppTheme\">\n";
    }

    private String generateManifestTag() {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    package=\"com.advancedse.project\">\n";
    }
}
