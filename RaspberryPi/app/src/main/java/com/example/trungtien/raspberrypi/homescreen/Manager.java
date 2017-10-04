package com.example.trungtien.raspberrypi.homescreen;

/**
 * Created by trungtien on 10/1/17.
 */

public class Manager {
    public static final String SAVE_PASS = "SAVE_PASS";
    public static final String SAVE_HOST = "SAVE_HOST";

    public static final String URL_HOST = "http://192.168.1.10/";
    public static final String POST_URL = URL_HOST + "~trungtien/register.php";
    public static final String URL_TEST = URL_HOST + "~trungtien/phpinfo.php";
    private static String URL;

    public static void setURL(String URL) {
        Manager.URL = URL;
    }

    public static String getURL() {
        if (URL == null)
            URL = POST_URL;
        return URL;
    }
}
