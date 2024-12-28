package com.tanya.JobBrowser.company;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies()
    {
        return new ResponseEntity<List<Company>>(companyService.getAllCompany(), HttpStatus.OK);
    }

    @PutMapping("{id}/")
    public ResponseEntity<String> updateCompany(@RequestBody Company company ,@PathVariable Long id)
    {
        companyService.UpdateCompany(company,id);

        return new ResponseEntity<String>("Updated Succesfully !" ,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company)
    {
        companyService.createCompany(company);
        return new ResponseEntity<String>("Created Successfully !", HttpStatus.CREATED);
    }

    @DeleteMapping("{id}/")
    public ResponseEntity<String> DeleteComapny(@PathVariable Long id)
    {
        Boolean deletedcompany = companyService.DeleteComapny(id);
        if(deletedcompany)
        {
            return new ResponseEntity<>("Deleted Succefully" ,HttpStatus.OK);
        }
        return  new ResponseEntity<>("Not Found Comapny !", HttpStatus.NOT_FOUND);
    }

    @GetMapping("{id}/")
    public ResponseEntity<Company> companyFindById(@PathVariable  Long id)
    {
        Company company = companyService.findComapnyById(id);

        if(company!=null)
           return new ResponseEntity<Company>(company,HttpStatus.FOUND);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
