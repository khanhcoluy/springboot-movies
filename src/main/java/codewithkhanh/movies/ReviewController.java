package codewithkhanh.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/{imdbId}")
    public ResponseEntity<Review> createReview(
            @PathVariable String imdbId,
            @Validated @RequestBody ReviewRequestDto requestDto
    ) {
        Review createdReview = reviewService.createReview(imdbId, requestDto);
        if (createdReview != null) {
            return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
