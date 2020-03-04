package com.invillia.acme.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STORE")
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STO_SEQ")
    @SequenceGenerator(sequenceName = "store_seq", allocationSize = 1, name = "STO_SEQ")
    private long storeid;
	
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private Set<PurchaseOrder> PurchaseOrders;
	
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String address;

	public long getId() {
		return storeid;
	}

	public void setId(long id) {
		this.storeid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Store() { }

    public Store(long id)
    {
        this.storeid = id;
    }
}
