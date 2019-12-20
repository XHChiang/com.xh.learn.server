package com.xh.learn.website.webProducts.usr.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "usr_group")
public class UsrGroup extends com.xh.learn.sdk.entity.Entity {
	@Id
	private Integer id;

	private Integer sort;

	private String name;

	private Integer parentId;

	private Integer isDeleted;

	private String description;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;

	private List<Usr> usrs;

	private List<Usr> deletedUsrs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public List<Usr> getUsrs() {
		return usrs;
	}

	public void setUsrs(List<Usr> usrs) {
		this.usrs = usrs;
	}

	public List<Usr> getDeletedUsrs() {
		return deletedUsrs;
	}

	public void setDeletedUsrs(List<Usr> deletedUsrs) {
		this.deletedUsrs = deletedUsrs;
	}

}
