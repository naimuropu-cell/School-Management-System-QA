package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ConfigReader;

public class DomInspect extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void st() { setUp(); }

    @Test(groups = {"inspect"})
    public void inspectStudentList() {
        loginAsAdmin();
        String baseUrl = ConfigReader.getProperty("baseUrl");
        driver.get(baseUrl + "/student-list");
        sleep(4000);
        System.out.println("=== URL: " + driver.getCurrentUrl());
        System.out.println("=== TITLE: " + driver.getTitle());
        // Headings
        for (WebElement h : driver.findElements(By.cssSelector("h1,h2,h3,h4,h5,.page-title,.card-title,.card-header"))) {
            System.out.println("HEADING: <" + h.getTagName() + "> " + escape(h.getText()));
        }
        // Search boxes
        for (WebElement s : driver.findElements(By.cssSelector("input[type='search'],input[type='text'],input[type='search']"))) {
            System.out.println("INPUT name=" + attr(s,"name") + " id=" + attr(s,"id") + " placeholder=" + attr(s,"placeholder") + " type=" + attr(s,"type"));
        }
        // Tables
        for (WebElement t : driver.findElements(By.cssSelector("table"))) {
            System.out.println("--- TABLE id=" + attr(t,"id") + " class=" + attr(t,"class"));
            for (WebElement th : t.findElements(By.cssSelector("thead th,tr:first-child th"))) {
                System.out.println("    TH: " + escape(th.getText()) + " [class=" + attr(th,"class") + "]");
            }
        }
        // Pagination
        for (WebElement p : driver.findElements(By.cssSelector(".pagination,.dataTables_paginate,.paginate_button,.paging_simple_numbers,#student-table_paginate"))) {
            System.out.println("PAGINATION: <" + p.getTagName() + "> class=" + attr(p,"class") + " text=" + escape(p.getText()).substring(0, Math.min(120, escape(p.getText()).length())));
        }
        // Rows sample
        java.util.List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
        System.out.println("ROW COUNT: " + rows.size());
        if (!rows.isEmpty()) {
            System.out.println("ROW1 HTML sample: " + escape(rows.get(0).getText()).substring(0, Math.min(300, escape(rows.get(0).getText()).length())));
        }
        // Any anchor with view/show/detail
        int c=0;
        for (WebElement a : driver.findElements(By.cssSelector("a"))) {
            String txt = a.getText().trim();
            String href = a.getAttribute("href") == null ? "" : a.getAttribute("href");
            if (txt.toLowerCase().matches(".*(view|show|detail|profile|edit|eye).*") || href.matches(".*(view|show|detail|profile).*")) {
                System.out.println("ACTION-LINK: text=" + escape(txt) + " href=" + href + " class=" + attr(a,"class"));
                if (++c > 15) break;
            }
        }
    }

    private void sleep(long ms){ try { Thread.sleep(ms); } catch(Exception e){} }
    private String attr(WebElement e, String name){ String v = e.getAttribute(name); return v==null?"":v; }
    private String escape(String s){ if(s==null) return ""; return s.replace("\n"," | ").replace("\r",""); }
}
