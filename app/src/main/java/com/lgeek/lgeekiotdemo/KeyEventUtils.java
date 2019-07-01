package com.lgeek.lgeekiotdemo;


import android.view.KeyEvent;

public class KeyEventUtils {
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
//PAGEDOWN   下一页          ， PAGEUP 上一页
    public static final String KEYCODE_OK="OK";
    public static final String KEYCODE_UP ="UP";
    public static final String KEYCODE_DOWN="DOWN";
    public static final String KEYCODE_LEFT ="LEFT";
    public static final String KEYCODE_RIGHT="RIGHT";
    public static final String KEYCODE_VUP ="VUP";
    public static final String KEYCODE_VDOWN="VDOWN";
    public static final String KEYCODE_MUTE ="MUTE";
    public static final String KEYCODE_BACK="BACK";
    public static final String KEYCODE_HOME ="HOME";
    public static final String KEYCODE_CANCEL="CANCEL";
    public static final String KEYCODE_PAGEDOWN = "PAGEDOWN";
    public static final String KEYCODE_PAGEUP = "PAGEUP";
    public static int getKeyEventCodeByNumber(int number) {

        int ret=-1;
        switch (number) {
            case 0:
                ret= KeyEvent.KEYCODE_0;
                break;
            case 1:
                ret= KeyEvent.KEYCODE_1;
                break;
            case 2:
                ret= KeyEvent.KEYCODE_2;
                break;
            case 3:
                ret= KeyEvent.KEYCODE_3;
                break;
            case 4:
                ret= KeyEvent.KEYCODE_4;
                break;
            case 5:
                ret= KeyEvent.KEYCODE_5;
                break;
            case 6:
                ret= KeyEvent.KEYCODE_6;
                break;
            case 7:
                ret= KeyEvent.KEYCODE_7;
                break;
            case 8:
                ret= KeyEvent.KEYCODE_8;
                break;
            case 9:
                ret= KeyEvent.KEYCODE_9;
                break;

            default:
                break;
        }


        return ret;

    }

    public static int getKeyEventCodeByStringKey(String key) {
        int ret=-1;
        switch (key) {
            case KEYCODE_OK:
                ret= KeyEvent.KEYCODE_ENTER;
                break;
            case KEYCODE_BACK:
                ret= KeyEvent.KEYCODE_BACK;
                break;
            case KEYCODE_CANCEL:
                ret= KeyEvent.KEYCODE_ESCAPE;
                break;
            case KEYCODE_DOWN:
                ret= KeyEvent.KEYCODE_DPAD_DOWN;
                break;
            case KEYCODE_LEFT:
                ret= KeyEvent.KEYCODE_DPAD_LEFT;
                break;
            case KEYCODE_RIGHT:
                ret= KeyEvent.KEYCODE_DPAD_RIGHT;
                break;
            case KEYCODE_UP:
                ret= KeyEvent.KEYCODE_DPAD_UP;
                break;
            case KEYCODE_MUTE:
                ret= KeyEvent.KEYCODE_MENU;
                break;
            case KEYCODE_VUP:
                ret= KeyEvent.KEYCODE_VOLUME_UP;
                break;
            case KEYCODE_VDOWN:
                ret= KeyEvent.KEYCODE_VOLUME_DOWN;
                break;
            case KEYCODE_HOME:
                ret= KeyEvent.KEYCODE_HOME;
                break;
            default:
                break;
        }
        return ret;

    }

    public static int getNumberBykeyEventCode(int keyEventCode) {
        int ret=-1;
        switch (keyEventCode) {
            case KeyEvent.KEYCODE_0:
                ret= 0;
                break;
            case KeyEvent.KEYCODE_1:
                ret= 1;
                break;
            case KeyEvent.KEYCODE_2:
                ret= 2;
                break;
            case KeyEvent.KEYCODE_3:
                ret= 3;
                break;
            case KeyEvent.KEYCODE_4:
                ret= 4;
                break;
            case KeyEvent.KEYCODE_5:
                ret= 5;
                break;
            case  KeyEvent.KEYCODE_6:
                ret=6;
                break;
            case KeyEvent.KEYCODE_7:
                ret= 7;
                break;
            case KeyEvent.KEYCODE_8:
                ret= 8;
                break;
            case  KeyEvent.KEYCODE_9:
                ret=9;
                break;
            default:
                break;
        }
        return ret;

    }
}
