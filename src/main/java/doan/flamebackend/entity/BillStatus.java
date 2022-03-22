package doan.flamebackend.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bill-status")
public class BillStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stt_id", nullable = false)
	private long sttId;
	@Column(name = "bill_status", nullable = false)
	private String status;

	@OneToMany(mappedBy = "bill_status", cascade = CascadeType.ALL)
	private Collection<Bill> bills;

	public BillStatus() {

	}

	public BillStatus(long sttId, String status, Collection<Bill> bills) {
		super();
		this.sttId = sttId;
		this.status = status;
		this.bills = bills;
	}

	public long getSttId() {
		return sttId;
	}

	public void setSttId(long sttId) {
		this.sttId = sttId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Collection<Bill> getBills() {
		return bills;
	}

	public void setBills(Collection<Bill> bills) {
		this.bills = bills;
	}

	@Override
	public String toString() {
		return "BillStatus [sttId=" + sttId + ", status=" + status + ", bills=" + bills + "]";
	}

}
