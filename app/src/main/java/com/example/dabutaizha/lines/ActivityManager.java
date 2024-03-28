package com.example.dabutaizha.lines;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityManager {
    private static List<Activity> mListActivities = new ArrayList<>();
    public static void addActivity(Activity activity){
        mListActivities.add(activity);
    }
    public static void removeActivity(Activity activity) {
        mListActivities.remove(activity);
    }

    public static void removeAllActivities() {
        mListActivities.clear();
    }
    public static void finishAllActivities() {
        for (Activity activity : mListActivities) {
            if (activity != null && !activity.isFinishing()) {
                activity.finish();
            }
        }
        removeAllActivities();
    }
}
