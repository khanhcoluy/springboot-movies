package codewithkhanh.movies;

import jakarta.validation.constraints.NotBlank;

public class ReviewRequestDto {
    @NotBlank(message = "Review text must not be bank!")
    private String reviewText;

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
