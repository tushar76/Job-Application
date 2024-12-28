package com.tanya.JobBrowser.reviews;
import java.util.*;

public interface ReviewsService {

    List<Reviews> getAllReviews(Long CompanyId);

    void addCompanyReview(Long companyId, Reviews review);

    Reviews getReviewById(Long id, Long companyId);

    Boolean UpdateReviewbyCompanyId(Long id, Reviews review, Long companyId);

    Boolean deleteRview(Long id, Long companyId);
}
