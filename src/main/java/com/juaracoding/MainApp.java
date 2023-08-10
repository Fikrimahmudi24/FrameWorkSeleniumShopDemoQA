package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.*;
import org.openqa.selenium.WebDriver;

public class MainApp {

    static WebDriver driver;

    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com/my-account/");

        //Akses Halaman Login
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        //Akses Halaman Dashboard & Masuk ke shop
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.dashboard();
        System.out.println("Akses Dashboard menuju Halaman Shop");

        //Halaman Shop dengan memilih baju oversized Pink
        ShopPage shopPage = new ShopPage();
        shopPage.shop();
        System.out.println("\n Berhasil Memilih Baju Oversized Pink");

        //Halaman Add to Cart dan Pemilihan warna dan ukuran baju
        ColorSizePage colorSizePage = new ColorSizePage();
        colorSizePage.colorsize();
        System.out.println("Berhasil ditambahkan/Add ke dalam Keranjangt/Cart");

        //Halaman produk yang sudah dimasukkan ke Cart
        ViewCartPage viewCartPage = new ViewCartPage();
        viewCartPage.viewcart();
        System.out.println("Silahkan Lihat produk terlebih dahulu pada halaman Cart");

        DriverSingleton.delay(50);
        DriverSingleton.closeObjectInstance();
    }
}