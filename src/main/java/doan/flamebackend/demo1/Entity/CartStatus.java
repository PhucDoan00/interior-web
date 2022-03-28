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
@Table(name = "cart_status")
public class CartStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stt_id;
	@Enumerated
	@Column(name = "status", length = 15)
	private ECartStatus status;

	@OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
	private Collection<Cart> carts;

	public CartStatus() {

	}

	public Long getStt_id() {
		return stt_id;
	}

	public void setStt_id(Long stt_id) {
		this.stt_id = stt_id;
	}

	public ECartStatus getStatus() {
		return status;
	}

	public void setStatus(ECartStatus status) {
		this.status = status;
	}

	public Collection<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Collection<Cart> carts) {
		this.carts = carts;
	}

	@Override
	public String toString() {
		return "CartStatus [stt_id=" + stt_id + ", status=" + status + ", carts=" + carts + "]";
	}

}
