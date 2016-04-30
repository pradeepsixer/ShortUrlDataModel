package com.shorturl.datamodel;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User Details Persistence Entity
 * @author Pradeep Kumar
 */
@Entity
@Table(name = "user_details")
@NamedQueries({
	@NamedQuery(name = UserDetails.NamedQueries.FIND_BY_EMAILID, query = "SELECT UD FROM UserDetails UD WHERE UD.emailId = :"
			+ UserDetails.NamedParameters.EMAIL_ID),
	@NamedQuery(name = UserDetails.NamedQueries.FIND_USER_ID_BY_EMAILID, query = "SELECT UD.userId FROM UserDetails UD WHERE UD.emailId = :"
			+ UserDetails.NamedParameters.EMAIL_ID)
})
public class UserDetails {
	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	@Column(name = "emailid")
	private String emailId;

	@Column(name = "profile_name")
	private String profileName;

	@Column(name = "password")
	private String password;

	@Column(name = "bitmask")
	private short userStatusBitMask;

	@Column(name = "expiration_date")
	private Date expirationDate;

	@OneToMany(mappedBy = "userDetails", orphanRemoval = false, fetch = FetchType.EAGER)
	private List<ShortUrlDetails> shortUrlDetails;

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the profileName
	 */
	public String getProfileName() {
		return profileName;
	}

	/**
	 * @param profileName the profileName to set
	 */
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userStatusBitMask
	 */
	public short getUserStatusBitMask() {
		return userStatusBitMask;
	}

	/**
	 * @param userStatusBitMask the userStatusBitMask to set
	 */
	public void setUserStatusBitMask(short userStatusBitMask) {
		this.userStatusBitMask = userStatusBitMask;
	}

	/**
	 * @return the expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return the shortUrlDetails
	 */
	public List<ShortUrlDetails> getShortUrlDetails() {
		return shortUrlDetails;
	}

	/**
	 * @param shortUrlDetails the shortUrlDetails to set
	 */
	public void setShortUrlDetails(List<ShortUrlDetails> shortUrlDetails) {
		this.shortUrlDetails = shortUrlDetails;
	}

	/**
	 * Named Queries
	 * @author Pradeep Kumar
	 */
	public static class NamedQueries {
		public static final String FIND_BY_EMAILID = "UserDetails.FindByEmailId";
		public static final String FIND_USER_ID_BY_EMAILID = "UserDetails.FindUserIdByEmailId";
	}

	/**
	 * Named Parameters
	 * @author Pradeep Kumar
	 */
	public static class NamedParameters {
		public static final String EMAIL_ID = "emailId";
	}
}
