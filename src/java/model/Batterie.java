/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Antsa
 */
public class Batterie {
    private int idBatterie;
    private String marque;
    private Unite unite;
    private double puissance;
    private static final double seuil=50;

    public double getPuissance() {
        return puissance;
    }

    public void setPuissance(double puissance)throws Exception {
        this.puissance = puissance;
        if(puissance>=0)
        {
            this.puissance = puissance;
        }
        else{
            throw new Exception("La puissance doit etre positive ou nulle");
        }
    }
    
    
    public void setPuissance(String puissance) throws Exception{
        try
        {
           double puis=Double.valueOf(puissance);
           this.setPuissance(puis);
        }
        catch(Exception e){
            throw new Exception("puissance invalide");
        }
    }

    public double getSeuil() {
        return seuil;
    }

    public int getIdBatterie() {
        return idBatterie;
    }

    public void setIdBatterie(int idBatterie) throws Exception{
        if(idBatterie<=0)
        {
            throw new Exception("id batterie doit etre positif");
        }
        else{
            this.idBatterie = idBatterie;
        }
    }
    
    public void setIdBatterie(String idBatterie) throws Exception{
        try{
            int id=Integer.valueOf(idBatterie);
            this.setIdBatterie(id);
        }
        catch(Exception e)
        {
            throw new Exception("Id batterie invalide");
        }
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) throws Exception{
        if(unite!=null){
            this.unite = unite;
        }else{
            throw new Exception("unite null");
        }
    }

    public Batterie(int idBatterie, String marque, Unite unite, double puissance)throws Exception {
        this.setIdBatterie(idBatterie);
        this.setMarque(marque);
        this.setUnite(unite);
        this.setPuissance(puissance);
    }
    public Batterie() {
    }
}
