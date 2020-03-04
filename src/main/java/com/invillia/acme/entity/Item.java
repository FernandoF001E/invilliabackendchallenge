package com.invillia.acme.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITM_SEQ")
    @SequenceGenerator(sequenceName = "item_seq", allocationSize = 1, name = "ITM_SEQ")
    private long itemid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "purchaseorderid", referencedColumnName = "purchaseorderid", updatable = false)
	private PurchaseOrder purchaseOrder;
	
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private Double unitprice;
    
    @Column(nullable = false)
    private Double quantity;

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public long getId() {
		return itemid;
	}

	public void setId(long id) {
		this.itemid = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	
	public Item() { }

    public Item(long id)
    {
        this.itemid = id;
    }
}
