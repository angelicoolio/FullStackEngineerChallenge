package jp.ne.paypay.performreview;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jp.ne.paypay.performreview.model.Review;
import jp.ne.paypay.performreview.repository.PerformanceReviewService;

@RestController
public class AdminController {
	
	PerformanceReviewService prService;
	
	// Assume admin is also a part of Employee.
	// Access control not implemented

	@PostMapping("/review/{reviewee}/{reviewer}")
	public Review newReview(@PathVariable Long reviewee, @PathVariable Long reviewer) {
		return prService.assignToReview(reviewer, reviewee);
	}
	
	@PutMapping("/review/update")
	public Review updateReview(@RequestBody Review in) {
		return prService.updateReview(in);
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee (@PathVariable Long id) {
		prService.removeEmployee(id);
	}
}
