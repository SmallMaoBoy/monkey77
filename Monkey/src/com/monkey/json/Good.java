package com.monkey.json;

public class Good {
    private Integer id;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Short getNumber() {
		return number;
	}
	public void setNumber(Short number) {
		this.number = number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getOriginPlace() {
		return originPlace;
	}
	public void setOriginPlace(String originPlace) {
		this.originPlace = originPlace;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public Integer getSaleVolume() {
		return saleVolume;
	}
	public void setSaleVolume(Integer saleVolume) {
		this.saleVolume = saleVolume;
	}
	public String getEdibleMethod() {
		return edibleMethod;
	}
	public void setEdibleMethod(String edibleMethod) {
		this.edibleMethod = edibleMethod;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price
				+ ", number=" + number + ", status=" + status
				+ ", specification=" + specification + ", originPlace="
				+ originPlace + ", title=" + title + ", picUrl=" + picUrl
				+ ", saleVolume=" + saleVolume + ", edibleMethod="
				+ edibleMethod + ", storage=" + storage + "]";
	}

}
