package com.monkey77.entities;

import org.apache.struts2.json.annotations.JSON;



/**
 * TProductPic entity. @author MyEclipse Persistence Tools
 */

public class TProductPic  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private TGood TGood;
     private String picUrl;
     private Short type;

    // Constructors

    public Short getType() {
		return type;
	}


	public void setType(Short type) {
		this.type = type;
	}


	/** default constructor */
    public TProductPic() {
    }

    
    /** full constructor */
    public TProductPic(TGood TGood, String picUrl) {
        this.TGood = TGood;
        this.picUrl = picUrl;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    @JSON(serialize=false)
    public TGood getTGood() {
        return this.TGood;
    }
    
    public void setTGood(TGood TGood) {
        this.TGood = TGood;
    }

    public String getPicUrl() {
        return this.picUrl;
    }
    
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }


	@Override
	public String toString() {
		return "TProductPic [id=" + id + ", picUrl=" + picUrl + ", type="
				+ type + "]";
	}
   








}