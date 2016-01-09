package com.monkey77.entities;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;



/**
 * TGood entity. @author MyEclipse Persistence Tools
 */

public class TGood  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private TCategory TCategory;
     private TShowPic TShowPic;
     private String name;
     private Float price;
     private Short number;
     private String status;
     private String specification;
     private String originPlace;
     private String title;
     private String picUrl;
     private Integer saleVolume;
     private String edibleMethod;
     private String storage;
     private Set TUsers = new HashSet(0);
     private Set TProductPics = new HashSet(0);
     private Set TOrderDetails = new HashSet(0);
     private Set TCarts = new HashSet(0);


    // Constructors

    /** default constructor */
    public TGood() {
    }

	public TGood(Integer id) {
		super();
		this.id = id;
	}

	/** minimal constructor */
    public TGood(String name, Float price, Short number, String status, String specification, String originPlace, String title, Integer saleVolume) {
        this.name = name;
        this.price = price;
        this.number = number;
        this.status = status;
        this.specification = specification;
        this.originPlace = originPlace;
        this.title = title;
        this.saleVolume = saleVolume;
    }
    
    /** full constructor */
    public TGood(TCategory TCategory, String name, Float price, Short number, String status, String specification, String originPlace, String title, String picUrl, Integer saleVolume, String edibleMethod, String storage, Set TShops, Set TUsers, Set TProductPics, Set TOrderDetails, Set TCarts) {
        this.TCategory = TCategory;
        this.name = name;
        this.price = price;
        this.number = number;
        this.status = status;
        this.specification = specification;
        this.originPlace = originPlace;
        this.title = title;
        this.picUrl = picUrl;
        this.saleVolume = saleVolume;
        this.edibleMethod = edibleMethod;
        this.storage = storage;
        this.TUsers = TUsers;
        this.TProductPics = TProductPics;
        this.TOrderDetails = TOrderDetails;
        this.TCarts = TCarts;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    @JSON(serialize=false)
    public TCategory getTCategory() {
        return this.TCategory;
    }
    @JSON(serialize=false)
    public TShowPic getTShowPic() {
		return TShowPic;
	}

	public void setTShowPic(TShowPic tShowPic) {
		TShowPic = tShowPic;
	}

	public void setTCategory(TCategory TCategory) {
        this.TCategory = TCategory;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return this.price;
    }
    
    public void setPrice(Float price) {
        this.price = price;
    }

    public Short getNumber() {
        return this.number;
    }
    
    public void setNumber(Short number) {
        this.number = number;
    }

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecification() {
        return this.specification;
    }
    
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getOriginPlace() {
        return this.originPlace;
    }
    
    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return this.picUrl;
    }
    
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getSaleVolume() {
        return this.saleVolume;
    }
    
    public void setSaleVolume(Integer saleVolume) {
        this.saleVolume = saleVolume;
    }

    public String getEdibleMethod() {
        return this.edibleMethod;
    }
    
    public void setEdibleMethod(String edibleMethod) {
        this.edibleMethod = edibleMethod;
    }

    public String getStorage() {
        return this.storage;
    }
    
    public void setStorage(String storage) {
        this.storage = storage;
    }
    @JSON(serialize=false)
    public Set getTUsers() {
        return this.TUsers;
    }
    
    public void setTUsers(Set TUsers) {
        this.TUsers = TUsers;
    }
    
    @JSON(serialize=false)
    public Set getTProductPics() {
        return this.TProductPics;
    }
  
    public void setTProductPics(Set TProductPics) {
        this.TProductPics = TProductPics;
    }
    @JSON(serialize=false)
    public Set getTOrderDetails() {
        return this.TOrderDetails;
    }
  
    public void setTOrderDetails(Set TOrderDetails) {
        this.TOrderDetails = TOrderDetails;
    }
    @JSON(serialize=false)
    public Set getTCarts() {
        return this.TCarts;
    }
  
    public void setTCarts(Set TCarts) {
        this.TCarts = TCarts;
    }

	@Override
	public String toString() {
		return "TGood [id=" + id +", name="
				+ name + ", price=" + price + ", number=" + number
				+ ", status=" + status + ", specification=" + specification
				+ ", originPlace=" + originPlace + ", title=" + title
				+ ", picUrl=" + picUrl + ", saleVolume=" + saleVolume
				+ ", edibleMethod=" + edibleMethod + ", storage=" + storage
				+"]";
	}


   








}