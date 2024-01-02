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

/**
 *
 * @author Antsa
 */
public class Classe {
    private int idClasse;
    private String nom;
    private double nbEleve;
    public static final Time debutMatin=new Time(8,0,0);
    public static final Time finMatin=new Time(12,0,0);
    public static final Time debutAprem=new Time(14,0,0);
    public static final Time finAprem=new Time(17,0,0);
    private double nbEleveMatin;
    private double nbEleveAprem;
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getNbEleve() {
        return nbEleve;
    }

    public void setNbEleve(double nbEleve)throws Exception {
         if(nbEleve>=0)
        {
            this.nbEleve = nbEleve;
        }
        else{
            throw new Exception("Le nombre d'eleve doit etre positive ou nulle");
        }
    }
    
     public void setNbEleve(String nbEleve)throws Exception {
        try
        {
           double qtt=Double.valueOf(nbEleve);
           this.setNbEleve(qtt);
        }
        catch(Exception e){
            throw new Exception("nombre d'eleve invalide");
        }
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) throws Exception{
        this.idClasse = idClasse;
        if(idClasse<=0)
        {
            throw new Exception("id classe doit etre positif");
        }
        else{
            this.idClasse = idClasse;
        }
    }
    
     public void setIdClasse(String idClasse) throws Exception{
        try{
            int id=Integer.valueOf(idClasse);
            this.setIdClasse(id);
        }
        catch(Exception e)
        {
            throw new Exception("Id classe invalide");
        }
    }

    public Classe(int idClasse) throws Exception{
        this.setIdClasse(idClasse);
    }

    public double getNbEleveMatin() {
        return nbEleveMatin;
    }

    public void setNbEleveMatin(double nbEleve)throws Exception {
         if(nbEleve>=0)
        {
            this.nbEleveMatin = nbEleve;
        }
        else{
            throw new Exception("Le nombre d'eleve matin doit etre positive ou nulle");
        }
    }
    
     public void setNbEleveMatin(String nbEleve)throws Exception {
        try
        {
           double qtt=Double.valueOf(nbEleve);
           this.setNbEleveMatin(qtt);
        }
        catch(Exception e){
            throw new Exception("nombre d'eleve matin invalide");
        }
    }
     
    public double getNbEleveAprem() {
        return nbEleveAprem;
    }

    public void setNbEleveAprem(double nbEleve)throws Exception {
         if(nbEleve>=0)
        {
            this.nbEleveAprem = nbEleve;
        }
        else{
            throw new Exception("Le nombre d'eleve apres-midi doit etre positive ou nulle");
        }
    }
    
     public void setNbEleveAprem(String nbEleve)throws Exception {
        try
        {
           double qtt=Double.valueOf(nbEleve);
           this.setNbEleveAprem(qtt);
        }
        catch(Exception e){
            throw new Exception("nombre d'eleve aprem invalide");
        }
    }
    
    public Classe(int idClasse, String nom, double nbEleve) throws Exception{
        this.setIdClasse (idClasse);
        this.setNom(nom);
        this.setNbEleve ( nbEleve);
    }
    
    public Classe() {
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public double getNbMoy(Date d,String dj,Connection con) throws Exception
    {
        double nb=0;
        Statement st = null;
        ResultSet res = null;
        int jour=Source.getJour(d);
        int co=0;
        if(con==null)
        {
            con=Connexion.getConnect("postgres");
            co=1;
        }
        try{
            String requete="";
            if(dj.equalsIgnoreCase("matin"))
            {
            requete = "select avg(nbeleve) as nb from presence where idclasse="+this.getIdClasse()+" and extract(dow from datepresence::date)="+jour+" and heuredebut>='"+this.debutMatin+"' and heurefin<='"+this.finMatin+"' and datepresence<='"+d+"'";   
            }
            else{
                requete ="select avg(nbeleve) as nb from presence where idclasse="+this.getIdClasse()+" and extract(dow from datepresence::date)="+jour+" and heuredebut>='"+this.debutAprem+"' and heurefin<='"+this.finAprem+"' and datepresence<='"+d+"'";  
            }
            //System.out.println(requete);
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
                nb=Classe.arrondir(res.getDouble("nb"));
                if(dj.equalsIgnoreCase("matin")) this.setNbEleveMatin(nb);
                else this.setNbEleveAprem(nb);
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
        return nb;
    }
    
    public double getNb(Date d,String dj,Connection con) throws Exception
    {
        double nb=0;
        Statement st = null;
        ResultSet res = null;
        int co=0;
        if(con==null)
        {
            con=Connexion.getConnect("postgres");
            co=1;
        }
        try{
            String requete="";
            if(dj.equalsIgnoreCase("matin"))
            {
            requete = "select nbeleve from presence where idclasse="+this.getIdClasse()+" and heuredebut>='"+this.debutMatin+"' and heurefin<='"+this.finMatin+"' and datepresence='"+d+"'";   
            }
            else{
                requete ="select nbeleve from presence where idclasse="+this.getIdClasse()+" and heuredebut>='"+this.debutAprem+"' and heurefin<='"+this.finAprem+"' and datepresence='"+d+"'";  
            }
            //System.out.println(requete);
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
              nb=Classe.arrondir(res.getDouble("nbeleve"));
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
        return nb;
    }
    
    public static double arrondir(double nombre) {
        double partieDecimale = nombre - (int) nombre;

        if (partieDecimale >= 0.5) {
            return Math.ceil(nombre);
        } else {
            return Math.floor(nombre);
        }
    }
}
