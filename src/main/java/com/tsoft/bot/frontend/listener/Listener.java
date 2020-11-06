package com.tsoft.bot.frontend.listener;

import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.FileHelper;

public class Listener {

    private static boolean DELETED_FILES = false;

    public void onTestStart(String name) {
        try {
            ExtentReportUtil.INSTANCE.createTest(name);
        } catch (Exception e) {
            System.out.println("[ERROR CRL-4213] Error en onTestStart: " + e.getMessage());
        }
    }

    public void onStart() {
        if (!DELETED_FILES) {
            FileHelper.deleteFolderElements("/img");
            DELETED_FILES = true;
        }
    }

    public void onFinish() {
        ExtentReportUtil.INSTANCE.flushReport();
    }
}
