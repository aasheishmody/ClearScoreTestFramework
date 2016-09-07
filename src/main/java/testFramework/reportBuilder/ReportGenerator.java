package testFramework.reportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.ReportBuilder;

public class ReportGenerator {

    public static void main(String[] args) throws Throwable {

        ReportGenerator munger = new ReportGenerator();
        munger.mergeReports();
    }

    public void mergeReports() throws Exception {

        File reportOutputDirectory = new File((System.getProperty("user.dir")+"/target/cucumber-html-report"));
        List<String> jsonReportFiles = new ArrayList<String>();
        jsonReportFiles.add((System.getProperty("user.dir")+"/target/cucumber-report1.json"));
        jsonReportFiles.add((System.getProperty("user.dir")+"/target/cucumber-report2.json"));
        jsonReportFiles.add((System.getProperty("user.dir")+"/target/cucumber-report3.json"));
        String buildNumber = "1";
        String buildProjectName = "super_project";
        Boolean skippedFails = false;
        Boolean undefinedFails = false;
        Boolean flashCharts = true;
        Boolean runWithJenkins = true;
        ReportBuilder reportBuilder = new ReportBuilder(jsonReportFiles, reportOutputDirectory, "", "", "Test Report", false, false, true, true, false, "", false);
        reportBuilder.generateReports();
    }
}