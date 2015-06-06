package br.com.ims.utils.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.ims.utils.BaseEntity;

@Entity
@XmlRootElement
@Table(name="version", schema ="flow")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class VersionEntity extends BaseEntity<Long> {
	
	private static final long serialVersionUID = 983822984221640060L;
	
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
