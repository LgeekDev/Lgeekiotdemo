package com.lgeek.lgeekiotdemo;

import android.app.Application;
import android.content.Intent;

import com.lgeek.iot.parse.com.LgeekSdkMgr;
import com.lgeek.iot.parse.utils.LgeekIotUtils;

public class MyApp extends Application {
//    public static class LgeekConstants {
//        public static final String IOT_DEVICE_TYPE_0 = "11";
//        public static final String IOT_DEVICE_NAME_0 = "安卓网关";
//
//        public static final String IOT_DEVICE_TYPE_1 = "109";
//        public static final String IOT_DEVICE_NAME_1= "电视";
//
//        public static final String IOT_DEVICE_TYPE_2 = "4001";
//        public static final String IOT_DEVICE_NAME_2= "机第三方机顶盒";
//
//        public static final String IOT_DEVICE_TYPE_3 = "5001";
//        public static final String IOT_DEVICE_NAME_3= "逻辑机顶盒";
//
//        public static final String IOT_DEVICE_TYPE_4 = "5002";
//        public static final String IOT_DEVICE_NAME_4 = "带屏小微";
//
//        public static final String IOT_DEVICE_TYPE_5 = "5003";
//        public static final String IOT_DEVICE_NAME_5 = "带屏魔镜";
//
//        public static final String IOT_DEVICE_TYPE_6 = "5004";
//        public static final String IOT_DEVICE_NAME_6 = "酒店电视APP";
//
//        //udp
//        public static final String UDP_DEVICE_PREFIX = "00"; //LGWB
//
//    }
    @Override
    public void onCreate() {
        super.onCreate();
        /*
        * 参数1 ： 是否开启日志   参数2  是否输出日志到文件  ， 参数3  日志保存天数
        * */
        LgeekIotUtils.initLog(true, true, 3);// 需要 文件读取权限 8.0 动态权限厂家自己适配

        /**
         * @param application
         * @param deviceType 固定值
         * @param deviceTypeId 设备类型，4001为第三方机顶盒
         * @param deviceTypeName 设备名称 逻辑iot的时候需要用到该字段，可填写App或厂商的名字
         */
        LgeekSdkMgr.getInstance().init(this, "2", "4001", "机第三方机顶盒");
        // 开启服务
        getApplicationContext().startService(new Intent(this,IotService.class));
    }
}
