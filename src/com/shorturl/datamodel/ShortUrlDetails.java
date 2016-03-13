/**
 * 
 */
package com.shorturl.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "link_details")
@NamedQueries({
		@NamedQuery(name = ShortUrlDetails.NamedQueries.INCREMENT_VIEW_COUNT, query = "UPDATE ShortUrlDetails SUD SET SUD.viewCount = SUD.viewCount + 1 WHERE SUD.shortUrl = :shortUrl"),
		@NamedQuery(name = ShortUrlDetails.NamedQueries.INCREMENT_CLICK_COUNT, query = "UPDATE ShortUrlDetails SUD SET SUD.targetClicks = SUD.targetClicks + 1 WHERE SUD.shortUrl = :shortUrl")})
public class ShortUrlDetails {

	@Id
	@Column(name = "short_url")
	private String shortUrl;

	/**
	 * Target URL for the banner
	 */
	@Column(name = "lp_url")
	private String landingPageUrl;

	/**
	 * Landing Page (To be loaded in the iframe)
	 */
	@Column(name = "share_url")
	private String shareUrl;

	/**
	 * The Title for the banner
	 */
	@Column(name = "banner_title")
	private String bannerTitle;

	/**
	 * The Description for the Banner
	 */
	@Column(name = "banner_description")
	private String bannerDescription;

	/**
	 * The page view count for the Landing Page
	 */
	@Column(name = "view_count")
	private int viewCount = 0;

	/**
	 * The number of clicks on the banner button
	 */
	@Column(name = "target_clicks")
	private int targetClicks = 0;

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
	 * @return the shareUrl
	 */
	public String getShareUrl() {
		return shareUrl;
	}

	/**
	 * @param shareUrl the shareUrl to set
	 */
	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}

	/**
	 * @return the bannerTitle
	 */
	public String getBannerTitle() {
		return bannerTitle;
	}

	/**
	 * @param bannerTitle
	 *            the bannerTitle to set
	 */
	public void setBannerTitle(String bannerTitle) {
		this.bannerTitle = bannerTitle;
	}

	/**
	 * @return the bannerDescription
	 */
	public String getBannerDescription() {
		return bannerDescription;
	}

	/**
	 * @param bannerDescription
	 *            the bannerDescription to set
	 */
	public void setBannerDescription(String bannerDescription) {
		this.bannerDescription = bannerDescription;
	}

	/**
	 * @return the viewCount
	 */
	public int getViewCount() {
		return viewCount;
	}

	/**
	 * @param viewCount
	 *            the viewCount to set
	 */
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	/**
	 * @return the targetClicks
	 */
	public int getTargetClicks() {
		return targetClicks;
	}

	/**
	 * @param targetClicks
	 *            the targetClicks to set
	 */
	public void setTargetClicks(int targetClicks) {
		this.targetClicks = targetClicks;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ShortUrlDetails [shortUrl=" + shortUrl + ", landingPageUrl=" + landingPageUrl + ", shareUrl="
				+ shareUrl + ", bannerTitle=" + bannerTitle + ", bannerDescription=" + bannerDescription
				+ ", viewCount=" + viewCount + ", targetClicks=" + targetClicks + "]";
	}

	/**
	 * The Named Queries
	 * 
	 * @author Pradeep Kumar
	 */
	public static class NamedQueries {
		public static final String INCREMENT_VIEW_COUNT = "ShortUrlDetails.IncrementViewCount";
		public static final String INCREMENT_CLICK_COUNT = "ShortUrlDetails.IncrementTargetClick";
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
