package com.genghis.leo.company;

import com.genghis.leo.company.modle.Company;
import com.genghis.leo.company.modle.CompanyRelation;
import com.genghis.leo.company.modle.classNum;
import com.genghis.leo.company.service.companyService;
import com.genghis.steed.ajax.response.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by hao pc on 2017/6/19.
 */
@Controller
@RequestMapping("/admin/company")
public class companyController {
    @Autowired
    private companyService companyService;

    @RequestMapping(value = "getAllcompany", method = {RequestMethod.POST})
    @ResponseBody
    public PageResponse<Company> findAllcompany(Company company) {
        return new PageResponse<>(company.getPage(), companyService.getCompanyListPage(company));
    }
    @RequestMapping(value = "surePayed")
    @ResponseBody
    public HashMap<String, String> surePayed(@RequestParam("idcard") String id){
        companyService.surePayed(id);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("success", " ");
        return map;
    }
    @RequestMapping(value = "getCompanyByfid")
    @ResponseBody
    public CompanyRelation getCompanyByfid(@RequestParam("fid") String fid) {

         CompanyRelation companyRelation=companyService.searchCompanyByfid(fid);

        return companyRelation;
    }
    @RequestMapping(value = "getCompanyByid")
    @ResponseBody
    public Company getCompanyByid(@RequestParam("idcard") String idcard) {

        Company company=companyService.getCompanyByid(idcard);

        return company;
    }
    @RequestMapping(value = "setCompany")
    @ResponseBody
    public String setCompany(HttpServletRequest request) {

        Company company=new Company();
        String category=request.getParameter("category");
        String  classnum=request.getParameter("classnum");
        company.setClassnum(classnum);
        company.setIdcard(request.getParameter("idcard"));
        company.setName(request.getParameter("name"));
        company.setSex(request.getParameter("sex"));
        company.setPhone(request.getParameter("phone"));
        company.setFid(request.getParameter("fid"));
        company.setRname(request.getParameter("rname"));
        company.setBillname(request.getParameter("billname"));
        company.setAddress(request.getParameter("address"));
        company.setStay(category);
        company.setFare1(request.getParameter("fare1"));
        company.setPayway1(request.getParameter("payway1"));
        company.setFare2(request.getParameter("fare2"));
        company.setPayway2(request.getParameter("payway2"));
        company.setFare3(request.getParameter("fare3"));
        company.setPayway3(request.getParameter("payway3"));
        company.setFare4(request.getParameter("fare4"));
        company.setPayway4(request.getParameter("payway4"));
       String day= request.getParameter("day");
        company.setDay(day);
        if(day.equals("no"))
        {
            day="1";
        }
        int sum=0;
        if(category.equals("单间"))
        {
            sum=Integer.parseInt(companyService.getClassInfo(classnum).getSigle())*Integer.parseInt(day);

        }
        if(category.equals("标间"))
        {
            sum=Integer.parseInt(companyService.getClassInfo(classnum).getStandard())*Integer.parseInt(day);
        }
        sum+=Integer.parseInt(companyService.getClassInfo(classnum).getTrain());
        company.setSum(sum + "");
        companyService.setCompanyInfo(company);
        return "redirect:successful";
    }

    @RequestMapping(value = "getSum")
    @ResponseBody
    public HashMap<String, String> getSum(HttpServletRequest request) {


     String classnum= request.getParameter("classnum");
        String category=request.getParameter("category");
        String day=request.getParameter("day");
        if(day.equals("no"))
        {
            day="1";
        }
        int sum=0;
        companyService.getClassInfo(classnum).getSigle();
        if(category.equals("单间"))
        {
            sum=Integer.parseInt(companyService.getClassInfo(classnum).getSigle())*Integer.parseInt(day);
        }
        if(category.equals("标间"))
        {
            sum=Integer.parseInt(companyService.getClassInfo(classnum).getStandard())*Integer.parseInt(day);
        }
        sum+=Integer.parseInt(companyService.getClassInfo(classnum).getTrain());
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("sum", sum+"");
        return map;
    }
}
