package Utility;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MyReportBuilder {

    @Test
    public void build(){
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber-reports/cucumber01.json");
        jsonFiles.add("target/cucumber-reports/cucumber02.json");
        jsonFiles.add("target/cucumber-reports/cucumber03.json");
        //jsonFiles.add("cucumber-report-2.json");

        String buildNumber = "1";
        String projectName = "Cucumber";
        boolean runWithJenkins = false;

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        // optional configuration - check javadoc
        configuration.setRunWithJenkins(runWithJenkins);
        configuration.setBuildNumber(buildNumber);
        // addidtional metadata presented on main page
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "Chorme");
        configuration.addClassifications("Branch", "release/1.0");

        // optionally add metadata presented on main page via properties file
        List<String> classificationFiles = new ArrayList<>();
        //classificationFiles.add("properties-1.properties");
        //classificationFiles.add("properties-2.properties");
        configuration.addClassificationFiles(classificationFiles);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
        // and here validate 'result' to decide what to do if report has failed

    }
}
