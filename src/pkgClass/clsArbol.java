/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgClass;

/**
 *
 * @author Jose Restrepo G
 */
public class clsArbol {
    private clsNodo root;
    
    public clsArbol(){
        this.root = null;
    }
    
    public void insertar (clsNodo dato, clsNodo rootTmp){
        if(this.getRoot() == null){
            this.setRoot(dato);
        }else{ 
            if(dato.getNum()> rootTmp.getNum()){
                if(rootTmp.getDer() == null){
                    rootTmp.setDer(dato);
                }else{
                    insertar(dato, rootTmp.getDer());
                }
            }else{                
                if(dato.getNum() <= rootTmp.getNum()){
                    
                     if(rootTmp.getIzq() == null){                         
                        rootTmp.setIzq(dato);
                    }else{
                        insertar(dato, rootTmp.getIzq());
                    }
                }
            }
        }
    }
    
    public void listar(clsNodo rootTmp){
        if(rootTmp != null){                        
            System.out.println("Num: "+ rootTmp.getNum());             
            if(rootTmp.getDer() != null){ 
                listar(rootTmp.getDer());              
            }    
            if(rootTmp.getIzq() != null){
                listar(rootTmp.getIzq());                
            }             
        }        
    }
    
    public void preorden(clsNodo rootTmp){
        if(rootTmp != null){                        
            System.out.println("Num: "+ rootTmp.getNum()); 
            if(rootTmp.getIzq() != null){
                preorden(rootTmp.getIzq());                
            }             
            if(rootTmp.getDer() != null){ 
                preorden(rootTmp.getDer());              
            }             
        }        
    }
    
    public void inorden(clsNodo rootTmp){
        if(rootTmp != null){
            if(rootTmp.getIzq() != null){
                inorden(rootTmp.getIzq());                
            }                                    
            System.out.println("Num: "+ rootTmp.getNum()); 
            if(rootTmp.getDer() != null){ 
                inorden(rootTmp.getDer());              
            }             
        }        
    }
    
    public void posorden(clsNodo rootTmp){
        if(rootTmp != null){
            if(rootTmp.getIzq() != null){
                posorden(rootTmp.getIzq());                
            }             
            if(rootTmp.getDer() != null){ 
                posorden(rootTmp.getDer());              
            }                        
            System.out.println("Num: "+ rootTmp.getNum());             
        }        
    }
    
    public void buscarnumero(int dato){        
        clsNodo rootTmp = root;
        if(rootTmp != null){
            if(dato == rootTmp.getNum()){
                System.out.println("El número "+dato +" fue encontrado con éxito.");
            }else{
                while(dato != rootTmp.getNum()){
                    if(dato > rootTmp.getNum()){
                        rootTmp = rootTmp.getDer();                    
                    }else{                    
                        rootTmp = rootTmp.getIzq();
                    }
                    if(rootTmp == null){
                        System.out.println("El número "+dato +" no fue encontrado en el arbol.");
                        return;
                    }                
                }
                System.out.println("El número "+dato +" fue encontrado con éxito.");                
            }
        }else{
           System.out.println("El árbol no tiene nodos.");
        }        
    }
    
    public int altura(clsNodo rootTmp){
        int alt = 0;        
        if(rootTmp == null){
            return alt;
        }
        if(rootTmp.getDer() != null){
            alt = Math.max(alt, altura(rootTmp.getDer()));                                            
        }
        if(rootTmp.getIzq() != null){
            alt = Math.max(alt, altura(rootTmp.getIzq()));                                            
        }
        alt++;        
        return alt;
    }
    

    /**
     * @return the root
     */
    public clsNodo getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(clsNodo root) {
        this.root = root;
    }
}