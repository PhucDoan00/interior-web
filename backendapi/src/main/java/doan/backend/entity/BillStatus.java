package doan.backend.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "bill_status")
public class BillStatus implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stt_id", nullable = false)
	private Long sttId;
	
	@Column(name = "status", nullable = false)
	private String status;

	@OneToMany(mappedBy = "status")
	private Set<Bill> bills;
	
	public BillStatus() {
		// TODO Auto-generated constructor stub
	}
	
	public Set<Bill> getBills() {
		return bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

	public Long getSttId() {
		return sttId;
	}

	public void setSttId(Long sttId) {
		this.sttId = sttId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
