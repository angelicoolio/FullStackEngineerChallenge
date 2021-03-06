package jp.ne.paypay.performreview.repository;

import java.util.Collection;
import jp.ne.paypay.performreview.model.Employee;
import jp.ne.paypay.performreview.model.Review;

public interface PerformanceReviewService {
	Employee addEmployee(String firstName, String lastName, String otherName);
	void removeEmployee(Long id);
	Employee updateEmployee(Long id, String firstName, String lastName, String otherName);
	Collection<Employee> viewEmployees();
	
	Collection<Review> getAllReview();
	Collection<Review> getReviewsByReviewer(Long reviewerId);
	Collection<Review> getReviewsByReviewee(Long revieweeId);
	Review assignToReview(Long reviewerId, Long revieweeId);
	Review submitFeedback(Review review);
	Review updateReview(Review review);
}
