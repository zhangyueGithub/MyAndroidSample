/*
package com.example.seatrend.myapplication.JavaTest;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ScrollView;
import android.widget.Toast;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.DefautDialog;
import scxd.jcz.ajlw.android.Activity.Common.DefautDialog.OnClickListener;
import scxd.jcz.ajlw.android.Activity.Common.Docxxml;
import scxd.jcz.ajlw.android.Activity.Common.WebStatus;
import scxd.jcz.ajlw.android.common.MD_ListItem;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.InfoItem;
import scxd.jcz.ajlw.android.model.InfoItemChk;
import scxd.jcz.ajlw.android.model.InfoItemDate;
import scxd.jcz.ajlw.android.model.InfoItemEdt;
import scxd.jcz.ajlw.android.model.InfoItemSp;
import scxd.jcz.ajlw.android.model.InfoItemSpEdt;
import scxd.jcz.ajlw.android.model.ItemLayout;
import scxd.jcz.ajlw.android.model.Md_Car_TongYong;
import scxd.jcz.ajlw.android.model.Md_cartype;
import scxd.jcz.ajlw.android.model.Md_system;

public class CarLoginActivity extends BaseActivity
{
  private static final int ONLINE;
  public static int hp = 0;
  public static int s;
  private InfoItem WZItem;
  String alertMsg = "";
  String alertTitle = "";
  private InfoItem bsxs = null;
  private InfoItem cllxItem;
  private InfoItem clsslbItem;
  private InfoItem clxhItem;
  private InfoItem clyt1;
  private InfoItem csys;
  private InfoItem dws;
  private String from = "CarLoginActivity";
  private InfoItem gl;
  private InfoItem gs = null;
  private InfoItem gyfs = null;
  private Handler handler = new Handler();
  private InfoItem hdzk;
  Map<String, String> hm = null;
  private InfoItem hphmItem;
  private InfoItem hpzlItem;
  private boolean isRGWJ = false;
  private InfoItem jclbItem;
  private InfoItem jcxlb;
  private InfoItem jqfs = null;
  private InfoItem jylbzlfdjItem;
  private InfoItem jylbzllsjyItem;
  private InfoItem lcbds;
  private ItemLayout loginModel;
  private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousIntent.getAction().equals("ATION_CHECK")) && (CarLoginActivity.this.zxzxjxs.getData().equals("0")))
      {
        if (CarLoginActivity.this.requestMap != null)
          CarLoginActivity.this.requestMap = null;
        if (CarLoginActivity.this.requesJYXMMap != null)
          CarLoginActivity.this.requesJYXMMap = null;
        if (!CarLoginActivity.this.vinItem.getData().equals(""))
        {
          if (!Md_system.getSfhj().equals("��"))
            break label585;
          if (Md_system.getSfgxjyxm().equals("��"))
            CarLoginActivity.this.loginModel.setItemsDataNull(3);
        }
      }
      while (true)
      {
        CarLoginActivity.this.requestMap = new HashMap();
        CarLoginActivity.this.requesJYXMMap = CarLoginActivity.this.loginModel.getDataNodeAndValue();
        CarLoginActivity.this.requesJYXMMap.put("jylsh", "");
        if ((CarLoginActivity.this.jclbItem.getData().equals("01")) || (CarLoginActivity.this.jclbItem.getData().equals("00")))
          CarLoginActivity.this.requesJYXMMap.put("jylbzl", "");
        CarLoginActivity.this.requesJYXMMap.put("jyjgbh", Md_system.getDzkey());
        CarLoginActivity.this.requesJYXMMap.put("dly", Md_Car_Temp.getTempCar().userxingming);
        if (!Md_system.getSfgxjyxm().equals("��"))
          CarLoginActivity.this.requesJYXMMap.put("jyxm", "F1");
        CarLoginActivity.this.requesJYXMMap.put("ycy", "");
        CarLoginActivity.this.requesJYXMMap.put("wjy", "");
        CarLoginActivity.this.requesJYXMMap.put("bhgx", "");
        CarLoginActivity.this.requesJYXMMap.put("jycs", "1");
        CarLoginActivity.this.requesJYXMMap.put("dtjyy", "");
        CarLoginActivity.this.requesJYXMMap.put("dpjyy", "");
        CarLoginActivity.this.requesJYXMMap.put("ycysfzh", "");
        CarLoginActivity.this.requesJYXMMap.put("wjysfzh", "");
        CarLoginActivity.this.requesJYXMMap.put("dtjyysfzh", "");
        CarLoginActivity.this.requesJYXMMap.put("ccdlsj", "");
        CarLoginActivity.this.requesJYXMMap.put("dlsj", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        CarLoginActivity.this.requesJYXMMap.put("dpjyysfzh", "");
        CarLoginActivity.this.requesJYXMMap.put("jyrq", "");
        CarLoginActivity.this.requestMap.put("vehispara", CarLoginActivity.this.requesJYXMMap);
        CarLoginActivity.this.request("18Q46", CarLoginActivity.this.requestMap, 0, new String[] { "2" });
        Toast.makeText(CarLoginActivity.this, "��ǰ������ʽΪ�������ܲ��ܹ�ѡ����", 0).show();
        return;
        label585: if (Md_system.getSfgxjyxm().equals("��"))
          CarLoginActivity.this.loginModel.setItemsDataNull(2);
      }
    }
  };
  private InfoItem obddsfzc = null;
  ProgressDialog p_dialog;
  private CheckBox projectAJ;
  private CheckBox projectHJ;
  InfoItem qdxs = null;
  private Button queryBtn;
  private int queryTime = 0;
  InfoItem qzdz = null;
  private InfoItem qzs;
  Map<String, Object> requesCarLogintMap = null;
  Map<String, Object> requesJYXMMap = null;
  Map<String, Object> requestMap = null;
  Map<String, Object> requestMapNode = null;
  private InfoItem sfqszxzItem;
  SharedPreferences sp;
  private String sp_hphm = "";
  private String sp_spinnerhphm = "";
  private Button submitBtn;
  private InfoItem syr;
  private InfoItem syxzItem;
  private Runnable task = new Runnable()
  {
    public void run()
    {
      CarLoginActivity.this.handler.postDelayed(this, 1000L);
      CarLoginActivity.access$1510(CarLoginActivity.this);
      if (CarLoginActivity.this.queryTime == 0)
        CarLoginActivity.this.stop();
    }
  };
  private InfoItem vinItem;
  InfoItem ygddtz;
  private InfoItem zczw;
  private InfoItem zxzxjxs;

  private InfoItem clsslbmoth(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.clsslbItem = new InfoItemSp(this, "�����������#", "clsslb", MD_ListItem.Get_clsslb(), new OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          if (CarLoginActivity.this.requestMap != null)
            CarLoginActivity.this.requestMap = null;
          if (CarLoginActivity.this.requesJYXMMap != null)
            CarLoginActivity.this.requesJYXMMap = null;
          if (!CarLoginActivity.this.vinItem.getData().equals(""))
          {
            if (!Md_system.getSfhj().equals("��"))
              break label542;
            if (Md_system.getSfgxjyxm().equals("��"))
              CarLoginActivity.this.loginModel.setItemsDataNull(3);
          }
          while (true)
          {
            CarLoginActivity.this.requestMap = new HashMap();
            CarLoginActivity.this.requesJYXMMap = CarLoginActivity.this.loginModel.getDataNodeAndValue();
            CarLoginActivity.this.requesJYXMMap.put("jylsh", "");
            if ((CarLoginActivity.this.jclbItem.getData().equals("01")) || (CarLoginActivity.this.jclbItem.getData().equals("00")))
              CarLoginActivity.this.requesJYXMMap.put("jylbzl", "");
            CarLoginActivity.this.requesJYXMMap.put("jyjgbh", Md_system.getDzkey());
            CarLoginActivity.this.requesJYXMMap.put("dly", Md_Car_Temp.getTempCar().userxingming);
            if (!Md_system.getSfgxjyxm().equals("��"))
              CarLoginActivity.this.requesJYXMMap.put("jyxm", "F1");
            CarLoginActivity.this.requesJYXMMap.put("ycy", "");
            CarLoginActivity.this.requesJYXMMap.put("wjy", "");
            CarLoginActivity.this.requesJYXMMap.put("bhgx", "");
            CarLoginActivity.this.requesJYXMMap.put("jycs", "1");
            CarLoginActivity.this.requesJYXMMap.put("dtjyy", "");
            CarLoginActivity.this.requesJYXMMap.put("dpjyy", "");
            CarLoginActivity.this.requesJYXMMap.put("ycysfzh", "");
            CarLoginActivity.this.requesJYXMMap.put("wjysfzh", "");
            CarLoginActivity.this.requesJYXMMap.put("dtjyysfzh", "");
            CarLoginActivity.this.requesJYXMMap.put("ccdlsj", "");
            CarLoginActivity.this.requesJYXMMap.put("dlsj", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            CarLoginActivity.this.requesJYXMMap.put("dpjyysfzh", "");
            CarLoginActivity.this.requesJYXMMap.put("jyrq", "");
            CarLoginActivity.this.requestMap.put("vehispara", CarLoginActivity.this.requesJYXMMap);
            CarLoginActivity.this.request("18Q46", CarLoginActivity.this.requestMap, 0, new String[] { "2" });
            return;
            label542: if (Md_system.getSfgxjyxm().equals("��"))
              CarLoginActivity.this.loginModel.setItemsDataNull(2);
          }
        }

        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
        {
        }
      });
      return this.clsslbItem;
    }
    this.clsslbItem = new InfoItemSp(this, "�����������#", "clsslb", MD_ListItem.Get_clsslb(), null);
    return this.clsslbItem;
  }

  private void getJYXM()
  {
    if (this.requestMap != null)
      this.requestMap = null;
    if (this.requesJYXMMap != null)
      this.requesJYXMMap = null;
    if (!this.vinItem.getData().equals(""))
    {
      if (!Md_system.getSfhj().equals("��"))
        break label495;
      if (Md_system.getSfgxjyxm().equals("��"))
      {
        if (!Md_system.getSfzj().equals("��"))
          break label484;
        this.loginModel.setItemsDataNull(4);
      }
    }
    while (true)
    {
      this.requestMap = new HashMap();
      this.requesJYXMMap = this.loginModel.getDataNodeAndValue();
      this.requesJYXMMap.put("jylsh", "");
      if ((this.jclbItem.getData().equals("01")) || (this.jclbItem.getData().equals("00")))
        this.requesJYXMMap.put("jylbzl", "");
      this.requesJYXMMap.put("jyjgbh", Md_system.getDzkey());
      this.requesJYXMMap.put("dly", Md_Car_Temp.getTempCar().userxingming);
      if (!Md_system.getSfgxjyxm().equals("��"))
        this.requesJYXMMap.put("jyxm", "F1");
      this.requesJYXMMap.put("ycy", "");
      this.requesJYXMMap.put("wjy", "");
      this.requesJYXMMap.put("bhgx", "");
      this.requesJYXMMap.put("jycs", "1");
      this.requesJYXMMap.put("dtjyy", "");
      this.requesJYXMMap.put("dpjyy", "");
      this.requesJYXMMap.put("ycysfzh", "");
      this.requesJYXMMap.put("wjysfzh", "");
      this.requesJYXMMap.put("dtjyysfzh", "");
      this.requesJYXMMap.put("ccdlsj", "");
      this.requesJYXMMap.put("dlsj", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
      this.requesJYXMMap.put("dpjyysfzh", "");
      this.requesJYXMMap.put("jyrq", "");
      this.requestMap.put("vehispara", this.requesJYXMMap);
      request("18Q46", this.requestMap, 0, new String[] { "2" });
      return;
      label484: this.loginModel.setItemsDataNull(3);
      continue;
      label495: if (Md_system.getSfgxjyxm().equals("��"))
        if (Md_system.getSfzj().equals("��"))
          this.loginModel.setItemsDataNull(3);
        else
          this.loginModel.setItemsDataNull(2);
    }
  }

  private void getwjqx()
  {
    label166: for (int i = 0; ; i++)
    {
      try
      {
        if (Md_Car_Temp.getTempCar().acl.equals(""));
        String[] arrayOfString;
        for (Object localObject = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "14" }; ; localObject = arrayOfString)
        {
          int j = localObject.length;
          if (i >= j)
            break;
          if (!"3".equals(localObject[i]))
            break label166;
          this.isRGWJ = true;
          break label166;
          arrayOfString = Md_Car_Temp.getTempCar().acl.split(",");
        }
      }
      catch (Exception localException)
      {
      }
      return;
    }
  }

  private void initItems(int paramInt)
  {
    this.clyt1 = null;
    this.hphmItem = new InfoItemSpEdt(this, "���ƺ���", "hphm", MD_ListItem.Get_sf(), 1, this.sp_hphm, this.sp_spinnerhphm);
    this.clxhItem = new InfoItemEdt(this, "�����ͺ�*", null, "clxh", 1, null, false);
    this.vinItem = new InfoItemEdt(this, "����VIN��*", null, "clsbdh", 1, null, false);
    this.cllxItem = new InfoItemEdt(this, "��������", null, "cllx", 1, null, false);
    this.syxzItem = new InfoItemSp(this, "ʹ������", "syxz", MD_ListItem.Get_syxz(), null);
    this.jylbzlfdjItem = new InfoItemSp(this, "����������#", "jylbzl", MD_ListItem.Get_jylbzlfdj(), new OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if ("0405".equals(((Md_cartype)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt)).getName()))
          CarLoginActivity.this.clyt1.setData("J2");
      }

      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
      {
      }
    });
    this.jylbzllsjyItem = new InfoItemSp(this, "����������#", "jylbzl", MD_ListItem.Get_jylbzllsjy(), null);
    this.jclbItem = new InfoItemSp(this, "������*", "jylb", MD_ListItem.Get_jylb(), new OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        String str = ((Md_cartype)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt)).getName();
        if (str.equals("04"))
        {
          CarLoginActivity.this.jylbzlfdjItem.setVisibility(0);
          CarLoginActivity.this.jylbzllsjyItem.setVisibility(8);
          return;
        }
        if (str.equals("02"))
        {
          CarLoginActivity.this.jylbzlfdjItem.setVisibility(8);
          CarLoginActivity.this.jylbzllsjyItem.setVisibility(0);
          return;
        }
        CarLoginActivity.this.jylbzlfdjItem.setVisibility(8);
        CarLoginActivity.this.jylbzllsjyItem.setVisibility(8);
      }

      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
      {
      }
    });
    this.sfqszxzItem = new InfoItemSp(this, "�Ƿ�˫ת����#", "sfqszxz", MD_ListItem.Get_sfsfqszxz(), null);
    this.WZItem = new InfoItemEdt(this, "Υ����Ϣ", null, "zt", 1, null, true);
    this.hpzlItem = new InfoItemSp(this, "��������", "hpzl", MD_ListItem.Get_hpzl(), new OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (Md_Car_Temp.FJ_HashMap == null)
          CarLoginActivity.this.loginModel.initEdtNull();
        if ("15".equals(((Md_cartype)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt)).getName()))
        {
          CarLoginActivity.this.qdxs.setData("0");
          CarLoginActivity.this.qzdz.setData("00");
          CarLoginActivity.this.ygddtz.setData("");
        }
        HashMap localHashMap;
        while (true)
        {
          if (Md_Car_Temp.getTempCar().isFromGGBD)
            try
            {
              localHashMap = new HashMap();
              Bundle localBundle = CarLoginActivity.this.getIntent().getBundleExtra("map");
              Iterator localIterator = localBundle.keySet().iterator();
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                localHashMap.put(str, localBundle.getString(str));
              }
            }
            catch (Exception localException)
            {
            }
          return;
          if (Md_Car_Temp.FJ_HashMap != null)
          {
            CarLoginActivity.this.qdxs.setData((String)Md_Car_Temp.FJ_HashMap.get("qdxs"));
            CarLoginActivity.this.qzdz.setData((String)Md_Car_Temp.FJ_HashMap.get("qzdz"));
            CarLoginActivity.this.ygddtz.setData((String)Md_Car_Temp.FJ_HashMap.get("ygddtz"));
          }
          else
          {
            CarLoginActivity.this.qdxs.setData("-1");
            CarLoginActivity.this.qzdz.setData("-1");
            CarLoginActivity.this.ygddtz.setData("-1");
          }
        }
        CarLoginActivity.this.loginModel.setItemsData(localHashMap);
      }

      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
      {
      }
    });
    this.syr = new InfoItemEdt(this, "������������", null, "syr", 1, null, true);
    InfoItemSp localInfoItemSp1 = new InfoItemSp(this, "����ߺ�", "jcxdh", MD_ListItem.Get_xh(), null);
    this.csys = new InfoItemEdt(this, "������ɫ", null, "csys", 1, null, true);
    this.zxzxjxs = new InfoItemSp(this, "������ʽ#", "zxzxjxs", MD_ListItem.Get_zxzxjxs(), null);
    this.qdxs = new InfoItemSp(this, "������#", "qdxs", MD_ListItem.Get_qdz(), null);
    this.zczw = new InfoItemSp(this, "��ɲ��#", "zczw", MD_ListItem.Get_qdz(), null);
    InfoItemSp localInfoItemSp2 = new InfoItemSp(this, "����*", "zs", getResources().getStringArray(2131034137), null);
    this.jcxlb = new InfoItemSp(this, "��������#", "jcxlb", MD_ListItem.Get_Jcxlb(), null);
    this.qzdz = new InfoItemSp(this, "ǰ�յ���#", "qzdz", MD_ListItem.Get_dz(), null);
    this.ygddtz = new InfoItemSp(this, "Զ�ⵥ������#", "ygddtz", MD_ListItem.Get_ygddtz(), null);
    InfoItemDate localInfoItemDate1 = new InfoItemDate(this, "ccrq", "��������*");
    InfoItemEdt localInfoItemEdt1 = new InfoItemEdt(this, "����Ʒ��*", null, "clpp1", 1, null, false);
    InfoItemEdt localInfoItemEdt2 = new InfoItemEdt(this, "��������*", " mm", "cwkk", 8194, null, false);
    InfoItemEdt localInfoItemEdt3 = new InfoItemEdt(this, "��������*", " mm", "cwkc", 8194, null, false);
    InfoItemEdt localInfoItemEdt4 = new InfoItemEdt(this, "��������*", " mm", "cwkg", 8194, null, false);
    InfoItemEdt localInfoItemEdt5 = new InfoItemEdt(this, "�����ڲ�����", " mm", "hxnbcd", 8194, null, true);
    InfoItemEdt localInfoItemEdt6 = new InfoItemEdt(this, "�����ڲ����", " mm", "hxnbkd", 8194, null, true);
    InfoItemEdt localInfoItemEdt7 = new InfoItemEdt(this, "�����ڲ��߶�", " mm", "hxnbgd", 8194, null, true);
    InfoItemEdt localInfoItemEdt8 = new InfoItemEdt(this, "������*", " kg", "zzl", 8194, "^[0-9\\.]{1,5}$", false);
    InfoItemEdt localInfoItemEdt9 = new InfoItemEdt(this, "��������*", " kg", "0", "zbzl", 8194, "^[0-9\\.]{1,5}$", false);
    InfoItemEdt localInfoItemEdt10 = new InfoItemEdt(this, "��̥���", null, "ltgg", 1, null, true);
    this.lcbds = new InfoItemEdt(this, "��̱���#", "km", "lcbds", 2, "^[0-9]{1,9}$", false);
    this.qzs = new InfoItemEdt(this, "ǰ����#", null, "qzs", 1, "^[0-9]{1,9}$", false);
    InfoItemEdt localInfoItemEdt11 = new InfoItemEdt(this, "��֤����*", null, "fzjg", 1, null, false);
    InfoItemEdt localInfoItemEdt12 = new InfoItemEdt(this, "��¼Ա(���֤��)#", null, "dlysfzh", 1, null, false);
    boolean bool1 = Md_system.getSfgxjyxm().equals("��");
    InfoItemChk localInfoItemChk1 = null;
    InfoItemChk localInfoItemChk2 = null;
    InfoItemChk localInfoItemChk3 = null;
    InfoItemChk localInfoItemChk4 = null;
    InfoItemChk localInfoItemChk5 = null;
    InfoItemChk localInfoItemChk6 = null;
    InfoItemChk localInfoItemChk7 = null;
    InfoItemChk localInfoItemChk8 = null;
    InfoItemChk localInfoItemChk9 = null;
    InfoItemChk localInfoItemChk10 = null;
    InfoItemChk localInfoItemChk11 = null;
    InfoItemChk localInfoItemChk12 = null;
    InfoItemChk localInfoItemChk13 = null;
    InfoItemChk localInfoItemChk14 = null;
    InfoItemChk localInfoItemChk15 = null;
    InfoItemChk localInfoItemChk16 = null;
    InfoItemChk localInfoItemChk17 = null;
    InfoItemChk localInfoItemChk18 = null;
    InfoItemChk localInfoItemChk19 = null;
    InfoItemChk localInfoItemChk20 = null;
    InfoItemChk localInfoItemChk21 = null;
    InfoItemChk localInfoItemChk22 = null;
    InfoItemChk localInfoItemChk23 = null;
    InfoItemChk localInfoItemChk24 = null;
    InfoItemChk localInfoItemChk25 = null;
    if (bool1)
    {
      localInfoItemChk20 = new InfoItemChk(this, "�����ߴ����", "M1", false);
      localInfoItemChk11 = new InfoItemChk(this, "������ۼ���", "F1", false);
      localInfoItemChk9 = new InfoItemChk(this, "���̼���", "C1", false);
      localInfoItemChk10 = new InfoItemChk(this, "��̬���̼���", "DC", false);
      localInfoItemChk3 = new InfoItemChk(this, "һ���ƶ�", "B1", false);
      localInfoItemChk4 = new InfoItemChk(this, "�����ƶ�", "B2", false);
      localInfoItemChk5 = new InfoItemChk(this, "�����ƶ�", "B3", false);
      localInfoItemChk6 = new InfoItemChk(this, "�����ƶ�", "B4", false);
      localInfoItemChk7 = new InfoItemChk(this, "�����ƶ�", "B5", false);
      localInfoItemChk8 = new InfoItemChk(this, "�����ƶ�", "B6", false);
      localInfoItemChk2 = new InfoItemChk(this, "פ���ƶ�", "B0", false);
      localInfoItemChk12 = new InfoItemChk(this, "����ƻ�����ֻ����������", "H1", false);
      localInfoItemChk13 = new InfoItemChk(this, "���ڵ�", "H2", false);
      localInfoItemChk14 = new InfoItemChk(this, "���ڵ�", "H3", false);
      localInfoItemChk15 = new InfoItemChk(this, "����ƻ�����ֻ��������ҵ�", "H4", false);
      localInfoItemChk24 = new InfoItemChk(this, "���ٱ�", "S1", false);
      localInfoItemChk1 = new InfoItemChk(this, "�໬���������������ƫ", "A1", false);
      localInfoItemChk21 = new InfoItemChk(this, "·���ƶ�", "R1", false);
      localInfoItemChk22 = new InfoItemChk(this, "·���µ�פ��", "R2", false);
      localInfoItemChk23 = new InfoItemChk(this, "·�Գ��ٱ�", "R3", false);
      localInfoItemChk25 = new InfoItemChk(this, "��������", "Z1", false);
      localInfoItemChk16 = new InfoItemChk(this, "һ������ƶ�", "L1", false);
      localInfoItemChk17 = new InfoItemChk(this, "��������ƶ�", "L2", false);
      localInfoItemChk18 = new InfoItemChk(this, "��������ƶ�", "L3", false);
      localInfoItemChk19 = new InfoItemChk(this, "��������ƶ�", "L4", false);
    }
    boolean bool2 = Md_system.getSfzj().equals("��");
    InfoItemChk localInfoItemChk26 = null;
    InfoItemChk localInfoItemChk27 = null;
    InfoItemChk localInfoItemChk28 = null;
    if (bool2)
    {
      localInfoItemChk27 = new InfoItemChk(this, "�ȼ�����", "grade", false);
      localInfoItemChk26 = new InfoItemChk(this, "����ά��", "ejwh", false);
      localInfoItemChk28 = new InfoItemChk(this, "���޿���", "repair", false);
    }
    InfoItemSp localInfoItemSp3;
    InfoItemSp localInfoItemSp4;
    InfoItemSp localInfoItemSp5;
    InfoItemSp localInfoItemSp6;
    InfoItemSp localInfoItemSp7;
    InfoItemSp localInfoItemSp8;
    InfoItemSp localInfoItemSp9;
    InfoItemSp localInfoItemSp10;
    InfoItemEdt localInfoItemEdt13;
    InfoItemEdt localInfoItemEdt14;
    InfoItemEdt localInfoItemEdt15;
    if (Md_system.getSfhj().equals("��"))
    {
      localInfoItemSp3 = new InfoItemSp(this, "������;", "clyt", MD_ListItem.Get_clyt(), null);
      this.obddsfzc = new InfoItemSp(this, "ODB���Ƿ�����", "obddsfzc", MD_ListItem.Get_pdsf(), null);
      localInfoItemSp4 = new InfoItemSp(this, "������־", "hbbz", MD_ListItem.Get_hbbz(), null);
      localInfoItemSp5 = new InfoItemSp(this, "ȼ�����", "rllb", MD_ListItem.Get_rylb(), null);
      this.gyfs = new InfoItemSp(this, "���ͷ�ʽ#", "gyfs", MD_ListItem.Get_gyfshj(), null);
      localInfoItemSp6 = new InfoItemSp(this, "�ŷű�׼", "pfbz", MD_ListItem.Get_pfbz(), null);
      this.jqfs = new InfoItemSp(this, "������ʽ#", "jqfs", MD_ListItem.Get_hjjqfs(), null);
      localInfoItemSp7 = new InfoItemSp(this, "��������׼", "hbjcbz", MD_ListItem.Get_hbjcbz(), null);
      localInfoItemSp8 = new InfoItemSp(this, "�Ƿ����", "sfgz", MD_ListItem.Get_sfgz(), null);
      List localList = MD_ListItem.Get_pdsf();
      OnItemSelectedListener local10 = new OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          if (paramAnonymousInt == 1)
          {
            CarLoginActivity.this.obddsfzc.setData("��");
            return;
          }
          CarLoginActivity.this.obddsfzc.setData("��");
        }

        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
        {
        }
      };
      localInfoItemSp9 = new InfoItemSp(this, "�Ƿ���ODB", "sfyobd", localList, local10);
      this.bsxs = new InfoItemSp(this, "������ʽ#", "bsxs", MD_ListItem.Get_bsxs(), null);
      localInfoItemSp10 = new InfoItemSp(this, "������", "bsx", MD_ListItem.Get_bsx(), null);
      localInfoItemEdt13 = new InfoItemEdt(this, "ODB������", null, "obdgzm", 1, null, true);
      localInfoItemEdt14 = new InfoItemEdt(this, "�������", null, "hbbh", 8194, null, true);
      this.gs = new InfoItemEdt(this, "������#", "��", "qgs", 8194, null, false);
      this.dws = new InfoItemEdt(this, "��λ��#", "��λ", "dws", 2, "^[0-9]{1,9}$", false);
      localInfoItemEdt15 = new InfoItemEdt(this, "ת��", null, "zs", 8194, null, true);
    }
    for (InfoItemEdt localInfoItemEdt16 = new InfoItemEdt(this, "����", " ML", "pl", 8194, null, true); ; localInfoItemEdt16 = null)
    {
      this.gl = new InfoItemEdt(this, "����", " KW", "gl", 8194, null, true);
      InfoItemSp localInfoItemSp11 = new InfoItemSp(this, "ȼ������#", "rlzl", MD_ListItem.Get_rlzl(), null);
      this.hdzk = new InfoItemEdt(this, "�˶��ؿ�����#", " ��", "hdzk", 1, "^[0-9]{1,5}$", true);
      InfoItemSp localInfoItemSp12 = new InfoItemSp(this, "������", "zzs", getResources().getStringArray(2131034137), null);
      InfoItemSp localInfoItemSp13 = new InfoItemSp(this, "�ƶ���Դ", "zzly", MD_ListItem.Get_zzly(), null);
      InfoItemEdt localInfoItemEdt17 = new InfoItemEdt(this, "���������", null, "xh", 1, null, true);
      this.clyt1 = new InfoItemSp(this, "������;", "clyt", MD_ListItem.Get_clyt1(), null);
      InfoItemEdt localInfoItemEdt18 = new InfoItemEdt(this, "�ͼ��ˣ�������", null, "sjr", 1, null, true);
      InfoItemEdt localInfoItemEdt19 = new InfoItemEdt(this, "�ͼ������֤��", null, "sjrsfzh", 1, null, true);
      InfoItemSp localInfoItemSp14 = new InfoItemSp(this, "��;����", "ytsx", MD_ListItem.Get_ytsx(), null);
      InfoItemEdt localInfoItemEdt20 = new InfoItemEdt(this, "��������", null, "fdjh", 1, null, true);
      InfoItemEdt localInfoItemEdt21 = new InfoItemEdt(this, "����ϸ��־", null, "jyhgbzbh", 1, null, true);
      InfoItemEdt localInfoItemEdt22 = new InfoItemEdt(this, "�˶�������", "  kg ", "hdzzl", 8194, "^[0-9\\.]{1,6}$", true);
      InfoItemEdt localInfoItemEdt23 = new InfoItemEdt(this, "��൥λ", " mm", "zj", 8194, null, true);
      InfoItemEdt localInfoItemEdt24 = new InfoItemEdt(this, "ǰ�־൥λ", " mm", "qlj", 8194, null, true);
      InfoItemEdt localInfoItemEdt25 = new InfoItemEdt(this, "���־൥λ", " mm", "hlj", 8194, null, true);
      InfoItemDate localInfoItemDate2 = new InfoItemDate(this, "ccdjrq", "���εǼ�����");
      InfoItemDate localInfoItemDate3 = new InfoItemDate(this, "yxqz", "������Ч��ֹ");
      InfoItemDate localInfoItemDate4 = new InfoItemDate(this, "bxzzrq", "������ֹ����");
      InfoItemEdt localInfoItemEdt26 = new InfoItemEdt(this, "�ְ嵯��Ƭ��", " Ƭ", "gbthps", 8194, null, true);
      InfoItemEdt localInfoItemEdt27 = new InfoItemEdt(this, "��̥��", " ��", "lts", 8194, null, true);
      InfoItemEdt localInfoItemEdt28 = new InfoItemEdt(this, "������", null, "glbm", 1, null, true);
      InfoItemEdt localInfoItemEdt29 = new InfoItemEdt(this, "�����", null, "zzg", 1, null, true);
      InfoItemEdt localInfoItemEdt30 = new InfoItemEdt(this, "�������ͺ�", null, "fdjxh", 1, null, true);
      InfoItemEdt localInfoItemEdt31 = new InfoItemEdt(this, "����/����", null, "gcjk", 1, null, true);
      InfoItemEdt localInfoItemEdt32 = new InfoItemEdt(this, "���֤������", null, "sfzmhm", 1, null, true);
      InfoItemEdt localInfoItemEdt33 = new InfoItemEdt(this, "����������", null, "hbdbqk", 1, null, true);
      InfoItemEdt localInfoItemEdt34 = new InfoItemEdt(this, "��ʻ֤֤о���", null, "xszbh", 1, null, true);
      InfoItemEdt localInfoItemEdt35 = new InfoItemEdt(this, "ǰ���ؿ�����", " ��", "qpzk", 8194, "^[0-9]{1,5}$", true);
      InfoItemEdt localInfoItemEdt36 = new InfoItemEdt(this, "�����ؿ�����", " ��", "hpzk", 8194, "^[0-9]{1,5}$", true);
      InfoItemEdt localInfoItemEdt37 = new InfoItemEdt(this, "���֤������", null, "sfzmmc", 1, null, true);
      InfoItemEdt localInfoItemEdt38 = new InfoItemEdt(this, "Ӣ��Ʒ��", null, "clpp2", 1, null, true);
      InfoItemEdt localInfoItemEdt39 = new InfoItemEdt(this, "׼ǣ��������", " kg", "zqyzl", 8194, null, true);
      InfoItemEdt localInfoItemEdt40 = new InfoItemEdt(this, "���쳧����", null, "zzcmc", 1, null, true);
      InfoItemEdt localInfoItemEdt41 = new InfoItemEdt(this, "ת����ʽ", null, "zxxs", 1, null, true);
      InfoItemDate localInfoItemDate5 = new InfoItemDate(this, "djrq", "�����������");
      InfoItemDate localInfoItemDate6 = new InfoItemDate(this, "qzbfqz", "ǿ�Ʊ�����ֹ");
      InfoItemSp localInfoItemSp15 = new InfoItemSp(this, "��Ѻ���", "dybj", MD_ListItem.Get_dybj(), null);
      if (Md_system.getSfhj().equals("��"))
      {
        if (Md_system.getSfgxjyxm().equals("��"))
        {
          if (Md_system.getSfzj().equals("��"))
          {
            this.loginModel.initItemBars(new String[] { "�ۼ������Ŀ", "����������Ϣ��", "����������Ϣһ", "���������Ϣ", "���������Ŀ", "������¼��Ϣ" });
            this.loginModel.addItem(5, this.jclbItem);
            this.loginModel.addItem(5, this.jylbzlfdjItem);
            this.loginModel.addItem(5, this.jylbzllsjyItem);
            this.jylbzlfdjItem.setVisibility(8);
            this.jylbzllsjyItem.setVisibility(8);
            this.loginModel.addItem(5, this.hphmItem);
            this.loginModel.addItem(5, this.hpzlItem);
            this.loginModel.addItem(5, this.vinItem);
            this.loginModel.addItem(5, this.clxhItem);
            this.loginModel.addItem(5, clsslbmoth(true));
            this.loginModel.addItem(5, this.cllxItem);
            this.loginModel.addItem(5, this.syxzItem);
            this.loginModel.addItem(5, this.syr);
            this.loginModel.addItem(5, localInfoItemSp1);
            this.loginModel.addItem(5, this.csys);
            this.loginModel.addItem(5, this.zxzxjxs);
            this.loginModel.addItem(5, this.qdxs);
            this.loginModel.addItem(5, this.zczw);
            this.loginModel.addItem(5, localInfoItemSp2);
            this.loginModel.addItem(5, this.sfqszxzItem);
            this.loginModel.addItem(5, this.jcxlb);
            this.loginModel.addItem(5, this.qzdz);
            this.loginModel.addItem(5, this.ygddtz);
            this.loginModel.addItem(5, localInfoItemDate1);
            this.loginModel.addItem(5, localInfoItemEdt1);
            this.loginModel.addItem(5, localInfoItemEdt2);
            this.loginModel.addItem(5, localInfoItemEdt3);
            this.loginModel.addItem(5, localInfoItemEdt4);
            this.loginModel.addItem(5, localInfoItemEdt5);
            this.loginModel.addItem(5, localInfoItemEdt6);
            this.loginModel.addItem(5, localInfoItemEdt7);
            this.loginModel.addItem(5, localInfoItemEdt16);
            this.loginModel.addItem(5, localInfoItemEdt30);
            this.loginModel.addItem(5, localInfoItemEdt8);
            this.loginModel.addItem(5, localInfoItemEdt9);
            this.loginModel.addItem(5, localInfoItemEdt10);
            this.loginModel.addItem(5, this.lcbds);
            this.loginModel.addItem(5, this.qzs);
            this.loginModel.addItem(5, localInfoItemEdt11);
            this.loginModel.addItem(5, localInfoItemEdt12);
            this.loginModel.addItem(5, this.WZItem);
            this.loginModel.addItem(5, this.jqfs);
            this.loginModel.addItem(5, localInfoItemSp11);
            this.loginModel.addItem(5, this.gs);
            this.loginModel.addItem(5, this.dws);
            this.loginModel.addItem(5, this.bsxs);
            this.loginModel.addItem(5, this.gyfs);
            this.loginModel.addItem(5, this.hdzk);
            this.loginModel.addItem(4, localInfoItemChk20);
            this.loginModel.addItem(4, localInfoItemChk11);
            this.loginModel.addItem(4, localInfoItemChk9);
            this.loginModel.addItem(4, localInfoItemChk10);
            this.loginModel.addItem(4, localInfoItemChk3);
            this.loginModel.addItem(4, localInfoItemChk4);
            this.loginModel.addItem(4, localInfoItemChk5);
            this.loginModel.addItem(4, localInfoItemChk6);
            this.loginModel.addItem(4, localInfoItemChk7);
            this.loginModel.addItem(4, localInfoItemChk8);
            this.loginModel.addItem(4, localInfoItemChk2);
            this.loginModel.addItem(4, localInfoItemChk12);
            this.loginModel.addItem(4, localInfoItemChk13);
            this.loginModel.addItem(4, localInfoItemChk14);
            this.loginModel.addItem(4, localInfoItemChk15);
            this.loginModel.addItem(4, localInfoItemChk24);
            this.loginModel.addItem(4, localInfoItemChk1);
            this.loginModel.addItem(4, localInfoItemChk21);
            this.loginModel.addItem(4, localInfoItemChk22);
            this.loginModel.addItem(4, localInfoItemChk23);
            this.loginModel.addItem(4, localInfoItemChk25);
            this.loginModel.addItem(4, localInfoItemChk16);
            this.loginModel.addItem(4, localInfoItemChk17);
            this.loginModel.addItem(4, localInfoItemChk18);
            this.loginModel.addItem(4, localInfoItemChk19);
            this.loginModel.addItem(3, localInfoItemSp3);
            this.loginModel.addItem(3, localInfoItemSp4);
            this.loginModel.addItem(3, localInfoItemSp5);
            this.loginModel.addItem(3, localInfoItemSp6);
            this.loginModel.addItem(3, localInfoItemSp7);
            this.loginModel.addItem(3, localInfoItemSp8);
            this.loginModel.addItem(3, localInfoItemSp9);
            this.loginModel.addItem(3, this.obddsfzc);
            this.loginModel.addItem(3, localInfoItemSp10);
            this.loginModel.addItem(3, localInfoItemEdt13);
            this.loginModel.addItem(3, localInfoItemEdt14);
            this.loginModel.addItem(3, localInfoItemEdt15);
            this.loginModel.addItem(2, this.gl);
            this.loginModel.addItem(2, localInfoItemSp12);
            this.loginModel.addItem(2, localInfoItemSp13);
            this.loginModel.addItem(2, localInfoItemEdt17);
            this.loginModel.addItem(2, this.clyt1);
            this.loginModel.addItem(2, localInfoItemEdt18);
            this.loginModel.addItem(2, localInfoItemEdt19);
            this.loginModel.addItem(2, localInfoItemSp14);
            this.loginModel.addItem(2, localInfoItemEdt20);
            this.loginModel.addItem(2, localInfoItemEdt21);
            this.loginModel.addItem(2, localInfoItemEdt22);
            this.loginModel.addItem(2, localInfoItemEdt23);
            this.loginModel.addItem(2, localInfoItemEdt24);
            this.loginModel.addItem(2, localInfoItemEdt25);
            this.loginModel.addItem(2, localInfoItemDate2);
            this.loginModel.addItem(2, localInfoItemDate3);
            this.loginModel.addItem(2, localInfoItemDate4);
            this.loginModel.addItem(1, localInfoItemEdt26);
            this.loginModel.addItem(1, localInfoItemEdt27);
            this.loginModel.addItem(1, localInfoItemEdt28);
            this.loginModel.addItem(1, localInfoItemEdt29);
            this.loginModel.addItem(1, localInfoItemEdt31);
            this.loginModel.addItem(1, localInfoItemEdt32);
            this.loginModel.addItem(1, localInfoItemEdt33);
            this.loginModel.addItem(1, localInfoItemEdt34);
            this.loginModel.addItem(1, localInfoItemEdt35);
            this.loginModel.addItem(1, localInfoItemEdt36);
            this.loginModel.addItem(1, localInfoItemEdt37);
            this.loginModel.addItem(1, localInfoItemEdt38);
            this.loginModel.addItem(1, localInfoItemEdt39);
            this.loginModel.addItem(1, localInfoItemEdt40);
            this.loginModel.addItem(1, localInfoItemEdt41);
            this.loginModel.addItem(1, localInfoItemDate5);
            this.loginModel.addItem(1, localInfoItemDate6);
            this.loginModel.addItem(1, localInfoItemSp15);
            this.loginModel.addItem(0, localInfoItemChk27);
            this.loginModel.addItem(0, localInfoItemChk26);
            this.loginModel.addItem(0, localInfoItemChk28);
            return;
          }
          this.loginModel.initItemBars(new String[] { "����������Ϣ��", "����������Ϣһ", "���������Ϣ", "���������Ŀ", "������¼��Ϣ" });
          this.loginModel.addItem(4, this.jclbItem);
          this.loginModel.addItem(4, this.jylbzlfdjItem);
          this.loginModel.addItem(4, this.jylbzllsjyItem);
          this.jylbzlfdjItem.setVisibility(8);
          this.jylbzllsjyItem.setVisibility(8);
          this.loginModel.addItem(4, this.hphmItem);
          this.loginModel.addItem(4, this.hpzlItem);
          this.loginModel.addItem(4, this.vinItem);
          this.loginModel.addItem(4, this.clxhItem);
          this.loginModel.addItem(4, clsslbmoth(true));
          this.loginModel.addItem(4, this.cllxItem);
          this.loginModel.addItem(4, this.syxzItem);
          this.loginModel.addItem(4, this.syr);
          this.loginModel.addItem(4, localInfoItemSp1);
          this.loginModel.addItem(4, this.csys);
          this.loginModel.addItem(4, this.zxzxjxs);
          this.loginModel.addItem(4, this.qdxs);
          this.loginModel.addItem(4, this.zczw);
          this.loginModel.addItem(4, localInfoItemSp2);
          this.loginModel.addItem(4, this.sfqszxzItem);
          this.loginModel.addItem(4, this.jcxlb);
          this.loginModel.addItem(4, this.qzdz);
          this.loginModel.addItem(4, this.ygddtz);
          this.loginModel.addItem(4, localInfoItemDate1);
          this.loginModel.addItem(4, localInfoItemEdt1);
          this.loginModel.addItem(4, localInfoItemEdt2);
          this.loginModel.addItem(4, localInfoItemEdt3);
          this.loginModel.addItem(4, localInfoItemEdt4);
          this.loginModel.addItem(4, localInfoItemEdt5);
          this.loginModel.addItem(4, localInfoItemEdt6);
          this.loginModel.addItem(4, localInfoItemEdt7);
          this.loginModel.addItem(4, localInfoItemEdt16);
          this.loginModel.addItem(4, localInfoItemEdt30);
          this.loginModel.addItem(4, localInfoItemEdt8);
          this.loginModel.addItem(4, localInfoItemEdt9);
          this.loginModel.addItem(4, localInfoItemEdt10);
          this.loginModel.addItem(4, this.lcbds);
          this.loginModel.addItem(4, this.qzs);
          this.loginModel.addItem(4, localInfoItemEdt11);
          this.loginModel.addItem(4, localInfoItemEdt12);
          this.loginModel.addItem(4, this.WZItem);
          this.loginModel.addItem(4, this.jqfs);
          this.loginModel.addItem(4, localInfoItemSp11);
          this.loginModel.addItem(4, this.gs);
          this.loginModel.addItem(4, this.dws);
          this.loginModel.addItem(4, this.bsxs);
          this.loginModel.addItem(4, this.gyfs);
          this.loginModel.addItem(4, this.hdzk);
          this.loginModel.addItem(3, localInfoItemChk20);
          this.loginModel.addItem(3, localInfoItemChk11);
          this.loginModel.addItem(3, localInfoItemChk9);
          this.loginModel.addItem(3, localInfoItemChk10);
          this.loginModel.addItem(3, localInfoItemChk3);
          this.loginModel.addItem(3, localInfoItemChk4);
          this.loginModel.addItem(3, localInfoItemChk5);
          this.loginModel.addItem(3, localInfoItemChk6);
          this.loginModel.addItem(3, localInfoItemChk7);
          this.loginModel.addItem(3, localInfoItemChk8);
          this.loginModel.addItem(3, localInfoItemChk2);
          this.loginModel.addItem(3, localInfoItemChk12);
          this.loginModel.addItem(3, localInfoItemChk13);
          this.loginModel.addItem(3, localInfoItemChk14);
          this.loginModel.addItem(3, localInfoItemChk15);
          this.loginModel.addItem(3, localInfoItemChk24);
          this.loginModel.addItem(3, localInfoItemChk1);
          this.loginModel.addItem(3, localInfoItemChk21);
          this.loginModel.addItem(3, localInfoItemChk22);
          this.loginModel.addItem(3, localInfoItemChk23);
          this.loginModel.addItem(3, localInfoItemChk25);
          this.loginModel.addItem(3, localInfoItemChk16);
          this.loginModel.addItem(3, localInfoItemChk17);
          this.loginModel.addItem(3, localInfoItemChk18);
          this.loginModel.addItem(3, localInfoItemChk19);
          this.loginModel.addItem(2, localInfoItemSp3);
          this.loginModel.addItem(2, localInfoItemSp4);
          this.loginModel.addItem(2, localInfoItemSp5);
          this.loginModel.addItem(2, localInfoItemSp6);
          this.loginModel.addItem(2, localInfoItemSp7);
          this.loginModel.addItem(2, localInfoItemSp8);
          this.loginModel.addItem(2, localInfoItemSp9);
          this.loginModel.addItem(2, this.obddsfzc);
          this.loginModel.addItem(2, localInfoItemSp10);
          this.loginModel.addItem(2, localInfoItemEdt13);
          this.loginModel.addItem(2, localInfoItemEdt14);
          this.loginModel.addItem(2, localInfoItemEdt15);
          this.loginModel.addItem(1, this.gl);
          this.loginModel.addItem(1, localInfoItemSp12);
          this.loginModel.addItem(1, localInfoItemSp13);
          this.loginModel.addItem(1, localInfoItemEdt17);
          this.loginModel.addItem(1, this.clyt1);
          this.loginModel.addItem(1, localInfoItemEdt18);
          this.loginModel.addItem(1, localInfoItemEdt19);
          this.loginModel.addItem(1, localInfoItemSp14);
          this.loginModel.addItem(1, localInfoItemEdt20);
          this.loginModel.addItem(1, localInfoItemEdt21);
          this.loginModel.addItem(1, localInfoItemEdt22);
          this.loginModel.addItem(1, localInfoItemEdt23);
          this.loginModel.addItem(1, localInfoItemEdt24);
          this.loginModel.addItem(1, localInfoItemEdt25);
          this.loginModel.addItem(1, localInfoItemDate2);
          this.loginModel.addItem(1, localInfoItemDate3);
          this.loginModel.addItem(1, localInfoItemDate4);
          this.loginModel.addItem(0, localInfoItemEdt26);
          this.loginModel.addItem(0, localInfoItemEdt27);
          this.loginModel.addItem(0, localInfoItemEdt28);
          this.loginModel.addItem(0, localInfoItemEdt29);
          this.loginModel.addItem(0, localInfoItemEdt31);
          this.loginModel.addItem(0, localInfoItemEdt32);
          this.loginModel.addItem(0, localInfoItemEdt33);
          this.loginModel.addItem(0, localInfoItemEdt34);
          this.loginModel.addItem(0, localInfoItemEdt35);
          this.loginModel.addItem(0, localInfoItemEdt36);
          this.loginModel.addItem(0, localInfoItemEdt37);
          this.loginModel.addItem(0, localInfoItemEdt38);
          this.loginModel.addItem(0, localInfoItemEdt39);
          this.loginModel.addItem(0, localInfoItemEdt40);
          this.loginModel.addItem(0, localInfoItemEdt41);
          this.loginModel.addItem(0, localInfoItemDate5);
          this.loginModel.addItem(0, localInfoItemDate6);
          this.loginModel.addItem(0, localInfoItemSp15);
          return;
        }
        if (Md_system.getSfzj().equals("��"))
        {
          this.loginModel.initItemBars(new String[] { "�ۼ������Ŀ", "����������Ϣ��", "����������Ϣһ", "���������Ϣ", "������¼��Ϣ" });
          this.loginModel.addItem(4, this.jclbItem);
          this.loginModel.addItem(4, this.jylbzlfdjItem);
          this.loginModel.addItem(4, this.jylbzllsjyItem);
          this.jylbzlfdjItem.setVisibility(8);
          this.jylbzllsjyItem.setVisibility(8);
          this.loginModel.addItem(4, this.hphmItem);
          this.loginModel.addItem(4, this.hpzlItem);
          this.loginModel.addItem(4, this.vinItem);
          this.loginModel.addItem(4, this.clxhItem);
          this.loginModel.addItem(4, clsslbmoth(false));
          this.loginModel.addItem(4, this.cllxItem);
          this.loginModel.addItem(4, this.syxzItem);
          this.loginModel.addItem(4, this.syr);
          this.loginModel.addItem(4, localInfoItemSp1);
          this.loginModel.addItem(4, this.csys);
          this.loginModel.addItem(4, this.zxzxjxs);
          this.loginModel.addItem(4, this.qdxs);
          this.loginModel.addItem(4, this.zczw);
          this.loginModel.addItem(4, localInfoItemSp2);
          this.loginModel.addItem(4, this.sfqszxzItem);
          this.loginModel.addItem(4, this.jcxlb);
          this.loginModel.addItem(4, this.qzdz);
          this.loginModel.addItem(4, this.ygddtz);
          this.loginModel.addItem(4, localInfoItemDate1);
          this.loginModel.addItem(4, localInfoItemEdt1);
          this.loginModel.addItem(4, localInfoItemEdt2);
          this.loginModel.addItem(4, localInfoItemEdt3);
          this.loginModel.addItem(4, localInfoItemEdt4);
          this.loginModel.addItem(4, localInfoItemEdt5);
          this.loginModel.addItem(4, localInfoItemEdt6);
          this.loginModel.addItem(4, localInfoItemEdt7);
          this.loginModel.addItem(4, localInfoItemEdt16);
          this.loginModel.addItem(4, localInfoItemEdt30);
          this.loginModel.addItem(4, localInfoItemEdt8);
          this.loginModel.addItem(4, localInfoItemEdt9);
          this.loginModel.addItem(4, localInfoItemEdt10);
          this.loginModel.addItem(4, this.lcbds);
          this.loginModel.addItem(4, this.qzs);
          this.loginModel.addItem(4, localInfoItemEdt11);
          this.loginModel.addItem(4, localInfoItemEdt12);
          this.loginModel.addItem(4, this.WZItem);
          this.loginModel.addItem(4, this.jqfs);
          this.loginModel.addItem(4, localInfoItemSp11);
          this.loginModel.addItem(4, this.gs);
          this.loginModel.addItem(4, this.dws);
          this.loginModel.addItem(4, this.bsxs);
          this.loginModel.addItem(4, this.gyfs);
          this.loginModel.addItem(4, this.hdzk);
          this.loginModel.addItem(3, localInfoItemSp3);
          this.loginModel.addItem(3, localInfoItemSp4);
          this.loginModel.addItem(3, localInfoItemSp5);
          this.loginModel.addItem(3, localInfoItemSp6);
          this.loginModel.addItem(3, localInfoItemSp7);
          this.loginModel.addItem(3, localInfoItemSp8);
          this.loginModel.addItem(3, localInfoItemSp9);
          this.loginModel.addItem(3, this.obddsfzc);
          this.loginModel.addItem(3, localInfoItemSp10);
          this.loginModel.addItem(3, localInfoItemEdt13);
          this.loginModel.addItem(3, localInfoItemEdt14);
          this.loginModel.addItem(3, localInfoItemEdt15);
          this.loginModel.addItem(2, this.gl);
          this.loginModel.addItem(2, localInfoItemSp12);
          this.loginModel.addItem(2, localInfoItemSp13);
          this.loginModel.addItem(2, localInfoItemEdt17);
          this.loginModel.addItem(2, this.clyt1);
          this.loginModel.addItem(2, localInfoItemEdt18);
          this.loginModel.addItem(2, localInfoItemEdt19);
          this.loginModel.addItem(2, localInfoItemSp14);
          this.loginModel.addItem(2, localInfoItemEdt20);
          this.loginModel.addItem(2, localInfoItemEdt21);
          this.loginModel.addItem(2, localInfoItemEdt22);
          this.loginModel.addItem(2, localInfoItemEdt23);
          this.loginModel.addItem(2, localInfoItemEdt24);
          this.loginModel.addItem(2, localInfoItemEdt25);
          this.loginModel.addItem(2, localInfoItemDate2);
          this.loginModel.addItem(2, localInfoItemDate3);
          this.loginModel.addItem(2, localInfoItemDate4);
          this.loginModel.addItem(1, localInfoItemEdt26);
          this.loginModel.addItem(1, localInfoItemEdt27);
          this.loginModel.addItem(1, localInfoItemEdt28);
          this.loginModel.addItem(1, localInfoItemEdt29);
          this.loginModel.addItem(1, localInfoItemEdt31);
          this.loginModel.addItem(1, localInfoItemEdt32);
          this.loginModel.addItem(1, localInfoItemEdt33);
          this.loginModel.addItem(1, localInfoItemEdt34);
          this.loginModel.addItem(1, localInfoItemEdt35);
          this.loginModel.addItem(1, localInfoItemEdt36);
          this.loginModel.addItem(1, localInfoItemEdt37);
          this.loginModel.addItem(1, localInfoItemEdt38);
          this.loginModel.addItem(1, localInfoItemEdt39);
          this.loginModel.addItem(1, localInfoItemEdt40);
          this.loginModel.addItem(1, localInfoItemEdt41);
          this.loginModel.addItem(1, localInfoItemDate5);
          this.loginModel.addItem(1, localInfoItemDate6);
          this.loginModel.addItem(1, localInfoItemSp15);
          this.loginModel.addItem(0, localInfoItemChk27);
          this.loginModel.addItem(0, localInfoItemChk26);
          this.loginModel.addItem(0, localInfoItemChk28);
          return;
        }
        this.loginModel.initItemBars(new String[] { "����������Ϣ��", "����������Ϣһ", "���������Ϣ", "������¼��Ϣ" });
        this.loginModel.addItem(3, this.jclbItem);
        this.loginModel.addItem(3, this.jylbzlfdjItem);
        this.loginModel.addItem(3, this.jylbzllsjyItem);
        this.jylbzlfdjItem.setVisibility(8);
        this.jylbzllsjyItem.setVisibility(8);
        this.loginModel.addItem(3, this.hphmItem);
        this.loginModel.addItem(3, this.hpzlItem);
        this.loginModel.addItem(3, this.vinItem);
        this.loginModel.addItem(3, this.clxhItem);
        this.loginModel.addItem(3, clsslbmoth(false));
        this.loginModel.addItem(3, this.cllxItem);
        this.loginModel.addItem(3, this.syxzItem);
        this.loginModel.addItem(3, this.syr);
        this.loginModel.addItem(3, localInfoItemSp1);
        this.loginModel.addItem(3, this.csys);
        this.loginModel.addItem(3, this.zxzxjxs);
        this.loginModel.addItem(3, this.qdxs);
        this.loginModel.addItem(3, this.zczw);
        this.loginModel.addItem(3, localInfoItemSp2);
        this.loginModel.addItem(3, this.sfqszxzItem);
        this.loginModel.addItem(3, this.jcxlb);
        this.loginModel.addItem(3, this.qzdz);
        this.loginModel.addItem(3, this.ygddtz);
        this.loginModel.addItem(3, localInfoItemDate1);
        this.loginModel.addItem(3, localInfoItemEdt1);
        this.loginModel.addItem(3, localInfoItemEdt2);
        this.loginModel.addItem(3, localInfoItemEdt3);
        this.loginModel.addItem(3, localInfoItemEdt4);
        this.loginModel.addItem(3, localInfoItemEdt5);
        this.loginModel.addItem(3, localInfoItemEdt6);
        this.loginModel.addItem(3, localInfoItemEdt7);
        this.loginModel.addItem(3, localInfoItemEdt16);
        this.loginModel.addItem(3, localInfoItemEdt30);
        this.loginModel.addItem(3, localInfoItemEdt8);
        this.loginModel.addItem(3, localInfoItemEdt9);
        this.loginModel.addItem(3, localInfoItemEdt10);
        this.loginModel.addItem(3, this.lcbds);
        this.loginModel.addItem(3, this.qzs);
        this.loginModel.addItem(3, localInfoItemEdt11);
        this.loginModel.addItem(3, localInfoItemEdt12);
        this.loginModel.addItem(3, this.WZItem);
        this.loginModel.addItem(3, this.jqfs);
        this.loginModel.addItem(3, localInfoItemSp11);
        this.loginModel.addItem(3, this.gs);
        this.loginModel.addItem(3, this.dws);
        this.loginModel.addItem(3, this.bsxs);
        this.loginModel.addItem(3, this.gyfs);
        this.loginModel.addItem(3, this.hdzk);
        this.loginModel.addItem(2, localInfoItemSp3);
        this.loginModel.addItem(2, localInfoItemSp4);
        this.loginModel.addItem(2, localInfoItemSp5);
        this.loginModel.addItem(2, localInfoItemSp6);
        this.loginModel.addItem(2, localInfoItemSp7);
        this.loginModel.addItem(2, localInfoItemSp8);
        this.loginModel.addItem(2, localInfoItemSp9);
        this.loginModel.addItem(2, this.obddsfzc);
        this.loginModel.addItem(2, localInfoItemSp10);
        this.loginModel.addItem(2, localInfoItemEdt13);
        this.loginModel.addItem(2, localInfoItemEdt14);
        this.loginModel.addItem(2, localInfoItemEdt15);
        this.loginModel.addItem(1, this.gl);
        this.loginModel.addItem(1, localInfoItemSp12);
        this.loginModel.addItem(1, localInfoItemSp13);
        this.loginModel.addItem(1, localInfoItemEdt17);
        this.loginModel.addItem(1, this.clyt1);
        this.loginModel.addItem(1, localInfoItemEdt18);
        this.loginModel.addItem(1, localInfoItemEdt19);
        this.loginModel.addItem(1, localInfoItemSp14);
        this.loginModel.addItem(1, localInfoItemEdt20);
        this.loginModel.addItem(1, localInfoItemEdt21);
        this.loginModel.addItem(1, localInfoItemEdt22);
        this.loginModel.addItem(1, localInfoItemEdt23);
        this.loginModel.addItem(1, localInfoItemEdt24);
        this.loginModel.addItem(1, localInfoItemEdt25);
        this.loginModel.addItem(1, localInfoItemDate2);
        this.loginModel.addItem(1, localInfoItemDate3);
        this.loginModel.addItem(1, localInfoItemDate4);
        this.loginModel.addItem(0, localInfoItemEdt26);
        this.loginModel.addItem(0, localInfoItemEdt27);
        this.loginModel.addItem(0, localInfoItemEdt28);
        this.loginModel.addItem(0, localInfoItemEdt29);
        this.loginModel.addItem(0, localInfoItemEdt31);
        this.loginModel.addItem(0, localInfoItemEdt32);
        this.loginModel.addItem(0, localInfoItemEdt33);
        this.loginModel.addItem(0, localInfoItemEdt34);
        this.loginModel.addItem(0, localInfoItemEdt35);
        this.loginModel.addItem(0, localInfoItemEdt36);
        this.loginModel.addItem(0, localInfoItemEdt37);
        this.loginModel.addItem(0, localInfoItemEdt38);
        this.loginModel.addItem(0, localInfoItemEdt39);
        this.loginModel.addItem(0, localInfoItemEdt40);
        this.loginModel.addItem(0, localInfoItemEdt41);
        this.loginModel.addItem(0, localInfoItemDate5);
        this.loginModel.addItem(0, localInfoItemDate6);
        this.loginModel.addItem(0, localInfoItemSp15);
        return;
      }
      if (Md_system.getSfgxjyxm().equals("��"))
      {
        if (Md_system.getSfzj().equals("��"))
        {
          this.loginModel.initItemBars(new String[] { "�ۼ������Ŀ", "����������Ϣ��", "����������Ϣһ", "���������Ŀ", "������¼��Ϣ" });
          this.loginModel.addItem(4, this.jclbItem);
          this.loginModel.addItem(4, this.jylbzlfdjItem);
          this.loginModel.addItem(4, this.jylbzllsjyItem);
          this.jylbzlfdjItem.setVisibility(8);
          this.jylbzllsjyItem.setVisibility(8);
          this.loginModel.addItem(4, this.hphmItem);
          this.loginModel.addItem(4, this.hpzlItem);
          this.loginModel.addItem(4, this.vinItem);
          this.loginModel.addItem(4, this.clxhItem);
          this.loginModel.addItem(4, clsslbmoth(true));
          this.loginModel.addItem(4, this.cllxItem);
          this.loginModel.addItem(4, this.syxzItem);
          this.loginModel.addItem(4, this.syr);
          this.loginModel.addItem(4, localInfoItemSp1);
          this.loginModel.addItem(4, this.csys);
          this.loginModel.addItem(4, this.zxzxjxs);
          this.loginModel.addItem(4, this.qdxs);
          this.loginModel.addItem(4, this.zczw);
          this.loginModel.addItem(4, localInfoItemSp2);
          this.loginModel.addItem(4, this.sfqszxzItem);
          this.loginModel.addItem(4, this.jcxlb);
          this.loginModel.addItem(4, this.qzdz);
          this.loginModel.addItem(4, this.ygddtz);
          this.loginModel.addItem(4, localInfoItemDate1);
          this.loginModel.addItem(4, localInfoItemEdt1);
          this.loginModel.addItem(4, localInfoItemEdt2);
          this.loginModel.addItem(4, localInfoItemEdt3);
          this.loginModel.addItem(4, localInfoItemEdt4);
          this.loginModel.addItem(4, localInfoItemEdt5);
          this.loginModel.addItem(4, localInfoItemEdt6);
          this.loginModel.addItem(4, localInfoItemEdt7);
          this.loginModel.addItem(4, localInfoItemEdt16);
          this.loginModel.addItem(4, localInfoItemEdt30);
          this.loginModel.addItem(4, localInfoItemEdt8);
          this.loginModel.addItem(4, localInfoItemEdt9);
          this.loginModel.addItem(4, localInfoItemEdt10);
          this.loginModel.addItem(4, this.lcbds);
          this.loginModel.addItem(4, this.qzs);
          this.loginModel.addItem(4, localInfoItemEdt11);
          this.loginModel.addItem(4, localInfoItemEdt12);
          this.loginModel.addItem(4, this.WZItem);
          this.loginModel.addItem(4, this.jqfs);
          this.loginModel.addItem(4, localInfoItemSp11);
          this.loginModel.addItem(4, this.gs);
          this.loginModel.addItem(4, this.dws);
          this.loginModel.addItem(4, this.bsxs);
          this.loginModel.addItem(4, this.gyfs);
          this.loginModel.addItem(4, this.hdzk);
          this.loginModel.addItem(3, localInfoItemChk20);
          this.loginModel.addItem(3, localInfoItemChk11);
          this.loginModel.addItem(3, localInfoItemChk9);
          this.loginModel.addItem(3, localInfoItemChk10);
          this.loginModel.addItem(3, localInfoItemChk3);
          this.loginModel.addItem(3, localInfoItemChk4);
          this.loginModel.addItem(3, localInfoItemChk5);
          this.loginModel.addItem(3, localInfoItemChk6);
          this.loginModel.addItem(3, localInfoItemChk7);
          this.loginModel.addItem(3, localInfoItemChk8);
          this.loginModel.addItem(3, localInfoItemChk2);
          this.loginModel.addItem(3, localInfoItemChk12);
          this.loginModel.addItem(3, localInfoItemChk13);
          this.loginModel.addItem(3, localInfoItemChk14);
          this.loginModel.addItem(3, localInfoItemChk15);
          this.loginModel.addItem(3, localInfoItemChk24);
          this.loginModel.addItem(3, localInfoItemChk1);
          this.loginModel.addItem(3, localInfoItemChk21);
          this.loginModel.addItem(3, localInfoItemChk22);
          this.loginModel.addItem(3, localInfoItemChk23);
          this.loginModel.addItem(3, localInfoItemChk25);
          this.loginModel.addItem(3, localInfoItemChk16);
          this.loginModel.addItem(3, localInfoItemChk17);
          this.loginModel.addItem(3, localInfoItemChk18);
          this.loginModel.addItem(3, localInfoItemChk19);
          this.loginModel.addItem(2, this.gl);
          this.loginModel.addItem(2, localInfoItemSp12);
          this.loginModel.addItem(2, localInfoItemSp13);
          this.loginModel.addItem(2, localInfoItemEdt17);
          this.loginModel.addItem(2, this.clyt1);
          this.loginModel.addItem(2, localInfoItemEdt18);
          this.loginModel.addItem(2, localInfoItemEdt19);
          this.loginModel.addItem(2, localInfoItemSp14);
          this.loginModel.addItem(2, localInfoItemEdt20);
          this.loginModel.addItem(2, localInfoItemEdt21);
          this.loginModel.addItem(2, localInfoItemEdt22);
          this.loginModel.addItem(2, localInfoItemEdt23);
          this.loginModel.addItem(2, localInfoItemEdt24);
          this.loginModel.addItem(2, localInfoItemEdt25);
          this.loginModel.addItem(2, localInfoItemDate2);
          this.loginModel.addItem(2, localInfoItemDate3);
          this.loginModel.addItem(2, localInfoItemDate4);
          this.loginModel.addItem(1, localInfoItemEdt26);
          this.loginModel.addItem(1, localInfoItemEdt27);
          this.loginModel.addItem(1, localInfoItemEdt28);
          this.loginModel.addItem(1, localInfoItemEdt29);
          this.loginModel.addItem(1, localInfoItemEdt31);
          this.loginModel.addItem(1, localInfoItemEdt32);
          this.loginModel.addItem(1, localInfoItemEdt33);
          this.loginModel.addItem(1, localInfoItemEdt34);
          this.loginModel.addItem(1, localInfoItemEdt35);
          this.loginModel.addItem(1, localInfoItemEdt36);
          this.loginModel.addItem(1, localInfoItemEdt37);
          this.loginModel.addItem(1, localInfoItemEdt38);
          this.loginModel.addItem(1, localInfoItemEdt39);
          this.loginModel.addItem(1, localInfoItemEdt40);
          this.loginModel.addItem(1, localInfoItemEdt41);
          this.loginModel.addItem(1, localInfoItemDate5);
          this.loginModel.addItem(1, localInfoItemDate6);
          this.loginModel.addItem(1, localInfoItemSp15);
          this.loginModel.addItem(0, localInfoItemChk27);
          this.loginModel.addItem(0, localInfoItemChk26);
          this.loginModel.addItem(0, localInfoItemChk28);
          return;
        }
        this.loginModel.initItemBars(new String[] { "����������Ϣ��", "����������Ϣһ", "���������Ŀ", "������¼��Ϣ" });
        this.loginModel.addItem(3, this.jclbItem);
        this.loginModel.addItem(3, this.jylbzlfdjItem);
        this.loginModel.addItem(3, this.jylbzllsjyItem);
        this.jylbzlfdjItem.setVisibility(8);
        this.jylbzllsjyItem.setVisibility(8);
        this.loginModel.addItem(3, this.hphmItem);
        this.loginModel.addItem(3, this.hpzlItem);
        this.loginModel.addItem(3, this.vinItem);
        this.loginModel.addItem(3, this.clxhItem);
        this.loginModel.addItem(3, clsslbmoth(true));
        this.loginModel.addItem(3, this.cllxItem);
        this.loginModel.addItem(3, this.syxzItem);
        this.loginModel.addItem(3, this.syr);
        this.loginModel.addItem(3, localInfoItemSp1);
        this.loginModel.addItem(3, this.csys);
        this.loginModel.addItem(3, this.zxzxjxs);
        this.loginModel.addItem(3, this.qdxs);
        this.loginModel.addItem(3, this.zczw);
        this.loginModel.addItem(3, localInfoItemSp2);
        this.loginModel.addItem(3, this.sfqszxzItem);
        this.loginModel.addItem(3, this.jcxlb);
        this.loginModel.addItem(3, this.qzdz);
        this.loginModel.addItem(3, this.ygddtz);
        this.loginModel.addItem(3, localInfoItemDate1);
        this.loginModel.addItem(3, localInfoItemEdt1);
        this.loginModel.addItem(3, localInfoItemEdt2);
        this.loginModel.addItem(3, localInfoItemEdt3);
        this.loginModel.addItem(3, localInfoItemEdt4);
        this.loginModel.addItem(3, localInfoItemEdt5);
        this.loginModel.addItem(3, localInfoItemEdt6);
        this.loginModel.addItem(3, localInfoItemEdt7);
        this.loginModel.addItem(3, localInfoItemEdt16);
        this.loginModel.addItem(3, localInfoItemEdt30);
        this.loginModel.addItem(3, localInfoItemEdt8);
        this.loginModel.addItem(3, localInfoItemEdt9);
        this.loginModel.addItem(3, localInfoItemEdt10);
        this.loginModel.addItem(3, this.lcbds);
        this.loginModel.addItem(3, this.qzs);
        this.loginModel.addItem(3, localInfoItemEdt11);
        this.loginModel.addItem(3, localInfoItemEdt12);
        this.loginModel.addItem(3, this.WZItem);
        this.loginModel.addItem(3, this.jqfs);
        this.loginModel.addItem(3, localInfoItemSp11);
        this.loginModel.addItem(3, this.gs);
        this.loginModel.addItem(3, this.dws);
        this.loginModel.addItem(3, this.bsxs);
        this.loginModel.addItem(3, this.gyfs);
        this.loginModel.addItem(3, this.hdzk);
        this.loginModel.addItem(2, localInfoItemChk20);
        this.loginModel.addItem(2, localInfoItemChk11);
        this.loginModel.addItem(2, localInfoItemChk9);
        this.loginModel.addItem(2, localInfoItemChk10);
        this.loginModel.addItem(2, localInfoItemChk3);
        this.loginModel.addItem(2, localInfoItemChk4);
        this.loginModel.addItem(2, localInfoItemChk5);
        this.loginModel.addItem(2, localInfoItemChk6);
        this.loginModel.addItem(2, localInfoItemChk7);
        this.loginModel.addItem(2, localInfoItemChk8);
        this.loginModel.addItem(2, localInfoItemChk2);
        this.loginModel.addItem(2, localInfoItemChk12);
        this.loginModel.addItem(2, localInfoItemChk13);
        this.loginModel.addItem(2, localInfoItemChk14);
        this.loginModel.addItem(2, localInfoItemChk15);
        this.loginModel.addItem(2, localInfoItemChk24);
        this.loginModel.addItem(2, localInfoItemChk1);
        this.loginModel.addItem(2, localInfoItemChk21);
        this.loginModel.addItem(2, localInfoItemChk22);
        this.loginModel.addItem(2, localInfoItemChk23);
        this.loginModel.addItem(2, localInfoItemChk25);
        this.loginModel.addItem(2, localInfoItemChk16);
        this.loginModel.addItem(2, localInfoItemChk17);
        this.loginModel.addItem(2, localInfoItemChk18);
        this.loginModel.addItem(2, localInfoItemChk19);
        this.loginModel.addItem(1, this.gl);
        this.loginModel.addItem(1, localInfoItemSp12);
        this.loginModel.addItem(1, localInfoItemSp13);
        this.loginModel.addItem(1, localInfoItemEdt17);
        this.loginModel.addItem(1, this.clyt1);
        this.loginModel.addItem(1, localInfoItemEdt18);
        this.loginModel.addItem(1, localInfoItemEdt19);
        this.loginModel.addItem(1, localInfoItemSp14);
        this.loginModel.addItem(1, localInfoItemEdt20);
        this.loginModel.addItem(1, localInfoItemEdt21);
        this.loginModel.addItem(1, localInfoItemEdt22);
        this.loginModel.addItem(1, localInfoItemEdt23);
        this.loginModel.addItem(1, localInfoItemEdt24);
        this.loginModel.addItem(1, localInfoItemEdt25);
        this.loginModel.addItem(1, localInfoItemDate2);
        this.loginModel.addItem(1, localInfoItemDate3);
        this.loginModel.addItem(1, localInfoItemDate4);
        this.loginModel.addItem(0, localInfoItemEdt26);
        this.loginModel.addItem(0, localInfoItemEdt27);
        this.loginModel.addItem(0, localInfoItemEdt28);
        this.loginModel.addItem(0, localInfoItemEdt29);
        this.loginModel.addItem(0, localInfoItemEdt31);
        this.loginModel.addItem(0, localInfoItemEdt32);
        this.loginModel.addItem(0, localInfoItemEdt33);
        this.loginModel.addItem(0, localInfoItemEdt34);
        this.loginModel.addItem(0, localInfoItemEdt35);
        this.loginModel.addItem(0, localInfoItemEdt36);
        this.loginModel.addItem(0, localInfoItemEdt37);
        this.loginModel.addItem(0, localInfoItemEdt38);
        this.loginModel.addItem(0, localInfoItemEdt39);
        this.loginModel.addItem(0, localInfoItemEdt40);
        this.loginModel.addItem(0, localInfoItemEdt41);
        this.loginModel.addItem(0, localInfoItemDate5);
        this.loginModel.addItem(0, localInfoItemDate6);
        this.loginModel.addItem(0, localInfoItemSp15);
        return;
      }
      if (Md_system.getSfzj().equals("��"))
      {
        this.loginModel.initItemBars(new String[] { "�ۼ������Ŀ", "����������Ϣ��", "����������Ϣһ", "������¼��Ϣ" });
        this.loginModel.addItem(3, this.jclbItem);
        this.loginModel.addItem(3, this.jylbzlfdjItem);
        this.loginModel.addItem(3, this.jylbzllsjyItem);
        this.jylbzlfdjItem.setVisibility(8);
        this.jylbzllsjyItem.setVisibility(8);
        this.loginModel.addItem(3, this.hphmItem);
        this.loginModel.addItem(3, this.hpzlItem);
        this.loginModel.addItem(3, this.vinItem);
        this.loginModel.addItem(3, this.clxhItem);
        this.loginModel.addItem(3, clsslbmoth(false));
        this.loginModel.addItem(3, this.cllxItem);
        this.loginModel.addItem(3, this.syxzItem);
        this.loginModel.addItem(3, this.syr);
        this.loginModel.addItem(3, localInfoItemSp1);
        this.loginModel.addItem(3, this.csys);
        this.loginModel.addItem(3, this.zxzxjxs);
        this.loginModel.addItem(3, this.qdxs);
        this.loginModel.addItem(3, this.zczw);
        this.loginModel.addItem(3, localInfoItemSp2);
        this.loginModel.addItem(3, this.sfqszxzItem);
        this.loginModel.addItem(3, this.jcxlb);
        this.loginModel.addItem(3, this.qzdz);
        this.loginModel.addItem(3, this.ygddtz);
        this.loginModel.addItem(3, localInfoItemDate1);
        this.loginModel.addItem(3, localInfoItemEdt1);
        this.loginModel.addItem(3, localInfoItemEdt2);
        this.loginModel.addItem(3, localInfoItemEdt3);
        this.loginModel.addItem(3, localInfoItemEdt4);
        this.loginModel.addItem(3, localInfoItemEdt5);
        this.loginModel.addItem(3, localInfoItemEdt6);
        this.loginModel.addItem(3, localInfoItemEdt7);
        this.loginModel.addItem(3, localInfoItemEdt16);
        this.loginModel.addItem(3, localInfoItemEdt30);
        this.loginModel.addItem(3, localInfoItemEdt8);
        this.loginModel.addItem(3, localInfoItemEdt9);
        this.loginModel.addItem(3, localInfoItemEdt10);
        this.loginModel.addItem(3, this.lcbds);
        this.loginModel.addItem(3, this.qzs);
        this.loginModel.addItem(3, localInfoItemEdt11);
        this.loginModel.addItem(3, localInfoItemEdt12);
        this.loginModel.addItem(3, this.WZItem);
        this.loginModel.addItem(3, this.jqfs);
        this.loginModel.addItem(3, localInfoItemSp11);
        this.loginModel.addItem(3, this.gs);
        this.loginModel.addItem(3, this.dws);
        this.loginModel.addItem(3, this.bsxs);
        this.loginModel.addItem(3, this.gyfs);
        this.loginModel.addItem(3, this.hdzk);
        this.loginModel.addItem(2, this.gl);
        this.loginModel.addItem(2, localInfoItemSp12);
        this.loginModel.addItem(2, localInfoItemSp13);
        this.loginModel.addItem(2, localInfoItemEdt17);
        this.loginModel.addItem(2, this.clyt1);
        this.loginModel.addItem(2, localInfoItemEdt18);
        this.loginModel.addItem(2, localInfoItemEdt19);
        this.loginModel.addItem(2, localInfoItemSp14);
        this.loginModel.addItem(2, localInfoItemEdt20);
        this.loginModel.addItem(2, localInfoItemEdt21);
        this.loginModel.addItem(2, localInfoItemEdt22);
        this.loginModel.addItem(2, localInfoItemEdt23);
        this.loginModel.addItem(2, localInfoItemEdt24);
        this.loginModel.addItem(2, localInfoItemEdt25);
        this.loginModel.addItem(2, localInfoItemDate2);
        this.loginModel.addItem(2, localInfoItemDate3);
        this.loginModel.addItem(2, localInfoItemDate4);
        this.loginModel.addItem(1, localInfoItemEdt26);
        this.loginModel.addItem(1, localInfoItemEdt27);
        this.loginModel.addItem(1, localInfoItemEdt28);
        this.loginModel.addItem(1, localInfoItemEdt29);
        this.loginModel.addItem(1, localInfoItemEdt31);
        this.loginModel.addItem(1, localInfoItemEdt32);
        this.loginModel.addItem(1, localInfoItemEdt33);
        this.loginModel.addItem(1, localInfoItemEdt34);
        this.loginModel.addItem(1, localInfoItemEdt35);
        this.loginModel.addItem(1, localInfoItemEdt36);
        this.loginModel.addItem(1, localInfoItemEdt37);
        this.loginModel.addItem(1, localInfoItemEdt38);
        this.loginModel.addItem(1, localInfoItemEdt39);
        this.loginModel.addItem(1, localInfoItemEdt40);
        this.loginModel.addItem(1, localInfoItemEdt41);
        this.loginModel.addItem(1, localInfoItemDate5);
        this.loginModel.addItem(1, localInfoItemDate6);
        this.loginModel.addItem(1, localInfoItemSp15);
        this.loginModel.addItem(0, localInfoItemChk27);
        this.loginModel.addItem(0, localInfoItemChk26);
        this.loginModel.addItem(0, localInfoItemChk28);
        return;
      }
      this.loginModel.initItemBars(new String[] { "����������Ϣ��", "����������Ϣһ", "������¼��Ϣ" });
      this.loginModel.addItem(2, this.jclbItem);
      this.loginModel.addItem(2, this.jylbzlfdjItem);
      this.loginModel.addItem(2, this.jylbzllsjyItem);
      this.jylbzlfdjItem.setVisibility(8);
      this.jylbzllsjyItem.setVisibility(8);
      this.loginModel.addItem(2, this.hphmItem);
      this.loginModel.addItem(2, this.hpzlItem);
      this.loginModel.addItem(2, this.vinItem);
      this.loginModel.addItem(2, this.clxhItem);
      this.loginModel.addItem(2, clsslbmoth(false));
      this.loginModel.addItem(2, this.cllxItem);
      this.loginModel.addItem(2, this.syxzItem);
      this.loginModel.addItem(2, this.syr);
      this.loginModel.addItem(2, localInfoItemSp1);
      this.loginModel.addItem(2, this.csys);
      this.loginModel.addItem(2, this.zxzxjxs);
      this.loginModel.addItem(2, this.qdxs);
      this.loginModel.addItem(2, this.zczw);
      this.loginModel.addItem(2, localInfoItemSp2);
      this.loginModel.addItem(2, this.sfqszxzItem);
      this.loginModel.addItem(2, this.jcxlb);
      this.loginModel.addItem(2, this.qzdz);
      this.loginModel.addItem(2, this.ygddtz);
      this.loginModel.addItem(2, localInfoItemDate1);
      this.loginModel.addItem(2, localInfoItemEdt1);
      this.loginModel.addItem(2, localInfoItemEdt2);
      this.loginModel.addItem(2, localInfoItemEdt3);
      this.loginModel.addItem(2, localInfoItemEdt4);
      this.loginModel.addItem(2, localInfoItemEdt5);
      this.loginModel.addItem(2, localInfoItemEdt6);
      this.loginModel.addItem(2, localInfoItemEdt7);
      this.loginModel.addItem(2, localInfoItemEdt16);
      this.loginModel.addItem(2, localInfoItemEdt30);
      this.loginModel.addItem(2, localInfoItemEdt8);
      this.loginModel.addItem(2, localInfoItemEdt9);
      this.loginModel.addItem(2, localInfoItemEdt10);
      this.loginModel.addItem(2, this.lcbds);
      this.loginModel.addItem(2, this.qzs);
      this.loginModel.addItem(2, localInfoItemEdt11);
      this.loginModel.addItem(2, localInfoItemEdt12);
      this.loginModel.addItem(2, this.WZItem);
      this.loginModel.addItem(2, this.jqfs);
      this.loginModel.addItem(2, localInfoItemSp11);
      this.loginModel.addItem(2, this.gs);
      this.loginModel.addItem(2, this.dws);
      this.loginModel.addItem(2, this.bsxs);
      this.loginModel.addItem(2, this.gyfs);
      this.loginModel.addItem(2, this.hdzk);
      this.loginModel.addItem(1, this.gl);
      this.loginModel.addItem(1, localInfoItemSp12);
      this.loginModel.addItem(1, localInfoItemSp13);
      this.loginModel.addItem(1, localInfoItemEdt17);
      this.loginModel.addItem(1, this.clyt1);
      this.loginModel.addItem(1, localInfoItemEdt18);
      this.loginModel.addItem(1, localInfoItemEdt19);
      this.loginModel.addItem(1, localInfoItemSp14);
      this.loginModel.addItem(1, localInfoItemEdt20);
      this.loginModel.addItem(1, localInfoItemEdt21);
      this.loginModel.addItem(1, localInfoItemEdt22);
      this.loginModel.addItem(1, localInfoItemEdt23);
      this.loginModel.addItem(1, localInfoItemEdt24);
      this.loginModel.addItem(1, localInfoItemEdt25);
      this.loginModel.addItem(1, localInfoItemDate2);
      this.loginModel.addItem(1, localInfoItemDate3);
      this.loginModel.addItem(1, localInfoItemDate4);
      this.loginModel.addItem(0, localInfoItemEdt26);
      this.loginModel.addItem(0, localInfoItemEdt27);
      this.loginModel.addItem(0, localInfoItemEdt28);
      this.loginModel.addItem(0, localInfoItemEdt29);
      this.loginModel.addItem(0, localInfoItemEdt31);
      this.loginModel.addItem(0, localInfoItemEdt32);
      this.loginModel.addItem(0, localInfoItemEdt33);
      this.loginModel.addItem(0, localInfoItemEdt34);
      this.loginModel.addItem(0, localInfoItemEdt35);
      this.loginModel.addItem(0, localInfoItemEdt36);
      this.loginModel.addItem(0, localInfoItemEdt37);
      this.loginModel.addItem(0, localInfoItemEdt38);
      this.loginModel.addItem(0, localInfoItemEdt39);
      this.loginModel.addItem(0, localInfoItemEdt40);
      this.loginModel.addItem(0, localInfoItemEdt41);
      this.loginModel.addItem(0, localInfoItemDate5);
      this.loginModel.addItem(0, localInfoItemDate6);
      this.loginModel.addItem(0, localInfoItemSp15);
      return;
      localInfoItemSp3 = null;
      localInfoItemSp4 = null;
      localInfoItemSp5 = null;
      localInfoItemSp6 = null;
      localInfoItemSp7 = null;
      localInfoItemSp8 = null;
      localInfoItemSp9 = null;
      localInfoItemSp10 = null;
      localInfoItemEdt13 = null;
      localInfoItemEdt14 = null;
      localInfoItemEdt15 = null;
    }
  }

  private void initValue()
  {
    try
    {
      if (this.hm != null)
        this.hm = null;
      this.hm = new HashMap();
      Md_Car_Temp.getTempCar();
      if ("".equals(Md_Car_Temp.car_hphm))
        return;
      Md_Car_Temp.getTempCar();
      if ("".equals(Md_Car_Temp.car_hpzl))
        return;
      Map localMap1 = this.hm;
      Md_Car_Temp.getTempCar();
      localMap1.put("hphm", Md_Car_Temp.car_hphm);
      Map localMap2 = this.hm;
      Md_Car_Temp.getTempCar();
      localMap2.put("hpzl", MD_ListItem.GetName(Md_Car_Temp.car_hpzl, MD_ListItem.Get_hpzl()));
      this.loginModel.setItemsData(this.hm);
      if (Md_system.getSfhj().equals("��"))
      {
        if (Md_system.getSfgxjyxm().equals("��"))
        {
          this.loginModel.setShow(4, true);
          return;
        }
        this.loginModel.setShow(3, true);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    if (Md_system.getSfgxjyxm().equals("��"))
    {
      this.loginModel.setShow(3, true);
      return;
    }
    this.loginModel.setShow(2, true);
  }

  private boolean isInYXQZ(String paramString)
  {
    if (paramString.equals(""));
    while (true)
    {
      return true;
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      try
      {
        int i = getMonthNum(localSimpleDateFormat.parse(localSimpleDateFormat.format(new Date())), localSimpleDateFormat.parse(paramString));
        if (i >= 3)
          return false;
      }
      catch (ParseException localParseException)
      {
        localParseException.printStackTrace();
      }
    }
    return true;
  }

  private String setIllegalInformation(Map<String, String> paramMap)
  {
    if (Md_Car_Temp.getTempCar().mapwz == null)
      Md_Car_Temp.getTempCar().mapwz = Docxxml.xmlread(this);
    String str1 = "";
    String str2 = (String)paramMap.get("zt");
    Md_Car_Temp.getTempCar().zt = str2;
    try
    {
      char[] arrayOfChar = Md_Car_Temp.getTempCar().zt.trim().toCharArray();
      if (arrayOfChar.length > 0)
      {
        int i = arrayOfChar.length;
        for (int j = 0; j < i; j++)
        {
          String str3 = new String(new char[] { arrayOfChar[j] });
          str1 = str1 + (String)Md_Car_Temp.getTempCar().mapwz.get(str3) + "\n";
        }
      }
      str1 = "��Υ����Ϣ";
      this.WZItem.setData(str1.trim());
      return str1.trim();
    }
    catch (Exception localException)
    {
      while (true)
        str1 = "��Υ����Ϣ";
    }
  }

  private void setMD_Car_Temp()
  {
    Md_Car_Temp.getTempCar();
    Md_Car_Temp.car_hpzl = this.hpzlItem.getData();
    Md_Car_Temp.getTempCar();
    Md_Car_Temp.car_clsbdh = this.vinItem.getData();
    Md_Car_Temp.getTempCar();
    Md_Car_Temp.car_hphm = this.hphmItem.getData();
    Md_Car_Temp.getTempCar();
    Md_Car_Temp.car_lx = this.cllxItem.getData();
    Md_Car_Temp.getTempCar();
    Md_Car_Temp.car_syxz = this.syxzItem.getData();
    Md_Car_Temp.getTempCar();
    Md_Car_Temp.car_vin = this.vinItem.getData();
    if (this.jclbItem.getData().equals("00"))
    {
      Md_Car_Temp.getTempCar();
      Md_Car_Temp.sfxc = "0";
      return;
    }
    Md_Car_Temp.getTempCar();
    Md_Car_Temp.sfxc = "1";
  }

  private void stop()
  {
    this.handler.removeCallbacks(this.task);
  }

  private void submitDataAJ()
  {
    this.requestMap = new HashMap();
    this.requesCarLogintMap = this.loginModel.getDataNodeAndValue();
    if (!Md_system.getSfgxjyxm().equals("��"))
      this.requesCarLogintMap.put("jyxm", "F1");
    this.requesCarLogintMap.put("jylsh", "");
    this.requesCarLogintMap.put("jyjgbh", Md_system.getDzkey());
    if ((this.jclbItem.getData().equals("01")) || (this.jclbItem.getData().equals("00")))
      this.requesCarLogintMap.put("jylbzl", "");
    this.requesCarLogintMap.put("dly", Md_Car_Temp.getTempCar().userxingming);
    this.requesCarLogintMap.put("ycy", "");
    this.requesCarLogintMap.put("wjy", "");
    this.requesCarLogintMap.put("bhgx", "");
    this.requesCarLogintMap.put("jycs", "1");
    this.requesCarLogintMap.put("dtjyy", "");
    this.requesCarLogintMap.put("dpjyy", "");
    this.requesCarLogintMap.put("ycysfzh", "");
    this.requesCarLogintMap.put("wjysfzh", "");
    this.requesCarLogintMap.put("dtjyysfzh", "");
    this.requesCarLogintMap.put("ccdlsj", "");
    this.requesCarLogintMap.put("dlsj", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    this.requesCarLogintMap.put("dpjyysfzh", "");
    this.requesCarLogintMap.put("jyrq", "");
    this.requestMap.put("vehispara", this.requesCarLogintMap);
    System.out.println("18C51+++" + this.requestMap);
    if ((WebStatus.isConnect(this) != 0) && (WebStatus.isConnect(this) != 1))
    {
      Toast.makeText(this, "�����쳣����������", 0).show();
      this.submitBtn.setEnabled(true);
      return;
    }
    request("18C51", this.requestMap, 2131230732, new String[] { "1" });
  }

  private void submitDataHJ()
  {
    if (this.requestMap != null)
      this.requestMap = null;
    if (this.requesCarLogintMap != null)
      this.requesCarLogintMap = null;
    this.requestMap = new HashMap();
    this.requesCarLogintMap = new HashMap();
    this.requesCarLogintMap = this.loginModel.getDataNodeAndValue();
    this.requesCarLogintMap.put("jczbh", Md_system.getHjdzkey());
    this.requesCarLogintMap.put("hphm", this.hphmItem.getData());
    this.requesCarLogintMap.put("sflx", "0");
    this.requesCarLogintMap.put("edzk", this.hdzk.getData());
    this.requesCarLogintMap.put("jccs", "����");
    this.requesCarLogintMap.put("clbs", Md_Car_Temp.sfxc);
    this.requesCarLogintMap.put("wjy", Md_Car_Temp.getTempCar().userxingming);
    this.requestMap.put("veh", this.requesCarLogintMap);
    request("01Q03", this.requestMap, 2131230765, new String[] { "1" });
  }

  public int getMonthNum(Date paramDate1, Date paramDate2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(paramDate1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(paramDate2);
    return 12 * (localCalendar2.get(1) - localCalendar1.get(1)) + (localCalendar2.get(2) - localCalendar1.get(2));
  }

  void init()
  {
    Md_Car_Temp.getTempCar().str = null;
    Md_Car_Temp.getTempCar();
    Md_Car_Temp.zdy = false;
    this.sp = getSharedPreferences("AJLW", 0);
    this.sp_hphm = this.sp.getString("HPHM", "A");
    this.sp_spinnerhphm = this.sp.getString("SPHPHM", "��");
    this.queryBtn = ((Button)findViewById(2131361884));
    this.loginModel = ((ItemLayout)findViewById(2131361805));
    this.submitBtn = ((Button)findViewById(2131361816));
    this.projectAJ = ((CheckBox)findViewById(2131361881));
    this.projectHJ = ((CheckBox)findViewById(2131361882));
    initItems(0);
    if ((this.projectAJ.isChecked()) && (!this.projectHJ.isChecked()))
    {
      this.jqfs.setVisibility(8);
      this.gs.setVisibility(8);
      this.dws.setVisibility(8);
      this.bsxs.setVisibility(8);
      this.gyfs.setVisibility(8);
    }
    HashMap localHashMap;
    if (Md_Car_Temp.getTempCar().isFromGGBD)
    {
      try
      {
        localHashMap = new HashMap();
        Bundle localBundle = getIntent().getBundleExtra("map");
        Iterator localIterator = localBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localHashMap.put(str, localBundle.getString(str));
        }
      }
      catch (Exception localException)
      {
      }
    }
    else
    {
      if (!Md_system.getSfhj().equals("��"))
        break label497;
      if (!Md_system.getSfgxjyxm().equals("��"))
        break label461;
      if (!Md_system.getSfzj().equals("��"))
        break label449;
      this.loginModel.setShow(5, true);
    }
    while (true)
    {
      findViewById(2131361885).setOnClickListener(new OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ((ScrollView)CarLoginActivity.this.findViewById(2131361831)).scrollTo(0, 0);
        }
      });
      findViewById(2131361886).setOnClickListener(new OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ((ScrollView)CarLoginActivity.this.findViewById(2131361831)).scrollTo(0, CarLoginActivity.this.loginModel.getHeight());
        }
      });
      this.projectHJ.setOnCheckedChangeListener(new OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          if (!paramAnonymousBoolean)
          {
            if (!CarLoginActivity.this.projectAJ.isChecked())
            {
              Toast.makeText(CarLoginActivity.this, "���빴ѡһ����¼��ʽ", 1).show();
              CarLoginActivity.this.projectHJ.setChecked(true);
              CarLoginActivity.this.clsslbItem.setVisibility(8);
              CarLoginActivity.this.zxzxjxs.setVisibility(8);
              CarLoginActivity.this.zczw.setVisibility(8);
              CarLoginActivity.this.sfqszxzItem.setVisibility(8);
              CarLoginActivity.this.jcxlb.setVisibility(8);
              CarLoginActivity.this.qzdz.setVisibility(8);
              CarLoginActivity.this.ygddtz.setVisibility(8);
              CarLoginActivity.this.qzs.setVisibility(8);
              CarLoginActivity.this.jqfs.setVisibility(0);
              CarLoginActivity.this.gs.setVisibility(0);
              CarLoginActivity.this.dws.setVisibility(0);
              CarLoginActivity.this.bsxs.setVisibility(0);
              CarLoginActivity.this.gyfs.setVisibility(0);
              return;
            }
            if (paramAnonymousBoolean)
            {
              CarLoginActivity.this.jqfs.setVisibility(0);
              CarLoginActivity.this.gs.setVisibility(0);
              CarLoginActivity.this.dws.setVisibility(0);
              CarLoginActivity.this.bsxs.setVisibility(0);
              CarLoginActivity.this.gyfs.setVisibility(0);
            }
            while (true) {
              CarLoginActivity.this.clsslbItem.setVisibility(0);
              CarLoginActivity.this.zxzxjxs.setVisibility(0);
              CarLoginActivity.this.zczw.setVisibility(0);
              CarLoginActivity.this.sfqszxzItem.setVisibility(0);
              CarLoginActivity.this.jcxlb.setVisibility(0);
              CarLoginActivity.this.qzdz.setVisibility(0);
              CarLoginActivity.this.ygddtz.setVisibility(0);
              CarLoginActivity.this.qzs.setVisibility(0);
              return;
              CarLoginActivity.this.jqfs.setVisibility(8);
              CarLoginActivity.this.gs.setVisibility(8);
              CarLoginActivity.this.dws.setVisibility(8);
              CarLoginActivity.this.bsxs.setVisibility(8);
              CarLoginActivity.this.gyfs.setVisibility(8);
            }
          }
          if (paramAnonymousBoolean)
          {
            CarLoginActivity.this.jqfs.setVisibility(0);
            CarLoginActivity.this.gs.setVisibility(0);
            CarLoginActivity.this.dws.setVisibility(0);
            CarLoginActivity.this.bsxs.setVisibility(0);
            CarLoginActivity.this.gyfs.setVisibility(0);
          }
          while (true)
          {
            CarLoginActivity.this.clsslbItem.setVisibility(0);
            CarLoginActivity.this.zxzxjxs.setVisibility(0);
            CarLoginActivity.this.zczw.setVisibility(0);
            CarLoginActivity.this.sfqszxzItem.setVisibility(0);
            CarLoginActivity.this.jcxlb.setVisibility(0);
            CarLoginActivity.this.qzdz.setVisibility(0);
            CarLoginActivity.this.ygddtz.setVisibility(0);
            CarLoginActivity.this.qzs.setVisibility(0);
            return;
            CarLoginActivity.this.jqfs.setVisibility(8);
            CarLoginActivity.this.gs.setVisibility(8);
            CarLoginActivity.this.dws.setVisibility(8);
            CarLoginActivity.this.bsxs.setVisibility(8);
            CarLoginActivity.this.gyfs.setVisibility(8);
          }
        }
      });
      this.projectAJ.setOnCheckedChangeListener(new OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          if (!paramAnonymousBoolean)
          {
            if (!CarLoginActivity.this.projectHJ.isChecked())
            {
              Toast.makeText(CarLoginActivity.this, "���빴ѡһ����¼��ʽ", 1).show();
              CarLoginActivity.this.projectAJ.setChecked(true);
              CarLoginActivity.this.clsslbItem.setVisibility(0);
              CarLoginActivity.this.zxzxjxs.setVisibility(0);
              CarLoginActivity.this.zczw.setVisibility(0);
              CarLoginActivity.this.sfqszxzItem.setVisibility(0);
              CarLoginActivity.this.jcxlb.setVisibility(0);
              CarLoginActivity.this.qzdz.setVisibility(0);
              CarLoginActivity.this.ygddtz.setVisibility(0);
              CarLoginActivity.this.qzs.setVisibility(0);
              CarLoginActivity.this.jqfs.setVisibility(8);
              CarLoginActivity.this.gs.setVisibility(8);
              CarLoginActivity.this.dws.setVisibility(8);
              CarLoginActivity.this.bsxs.setVisibility(8);
              CarLoginActivity.this.gyfs.setVisibility(8);
              return;
            }
            CarLoginActivity.this.jqfs.setVisibility(0);
            CarLoginActivity.this.gs.setVisibility(0);
            CarLoginActivity.this.dws.setVisibility(0);
            CarLoginActivity.this.bsxs.setVisibility(0);
            CarLoginActivity.this.gyfs.setVisibility(0);
            CarLoginActivity.this.clsslbItem.setVisibility(8);
            CarLoginActivity.this.zxzxjxs.setVisibility(8);
            CarLoginActivity.this.zczw.setVisibility(8);
            CarLoginActivity.this.sfqszxzItem.setVisibility(8);
            CarLoginActivity.this.jcxlb.setVisibility(8);
            CarLoginActivity.this.qzdz.setVisibility(8);
            CarLoginActivity.this.ygddtz.setVisibility(8);
            CarLoginActivity.this.qzs.setVisibility(8);
            return;
          }
          CarLoginActivity.this.clsslbItem.setVisibility(0);
          CarLoginActivity.this.zxzxjxs.setVisibility(0);
          CarLoginActivity.this.zczw.setVisibility(0);
          CarLoginActivity.this.sfqszxzItem.setVisibility(0);
          CarLoginActivity.this.jcxlb.setVisibility(0);
          CarLoginActivity.this.qzdz.setVisibility(0);
          CarLoginActivity.this.ygddtz.setVisibility(0);
          CarLoginActivity.this.qzs.setVisibility(0);
          CarLoginActivity.this.jqfs.setVisibility(0);
          CarLoginActivity.this.gs.setVisibility(0);
          CarLoginActivity.this.dws.setVisibility(0);
          CarLoginActivity.this.bsxs.setVisibility(0);
          CarLoginActivity.this.gyfs.setVisibility(0);
        }
      });
      this.queryBtn.setOnClickListener(new OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          CarLoginActivity.this.submitBtn.setEnabled(true);
          if (Md_Car_Temp.getTempCar().mapwz == null)
            Md_Car_Temp.getTempCar().mapwz = Docxxml.xmlread(CarLoginActivity.this);
          if (CarLoginActivity.this.queryTime == 0)
          {
            if (CarLoginActivity.this.jclbItem.getData().equals("01"))
            {
              if ((!CarLoginActivity.this.hphmItem.getData().equals("")) && (!CarLoginActivity.this.vinItem.getData().equals("")))
              {
                CarLoginActivity.this.queryBtn.setEnabled(false);
                String str1 = CarLoginActivity.this.hphmItem.getData();
                String str2;
                if (str1.contains("�³�"))
                  str2 = str1.substring(2, 3);
                while (true)
                {
                  Editor localEditor = CarLoginActivity.this.sp.edit();
                  localEditor.putString("HPHM", str2);
                  ((InfoItemSpEdt)CarLoginActivity.this.hphmItem);
                  localEditor.putString("SPHPHM", InfoItemSpEdt.getSpinnerDate());
                  localEditor.commit();
                  if (CarLoginActivity.this.requestMap != null)
                    CarLoginActivity.this.requestMap = null;
                  if (CarLoginActivity.this.requesCarLogintMap != null)
                    CarLoginActivity.this.requesCarLogintMap = null;
                  CarLoginActivity.this.requestMap = new HashMap();
                  CarLoginActivity.this.requesCarLogintMap = new HashMap();
                  CarLoginActivity.this.requesCarLogintMap.put("hphm", CarLoginActivity.this.hphmItem.getData().toUpperCase());
                  CarLoginActivity.this.requesCarLogintMap.put("hpzl", CarLoginActivity.this.hpzlItem.getData());
                  CarLoginActivity.this.requesCarLogintMap.put("clsbdh", CarLoginActivity.this.vinItem.getData());
                  CarLoginActivity.this.requesCarLogintMap.put("jyjgbh", Md_system.getDzkey());
                  CarLoginActivity.this.requestMap.put("QueryCondition", CarLoginActivity.this.requesCarLogintMap);
                  if ((WebStatus.isConnect(CarLoginActivity.this) == 0) || (WebStatus.isConnect(CarLoginActivity.this) == 1))
                    break;
                  Toast.makeText(CarLoginActivity.this, "�����쳣����������", 0).show();
                  CarLoginActivity.this.queryBtn.setEnabled(true);
                  return;
                  if (str1.contains("WJ"))
                    str2 = str1.substring(3, 4);
                  else
                    str2 = str1.substring(1, 2);
                }
                CarLoginActivity.this.request("18C49", CarLoginActivity.this.requestMap, 2131230765, new String[] { "2" });
                return;
              }
              DefautDialog.showDialog(CarLoginActivity.this, 2131230742, 2131230753, Boolean.valueOf(false), null, null);
              return;
            }
            if (CarLoginActivity.this.jclbItem.getData().equals("00"))
            {
              if (!CarLoginActivity.this.vinItem.getData().equals(""))
              {
                CarLoginActivity.this.queryBtn.setEnabled(false);
                if (CarLoginActivity.this.requestMap != null)
                  CarLoginActivity.this.requestMap = null;
                if (CarLoginActivity.this.requesCarLogintMap != null)
                  CarLoginActivity.this.requesCarLogintMap = null;
                CarLoginActivity.this.requestMap = new HashMap();
                CarLoginActivity.this.requesCarLogintMap = new HashMap();
                CarLoginActivity.this.requesCarLogintMap.put("hphm", "");
                CarLoginActivity.this.requesCarLogintMap.put("hpzl", CarLoginActivity.this.hpzlItem.getData());
                CarLoginActivity.this.requesCarLogintMap.put("jylb", CarLoginActivity.this.jclbItem.getData());
                CarLoginActivity.this.requesCarLogintMap.put("clsbdh", CarLoginActivity.this.vinItem.getData());
                CarLoginActivity.this.requesCarLogintMap.put("jyjgbh", Md_system.getDzkey());
                CarLoginActivity.this.requestMap.put("QueryCondition", CarLoginActivity.this.requesCarLogintMap);
                if ((WebStatus.isConnect(CarLoginActivity.this) != 0) && (WebStatus.isConnect(CarLoginActivity.this) != 1))
                {
                  Toast.makeText(CarLoginActivity.this, "�����쳣����������", 0).show();
                  CarLoginActivity.this.queryBtn.setEnabled(true);
                  return;
                }
                CarLoginActivity.this.request("18C49", CarLoginActivity.this.requestMap, 2131230765, new String[] { "2" });
                return;
              }
              DefautDialog.showDialog(CarLoginActivity.this, 2131230742, 2131230752, Boolean.valueOf(false), null, null);
              return;
            }
            if ((!CarLoginActivity.this.hphmItem.getData().equals("")) && (!CarLoginActivity.this.vinItem.getData().equals("")))
            {
              CarLoginActivity.this.queryBtn.setEnabled(false);
              if (CarLoginActivity.this.requestMap != null)
                CarLoginActivity.this.requestMap = null;
              if (CarLoginActivity.this.requesCarLogintMap != null)
                CarLoginActivity.this.requesCarLogintMap = null;
              CarLoginActivity.this.requestMap = new HashMap();
              CarLoginActivity.this.requesCarLogintMap = new HashMap();
              CarLoginActivity.this.requesCarLogintMap.put("hphm", CarLoginActivity.this.hphmItem.getData().toUpperCase());
              CarLoginActivity.this.requesCarLogintMap.put("hpzl", CarLoginActivity.this.hpzlItem.getData());
              CarLoginActivity.this.requesCarLogintMap.put("clsbdh", CarLoginActivity.this.vinItem.getData());
              CarLoginActivity.this.requesCarLogintMap.put("jyjgbh", Md_system.getDzkey());
              CarLoginActivity.this.requestMap.put("QueryCondition", CarLoginActivity.this.requesCarLogintMap);
              if ((WebStatus.isConnect(CarLoginActivity.this) != 0) && (WebStatus.isConnect(CarLoginActivity.this) != 1))
              {
                Toast.makeText(CarLoginActivity.this, "�����쳣����������", 0).show();
                CarLoginActivity.this.queryBtn.setEnabled(true);
                return;
              }
              CarLoginActivity.this.request("18C49", CarLoginActivity.this.requestMap, 2131230765, new String[] { "2" });
              return;
            }
            DefautDialog.showDialog(CarLoginActivity.this, 2131230742, 2131230753, Boolean.valueOf(false), null, null);
            return;
          }
          DefautDialog.showDialog(CarLoginActivity.this, "��ʾ��", "��3������µ����ѯ��", Boolean.valueOf(false), null, null);
        }
      });
      this.submitBtn.setOnClickListener(new OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          CarLoginActivity.this.submitBtn.setEnabled(false);
          CarLoginActivity.this.setMD_Car_Temp();
          if (CarLoginActivity.this.loginModel.isCompleted())
          {
            if (CarLoginActivity.this.loginModel.isMatch())
            {
              if ((CarLoginActivity.this.projectAJ.isChecked()) && (CarLoginActivity.this.projectHJ.isChecked()))
              {
                Md_Car_Temp.getTempCar().isAJHJFlag = true;
                CarLoginActivity.this.submitDataAJ();
              }
              do
              {
                return;
                if ((CarLoginActivity.this.projectHJ.isChecked()) && (!CarLoginActivity.this.projectAJ.isChecked()))
                {
                  Md_Car_Temp.getTempCar().isAJHJFlag = false;
                  CarLoginActivity.this.submitDataHJ();
                  return;
                }
              }
              while ((!CarLoginActivity.this.projectAJ.isChecked()) || (CarLoginActivity.this.projectHJ.isChecked()));
              Md_Car_Temp.getTempCar().isAJHJFlag = false;
              CarLoginActivity.this.submitDataAJ();
              return;
            }
            CarLoginActivity.this.submitBtn.setEnabled(true);
            DefautDialog.showDialog(CarLoginActivity.this, CarLoginActivity.this.getResources().getString(2131230796), CarLoginActivity.this.loginModel.Log(), Boolean.valueOf(false), null, null);
            return;
          }
          CarLoginActivity.this.submitBtn.setEnabled(true);
          DefautDialog.showDialog(CarLoginActivity.this, CarLoginActivity.this.getResources().getString(2131230796), CarLoginActivity.this.loginModel.Log(), Boolean.valueOf(false), null, null);
        }
      });
      initValue();
      getwjqx();
      return;
      this.loginModel.setItemsData(localHashMap);
      break;
      label449: this.loginModel.setShow(4, true);
      continue;
      label461: if (Md_system.getSfzj().equals("��"))
      {
        this.loginModel.setShow(4, true);
      }
      else
      {
        this.loginModel.setShow(3, true);
        continue;
        label497: if (Md_system.getSfgxjyxm().equals("��"))
        {
          if (Md_system.getSfzj().equals("��"))
            this.loginModel.setShow(4, true);
          else
            this.loginModel.setShow(3, true);
        }
        else if (Md_system.getSfzj().equals("��"))
          this.loginModel.setShow(3, true);
        else
          this.loginModel.setShow(2, true);
      }
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903057);
    registerBoradcastReceiver();
    Md_Car_Temp.getTempCar().isFlagToPicTrue = false;
    Md_Car_Temp.getTempCar().isAJHJFlag = false;
    Md_Car_Temp.getTempCar();
    Md_Car_Temp.car_lsh = "";
    Md_Car_Temp.getTempCar();
    Md_Car_Temp.car_hjjylsh = "";
    Md_Car_Temp.sfbpzp_HJ = "";
    init();
    if (Md_Car_Temp.FJ_HashMap != null)
    {
      Md_Car_Temp.isQuery = false;
      this.loginModel.setItemsData(Md_Car_Temp.FJ_HashMap);
      setIllegalInformation(Md_Car_Temp.FJ_HashMap);
    }
  }

  protected void onDestroy()
  {
    Md_Car_Temp.getTempCar().isFromGGBD = false;
    Md_Car_Temp.FJ_HashMap = null;
    if (this.mBroadcastReceiver != null)
      unregisterReceiver(this.mBroadcastReceiver);
    super.onDestroy();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      Md_Car_Temp.getTempCar();
      if ("FJ_ClfjCarList_Activity".equals(Md_Car_Temp.fromTag))
      {
        Md_Car_Temp.getTempCar();
        Md_Car_Temp.fromTag = "";
        Md_Car_Temp.FJ_HashMap = null;
        startActivity(new Intent(this, FJ_ClfjCarList_Activity.class));
      }
      finish();
    }
    return true;
  }

  protected void onPause()
  {
    Md_Car_Temp.getTempCar().isFromGGBD = false;
    super.onPause();
  }

  public void onRequestSuccess(String paramString, Object paramObject)
  {
    try
    {
      if (!"18C51".equals(paramString))
        break label472;
      this.submitBtn.setEnabled(true);
      List localList2 = (List)paramObject;
      if (!((Md_Car_TongYong)localList2.get(0)).code.equals("1"))
      {
        DefautDialog.showDialog(this, getResources().getString(2131230796), ((Md_Car_TongYong)localList2.get(0)).message, Boolean.valueOf(false), null, null);
        return;
      }
      if (Md_system.getSfhj().equals("��"))
      {
        if (this.requestMap != null)
          this.requestMap = null;
        if (this.requesCarLogintMap != null)
          this.requesCarLogintMap = null;
        if (this.requestMapNode != null)
          this.requestMapNode = null;
        this.requestMapNode = new HashMap();
        this.requestMap = new HashMap();
        this.requesCarLogintMap = this.loginModel.getDataNodeAndValueHbxx();
        this.requesCarLogintMap.put("clsbdh", this.vinItem.getData());
        this.requesCarLogintMap.put("gl", this.gl.getData());
        this.requestMap.put("hbxx", this.requesCarLogintMap);
        this.requestMapNode.put("vehispara", this.requestMap);
        request("18H01", this.requestMapNode, 2131230732, new String[] { "1" });
        return;
      }
    }
    catch (Exception localException1)
    {
      this.submitBtn.setEnabled(true);
      DefautDialog.showDialog(this, 2131230796, 2131230895, Boolean.valueOf(false), null, null);
      return;
    }
    label472: HashMap localHashMap1;
    if (Md_Car_Temp.getTempCar().isAJHJFlag)
    {
      Md_Car_Temp.getTempCar();
      Md_Car_Temp.zdy = false;
      if (Md_Car_Temp.getTempCar().car_jyxm.contains("F1"))
      {
        if ((Md_Car_Temp.getTempCar().car_ywcjyxm != null) && (Md_Car_Temp.getTempCar().car_ywcjyxm.contains("F1")))
        {
          Toast.makeText(this, "��ۼ������ύ������������������....", 0).show();
          Md_Car_Temp.getTempCar().isFlagToPicTrue = true;
          submitDataHJ();
          return;
        }
        if ("�Ĵ�".equals(Md_system.dq))
        {
          if (this.isRGWJ)
          {
            Md_Car_Temp.getTempCar().isFlagToPicTrue = false;
            submitDataHJ();
            return;
          }
          Toast.makeText(this, "��û�����Ȩ��", 0).show();
          return;
        }
        Md_Car_Temp.getTempCar().isFlagToPicTrue = false;
        submitDataHJ();
      }
    }
    else
    {
      DefautDialog.showDialog(this, getResources().getString(2131230796), "������¼�ɹ���", Boolean.valueOf(false), new DefautDialog.OnClickListener()
      {
        public void onClick(DefautDialog paramAnonymousDefautDialog, View paramAnonymousView)
        {
          paramAnonymousDefautDialog.dimiss();
          Md_Car_Temp.getTempCar();
          Md_Car_Temp.zdy = false;
          if (Md_Car_Temp.getTempCar().car_jyxm.contains("F1"))
          {
            if ((Md_Car_Temp.getTempCar().car_ywcjyxm != null) && (Md_Car_Temp.getTempCar().car_ywcjyxm.contains("F1")))
            {
              Toast.makeText(CarLoginActivity.this, "��ۼ������ύ������������������....", 0).show();
              Application_Activity.goToActivity(CarLoginActivity.this, Pzlx_Activity.class);
              CarLoginActivity.this.finish();
            }
          }
          else
            return;
          if ("�Ĵ�".equals(Md_system.dq))
          {
            if (CarLoginActivity.this.isRGWJ)
            {
              Application_Activity.goToActivity(CarLoginActivity.this, CarPeople_Item_Activity.class);
              CarLoginActivity.this.finish();
              return;
            }
            Toast.makeText(CarLoginActivity.this, "��û�����Ȩ��", 0).show();
            return;
          }
          Application_Activity.goToActivity(CarLoginActivity.this, CarPeople_Item_Activity.class);
          CarLoginActivity.this.finish();
        }
      }
      , null);
      return;
      if ("18H01".equals(paramString))
      {
        this.submitBtn.setEnabled(true);
        if (Md_Car_Temp.getTempCar().isAJHJFlag)
        {
          Md_Car_Temp.getTempCar();
          Md_Car_Temp.zdy = false;
          if (Md_Car_Temp.getTempCar().car_jyxm.contains("F1"))
          {
            if ((Md_Car_Temp.getTempCar().car_ywcjyxm != null) && (Md_Car_Temp.getTempCar().car_ywcjyxm.contains("F1")))
            {
              Toast.makeText(this, "��ۼ������ύ������������������....", 0).show();
              Md_Car_Temp.getTempCar().isFlagToPicTrue = true;
              submitDataHJ();
              return;
            }
            if ("�Ĵ�".equals(Md_system.dq))
            {
              if (this.isRGWJ)
              {
                Md_Car_Temp.getTempCar().isFlagToPicTrue = false;
                submitDataHJ();
                return;
              }
              Toast.makeText(this, "��û�����Ȩ��", 0).show();
              return;
            }
            Md_Car_Temp.getTempCar().isFlagToPicTrue = false;
            submitDataHJ();
          }
        }
        else
        {
          DefautDialog.showDialog(this, getResources().getString(2131230796), "������¼�ɹ���", Boolean.valueOf(false), new DefautDialog.OnClickListener()
          {
            public void onClick(DefautDialog paramAnonymousDefautDialog, View paramAnonymousView)
            {
              paramAnonymousDefautDialog.dimiss();
              Md_Car_Temp.getTempCar();
              Md_Car_Temp.zdy = false;
              if (Md_Car_Temp.getTempCar().car_jyxm.contains("F1"))
              {
                if ((Md_Car_Temp.getTempCar().car_ywcjyxm != null) && (Md_Car_Temp.getTempCar().car_ywcjyxm.contains("F1")))
                {
                  Toast.makeText(CarLoginActivity.this, "��ۼ������ύ������������������....", 0).show();
                  Application_Activity.goToActivity(CarLoginActivity.this, Pzlx_Activity.class);
                  CarLoginActivity.this.finish();
                }
              }
              else
                return;
              if ("�Ĵ�".equals(Md_system.dq))
              {
                if (CarLoginActivity.this.isRGWJ)
                {
                  Application_Activity.goToActivity(CarLoginActivity.this, CarPeople_Item_Activity.class);
                  CarLoginActivity.this.finish();
                  return;
                }
                Toast.makeText(CarLoginActivity.this, "��û�����Ȩ��", 0).show();
                return;
              }
              Application_Activity.goToActivity(CarLoginActivity.this, CarPeople_Item_Activity.class);
              CarLoginActivity.this.finish();
            }
          }
          , null);
        }
      }
      else if ("18Q46".equals(paramString))
      {
        this.submitBtn.setEnabled(true);
        HashMap localHashMap2 = (HashMap)paramObject;
        if ((!((String)localHashMap2.get("code")).equals("0")) && (!((String)localHashMap2.get("code")).equals("$EE")))
          if (Md_system.getSfhj().equals("��"))
          {
            if (Md_system.getSfgxjyxm().equals("��"))
              this.loginModel.setJYXMItemsData(localHashMap2, 3);
          }
          else if (Md_system.getSfgxjyxm().equals("��"))
            this.loginModel.setJYXMItemsData(localHashMap2, 2);
      }
      else if ("18C49".equals(paramString))
      {
        Md_Car_Temp.isQuery = true;
        this.queryBtn.setEnabled(true);
        localHashMap1 = (HashMap)paramObject;
        if (!((String)localHashMap1.get("code")).equals("1"))
        {
          DefautDialog.showDialog(this, getResources().getString(2131230796), (String)localHashMap1.get("message"), Boolean.valueOf(false), null, null);
          this.queryTime = 3;
          this.handler.post(this.task);
          return;
        }
        localHashMap1.put("dlysfzh", Md_Car_Temp.getTempCar().jyysfzh);
        this.loginModel.setItemsData(localHashMap1);
        if (Md_system.getSfhj().equals("��"))
          if (Md_system.getSfgxjyxm().equals("��"))
          {
            this.loginModel.setShow(4, true);
            this.loginModel.setShow(3, true);
          }
      }
    }
    while (true)
    {
      String str1 = (String)localHashMap1.get("syr");
      label1008: String str2;
      label1033: Object localObject;
      if ((str1.indexOf("<<") != -1) && (str1.indexOf(">>") != -1))
      {
        this.syr.setData(str1.replace("<<", "��").replace(">>", "��"));
        if (!"1".equals((String)localHashMap1.get("sfmj")))
          break label1412;
        str2 = "\n�ó�δ�����������Ч��";
        localObject = "";
        String str3 = (String)localHashMap1.get("zt");
        Md_Car_Temp.getTempCar().zt = str3;
      }
      try
      {
        char[] arrayOfChar1 = Md_Car_Temp.getTempCar().zt.trim().toCharArray();
        if (arrayOfChar1.length > 0)
        {
          int i = arrayOfChar1.length;
          for (int j = 0; j < i; j++)
          {
            char[] arrayOfChar2 = { arrayOfChar1[j] };
            String str4 = new String(arrayOfChar2);
            String str5 = (String)localObject + (String)Md_Car_Temp.getTempCar().mapwz.get(str4) + "\n";
            localObject = str5;
          }
          this.loginModel.setShow(3, true);
          continue;
          if (Md_system.getSfgxjyxm().equals("��"))
          {
            this.loginModel.setShow(3, true);
            this.loginModel.setShow(2, true);
            continue;
          }
          this.loginModel.setShow(2, true);
          continue;
          if (str1.indexOf("<<") != -1)
          {
            this.syr.setData(str1.replace("<<", "��"));
            break label1008;
          }
          if (str1.indexOf(">>") != -1)
          {
            this.syr.setData(str1.replace(">>", "��"));
            break label1008;
          }
          if ((str1.indexOf("<") != -1) && (str1.indexOf(">") != -1))
          {
            this.syr.setData(str1.replace("<", "��").replace(">", "��"));
            break label1008;
          }
          if (str1.indexOf("<") != -1)
          {
            this.syr.setData(str1.replace("<", "��"));
            break label1008;
          }
          if (str1.indexOf(">") == -1)
            break label1008;
          this.syr.setData(str1.replace(">", "��"));
          break label1008;
          label1412: str2 = "";
          break label1033;
        }
        localObject = "��Υ����Ϣ";
        this.WZItem.setData(((String)localObject).trim());
        if ((localHashMap1.get("yxqz") == null) || (isInYXQZ((String)localHashMap1.get("yxqz"))))
        {
          DefautDialog.showDialog(this, "ϵͳ��ʾ��", (String)localObject + str2, Boolean.valueOf(false), new DefautDialog.OnClickListener()
          {
            public void onClick(DefautDialog paramAnonymousDefautDialog, View paramAnonymousView)
            {
              paramAnonymousDefautDialog.dimiss();
              if (Md_system.getSfgxjyxm().equals("��"))
                CarLoginActivity.this.getJYXM();
            }
          }
          , null);
          return;
        }
        DefautDialog.showDialog(this, "ϵͳ��ʾ��", (String)localObject + str2 + "\n�˳�δ���쳵����Ч��", Boolean.valueOf(false), new DefautDialog.OnClickListener()
        {
          public void onClick(DefautDialog paramAnonymousDefautDialog, View paramAnonymousView)
          {
            paramAnonymousDefautDialog.dimiss();
            if (Md_system.getSfgxjyxm().equals("��"))
              CarLoginActivity.this.getJYXM();
          }
        }
        , null);
        return;
        if ("01Q03".equals(paramString))
        {
          this.submitBtn.setEnabled(true);
          List localList1 = (List)paramObject;
          if (localList1 != null)
          {
            if (!((Md_Car_TongYong)localList1.get(0)).code.equals("1"))
            {
              DefautDialog.showDialog(this, "ϵͳ��ʾ", ((Md_Car_TongYong)localList1.get(0)).message, Boolean.valueOf(false), null, null);
              return;
            }
            DefautDialog.showDialog(this, "ϵͳ��ʾ", ((Md_Car_TongYong)localList1.get(0)).message, Boolean.valueOf(false), new DefautDialog.OnClickListener()
            {
              public void onClick(DefautDialog paramAnonymousDefautDialog, View paramAnonymousView)
              {
                if (Md_Car_Temp.getTempCar().isAJHJFlag)
                {
                  if (Md_Car_Temp.getTempCar().isFlagToPicTrue)
                  {
                    Intent localIntent2 = new Intent();
                    localIntent2.setClass(CarLoginActivity.this, HBYJActivity.class);
                    localIntent2.putExtra("from", CarLoginActivity.this.from);
                    localIntent2.putExtra("TAG", CarLoginActivity.this.from);
                    localIntent2.putExtra("LCB", CarLoginActivity.this.lcbds.getData());
                    CarLoginActivity.this.startActivity(localIntent2);
                    CarLoginActivity.this.finish();
                    return;
                  }
                  Intent localIntent3 = new Intent();
                  localIntent3.setClass(CarLoginActivity.this, ANandHJProjectActivity.class);
                  localIntent3.putExtra("from", CarLoginActivity.this.from);
                  localIntent3.putExtra("TAG", CarLoginActivity.this.from);
                  localIntent3.putExtra("LCB", CarLoginActivity.this.lcbds.getData());
                  CarLoginActivity.this.startActivity(localIntent3);
                  CarLoginActivity.this.finish();
                  return;
                }
                if ("��".equals(Md_system.qzyjspiner))
                {
                  Intent localIntent1 = new Intent();
                  localIntent1.setClass(CarLoginActivity.this, HBYJActivity.class);
                  localIntent1.putExtra("from", CarLoginActivity.this.from);
                  localIntent1.putExtra("TAG", CarLoginActivity.this.from);
                  localIntent1.putExtra("LCB", CarLoginActivity.this.lcbds.getData());
                  CarLoginActivity.this.startActivity(localIntent1);
                  CarLoginActivity.this.finish();
                  return;
                }
                Md_Car_Temp.zdy = false;
                Md_Car_Temp.topaizhao = "0";
                Md_Car_Temp.hjsfbpzp = "1";
                Application_Activity.goToActivity(CarLoginActivity.this, HjpzlxActivity.class);
                CarLoginActivity.this.finish();
              }
            }
            , null);
            return;
          }
          DefautDialog.showDialog(this, getResources().getString(2131230796), "��������ʧ��", Boolean.valueOf(false), null, null);
        }
        return;
      }
      catch (Exception localException2)
      {
        while (true)
          localObject = "��Υ����Ϣ";
      }
    }
  }

  public void registerBoradcastReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("ATION_CHECK");
    registerReceiver(this.mBroadcastReceiver, localIntentFilter);
  }
}
*/
