package com.tanya.JobBrowser.company.imp;

import com.tanya.JobBrowser.company.Company;
import com.tanya.JobBrowser.company.CompanyRepository;
import com.tanya.JobBrowser.company.CompanyService;
import com.tanya.JobBrowser.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Boolean UpdateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);

        if(companyOptional.isPresent())
        {
            Company companyUpdates = companyOptional.get();
            companyUpdates.setDesc(company.getDesc());
            companyUpdates.setJobs(company.getJobs());
            companyUpdates.setName(company.getName());

            companyRepository.save(companyUpdates);
            return true;
        }

        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Boolean DeleteComapny(Long id) {
        try
        {
            companyRepository.deleteById(id);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public Company findComapnyById(Long id) {
        return companyRepository.findById(id).orElse(null);

    }
}
