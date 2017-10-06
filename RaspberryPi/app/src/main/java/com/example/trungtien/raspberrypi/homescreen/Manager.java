package com.example.trungtien.raspberrypi.homescreen;

/**
 * Created by trungtien on 10/1/17.
 */

public class Manager {
    public static final String SAVE_PASS = "SAVE_PASS";
    public static final String SAVE_HOST = "SAVE_HOST";

    public static final String POST_URL = "http://192.168.1.10/~trungtien/register.php";
    public static final String URL_TEST = "http://192.168.1.10/~trungtien/phpinfo.php";

    public static String getURL() {
        return POST_URL;
    }
}
