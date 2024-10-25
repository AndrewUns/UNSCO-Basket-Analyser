/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Andrew Unsworth
 */

import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.associations.Apriori;
import weka.associations.AssociationRule;
import weka.associations.AssociationRules;
import weka.associations.Item;

import java.util.*;
import java.io.*;
import java.util.Collection;



public class BasketAnalyser {

private Vector collectedRules;
private final int numOfColumns = 8;
private ArffLoader loader = new ArffLoader();
private Instances data;
private AssociationRules allRules;
private List<AssociationRule> listedRules;
private Apriori apper = new Apriori();



    public BasketAnalyser() throws Exception {
        System.out.println("New BasketAnalyser instance created.");
            }
    
    public Object[][] getRules(String location) throws IOException, Exception {
        
        try {
            // open the file at the location passed as an argument
            loader.setFile(new File(location));
       } catch (IOException e) {
            System.out.println("An IOException occurred: " + e);
        }
        
        // get data from the file and create a set of instances
        data = loader.getDataSet();
        
        try {
            // Call Weka to generate rule associations using data from the file
            apper.buildAssociations(data);
        
        } catch (Exception e) {
            System.out.println("An Exception occurred: " + e);
        }
        
        allRules = apper.getAssociationRules();
        
        listedRules = allRules.getRules();
               
        collectedRules = new Vector(listedRules.size());
                
        for(int index = 0; index < listedRules.size(); index++) {
           AssociationRule singleRule = listedRules.get(index);
           Vector metrics = new Vector(numOfColumns);
           
           Collection<Item> premise = singleRule.getPremise();
           int premSupport = singleRule.getPremiseSupport();
           Collection<Item> consequence = singleRule.getConsequence();
           int conseqSupport = singleRule.getConsequenceSupport();
           double confidence = singleRule.getNamedMetricValue("Confidence");
           double lift = singleRule.getNamedMetricValue("Lift");
           double leverage = singleRule.getNamedMetricValue("Leverage");
           double conviction = singleRule.getNamedMetricValue("Conviction");
           
           metrics.add(premise.toString());
           metrics.add(premSupport + "");
           metrics.add(consequence.toString());
           metrics.add(conseqSupport + "");
           metrics.add(confidence + "");
           metrics.add(lift + "");
           metrics.add(leverage + "");
           metrics.add(conviction + "");
           collectedRules.add(metrics); 
           
            }
        Object[][] returnedMetrics = new Object[10][8];
        System.out.println("returnedMetrics length == " + returnedMetrics.length);
        System.out.println("returnedMetrics width == " + returnedMetrics[0].length);
        
        for(int index = 0; index < listedRules.size(); index++) {
            
            Vector metrics = (Vector) collectedRules.get(index);
            System.out.print("Metrics.size(): " + metrics.size());
            System.out.print("Rule " + index + ": ");
            for (int innerIndex = 0; innerIndex < metrics.size(); innerIndex++) {
                returnedMetrics[index][innerIndex] = (String) metrics.get(innerIndex);
                System.out.print(returnedMetrics[index][innerIndex] + " ");
            }
            System.out.println(" ");
        }
        
        
        try {
        System.out.println("Outputting returned returnedMetrics array:");
        for(int index = 0; index < 10;index++) {
            System.out.print("Rule " + index + ": ");
            for(int innerIndex = 0; innerIndex < 8; innerIndex++) {
                System.out.print(returnedMetrics[index][innerIndex] + " ");
                
                    }
            System.out.println(" ");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.toString());
                }
        return returnedMetrics;
           
}
}