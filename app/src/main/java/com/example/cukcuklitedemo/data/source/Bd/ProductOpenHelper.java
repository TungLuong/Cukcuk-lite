package com.example.cukcuklitedemo.data.source.Bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ProductOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "cukcuklite.db";
    private static ProductOpenHelper sInstance;
    public final static String DATABASE_PATH = "/data/data/com.example.cukcuklitedemo/databases/";
    private static final int DATABASE_VERSION = 1;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    private ProductOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mContext = context;
    }


    static ProductOpenHelper getInstance(Context context){
        if (sInstance == null) sInstance = new ProductOpenHelper(context);
        return sInstance;
    }

    /**
     * Taọ mới database
     * create by lntung date 5/23/2019
     */
    public void onCreateDatabase() {
        try {
            boolean dbExits = checkDatabaseExits();
            if (dbExits) {

            } else {
                this.getReadableDatabase();
                copyDatabase();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * create by lntung date 5/23/2019
     * Kiểm tra cơ sở dữ liệu đã tồn tại hay chưa
     *
     * @return true cơ sở dữ liệu đã tồn tại, false cơ sở dữ liệu chưa tồn tại
     */
    private boolean checkDatabaseExits() {
        try {
            String dbPath = DATABASE_PATH + DATABASE_NAME;
            File dbFile = new File(dbPath);
            return dbFile.exists();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * create by lntung date 5/23/2019
     * Sao chép dữ liệu vào cơ sở dữ liệu
     */
    private void copyDatabase() {
        try {
            InputStream mInput = mContext.getAssets().open("database/"+DATABASE_NAME);
            String outFileName = DATABASE_PATH + DATABASE_NAME;
            OutputStream mOutput = new FileOutputStream(DATABASE_PATH + DATABASE_NAME);
            byte[] mBuffer = new byte[2024];
            int mLength;
            while ((mLength = mInput.read(mBuffer)) > 0) {
                mOutput.write(mBuffer, 0, mLength);
            }
            mOutput.flush();
            mOutput.close();
            mInput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * create by lntung date 5/23/2019
     * Mở cơ sở dữ liệu
     */
    public void openDatabase() {
        //Open the database
        try {
            String dbPath = DATABASE_PATH + DATABASE_NAME;
            mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * create by lntung date 5/23/2019
     * Đóng cơ sở dữ liệu
     */
    public void closeDB() {
        try {
            if (mDatabase != null) {
                mDatabase.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * created by lntung
     * created date 5/11/2019
     * lấy cơ sở dữ liệu
     *
     * @return cơ sở dữ liệu
     */
    public SQLiteDatabase getDatabase() {
        if (mDatabase == null) openDatabase();
        return this.mDatabase;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
