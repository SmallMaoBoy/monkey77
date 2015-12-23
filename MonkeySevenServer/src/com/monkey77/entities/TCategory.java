package com.monkey77.entities;

import java.util.HashSet;
import java.util.Set;


/**
 * TCategory entity. @author MyEclipse Persistence Tools
 */

public class TCategory  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Set TGoods = new HashSet(0);


    // Constructors

    /** default constructor */
    public TCategory() {
    }

	/** minimal constructor */
    public TCategory(String name) {
        this.name = name;
    }
    
    /** full constructor */
    public TCategory(String name, Set TGoods) {
        this.name = name;
        this.TGoods = TGoods;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set getTGoods() {
        return this.TGoods;
    }
    
    public void setTGoods(Set TGoods) {
        this.TGoods = TGoods;
    }
   








}