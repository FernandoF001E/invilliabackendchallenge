package com.invillia.acme.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Purchaseorder")
public class PurchaseOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PUORD_SEQ")
    @SequenceGenerator(sequenceName = "purchaseorder_seq", allocationSize = 1, name = "PUORD_SEQ")
    private long purchaseorderid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storeid", referencedColumnName = "storeid", updatable = false)
	private Store store;
	
	@OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL)
    private Set<Item> Itens;
	
	@OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL)
    private Set<Payment> Payment;
	
    @Column(nullable = false)
    private String address;
    
    @Column(nullable = false)
    private Date confirmationdate;
    
    @Column(nullable = false)
    private Integer status;
    

	public long getPurchaseorderid() {
		return purchaseorderid;
	}

	public void setPurchaseorderid(long purchaseorderid) {
		this.purchaseorderid = purchaseorderid;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getConfirmationdate() {
		return confirmationdate;
	}

	public void setConfirmationdate(Date confirmationdate) {
		this.confirmationdate = confirmationdate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public PurchaseOrder() { }

    public PurchaseOrder(long id)
    {
        this.purchaseorderid = id;
    }
}
