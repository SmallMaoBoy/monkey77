package com.monkey77.entities;



/**
 * TOrderDetail entity. @author MyEclipse Persistence Tools
 */

public class TOrderDetail  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private TOrder TOrder;
     private TGood TGood;
     private Integer goodNumber;
     private Float goodPrice;

    // Constructors

    /** default constructor */
    public TOrderDetail() {
    }

    
    /** full constructor */
    public TOrderDetail(TOrder TOrder, TGood TGood, Integer goodNumber,Float goodPrice) {
        this.TOrder = TOrder;
        this.TGood = TGood;
        this.goodNumber = goodNumber;
        this.goodPrice=goodPrice;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public TOrder getTOrder() {
        return this.TOrder;
    }
    
    public void setTOrder(TOrder TOrder) {
        this.TOrder = TOrder;
    }

    public TGood getTGood() {
        return this.TGood;
    }
    
    public void setTGood(TGood TGood) {
        this.TGood = TGood;
    }

    public Integer getGoodNumber() {
        return this.goodNumber;
    }
    
    public void setGoodNumber(Integer goodNumber) {
        this.goodNumber = goodNumber;
    }


	public Float getGoodPrice() {
		return goodPrice;
	}


	public void setGoodPrice(Float goodPrice) {
		this.goodPrice = goodPrice;
	}


	@Override
	public String toString() {
		return "TOrderDetail [id=" + id + ", goodNumber=" + goodNumber
				+ ", goodPrice=" + goodPrice + "]";
	}


}