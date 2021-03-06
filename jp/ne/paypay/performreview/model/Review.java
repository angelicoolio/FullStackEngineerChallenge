package jp.ne.paypay.performreview.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="REVIEW")
public class Review {

	@Id
	@Column(name="id")
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "reviewee_id", referencedColumnName = "id")
	private Employee reviewee;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="reviewer_id", referencedColumnName = "id")
	private Employee reviewer;
	
	@Column(name = "feedBack")
	private String feedback;
	
	@Column(name = "lastUpdated")
	private Date lastUpdated;
	
	@Column(name = "isFeedbacked")
	private Boolean isFeedbacked;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getReviewee() {
		return reviewee;
	}

	public void setReviewee(Employee reviewee) {
		this.reviewee = reviewee;
	}

	public Employee getReviewer() {
		return reviewer;
	}

	public void setReviewer(Employee reviewer) {
		this.reviewer = reviewer;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Boolean getIsFeedbacked() {
		return isFeedbacked;
	}

	public void setIsFeedbacked(Boolean isFeedbacked) {
		this.isFeedbacked = isFeedbacked;
	}
	
}
