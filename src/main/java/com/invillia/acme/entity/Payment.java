package com.invillia.acme.entity;

import java.sql.Date;

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
@Table(name = "PAYMENT")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAY_SEQ")
    @SequenceGenerator(sequenceName = "payment_seq", allocationSize = 1, name = "PAY_SEQ")
    private long paymentid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "purchaseorderid", referencedColumnName = "purchaseorderid", updatable = false)
	private PurchaseOrder purchaseOrder;
	
	@Column(nullable = false)
    private Number credicardnumber;
	
	@Column(nullable = false)
    private Date paymentdate;
	
	@Column(nullable = false)
    private Integer status;

	public long getId() {
		return paymentid;
	}

	public void setId(long id) {
		this.paymentid = id;
	}

	public Number getCredicardnumber() {
		return credicardnumber;
	}

	public void setCredicardnumber(Number credicardnumber) {
		this.credicardnumber = credicardnumber;
	}

	public Date getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Payment() { }

    public Payment(long id)
    {
        this.paymentid = id;
    }
}
