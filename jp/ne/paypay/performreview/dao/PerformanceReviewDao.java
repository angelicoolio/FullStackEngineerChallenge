package jp.ne.paypay.performreview.dao;

import java.util.Collection;

import jp.ne.paypay.performreview.model.Employee;
import jp.ne.paypay.performreview.model.Review;

public interface PerformanceReviewDao {
	Collection<Employee> getEmployee();
	Employee insertOrUpdateEmployee(Employee employee);
	void deleteEmployee(Long id);
	Employee findEmployee(String firstName, String lastName);
	
	Collection<Review> getAllReview();
	Collection<Review> getReviewByReviewee(Employee reviewee);
	Collection<Review> getReviewByReviewer(Employee reviewer);
	Review insertOrUpdateReview(Review review);
}
