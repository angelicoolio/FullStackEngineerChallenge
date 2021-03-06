package jp.ne.paypay.performreview.dao;

import java.util.Collection;

import jp.ne.paypay.performreview.model.Employee;
import jp.ne.paypay.performreview.model.Review;

public interface PerformanceReviewDao {
	Collection<Employee> getEmployee();
	Employee insertOrUpdateEmployee(Employee employee);
	void deleteEmployee(Long id);
	Employee findEmployeeById(Long id);
	Collection<Employee> findEmployee(String firstName, String lastName, String otherName);
	
	Collection<Review> getAllReview();
	Collection<Review> getReviewByReviewee(Long revieweeId);
	Collection<Review> getReviewByReviewer(Long reviewerId);
	Review insertOrUpdateReview(Review review);
}
