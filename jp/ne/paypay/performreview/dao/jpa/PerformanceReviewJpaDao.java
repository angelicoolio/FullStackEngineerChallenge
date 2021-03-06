package jp.ne.paypay.performreview.dao.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;

import jp.ne.paypay.performreview.dao.PerformanceReviewDao;
import jp.ne.paypay.performreview.model.Employee;
import jp.ne.paypay.performreview.model.Review;

public class PerformanceReviewJpaDao implements PerformanceReviewDao {
	
	EntityManager entityManager;

	@Override
	public Collection<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee insertOrUpdateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee findEmployee(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Review> getAllReview() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Review> getReviewByReviewee(Employee reviewee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Review> getReviewByReviewer(Employee reviewer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review insertOrUpdateReview(Review review) {
		// TODO Auto-generated method stub
		return null;
	}

}
