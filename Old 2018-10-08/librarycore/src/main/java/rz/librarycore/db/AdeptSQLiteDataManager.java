package rz.librarycore.db;

import android.content.Context;

import me.apphive.readnewspaper.BuildConfig;

public class AdeptSQLiteDataManager {
    private Context context;
    private AdeptSQLiteDBCopyHelper sqLiteDBCopyHelper = null;
    //private Cursor cursor;
    private String dbFile = "db-cattle-shurjohms.sqlite3";
    private String dbDir = "/database/";
    private boolean isDebug = false;
    private String debugString = "";

    public AdeptSQLiteDataManager(Context argContext) {
        context = argContext;
        isDebug = false;
        if (BuildConfig.DEBUG) {
            isDebug = true;
        }
    }

    protected AdeptSQLiteDBCopyHelper openDatabase() {
        sqLiteDBCopyHelper = new AdeptSQLiteDBCopyHelper(context, dbFile, dbDir);
        if (sqLiteDBCopyHelper != null) {
            sqLiteDBCopyHelper.onOpenDatabase();
        }
        return sqLiteDBCopyHelper;
    }

    protected void closeDatabase(AdeptSQLiteDBCopyHelper argSqLiteDBCopyHelper) {
        if (sqLiteDBCopyHelper != null) {
            sqLiteDBCopyHelper.onCloseDatabase();
            sqLiteDBCopyHelper = null;
        }
        if (argSqLiteDBCopyHelper != null) {
            argSqLiteDBCopyHelper = null;
        }
    }

    public void sysLog(String argMsg) {
        if (isDebug) {
            System.out.println();
            System.out.println("|----|--------DEBUG_LOG: " + argMsg);
        }
    }

    public void onBackupDb() {
        //System.out.println("|----|--------PRINT: DATABASE_BACKUP");
        if (isDebug) {
            //System.out.println("|----|--------DEBUG_LOG: DATABASE_BACKUP");
            AdeptSQLiteDBCopyHelper sqLiteDBCopyHelper = new AdeptSQLiteDBCopyHelper(context, dbFile, dbDir);
            sqLiteDBCopyHelper.onBackupDb();
        }
    }
}
