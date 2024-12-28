package com.tanya.JobBrowser.reviews;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/{companyId}/")
public class ReviewsController {


    ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping("/reviews")
    public List<Reviews> getReviewByCompany(@PathVariable Long companyId)
    {
        return reviewsService.getAllReviews(companyId);
    }

    @PostMapping("/reviews")
    public String addComapnyReviews(@PathVariable Long companyId , @RequestBody Reviews review)
    {
         reviewsService.addCompanyReview(companyId,review);
         return "Added Sucessfully !";
    }

    @GetMapping("/reviews/{id}")
    public Reviews getReviewById(@PathVariable Long id ,@PathVariable Long companyId)
    {

        return reviewsService.getReviewById(id ,companyId);
    }

    @PutMapping("/reviews/{id}")
    public String UpdateReviews(@PathVariable Long id , @RequestBody Reviews review, @PathVariable Long companyId)
    {
        Boolean Updated = reviewsService.UpdateReviewbyCompanyId(id,review,companyId);

        if(Updated)
            return "Updated Successfully !";
        return "Not Found !";

    }

    @DeleteMapping("/reviews/{id}")
    public String deleteReview(@PathVariable Long id , @PathVariable Long companyId)
    {
        Boolean deleted = reviewsService.deleteRview(id ,companyId);
        if(deleted)
            return "Deleted Sucessfully !";
        return "Not Found!";
    }

}

