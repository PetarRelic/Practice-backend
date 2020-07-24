package it.eng.petarrelic.vezba.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public class BaseEntity {

	@Column(name = "update_time_utc", nullable = true)
	@JsonIgnore
	private Long updateTimeUTC;
	
	@Column(name = "update_by_username", nullable = true, length = 200)
	@JsonIgnore
	private String updateByUsername;

	
	public long getUpdateTimeUTC() {
		return updateTimeUTC;
	}
	public void setUpdateTimeUTC(long updateTimeUTC) {
		this.updateTimeUTC = updateTimeUTC;
	}

	public String getUpdateByUsername() {
		return updateByUsername;
	}
	public void setUpdateByUsername(String updateByUsername) {
		this.updateByUsername = updateByUsername;
	}
	
	
	/**
	 * automatic property set before any database persistence
	 */
	@PreUpdate
	@PrePersist
	public void setLastUpdate() {
		setUpdateTimeUTC(System.currentTimeMillis());
		setUpdateByUsername("test");
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseEntity [updateTimeUTC=");
		builder.append(updateTimeUTC);
		builder.append(", updateByUsername=");
		builder.append(updateByUsername);
		builder.append("]");
		return builder.toString();
	}
}
