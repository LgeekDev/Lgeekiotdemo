package com.lgeek.lgeekiotdemo;

import android.app.Instrumentation;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.view.KeyEvent;

import com.blankj.utilcode.util.EncryptUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lgeek.iot.parse.bean.TvDeviceAttr;
import com.lgeek.iot.parse.bean.tencent.TencentIotBaseBean;
import com.lgeek.iot.parse.callback.AbServiceCallBack;
import com.lgeek.iot.parse.com.LgeekSdkMgr;
import com.lgeek.iot.parse.utils.LogUtils;

import org.json.JSONObject;

public class IotService extends Service {
    private MsgHandler mMsgHandler = new MsgHandler();

    public IotService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        return START_STICKY;
    }

    @Override
    public void onCreate() {

        LgeekSdkMgr.getInstance().addListener(mMsgHandler);

        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LgeekSdkMgr.getInstance().removeListener(mMsgHandler);
    }


    private class MsgHandler extends AbServiceCallBack {
        public MsgHandler() {
            super();
        }

        @Override
        public void onReply(TencentIotBaseBean bean) {
            super.onReply(bean);
//            ToastUtils.showLong("腾讯消息:" + "\n消息类型：" + bean.getMsgType() + "\n消息内容:" + bean.getData().toString());
        }

        @Override
        public void onReply(int iotType, int msgType, String msgId, String msg, int ack) {
            super.onReply(iotType, msgType, msgId, msg, ack);
            String type = iotType == 1 ? "逻辑" : "腾讯";
//            ToastUtils.showLong(type + "消息:" + "\n消息类型：" + msgType + "\n消息内容:" + msg);
        }

        //收到消息回复      默认有回复   如果有特殊需求可以  去掉super   自定义回复
//        @Override
//        public void onReply(int msgType, String msgId, String msg, int ack) {
//            super.onReply(msgType, msgId, msg, ack);
//
////            String s="自定义回复";
////            LgeekSdkMgr.getInstance().publish(s);
//
//        }

        //服务端主动要求设备端上报设备状态   设备 状态 全量上报  当前设备状态上报   目前支持 电视

        @Override
        public void devConfigPortAll() {
            super.devConfigPortAll();
            reportTvStatus();
        }

        @Override
        public void devConfigPort() {
            super.devConfigPort();
        }

        @Override
        public void getDevConfig() {
            super.getDevConfig();
        }

        //好吃好玩 地图
        @Override
        public void recommend(int type) {
            super.recommend(type);
        }

        //机票
        @Override
        public void buyAirTickets(String url) {
            super.buyAirTickets(url);
        }

        //欢迎页面
        @Override
        public void welcome(String url) {
            super.welcome(url);
        }

        //火警
        @Override
        public void fire_alarm(String url) {
            super.fire_alarm(url);
        }


        //pms  入住
        @Override
        public void checkin(JSONObject check) {
            super.checkin(check);

        }

        //app 检测更新 服务端下发指令，要求客户端检测更新
        @Override
        public void appUpdate(String version) {
            super.appUpdate(version);
        }


        //打开电视
        @Override
        public void onTvPowerOn() {
            super.onTvPowerOn();
        }

        //关闭电视
        @Override
        public void onTvPowerOff() {
            super.onTvPowerOff();
        }

        //设置音量
        @Override
        public void onTvSetMediaVolume(String value) {
            super.onTvSetMediaVolume(value);
        }

        //静音
        @Override
        public void onTvAdjust_mute() {
            super.onTvAdjust_mute();
        }

        // 取消 静音
        @Override
        public void onTvAdjust_unmute() {
            super.onTvAdjust_unmute();
        }

        //信号源
        @Override
        public void onTvsetSwitchSignalSource(String value) {
            super.onTvsetSwitchSignalSource(value);

        }

        //打开直播
        @Override
        public void onLiveOpen() {
            super.onLiveOpen();
        }

        //切换直播频道  number  频道号
        @Override
        public void onLiveChangeChannel(int number) {
            super.onLiveChangeChannel(number);
        }

        //切换直播频道  number  频道号
        @Override
        public void onLiveChangeCode(String code) {
            super.onLiveChangeCode(code);
        }

        //打开特定的页面,type 代表一级，2级页面
        @Override
        public void onLiveOpen(String url, String type) {
            super.onLiveOpen(url, type);

            //下面是清鹤需要
            if ("MUSIC".equalsIgnoreCase(url)) {
//                   打开音乐界面

            }
//            音乐：MUSIC
//            投屏:AIRPLAY
//            酒店商城：HOTEL_SHOP(暂不支持单个商城界面跳转)
//            酒店介绍:HOTEL_INTRODUCE
//            手机遥控：MOBILE_CONTROL
//            返回导航界面：MENU
//            酒店服务界面：HOTEL_SERVICE
//            叫醒服务：MORNING_CALL
//            一键送物：LEASE_GOODS
        }

        //切换直播频道  number  频道号
        @Override
        public void onLiveChangeChannel(String name) {
            super.onLiveChangeChannel(name);
        }

        //下一频道
        @Override
        public void onLiveNextChannel() {
            super.onLiveNextChannel();
        }

        //上一频道
        @Override
        public void onLivePrevChannel() {
            super.onLivePrevChannel();
        }

        //点播
        @Override
        public void onBunchExecute(String json) {
            super.onBunchExecute(json);
        }

        //点播  我要看 战狼2   返回 contentId
        @Override
        public void onBunchPlayContentId(String contentId) {
            super.onBunchPlayContentId(contentId);
        }

        //点播 （我要看 刘德华电影）
        @Override
        public void onBunchShows(String item) {
            super.onBunchShows(item);
        }

        //模拟遥控器操作  action 对应 KeyEventUtils 里面值
        @Override
        public void onRemoteControllExecute(final String action) {

//            action=
            //    OK  确认
            //    UP   向上
            //    DOWN  向下
            //    LEFT 向左
            //    RIGHT  向右
            //    VUP  音量
            //    VDOWN  音量-
            //    MUTE  静音
            //    BACK  返回
            //    HOME  首页
            //    CANCEL  取消
            //    PAGEDOWN   下一页
            //    PAGEUP 上一页
//
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Instrumentation inst = new Instrumentation();
                    int keyEvent = KeyEventUtils.getKeyEventCodeByStringKey(action);
                    if (action.equalsIgnoreCase(KeyEventUtils.KEYCODE_HOME)) {

                        return;

                    }
                    if (action.equalsIgnoreCase(KeyEventUtils.KEYCODE_BACK)) {


                        return;
                    }
                    inst.sendKeyDownUpSync(keyEvent);

                }
            }).start();
            super.onRemoteControllExecute(action);
        }

        /**
         * 选择第几个
         *
         * @param value
         */
        @Override
        public void onChoose(int value) {
            super.onChoose(value);
        }

        //打开腾讯视频
        @Override
        public void openTencentVideo(String value) {
            super.openTencentVideo(value);
        }

        //好吃好玩 去第几个地方
        @Override
        public void goToPlace(JSONObject jsonpams) {
            super.goToPlace(jsonpams);
        }

        //腾讯iot中 通过包名打开特定APP
        @Override
        public void customAPP(String app_pg, String app_commend, String app_text) {
            super.customAPP(app_pg, app_commend, app_text);


            if ("com.ktcp.tvvideo".equalsIgnoreCase(app_pg)) {
                //腾讯视频vip
                if ("open".equalsIgnoreCase(app_commend)) {

                    try {
                        Intent intent = getPackageManager().getLaunchIntentForPackage(app_pg);
                        if (intent != null) {
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
//                            LogUtils.eTag(TAG, e.toString());
                    }

                } else if ("exit".equalsIgnoreCase(app_commend)) {
                    //退出腾讯视频
                } else {
                    try {
                        String uriString = "txaiagent://openintent?action=queryVoiceText&text=" + app_text;

                        String apiKey = "cb1fbdd4fec9e52ca3cd4b9b4dbe1c25";
                        String token = EncryptUtils.encryptHmacSHA1ToString(uriString.getBytes(), apiKey.getBytes());
                        Intent intent = new Intent();
                        intent.setData(Uri.parse(uriString));
                        intent.putExtra("token", token);
                        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                        IotService.this.sendBroadcast(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

        }

        //返回上一页
        @Override
        public void onBack542(JSONObject jsondata) {
            super.onBack542(jsondata);
        }

        //返回上一页
        @Override
        public void onBack541(JSONObject jsondata) {
            super.onBack541(jsondata);
        }

        //pms  入住推送
        @Override
        public void checkin(String checkin) {
            super.checkin(checkin);

        }

        //模拟按键输入
        @Override
        public void onSimulateKeyEvent(final String action) {
            // 返回Android 标准code
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        int keyEvent = Integer.parseInt(action);
                        Instrumentation inst = new Instrumentation();
                        switch (keyEvent) {
                            case KeyEvent.KEYCODE_HOME:

                                break;
                            case KeyEvent.KEYCODE_CHANNEL_UP:

                                onLivePrevChannel();
                                break;
                            case KeyEvent.KEYCODE_CHANNEL_DOWN:

                                onLiveNextChannel();

                                break;
                            case KeyEvent.KEYCODE_BACK:

                                break;
                            default:
                                break;
                        }

                        inst.sendKeyDownUpSync(keyEvent);
                    } catch (Exception e) {
                        e.printStackTrace();
                        LogUtils.eTag("", e.toString());
                    }
                }
            }).start();
            super.onSimulateKeyEvent(action);
        }

        //第三方厂家不用关心这个方法
        @Override
        public void on551IotReSetConfigs(JSONObject jsonObject) {
            super.on551IotReSetConfigs(jsonObject);
        }

//        @Override
//        public void startPage(String s) {
//
//        }
//
//        @Override
//        public void lightScreen(boolean b) {
//
//        }
//
//        @Override
//        public void clearData() {
//
//        }
    }


//信号源
//            obj.put("player", "1");
//            obj.put("vga", "2");
//            obj.put("hdmi", "3");
//            obj.put("dvd", "4");
//            obj.put("storage", "5");
//            obj.put("av", "6");
//            obj.put("atv", "7");
//            obj.put("dtv", "8");
//            obj.put("hdmi2", "9");
//            obj.put("hdmi3", "10");


    //反馈TV状态  设备状态变化时候用户主动上报
    private void reportTvStatus() {
        // 如果你电视设备可以拿到这些属性可以这样上报。
        TvDeviceAttr tvDeviceAttr = new TvDeviceAttr();
        tvDeviceAttr.setMute(1);//静音  0  or  1
        tvDeviceAttr.setPower(1);//开关   0  or  1
        tvDeviceAttr.setSwitchSignalSource("3");//视频源
        tvDeviceAttr.setVoice(50);//声音 0-100
//        TvDeviceAttrMgr.getInstance().reportDeviceAttr(tvDeviceAttr);//用户可以主动上报
    }

}
