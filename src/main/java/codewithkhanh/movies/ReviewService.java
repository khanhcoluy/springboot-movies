package codewithkhanh.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    public Review createReview(String imdbId, ReviewRequestDto requestDto) {
        Optional<Movie> movie = movieRepository.findMovieByImdbId(imdbId);
        if (movie.isPresent()) {
            String reviewText = requestDto.getReviewText();
            Review review = new Review(reviewText);
            reviewRepository.insert(review);
            Movie updatedMovie = movie.get();
            updatedMovie.getReviewIds().add(review);
            movieRepository.save(updatedMovie);

            return review;
        } else {
            return null;
        }
    }
}
