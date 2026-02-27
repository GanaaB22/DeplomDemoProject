package com.DataLogGen.demo.reviews.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.DataLogGen.demo.companies.Company;
import com.DataLogGen.demo.companies.CompanyService;
import com.DataLogGen.demo.reviews.Review;
import com.DataLogGen.demo.reviews.ReviewRepository;
import com.DataLogGen.demo.reviews.ReviewService;

@Service
public class ReviewServiceimpl implements ReviewService{
    private final ReviewRepository reviewRepository;

    private final CompanyService companyService;

   public ReviewServiceimpl(ReviewRepository reviewRepository, CompanyService companyService) {
    this.reviewRepository = reviewRepository;
    this.companyService = companyService;
    }
    
    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        } 
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
    
    if (companyService.getCompanyById(companyId) != null) {
        
        Review existingReview = getReview(companyId, reviewId);
        
        if (existingReview != null) {
           
            existingReview.setTitle(updatedReview.getTitle());
            existingReview.setDescription(updatedReview.getDescription());
            existingReview.setRating(updatedReview.getRating());
            
           
            reviewRepository.save(existingReview);
            return true;
        }
    }
    return false;
}

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        
        if (companyService.getCompanyById(companyId) != null) {
            Review review = getReview(companyId, reviewId);
            if (review != null) {
                reviewRepository.delete(review);
                return true;
            }
        }
        return false;
    }
    
}
