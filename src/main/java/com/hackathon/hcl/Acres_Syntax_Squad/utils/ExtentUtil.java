package com.hackathon.hcl.Acres_Syntax_Squad.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentUtil {

    private static ExtentReports extent;

    // Get Extent Report Instance
    public static ExtentReports getReportInstance() {

        if (extent == null) {

            // Timestamp for unique report name
            String timestamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss")
                            .format(new Date());

            // Report Path
            String reportPath =
                    "reports/ExtentReport_" + timestamp + ".html";

            // Spark Reporter
            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            // Report Name
            sparkReporter.config().setReportName(
                    "99Acres Automation Report"
            );

            // Document Title
            sparkReporter.config().setDocumentTitle(
                    "Automation Test Results"
            );

            // Extent Report Object
            extent = new ExtentReports();

            // Attach Reporter
            extent.attachReporter(sparkReporter);

            // System Information
            extent.setSystemInfo("Project Name",
                    "99Acres Automation Framework");

            extent.setSystemInfo("Tester",
                    "Syntax Squad");

            extent.setSystemInfo("Environment",
                    "QA");

            extent.setSystemInfo("Browser",
                    ConfigReader.getBrowser());
        }

        return extent;
    }
}