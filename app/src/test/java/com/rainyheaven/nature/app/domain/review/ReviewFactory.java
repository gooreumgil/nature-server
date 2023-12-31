package com.rainyheaven.nature.app.domain.review;

import com.rainyheaven.nature.core.domain.item.Item;
import com.rainyheaven.nature.core.domain.review.Review;
import com.rainyheaven.nature.core.domain.review.ReviewRepository;
import com.rainyheaven.nature.core.domain.review.dto.app.ReviewSaveRequestDto;
import com.rainyheaven.nature.core.domain.reviewlike.ReviewLike;
import com.rainyheaven.nature.core.domain.reviewlike.ReviewLikeRepository;
import com.rainyheaven.nature.core.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewFactory {

    private final ReviewRepository reviewRepository;
    private final ReviewLikeRepository reviewLikeRepository;
    
    public Review save(int rating, String content, Item item, User user) {
    
        ReviewSaveRequestDto reviewSaveRequestDto = getReviewSaveRequestDto(rating, content);
        Review review = Review.create(reviewSaveRequestDto, item, user);
        return reviewRepository.save(review);
    }

    public Page<Review> findByUser(User user) {
        return reviewRepository.findAllByUserIdWithItem(user.getId(), PageRequest.of(0, 5));
    }

    public ReviewLike saveReviewLike(Review review, User user) {
        return reviewLikeRepository.save(ReviewLike.create(review, user));
    }

    public ReviewSaveRequestDto getReviewSaveRequestDto(int rating, String content) {
        ReviewSaveRequestDto reviewSaveRequestDto = new ReviewSaveRequestDto();
        reviewSaveRequestDto.setRating(rating);
        reviewSaveRequestDto.setContent(content);
        return reviewSaveRequestDto;
    }

    public String getLongContent() {
        return "longContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContent" +
                "longContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContent" +
                "longContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContent" +
                "longContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContent" +
                "longContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContent" +
                "longContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContent" +
                "longContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContent" +
                "longContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContent" +
                "longContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContent" +
                "longContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContentlongContent";
    }
}
