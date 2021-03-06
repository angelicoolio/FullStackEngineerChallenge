package jp.ne.paypay.performreview;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jp.ne.paypay.performreview.model.Employee;
import jp.ne.paypay.performreview.model.Review;
import jp.ne.paypay.performreview.repository.PerformanceReviewService;

/**
 * This controller is intended to be called by admin only
 * @author angelicoolio
 *
 */
@RestController
public class AdminController {
	
	PerformanceReviewService prService;
	
	// Assume admin is also a part of Employee.
	// Access control not implemented

	/**
	 * This is for the admin to assign a reviewer to an employee (reviewee)
	 * @param reviewee - The employer id to be reviewed
	 * @param reviewer - The employer id to review the reviewee
	 * @return
	 */
	@PostMapping("/review/{reviewee}/{reviewer}")
	public Review newReview(@PathVariable Long reviewee, @PathVariable Long reviewer) {
		return prService.assignToReview(reviewer, reviewee);
	}
	/**
	 * This is for the admin to perform an update on a review
	 * @param in - Review updated by the admin
	 * @param updatedBy - Employee id which updated this review (which is an admin)
	 * @return
	 */
	@PutMapping("/review/{updatedBy}")
	public Review updateReview(@RequestBody Review in, @PathVariable Long updatedBy) {
		return prService.updateReview(in, updatedBy);
	}
	
	/**
	 * This is for the admin to view the whole list of employees created
	 * @return - List of all employees
	 */
	@GetMapping("/employee")
	public List<Employee> getEmployee(){
		return new ArrayList<>(prService.viewEmployees());
	}
	
	/**
	 * This is for the admin to create a new employee
	 * @param in - The employee to be created
	 * @return - If adding employee is successful
	 */
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee in) {
		return prService.addEmployee(in);
	}
	
	/**
	 * This is for the admin to delete an employee entry
	 * @param id - employee id to be deleted
	 */
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee (@PathVariable Long id) {
		prService.removeEmployee(id);
	}
	
	/**
	 * This is for the admin to update the details of an employee entry
	 * @param in - The updated employee
	 * @return
	 */
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee in) {
		return prService.updateEmployee(in);
	}
}
