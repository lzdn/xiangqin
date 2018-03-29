package com.xiangqin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xiangqin.domain.base.BaseEntity;

/**
 * 收发信件
 * 
 * @author zhanglin
 *
 */
@Entity
@Table(name = "t_letter")
public class Letter extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, nullable = false)
	private Integer id;

	@Column(name = "account_id", length = 11, nullable = false)
	private Integer accountId;

	@Column(name = "content", length = 250, nullable = false)
	private String content;
	
	@Column(name = "read_state", length = 2, nullable = false)
	private Integer readState;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
