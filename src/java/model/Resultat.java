/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;

/**
 *
 * @author Antsa
 */
public class Resultat {
    private Time heureCoupure;
    private double consommation;
    private double luminosite;
    private double panneau;
    private double batterie;
    private double consommationUnit;

    public Time getHeureCoupure() {
        return heureCoupure;
    }

     public void setHeureCoupure(Time heureCoupure)throws Exception {
        if(heureCoupure==null)
        {
            throw new Exception("L'heure de coupure du resultat ne peut pas etre null");
        }else{
            this.heureCoupure = heureCoupure;
        }
    }
    
    public void setHeureCoupure(String heureCoupure)throws Exception
    {
        if(heureCoupure.equals(""))
        {
            throw new Exception("L'heure de coupure du resultat ne peut pas etre null");
        }else{
            Time heure=Time.valueOf(heureCoupure);
            this.setHeureCoupure(heure);
        }
    }

    public double getConsommation() {
        return consommation;
    }

    public void setConsommation(double consommation)throws Exception {
        if(consommation>=0)
        {
            this.consommation = consommation;
        }
        else{
            throw new Exception("La consommation doit etre positive ou nulle");
        }
    }
    
    
    public void setConsommation(String consommation) throws Exception{
        try
        {
           double conso=Double.valueOf(consommation);
           this.setConsommation(conso);
        }
        catch(Exception e){
            throw new Exception("consommation invalide");
        }
    }

    public double getLuminosite() {
        return luminosite;
    }
    
    public void setLuminosite(double luminosite)throws Exception {
        if(luminosite>=0)
        {
            this.luminosite = luminosite;
        }
        else{
            throw new Exception("La luminosite doit etre positive ou nulle");
        }
    }
    
    
    public void setLuminosite(String luminosite)throws Exception {
        try
        {
           double lumin=Double.valueOf(luminosite);
           this.setLuminosite(lumin);
        }
        catch(Exception e){
            throw new Exception("luminosite invalide");
        }
    }

    public double getPanneau() {
        return panneau;
    }

    public void setPanneau(double panneau)throws Exception {
        if(panneau>=0)
        {
            this.panneau = panneau;
        }
        else{
            throw new Exception("La puissance du panneau doit etre positive ou nulle");
        }
    }
    
    
    public void setPanneau(String panneau)throws Exception {
        try
        {
           double pann=Double.valueOf(panneau);
           this.setPanneau(pann);
        }
        catch(Exception e){
            throw new Exception("puissance panneau invalide");
        }
    }


    public double getBatterie() {
        return batterie;
    }

    public void setBatterie(double batterie)throws Exception {
        if(batterie>=0)
        {
            this.batterie = batterie;
        }
        else{
            throw new Exception("La puissance de la batterie doit etre positive ou nulle");
        }
    }
    
    
    public void setBatterie(String batterie)throws Exception {
        try
        {
           double batt=Double.valueOf(batterie);
           this.setBatterie(batt);
        }
        catch(Exception e){
            throw new Exception("puissance batterie invalide");
        }
    }

    public double getConsommationUnit() {
        return consommationUnit;
    }

    public void setConsommationUnit(double conso)throws Exception {
        if(conso>=0)
        {
            this.consommationUnit = conso;
        }
        else{
            throw new Exception("La consommation unitaire doit etre positive ou nulle");
        }
    }
    
    
    public void setConsommationUnit(String conso)throws Exception {
        try
        {
           double c=Double.valueOf(conso);
           this.setConsommationUnit(c);
        }
        catch(Exception e){
            throw new Exception("consommation unitaire invalide");
        }
    }

    public Resultat(Time heureCoupure, double consommation, double luminosite, double panneau, double batterie, double consommationUnit) throws Exception{
        this.setHeureCoupure(heureCoupure);
        this.setConsommation(consommation);
        this.setLuminosite(luminosite);
        this.setPanneau(panneau);
        this.setBatterie(batterie);
        this.setConsommationUnit(consommationUnit);
    }

    public Resultat() {
    }
    
    
}
