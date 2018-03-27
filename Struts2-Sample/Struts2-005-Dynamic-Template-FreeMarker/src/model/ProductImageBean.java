package model;

import java.io.Serializable;

/**
 * 图片数据库 t_product_image
 */
public class ProductImageBean implements Serializable {

	private static final long serialVersionUID = 3508888414362624716L;
	private Long productImageId;// 产品图片ID
	private String productImgURL;// 产品路径
	private Long productId;// 产品ID

	public Long getProductImageId() {
		return productImageId;
	}

	public void setProductImageId(Long productImageId) {
		this.productImageId = productImageId;
	}

	public String getProductImgURL() {
		return productImgURL;
	}

	public void setProductImgURL(String productImgURL) {
		this.productImgURL = productImgURL;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public ProductImageBean(Long productImageId, String productImgURL, Long productId) {
		super();
		this.productImageId = productImageId;
		this.productImgURL = productImgURL;
		this.productId = productId;
	}

	public ProductImageBean() {
		super();
	}

}
