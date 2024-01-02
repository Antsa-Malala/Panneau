/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Antsa
 */
public class Luminosite {
    private Date dateLuminosite;
    private int luminosite;
    private Time heureluminositedebut;
    private Time heureluminositefin;

    public Date getDateLuminosite() {
        return dateLuminosite;
    }

    public void setDateLuminosite(Date dateLuminosite) throws Exception{
        if(dateLuminosite==null)
        {
            throw new Exception("La date de luminosite ne peut pas etre null");
        }else{
            this.dateLuminosite = dateLuminosite;
        }
        this.dateLuminosite = dateLuminosite;
    }
    
    public void setDateLuminosite(String dateLuminosite) throws Exception
    {
        if(dateLuminosite.equals(""))
        {
            throw new Exception("La date de luminosite ne peut pas etre null");
        }else{
            Date daty=Date.valueOf(dateLuminosite);
            this.setDateLuminosite(daty);
        }
    }

    public int getLuminosite() {
        return luminosite;
    }

    public void setLuminosite(int luminosite) throws Exception{
        this.luminosite = luminosite;
        if(luminosite<=0)
        {
            throw new Exception("luminosite doit etre positif");
        }
        else{
            this.luminosite = luminosite;
        }
    }
    
    public void setLuminosite(String luminosite) throws Exception{
        try{
            int l=Integer.valueOf(luminosite);
            this.setLuminosite(l);
        }
        catch(Exception e)
        {
            throw new Exception("luminosite invalide");
        }
    }

    public Time getHeureluminositedebut() {
        return heureluminositedebut;
    }

    public void setHeureluminositedebut(Time heureluminositedebut) throws Exception{
        if(heureluminositedebut==null)
        {
            throw new Exception("L'heure de luminosite ne peut pas etre null");
        }else{
            this.heureluminositedebut = heureluminositedebut;
        }
    }
    
     public void setHeureluminositedebut(String heureluminositedebut) throws Exception{
        if(heureluminositedebut==null)
        {
            throw new Exception("L'heure de luminosite ne peut pas etre null");
        }else{
            Time heure=Time.valueOf(heureluminositedebut);
            this.setHeureluminositedebut(heure);
        }
    }
   

    public Time getHeureluminositefin() {
        return heureluminositefin;
    }
    
     public void setHeureluminositefin(Time heureluminositefin) throws Exception{
        if(heureluminositefin==null)
        {
            throw new Exception("L'heure de luminosite ne peut pas etre null");
        }else{
            this.heureluminositefin = heureluminositefin;
        }
    }
    
     public void setHeureluminositefin(String heureluminositefin) throws Exception{
        if(heureluminositefin==null)
        {
            throw new Exception("L'heure de luminosite ne peut pas etre null");
        }else{
            Time heure=Time.valueOf(heureluminositefin);
            this.setHeureluminositefin(heure);
        }
    }

    public Luminosite(Date dateLuminosite, int luminosite, Time heureluminositedebut, Time heureluminositefin) throws Exception{
        this.setDateLuminosite(dateLuminosite);
        this.setLuminosite (luminosite);
        this.setHeureluminositedebut (heureluminositedebut);
        this.setHeureluminositefin (heureluminositefin);
    }

    public Luminosite() {
    }

    public static Luminosite[] getLuminosite(Date d,Connection con)throws Exception
    {
        ArrayList<Luminosite> lum=new ArrayList<>();
        Luminosite[] luminosite=new Luminosite[0];
        Statement st = null;
        ResultSet res = null;
        int co=0;
        if(con==null)
        {
            con=Connexion.getConnect("postgres");
            co=1;
        }
        try{
            String requete = "select * from luminosite where dateLuminosite='"+d+"' order by heureLuminositeDebut asc";
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
                lum.add(new Luminosite(res.getDate("dateluminosite"),res.getInt("luminosite"),res.getTime("heureluminositedebut"),res.getTime("heureluminositefin")));
            }
            if(lum.isEmpty())
            {
                throw new Exception("Il n'y a pas de luminosite pour cette date");
            }
        }
        catch(Exception ex){
            throw ex;
        }
        finally{

            if( res != null ){
                res.close();
            }
            if(st != null ){
                st.close();
            }
            if(co==1)
            {
                con.close();
            }
        }
        return lum.toArray(luminosite);
    }
    
    public static Luminosite getLuminositeHeure(Date d,Time heureDebut,Time heureFin,Connection con)throws Exception
    {
        Luminosite l=new Luminosite();
        Statement st = null;
        ResultSet res = null;
        int co=0;
        if(con==null)
        {
            con=Connexion.getConnect("postgres");
            co=1;
        }
        try{
            String requete = "select * from luminosite where dateLuminosite='"+d+"' and heureLuminositeDebut<='"+heureDebut+"' and heureLuminositeFin>='"+heureFin+"'";
            //System.out.println(requete);
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
                l=new Luminosite(res.getDate("dateluminosite"),res.getInt("luminosite"),res.getTime("heureluminositedebut"),res.getTime("heureluminositefin"));
            }
            /*if(l==null)
            {
                throw new Exception("Il n'y a pas de luminosite pour cette date et cette heure");
            }*/
        }
        catch(Exception ex){
            throw ex;
        }
        finally{

            if( res != null ){
                res.close();
            }
            if(st != null ){
                st.close();
            }
            if(co==1)
            {
                con.close();
            }
        }
        return l;
    }
}
