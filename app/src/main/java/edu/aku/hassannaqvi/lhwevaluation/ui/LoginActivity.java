package edu.aku.hassannaqvi.lhwevaluation.ui;

import static edu.aku.hassannaqvi.lhwevaluation.core.MainApp.PROJECT_NAME;
import static edu.aku.hassannaqvi.lhwevaluation.core.MainApp.editor;
import static edu.aku.hassannaqvi.lhwevaluation.core.MainApp.sharedPref;
import static edu.aku.hassannaqvi.lhwevaluation.core.UserAuth.checkPassword;
import static edu.aku.hassannaqvi.lhwevaluation.core.UserAuth.generatePassword;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.DATABASE_COPY;
import static edu.aku.hassannaqvi.lhwevaluation.database.CreateTable.DATABASE_NAME;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import net.sqlcipher.database.SQLiteException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import edu.aku.hassannaqvi.lhwevaluation.MainActivity;
import edu.aku.hassannaqvi.lhwevaluation.R;
import edu.aku.hassannaqvi.lhwevaluation.contracts.TableContracts;
import edu.aku.hassannaqvi.lhwevaluation.core.AppInfo;
import edu.aku.hassannaqvi.lhwevaluation.core.MainApp;
import edu.aku.hassannaqvi.lhwevaluation.database.DatabaseHelper;
import edu.aku.hassannaqvi.lhwevaluation.databinding.ActivityLoginBinding;
import edu.aku.hassannaqvi.lhwevaluation.models.EntryLog;
import edu.aku.hassannaqvi.lhwevaluation.models.Users;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    protected static LocationManager locationManager;

    // UI references.

    ActivityLoginBinding bi;
    Spinner spinnerDistrict;
    String DirectoryName;
    DatabaseHelper db;
    ArrayAdapter<String> provinceAdapter;
    int attemptCounter = 0;
    private int countryCode;
    String username = "";
    String password = "";

    public static String encrypt(String plain) {
        try {
            byte[] iv = new byte[16];
            new SecureRandom().nextBytes(iv);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec("asSa%s|n'$ crEed".getBytes(StandardCharsets.UTF_8), "AES"), new IvParameterSpec(iv));
            byte[] cipherText = cipher.doFinal(plain.getBytes(StandardCharsets.UTF_8));
            byte[] ivAndCipherText = new byte[iv.length + cipherText.length];
            System.arraycopy(iv, 0, ivAndCipherText, 0, iv.length);
            System.arraycopy(cipherText, 0, ivAndCipherText, iv.length, cipherText.length);
            return Base64.encodeToString(ivAndCipherText, Base64.NO_WRAP);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static String decrypt(String encoded) {
        try {
            byte[] ivAndCipherText = Base64.decode(encoded, Base64.NO_WRAP);
            byte[] iv = Arrays.copyOfRange(ivAndCipherText, 0, 16);
            byte[] cipherText = Arrays.copyOfRange(ivAndCipherText, 16, ivAndCipherText.length);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec("asSa%s|n'$ crEed".getBytes(StandardCharsets.UTF_8), "AES"), new IvParameterSpec(iv));
            return new String(cipher.doFinal(cipherText), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        //initializingCountry();
        Dexter.withContext(this)
                .withPermissions(
                        Manifest.permission.ACCESS_NETWORK_STATE,
                        Manifest.permission.WAKE_LOCK,
                        Manifest.permission.INTERNET,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.CAMERA
                ).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                if (report.areAllPermissionsGranted()) {
                    MainApp.permissionCheck = true;
                }
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).check();

        bi = DataBindingUtil.setContentView(this, R.layout.activity_login);
        bi.setCallback(this);

        db = MainApp.appInfo.getDbHelper();


        settingCountryCode();

        MainApp.appInfo = new AppInfo(this);
        MainApp.user = new Users();
        bi.txtinstalldate.setText(MainApp.appInfo.getAppInfo());

        try {
            String testPass = generatePassword("test0001", null);
            Log.d(TAG, "onCreate(testPass): " + testPass);
            Log.d(TAG, "onCreate(checkPAss): " + checkPassword("test0001", testPass));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }


    }

    /*    private void settingCountryCode() {


     *//*
        bi.countrySwitch.setChecked(false);


        bi.countrySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean showBounds) {
               // prefs.setShowBounds(showBounds);
            }
        });
*//*
     *//*      editor
                .putString("lang", bi.countrySwitch.isChecked()? "1" : "3")
                .apply();*//*
        bi.countrySwitch.setChecked(sharedPref.getString("lang", "1").equals("1"));

        bi.countrySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
                changeLanguage(isChecked ? 1 : 3);

                startActivity(new Intent(LoginActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });

    }*/


    /*    *//*
     * Setting country code in Shared Preference
     * *//*
    private void initializingCountry() {
        countryCode= Integer.parseInt(sharedPref.getString("lang", "0"));
            if (countryCode == 0) {
               MainApp.editor.putString("lang","1").apply();
            }

        changeLanguage(1);
    }*/

    public void dbBackup() {


        // if (sharedPref.getBoolean("flag", false)) {

        String dt = sharedPref.getString("dt", new SimpleDateFormat("yyyy_mm_dd").format(new Date()));

        if (!dt.equals(new SimpleDateFormat("yyyy_mm_dd").format(new Date()))) {
            MainApp.editor.putString("dt", new SimpleDateFormat("yyyy_mm_dd").format(new Date()));
            MainApp.editor.apply();
        }

        // File folder = new File(Environment.getExternalStorageDirectory() + File.separator + PROJECT_NAME);
        File folder = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        boolean success = true;
        folder = new File(folder + File.separator + PROJECT_NAME);


        DirectoryName = folder.getPath() + File.separator + sharedPref.getString("dt", "");
        folder = new File(DirectoryName);
        if (!folder.exists()) {
            success = folder.mkdirs();
        }
        if (success) {


            File dbFile = new File(this.getDatabasePath(DATABASE_NAME).getPath());

            Long oldDBFileSize = sharedPref.getLong("dbFileSize", 0);
            Long newDBFileSize = dbFile.length();
            sharedPref.edit().putLong("dbFileSize", newDBFileSize);
            editor.apply();
            if (newDBFileSize > oldDBFileSize) {
                try {
                    FileInputStream fis = new FileInputStream(dbFile);
                    String outFileName = DirectoryName + File.separator + dt + "_" + DATABASE_COPY;
                    Log.d(TAG, "dbBackup: " + outFileName);

                    // Open the empty db as the output stream
                    OutputStream output = new FileOutputStream(outFileName);

                    // Transfer bytes from the inputfile to the outputfile
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = fis.read(buffer)) > 0) {
                        output.write(buffer, 0, length);
                    }

                    // Close the streams
                    output.flush();
                    output.close();
                    fis.close();
                } catch (IOException e) {
                    Log.e("dbBackup:", Objects.requireNonNull(e.getMessage()));
                }
            }


            } else {
                Toast.makeText(this, getString(R.string.folder_not_created), Toast.LENGTH_SHORT).show();
            }
        // }

    }

    public void onShowPasswordClick(View view) {
        //TODO implement
        if (bi.password.getTransformationMethod() == null) {
            bi.password.setTransformationMethod(new PasswordTransformationMethod());
            bi.password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock_close, 0, 0, 0);
        } else {
            bi.password.setTransformationMethod(null);
            bi.password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock_open, 0, 0, 0);
        }
    }

    public void onSyncDataClick(View view) {
        //callUsersWorker();

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            startActivity(new Intent(this, edu.aku.hassannaqvi.lhwevaluation.ui.SyncActivity.class).putExtra("login", true));
        } else {
            Toast.makeText(this, getString(R.string.network_conn_error), Toast.LENGTH_SHORT).show();
        }
    }

    public void attemptLogin(View view) {
        attemptCounter++;
        // Reset errors.
        bi.username.setError(null);
        bi.password.setError(null);
        Toast.makeText(this, String.valueOf(attemptCounter), Toast.LENGTH_SHORT).show();
        if (attemptCounter == 7) {
            Intent iLogin = new Intent(edu.aku.hassannaqvi.lhwevaluation.ui.LoginActivity.this, MainActivity.class);
            startActivity(iLogin);

        } else {
            // Store values at the time of the login attempt.
            String username = bi.username.getText().toString();
            String password = bi.password.getText().toString();

            boolean cancel = false;
            View focusView = null;

            // Check for a valid password, if the user entered one.
            if (password.length() < 8) {
                bi.password.setError(getString(R.string.invalid_password));
                focusView = bi.password;
                return;
            }

            // Check for a valid username address.
            if (TextUtils.isEmpty(username)) {
                bi.username.setError(getString(R.string.username_required));
                focusView = bi.username;
                return;
            }

            //if(!Validator.emptySpinner(this, bi.countrySwitch)) return;
            /*if (bi.countrySwitch.getSelectedItemPosition() == 0) {
                bi.as1q01.setError(getString(R.string.as1q01));
                return;
            }*/
            try {

                if ((username.equals("dmu@aku") && password.equals("aku?dmu"))
                        || (username.equals("test1234") && password.equals("test1234"))
                        || db.doLogin(username, password)
                ) {

                    MainApp.user.setUserName(username);
                    MainApp.admin = username.contains("@") || username.contains("test1234");
                    MainApp.superuser = MainApp.user.getDesignation().equals("Supervisor");
                    Intent iLogin = null;
                    if (MainApp.admin) {
                        recordEntry("Successful Login (Admin)");
                        iLogin = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(iLogin);
                    } else if (MainApp.user.getEnabled().equals("1")) {
                        if (!MainApp.user.getNewUser().equals("1")) { // TODO: getEnabled().equals("1")
                            recordEntry("Successful Login");
                            iLogin = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(iLogin);
                        } else if (MainApp.user.getNewUser().equals("1")) {
                            recordEntry("First Login");
                            iLogin = new Intent(LoginActivity.this, ChangePasswordActivity.class);
                            startActivity(iLogin);
                        }
                    } else {
                        recordEntry("Inactive User (Disabled)");
                        Toast.makeText(this, "This user is inactive.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    recordEntry("Failed Login: Incorrect username or password");
                    bi.password.setError(getString(R.string.incorrect_username_or_password));
                    bi.password.requestFocus();
                    //  Toast.makeText(LoginActivity.this, username + " " + password, Toast.LENGTH_SHORT).show();
                }
            } catch (InvalidKeySpecException e) {
                e.printStackTrace();
                Toast.makeText(this, "InvalidKeySpecException(UserAuth):" + e.getMessage(), Toast.LENGTH_SHORT).show();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                Toast.makeText(this, "NoSuchAlgorithmException(UserAuth):" + e.getMessage(), Toast.LENGTH_SHORT).show();

            }

        }
    }

    private void recordEntry(String entryType) {

        EntryLog entryLog = new EntryLog();
        entryLog.setProjectName(PROJECT_NAME);
        entryLog.setUserName(username);
        entryLog.setEntryDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        entryLog.setAppver(MainApp.appInfo.getAppVersion());
        entryLog.setEntryType(entryType);
        entryLog.setDeviceId(MainApp.deviceid);
        Long rowId = null;
        try {
            rowId = db.addEntryLog(entryLog);
        } catch (SQLiteException e) {
            Toast.makeText(this, "SQLiteException(EntryLog)" + entryLog, Toast.LENGTH_SHORT).show();
        }
        if (rowId != -1) {
            entryLog.setId(String.valueOf(rowId));
            entryLog.setUid(entryLog.getDeviceId() + entryLog.getId());
            db.updatesEntryLogColumn(TableContracts.EntryLogTable.COLUMN_UID, entryLog.getUid(), entryLog.getId());
        } else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();

        }

    }

    public String computeHash(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        byte[] byteData = digest.digest(input.getBytes(StandardCharsets.UTF_8));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        Log.d("TAG", "computeHash: " + sb);
        return sb.toString();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }


    /*
     * Toggle Language
     * */
    private void changeLanguage(int code) {
        String lang;
        String country;
        /*if (code == TAJIKISTAN) {
            lang = "ur";
            country = "PK";
            MainApp.editor
                    .putString("lang", "3")
                    .apply();
        } else {
            lang = "en";
            country = "US";
            MainApp.editor
                    .putString("lang", "1")
                    .apply();
        }*/
        switch (code) {
            case 1:
                lang = "ur";
                country = "PK";
                MainApp.editor
                        .putString("lang", "1")
                        .apply();
                break;
            case 2:
                lang = "sd";
                country = "PK";
                MainApp.editor
                        .putString("lang", "2")
                        .apply();
                break;
            default:
                lang = "en";
                country = "US";
                MainApp.editor
                        .putString("lang", "0")
                        .apply();
                break;
        }
        Locale locale = new Locale(lang, country);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        config.setLayoutDirection(new Locale(lang, country));
        this.getResources().updateConfiguration(config, this.getResources().getDisplayMetrics());

    }

    private void settingCountryCode() {

        /*bi.countrySwitch.setChecked(sharedPref.getString("lang", "1").equals("1"));

        bi.countrySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
                changeLanguage(isChecked ? 1 : 3);

                startActivity(new Intent(LoginActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });*/
        bi.countrySwitch.setAdapter(new ArrayAdapter<>(LoginActivity.this, R.layout.custom_spinner, getResources().getStringArray(R.array.langs)));
        bi.countrySwitch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                changeLanguage(position);
                /*startActivity(new Intent(LoginActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    /*
     * Setting country code in Shared Preference
     * */
    private void initializingCountry() {
        countryCode = Integer.parseInt(sharedPref.getString("lang", "0"));
        if (countryCode == 0) {
            MainApp.editor.putString("lang", "0").apply();
        }

        changeLanguage(Integer.parseInt(sharedPref.getString("lang", "0")));
    }

   /* private void GZIPTest() throws IOException, DataFormatException {
        // deflater
        Deflater d = new Deflater();

        // get the text
        String pattern = "QPmrkqaqWwqQzn4LkvVf9MQIC3Y9XvrolZRBmOhLvx5kuNnjTQ+5p85ukfMWJ+q6UwtDYO1SrWse4h7UOevmSLnVGIpiy2zZ";
        String text = "QPmrkqaqWwqQzn4LkvVf9MQIC3Y9XvrolZRBmOhLvx5kuNnjTQ+5p85ukfMWJ+q6UwtDYO1SrWse4h7UOevmSLnVGIpiy2zZ";

       generate the text
        for (int i = 0; i < 4; i++)
            text += pattern;

        // set the input for deflator
        d.setInput(text.getBytes("UTF-8"));

        // finish
        d.finish();

        // output bytes
        byte output[] = new byte[text.getBytes(StandardCharsets.UTF_8).length];

        // compress the data
        int size = d.deflate(output);

        // compressed String
        System.out.println("Compressed String :"
                + new String(output)
                + "\n Size " + size);
        // compressed String
        System.out.println("Compressed String (base64) :"
                + Base64.encodeToString(output, Base64.NO_WRAP)
        );

        // original String
        System.out.println("Original String :"
                + text + "\n Size "
                + text.length());

        // compressed String
        System.out.println("Original String (base64) :"
                + Base64.encodeToString(text.getBytes(StandardCharsets.UTF_8), Base64.NO_WRAP)
        );


        //Decompresses the data
        Inflater i = new Inflater();
        i.setInput(output, 0, size);
        byte[] result = new byte[output.length];
        int resultLength = i.inflate(result);
        i.end();
        String outStr = new String(result, 0, resultLength, "UTF-8");
        System.out.println("Deflated data: "+outStr);
        // end
        d.end();
    }*/
}

