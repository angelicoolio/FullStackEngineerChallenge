package jp.ne.paypay.performreview;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jp.ne.paypay.performreview.model.Review;
import jp.ne.paypay.performreview.repository.PerformanceReviewService;

@RestController
public class EmployeeController {
	
	PerformanceReviewService prService;
	
	/**
	 * This is for employer to retrieve reviews needed to be reviewed
	 * @param id - Reviewer's Employee ID
	 * @return - List of reviews for the input reviewer
	 */
	@GetMapping("/review/{id}")
	public List<Review> getReviews(@PathVariable Long id){
		return new ArrayList<>(prService.getReviewsByReviewer(id));
	}

	/**
	 * This is to submit the updated review by the reviewer
	 * @param in - Updated review by the reviewer
	 * @return
	 */
	@PutMapping("/review")
	public Review submitFeedback(@RequestBody Review in) {
		return prService.submitFeedback(in);
	}
}
