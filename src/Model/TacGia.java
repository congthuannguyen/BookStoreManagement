/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author congt
 */
public class TacGia {
    
    public String maTG;
    public String tenTG;
    public String lienLac;
    
    
    public TacGia(){
        
    }

    public TacGia(String maTG, String tenTG, String lienLac) {
        this.maTG = maTG;
        this.tenTG = tenTG;
        this.lienLac = lienLac;
    }

    public String getMaTG() {
        return maTG;
    }

    public String getTenTG() {
        return tenTG;
    }

    public String getLienLac() {
        return lienLac;
    }

    public void setMaTG(String maTG) {
        this.maTG = maTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public void setLienLac(String lienLac) {
        this.lienLac = lienLac;
    }
}
