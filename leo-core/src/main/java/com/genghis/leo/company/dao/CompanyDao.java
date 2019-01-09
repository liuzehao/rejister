package com.genghis.leo.company.dao;

import com.genghis.leo.company.modle.Company;
import com.genghis.leo.company.modle.CompanyRelation;
import com.genghis.leo.company.modle.classNum;
import com.genghis.steed.annotation.mybatisRepository;

import java.util.List;

/**
 * Created by hao pc on 2016/9/23.
 */
@mybatisRepository
public interface  CompanyDao {
    List<Company> getCompanyListPage(Company company);
    List<Company> searchCompanyListPage(String attribute,String value);
    List<Company> getAllCompanyList();
    String searchIdexit(String id);
   classNum getClassInfo(String id);
    void setCompanyInfo(Company companyInfo);
    void setCompanyHistory(Company companyInfo);
    void deleteCompanyInfo(String id);
    void surePayed(String id);
    CompanyRelation searchCompanyByfid(String id);
  Company getCompanyByid(String id);
}
