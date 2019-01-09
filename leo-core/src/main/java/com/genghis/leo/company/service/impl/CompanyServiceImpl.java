package com.genghis.leo.company.service.impl;

import com.genghis.leo.company.dao.CompanyDao;

import com.genghis.leo.company.modle.Company;


import com.genghis.leo.company.modle.CompanyRelation;
import com.genghis.leo.company.modle.classNum;
import com.genghis.leo.company.service.companyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hao pc on 2016/9/23.
 */
@Service("CompanyService")
public class CompanyServiceImpl implements companyService {
    @Autowired
    private CompanyDao companydao;
    @Override
    public List<Company> getCompanyListPage(Company company)
    {
        return companydao.getCompanyListPage(company);
    }
    @Override
    public List<Company> searchCompanyListPage(String attribute,String value){
        return companydao.searchCompanyListPage(attribute, value);
    }
    @Override
    public void setCompanyInfo(Company company) {
        companydao.setCompanyInfo(company);
        companydao.setCompanyHistory(company);
    }

    @Override
    public void deleteCompanyInfo(String id) {
        companydao.deleteCompanyInfo(id);
    }
    @Override
    public List<Company> getAllCompanyList()
    {
        return companydao.getAllCompanyList();
    }
    @Override
    public String searchIdexit(String id) {
        String i=  companydao.searchIdexit(id);
        return i;
    }
    @Override
    public CompanyRelation searchCompanyByfid(String id) {

        return  companydao.searchCompanyByfid(id);
    }
    @Override
    public void surePayed(String id) {

       companydao.surePayed(id);
    }
    @Override
    public classNum getClassInfo(String id)
    {
        return companydao.getClassInfo(id);
    }
    @Override
    public Company getCompanyByid(String id)
    {
        return companydao.getCompanyByid(id);
    }
}