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
public class Coupure {
    private Resultat[] coupure;
    private Source source;
    private Time heureCoupure;

    public Resultat[] getCoupure() {
        return coupure;
    }

    public void setCoupure(Resultat[] coupure) throws Exception{
        if(coupure!=null)
        {
            this.coupure = coupure;
        }
        else{
            throw new Exception("la liste des coupure ne peut pas etre null");
        }
    }


    public Source getSource() {
        return source;
    }

    public void setSource(Source source) throws Exception{
        if(source!=null)
        {
            this.source = source;
        }
        else{
            throw new Exception("La source ne devrait pas être null");
        }
    }

    public Time getHeureCoupure() {
        return heureCoupure;
    }

    public void setHeureCoupure(Time heureCoupure)throws Exception {
        if(heureCoupure==null)
        {
            throw new Exception("L'heure de coupure ne peut pas etre null");
        }else{
            this.heureCoupure = heureCoupure;
        }
        this.heureCoupure = heureCoupure;
    }
    
    public void setHeureCoupure(String heureCoupure)throws Exception
    {
        if(heureCoupure.equals(""))
        {
            throw new Exception("L'heure de coupure ne peut pas etre null");
        }else{
            Time heure=Time.valueOf(heureCoupure);
            this.setHeureCoupure(heure);
        }
    }

    public Coupure(Resultat[] coupure, Source source, Time heureCoupure) throws Exception{
        this.setCoupure(coupure);
        this.setSource(source);
        this.setHeureCoupure(heureCoupure);
    }
}
