package doan.flamebackend.demo1.Entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bill_status")
public class BillStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stt_id;

	@Enumerated
	@Column(name = "status", length = 15)
	private EBillStatus status;

	@OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
	private Collection<Bill> bills;

	public BillStatus() {

	}

	public Long getStt_id() {
		return stt_id;
	}

	public void setStt_id(Long stt_id) {
		this.stt_id = stt_id;
	}

	public EBillStatus getStatus() {
		return status;
	}

	public void setStatus(EBillStatus status) {
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
		return "BillStatus [stt_id=" + stt_id + ", status=" + status + ", bills=" + bills + "]";
	}

}
