package jp.ne.paypay.performreview.dao.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.query.Query;
import org.hibernate.Session;

import jp.ne.paypay.performreview.dao.PerformanceReviewDao;
import jp.ne.paypay.performreview.model.Employee;
import jp.ne.paypay.performreview.model.Review;

public class PerformanceReviewJpaDao implements PerformanceReviewDao {
	
	final String HQL_GET_ALL_EMPLOYEE = "SELECT e FROM EMPLOYEE e";
	final String HQL_GET_EMPLOYEE_BY_ID = "SELECT e FROM EMPLOYEE e WHERE e.id = :emp_id";
	final String HQL_DELETE_EMPLOYEE = "DELETE FROM EMPLOYEE e WHERE e.id = :emp_id";
	final String HQL_WHERE_STRING = " WHERE ";
	final String HQL_AND_STRING = " AND ";
	final String HQL_FIRST_NAME_CRITERIA = "e.firstName = :firstName";
	final String HQL_LAST_NAME_CRITERIA = "e.lastName = :lastName";
	final String HQL_OTHER_NAME_CRITERIA = "e.otherName = :otherName";
	
	final String HQL_GET_ALL_REVIEW = "SELECT r FROM REVIEW r";
	final String HQL_GET_REVIEW_BY_REVIEWER = "SELECT r FROM REVIEW r where r.reviewer_id = :reviewer_id";
	final String HQL_GET_REVIEW_BY_REVIEWEE = "SELECT r FROM REVIEW r where r.reviewee_id = :reviewee_id";
	
	@PersistenceContext
	EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Collection<Employee> getEmployee() {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery(HQL_GET_ALL_EMPLOYEE, Employee.class).getResultList();
	}

	@Override
	public Employee insertOrUpdateEmployee(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		return (Employee) session.merge(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> query = session.createQuery(HQL_DELETE_EMPLOYEE, Employee.class);
		query.setParameter("emp_id", id);
		query.executeUpdate();
	}

	@Override
	public Employee findEmployeeById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> query = session.createQuery(HQL_GET_EMPLOYEE_BY_ID, Employee.class);
		query.setParameter("emp_id", id);
		return query.getSingleResult();
	}

	@Override
	public Collection<Employee> findEmployee(String firstName, String lastName, String otherName) {
		Session session = entityManager.unwrap(Session.class);
		String queryString = HQL_GET_ALL_EMPLOYEE;
		// check input conditions...
		int notNullInputs = 0;
		if (firstName != null && firstName.length() > 0) notNullInputs += 1;
		if (lastName != null && lastName.length() > 0) notNullInputs += 2;
		if (otherName != null && otherName.length() > 0) notNullInputs += 4;
		
		int elementsAdded = 0;
		if (notNullInputs == 0) {
			// all inputs are empty. do nothing
		} else {
			// There must be valid inputs...
			queryString += HQL_WHERE_STRING;
			
			// If firstName has input
			if ( (notNullInputs & 0x01) > 0) {
				queryString += HQL_FIRST_NAME_CRITERIA;
				elementsAdded++;
			}
			
			// If lastName has input
			if ((notNullInputs & 0x02) > 0) {
				// check if valid criteria added before
				if (elementsAdded > 0) queryString += HQL_AND_STRING;
				queryString += HQL_LAST_NAME_CRITERIA;
				elementsAdded++;
			}
			
			// If otherName has input
			if ((notNullInputs & 0x04) > 0) {
				// check if valid criteria added before
				if (elementsAdded > 0) queryString += HQL_AND_STRING;
				queryString += HQL_OTHER_NAME_CRITERIA;
				elementsAdded++;
			}
		}
		
		// HQL prepared
		Query<Employee> query = session.createQuery(queryString, Employee.class);
		if ( (notNullInputs & 0x01) > 0) {
			query.setParameter("firstName", firstName);
		}
		if ( (notNullInputs & 0x02) > 0) {
			query.setParameter("lastName", lastName);
		}
		if ( (notNullInputs & 0x04) > 0) {
			query.setParameter("otherName", otherName);
		}
		return query.getResultList();
	}

	@Override
	public Collection<Review> getAllReview() {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery(HQL_GET_ALL_REVIEW, Review.class).getResultList();
	}

	@Override
	public Collection<Review> getReviewByReviewee(Long revieweeId) {
		Session session = entityManager.unwrap(Session.class);
		Query<Review> query = session.createQuery(HQL_GET_REVIEW_BY_REVIEWEE, Review.class);
		query.setParameter("reviewee_id", revieweeId);
		return query.getResultList();
	}

	@Override
	public Collection<Review> getReviewByReviewer(Long reviewerId) {
		Session session = entityManager.unwrap(Session.class);
		Query<Review> query = session.createQuery(HQL_GET_REVIEW_BY_REVIEWER, Review.class);
		query.setParameter("reviewer_id", reviewerId);
		return query.getResultList();
	}

	@Override
	public Review insertOrUpdateReview(Review review) {
		Session session = entityManager.unwrap(Session.class);
		return (Review) session.merge(review);
	}
}
