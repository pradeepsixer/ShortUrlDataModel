/**
 * 
 */
package com.shorturl.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity Object for the Short URL's Details. Contains Information such as:
 * <ol>
 * <li><dl><dt>Short URL</dt><dd>The Created Short URL</dd></dl></li>
 * <li><dl><dt>Landing Page URL</dt><dd>The URL for the page that is to be shown within the {@code iframe}</dd></dl></li>
 * <li><dl><dt>Target URL</dt><dd>The URL for the page that the banner links to</dd></dl></li>
 * <li><dl><dt>Banner Title</dt><dd>The Banner's Title - Used for Button linking</dd></dl></li>
 * <li><dl><dt>Banner Description</dt><dd>The Banner's Description Text</dd></dl></li>
 * <li><dl><dt>View Count</dt><dd>The number of hits the short url has received</dd></dl></li>
 * <li><dl><dt>Target Clicks</dt><dd>The number of clicks the banner button has received</dd></dl></li>
 * </ol>
 * @author Pradeep Kumar
 */
@Entity
@Table(name = "short_url_details")
@NamedQueries({
	// Find Queries
		@NamedQuery(name = ShortUrlDetails.NamedQueries.FIND_BY_SHORTURL, query = "SELECT SUD FROM ShortUrlDetails SUD WHERE SUD.shortUrl = :shortUrl"),
	// Increment Count Queries
		@NamedQuery(name = ShortUrlDetails.NamedQueries.INCREMENT_VIEW_COUNT, query = "UPDATE ShortUrlDetails SUD SET SUD.viewCount = SUD.viewCount + 1 WHERE SUD.shortUrl = :shortUrl"),
		@NamedQuery(name = ShortUrlDetails.NamedQueries.INCREMENT_ACTION_COMPLETED_COUNT, query = "UPDATE ShortUrlDetails SUD SET SUD.numActionCompleted = SUD.numActionCompleted + 1 WHERE SUD.shortUrl = :shortUrl")})
public class ShortUrlDetails {

	@Id
	@Column(name = "short_url_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long shortUrlId;

	@Column(name = "short_url")
	private String shortUrl;

	/**
	 * The page to be loaded in the iframe
	 */
	@Column(name = "landing_page_url")
	private String landingPageUrl;

	/**
	 * The page view count for the Landing Page
	 */
	@Column(name = "view_count")
	private long viewCount = 0;

	/**
	 * The number of intended actions completed from the bottom banner
	 */
	@Column(name = "num_action_completed")
	private long numActionCompleted = 0;

	/**
	 * The JSON string for the action
	 */
	@Column(name = "action_json")
	private String actionJson;

	@ManyToOne
	@JoinColumn(name = "userid", nullable = true)
	private UserDetails userDetails;

	/**
	 * @return the shortUrlId
	 */
	public long getShortUrlId() {
		return shortUrlId;
	}

	/**
	 * @param shortUrlId the shortUrlId to set
	 */
	public void setShortUrlId(long shortUrlId) {
		this.shortUrlId = shortUrlId;
	}

	/**
	 * @return the linkId
	 */
	public String getShortUrl() {
		return shortUrl;
	}

	/**
	 * @param linkId
	 *            the linkId to set
	 */
	public void setShortUrl(String linkId) {
		this.shortUrl = linkId;
	}

	/**
	 * @return the landingPageUrl
	 */
	public String getLandingPageUrl() {
		return landingPageUrl;
	}

	/**
	 * @param landingPageUrl
	 *            the landingPageUrl to set
	 */
	public void setLandingPageUrl(String landingPageUrl) {
		this.landingPageUrl = landingPageUrl;
	}

	/**
	 * @return the viewCount
	 */
	public long getViewCount() {
		return viewCount;
	}

	/**
	 * @param viewCount
	 *            the viewCount to set
	 */
	public void setViewCount(long viewCount) {
		this.viewCount = viewCount;
	}

	/**
	 * @return the numActionCompleted
	 */
	public long getNumActionCompleted() {
		return numActionCompleted;
	}

	/**
	 * @param numActionCompleted the numActionCompleted to set
	 */
	public void setNumActionCompleted(long numActionCompleted) {
		this.numActionCompleted = numActionCompleted;
	}

	/**
	 * @return the actionJson
	 */
	public String getActionJson() {
		return actionJson;
	}

	/**
	 * @param actionJson the actionJson to set
	 */
	public void setActionJson(String actionJson) {
		this.actionJson = actionJson;
	}

	/**
	 * @return the userDetails
	 */
	public UserDetails getUserDetails() {
		return userDetails;
	}

	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ShortUrlDetails [shortUrl=" + shortUrl + ", landingPageUrl=" + landingPageUrl + ", viewCount="
				+ viewCount + ", numActionCompleted=" + numActionCompleted + ", actionJson=" + actionJson + "]";
	}

	/**
	 * The Named Queries
	 * 
	 * @author Pradeep Kumar
	 */
	public static class NamedQueries {
		public static final String FIND_BY_SHORTURL = "ShortUrlDetails.FindByShortUrl";

		public static final String INCREMENT_VIEW_COUNT = "ShortUrlDetails.IncrementViewCount";
		public static final String INCREMENT_ACTION_COMPLETED_COUNT = "ShortUrlDetails.IncrementActionCompleted";
	}

	/**
	 * Named Parameters
	 * 
	 * @author Pradeep Kumar
	 */
	public static class NamedParameters {
		public static final String SHORT_URL = "shortUrl";
	}
}
