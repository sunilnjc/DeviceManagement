package com.axiom.devicemanagement.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long priceEur;
	private String announceDate;

	private String sim;

	public SearchQuery(Long priceEur, String announceDate, String sim) {
		super();
		this.priceEur = priceEur;
		this.announceDate = announceDate;
		this.sim = sim;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public Long getPriceEur() {
		return priceEur;
	}

	public void setPriceEur(Long priceEur) {
		this.priceEur = priceEur;
	}

	public String getAnnounceDate() {
		return announceDate;
	}

	public void setAnnounceDate(String announceDate) {
		this.announceDate = announceDate;
	}

	@Override
	public String toString() {
		return "SearchQuery [priceEur=" + priceEur + ", announceDate=" + announceDate + ", sim=" + sim + "]";
	}

}
