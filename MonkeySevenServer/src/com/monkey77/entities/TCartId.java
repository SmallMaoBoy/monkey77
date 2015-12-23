package com.monkey77.entities;



/**
 * TCartId entity. @author MyEclipse Persistence Tools
 */

public class TCartId  implements java.io.Serializable {


    // Fields    

     private Integer userId;
     private Integer goodId;
     private Integer goodNumber;


    // Constructors

    /** default constructor */
    public TCartId() {
    }

    
    /** full constructor */
    public TCartId(Integer userId, Integer goodId, Integer goodNumber) {
        this.userId = userId;
        this.goodId = goodId;
        this.goodNumber = goodNumber;
    }

   
    // Property accessors

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodId() {
        return this.goodId;
    }
    
    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getGoodNumber() {
        return this.goodNumber;
    }
    
    public void setGoodNumber(Integer goodNumber) {
        this.goodNumber = goodNumber;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TCartId) ) return false;
		 TCartId castOther = ( TCartId ) other; 
         
		 return ( (this.getUserId()==castOther.getUserId()) || ( this.getUserId()!=null && castOther.getUserId()!=null && this.getUserId().equals(castOther.getUserId()) ) )
 && ( (this.getGoodId()==castOther.getGoodId()) || ( this.getGoodId()!=null && castOther.getGoodId()!=null && this.getGoodId().equals(castOther.getGoodId()) ) )
 && ( (this.getGoodNumber()==castOther.getGoodNumber()) || ( this.getGoodNumber()!=null && castOther.getGoodNumber()!=null && this.getGoodNumber().equals(castOther.getGoodNumber()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getUserId() == null ? 0 : this.getUserId().hashCode() );
         result = 37 * result + ( getGoodId() == null ? 0 : this.getGoodId().hashCode() );
         result = 37 * result + ( getGoodNumber() == null ? 0 : this.getGoodNumber().hashCode() );
         return result;
   }   





}