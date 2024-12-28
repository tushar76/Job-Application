package com.tanya.JobBrowser.reviews.impl;

import com.tanya.JobBrowser.company.Company;
import com.tanya.JobBrowser.company.CompanyService;
import com.tanya.JobBrowser.reviews.Reviews;
import com.tanya.JobBrowser.reviews.ReviewsRepository;
import com.tanya.JobBrowser.reviews.ReviewsService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewsServiceImpl implements ReviewsService {

   private final ReviewsRepository reviewsRepository;
   private final CompanyService companyService;

    public ReviewsServiceImpl(ReviewsRepository reviewsRepository , CompanyService companyService) {
        this.reviewsRepository = reviewsRepository;
        this.companyService=companyService;
    }

    @Override
    public List<Reviews> getAllReviews(Long CompanyId) {
        List<Reviews> reviews = reviewsRepository.findByCompanyId(CompanyId);
        return reviews;
    }

    @Override
    public void addCompanyReview(Long companyId, Reviews review) {
        Company company = companyService.findComapnyById(companyId);
        if(company!=null)
        {
            review.setCompany(company);
            reviewsRepository.save(review);
        }
    }

    @Override
    public Reviews getReviewById(Long id, Long companyId) {
        List<Reviews> reviews = reviewsRepository.findByCompanyId(companyId);

        return reviews.stream()
                .filter(r->r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Boolean UpdateReviewbyCompanyId(Long id, Reviews Updatedreview, Long companyId) {
        if(companyService.findComapnyById(companyId)!=null)
        {

            Updatedreview.setCompany(companyService.findComapnyById(companyId));
            Updatedreview.setId(id);
            reviewsRepository.save(Updatedreview);
            return true;
        }
        else
            return  false;
    }

    @Override
    public Boolean deleteRview(Long id, Long companyId) {
        if(companyService.findComapnyById(companyId) !=null &&
                 reviewsRepository.existsById(id))
        {
            Reviews review = reviewsRepository.findById(id).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);

            // company not present
            review.setCompany(null);
            companyService.UpdateCompany(company,companyId);
            reviewsRepository.deleteById(id);
            return true;


        }
        return false;
    }
}
