package com.genghis.leo.company.service;

import com.genghis.leo.company.modle.Company;
import com.genghis.leo.company.modle.CompanyRelation;
import com.genghis.leo.company.modle.classNum;

import java.util.List;

/**
 * Created by hao pc on 2017/6/19.
 */
public interface companyService {
    List<Company> getCompanyListPage(Company company);
    List<Company> searchCompanyListPage(String attribute, String value);
    List<Company> getAllCompanyList();
    void setCompanyInfo(Company stuInfo);
    void deleteCompanyInfo(String id);
    String searchIdexit(String id);
    CompanyRelation searchCompanyByfid(String id);
    void surePayed(String id);
    classNum getClassInfo(String id);
    Company getCompanyByid(String id);
}
