/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ccos.utils;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.ReportEngine;

/**
 *
 * @author shand
 */
public class ReportGenerator {
    
    private String rptDesign = "C:/Users/shand/Projects/NetBeansProjects/CCOS/web/assets/ccos.rptdesign";
    public String outputFile = "C:/Users/shand/Projects/NetBeansProjects/CCOS/web/assets/pdf/ccos-output.pdf";
    private EngineConfig config;
    private ReportEngine engine;
    
    public ReportGenerator() {
        init();
    }
    
    public void init() {
        config = new EngineConfig();
        engine = new ReportEngine(config);
    }
    public void close() {
       engine.destroy(); 
    }
    
    public void generateReport(Integer month, Integer year) throws BirtException {
        // Open the report design
        IReportRunnable design = null;
        design = engine.openReportDesign(rptDesign);
        IRunAndRenderTask task = engine.createRunAndRenderTask(design);
        
        // Set Parameters
        task.setParameterValue("month", month);
        task.setParameterValue("year", year);
        task.validateParameters();
        
        HTMLRenderOption HTML_OPTIONS = new HTMLRenderOption();
        HTML_OPTIONS.setOutputFileName(outputFile);
        HTML_OPTIONS.setOutputFormat("pdf");

        task.setRenderOption(HTML_OPTIONS);

        task.run();
        task.close();
    }
    
}
