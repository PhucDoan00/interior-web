package doan.flamebackend.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cart-status")
public class CartStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stt_id", nullable = false)
	private long sttId;
	@Column(name = "cart_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private ECartStatus status;

	@OneToMany(mappedBy = "cartStatus", cascade = CascadeType.ALL)
	private Collection<Cart> carts;

	public CartStatus() {

	}

	public CartStatus(long sttId, ECartStatus status, Collection<Cart> carts) {
		super();
		this.sttId = sttId;
		this.status = status;
		this.carts = carts;
	}

	public long getSttId() {
		return sttId;
	}

	public void setSttId(long sttId) {
		this.sttId = sttId;
	}

	public ECartStatus getEStatus() {
		return status;
	}

	public void setEStatus(ECartStatus status) {
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
		return "CartStatus [sttId=" + sttId + ", status=" + status + ", carts=" + carts + "]";
	}

}
