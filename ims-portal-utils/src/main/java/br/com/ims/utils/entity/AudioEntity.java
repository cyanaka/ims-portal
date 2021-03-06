package br.com.ims.utils.entity;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class AudioEntity{
	
	private Long id;
	private String type;
	private String name;
	private String description;
	private String path;
	private String property;
	private Long versionid;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public Long getVersionid() {
		return versionid;
	}
	public void setVersionid(Long versionid) {
		this.versionid = versionid;
	}
	
	
	

}
