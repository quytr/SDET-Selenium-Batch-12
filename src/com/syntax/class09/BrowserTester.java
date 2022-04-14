package com.syntax.class09;


import static com.syntax.util.CommonMethods.*;

public class BrowserTester {

    public static void main(String[] args) {

        openBrowser("https://www.amazon.com/");
        closeBrowser();

        openBrowser("https://www.facebook.com/");
        quitBrowser();
    }
}
