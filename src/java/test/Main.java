/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import connection.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import model.Classe;
import model.Coupure;
import model.Resultat;
import model.Source;

/**
 *
 * @author Antsa
 */
public class Main {
    public static void main(String args[]) {
        try {
            Connection con=Connexion.getConnect("");
            ArrayList<Coupure> coupe=Source.getAllCoupure("2024-01-03",con);
            
            for(Coupure co : coupe)
            {   
                Source sr=co.getSource();
                System.out.println("Source : "+sr.getNom() +" Matin => "+sr.getNbEleveMatin()+" Aprem => "+sr.getNbEleveAprem());
                System.out.println("Batterie : "+sr.getBatterie().getPuissance()+" | Panneau : "+sr.getPanneau().getPuissance());
                for(Classe c : sr.getClasses())
                {
                    System.out.println("Classe : "+c.getNom()+" Matin => "+c.getNbEleveMatin()+" Aprem => "+c.getNbEleveAprem());   
                }
                System.out.println("HEURE DE COUPURE => "+co.getHeureCoupure());
                
                
                for(int i=0;i<co.getCoupure().length;i++)
                {
                    Resultat r=co.getCoupure()[i];
                    System.out.println("Heure : "+r.getHeureCoupure()+" | Consommation : "+r.getConsommation()+" | Luminosite : "+r.getLuminosite()+" | Panneau : "+r.getPanneau()+" | Batterie : "+r.getBatterie()+" | Consommation Unitaire : "+r.getConsommationUnit());
                }
                System.out.println("");
            }
            /*Source s=new Source(5,con);
            Resultat r=s.getConsommation(Date.valueOf("2023-11-02"), con);
            System.out.println("consommation"+r.getConsommationUnit());
            con.close();*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
