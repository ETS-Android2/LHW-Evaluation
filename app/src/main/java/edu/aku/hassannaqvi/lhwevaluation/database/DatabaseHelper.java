package edu.aku.hassannaqvi.lhwevaluation.database;

import static edu.aku.hassannaqvi.lhwevaluation.core.MainApp.IBAHC;
import static edu.aku.hassannaqvi.lhwevaluation.core.MainApp.PROJECT_NAME;
import static edu.aku.hassannaqvi.lhwevaluation.core.MainApp.mwra;
import static edu.aku.hassannaqvi.lhwevaluation.core.UserAuth.checkPassword;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.SQL_ALTER_USERS_DESIGNATION;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.SQL_ALTER_USERS_DIST_ID;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.SQL_ALTER_USERS_ENABLED;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.SQL_ALTER_USERS_ISNEW_USER;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.SQL_ALTER_USERS_PWD_EXPIRY;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.SQL_CREATE_DISTRICT;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.SQL_CREATE_ENTRYLOGS;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.SQL_CREATE_FAMILY_MEMBERS;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.SQL_CREATE_HH_FORMS;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.SQL_CREATE_LHW;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.SQL_CREATE_LHWHH;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.SQL_CREATE_LHW_FORMS;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.SQL_CREATE_LHW_HF;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.SQL_CREATE_MWRALIST;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.SQL_CREATE_RANDOM;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.SQL_CREATE_TEHSIL;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.SQL_CREATE_USERS;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.SQL_CREATE_VERSIONAPP;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.util.Log;
import android.widget.Toast;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteException;
import net.sqlcipher.database.SQLiteOpenHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.lhwevaluation.contracts.TableContracts;
import edu.aku.hassannaqvi.lhwevaluation.contracts.TableContracts.EntryLogTable;
import edu.aku.hassannaqvi.lhwevaluation.contracts.TableContracts.FamilyMembersTable;
import edu.aku.hassannaqvi.lhwevaluation.contracts.TableContracts.HHFormsTable;
import edu.aku.hassannaqvi.lhwevaluation.contracts.TableContracts.LHWFormsTable;
import edu.aku.hassannaqvi.lhwevaluation.contracts.TableContracts.LHWHHTable;
import edu.aku.hassannaqvi.lhwevaluation.contracts.TableContracts.MWRAListTable;
import edu.aku.hassannaqvi.lhwevaluation.contracts.TableContracts.TableDistricts;
import edu.aku.hassannaqvi.lhwevaluation.contracts.TableContracts.TableHealthFacilities;
import edu.aku.hassannaqvi.lhwevaluation.contracts.TableContracts.TableLhw;
import edu.aku.hassannaqvi.lhwevaluation.contracts.TableContracts.TableTehsil;
import edu.aku.hassannaqvi.lhwevaluation.contracts.TableContracts.UsersTable;
import edu.aku.hassannaqvi.lhwevaluation.core.MainApp;
import edu.aku.hassannaqvi.lhwevaluation.models.Districts;
import edu.aku.hassannaqvi.lhwevaluation.models.EntryLog;
import edu.aku.hassannaqvi.lhwevaluation.models.FamilyMembers;
import edu.aku.hassannaqvi.lhwevaluation.models.HHForm;
import edu.aku.hassannaqvi.lhwevaluation.models.HealthFacilities;
import edu.aku.hassannaqvi.lhwevaluation.models.LHW;
import edu.aku.hassannaqvi.lhwevaluation.models.LHWForm;
import edu.aku.hassannaqvi.lhwevaluation.models.LHWHouseholds;
import edu.aku.hassannaqvi.lhwevaluation.models.MWRA;
import edu.aku.hassannaqvi.lhwevaluation.models.RandomHH;
import edu.aku.hassannaqvi.lhwevaluation.models.Tehsil;
import edu.aku.hassannaqvi.lhwevaluation.models.Users;
import edu.aku.hassannaqvi.lhwevaluation.models.VersionApp;




/*import edu.aku.hassannaqvi.naunehal.models.Immunization;*/

/**
 * @author hassan.naqvi on 11/30/2016.
 * @update ali azaz on 01/07/21
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = PROJECT_NAME + ".db";
    public static final String DATABASE_COPY = PROJECT_NAME + "_copy.db";
    private final String TAG = "DatabaseHelper";
    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_PASSWORD = IBAHC;
    private final Context mContext;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_DISTRICT);
        db.execSQL(SQL_CREATE_TEHSIL);
        db.execSQL(SQL_CREATE_LHW);
        db.execSQL(SQL_CREATE_LHW_HF);
        db.execSQL(SQL_CREATE_RANDOM);
        db.execSQL(SQL_CREATE_HH_FORMS);
        db.execSQL(SQL_CREATE_LHW_FORMS);
        db.execSQL(SQL_CREATE_FAMILY_MEMBERS);
        db.execSQL(SQL_CREATE_LHWHH);
        db.execSQL(SQL_CREATE_MWRALIST);
       /* db.execSQL(SQL_CREATE_BLOOD);
        db.execSQL(SQL_CREATE_STOOL);*/
        db.execSQL(SQL_CREATE_VERSIONAPP);
        db.execSQL(SQL_CREATE_ENTRYLOGS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
            case 2:
                db.execSQL(SQL_ALTER_USERS_DIST_ID);
                db.execSQL(SQL_ALTER_USERS_DESIGNATION);
                db.execSQL(SQL_ALTER_USERS_ENABLED);
                db.execSQL(SQL_ALTER_USERS_ISNEW_USER);
                db.execSQL(SQL_ALTER_USERS_PWD_EXPIRY);

        }
    }


    //ADDITION in DB
    public long addHHForm(HHForm HHForm) throws JSONException {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(TableContracts.HHFormsTable.COLUMN_PROJECT_NAME, HHForm.getProjectName());
        values.put(TableContracts.HHFormsTable.COLUMN_UID, HHForm.getUid());
        values.put(TableContracts.HHFormsTable.COLUMN_LHW_CODE, HHForm.getLhwCode());
        values.put(TableContracts.HHFormsTable.COLUMN_KHANDAN_NO, HHForm.getKhandandNo());
        values.put(TableContracts.HHFormsTable.COLUMN_LHW_UID, HHForm.getLhwuid());
        values.put(TableContracts.HHFormsTable.COLUMN_USERNAME, HHForm.getUserName());
        values.put(TableContracts.HHFormsTable.COLUMN_SYSDATE, HHForm.getSysDate());
        values.put(HHFormsTable.COLUMN_SYNCED, HHForm.getSynced());
        values.put(HHFormsTable.COLUMN_SYNCED_DATE, HHForm.getSyncDate());


        values.put(TableContracts.HHFormsTable.COLUMN_SH2, HHForm.sH2toString());
     /*   values.put(TableContracts.HHFormsTable.COLUMN_SH3, hhForm.sH3toString());
        values.put(TableContracts.HHFormsTable.COLUMN_SAB, hhForm.sABtoString());
        values.put(TableContracts.HHFormsTable.COLUMN_SM, hhForm.sMtoString());*/

        values.put(TableContracts.HHFormsTable.COLUMN_ISTATUS, HHForm.getiStatus());
        values.put(TableContracts.HHFormsTable.COLUMN_DEVICETAGID, HHForm.getDeviceTag());
        values.put(TableContracts.HHFormsTable.COLUMN_DEVICEID, HHForm.getDeviceId());
        values.put(TableContracts.HHFormsTable.COLUMN_APPVERSION, HHForm.getAppver());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                TableContracts.HHFormsTable.TABLE_NAME,
                TableContracts.HHFormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public long addFamilyMember(FamilyMembers familyMembers) throws JSONException {
        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(TableContracts.FamilyMembersTable.COLUMN_PROJECT_NAME, familyMembers.getProjectName());
        values.put(TableContracts.FamilyMembersTable.COLUMN_UID, familyMembers.getUid());
        values.put(TableContracts.FamilyMembersTable.COLUMN_UUID, familyMembers.getUuid());
        values.put(TableContracts.FamilyMembersTable.COLUMN_LHW_CODE, familyMembers.getLhwCode());
        values.put(TableContracts.FamilyMembersTable.COLUMN_KHANDAN_NO, familyMembers.getkNo());
        values.put(TableContracts.FamilyMembersTable.COLUMN_USERNAME, familyMembers.getUserName());
        values.put(TableContracts.FamilyMembersTable.COLUMN_SYSDATE, familyMembers.getSysDate());
        values.put(FamilyMembersTable.COLUMN_SYNCED, familyMembers.getSynced());
        values.put(FamilyMembersTable.COLUMN_SYNCED_DATE, familyMembers.getSyncDate());

        values.put(FamilyMembersTable.COLUMN_SH3, familyMembers.sH3toString());
     /*   values.put(TableContracts.FamilyMemberssTable.COLUMN_SH3, familyMembers.sH3toString());
        values.put(TableContracts.FamilyMemberssTable.COLUMN_SAB, familyMembers.sABtoString());
        values.put(TableContracts.FamilyMemberssTable.COLUMN_SM, familyMembers.sMtoString());*/

        values.put(TableContracts.FamilyMembersTable.COLUMN_ISTATUS, familyMembers.getiStatus());
        values.put(TableContracts.FamilyMembersTable.COLUMN_DEVICETAGID, familyMembers.getDeviceTag());
        values.put(TableContracts.FamilyMembersTable.COLUMN_DEVICEID, familyMembers.getDeviceId());
        values.put(TableContracts.FamilyMembersTable.COLUMN_APPVERSION, familyMembers.getAppver());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                TableContracts.FamilyMembersTable.TABLE_NAME,
                TableContracts.FamilyMembersTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public long addLhwForm(LHWForm lhwForm) throws JSONException {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(TableContracts.LHWFormsTable.COLUMN_PROJECT_NAME, lhwForm.getProjectName());
        values.put(TableContracts.LHWFormsTable.COLUMN_UID, lhwForm.getUid());
        values.put(TableContracts.LHWFormsTable.COLUMN_CLUSTER, lhwForm.getCluster());
        values.put(TableContracts.LHWFormsTable.COLUMN_USERNAME, lhwForm.getUserName());
        values.put(TableContracts.LHWFormsTable.COLUMN_SYSDATE, lhwForm.getSysDate());
        values.put(LHWFormsTable.COLUMN_SYNCED, lhwForm.getSynced());
        values.put(LHWFormsTable.COLUMN_SYNCED_DATE, lhwForm.getSyncDate());
        values.put(TableContracts.LHWFormsTable.COLUMN_A101, lhwForm.getA101());
        values.put(TableContracts.LHWFormsTable.COLUMN_A102, lhwForm.getA102());
        values.put(TableContracts.LHWFormsTable.COLUMN_A103, lhwForm.getA103());
        values.put(TableContracts.LHWFormsTable.COLUMN_A104n, lhwForm.getA104n());
        values.put(TableContracts.LHWFormsTable.COLUMN_A104c, lhwForm.getA104c());

        values.put(TableContracts.LHWFormsTable.COLUMN_SL1, lhwForm.sAtoString());


        values.put(TableContracts.LHWFormsTable.COLUMN_ISTATUS, lhwForm.getiStatus());
        values.put(TableContracts.LHWFormsTable.COLUMN_DEVICETAGID, lhwForm.getDeviceTag());
        values.put(TableContracts.LHWFormsTable.COLUMN_DEVICEID, lhwForm.getDeviceId());
        values.put(TableContracts.LHWFormsTable.COLUMN_APPVERSION, lhwForm.getAppver());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                TableContracts.LHWFormsTable.TABLE_NAME,
                TableContracts.LHWFormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addLhwHh(LHWHouseholds LHWHouseholds) throws JSONException {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(TableContracts.LHWHHTable.COLUMN_PROJECT_NAME, LHWHouseholds.getProjectName());
        values.put(TableContracts.LHWHHTable.COLUMN_UID, LHWHouseholds.getUid());
        values.put(TableContracts.LHWHHTable.COLUMN_UUID, LHWHouseholds.getLuid());
        values.put(TableContracts.LHWHHTable.COLUMN_CLUSTER, LHWHouseholds.getCluster());
        values.put(TableContracts.LHWHHTable.COLUMN_HHID, LHWHouseholds.getHhid());
        values.put(TableContracts.LHWHHTable.COLUMN_USERNAME, LHWHouseholds.getUserName());
        values.put(TableContracts.LHWHHTable.COLUMN_SYSDATE, LHWHouseholds.getSysDate());
        values.put(LHWHHTable.COLUMN_SYNCED, LHWHouseholds.getSynced());
        values.put(LHWHHTable.COLUMN_SYNCED_DATE, LHWHouseholds.getSyncDate());

        values.put(TableContracts.LHWHHTable.COLUMN_H101, LHWHouseholds.getH101());
        values.put(TableContracts.LHWHHTable.COLUMN_H102, LHWHouseholds.getH102());
        values.put(TableContracts.LHWHHTable.COLUMN_H103, LHWHouseholds.getH103());
        values.put(TableContracts.LHWHHTable.COLUMN_H104A, LHWHouseholds.getH104a());
        values.put(TableContracts.LHWHHTable.COLUMN_H104B, LHWHouseholds.getH104b());
        values.put(TableContracts.LHWHHTable.COLUMN_H104C, LHWHouseholds.getH104c());
        values.put(TableContracts.LHWHHTable.COLUMN_H104D, LHWHouseholds.getH104d());
        values.put(TableContracts.LHWHHTable.COLUMN_H104E, LHWHouseholds.getH104e());
        values.put(TableContracts.LHWHHTable.COLUMN_H104F, LHWHouseholds.getH104f());
        values.put(TableContracts.LHWHHTable.COLUMN_SIDENT, LHWHouseholds.sIdenttoString());
        values.put(TableContracts.LHWHHTable.COLUMN_LHWPHOTO, LHWHouseholds.getLhwphoto());
        values.put(TableContracts.LHWHHTable.COLUMN_LHW_CODE, LHWHouseholds.getLhwCode());

        values.put(TableContracts.LHWHHTable.COLUMN_ISTATUS, LHWHouseholds.getiStatus());
        values.put(TableContracts.LHWHHTable.COLUMN_DEVICETAGID, LHWHouseholds.getDeviceTag());
        values.put(TableContracts.LHWHHTable.COLUMN_DEVICEID, LHWHouseholds.getDeviceId());
        values.put(TableContracts.LHWHHTable.COLUMN_APPVERSION, LHWHouseholds.getAppver());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                TableContracts.LHWHHTable.TABLE_NAME,
                TableContracts.LHWHHTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addMWRA(MWRA mwra) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(TableContracts.MWRAListTable.COLUMN_PROJECT_NAME, mwra.getProjectName());
        values.put(TableContracts.MWRAListTable.COLUMN_UID, mwra.getUid());
        values.put(TableContracts.MWRAListTable.COLUMN_UUID, mwra.getUuid());
        values.put(TableContracts.MWRAListTable.COLUMN_CLUSTER, mwra.getCluster());
        values.put(TableContracts.MWRAListTable.COLUMN_HHID, mwra.getHhid());
        values.put(TableContracts.MWRAListTable.COLUMN_USERNAME, mwra.getUserName());
        values.put(TableContracts.MWRAListTable.COLUMN_SYSDATE, mwra.getSysDate());
        values.put(TableContracts.MWRAListTable.COLUMN_INDEXED, mwra.getIndexed());
        values.put(MWRAListTable.COLUMN_SYNCED, mwra.getSynced());
        values.put(MWRAListTable.COLUMN_SYNCED_DATE, mwra.getSyncDate());
        values.put(TableContracts.MWRAListTable.COLUMN_SW1, mwra.sW1toString());
      /*  values.put(TableContracts.MWRAListTable.COLUMN_SW2, mwra.sW2toString());
        values.put(TableContracts.MWRAListTable.COLUMN_SW3, mwra.sW3toString());
        values.put(TableContracts.MWRAListTable.COLUMN_SW41, mwra.sW41toString());
        values.put(TableContracts.MWRAListTable.COLUMN_SW42, mwra.sW42toString());
        values.put(TableContracts.MWRAListTable.COLUMN_SW43, mwra.sW43toString());*/

        values.put(TableContracts.MWRAListTable.COLUMN_DEVICEID, mwra.getDeviceId());
        values.put(TableContracts.MWRAListTable.COLUMN_DEVICETAGID, mwra.getDeviceTag());
        values.put(TableContracts.MWRAListTable.COLUMN_APPVERSION, mwra.getAppver());
        values.put(TableContracts.MWRAListTable.COLUMN_ISTATUS, mwra.getiStatus());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                TableContracts.MWRAListTable.TABLE_NAME,
                TableContracts.MWRAListTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    //UPDATE in DB
    public int updatesHHFormColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = TableContracts.HHFormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.hhForm.getId())};

        return db.update(TableContracts.HHFormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesFamilyMembersColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = TableContracts.FamilyMembersTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.familyMembers.getId())};

        return db.update(TableContracts.FamilyMembersTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesLHWFormColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = TableContracts.LHWFormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.LHWForm.getId())};

        return db.update(TableContracts.LHWFormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesMwraColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = TableContracts.MWRAListTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(mwra.getId())};

        return db.update(TableContracts.MWRAListTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesLhwColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = TableContracts.LHWFormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.LHWHouseholds.getId())};

        return db.update(TableContracts.LHWFormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesLhwHhColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = TableContracts.LHWHHTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.LHWHouseholds.getId())};

        return db.update(TableContracts.LHWHHTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updateEnding() {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(TableContracts.HHFormsTable.COLUMN_ISTATUS, MainApp.hhForm.getiStatus());

        // Which row to update, based on the ID
        String selection = TableContracts.HHFormsTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.hhForm.getId())};

        return db.update(TableContracts.HHFormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }


    //Functions that dealing with table data
    public boolean doLogin(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = TableContracts.UsersTable.COLUMN_USERNAME + "=? ";
        String[] whereArgs = {username};
        String groupBy = null;
        String having = null;
        String orderBy = TableContracts.UsersTable.COLUMN_ID + " ASC";

        Users loggedInUser = new Users();
        c = db.query(
                TableContracts.UsersTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            loggedInUser = new Users().hydrate(c);

        }

        c.close();

        db.close();
        if (loggedInUser.getPassword().equals("")) {
            Toast.makeText(mContext, "Stored password is invalid", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (checkPassword(password, loggedInUser.getPassword())) {
            MainApp.user = loggedInUser;
            //  MainApp.selectedDistrict = loggedInUser.getDist_id();
            return c.getCount() > 0;
        } else {
            return false;
        }
    }

    public ArrayList<HHForm> getFormsByDate(String sysdate) {

        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = {
                TableContracts.HHFormsTable._ID,
                TableContracts.HHFormsTable.COLUMN_UID,
                TableContracts.HHFormsTable.COLUMN_SYSDATE,
                TableContracts.HHFormsTable.COLUMN_USERNAME,
                TableContracts.HHFormsTable.COLUMN_ISTATUS,
                TableContracts.HHFormsTable.COLUMN_SYNCED,

        };
        String whereClause = TableContracts.HHFormsTable.COLUMN_SYSDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + sysdate + " %"};
        String groupBy = null;
        String having = null;
        String orderBy = TableContracts.HHFormsTable.COLUMN_ID + " ASC";
        ArrayList<HHForm> allHHForms = new ArrayList<>();
            c = db.query(
                    TableContracts.HHFormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                HHForm forms = new HHForm();
                forms.setId(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_ID)));
                forms.setUid(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_UID)));
                forms.setSysDate(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_SYSDATE)));
                forms.setUserName(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_USERNAME)));
                allHHForms.add(forms);
            }

                db.close();

        return allHHForms;
    }


    // istatus examples: (1) or (1,9) or (1,3,5)
    public HHForm getFormByAssessNo(String uid, String istatus) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = TableContracts.HHFormsTable.COLUMN_UID + "=? AND " +
                TableContracts.HHFormsTable.COLUMN_ISTATUS + " in " + istatus;

        String[] whereArgs = {uid};

        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.HHFormsTable.COLUMN_ID + " ASC";

        HHForm allFC = null;
            c = db.query(
                    TableContracts.HHFormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allFC = new HHForm().Hydrate(c);
            }

                db.close();

        return allFC;
    }

    public ArrayList<Cursor> getDatabaseManagerData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase(DATABASE_PASSWORD);
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(Query, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (Exception sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    /*public int updateTemp(String assessNo, String temp) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(HHFormsTable.COLUMN_TSF305, temp);
        values.put(HHFormsTable.COLUMN_SYSDATE, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()) + "-Updated");
        values.put(HHFormsTable.COLUMN_ISTATUS, "1");
        values.put(HHFormsTable.COLUMN_SYNCED, (byte[]) null);

        String selection = HHFormsTable.COLUMN_ASSESMENT_NO + " =? AND " + HHFormsTable.COLUMN_ISTATUS + " =? ";
        // String selection = HHFormsTable.COLUMN_ASSESMENT_NO + " =? ";
        String[] selectionArgs = {assessNo, "9"};
        // String[] selectionArgs = {assessNo};

        return db.update(HHFormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }*/


    public int syncVersionApp(JSONObject VersionList) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        db.delete(TableContracts.VersionTable.TABLE_NAME, null, null);
        long count = 0;
            JSONObject jsonObjectCC = ((JSONArray) VersionList.get(TableContracts.VersionTable.COLUMN_VERSION_PATH)).getJSONObject(0);
            VersionApp Vc = new VersionApp();
            Vc.sync(jsonObjectCC);

            ContentValues values = new ContentValues();

            values.put(TableContracts.VersionTable.COLUMN_PATH_NAME, Vc.getPathname());
            values.put(TableContracts.VersionTable.COLUMN_VERSION_CODE, Vc.getVersioncode());
            values.put(TableContracts.VersionTable.COLUMN_VERSION_NAME, Vc.getVersionname());

            count = db.insert(TableContracts.VersionTable.TABLE_NAME, null, values);
            if (count > 0) count = 1;


            db.close();


        return (int) count;
    }

    public int syncUser(JSONArray userList) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        db.delete(TableContracts.UsersTable.TABLE_NAME, null, null);
        int insertCount = 0;
            for (int i = 0; i < userList.length(); i++) {

                JSONObject jsonObjectUser = userList.getJSONObject(i);

                Users user = new Users();
                user.sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(UsersTable.COLUMN_USERNAME, user.getUserName());
                values.put(UsersTable.COLUMN_PASSWORD, user.getPassword());
                values.put(UsersTable.COLUMN_FULLNAME, user.getFullname());
                values.put(UsersTable.COLUMN_ENABLED, user.getEnabled());
                values.put(UsersTable.COLUMN_ISNEW_USER, user.getNewUser());
                values.put(UsersTable.COLUMN_PWD_EXPIRY, user.getPwdExpiry());
                values.put(UsersTable.COLUMN_DESIGNATION, user.getDesignation());
                values.put(UsersTable.COLUMN_DIST_ID, user.getDist_id());
                long rowID = db.insert(TableContracts.UsersTable.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }


            db.close();
        return insertCount;
    }

    /*
     * Download data functions
     * */
    public int syncDistricts(JSONArray Districtslist) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        db.delete(TableDistricts.TABLE_NAME, null, null);
        int insertCount = 0;
            for (int i = 0; i < Districtslist.length(); i++) {
                JSONObject jsonObjectDistrict = Districtslist.getJSONObject(i);
                Districts District = new Districts();
                District.sync(jsonObjectDistrict);
                ContentValues values = new ContentValues();

                values.put(TableDistricts.COLUMN_DISTRICT_CODE, District.getDistrictCode());
                values.put(TableDistricts.COLUMN_DISTRICT_NAME, District.getDistrictName());
                long rowID = db.insert(TableDistricts.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }


            db.close();

        return insertCount;
    }

/*    public int syncCluster(JSONArray clusterList) {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        db.delete(TableClusters.TABLE_NAME, null, null);
        int insertCount = 0;
        try {

            for (int i = 0; i < clusterList.length(); i++) {
                JSONObject jsonObjectCluster = clusterList.getJSONObject(i);
                Clusters cluster = new Clusters();
                cluster.sync(jsonObjectCluster);
                ContentValues values = new ContentValues();

                values.put(TableClusters.COLUMN_CLUSTER_CODE, cluster.getClusterCode());
                values.put(TableClusters.COLUMN_CLUSTER_NAME, cluster.getClustername());
                values.put(TableClusters.COLUMN_DIST_CODE, cluster.getDistCode());

                long rowID = db.insert(TableClusters.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }
            db.close();

        } catch (Exception e) {
            Log.d(TAG, "syncCluster(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }*/


   /* public int syncUCs(JSONArray ucList) {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        db.delete(TableUCs.TABLE_NAME, null, null);
        int insertCount = 0;
        try {

            for (int i = 0; i < ucList.length(); i++) {
                JSONObject jsonObjectUc = ucList.getJSONObject(i);
                UCs uc = new UCs();
                uc.sync(jsonObjectUc);
                ContentValues values = new ContentValues();

                values.put(TableUCs.COLUMN_UC_CODE, uc.getUcCode());
                values.put(TableUCs.COLUMN_UC_NAME, uc.getUcName());
                values.put(TableUCs.COLUMN_DISTRICT_CODE, uc.getDistrictCode());

                long rowID = db.insert(TableUCs.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }
            db.close();

        } catch (Exception e) {
            Log.d(TAG, "syncUc(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }
*/
/*
    public int syncVersionApp(JSONObject VersionList) {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        db.delete(VersionTable.TABLE_NAME, null, null);
        long count = 0;
        try {
            JSONObject jsonObjectCC = ((JSONArray) VersionList.get(VersionTable.COLUMN_VERSION_PATH)).getJSONObject(0);
            VersionApp Vc = new VersionApp();
            Vc.sync(jsonObjectCC);

            ContentValues values = new ContentValues();

            values.put(VersionTable.COLUMN_PATH_NAME, Vc.getPathname());
            values.put(VersionTable.COLUMN_VERSION_CODE, Vc.getVersioncode());
            values.put(VersionTable.COLUMN_VERSION_NAME, Vc.getVersionname());

            count = db.insert(VersionTable.TABLE_NAME, null, values);
            if (count > 0) count = 1;

        } catch (Exception ignored) {
        } finally {
            db.close();
        }

        return (int) count;
    }*/


 /*   public int syncUser(JSONArray userList) {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        db.delete(UsersTable.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < userList.length(); i++) {

                JSONObject jsonObjectUser = userList.getJSONObject(i);

                Users user = new Users();
                user.sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(UsersTable.COLUMN_USERNAME, user.getUserName());
                values.put(UsersTable.COLUMN_PASSWORD, user.getPassword());
                values.put(UsersTable.COLUMN_FULLNAME, user.getFullname());
               // values.put(UsersTable.COLUMN_DIST_ID, user.getDist_id());
                long rowID = db.insert(UsersTable.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }*/

    //    Sync LHW
    public int syncLhw(JSONArray lhwList) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        db.delete(TableLhw.TABLE_NAME, null, null);
        int insertCount = 0;

            for (int i = 0; i < lhwList.length(); i++) {
                JSONObject json = lhwList.getJSONObject(i);
                LHW lhw = new LHW();
                lhw.sync(json);
                ContentValues values = new ContentValues();

                values.put(TableLhw.COLUMN_HF_CODE, lhw.getHf_Code());
                values.put(TableLhw.COLUMN_LHW_CODE, lhw.getLhw_Code());
                values.put(TableLhw.COLUMN_LHW_NAME, lhw.getLhw_Name());

                long rowID = db.insert(TableLhw.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }
            db.close();




        return insertCount;
    }

    //    Sync Tehsil
    public int syncTehsil(JSONArray tehsilList) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        db.delete(TableTehsil.TABLE_NAME, null, null);
        int insertCount = 0;


            for (int i = 0; i < tehsilList.length(); i++) {
                JSONObject json = tehsilList.getJSONObject(i);
                Tehsil tehsil = new Tehsil();
                tehsil.sync(json);
                ContentValues values = new ContentValues();

                values.put(TableTehsil.COLUMN_DIST_ID, tehsil.getDist_id());
                values.put(TableTehsil.COLUMN_TEHSIL_NAME, tehsil.getTehsilName());
                values.put(TableTehsil.COLUMN_TEHSIL_CODE, tehsil.getTehsilCode());

                long rowID = db.insert(TableTehsil.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }
            db.close();


            db.close();

        return insertCount;
    }

    //    Sync LHWHF
    public int syncHealthFacilities(JSONArray healthfacilities) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        db.delete(TableHealthFacilities.TABLE_NAME, null, null);
        int insertCount = 0;

        for (int i = 0; i < healthfacilities.length(); i++) {
            JSONObject json = healthfacilities.getJSONObject(i);
            HealthFacilities lhwHF = new HealthFacilities();
            lhwHF.sync(json);
            ContentValues values = new ContentValues();

            values.put(TableHealthFacilities.COLUMN_HF_CODE, lhwHF.getHfCode());
            values.put(TableHealthFacilities.COLUMN_HF_NAME, lhwHF.getHfName());
            values.put(TableHealthFacilities.COLUMN_DIST_ID, lhwHF.getDist_id());

            long rowID = db.insert(TableHealthFacilities.TABLE_NAME, null, values);
            if (rowID != -1) insertCount++;
            }
            db.close();


            db.close();

        return insertCount;
    }


    //get UnSyncedTables

    public JSONArray getUnsyncedLHWForms() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        //whereClause = null;
        whereClause = TableContracts.LHWFormsTable.COLUMN_SYNCED + " = '' ";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.LHWFormsTable.COLUMN_ID + " ASC";

        JSONArray allLHWForms = new JSONArray();

        c = db.query(
                TableContracts.LHWFormsTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            /** WorkManager Upload
             /*hhForm fc = new hhForm();
             allFC.add(fc.Hydrate(c));*/
            Log.d(TAG, "getUnsyncedForms: " + c.getCount());
            LHWForm lhwForm = new LHWForm().Hydrate(c);
            List<LHWHouseholds> lhwhhs = getKhandanNoByLHW(lhwForm.getA104c());
            if (lhwhhs.size() >= 10)
                allLHWForms.put(lhwForm.toJSONObject());


        }

        db.close();

    /*    Log.d(TAG, "getUnsyncedForms: " + LHWForm.toString().length());
        Log.d(TAG, "getUnsyncedForms: " + LHWForm);*/
        return allLHWForms;
    }


    public JSONArray getUnsyncedLHWHHForms() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        //whereClause = null;
        whereClause = TableContracts.LHWHHTable.COLUMN_SYNCED + " = '' ";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.LHWHHTable.COLUMN_ID + " ASC";

        JSONArray allLHWHHForms = new JSONArray();

        c = db.query(
                TableContracts.LHWHHTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            /** WorkManager Upload
             /*hhForm fc = new hhForm();
             allFC.add(fc.Hydrate(c));*/
            Log.d(TAG, "getUnsyncedForms: " + c.getCount());
            LHWHouseholds lhwHousehold = new LHWHouseholds().Hydrate(c);
            List<LHWHouseholds> lhwhhs = getKhandanNoByLHW(lhwHousehold.getLhwCode());
            if (lhwhhs.size() >= 10)
                allLHWHHForms.put(lhwHousehold.toJSONObject());


        }

        db.close();

    /*    Log.d(TAG, "getUnsyncedForms: " + LHWForm.toString().length());
        Log.d(TAG, "getUnsyncedForms: " + LHWForm);*/
        return allLHWHHForms;
    }

    public JSONArray getUnsyncedHHForms() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        //whereClause = null;
        whereClause = TableContracts.HHFormsTable.COLUMN_SYNCED + " ='' AND " +
                TableContracts.HHFormsTable.COLUMN_ISTATUS + "!= ''";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.HHFormsTable.COLUMN_ID + " ASC";

        JSONArray allForms = new JSONArray();

        c = db.query(
                TableContracts.HHFormsTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            /** WorkManager Upload
             /*hhForm fc = new hhForm();
             allFC.add(fc.Hydrate(c));*/
            Log.d(TAG, "getUnsyncedForms: " + c.getCount());
            HHForm HHForm = new HHForm();
            allForms.put(HHForm.Hydrate(c).toJSONObject());


        }

        db.close();

        Log.d(TAG, "getUnsyncedLHWHouseholds: " + allForms.toString().length());
        Log.d(TAG, "getUnsyncedLHWHouseholds: " + allForms);
        return allForms;
    }


    public JSONArray getUnsyncedFamilyMembers() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        //whereClause = null;
        whereClause = FamilyMembersTable.COLUMN_SYNCED + " ='' ";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = FamilyMembersTable.COLUMN_ID + " ASC";

        JSONArray allFamilyMembers = new JSONArray();

        c = db.query(
                FamilyMembersTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            /** WorkManager Upload
             /*hhForm fc = new hhForm();
             allFC.add(fc.Hydrate(c));*/
            Log.d(TAG, "getUnsyncedForms: " + c.getCount());


            FamilyMembers familyMember = new FamilyMembers();
            familyMember = familyMember.Hydrate(c);
            if (checkHHFormStatus(familyMember.getUuid()))
                allFamilyMembers.put(familyMember.toJSONObject());


        }

        db.close();

        Log.d(TAG, "getUnsyncedForms: " + allFamilyMembers.toString().length());
        Log.d(TAG, "getUnsyncedForms: " + allFamilyMembers);
        return allFamilyMembers;
    }


    public JSONArray getUnsyncedMWRA() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        //whereClause = null;
        whereClause = TableContracts.MWRAListTable.COLUMN_SYNCED + " ='' ";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.MWRAListTable.COLUMN_ID + " ASC";

        JSONArray allMWRA = new JSONArray();

        c = db.query(
                TableContracts.MWRAListTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            /** WorkManager Upload
             /*hhForm fc = new hhForm();
             allFC.add(fc.Hydrate(c));*/
            Log.d(TAG, "getUnsyncedForms: " + c.getCount());
            MWRA mwra = new MWRA().Hydrate(c);
            if (checkHHFormStatus(mwra.getUuid()))
                allMWRA.put(mwra.toJSONObject());

        }

        db.close();

    /*    Log.d(TAG, "getUnsyncedForms: " + LHWForm.toString().length());
        Log.d(TAG, "getUnsyncedForms: " + LHWForm);*/
        return allMWRA;
    }

    //update SyncedTables
    public void updateSyncedHouseholdForm(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

// New value for one column
        ContentValues values = new ContentValues();
        values.put(TableContracts.HHFormsTable.COLUMN_SYNCED, true);
        values.put(TableContracts.HHFormsTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = TableContracts.HHFormsTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                TableContracts.HHFormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedFamilyMember(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

// New value for one column
        ContentValues values = new ContentValues();
        values.put(TableContracts.FamilyMembersTable.COLUMN_SYNCED, true);
        values.put(TableContracts.FamilyMembersTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = TableContracts.FamilyMembersTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                TableContracts.FamilyMembersTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    //update SyncedTables
    public void updateSyncedLHWForm(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

// New value for one column
        ContentValues values = new ContentValues();
        values.put(TableContracts.LHWFormsTable.COLUMN_SYNCED, true);
        values.put(TableContracts.LHWFormsTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = TableContracts.LHWFormsTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                TableContracts.LHWFormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedLHWHousehold(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

// New value for one column
        ContentValues values = new ContentValues();
        values.put(TableContracts.LHWHHTable.COLUMN_SYNCED, true);
        values.put(TableContracts.LHWHHTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = TableContracts.LHWHHTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                TableContracts.LHWHHTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedMwraForm(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

// New value for one column
        ContentValues values = new ContentValues();
        values.put(TableContracts.MWRAListTable.COLUMN_SYNCED, true);
        values.put(TableContracts.MWRAListTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = TableContracts.MWRAListTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                TableContracts.MWRAListTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase(DATABASE_PASSWORD);
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {
            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }



    //get Distinct Districts
    public Collection<Districts> getAllDistricts() {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = {TableContracts.TableDistricts.COLUMN_DISTRICT_CODE, TableContracts.TableDistricts.COLUMN_DISTRICT_NAME};

        String orderBy = TableContracts.TableDistricts.COLUMN_DISTRICT_NAME + " ASC";

        Collection<Districts> allDistricts = new ArrayList<>();
            c = db.query(
                    true,
                    TableContracts.TableDistricts.TABLE_NAME,  // The table to query
                    columns,
                    null,
                    null,
                    null,
                    null,
                    orderBy,
                    "5000"

                    // The sort order
            );
            while (c.moveToNext()) {


                Log.d(TAG, "getUnsyncedPreg: " + c.getCount());
                Districts cluster = new Districts();
                cluster.setDistrictCode(c.getString(c.getColumnIndexOrThrow(TableContracts.TableDistricts.COLUMN_DISTRICT_CODE)));
                cluster.setDistrictName(c.getString(c.getColumnIndexOrThrow(TableContracts.TableDistricts.COLUMN_DISTRICT_NAME)));
                allDistricts.add(cluster);

            }

                db.close();



        return allDistricts;
    }


    public RandomHH checkHousehold(String cluster_no, String hh_no) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String selection = TableContracts.RandomTable.COLUMN_CLUSTER_NO + "= ? AND "
                + TableContracts.RandomTable.COLUMN_HH_NO + "= ? ";
        String[] selectionArgs = {cluster_no, hh_no};

        int cCount;
        RandomHH hh = null;
            c = db.query(
                    TableContracts.RandomTable.TABLE_NAME,
                    columns,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    null
            );
            while (c.moveToNext()) {

                hh = new RandomHH().hydrate(c);

            }

                db.close();


        return hh;

    }

    public HHForm getFormByClusterHHNo(String cluster_no, String hh_no) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = TableContracts.HHFormsTable.COLUMN_LHW_CODE + "=? AND " +
                TableContracts.HHFormsTable.COLUMN_KHANDAN_NO + " =? ";

        String[] whereArgs = {cluster_no, hh_no};

        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.HHFormsTable.COLUMN_ID + " ASC";

        HHForm HHForm = null;

            c = db.query(
                    TableContracts.HHFormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
        while (c.moveToNext()) {
            HHForm = new HHForm().Hydrate(c);
        }

        db.close();

        return HHForm;
    }

    public boolean checkHHFormStatus(String uid) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = HHFormsTable.COLUMN_UID + "=? AND " +
                HHFormsTable.COLUMN_ISTATUS + " =? ";

        String[] whereArgs = {uid, "1"};

        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.HHFormsTable.COLUMN_ID + " ASC";

        HHForm HHForm = null;

        c = db.query(
                TableContracts.HHFormsTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy,
                "1"// The sort order
        );

        int cCount = c.getCount();
        db.close();

        return cCount > 0;
    }

    public Collection<HHForm> getFormsByCluster(String cluster) {

        // String sysdate =  spDateT.substring(0, 8).trim()
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = TableContracts.HHFormsTable.COLUMN_LHW_CODE + " = ? ";
        String[] whereArgs = new String[]{cluster};
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy =
                TableContracts.HHFormsTable.COLUMN_ID + " ASC";

        Collection<HHForm> allFC = new ArrayList<>();

            c = db.query(
                    TableContracts.HHFormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                HHForm fc = new HHForm();
                fc.setId(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_ID)));
                fc.setUid(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_UID)));
                fc.setSysDate(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_SYSDATE)));
                fc.setLhwCode(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_LHW_CODE)));
                fc.setKhandandNo(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_KHANDAN_NO)));
                fc.setiStatus(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_SYNCED)));
                allFC.add(fc);
            }

                db.close();

        return allFC;
    }

    public Collection<HHForm> getTodayForms(String sysdate) {

        // String sysdate =  spDateT.substring(0, 8).trim()
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = TableContracts.HHFormsTable.COLUMN_SYSDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + sysdate + " %"};
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.HHFormsTable.COLUMN_ID + " DESC";

        Collection<HHForm> allFC = new ArrayList<>();

            c = db.query(
                    TableContracts.HHFormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                HHForm fc = new HHForm();
                fc.setId(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_ID)));
                fc.setUid(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_UID)));
                fc.setLhwuid(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_LHW_UID)));
                fc.setSysDate(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_SYSDATE)));
                fc.setLhwCode(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_LHW_CODE)));
                fc.setKhandandNo(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_KHANDAN_NO)));
                fc.setiStatus(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_SYNCED)));
                allFC.add(fc);
            }

                db.close();

        return allFC;
    }


    public Collection<HHForm> getPendingForms() {

        // String sysdate =  spDateT.substring(0, 8).trim()
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = TableContracts.HHFormsTable.COLUMN_ISTATUS + " = ?";
        String[] whereArgs = new String[]{""};
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.HHFormsTable.COLUMN_ID + " DESC";

        Collection<HHForm> allFC = new ArrayList<>();
            c = db.query(
                    TableContracts.HHFormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                HHForm fc = new HHForm();
                fc.setId(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_ID)));
                fc.setUid(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_UID)));
                fc.setLhwuid(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_LHW_UID)));
                fc.setSysDate(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_SYSDATE)));
                fc.setLhwCode(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_LHW_CODE)));
                fc.setKhandandNo(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_KHANDAN_NO)));
                fc.setiStatus(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndexOrThrow(TableContracts.HHFormsTable.COLUMN_SYNCED)));
                allFC.add(fc);
            }

                db.close();

        return allFC;
    }


    public List<LHWForm> getAllLHW() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = null;

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.LHWFormsTable.COLUMN_ID + " ASC";

        List<LHWForm> lhws = new ArrayList<>();

            c = db.query(
                    TableContracts.MWRAListTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {

                lhws.add(new LHWForm().Hydrate(c));


            }

                db.close();

        return lhws;
    }


    public List<HHForm> getAllFormsByLHW(String uid) throws JSONException {

        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = TableContracts.HHFormsTable.COLUMN_LHW_UID + " = ? ";

        String[] whereArgs = {uid};

        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.HHFormsTable.COLUMN_ID + " ASC";

        List<HHForm> hhs = new ArrayList<>();

            c = db.query(
                    TableContracts.MWRAListTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {

                hhs.add(new HHForm().Hydrate(c));


            }

                db.close();

        return hhs;
    }

    public Collection<Tehsil> getTehsilByDist(String distCode) {

        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = TableTehsil.COLUMN_DIST_ID + " = ? ";

        String[] whereArgs = {distCode};

        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.TableTehsil.COLUMN_ID + " ASC";

        List<Tehsil> tehsils = new ArrayList<>();

            c = db.query(
                    TableContracts.TableTehsil.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {

                tehsils.add(new Tehsil().hydrate(c));


            }

                db.close();

        return tehsils;
    }

    public Collection<HealthFacilities> getHealthFacilityByDist(String distCode) {

        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = TableHealthFacilities.COLUMN_DIST_ID + " = ? ";

        String[] whereArgs = {distCode};

        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.TableHealthFacilities.COLUMN_ID + " ASC";

        List<HealthFacilities> healthFacilities = new ArrayList<>();

            c = db.query(
                    TableContracts.TableHealthFacilities.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {

                healthFacilities.add(new HealthFacilities().hydrate(c));


            }

                db.close();

        return healthFacilities;
    }

    public Collection<LHW> getLHWByHF(String hfCode) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = TableLhw.COLUMN_HF_CODE + " = ? ";

        String[] whereArgs = {hfCode};

        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.TableLhw.COLUMN_ID + " ASC";

        List<LHW> lhws = new ArrayList<>();

            c = db.query(
                    TableContracts.TableLhw.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {

                lhws.add(new LHW().hydrate(c));


            }

                db.close();

        return lhws;
    }

    public LHWForm getLHWFormByLHWCode(String lhwCode) throws JSONException {

        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause;
        whereClause = LHWFormsTable.COLUMN_A104c + "=? ";

        String[] whereArgs = {lhwCode};

        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.LHWFormsTable.COLUMN_ID + " ASC";

        LHWForm LhwForm = null;

        c = db.query(
                TableContracts.LHWFormsTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            LhwForm = new LHWForm().Hydrate(c);
        }

        db.close();

        return LhwForm;
    }

    public LHWHouseholds getLHWHHBySNo(String lhwCode, String lhwHHSno) throws JSONException {


        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause;
        whereClause = LHWHHTable.COLUMN_LHW_CODE + "=? AND " +
                LHWHHTable.COLUMN_H101 + "=?";

        String[] whereArgs = {lhwCode, lhwHHSno};

        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.LHWHHTable.COLUMN_ID + " ASC";

        LHWHouseholds Lhwhousehold = null;

        c = db.query(
                TableContracts.LHWHHTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            Lhwhousehold = new LHWHouseholds().Hydrate(c);
        }

        db.close();

        return Lhwhousehold;
    }

    public Collection<LHWForm> getRegisteredLhws()  {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = {LHWFormsTable.COLUMN_A104c,LHWFormsTable.COLUMN_A104n} ;

        String whereClause;
        whereClause = null;

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.LHWFormsTable.COLUMN_ID + " ASC";

        List<LHWForm> lhws = new ArrayList<>();

        c = db.query(
                TableContracts.LHWFormsTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {

            LHWForm lhw = new LHWForm();
            lhw.setA104c(c.getString(c.getColumnIndexOrThrow(TableContracts.LHWFormsTable.COLUMN_A104c)));
            lhw.setA104n(c.getString(c.getColumnIndexOrThrow(TableContracts.LHWFormsTable.COLUMN_A104n)));

            lhws.add(lhw);

        }

        db.close();

        return lhws;    }

    public List<LHWHouseholds> getKhandanNoByLHW(String lhwCode) throws JSONException {

        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause;
        whereClause = LHWHHTable.COLUMN_LHW_CODE + "=?";

        String[] whereArgs = {lhwCode};

        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.LHWHHTable.COLUMN_ID + " ASC";

        List<LHWHouseholds>  lhwhhs = new ArrayList<>();

        c = db.query(
                TableContracts.LHWHHTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {

            lhwhhs.add(new LHWHouseholds().Hydrate(c));
        }

        db.close();

        return lhwhhs;
    }

    public int getLHWHHbyLHWCode(String lhwCode) throws JSONException {

        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause;
        whereClause = LHWHHTable.COLUMN_LHW_CODE + "=? ";

        String[] whereArgs = {lhwCode};

        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.LHWHHTable.COLUMN_ID + " ASC";

        int lhwHHCount = 0;

        c = db.query(
                TableContracts.LHWHHTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );

        c.getCount();
        db.close();

        return lhwHHCount;
    }

    public HHForm getHHFormByLHWCode(String lhwCode, String kNo) throws JSONException {

        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause;
        whereClause = HHFormsTable.COLUMN_LHW_CODE + "=? AND " +
                HHFormsTable.COLUMN_KHANDAN_NO + "=?";

        String[] whereArgs = {lhwCode, kNo};

        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.HHFormsTable.COLUMN_ID + " ASC";

        HHForm hhForm = null;

        c = db.query(
                TableContracts.HHFormsTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            hhForm = new HHForm().Hydrate(c);
        }

        db.close();

        return hhForm;
    }

        public List<FamilyMembers> getMemberBYUID(String uid) throws JSONException {
            SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
            Cursor c = null;
            String[] columns = null;

            String whereClause;
            whereClause = FamilyMembersTable.COLUMN_UUID + "=?";

            String[] whereArgs = {uid};

            String groupBy = null;
            String having = null;

            String orderBy = FamilyMembersTable.COLUMN_ID + " ASC";

            ArrayList<FamilyMembers> membersByUID = new ArrayList<>();
            try {
                c = db.query(
                        FamilyMembersTable.TABLE_NAME,  // The table to query
                        columns,                   // The columns to return
                        whereClause,               // The columns for the WHERE clause
                        whereArgs,                 // The values for the WHERE clause
                        groupBy,                   // don't group the rows
                        having,                    // don't filter by row groups
                        orderBy                    // The sort order
                );
                while (c.moveToNext()) {
                    FamilyMembers mwra = new FamilyMembers().Hydrate(c);

                    membersByUID.add(mwra);
                }
            } finally {
                if (c != null) {
                    c.close();
                }
                if (db != null) {
                    db.close();
                }
            }
            return membersByUID;
        }

    public MWRA getMwraByUUid() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause;
        whereClause = MWRAListTable.COLUMN_UUID + "=? ";

        String[] whereArgs = {MainApp.hhForm.getUid()};

        String groupBy = null;
        String having = null;

        String orderBy = TableContracts.MWRAListTable.COLUMN_ID + " ASC";

        MWRA mwra = null;

        c = db.query(
                TableContracts.MWRAListTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            mwra = new MWRA().Hydrate(c);
        }

        db.close();

        return mwra;
    }

    public Long addEntryLog(EntryLog entryLog) throws SQLiteException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(EntryLogTable.COLUMN_PROJECT_NAME, entryLog.getProjectName());
        values.put(EntryLogTable.COLUMN_UUID, entryLog.getUuid());
        values.put(EntryLogTable.COLUMN_PSU_CODE, entryLog.getPsuCode());
        values.put(EntryLogTable.COLUMN_HHID, entryLog.getHhid());
        values.put(EntryLogTable.COLUMN_USERNAME, entryLog.getUserName());
        values.put(EntryLogTable.COLUMN_SYSDATE, entryLog.getSysDate());
        values.put(EntryLogTable.COLUMN_ISTATUS, entryLog.getiStatus());
        values.put(EntryLogTable.COLUMN_ISTATUS96x, entryLog.getiStatus96x());
        values.put(EntryLogTable.COLUMN_ENTRY_TYPE, entryLog.getEntryType());
        values.put(EntryLogTable.COLUMN_ENTRY_DATE, entryLog.getEntryDate());
        values.put(EntryLogTable.COLUMN_DEVICEID, entryLog.getDeviceId());
        values.put(EntryLogTable.COLUMN_SYNCED, entryLog.getSynced());
        values.put(EntryLogTable.COLUMN_SYNC_DATE, entryLog.getSyncDate());
        values.put(EntryLogTable.COLUMN_APPVERSION, entryLog.getAppver());

        long newRowId;
        newRowId = db.insertOrThrow(
                EntryLogTable.TABLE_NAME,
                EntryLogTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public int updatesEntryLogColumn(String column, String value, String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = EntryLogTable._ID + " =? ";
        String[] selectionArgs = {id};

        return db.update(EntryLogTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public JSONArray getUnsyncedEntryLog() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause;
        whereClause = EntryLogTable.COLUMN_SYNCED + " = '' ";

        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = EntryLogTable.COLUMN_ID + " ASC";

        JSONArray all = new JSONArray();
        c = db.query(
                EntryLogTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            Log.d(TAG, "getUnsyncedEntryLog: " + c.getCount());
            EntryLog entryLog = new EntryLog();
            all.put(entryLog.Hydrate(c).toJSONObject());
        }
        Log.d(TAG, "getUnsyncedEntryLog: " + all.toString().length());
        Log.d(TAG, "getUnsyncedEntryLog: " + all);
        return all;
    }

    public void updateSyncedEntryLog(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(EntryLogTable.COLUMN_SYNCED, true);
        values.put(EntryLogTable.COLUMN_SYNC_DATE, new Date().toString());
        String where = EntryLogTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};
        int count = db.update(
                EntryLogTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public int updatePassword(String hashedPassword) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(UsersTable.COLUMN_PASSWORD, hashedPassword);
        values.put(UsersTable.COLUMN_ISNEW_USER, "");

        String selection = UsersTable.COLUMN_USERNAME + " =? ";
        String[] selectionArgs = {MainApp.user.getUserName()};

        return db.update(UsersTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }
}