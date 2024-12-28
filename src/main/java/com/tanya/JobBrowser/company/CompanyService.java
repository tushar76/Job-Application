package com.tanya.JobBrowser.company;
import org.springframework.stereotype.Service;

import java.util.*;



public interface CompanyService {

     List<Company> getAllCompany();
     Boolean UpdateCompany(Company company,Long id);
      void createCompany(Company company);
    Boolean DeleteComapny(Long id);
    Company findComapnyById(Long id);

}
