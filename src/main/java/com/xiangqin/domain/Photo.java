package com.xiangqin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xiangqin.domain.base.BaseEntity;

/**
 * 用户相册
 * 
 * @author zhanglin
 *
 */
@Entity
@Table(name = "t_photo")
public class Photo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "account_id", length = 11, nullable = false)
	private Integer accountId;

	@Column(name = "img_url", length = 50, nullable = false)
	private String imgUrl;

	@Column(name = "state", length = 11, nullable = false)
	private Integer state;

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
