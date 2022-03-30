package in.nareshit.raghu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="product_tab")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pid")
	private Long id;
	
	@Column(name="pcode")
	private String code;
	
	@Column(name="pcost")
	private Double cost;
	
	@Column(name="pvendor")
	private String vendor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", cost=" + cost + ", vendor=" + vendor + "]";
	}

	public Product(Long id, String code, Double cost, String vendor) {
		super();
		this.id = id;
		this.code = code;
		this.cost = cost;
		this.vendor = vendor;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
