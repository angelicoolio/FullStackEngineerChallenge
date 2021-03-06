package jp.ne.paypay.performreview.repository;

import java.util.Collection;
import jp.ne.paypay.performreview.model.Employee;
import jp.ne.paypay.performreview.model.Review;

public interface PerformanceReviewService {
	Employee addEmployee(Employee in);
	void removeEmployee(Long id);
	Employee updateEmployee(Employee in);
	Collection<Employee> findEmployee(String firstName, String lastName, String otherName);
	Collection<Employee> viewEmployees();
	
	Collection<Review> getAllReview();
	Collection<Review> getReviewsByReviewer(Long reviewerId);
	Collection<Review> getReviewsByReviewee(Long revieweeId);
	Review assignToReview(Long reviewerId, Long revieweeId);
	Review submitFeedback(Review review);
	Review updateReview(Review review, Long updatedBy);
}
