package jp.ne.paypay.performreview.repository;

import java.util.Calendar;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import jp.ne.paypay.performreview.dao.PerformanceReviewDao;
import jp.ne.paypay.performreview.model.Employee;
import jp.ne.paypay.performreview.model.Review;

public class PerformanceReviewServiceImpl implements PerformanceReviewService {
	
	@Autowired
	PerformanceReviewDao dao;

	@Override
	public Employee addEmployee(Employee in) {
		return dao.insertOrUpdateEmployee(in);
	}

	@Override
	public void removeEmployee(Long id) {
		dao.deleteEmployee(id);
	}

	@Override
	public Employee updateEmployee(Employee in) {
		return dao.insertOrUpdateEmployee(in); 
	}

	@Override
	public Collection<Employee> findEmployee(String firstName, String lastName, String otherName) {
		return dao.findEmployee(firstName, lastName, otherName);
	}

	@Override
	public Collection<Employee> viewEmployees() {
		return dao.getEmployee();
	}

	@Override
	public Collection<Review> getAllReview() {
		return dao.getAllReview();
	}

	@Override
	public Collection<Review> getReviewsByReviewer(Long reviewerId) {
		return dao.getReviewByReviewer(reviewerId);
	}

	@Override
	public Collection<Review> getReviewsByReviewee(Long revieweeId) {
		return dao.getReviewByReviewee(revieweeId);
	}

	@Override
	public Review assignToReview(Long reviewerId, Long revieweeId) {
		Review r = new Review();
		r.setIsFeedbacked(false);
		r.setLastUpdated(Calendar.getInstance().getTime());
		r.setReviewer(dao.findEmployeeById(reviewerId));
		r.setReviewee(dao.findEmployeeById(revieweeId));
		return dao.insertOrUpdateReview(r);
	}

	@Override
	public Review submitFeedback(Review review) {
		review.setLastUpdatedBy(review.getReviewer());
		return dao.insertOrUpdateReview(review);
	}

	@Override
	public Review updateReview(Review review, Long updatedBy) {
		review.setLastUpdatedBy(dao.findEmployeeById(updatedBy));
		return dao.insertOrUpdateReview(review);
	}

}
