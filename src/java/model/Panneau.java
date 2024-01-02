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
public class Panneau {
    private int idPanneau;
    private String marque;
    private Unite unite;
    private double puissance;

    public double getPuissance() {
        return puissance;
    }

    public void setPuissance(double puissance)throws Exception {
        if(puissance>=0)
        {
            this.puissance = puissance;
        }
        else{
            throw new Exception("La puissance doit etre positive ou null");
        }
    }
    public void setPuissance(String puissance) throws Exception{
        try
        {
           double qtt=Double.valueOf(puissance);
           this.setPuissance(qtt);
        }
        catch(Exception e){
            throw new Exception("puissance panneau invalide");
        }
    }

    public Panneau() {
    }

    public int getIdPanneau() {
        return idPanneau;
    }

    public void setIdPanneau(int idPanneau)throws Exception {
        if(idPanneau<=0)
        {
            throw new Exception("id panneau doit etre positif");
        }
        else{
            this.idPanneau = idPanneau;
        }
    }
    
    public void setIdPanneau(String idPanneau)throws Exception {
        try{
            int id=Integer.valueOf(idPanneau);
            this.setIdPanneau(id);
        }
        catch(Exception e)
        {
            throw new Exception("Id panneau invalide");
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
    public Panneau(int idPanneau, String marque, Unite unite, double puissance) throws Exception{
        this.setIdPanneau(idPanneau);
        this.setMarque(marque);
        this.setUnite(unite);
        this.setPuissance(puissance);
    }
    
    public double puissancePanneau(Luminosite l) throws Exception
    {
        double pourcentage=l.getLuminosite()*10;
        double puissance=(this.getPuissance()*pourcentage)/100;
        //System.out.println(puissance);
        return puissance;
    }
    
        
}
