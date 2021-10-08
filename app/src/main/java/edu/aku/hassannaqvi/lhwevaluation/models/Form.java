package edu.aku.hassannaqvi.lhwevaluation.models;

import android.database.Cursor;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.lhwevaluation.BR;
import edu.aku.hassannaqvi.lhwevaluation.contracts.TableContracts.FormsTable;
import edu.aku.hassannaqvi.lhwevaluation.core.MainApp;

public class Form extends BaseObservable implements Observable {

    private final String TAG = "Form";
    private final transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();
    // APP VARIABLES
    private String projectName = MainApp.PROJECT_NAME;
    // APP VARIABLES
    private String id = StringUtils.EMPTY;
    private String uid = StringUtils.EMPTY;
    private final String wuid = StringUtils.EMPTY;
    private final String cuid = StringUtils.EMPTY;
    private String userName = StringUtils.EMPTY;
    private String sysDate = StringUtils.EMPTY;
    private String cluster = StringUtils.EMPTY;
    private String hhid = StringUtils.EMPTY;
    private String deviceId = StringUtils.EMPTY;
    private String deviceTag = StringUtils.EMPTY;
    private String appver = StringUtils.EMPTY;
    private String endTime = StringUtils.EMPTY;
    private String iStatus = StringUtils.EMPTY;
    private String iStatus96x = StringUtils.EMPTY;
    private String synced = StringUtils.EMPTY;
    private String syncDate = StringUtils.EMPTY;
    // SECTION VARIABLES
    private String sA = StringUtils.EMPTY;
    private String sB = StringUtils.EMPTY;
    private String sC = StringUtils.EMPTY;
    private String sH1 = StringUtils.EMPTY;
    private String sH2 = StringUtils.EMPTY;
    private String sH3 = StringUtils.EMPTY;
    private String sAB = StringUtils.EMPTY;
    private String sM = StringUtils.EMPTY;

    // FIELD VARIABLES
    private String a101 = StringUtils.EMPTY;
    private String a102 = StringUtils.EMPTY;
    private String a103 = StringUtils.EMPTY;
    private String a104n = StringUtils.EMPTY;
    private String a104c = StringUtils.EMPTY;
    private String a105 = StringUtils.EMPTY;
    private String a106 = StringUtils.EMPTY;
    private String a107 = StringUtils.EMPTY;
    private String a10796x = StringUtils.EMPTY;
    private String a108 = StringUtils.EMPTY;
    private String a109 = StringUtils.EMPTY;
    private String b101 = StringUtils.EMPTY;
    private String b102 = StringUtils.EMPTY;
    private String b103 = StringUtils.EMPTY;
    private String b10396x = StringUtils.EMPTY;
    private String b104 = StringUtils.EMPTY;
    private String b107a = StringUtils.EMPTY;
    private String b107b = StringUtils.EMPTY;
    private String b107c = StringUtils.EMPTY;
    private String b107d = StringUtils.EMPTY;
    private String b107e = StringUtils.EMPTY;
    private String b107f = StringUtils.EMPTY;
    private String b107g = StringUtils.EMPTY;
    private String b107h = StringUtils.EMPTY;
    private String b107i = StringUtils.EMPTY;
    private String b107j = StringUtils.EMPTY;
    private String b108a = StringUtils.EMPTY;
    private String b108b = StringUtils.EMPTY;
    private String b108c = StringUtils.EMPTY;
    private String b108d = StringUtils.EMPTY;
    private String b108e = StringUtils.EMPTY;
    private String b108f = StringUtils.EMPTY;
    private String b108g = StringUtils.EMPTY;
    private String b108h = StringUtils.EMPTY;
    private String b108i = StringUtils.EMPTY;
    private String b108j = StringUtils.EMPTY;
    private String b108k = StringUtils.EMPTY;
    private String b108l = StringUtils.EMPTY;
    private String b108m = StringUtils.EMPTY;
    private String b108n = StringUtils.EMPTY;
    private String b108o = StringUtils.EMPTY;
    private String b108p = StringUtils.EMPTY;
    private String b108q = StringUtils.EMPTY;
    private String b108r = StringUtils.EMPTY;
    private String b108s = StringUtils.EMPTY;
    private String b108t = StringUtils.EMPTY;
    private String b108u = StringUtils.EMPTY;
    private String b108v = StringUtils.EMPTY;
    private String b108w = StringUtils.EMPTY;
    private String c101s = StringUtils.EMPTY;
    private String c101m = StringUtils.EMPTY;
    private String c102s = StringUtils.EMPTY;
    private String c102m = StringUtils.EMPTY;
    private String c103s = StringUtils.EMPTY;
    private String c103m = StringUtils.EMPTY;
    private String c104s = StringUtils.EMPTY;
    private String c104m = StringUtils.EMPTY;
    private String c105s = StringUtils.EMPTY;
    private String c105m = StringUtils.EMPTY;
    private String c106s = StringUtils.EMPTY;
    private String c106m = StringUtils.EMPTY;
    private String c107s = StringUtils.EMPTY;
    private String c107m = StringUtils.EMPTY;
    private String c108s = StringUtils.EMPTY;
    private String c108m = StringUtils.EMPTY;
    private String c109s = StringUtils.EMPTY;
    private String c109m = StringUtils.EMPTY;
    private String c110s = StringUtils.EMPTY;
    private String c110m = StringUtils.EMPTY;
    private String c111s = StringUtils.EMPTY;
    private String c111m = StringUtils.EMPTY;
    private String c112s = StringUtils.EMPTY;
    private String c112m = StringUtils.EMPTY;
    private String c113s = StringUtils.EMPTY;
    private String c113m = StringUtils.EMPTY;
    private String c114s = StringUtils.EMPTY;
    private String c114m = StringUtils.EMPTY;
    private String c115s = StringUtils.EMPTY;
    private String c115m = StringUtils.EMPTY;
    private String c116s = StringUtils.EMPTY;
    private String c116m = StringUtils.EMPTY;
    private String c117s = StringUtils.EMPTY;
    private String c117m = StringUtils.EMPTY;
    private String c118s = StringUtils.EMPTY;
    private String c118m = StringUtils.EMPTY;
    private String c119s = StringUtils.EMPTY;
    private String c119m = StringUtils.EMPTY;
    private String c120s = StringUtils.EMPTY;
    private String c120m = StringUtils.EMPTY;
    private String c121s = StringUtils.EMPTY;
    private String c121m = StringUtils.EMPTY;
    private String c122s = StringUtils.EMPTY;
    private String c122m = StringUtils.EMPTY;
    private String c123s = StringUtils.EMPTY;
    private String c123m = StringUtils.EMPTY;
    private String c124s = StringUtils.EMPTY;
    private String c124m = StringUtils.EMPTY;
    private String c125s = StringUtils.EMPTY;
    private String c125m = StringUtils.EMPTY;
    private String c126s = StringUtils.EMPTY;
    private String c126m = StringUtils.EMPTY;
    private String c127s = StringUtils.EMPTY;
    private String c127m = StringUtils.EMPTY;
    private String c128s = StringUtils.EMPTY;
    private String c128m = StringUtils.EMPTY;
    private String c129s = StringUtils.EMPTY;
    private String c129m = StringUtils.EMPTY;
    private String c130s = StringUtils.EMPTY;
    private String c130m = StringUtils.EMPTY;
    private String c131s = StringUtils.EMPTY;
    private String c131m = StringUtils.EMPTY;
    private String c132s = StringUtils.EMPTY;
    private String c132m = StringUtils.EMPTY;
    private String c133s = StringUtils.EMPTY;
    private String c133m = StringUtils.EMPTY;
    private String c134s = StringUtils.EMPTY;
    private String c134m = StringUtils.EMPTY;
    private String c135s = StringUtils.EMPTY;
    private String c135m = StringUtils.EMPTY;
    private String c136s = StringUtils.EMPTY;
    private String c136m = StringUtils.EMPTY;
    private String c137s = StringUtils.EMPTY;
    private String c137m = StringUtils.EMPTY;
    private String c138s = StringUtils.EMPTY;
    private String c138m = StringUtils.EMPTY;
    private String c139s = StringUtils.EMPTY;
    private String c139m = StringUtils.EMPTY;
    private String c140 = StringUtils.EMPTY;
    private String c141 = StringUtils.EMPTY;
    private String c14196x = StringUtils.EMPTY;
    private String h101 = StringUtils.EMPTY;
    private String h102 = StringUtils.EMPTY;
    private String h103 = StringUtils.EMPTY;
    private String h104a = StringUtils.EMPTY;
    private String h104b = StringUtils.EMPTY;
    private String h104c = StringUtils.EMPTY;
    private String h104d = StringUtils.EMPTY;
    private String h104e = StringUtils.EMPTY;
    private String h104f = StringUtils.EMPTY;
    private String lhwphoto = StringUtils.EMPTY;
    private String h201 = StringUtils.EMPTY;
    private String h202 = StringUtils.EMPTY;
    private String h203 = StringUtils.EMPTY;
    private String h204a = StringUtils.EMPTY;
    private String h204b = StringUtils.EMPTY;
    private String h204c = StringUtils.EMPTY;
    private String h204d = StringUtils.EMPTY;
    private String h204e = StringUtils.EMPTY;
    private String h204f = StringUtils.EMPTY;
    private String h205 = StringUtils.EMPTY;
    private String h301 = StringUtils.EMPTY;
    private String h302 = StringUtils.EMPTY;
    private String h303 = StringUtils.EMPTY;
    private String h304d = StringUtils.EMPTY;
    private String h304m = StringUtils.EMPTY;
    private String h304y = StringUtils.EMPTY;
    private String h305 = StringUtils.EMPTY;
    private String h306 = StringUtils.EMPTY;
    private String h307 = StringUtils.EMPTY;
    private String h308 = StringUtils.EMPTY;
    private String h309 = StringUtils.EMPTY;
    private String ab101 = StringUtils.EMPTY;
    private String ab102 = StringUtils.EMPTY;
    private String ab103 = StringUtils.EMPTY;
    private String ab104 = StringUtils.EMPTY;
    private String ab104a = StringUtils.EMPTY;
    private String ab104b = StringUtils.EMPTY;
    private String ab104c = StringUtils.EMPTY;
    private String ab104d = StringUtils.EMPTY;
    private String ab10496 = StringUtils.EMPTY;
    private String ab10496x = StringUtils.EMPTY;
    private String ab105 = StringUtils.EMPTY;
    private String ab106 = StringUtils.EMPTY;
    private String ab107 = StringUtils.EMPTY;
    private String ab108 = StringUtils.EMPTY;
    private String ab108a = StringUtils.EMPTY;
    private String ab108b = StringUtils.EMPTY;
    private String ab108c = StringUtils.EMPTY;
    private String ab108d = StringUtils.EMPTY;
    private String ab108e = StringUtils.EMPTY;
    private String ab108f = StringUtils.EMPTY;
    private String ab108g = StringUtils.EMPTY;
    private String ab108h = StringUtils.EMPTY;
    private String ab108i = StringUtils.EMPTY;
    private String ab108j = StringUtils.EMPTY;
    private String ab108k = StringUtils.EMPTY;
    private String ab10896 = StringUtils.EMPTY;
    private String ab10896x = StringUtils.EMPTY;
    private String ab109 = StringUtils.EMPTY;
    private String ab10996x = StringUtils.EMPTY;
    private String ab110 = StringUtils.EMPTY;
    private String ab110a = StringUtils.EMPTY;
    private String ab110b = StringUtils.EMPTY;
    private String ab110c = StringUtils.EMPTY;
    private String ab110d = StringUtils.EMPTY;
    private String ab110e = StringUtils.EMPTY;
    private String ab11096 = StringUtils.EMPTY;
    private String ab11096x = StringUtils.EMPTY;
    private String ab111 = StringUtils.EMPTY;
    private String ab112 = StringUtils.EMPTY;
    private String ab113 = StringUtils.EMPTY;
    private String ab113a = StringUtils.EMPTY;
    private String ab113b = StringUtils.EMPTY;
    private String ab113c = StringUtils.EMPTY;
    private String ab11398 = StringUtils.EMPTY;
    private String ab11396 = StringUtils.EMPTY;
    private String ab11396x = StringUtils.EMPTY;
    private String ab114 = StringUtils.EMPTY;
    private String ab115 = StringUtils.EMPTY;
    private String ab117 = StringUtils.EMPTY;
    private String ab118a = StringUtils.EMPTY;
    private String ab118b = StringUtils.EMPTY;
    private String ab118c = StringUtils.EMPTY;
    private String ab118d = StringUtils.EMPTY;
    private String ab118e = StringUtils.EMPTY;
    private String ab118f = StringUtils.EMPTY;
    private String ab118g = StringUtils.EMPTY;
    private String ab118h = StringUtils.EMPTY;
    private String ab118i = StringUtils.EMPTY;
    private String ab118j = StringUtils.EMPTY;
    private String ab118k = StringUtils.EMPTY;
    private String ab118l = StringUtils.EMPTY;
    private String ab118m = StringUtils.EMPTY;
    private String ab118n = StringUtils.EMPTY;
    private String ab118o = StringUtils.EMPTY;
    private String ab118p = StringUtils.EMPTY;
    private String ab118q = StringUtils.EMPTY;
    private String ab118r = StringUtils.EMPTY;
    private String ab118s = StringUtils.EMPTY;
    private String ab118t = StringUtils.EMPTY;
    private String ab118u = StringUtils.EMPTY;
    private String ab119 = StringUtils.EMPTY;
    private String m101 = StringUtils.EMPTY;
    private String m102 = StringUtils.EMPTY;
    private String m103 = StringUtils.EMPTY;
    private String m104 = StringUtils.EMPTY;
    private String m105 = StringUtils.EMPTY;
    private String m105a = StringUtils.EMPTY;
    private String m105b = StringUtils.EMPTY;
    private String m105c = StringUtils.EMPTY;
    private String m105d = StringUtils.EMPTY;
    private String m105e = StringUtils.EMPTY;
    private String m105f = StringUtils.EMPTY;
    private String m105g = StringUtils.EMPTY;
    private String m105h = StringUtils.EMPTY;
    private String m10596 = StringUtils.EMPTY;
    private String m10596x = StringUtils.EMPTY;
    private String m106 = StringUtils.EMPTY;
    private String m106a = StringUtils.EMPTY;
    private String m106b = StringUtils.EMPTY;
    private String m106c = StringUtils.EMPTY;
    private String m106d = StringUtils.EMPTY;


    public Form() {
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Bindable
    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
        notifyPropertyChanged(BR.cluster);
    }

    @Bindable
    public String getHhid() {
        return hhid;
    }

    public void setHhid(String hhid) {
        this.hhid = hhid;
        notifyPropertyChanged(BR.hhid);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceTag() {
        return deviceTag;
    }

    public void setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
    }

    public String getAppver() {
        return appver;
    }

    public void setAppver(String appver) {
        this.appver = appver;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getiStatus() {
        return iStatus;
    }

    public void setiStatus(String iStatus) {
        this.iStatus = iStatus;
    }

    public String getiStatus96x() {
        return iStatus96x;
    }

    public void setiStatus96x(String iStatus96x) {
        this.iStatus96x = iStatus96x;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(String syncDate) {
        this.syncDate = syncDate;
    }


    /*JSON DATABASE VARIABLES*/
    public String getsA() {
        return sA;
    }

    public void setsA(String sA) {
        this.sA = sA;
    }

    public String getsB() {
        return sB;
    }

    public void setsB(String sB) {
        this.sB = sB;
    }


    public String getsC() {
        return sC;
    }

    public void setsC(String sC) {
        this.sC = sC;
    }


    public String getsH1() {
        return sH1;
    }

    public void setsH1(String sH1) {
        this.sH1 = sH1;
    }


    public String getsH2() {
        return sH2;
    }

    public void setsH2(String sH2) {
        this.sH2 = sH2;
    }


    public String getsH3() {
        return sH3;
    }

    public void setsH3(String sH3) {
        this.sH3 = sH3;
    }


    public String getsAB() {
        return sAB;
    }

    public void setsAB(String sAB) {
        this.sAB = sAB;
    }


    public String getsM() {
        return sM;
    }

    public void setsM(String sM) {
        this.sM = sM;
    }


    @Bindable
    public String getA101() {
        return a101;
    }

    public void setA101(String a101) {
        this.a101 = a101;
        notifyPropertyChanged(BR.a101);
    }

    @Bindable
    public String getA102() {
        return a102;
    }

    public void setA102(String a102) {
        this.a102 = a102;
        notifyPropertyChanged(BR.a102);
    }

    @Bindable
    public String getA103() {
        return a103;
    }

    public void setA103(String a103) {
        this.a103 = a103;
        notifyPropertyChanged(BR.a103);
    }

    @Bindable
    public String getA104n() {
        return a104n;
    }

    public void setA104n(String a104n) {
        this.a104n = a104n;
        notifyPropertyChanged(BR.a104n);
    }

    @Bindable
    public String getA104c() {
        return a104c;
    }

    public void setA104c(String a104c) {
        this.a104c = a104c;
        notifyPropertyChanged(BR.a104c);
    }

    @Bindable
    public String getA105() {
        return a105;
    }

    public void setA105(String a105) {
        this.a105 = a105;
        notifyPropertyChanged(BR.a105);
    }

    @Bindable
    public String getA106() {
        return a106;
    }

    public void setA106(String a106) {
        this.a106 = a106;
        notifyPropertyChanged(BR.a106);
    }

    @Bindable
    public String getA107() {
        return a107;
    }

    public void setA107(String a107) {
        this.a107 = a107;
        setA10796x(a107.equals("96") ? this.a10796x : "");
        notifyPropertyChanged(BR.a107);
    }

    @Bindable
    public String getA10796x() {
        return a10796x;
    }

    public void setA10796x(String a10796x) {
        this.a10796x = a10796x;
        notifyPropertyChanged(BR.a10796x);
    }

    @Bindable
    public String getA108() {
        return a108;
    }

    public void setA108(String a108) {
        this.a108 = a108;
        notifyPropertyChanged(BR.a108);
    }

    @Bindable
    public String getA109() {
        return a109;
    }

    public void setA109(String a109) {
        this.a109 = a109;
        notifyPropertyChanged(BR.a109);
    }

    @Bindable
    public String getB101() {
        return b101;
    }

    public void setB101(String b101) {
        this.b101 = b101;
        setB103(b101.equals("1") && this.b102.equals("1") ? "" : this.b103);
        notifyPropertyChanged(BR.b101);
    }

    @Bindable
    public String getB102() {
        return b102;
    }

    public void setB102(String b102) {
        this.b102 = b102;
        setB103(b102.equals("1") && this.b101.equals("1") ? "" : this.b103);
        notifyPropertyChanged(BR.b102);
    }

    @Bindable
    public String getB103() {
        return b103;
    }

    public void setB103(String b103) {
        this.b103 = b103;
        setB10396x(b103.equals("96") ? b10396x : "");
        notifyPropertyChanged(BR.b103);
    }

    @Bindable
    public String getB10396x() {
        return b10396x;
    }

    public void setB10396x(String b10396x) {
        this.b10396x = b10396x;
        notifyPropertyChanged(BR.b10396x);
    }

    @Bindable
    public String getB104() {
        return b104;
    }

    public void setB104(String b104) {
        this.b104 = b104;
        notifyPropertyChanged(BR.b104);
    }

    @Bindable
    public String getB107a() {
        return b107a;
    }

    public void setB107a(String b107a) {
        this.b107a = b107a;
        notifyPropertyChanged(BR.b107a);
    }

    @Bindable
    public String getB107b() {
        return b107b;
    }

    public void setB107b(String b107b) {
        this.b107b = b107b;
        notifyPropertyChanged(BR.b107b);
    }

    @Bindable
    public String getB107c() {
        return b107c;
    }

    public void setB107c(String b107c) {
        this.b107c = b107c;
        notifyPropertyChanged(BR.b107c);
    }

    @Bindable
    public String getB107d() {
        return b107d;
    }

    public void setB107d(String b107d) {
        this.b107d = b107d;
        notifyPropertyChanged(BR.b107d);
    }

    @Bindable
    public String getB107e() {
        return b107e;
    }

    public void setB107e(String b107e) {
        this.b107e = b107e;
        notifyPropertyChanged(BR.b107e);
    }

    @Bindable
    public String getB107f() {
        return b107f;
    }

    public void setB107f(String b107f) {
        this.b107f = b107f;
        notifyPropertyChanged(BR.b107f);
    }

    @Bindable
    public String getB107g() {
        return b107g;
    }

    public void setB107g(String b107g) {
        this.b107g = b107g;
        notifyPropertyChanged(BR.b107g);
    }

    @Bindable
    public String getB107h() {
        return b107h;
    }

    public void setB107h(String b107h) {
        this.b107h = b107h;
        notifyPropertyChanged(BR.b107h);
    }

    @Bindable
    public String getB107i() {
        return b107i;
    }

    public void setB107i(String b107i) {
        this.b107i = b107i;
        notifyPropertyChanged(BR.b107i);
    }

    @Bindable
    public String getB107j() {
        return b107j;
    }

    public void setB107j(String b107j) {
        this.b107j = b107j;
        notifyPropertyChanged(BR.b107j);
    }

    @Bindable
    public String getB108a() {
        return b108a;
    }

    public void setB108a(String b108a) {
        this.b108a = b108a;
        notifyPropertyChanged(BR.b108a);
    }

    @Bindable
    public String getB108b() {
        return b108b;
    }

    public void setB108b(String b108b) {
        this.b108b = b108b;
        notifyPropertyChanged(BR.b108b);
    }

    @Bindable
    public String getB108c() {
        return b108c;
    }

    public void setB108c(String b108c) {
        this.b108c = b108c;
        notifyPropertyChanged(BR.b108c);
    }

    @Bindable
    public String getB108d() {
        return b108d;
    }

    public void setB108d(String b108d) {
        this.b108d = b108d;
        notifyPropertyChanged(BR.b108d);
    }

    @Bindable
    public String getB108e() {
        return b108e;
    }

    public void setB108e(String b108e) {
        this.b108e = b108e;
        notifyPropertyChanged(BR.b108e);
    }

    @Bindable
    public String getB108f() {
        return b108f;
    }

    public void setB108f(String b108f) {
        this.b108f = b108f;
        notifyPropertyChanged(BR.b108f);
    }

    @Bindable
    public String getB108g() {
        return b108g;
    }

    public void setB108g(String b108g) {
        this.b108g = b108g;
        notifyPropertyChanged(BR.b108g);
    }

    @Bindable
    public String getB108h() {
        return b108h;
    }

    public void setB108h(String b108h) {
        this.b108h = b108h;
        notifyPropertyChanged(BR.b108h);
    }

    @Bindable
    public String getB108i() {
        return b108i;
    }

    public void setB108i(String b108i) {
        this.b108i = b108i;
        notifyPropertyChanged(BR.b108i);
    }

    @Bindable
    public String getB108j() {
        return b108j;
    }

    public void setB108j(String b108j) {
        this.b108j = b108j;
        notifyPropertyChanged(BR.b108j);
    }

    @Bindable
    public String getB108k() {
        return b108k;
    }

    public void setB108k(String b108k) {
        this.b108k = b108k;
        notifyPropertyChanged(BR.b108k);
    }

    @Bindable
    public String getB108l() {
        return b108l;
    }

    public void setB108l(String b108l) {
        this.b108l = b108l;
        notifyPropertyChanged(BR.b108l);
    }

    @Bindable
    public String getB108m() {
        return b108m;
    }

    public void setB108m(String b108m) {
        this.b108m = b108m;
        notifyPropertyChanged(BR.b108m);
    }

    @Bindable
    public String getB108n() {
        return b108n;
    }

    public void setB108n(String b108n) {
        this.b108n = b108n;
        notifyPropertyChanged(BR.b108n);
    }

    @Bindable
    public String getB108o() {
        return b108o;
    }

    public void setB108o(String b108o) {
        this.b108o = b108o;
        notifyPropertyChanged(BR.b108o);
    }

    @Bindable
    public String getB108p() {
        return b108p;
    }

    public void setB108p(String b108p) {
        this.b108p = b108p;
        notifyPropertyChanged(BR.b108p);
    }

    @Bindable
    public String getB108q() {
        return b108q;
    }

    public void setB108q(String b108q) {
        this.b108q = b108q;
        notifyPropertyChanged(BR.b108q);
    }

    @Bindable
    public String getB108r() {
        return b108r;
    }

    public void setB108r(String b108r) {
        this.b108r = b108r;
        notifyPropertyChanged(BR.b108r);
    }

    @Bindable
    public String getB108s() {
        return b108s;
    }

    public void setB108s(String b108s) {
        this.b108s = b108s;
        notifyPropertyChanged(BR.b108s);
    }

    @Bindable
    public String getB108t() {
        return b108t;
    }

    public void setB108t(String b108t) {
        this.b108t = b108t;
        notifyPropertyChanged(BR.b108t);
    }

    @Bindable
    public String getB108u() {
        return b108u;
    }

    public void setB108u(String b108u) {
        this.b108u = b108u;
        notifyPropertyChanged(BR.b108u);
    }

    @Bindable
    public String getB108v() {
        return b108v;
    }

    public void setB108v(String b108v) {
        this.b108v = b108v;
        notifyPropertyChanged(BR.b108v);
    }

    @Bindable
    public String getB108w() {
        return b108w;
    }

    public void setB108w(String b108w) {
        this.b108w = b108w;
        notifyPropertyChanged(BR.b108w);
    }

    @Bindable
    public String getC101s() {
        return c101s;
    }

    public void setC101s(String c101s) {
        this.c101s = c101s;
        notifyPropertyChanged(BR.c101s);
    }

    @Bindable
    public String getC101m() {
        return c101m;
    }

    public void setC101m(String c101m) {
        this.c101m = c101m;
        notifyPropertyChanged(BR.c101m);
    }

    @Bindable
    public String getC102s() {
        return c102s;
    }

    public void setC102s(String c102s) {
        this.c102s = c102s;
        notifyPropertyChanged(BR.c102s);
    }

    @Bindable
    public String getC102m() {
        return c102m;
    }

    public void setC102m(String c102m) {
        this.c102m = c102m;
        notifyPropertyChanged(BR.c102m);
    }

    @Bindable
    public String getC103s() {
        return c103s;
    }

    public void setC103s(String c103s) {
        this.c103s = c103s;
        notifyPropertyChanged(BR.c103s);
    }

    @Bindable
    public String getC103m() {
        return c103m;
    }

    public void setC103m(String c103m) {
        this.c103m = c103m;
        notifyPropertyChanged(BR.c103m);
    }

    @Bindable
    public String getC104s() {
        return c104s;
    }

    public void setC104s(String c104s) {
        this.c104s = c104s;
        notifyPropertyChanged(BR.c104s);
    }

    @Bindable
    public String getC104m() {
        return c104m;
    }

    public void setC104m(String c104m) {
        this.c104m = c104m;
        notifyPropertyChanged(BR.c104m);
    }

    @Bindable
    public String getC105s() {
        return c105s;
    }

    public void setC105s(String c105s) {
        this.c105s = c105s;
        notifyPropertyChanged(BR.c105s);
    }

    @Bindable
    public String getC105m() {
        return c105m;
    }

    public void setC105m(String c105m) {
        this.c105m = c105m;
        notifyPropertyChanged(BR.c105m);
    }

    @Bindable
    public String getC106s() {
        return c106s;
    }

    public void setC106s(String c106s) {
        this.c106s = c106s;
        notifyPropertyChanged(BR.c106s);
    }

    @Bindable
    public String getC106m() {
        return c106m;
    }

    public void setC106m(String c106m) {
        this.c106m = c106m;
        notifyPropertyChanged(BR.c106m);
    }

    @Bindable
    public String getC107s() {
        return c107s;
    }

    public void setC107s(String c107s) {
        this.c107s = c107s;
        notifyPropertyChanged(BR.c107s);
    }

    @Bindable
    public String getC107m() {
        return c107m;
    }

    public void setC107m(String c107m) {
        this.c107m = c107m;
        notifyPropertyChanged(BR.c107m);
    }

    @Bindable
    public String getC108s() {
        return c108s;
    }

    public void setC108s(String c108s) {
        this.c108s = c108s;
        notifyPropertyChanged(BR.c108s);
    }

    @Bindable
    public String getC108m() {
        return c108m;
    }

    public void setC108m(String c108m) {
        this.c108m = c108m;
        notifyPropertyChanged(BR.c108m);
    }

    @Bindable
    public String getC109s() {
        return c109s;
    }

    public void setC109s(String c109s) {
        this.c109s = c109s;
        notifyPropertyChanged(BR.c109s);
    }

    @Bindable
    public String getC109m() {
        return c109m;
    }

    public void setC109m(String c109m) {
        this.c109m = c109m;
        notifyPropertyChanged(BR.c109m);
    }

    @Bindable
    public String getC110s() {
        return c110s;
    }

    public void setC110s(String c110s) {
        this.c110s = c110s;
        notifyPropertyChanged(BR.c110s);
    }

    @Bindable
    public String getC110m() {
        return c110m;
    }

    public void setC110m(String c110m) {
        this.c110m = c110m;
        notifyPropertyChanged(BR.c110m);
    }

    @Bindable
    public String getC111s() {
        return c111s;
    }

    public void setC111s(String c111s) {
        this.c111s = c111s;
        notifyPropertyChanged(BR.c111s);
    }

    @Bindable
    public String getC111m() {
        return c111m;
    }

    public void setC111m(String c111m) {
        this.c111m = c111m;
        notifyPropertyChanged(BR.c111m);
    }

    @Bindable
    public String getC112s() {
        return c112s;
    }

    public void setC112s(String c112s) {
        this.c112s = c112s;
        notifyPropertyChanged(BR.c112s);
    }

    @Bindable
    public String getC112m() {
        return c112m;
    }

    public void setC112m(String c112m) {
        this.c112m = c112m;
        notifyPropertyChanged(BR.c112m);
    }

    @Bindable
    public String getC113s() {
        return c113s;
    }

    public void setC113s(String c113s) {
        this.c113s = c113s;
        notifyPropertyChanged(BR.c113s);
    }

    @Bindable
    public String getC113m() {
        return c113m;
    }

    public void setC113m(String c113m) {
        this.c113m = c113m;
        notifyPropertyChanged(BR.c113m);
    }

    @Bindable
    public String getC114s() {
        return c114s;
    }

    public void setC114s(String c114s) {
        this.c114s = c114s;
        notifyPropertyChanged(BR.c114s);
    }

    @Bindable
    public String getC114m() {
        return c114m;
    }

    public void setC114m(String c114m) {
        this.c114m = c114m;
        notifyPropertyChanged(BR.c114m);
    }

    @Bindable
    public String getC115s() {
        return c115s;
    }

    public void setC115s(String c115s) {
        this.c115s = c115s;
        notifyPropertyChanged(BR.c115s);
    }

    @Bindable
    public String getC115m() {
        return c115m;
    }

    public void setC115m(String c115m) {
        this.c115m = c115m;
        notifyPropertyChanged(BR.c115m);
    }

    @Bindable
    public String getC116s() {
        return c116s;
    }

    public void setC116s(String c116s) {
        this.c116s = c116s;
        notifyPropertyChanged(BR.c116s);
    }

    @Bindable
    public String getC116m() {
        return c116m;
    }

    public void setC116m(String c116m) {
        this.c116m = c116m;
        notifyPropertyChanged(BR.c116m);
    }

    @Bindable
    public String getC117s() {
        return c117s;
    }

    public void setC117s(String c117s) {
        this.c117s = c117s;
        notifyPropertyChanged(BR.c117s);
    }

    @Bindable
    public String getC117m() {
        return c117m;
    }

    public void setC117m(String c117m) {
        this.c117m = c117m;
        notifyPropertyChanged(BR.c117m);
    }

    @Bindable
    public String getC118s() {
        return c118s;
    }

    public void setC118s(String c118s) {
        this.c118s = c118s;
        notifyPropertyChanged(BR.c118s);
    }

    @Bindable
    public String getC118m() {
        return c118m;
    }

    public void setC118m(String c118m) {
        this.c118m = c118m;
        notifyPropertyChanged(BR.c118m);
    }

    @Bindable
    public String getC119s() {
        return c119s;
    }

    public void setC119s(String c119s) {
        this.c119s = c119s;
        notifyPropertyChanged(BR.c119s);
    }

    @Bindable
    public String getC119m() {
        return c119m;
    }

    public void setC119m(String c119m) {
        this.c119m = c119m;
        notifyPropertyChanged(BR.c119m);
    }

    @Bindable
    public String getC120s() {
        return c120s;
    }

    public void setC120s(String c120s) {
        this.c120s = c120s;
        notifyPropertyChanged(BR.c120s);
    }

    @Bindable
    public String getC120m() {
        return c120m;
    }

    public void setC120m(String c120m) {
        this.c120m = c120m;
        notifyPropertyChanged(BR.c120m);
    }

    @Bindable
    public String getC121s() {
        return c121s;
    }

    public void setC121s(String c121s) {
        this.c121s = c121s;
        notifyPropertyChanged(BR.c121s);
    }

    @Bindable
    public String getC121m() {
        return c121m;
    }

    public void setC121m(String c121m) {
        this.c121m = c121m;
        notifyPropertyChanged(BR.c121m);
    }

    @Bindable
    public String getC122s() {
        return c122s;
    }

    public void setC122s(String c122s) {
        this.c122s = c122s;
        notifyPropertyChanged(BR.c122s);
    }

    @Bindable
    public String getC122m() {
        return c122m;
    }

    public void setC122m(String c122m) {
        this.c122m = c122m;
        notifyPropertyChanged(BR.c122m);
    }

    @Bindable
    public String getC123s() {
        return c123s;
    }

    public void setC123s(String c123s) {
        this.c123s = c123s;
        notifyPropertyChanged(BR.c123s);
    }

    @Bindable
    public String getC123m() {
        return c123m;
    }

    public void setC123m(String c123m) {
        this.c123m = c123m;
        notifyPropertyChanged(BR.c123m);
    }

    @Bindable
    public String getC124s() {
        return c124s;
    }

    public void setC124s(String c124s) {
        this.c124s = c124s;
        notifyPropertyChanged(BR.c124s);
    }

    @Bindable
    public String getC124m() {
        return c124m;
    }

    public void setC124m(String c124m) {
        this.c124m = c124m;
        notifyPropertyChanged(BR.c124m);
    }

    @Bindable
    public String getC125s() {
        return c125s;
    }

    public void setC125s(String c125s) {
        this.c125s = c125s;
        notifyPropertyChanged(BR.c125s);
    }

    @Bindable
    public String getC125m() {
        return c125m;
    }

    public void setC125m(String c125m) {
        this.c125m = c125m;
        notifyPropertyChanged(BR.c125m);
    }

    @Bindable
    public String getC126s() {
        return c126s;
    }

    public void setC126s(String c126s) {
        this.c126s = c126s;
        notifyPropertyChanged(BR.c126s);
    }

    @Bindable
    public String getC126m() {
        return c126m;
    }

    public void setC126m(String c126m) {
        this.c126m = c126m;
        notifyPropertyChanged(BR.c126m);
    }

    @Bindable
    public String getC127s() {
        return c127s;
    }

    public void setC127s(String c127s) {
        this.c127s = c127s;
        notifyPropertyChanged(BR.c127s);
    }

    @Bindable
    public String getC127m() {
        return c127m;
    }

    public void setC127m(String c127m) {
        this.c127m = c127m;
        notifyPropertyChanged(BR.c127m);
    }

    @Bindable
    public String getC128s() {
        return c128s;
    }

    public void setC128s(String c128s) {
        this.c128s = c128s;
        notifyPropertyChanged(BR.c128s);
    }

    @Bindable
    public String getC128m() {
        return c128m;
    }

    public void setC128m(String c128m) {
        this.c128m = c128m;
        notifyPropertyChanged(BR.c128m);
    }

    @Bindable
    public String getC129s() {
        return c129s;
    }

    public void setC129s(String c129s) {
        this.c129s = c129s;
        notifyPropertyChanged(BR.c129s);
    }

    @Bindable
    public String getC129m() {
        return c129m;
    }

    public void setC129m(String c129m) {
        this.c129m = c129m;
        notifyPropertyChanged(BR.c129m);
    }

    @Bindable
    public String getC130s() {
        return c130s;
    }

    public void setC130s(String c130s) {
        this.c130s = c130s;
        notifyPropertyChanged(BR.c130s);
    }

    @Bindable
    public String getC130m() {
        return c130m;
    }

    public void setC130m(String c130m) {
        this.c130m = c130m;
        notifyPropertyChanged(BR.c130m);
    }

    @Bindable
    public String getC131s() {
        return c131s;
    }

    public void setC131s(String c131s) {
        this.c131s = c131s;
        notifyPropertyChanged(BR.c131s);
    }

    @Bindable
    public String getC131m() {
        return c131m;
    }

    public void setC131m(String c131m) {
        this.c131m = c131m;
        notifyPropertyChanged(BR.c131m);
    }

    @Bindable
    public String getC132s() {
        return c132s;
    }

    public void setC132s(String c132s) {
        this.c132s = c132s;
        notifyPropertyChanged(BR.c132s);
    }

    @Bindable
    public String getC132m() {
        return c132m;
    }

    public void setC132m(String c132m) {
        this.c132m = c132m;
        notifyPropertyChanged(BR.c132m);
    }

    @Bindable
    public String getC133s() {
        return c133s;
    }

    public void setC133s(String c133s) {
        this.c133s = c133s;
        notifyPropertyChanged(BR.c133s);
    }

    @Bindable
    public String getC133m() {
        return c133m;
    }

    public void setC133m(String c133m) {
        this.c133m = c133m;
        notifyPropertyChanged(BR.c133m);
    }

    @Bindable
    public String getC134s() {
        return c134s;
    }

    public void setC134s(String c134s) {
        this.c134s = c134s;
        notifyPropertyChanged(BR.c134s);
    }

    @Bindable
    public String getC134m() {
        return c134m;
    }

    public void setC134m(String c134m) {
        this.c134m = c134m;
        notifyPropertyChanged(BR.c134m);
    }

    @Bindable
    public String getC135s() {
        return c135s;
    }

    public void setC135s(String c135s) {
        this.c135s = c135s;
        notifyPropertyChanged(BR.c135s);
    }

    @Bindable
    public String getC135m() {
        return c135m;
    }

    public void setC135m(String c135m) {
        this.c135m = c135m;
        notifyPropertyChanged(BR.c135m);
    }

    @Bindable
    public String getC136s() {
        return c136s;
    }

    public void setC136s(String c136s) {
        this.c136s = c136s;
        notifyPropertyChanged(BR.c136s);
    }

    @Bindable
    public String getC136m() {
        return c136m;
    }

    public void setC136m(String c136m) {
        this.c136m = c136m;
        notifyPropertyChanged(BR.c136m);
    }

    @Bindable
    public String getC137s() {
        return c137s;
    }

    public void setC137s(String c137s) {
        this.c137s = c137s;
        notifyPropertyChanged(BR.c137s);
    }

    @Bindable
    public String getC137m() {
        return c137m;
    }

    public void setC137m(String c137m) {
        this.c137m = c137m;
        notifyPropertyChanged(BR.c137m);
    }

    @Bindable
    public String getC138s() {
        return c138s;
    }

    public void setC138s(String c138s) {
        this.c138s = c138s;
        notifyPropertyChanged(BR.c138s);
    }

    @Bindable
    public String getC138m() {
        return c138m;
    }

    public void setC138m(String c138m) {
        this.c138m = c138m;
        notifyPropertyChanged(BR.c138m);
    }

    @Bindable
    public String getC139s() {
        return c139s;
    }

    public void setC139s(String c139s) {
        this.c139s = c139s;
        notifyPropertyChanged(BR.c139s);
    }

    @Bindable
    public String getC139m() {
        return c139m;
    }

    public void setC139m(String c139m) {
        this.c139m = c139m;
        notifyPropertyChanged(BR.c139m);
    }

    @Bindable
    public String getC140() {
        return c140;
    }

    public void setC140(String c140) {
        this.c140 = c140;
        setC141(c140.equals("2") ? "" : this.c141);
        notifyPropertyChanged(BR.c140);
    }

    @Bindable
    public String getC141() {
        return c141;
    }

    public void setC141(String c141) {
        this.c141 = c141;
        setC14196x(c141.equals("96") ? this.c14196x : "");
        notifyPropertyChanged(BR.c141);
    }

    @Bindable
    public String getC14196x() {
        return c14196x;
    }

    public void setC14196x(String c14196x) {
        this.c14196x = c14196x;
        notifyPropertyChanged(BR.c14196x);
    }

    @Bindable
    public String getH101() {
        return h101;
    }

    public void setH101(String h101) {
        this.h101 = h101;
        notifyPropertyChanged(BR.h101);
    }

    @Bindable
    public String getH102() {
        return h102;
    }

    public void setH102(String h102) {
        this.h102 = h102;
        notifyPropertyChanged(BR.h102);
    }

    @Bindable
    public String getH103() {
        return h103;
    }

    public void setH103(String h103) {
        this.h103 = h103;
        notifyPropertyChanged(BR.h103);
    }

    @Bindable
    public String getH104a() {
        return h104a;
    }

    public void setH104a(String h104a) {
        this.h104a = h104a;
        notifyPropertyChanged(BR.h104a);
    }

    @Bindable
    public String getH104b() {
        return h104b;
    }

    public void setH104b(String h104b) {
        this.h104b = h104b;
        notifyPropertyChanged(BR.h104b);
    }

    @Bindable
    public String getH104c() {
        return h104c;
    }

    public void setH104c(String h104c) {
        this.h104c = h104c;
        notifyPropertyChanged(BR.h104c);
    }

    @Bindable
    public String getH104d() {
        return h104d;
    }

    public void setH104d(String h104d) {
        this.h104d = h104d;
        notifyPropertyChanged(BR.h104d);
    }

    @Bindable
    public String getH104e() {
        return h104e;
    }

    public void setH104e(String h104e) {
        this.h104e = h104e;
        notifyPropertyChanged(BR.h104e);
    }

    @Bindable
    public String getH104f() {
        return h104f;
    }

    public void setH104f(String h104f) {
        this.h104f = h104f;
        notifyPropertyChanged(BR.h104f);
    }

    @Bindable
    public String getLhwphoto() {
        return lhwphoto;
    }

    public void setLhwphoto(String lhwphoto) {
        this.lhwphoto = lhwphoto;
        notifyPropertyChanged(BR.lhwphoto);
    }

    @Bindable
    public String getH201() {
        return h201;
    }

    public void setH201(String h201) {
        this.h201 = h201;
        notifyPropertyChanged(BR.h201);
    }

    @Bindable
    public String getH202() {
        return h202;
    }

    public void setH202(String h202) {
        this.h202 = h202;
        notifyPropertyChanged(BR.h202);
    }

    @Bindable
    public String getH203() {
        return h203;
    }

    public void setH203(String h203) {
        this.h203 = h203;
        notifyPropertyChanged(BR.h203);
    }

    @Bindable
    public String getH204a() {
        return h204a;
    }

    public void setH204a(String h204a) {
        this.h204a = h204a;
        notifyPropertyChanged(BR.h204a);
    }

    @Bindable
    public String getH204b() {
        return h204b;
    }

    public void setH204b(String h204b) {
        this.h204b = h204b;
        notifyPropertyChanged(BR.h204b);
    }

    @Bindable
    public String getH204c() {
        return h204c;
    }

    public void setH204c(String h204c) {
        this.h204c = h204c;
        notifyPropertyChanged(BR.h204c);
    }

    @Bindable
    public String getH204d() {
        return h204d;
    }

    public void setH204d(String h204d) {
        this.h204d = h204d;
        notifyPropertyChanged(BR.h204d);
    }

    @Bindable
    public String getH204e() {
        return h204e;
    }

    public void setH204e(String h204e) {
        this.h204e = h204e;
        notifyPropertyChanged(BR.h204e);
    }

    @Bindable
    public String getH204f() {
        return h204f;
    }

    public void setH204f(String h204f) {
        this.h204f = h204f;
        notifyPropertyChanged(BR.h204f);
    }

    @Bindable
    public String getH205() {
        return h205;
    }

    public void setH205(String h205) {
        this.h205 = h205;
        notifyPropertyChanged(BR.h205);
    }

    @Bindable
    public String getH301() {
        return h301;
    }

    public void setH301(String h301) {
        this.h301 = h301;
        notifyPropertyChanged(BR.h301);
    }

    @Bindable
    public String getH302() {
        return h302;
    }

    public void setH302(String h302) {
        this.h302 = h302;
        notifyPropertyChanged(BR.h302);
    }

    @Bindable
    public String getH303() {
        return h303;
    }

    public void setH303(String h303) {
        this.h303 = h303;
        notifyPropertyChanged(BR.h303);
    }

    @Bindable
    public String getH304d() {
        return h304d;
    }

    public void setH304d(String h304d) {
        this.h304d = h304d;
        notifyPropertyChanged(BR.h304d);
    }

    @Bindable
    public String getH304m() {
        return h304m;
    }

    public void setH304m(String h304m) {
        this.h304m = h304m;
        notifyPropertyChanged(BR.h304m);
    }

    @Bindable
    public String getH304y() {
        return h304y;
    }

    public void setH304y(String h304y) {
        this.h304y = h304y;
        notifyPropertyChanged(BR.h304y);
    }

    @Bindable
    public String getH305() {
        return h305;
    }

    public void setH305(String h305) {
        this.h305 = h305;
        notifyPropertyChanged(BR.h305);
    }

    @Bindable
    public String getH306() {
        return h306;
    }

    public void setH306(String h306) {
        this.h306 = h306;
        notifyPropertyChanged(BR.h306);
    }

    @Bindable
    public String getH307() {
        return h307;
    }

    public void setH307(String h307) {
        this.h307 = h307;
        notifyPropertyChanged(BR.h307);
    }

    @Bindable
    public String getH308() {
        return h308;
    }

    public void setH308(String h308) {
        this.h308 = h308;
        notifyPropertyChanged(BR.h308);
    }

    @Bindable
    public String getH309() {
        return h309;
    }

    public void setH309(String h309) {
        this.h309 = h309;
        notifyPropertyChanged(BR.h309);
    }

    @Bindable
    public String getAb101() {
        return ab101;
    }

    public void setAb101(String ab101) {
        this.ab101 = ab101;
        notifyPropertyChanged(BR.ab101);
    }

    @Bindable
    public String getAb102() {
        return ab102;
    }

    public void setAb102(String ab102) {
        this.ab102 = ab102;
        notifyPropertyChanged(BR.ab102);
    }

    @Bindable
    public String getAb103() {
        return ab103;
    }

    public void setAb103(String ab103) {
        this.ab103 = ab103;
        setAb104a(ab103.equals("2") ? "" : this.ab104a);
        setAb104b(ab103.equals("2") ? "" : this.ab104b);
        setAb104c(ab103.equals("2") ? "" : this.ab104c);
        setAb104d(ab103.equals("2") ? "" : this.ab104d);
        setAb10496(ab103.equals("2") ? "" : this.ab10496);
        setAb105(ab103.equals("2") ? "" : this.ab105);
        notifyPropertyChanged(BR.ab103);
    }

    @Bindable
    public String getAb104() {
        return ab104;
    }

    public void setAb104(String ab104) {
        this.ab104 = ab104;
        notifyPropertyChanged(BR.ab104);
    }

    @Bindable
    public String getAb104a() {
        return ab104a;
    }

    public void setAb104a(String ab104a) {
        if (this.ab104a.equals(ab104a)) return;
        this.ab104a = ab104a;
        notifyPropertyChanged(BR.ab104a);
    }

    @Bindable
    public String getAb104b() {
        return ab104b;
    }

    public void setAb104b(String ab104b) {
        if (this.ab104b.equals(ab104b)) return;
        this.ab104b = ab104b;
        notifyPropertyChanged(BR.ab104b);
    }

    @Bindable
    public String getAb104c() {
        return ab104c;
    }

    public void setAb104c(String ab104c) {
        if (this.ab104c.equals(ab104c)) return;
        this.ab104c = ab104c;
        notifyPropertyChanged(BR.ab104c);
    }

    @Bindable
    public String getAb104d() {
        return ab104d;
    }

    public void setAb104d(String ab104d) {
        if (this.ab104d.equals(ab104d)) return;
        this.ab104d = ab104d;
        notifyPropertyChanged(BR.ab104d);
    }

    @Bindable
    public String getAb10496() {
        return ab10496;
    }

    public void setAb10496(String ab10496) {
        if (this.ab10496.equals(ab10496)) return;
        this.ab10496 = ab10496;
        setAb10496x(ab10496.equals("96") ? this.ab10496x : "");
        notifyPropertyChanged(BR.ab10496);
    }

    @Bindable
    public String getAb10496x() {
        return ab10496x;
    }

    public void setAb10496x(String ab10496x) {
        this.ab10496x = ab10496x;
        notifyPropertyChanged(BR.ab10496x);
    }

    @Bindable
    public String getAb105() {
        return ab105;
    }

    public void setAb105(String ab105) {
        this.ab105 = ab105;
        notifyPropertyChanged(BR.ab105);
    }

    @Bindable
    public String getAb106() {
        return ab106;
    }

    public void setAb106(String ab106) {
        this.ab106 = ab106;
        setAb107(ab106.equals("2") ? "" : this.ab107);
        setAb108a(ab106.equals("2") ? "" : this.ab108a);
        setAb108b(ab106.equals("2") ? "" : this.ab108b);
        setAb108c(ab106.equals("2") ? "" : this.ab108c);
        setAb108d(ab106.equals("2") ? "" : this.ab108d);
        setAb108e(ab106.equals("2") ? "" : this.ab108e);
        setAb108f(ab106.equals("2") ? "" : this.ab108f);
        setAb108g(ab106.equals("2") ? "" : this.ab108g);
        setAb108h(ab106.equals("2") ? "" : this.ab108h);
        setAb108i(ab106.equals("2") ? "" : this.ab108i);
        setAb108j(ab106.equals("2") ? "" : this.ab108j);
        setAb108k(ab106.equals("2") ? "" : this.ab108k);
        setAb10896(ab106.equals("2") ? "" : this.ab10896);
        setAb109(ab106.equals("2") ? "" : this.ab109);
        setAb110a(ab106.equals("2") ? "" : this.ab110a);
        setAb110b(ab106.equals("2") ? "" : this.ab110b);
        setAb110c(ab106.equals("2") ? "" : this.ab110c);
        setAb110d(ab106.equals("2") ? "" : this.ab110d);
        setAb110e(ab106.equals("2") ? "" : this.ab110e);
        setAb11096(ab106.equals("2") ? "" : this.ab11096);
        setAb111(ab106.equals("2") ? "" : this.ab111);
        notifyPropertyChanged(BR.ab106);
    }

    @Bindable
    public String getAb107() {
        return ab107;
    }

    public void setAb107(String ab107) {
        this.ab107 = ab107;
        setAb108a(ab107.equals("1") ? "" : this.ab108a);
        setAb108b(ab107.equals("1") ? "" : this.ab108b);
        setAb108c(ab107.equals("1") ? "" : this.ab108c);
        setAb108d(ab107.equals("1") ? "" : this.ab108d);
        setAb108e(ab107.equals("1") ? "" : this.ab108e);
        setAb108f(ab107.equals("1") ? "" : this.ab108f);
        setAb108g(ab107.equals("1") ? "" : this.ab108g);
        setAb108h(ab107.equals("1") ? "" : this.ab108h);
        setAb108i(ab107.equals("1") ? "" : this.ab108i);
        setAb108j(ab107.equals("1") ? "" : this.ab108j);
        setAb108k(ab107.equals("1") ? "" : this.ab108k);
        setAb10896(ab107.equals("1") ? "" : this.ab10896);
        notifyPropertyChanged(BR.ab107);
    }

    @Bindable
    public String getAb108() {
        return ab108;
    }

    public void setAb108(String ab108) {
        this.ab108 = ab108;
        notifyPropertyChanged(BR.ab108);
    }

    @Bindable
    public String getAb108a() {
        return ab108a;
    }

    public void setAb108a(String ab108a) {
        if (this.ab108a.equals(ab108a)) return;
        this.ab108a = ab108a;
        notifyPropertyChanged(BR.ab108a);
    }

    @Bindable
    public String getAb108b() {
        return ab108b;
    }

    public void setAb108b(String ab108b) {
        if (this.ab108b.equals(ab108b)) return;
        this.ab108b = ab108b;
        notifyPropertyChanged(BR.ab108b);
    }

    @Bindable
    public String getAb108c() {
        return ab108c;
    }

    public void setAb108c(String ab108c) {
        if (this.ab108c.equals(ab108c)) return;
        this.ab108c = ab108c;
        notifyPropertyChanged(BR.ab108c);
    }

    @Bindable
    public String getAb108d() {
        return ab108d;
    }

    public void setAb108d(String ab108d) {
        if (this.ab108d.equals(ab108d)) return;
        this.ab108d = ab108d;
        notifyPropertyChanged(BR.ab108d);
    }

    @Bindable
    public String getAb108e() {
        return ab108e;
    }

    public void setAb108e(String ab108e) {
        if (this.ab108e.equals(ab108e)) return;
        this.ab108e = ab108e;
        notifyPropertyChanged(BR.ab108e);
    }

    @Bindable
    public String getAb108f() {
        return ab108f;
    }

    public void setAb108f(String ab108f) {
        if (this.ab108f.equals(ab108f)) return;
        this.ab108f = ab108f;
        notifyPropertyChanged(BR.ab108f);
    }

    @Bindable
    public String getAb108g() {
        return ab108g;
    }

    public void setAb108g(String ab108g) {
        if (this.ab108g.equals(ab108g)) return;
        this.ab108g = ab108g;
        notifyPropertyChanged(BR.ab108g);
    }

    @Bindable
    public String getAb108h() {
        return ab108h;
    }

    public void setAb108h(String ab108h) {
        if (this.ab108h.equals(ab108h)) return;
        this.ab108h = ab108h;
        notifyPropertyChanged(BR.ab108h);
    }

    @Bindable
    public String getAb108i() {
        return ab108i;
    }

    public void setAb108i(String ab108i) {
        if (this.ab108i.equals(ab108i)) return;
        this.ab108i = ab108i;
        notifyPropertyChanged(BR.ab108i);
    }

    @Bindable
    public String getAb108j() {
        return ab108j;
    }

    public void setAb108j(String ab108j) {
        if (this.ab108j.equals(ab108j)) return;
        this.ab108j = ab108j;
        notifyPropertyChanged(BR.ab108j);
    }

    @Bindable
    public String getAb108k() {
        return ab108k;
    }

    public void setAb108k(String ab108k) {
        if (this.ab108k.equals(ab108k)) return;
        this.ab108k = ab108k;
        notifyPropertyChanged(BR.ab108k);
    }

    @Bindable
    public String getAb10896() {
        return ab10896;
    }

    public void setAb10896(String ab10896) {
        if (this.ab10896.equals(ab10896)) return;
        this.ab10896 = ab10896;
        setAb10896x(ab10896.equals("96") ? this.ab10896x : "");
        notifyPropertyChanged(BR.ab10896);
    }

    @Bindable
    public String getAb10896x() {
        return ab10896x;
    }

    public void setAb10896x(String ab10896x) {
        this.ab10896x = ab10896x;
        notifyPropertyChanged(BR.ab10896x);
    }

    @Bindable
    public String getAb109() {
        return ab109;
    }

    public void setAb109(String ab109) {
        this.ab109 = ab109;
        notifyPropertyChanged(BR.ab109);
    }

    @Bindable
    public String getAb10996x() {
        return ab10996x;
    }

    public void setAb10996x(String ab10996x) {
        this.ab10996x = ab10996x;
        notifyPropertyChanged(BR.ab10996x);
    }

    @Bindable
    public String getAb110() {
        return ab110;
    }

    public void setAb110(String ab110) {
        this.ab110 = ab110;
        notifyPropertyChanged(BR.ab110);
    }

    @Bindable
    public String getAb110a() {
        return ab110a;
    }

    public void setAb110a(String ab110a) {
        if (this.ab110a.equals(ab110a)) return;
        this.ab110a = ab110a;
        notifyPropertyChanged(BR.ab110a);
    }

    @Bindable
    public String getAb110b() {
        return ab110b;
    }

    public void setAb110b(String ab110b) {
        if (this.ab110b.equals(ab110b)) return;
        this.ab110b = ab110b;
        notifyPropertyChanged(BR.ab110b);
    }

    @Bindable
    public String getAb110c() {
        return ab110c;
    }

    public void setAb110c(String ab110c) {
        if (this.ab110c.equals(ab110c)) return;
        this.ab110c = ab110c;
        notifyPropertyChanged(BR.ab110c);
    }

    @Bindable
    public String getAb110d() {
        return ab110d;
    }

    public void setAb110d(String ab110d) {
        if (this.ab110d.equals(ab110d)) return;
        this.ab110d = ab110d;
        notifyPropertyChanged(BR.ab110d);
    }

    @Bindable
    public String getAb110e() {
        return ab110e;
    }

    public void setAb110e(String ab110e) {
        if (this.ab110e.equals(ab110e)) return;
        this.ab110e = ab110e;
        notifyPropertyChanged(BR.ab110e);
    }

    @Bindable
    public String getAb11096() {
        return ab11096;
    }

    public void setAb11096(String ab11096) {
        if (this.ab11096.equals(ab11096)) return;
        this.ab11096 = ab11096;
        setAb11096x(ab11096.equals("96") ? this.ab11096x : "");
        notifyPropertyChanged(BR.ab11096);
    }

    @Bindable
    public String getAb11096x() {
        return ab11096x;
    }

    public void setAb11096x(String ab11096x) {
        this.ab11096x = ab11096x;
        notifyPropertyChanged(BR.ab11096x);
    }

    @Bindable
    public String getAb111() {
        return ab111;
    }

    public void setAb111(String ab111) {
        this.ab111 = ab111;
        notifyPropertyChanged(BR.ab111);
    }

    @Bindable
    public String getAb112() {
        return ab112;
    }

    public void setAb112(String ab112) {
        this.ab112 = ab112;
        notifyPropertyChanged(BR.ab112);
    }

    @Bindable
    public String getAb113() {
        return ab113;
    }

    public void setAb113(String ab113) {
        this.ab113 = ab113;
        notifyPropertyChanged(BR.ab113);
    }

    @Bindable
    public String getAb113a() {
        return ab113a;
    }

    public void setAb113a(String ab113a) {
        if (this.ab113a.equals(ab113a)) return;
        this.ab113a = ab113a;
        notifyPropertyChanged(BR.ab113a);
    }

    @Bindable
    public String getAb113b() {
        return ab113b;
    }

    public void setAb113b(String ab113b) {
        if (this.ab113b.equals(ab113b)) return;
        this.ab113b = ab113b;
        notifyPropertyChanged(BR.ab113b);
    }

    @Bindable
    public String getAb113c() {
        return ab113c;
    }

    public void setAb113c(String ab113c) {
        if (this.ab113c.equals(ab113c)) return;
        this.ab113c = ab113c;
        setAb113a(ab113c.equals("3") ? "" : this.ab113a);
        setAb113b(ab113c.equals("3") ? "" : this.ab113b);
        setAb11398(ab113c.equals("3") ? "" : this.ab11398);
        setAb11396(ab113c.equals("3") ? "" : this.ab11396);
        notifyPropertyChanged(BR.ab113c);
    }

    @Bindable
    public String getAb11398() {
        return ab11398;
    }

    public void setAb11398(String ab11398) {
        if (this.ab11398.equals(ab11398)) return;
        this.ab11398 = ab11398;
        setAb113a(ab11398.equals("98") ? "" : this.ab113a);
        setAb113b(ab11398.equals("98") ? "" : this.ab113b);
        setAb113c(ab11398.equals("98") ? "" : this.ab113c);
        setAb11396(ab11398.equals("98") ? "" : this.ab11396);
        notifyPropertyChanged(BR.ab11398);
    }

    @Bindable
    public String getAb11396() {
        return ab11396;
    }

    public void setAb11396(String ab11396) {
        if (this.ab11396.equals(ab11396)) return;
        this.ab11396 = ab11396;
        setAb11396x(ab11396.equals("96") ? this.ab11396x : "");
        notifyPropertyChanged(BR.ab11396);
    }

    @Bindable
    public String getAb11396x() {
        return ab11396x;
    }

    public void setAb11396x(String ab11396x) {
        this.ab11396x = ab11396x;
        notifyPropertyChanged(BR.ab11396x);
    }

    @Bindable
    public String getAb114() {
        return ab114;
    }

    public void setAb114(String ab114) {
        this.ab114 = ab114;
        setAb115(ab114.equals("2") ? "" : this.ab115);
        setAb117(ab114.equals("2") ? "" : this.ab117);
        notifyPropertyChanged(BR.ab114);
    }

    @Bindable
    public String getAb115() {
        return ab115;
    }

    public void setAb115(String ab115) {
        this.ab115 = ab115;
        notifyPropertyChanged(BR.ab115);
    }

    @Bindable
    public String getAb117() {
        return ab117;
    }

    public void setAb117(String ab117) {
        this.ab117 = ab117;
        notifyPropertyChanged(BR.ab117);
    }

    @Bindable
    public String getAb118a() {
        return ab118a;
    }

    public void setAb118a(String ab118a) {
        this.ab118a = ab118a;
        notifyPropertyChanged(BR.ab118a);
    }

    @Bindable
    public String getAb118b() {
        return ab118b;
    }

    public void setAb118b(String ab118b) {
        this.ab118b = ab118b;
        notifyPropertyChanged(BR.ab118b);
    }

    @Bindable
    public String getAb118c() {
        return ab118c;
    }

    public void setAb118c(String ab118c) {
        this.ab118c = ab118c;
        notifyPropertyChanged(BR.ab118c);
    }

    @Bindable
    public String getAb118d() {
        return ab118d;
    }

    public void setAb118d(String ab118d) {
        this.ab118d = ab118d;
        notifyPropertyChanged(BR.ab118d);
    }

    @Bindable
    public String getAb118e() {
        return ab118e;
    }

    public void setAb118e(String ab118e) {
        this.ab118e = ab118e;
        notifyPropertyChanged(BR.ab118e);
    }

    @Bindable
    public String getAb118f() {
        return ab118f;
    }

    public void setAb118f(String ab118f) {
        this.ab118f = ab118f;
        notifyPropertyChanged(BR.ab118f);
    }

    @Bindable
    public String getAb118g() {
        return ab118g;
    }

    public void setAb118g(String ab118g) {
        this.ab118g = ab118g;
        notifyPropertyChanged(BR.ab118g);
    }

    @Bindable
    public String getAb118h() {
        return ab118h;
    }

    public void setAb118h(String ab118h) {
        this.ab118h = ab118h;
        notifyPropertyChanged(BR.ab118h);
    }

    @Bindable
    public String getAb118i() {
        return ab118i;
    }

    public void setAb118i(String ab118i) {
        this.ab118i = ab118i;
        notifyPropertyChanged(BR.ab118i);
    }

    @Bindable
    public String getAb118j() {
        return ab118j;
    }

    public void setAb118j(String ab118j) {
        this.ab118j = ab118j;
        notifyPropertyChanged(BR.ab118j);
    }

    @Bindable
    public String getAb118k() {
        return ab118k;
    }

    public void setAb118k(String ab118k) {
        this.ab118k = ab118k;
        notifyPropertyChanged(BR.ab118k);
    }

    @Bindable
    public String getAb118l() {
        return ab118l;
    }

    public void setAb118l(String ab118l) {
        this.ab118l = ab118l;
        notifyPropertyChanged(BR.ab118l);
    }

    @Bindable
    public String getAb118m() {
        return ab118m;
    }

    public void setAb118m(String ab118m) {
        this.ab118m = ab118m;
        notifyPropertyChanged(BR.ab118m);
    }

    @Bindable
    public String getAb118n() {
        return ab118n;
    }

    public void setAb118n(String ab118n) {
        this.ab118n = ab118n;
        notifyPropertyChanged(BR.ab118n);
    }

    @Bindable
    public String getAb118o() {
        return ab118o;
    }

    public void setAb118o(String ab118o) {
        this.ab118o = ab118o;
        notifyPropertyChanged(BR.ab118o);
    }

    @Bindable
    public String getAb118p() {
        return ab118p;
    }

    public void setAb118p(String ab118p) {
        this.ab118p = ab118p;
        notifyPropertyChanged(BR.ab118p);
    }

    @Bindable
    public String getAb118q() {
        return ab118q;
    }

    public void setAb118q(String ab118q) {
        this.ab118q = ab118q;
        notifyPropertyChanged(BR.ab118q);
    }

    @Bindable
    public String getAb118r() {
        return ab118r;
    }

    public void setAb118r(String ab118r) {
        this.ab118r = ab118r;
        notifyPropertyChanged(BR.ab118r);
    }

    @Bindable
    public String getAb118s() {
        return ab118s;
    }

    public void setAb118s(String ab118s) {
        this.ab118s = ab118s;
        notifyPropertyChanged(BR.ab118s);
    }

    @Bindable
    public String getAb118t() {
        return ab118t;
    }

    public void setAb118t(String ab118t) {
        this.ab118t = ab118t;
        notifyPropertyChanged(BR.ab118t);
    }

    @Bindable
    public String getAb118u() {
        return ab118u;
    }

    public void setAb118u(String ab118u) {
        this.ab118u = ab118u;
        notifyPropertyChanged(BR.ab118u);
    }

    @Bindable
    public String getAb119() {
        return ab119;
    }

    public void setAb119(String ab119) {
        this.ab119 = ab119;
        notifyPropertyChanged(BR.ab119);
    }

    @Bindable
    public String getM101() {
        return m101;
    }

    public void setM101(String m101) {
        this.m101 = m101;
        setM102(m101.equals("2") ? "" : this.m102);
        setM103(m101.equals("2") ? "" : this.m103);
        setM104(m101.equals("2") ? "" : this.m104);
        setM105a(m101.equals("2") ? "" : this.m105a);
        setM105b(m101.equals("2") ? "" : this.m105b);
        setM105c(m101.equals("2") ? "" : this.m105c);
        setM105d(m101.equals("2") ? "" : this.m105d);
        setM105e(m101.equals("2") ? "" : this.m105e);
        setM105f(m101.equals("2") ? "" : this.m105f);
        setM105g(m101.equals("2") ? "" : this.m105g);
        setM105h(m101.equals("2") ? "" : this.m105h);
        setM10596(m101.equals("2") ? "" : this.m10596);
        setM106a(m101.equals("2") ? "" : this.m106a);
        setM106b(m101.equals("2") ? "" : this.m106b);
        setM106c(m101.equals("2") ? "" : this.m106c);
        setM106d(m101.equals("2") ? "" : this.m106d);
        notifyPropertyChanged(BR.m101);
    }

    @Bindable
    public String getM102() {
        return m102;
    }

    public void setM102(String m102) {
        this.m102 = m102;
        notifyPropertyChanged(BR.m102);
    }

    @Bindable
    public String getM103() {
        return m103;
    }

    public void setM103(String m103) {
        this.m103 = m103;
        setM104(m103.equals("2") ? "" : this.m104);
        setM105a(m103.equals("1") ? "" : this.m105a);
        setM105b(m103.equals("1") ? "" : this.m105b);
        setM105c(m103.equals("1") ? "" : this.m105c);
        setM105d(m103.equals("1") ? "" : this.m105d);
        setM105e(m103.equals("1") ? "" : this.m105e);
        setM105f(m103.equals("1") ? "" : this.m105f);
        setM105g(m103.equals("1") ? "" : this.m105g);
        setM105h(m103.equals("1") ? "" : this.m105h);
        setM10596(m103.equals("1") ? "" : this.m10596);
        setM106a(m103.equals("2") ? "" : this.m106a);
        setM106b(m103.equals("2") ? "" : this.m106b);
        setM106c(m103.equals("2") ? "" : this.m106c);
        setM106d(m103.equals("2") ? "" : this.m106d);
        notifyPropertyChanged(BR.m103);
    }

    @Bindable
    public String getM104() {
        return m104;
    }

    public void setM104(String m104) {
        this.m104 = m104;
        notifyPropertyChanged(BR.m104);
    }

    @Bindable
    public String getM105() {
        return m105;
    }

    public void setM105(String m105) {
        this.m105 = m105;
        notifyPropertyChanged(BR.m105);
    }

    @Bindable
    public String getM105a() {
        return m105a;
    }

    public void setM105a(String m105a) {
        if (this.m105a.equals(m105a)) return;
        this.m105a = m105a;
        notifyPropertyChanged(BR.m105a);
    }

    @Bindable
    public String getM105b() {
        return m105b;
    }

    public void setM105b(String m105b) {
        if (this.m105b.equals(m105b)) return;
        this.m105b = m105b;
        notifyPropertyChanged(BR.m105b);
    }

    @Bindable
    public String getM105c() {
        return m105c;
    }

    public void setM105c(String m105c) {
        if (this.m105c.equals(m105c)) return;
        this.m105c = m105c;
        notifyPropertyChanged(BR.m105c);
    }

    @Bindable
    public String getM105d() {
        return m105d;
    }

    public void setM105d(String m105d) {
        if (this.m105d.equals(m105d)) return;
        this.m105d = m105d;
        notifyPropertyChanged(BR.m105d);
    }

    @Bindable
    public String getM105e() {
        return m105e;
    }

    public void setM105e(String m105e) {
        if (this.m105e.equals(m105e)) return;
        this.m105e = m105e;
        notifyPropertyChanged(BR.m105e);
    }

    @Bindable
    public String getM105f() {
        return m105f;
    }

    public void setM105f(String m105f) {
        if (this.m105f.equals(m105f)) return;
        this.m105f = m105f;
        notifyPropertyChanged(BR.m105f);
    }

    @Bindable
    public String getM105g() {
        return m105g;
    }

    public void setM105g(String m105g) {
        if (this.m105g.equals(m105g)) return;
        this.m105g = m105g;
        notifyPropertyChanged(BR.m105g);
    }

    @Bindable
    public String getM105h() {
        return m105h;
    }

    public void setM105h(String m105h) {
        if (this.m105h.equals(m105h)) return;
        this.m105h = m105h;
        notifyPropertyChanged(BR.m105h);
    }

    @Bindable
    public String getM10596() {
        return m10596;
    }

    public void setM10596(String m10596) {
        if (this.m10596.equals(m10596)) return;
        this.m10596 = m10596;
        setM10596x(m10596.equals("96") ? this.m10596x : "");
        notifyPropertyChanged(BR.m10596);
    }

    @Bindable
    public String getM10596x() {
        return m10596x;
    }

    public void setM10596x(String m10596x) {
        this.m10596x = m10596x;
        notifyPropertyChanged(BR.m10596x);
    }

    @Bindable
    public String getM106() {
        return m106;
    }

    public void setM106(String m106) {
        this.m106 = m106;
        notifyPropertyChanged(BR.m106);
    }

    @Bindable
    public String getM106a() {
        return m106a;
    }

    public void setM106a(String m106a) {
        if (this.m106a.equals(m106a)) return;
        this.m106a = m106a;
        notifyPropertyChanged(BR.m106a);
    }

    @Bindable
    public String getM106b() {
        return m106b;
    }

    public void setM106b(String m106b) {
        if (this.m106b.equals(m106b)) return;
        this.m106b = m106b;
        notifyPropertyChanged(BR.m106b);
    }

    @Bindable
    public String getM106c() {
        return m106c;
    }

    public void setM106c(String m106c) {
        if (this.m106c.equals(m106c)) return;
        this.m106c = m106c;
        notifyPropertyChanged(BR.m106c);
    }

    @Bindable
    public String getM106d() {
        return m106d;
    }

    public void setM106d(String m106d) {
        if (this.m106d.equals(m106d)) return;
        this.m106d = m106d;
        notifyPropertyChanged(BR.m106d);
    }


    public Form Hydrate(Cursor cursor) throws JSONException {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_UID));
        this.cluster = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_CLUSTER));
        this.hhid = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_HHID));
        this.userName = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SYSDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SYNCED_DATE));

        sAHydrate(cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SA)));
        sBHydrate(cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SB)));
        sCHydrate(cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SC)));
        sH1Hydrate(cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SH1)));
        sH2Hydrate(cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SH2)));
        sH3Hydrate(cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SH3)));
        sABHydrate(cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SAB)));
        sMHydrate(cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SM)));

        return this;
    }

    public void sAHydrate(String string) throws JSONException {
        Log.d(TAG, "sAHydrate: " + string);
        if (string != null) {

            JSONObject json = null;
            json = new JSONObject(string);
            this.a101 = json.getString("a101");
            this.a102 = json.getString("a102");
            this.a103 = json.getString("a103");
            this.a104n = json.getString("a104n");
            this.a104c = json.getString("a104c");
            this.a105 = json.getString("a105");
            this.a106 = json.getString("a106");
            this.a107 = json.getString("a107");
            this.a10796x = json.getString("a10796x");
            this.a108 = json.getString("a108");
            this.a109 = json.getString("a109");
            this.lhwphoto = json.getString("lhwphoto");
        }
    }

    public void sBHydrate(String string) throws JSONException {
        Log.d(TAG, "sBHydrate: " + string);
        if (string != null) {

            JSONObject json = null;
            json = new JSONObject(string);
            this.b101 = json.getString("b101");
            this.b102 = json.getString("b102");
            this.b103 = json.getString("b103");
            this.b10396x = json.getString("b10396x");
            this.b104 = json.getString("b104");
            this.b107a = json.getString("b107a");
            this.b107b = json.getString("b107b");
            this.b107c = json.getString("b107c");
            this.b107d = json.getString("b107d");
            this.b107e = json.getString("b107e");
            this.b107f = json.getString("b107f");
            this.b107g = json.getString("b107g");
            this.b107h = json.getString("b107h");
            this.b107i = json.getString("b107i");
            this.b107j = json.getString("b107j");
            this.b108a = json.getString("b108a");
            this.b108b = json.getString("b108b");
            this.b108c = json.getString("b108c");
            this.b108d = json.getString("b108d");
            this.b108e = json.getString("b108e");
            this.b108f = json.getString("b108f");
            this.b108g = json.getString("b108g");
            this.b108h = json.getString("b108h");
            this.b108i = json.getString("b108i");
            this.b108j = json.getString("b108j");
            this.b108k = json.getString("b108k");
            this.b108l = json.getString("b108l");
            this.b108m = json.getString("b108m");
            this.b108n = json.getString("b108n");
            this.b108o = json.getString("b108o");
            this.b108p = json.getString("b108p");
            this.b108q = json.getString("b108q");
            this.b108r = json.getString("b108r");
            this.b108s = json.getString("b108s");
            this.b108t = json.getString("b108t");
            this.b108u = json.getString("b108u");
            this.b108v = json.getString("b108v");
            this.b108w = json.getString("b108w");
        }
    }

    public void sCHydrate(String string) throws JSONException {
        Log.d(TAG, "sCHydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.c101s = json.getString("c101s");
            this.c101m = json.getString("c101m");
            this.c102s = json.getString("c102s");
            this.c102m = json.getString("c102m");
            this.c103s = json.getString("c103s");
            this.c103m = json.getString("c103m");
            this.c104s = json.getString("c104s");
            this.c104m = json.getString("c104m");
            this.c105s = json.getString("c105s");
            this.c105m = json.getString("c105m");
            this.c106s = json.getString("c106s");
            this.c106m = json.getString("c106m");
            this.c107s = json.getString("c107s");
            this.c107m = json.getString("c107m");
            this.c108s = json.getString("c108s");
            this.c108m = json.getString("c108m");
            this.c109s = json.getString("c109s");
            this.c109m = json.getString("c109m");
            this.c110s = json.getString("c110s");
            this.c110m = json.getString("c110m");
            this.c111s = json.getString("c111s");
            this.c111m = json.getString("c111m");
            this.c112s = json.getString("c112s");
            this.c112m = json.getString("c112m");
            this.c113s = json.getString("c113s");
            this.c113m = json.getString("c113m");
            this.c114s = json.getString("c114s");
            this.c114m = json.getString("c114m");
            this.c115s = json.getString("c115s");
            this.c115m = json.getString("c115m");
            this.c116s = json.getString("c116s");
            this.c116m = json.getString("c116m");
            this.c117s = json.getString("c117s");
            this.c117m = json.getString("c117m");
            this.c118s = json.getString("c118s");
            this.c118m = json.getString("c118m");
            this.c119s = json.getString("c119s");
            this.c119m = json.getString("c119m");
            this.c120s = json.getString("c10s");
            this.c120m = json.getString("c120m");
            this.c121s = json.getString("c121s");
            this.c121m = json.getString("c121m");
            this.c122s = json.getString("c122s");
            this.c122m = json.getString("c122m");
            this.c123s = json.getString("c123s");
            this.c123m = json.getString("c123m");
            this.c124s = json.getString("c124s");
            this.c124m = json.getString("c124m");
            this.c125s = json.getString("c125s");
            this.c125m = json.getString("c125m");
            this.c126s = json.getString("c126s");
            this.c126m = json.getString("c126m");
            this.c127s = json.getString("c127s");
            this.c127m = json.getString("c127m");
            this.c128s = json.getString("c128s");
            this.c128m = json.getString("c128m");
            this.c129s = json.getString("c129s");
            this.c129m = json.getString("c129m");
            this.c130s = json.getString("c130s");
            this.c130m = json.getString("c130m");
            this.c131s = json.getString("c131s");
            this.c131m = json.getString("c131m");
            this.c132s = json.getString("c132s");
            this.c132m = json.getString("c132m");
            this.c133s = json.getString("c133s");
            this.c133m = json.getString("c133m");
            this.c134s = json.getString("c134s");
            this.c134m = json.getString("c134m");
            this.c135s = json.getString("c135s");
            this.c135m = json.getString("c135m");
            this.c136s = json.getString("c136s");
            this.c136m = json.getString("c136m");
            this.c137s = json.getString("c137s");
            this.c137m = json.getString("c137m");
            this.c138s = json.getString("c138s");
            this.c138m = json.getString("c138m");
            this.c139s = json.getString("c139s");
            this.c139m = json.getString("c139m");
            this.c140 = json.getString("c140");
            this.c141 = json.getString("c141");
            this.c14196x = json.getString("c14196x");
        }
    }

    public void sH1Hydrate(String string) throws JSONException {
        Log.d(TAG, "sH1Hydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.h101 = json.getString("h101");
            this.h102 = json.getString("h102");
            this.h103 = json.getString("h103");
            this.h104a = json.getString("h104a");
            this.h104b = json.getString("h104b");
            this.h104c = json.getString("h104c");
            this.h104d = json.getString("h104d");
            this.h104e = json.getString("h104e");
            this.h104f = json.getString("h104f");
        }
    }

    public void sH2Hydrate(String string) throws JSONException {
        Log.d(TAG, "sH2Hydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.h201 = json.getString("h201");
            this.h202 = json.getString("h202");
            this.h203 = json.getString("h203");
            this.h204a = json.getString("h204a");
            this.h204b = json.getString("h204b");
            this.h204c = json.getString("h204c");
            this.h204d = json.getString("h204d");
            this.h204e = json.getString("h204e");
            this.h204f = json.getString("h204f");
            this.h205 = json.getString("h205");
        }
    }

    public void sH3Hydrate(String string) throws JSONException {
        Log.d(TAG, "sH3Hydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.h301 = json.getString("h301");
            this.h302 = json.getString("h302");
            this.h303 = json.getString("h303");
            this.h304d = json.getString("h304d");
            this.h304m = json.getString("h304m");
            this.h304y = json.getString("h304y");
            this.h305 = json.getString("h305");
            this.h306 = json.getString("h306");
            this.h307 = json.getString("h307");
            this.h308 = json.getString("h308");
            this.h309 = json.getString("h309");
        }
    }

    public void sABHydrate(String string) throws JSONException {
        Log.d(TAG, "sABHydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.ab101 = json.getString("ab101");
            this.ab102 = json.getString("ab102");
            this.ab103 = json.getString("ab103");
            this.ab104 = json.getString("ab104");
            this.ab104a = json.getString("ab104a");
            this.ab104b = json.getString("ab104b");
            this.ab104c = json.getString("ab104c");
            this.ab104d = json.getString("ab104d");
            this.ab10496 = json.getString("ab10496");
            this.ab10496x = json.getString("ab10496x");
            this.ab105 = json.getString("ab105");
            this.ab106 = json.getString("ab106");
            this.ab107 = json.getString("ab107");
            this.ab108 = json.getString("ab108");
            this.ab108a = json.getString("ab108a");
            this.ab108b = json.getString("ab108b");
            this.ab108c = json.getString("ab108c");
            this.ab108d = json.getString("ab108d");
            this.ab108e = json.getString("ab108e");
            this.ab108f = json.getString("ab108f");
            this.ab108g = json.getString("ab108g");
            this.ab108h = json.getString("ab108h");
            this.ab108i = json.getString("ab108i");
            this.ab108j = json.getString("ab108j");
            this.ab108k = json.getString("ab108k");
            this.ab10896 = json.getString("ab10896");
            this.ab10896x = json.getString("ab10896x");
            this.ab109 = json.getString("ab109");
            this.ab10996x = json.getString("ab10996x");
            this.ab110 = json.getString("ab110");
            this.ab110a = json.getString("ab110a");
            this.ab110b = json.getString("ab110b");
            this.ab110c = json.getString("ab110c");
            this.ab110d = json.getString("ab110d");
            this.ab110e = json.getString("ab110e");
            this.ab11096 = json.getString("ab11096");
            this.ab11096x = json.getString("ab11096x");
            this.ab111 = json.getString("ab111");
            this.ab112 = json.getString("ab112");
            this.ab113 = json.getString("ab113");
            this.ab113a = json.getString("ab113a");
            this.ab113b = json.getString("ab113b");
            this.ab113c = json.getString("ab113c");
            this.ab11398 = json.getString("ab11398");
            this.ab11396 = json.getString("ab11396");
            this.ab114 = json.getString("ab114");
            this.ab115 = json.getString("ab115");
            this.ab117 = json.getString("ab117");
            this.ab118a = json.getString("ab118a");
            this.ab118b = json.getString("ab118b");
            this.ab118c = json.getString("ab118c");
            this.ab118d = json.getString("ab118d");
            this.ab118e = json.getString("ab118e");
            this.ab118f = json.getString("ab118f");
            this.ab118g = json.getString("ab118g");
            this.ab118h = json.getString("ab118h");
            this.ab118i = json.getString("ab118i");
            this.ab118j = json.getString("ab118j");
            this.ab118k = json.getString("ab118k");
            this.ab118l = json.getString("ab118l");
            this.ab118m = json.getString("ab118m");
            this.ab118n = json.getString("ab118n");
            this.ab118o = json.getString("ab118o");
            this.ab118p = json.getString("ab118p");
            this.ab118q = json.getString("ab118q");
            this.ab118r = json.getString("ab118r");
            this.ab118s = json.getString("ab118s");
            this.ab118t = json.getString("ab118t");
            this.ab118u = json.getString("ab118u");
            this.ab119 = json.getString("ab119");
        }
    }

    public void sMHydrate(String string) throws JSONException {
        Log.d(TAG, "sMHydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.m101 = json.getString("m101");
            this.m102 = json.getString("m102");
            this.m103 = json.getString("m103");
            this.m104 = json.getString("m104");
            this.m105 = json.getString("m105");
            this.m105a = json.getString("m105a");
            this.m105b = json.getString("m105b");
            this.m105c = json.getString("m105c");
            this.m105d = json.getString("m105d");
            this.m105e = json.getString("m105e");
            this.m105f = json.getString("m105f");
            this.m105g = json.getString("m105g");
            this.m105h = json.getString("m105h");
            this.m10596 = json.getString("m10596");
            this.m10596x = json.getString("m10596x");
            this.m106 = json.getString("m106");
            this.m106a = json.getString("m106a");
            this.m106b = json.getString("m106b");
            this.m106c = json.getString("m106c");
            this.m106d = json.getString("m106d");
        }
    }


    public String sAtoString() throws JSONException {
        Log.d(TAG, "sAtoString: ");
        JSONObject json = new JSONObject();
        json.put("a101", a101)
                .put("a102", a102)
                .put("a103", a103)
                .put("a104n", a104n)
                .put("a104c", a104c)
                .put("a105", a105)
                .put("a106", a106)
                .put("a107", a107)
                .put("a10796x", a10796x)
                .put("a108", a108)
                .put("a109", a109)
                .put("lhwphoto", lhwphoto);
        return json.toString();
    }

    public String sBtoString() throws JSONException {
        Log.d(TAG, "sBtoString: ");
        JSONObject json = new JSONObject();
        json.put("b101", b101)
                .put("b102", b102)
                .put("b103", b103)
                .put("b10396x", b10396x)
                .put("b104", b104)
                .put("b107a", b107a)
                .put("b107b", b107b)
                .put("b107c", b107c)
                .put("b107d", b107d)
                .put("b107e", b107e)
                .put("b107f", b107f)
                .put("b107g", b107g)
                .put("b107h", b107h)
                .put("b107i", b107i)
                .put("b107j", b107j)
                .put("b108a", b108a)
                .put("b108b", b108b)
                .put("b108c", b108c)
                .put("b108d", b108d)
                .put("b108e", b108e)
                .put("b108f", b108f)
                .put("b108g", b108g)
                .put("b108h", b108h)
                .put("b108i", b108i)
                .put("b108j", b108j)
                .put("b108k", b108k)
                .put("b108l", b108l)
                .put("b108m", b108m)
                .put("b108n", b108n)
                .put("b108o", b108o)
                .put("b108p", b108p)
                .put("b108q", b108q)
                .put("b108r", b108r)
                .put("b108s", b108s)
                .put("b108t", b108t)
                .put("b108u", b108u)
                .put("b108v", b108v)
                .put("b108w", b108w);
        return json.toString();
    }

    public String sCtoString() throws JSONException {
        Log.d(TAG, "sCtoString: ");
        JSONObject json = new JSONObject();
        json.put("c101s", c101s)
                .put("c101m", c101m)
                .put("c102s", c102s)
                .put("c102m", c102m)
                .put("c103s", c103s)
                .put("c103m", c103m)
                .put("c104s", c104s)
                .put("c104m", c104m)
                .put("c105s", c105s)
                .put("c105m", c105m)
                .put("c106s", c106s)
                .put("c106m", c106m)
                .put("c107s", c107s)
                .put("c107m", c107m)
                .put("c108s", c108s)
                .put("c108m", c108m)
                .put("c109s", c109s)
                .put("c109m", c109m)
                .put("c110s", c110s)
                .put("c110m", c110m)
                .put("c111s", c111s)
                .put("c111m", c111m)
                .put("c112s", c112s)
                .put("c112m", c112m)
                .put("c113s", c113s)
                .put("c113m", c113m)
                .put("c114s", c114s)
                .put("c114m", c114m)
                .put("c115s", c115s)
                .put("c115m", c115m)
                .put("c116s", c116s)
                .put("c116m", c116m)
                .put("c117s", c117s)
                .put("c117m", c117m)
                .put("c118s", c118s)
                .put("c118m", c118m)
                .put("c119s", c119s)
                .put("c119m", c119m)
                .put("c10s", c120s)
                .put("c120m", c120m)
                .put("c121s", c121s)
                .put("c121m", c121m)
                .put("c122s", c122s)
                .put("c122m", c122m)
                .put("c123s", c123s)
                .put("c123m", c123m)
                .put("c124s", c124s)
                .put("c124m", c124m)
                .put("c125s", c125s)
                .put("c125m", c125m)
                .put("c126s", c126s)
                .put("c126m", c126m)
                .put("c127s", c127s)
                .put("c127m", c127m)
                .put("c128s", c128s)
                .put("c128m", c128m)
                .put("c129s", c129s)
                .put("c129m", c129m)
                .put("c130s", c130s)
                .put("c130m", c130m)
                .put("c131s", c131s)
                .put("c131m", c131m)
                .put("c132s", c132s)
                .put("c132m", c132m)
                .put("c133s", c133s)
                .put("c133m", c133m)
                .put("c134s", c134s)
                .put("c134m", c134m)
                .put("c135s", c135s)
                .put("c135m", c135m)
                .put("c136s", c136s)
                .put("c136m", c136m)
                .put("c137s", c137s)
                .put("c137m", c137m)
                .put("c138s", c138s)
                .put("c138m", c138m)
                .put("c139s", c139s)
                .put("c139m", c139m)
                .put("c140", c140)
                .put("c141", c141)
                .put("c14196x", c14196x);
        return json.toString();
    }

    public String sH1toString() throws JSONException {
        Log.d(TAG, "sH1toString: ");
        JSONObject json = new JSONObject();
        json.put("h101", h101)
                .put("h102", h102)
                .put("h103", h103)
                .put("h104a", h104a)
                .put("h104b", h104b)
                .put("h104c", h104c)
                .put("h104d", h104d)
                .put("h104e", h104e)
                .put("h104f", h104f);
        return json.toString();
    }

    public String sH2toString() throws JSONException {
        Log.d(TAG, "sH2toString: ");
        JSONObject json = new JSONObject();
        json.put("h201", h201)
                .put("h202", h202)
                .put("h203", h203)
                .put("h204a", h204a)
                .put("h204b", h204b)
                .put("h204c", h204c)
                .put("h204d", h204d)
                .put("h204e", h204e)
                .put("h204f", h204f)
                .put("h205", h205);
        return json.toString();
    }

    public String sH3toString() throws JSONException {
        Log.d(TAG, "sH3toString: ");
        JSONObject json = new JSONObject();
        json.put("h301", h301)
                .put("h302", h302)
                .put("h303", h303)
                .put("h304d", h304d)
                .put("h304m", h304m)
                .put("h304y", h304y)
                .put("h305", h305)
                .put("h306", h306)
                .put("h307", h307)
                .put("h308", h308)
                .put("h309", h309);
        return json.toString();
    }

    public String sABtoString() throws JSONException {
        Log.d(TAG, "sABtoString: ");
        JSONObject json = new JSONObject();
        json.put("ab101", ab101)
                .put("ab102", ab102)
                .put("ab103", ab103)
                .put("ab104", ab104)
                .put("ab104a", ab104a)
                .put("ab104b", ab104b)
                .put("ab104c", ab104c)
                .put("ab104d", ab104d)
                .put("ab10496", ab10496)
                .put("ab10496x", ab10496x)
                .put("ab105", ab105)
                .put("ab106", ab106)
                .put("ab107", ab107)
                .put("ab108", ab108)
                .put("ab108a", ab108a)
                .put("ab108b", ab108b)
                .put("ab108c", ab108c)
                .put("ab108d", ab108d)
                .put("ab108e", ab108e)
                .put("ab108f", ab108f)
                .put("ab108g", ab108g)
                .put("ab108h", ab108h)
                .put("ab108i", ab108i)
                .put("ab108j", ab108j)
                .put("ab108k", ab108k)
                .put("ab10896", ab10896)
                .put("ab10896x", ab10896x)
                .put("ab109", ab109)
                .put("ab10996x", ab10996x)
                .put("ab110", ab110)
                .put("ab110a", ab110a)
                .put("ab110b", ab110b)
                .put("ab110c", ab110c)
                .put("ab110d", ab110d)
                .put("ab110e", ab110e)
                .put("ab11096", ab11096)
                .put("ab11096x", ab11096x)
                .put("ab111", ab111)
                .put("ab112", ab112)
                .put("ab113", ab113)
                .put("ab113a", ab113a)
                .put("ab113b", ab113b)
                .put("ab113c", ab113c)
                .put("ab11398", ab11398)
                .put("ab11396", ab11396)
                .put("ab114", ab114)
                .put("ab115", ab115)
                .put("ab117", ab117)
                .put("ab118a", ab118a)
                .put("ab118b", ab118b)
                .put("ab118c", ab118c)
                .put("ab118d", ab118d)
                .put("ab118e", ab118e)
                .put("ab118f", ab118f)
                .put("ab118g", ab118g)
                .put("ab118h", ab118h)
                .put("ab118i", ab118i)
                .put("ab118j", ab118j)
                .put("ab118k", ab118k)
                .put("ab118l", ab118l)
                .put("ab118m", ab118m)
                .put("ab118n", ab118n)
                .put("ab118o", ab118o)
                .put("ab118p", ab118p)
                .put("ab118q", ab118q)
                .put("ab118r", ab118r)
                .put("ab118s", ab118s)
                .put("ab118t", ab118t)
                .put("ab118u", ab118u)
                .put("ab119", ab119);
        return json.toString();
    }

    public String sMtoString() throws JSONException {
        Log.d(TAG, "sMtoString: ");
        JSONObject json = new JSONObject();
        json.put("m101", m101)
                .put("m102", m102)
                .put("m103", m103)
                .put("m104", m104)
                .put("m105", m105)
                .put("m105a", m105a)
                .put("m105b", m105b)
                .put("m105c", m105c)
                .put("m105d", m105d)
                .put("m105e", m105e)
                .put("m105f", m105f)
                .put("m105g", m105g)
                .put("m105h", m105h)
                .put("m10596", m10596)
                .put("m10596x", m10596x)
                .put("m106", m106)
                .put("m106a", m106a)
                .put("m106b", m106b)
                .put("m106c", m106c)
                .put("m106d", m106d);
        return json.toString();
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();

        json.put(FormsTable.COLUMN_ID, this.id);
        json.put(FormsTable.COLUMN_UID, this.uid);
        json.put(FormsTable.COLUMN_CLUSTER, this.cluster);
        json.put(FormsTable.COLUMN_HHID, this.hhid);
        json.put(FormsTable.COLUMN_USERNAME, this.userName);
        json.put(FormsTable.COLUMN_SYSDATE, this.sysDate);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceId);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.deviceTag);
        json.put(FormsTable.COLUMN_ISTATUS, this.iStatus);
        //  json.put(FormsTable.COLUMN_SYNCED, this.synced);
        //  json.put(FormsTable.COLUMN_SYNCED_DATE, this.syncDate);

        // Household

        json.put(FormsTable.COLUMN_SA, new JSONObject(sAtoString()));
        json.put(FormsTable.COLUMN_SB, new JSONObject(sBtoString()));
        json.put(FormsTable.COLUMN_SC, new JSONObject(sCtoString()));
        json.put(FormsTable.COLUMN_SH1, new JSONObject(sH1toString()));
        json.put(FormsTable.COLUMN_SH2, new JSONObject(sH2toString()));
        json.put(FormsTable.COLUMN_SH3, new JSONObject(sH3toString()));
        json.put(FormsTable.COLUMN_SAB, new JSONObject(sABtoString()));
        json.put(FormsTable.COLUMN_SM, new JSONObject(sMtoString()));
        return json;
    }


}
