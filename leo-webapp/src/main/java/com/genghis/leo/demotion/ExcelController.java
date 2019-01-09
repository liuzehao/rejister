package com.genghis.leo.demotion;

import com.genghis.leo.company.modle.Company;
import com.genghis.leo.company.service.companyService;
import com.genghis.leo.demotion.model.StuGrade;
import com.genghis.leo.demotion.model.StuInfo;
import com.genghis.leo.demotion.model.StuPlan;
import com.genghis.leo.demotion.model.StuWrong;
import com.genghis.leo.demotion.service.StuService;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Label;
import jxl.write.biff.RowsExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hao pc on 2016/9/24.
 */
@Controller
public class ExcelController {

    private String stu_info = "20140045";

    @Autowired
    private StuService stuService;
    @Autowired
    private companyService companyservice;
    @RequestMapping(value = "/admin/excel/getExcel", method = {RequestMethod.GET})
    public String getExcelPage() {
        return "/admin/excel/addExcelDo";
    }

    //导出不及格且没有被替换的课程
    @RequestMapping("/exportFailCoursePage")
    public String exportFailCoursePage(){
        return "/admin/excel/exportFailCoursePage";
    }

    @RequestMapping("/exportFailCourse")
    @ResponseBody
    public String exportFailCourse(String path){
        List<StuGrade> failCourses = stuService.getFailCourseWOReplace();
        File exportFile = new File(path);
        if (exportFile.exists())
            exportFile.delete();
        // 打开文件
        WritableWorkbook book;
        try {
            book = Workbook.createWorkbook(exportFile);
            // 生成名为“第一页”的工作表，参数0表示这是第一页
            WritableSheet sheet = book.createSheet("sheet1", 0);
            exportFailCourseFirstRow(sheet);
            exportFailCourseOtherRow(sheet, failCourses);
            book.write();
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"msg\":\"error\"}";
        } catch (RowsExceededException e) {
            e.printStackTrace();
            return "{\"msg\":\"error\"}";
        } catch (WriteException e) {
            e.printStackTrace();
            return "{\"msg\":\"error\"}";
        }

        return "{\"msg\":\"success\"}";
    }

    public void exportFailCourseOtherRow(WritableSheet sheet, List<StuGrade> failCourses) throws WriteException {
        Label label;
        for(int i = 1; i <= failCourses.size(); i++){
            StuGrade stuGrade = failCourses.get(i-1);
            label = new Label(0, i, stuGrade.getSno()==null?"":stuGrade.getSno());
            sheet.addCell(label);
            label = new Label(1, i, stuGrade.getName()==null?"":stuGrade.getName());
            sheet.addCell(label);
            label = new Label(2, i, stuGrade.getSemester()==null?"":stuGrade.getSemester());
            sheet.addCell(label);
            label = new Label(3, i, stuGrade.getCno()==null?"":stuGrade.getCno());
            sheet.addCell(label);
            label = new Label(4, i, stuGrade.getCourseNo()==null?"":stuGrade.getCourseNo());
            sheet.addCell(label);
            label = new Label(5, i, stuGrade.getCourseName());
            sheet.addCell(label);
            label = new Label(6, i, stuGrade.getUsualGrade()==null?"":stuGrade.getUsualGrade());
            sheet.addCell(label);
            label = new Label(7, i, stuGrade.getExperGrade()==null?"":stuGrade.getExperGrade());
            sheet.addCell(label);
            label = new Label(8, i, stuGrade.getTotalGrade()==null?"":stuGrade.getTotalGrade());
            sheet.addCell(label);
            label = new Label(9, i, stuGrade.getGradeId()==null?"":stuGrade.getGradeId());
            sheet.addCell(label);
            label = new Label(10, i, stuGrade.getCoursePro()==null?"":stuGrade.getCoursePro());
            sheet.addCell(label);
            label = new Label(11, i, stuGrade.getCourseAttr()==null?"":stuGrade.getCourseAttr());
            sheet.addCell(label);
            label = new Label(12, i, stuGrade.getPeriod()==null?"":stuGrade.getPeriod());
            sheet.addCell(label);
            label = new Label(13, i, String.valueOf(stuGrade.getCredit()));
            sheet.addCell(label);
            label = new Label(14, i, stuGrade.getGpa()==null?"":stuGrade.getGpa());
            sheet.addCell(label);
            label = new Label(15, i, stuGrade.getCourseDepart()==null?"":stuGrade.getCourseDepart());
            sheet.addCell(label);
            label = new Label(16, i, stuGrade.getExamPro()==null?"":stuGrade.getExamPro());
            sheet.addCell(label);
        }
    }

    /**
     * excel导出第一行
     * @param sheet
     * @throws WriteException
     */
    public void exportFailCourseFirstRow(WritableSheet sheet) throws WriteException {
        Label label;
        label = new Label(0, 0, "学号");
        sheet.addCell(label);
        label = new Label(1, 0, "姓名");
        sheet.addCell(label);
        label = new Label(2, 0, "学期");
        sheet.addCell(label);
        label = new Label(3, 0, "班级");
        sheet.addCell(label);
        label = new Label(4, 0, "课程号");
        sheet.addCell(label);
        label = new Label(5, 0, "课程名称");
        sheet.addCell(label);
        label = new Label(6, 0, "平时成绩");
        sheet.addCell(label);
        label = new Label(7, 0, "实验成绩");
        sheet.addCell(label);
        label = new Label(8, 0, "总成绩");
        sheet.addCell(label);
        label = new Label(9, 0, "成绩标识");
        sheet.addCell(label);
        label = new Label(10, 0, "课程性质");
        sheet.addCell(label);
        label = new Label(11, 0, "课程属性");
        sheet.addCell(label);
        label = new Label(12, 0, "学时");
        sheet.addCell(label);
        label = new Label(13, 0, "学分");
        sheet.addCell(label);
        label = new Label(14, 0, "绩点");
        sheet.addCell(label);
        label = new Label(15, 0, "开课学院");
        sheet.addCell(label);
        label = new Label(16, 0, "考试性质");
        sheet.addCell(label);
    }



    //导出不及格信息到excel
    @RequestMapping("/admin/exportExcelPage")
    public String exportExcelPage(){
        return "/admin/excel/exportExcelPage";
    }



    @RequestMapping("/admin/exportExcel")
    @ResponseBody
    public String exportExcel(String path,HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        List<Company> list =  companyservice.getAllCompanyList();
        //String fullFileName =request.getServletContext().getRealPath("/upload/documents/aaa.xls");

        File exportFile = new File(path);
        if (exportFile.exists())
            exportFile.delete();
        // 打开文件
        WritableWorkbook book = null;
        try {
            book = Workbook.createWorkbook(exportFile);
            // 生成名为“第一页”的工作表，参数0表示这是第一页
            WritableSheet sheet = book.createSheet("sheet1", 0);
            exportFirstRow(sheet);
            exportWrongFirstRow(sheet);
            exportWrongOtherRow(sheet, list);
            book.write();
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"msg\":\"error\"}";
        } catch (RowsExceededException e) {
            e.printStackTrace();
            return "{\"msg\":\"error\"}";
        } catch (WriteException e) {
            e.printStackTrace();
            return "{\"msg\":\"error\"}";
        }

        //读取文件
        /*InputStream in = new FileInputStream(fullFileName);

        OutputStream out = response.getOutputStream();

        //写文件
        int b;
        while((b=in.read())!= -1)
        {
            out.write(b);
        }

        in.close();
        out.close();*/
        return "{\"msg\":\"success\"}";
    }



    public void exportWrongOtherRow(WritableSheet sheet, List<Company> list) throws WriteException {
        Label label;
        int t=0;//t为未付钱的人
        for(int i = 2; (i-1) <= list.size(); i++){

            Company company = list.get(i-2);
            if(company.getPayed().equals("1")) {
                label = new Label(0, i, (i - 1-t) + "");
                sheet.addCell(label);
                label = new Label(1, i, company.getClassnum());
                sheet.addCell(label);
                label = new Label(2, i, company.getFid());
                sheet.addCell(label);
                label = new Label(3, i, company.getRname());
                sheet.addCell(label);
                label = new Label(4, i, company.getName());
                sheet.addCell(label);
                label = new Label(5, i, company.getSex());
                sheet.addCell(label);
                label = new Label(6, i, company.getIdcard());
                sheet.addCell(label);
                label = new Label(7, i, company.getBillname());
                sheet.addCell(label);
                label = new Label(8, i, company.getAddress());
                sheet.addCell(label);
                label = new Label(9, i, company.getPhone());
                sheet.addCell(label);
                label = new Label(10, i, company.getStay());
                sheet.addCell(label);
                label = new Label(11, i, company.getDay());
                sheet.addCell(label);
                label = new Label(12, i, company.getPayway1());
                sheet.addCell(label);
                label = new Label(13, i, company.getFare1());
                sheet.addCell(label);
                label = new Label(14, i, company.getPayway2());
                sheet.addCell(label);
                label = new Label(15, i, company.getFare2());
                sheet.addCell(label);
                label = new Label(16, i, company.getPayway3());
                sheet.addCell(label);
                label = new Label(17, i, company.getFare3());
                sheet.addCell(label);
                label = new Label(18, i, company.getPayway4());
                sheet.addCell(label);
                label = new Label(19, i, company.getFare4());
                sheet.addCell(label);
                label = new Label(20, i, company.getSum());
                sheet.addCell(label);
            }else{t++;}
        }
    }

    /**
     * excel导出不及格信息第一行
     * @param sheet
     * @throws WriteException
     */
    public void exportWrongFirstRow(WritableSheet sheet) throws WriteException {
        Label label;
        label = new Label(0, 1, "序号");
        sheet.addCell(label);
        label = new Label(1, 1, "培训班级");
        sheet.addCell(label);
        label = new Label(2, 1, "工厂编号");
        sheet.addCell(label);
        label = new Label(3, 1, "工厂名称");
        sheet.addCell(label);
        label = new Label(4, 1, "姓名");
        sheet.addCell(label);
        label = new Label(5, 1, "性别");
        sheet.addCell(label);
        label = new Label(6, 1, "身份证号码");
        sheet.addCell(label);
        label = new Label(7, 1, "发票抬头");
        sheet.addCell(label);
        label = new Label(8, 1, "寄送发票地址");
        sheet.addCell(label);
        label = new Label(9, 1, "联系手机");
        sheet.addCell(label);
        label = new Label(10, 1, "是否住宿");
        sheet.addCell(label);
        label = new Label(11, 1, "住宿天数");
        sheet.addCell(label);
        label = new Label(12, 1, "付费型式1");
        sheet.addCell(label);
        label = new Label(13, 1, "费用1");
        sheet.addCell(label);
        label = new Label(14, 1, "付费型式2");
        sheet.addCell(label);
        label = new Label(15, 1, "费用2");
        sheet.addCell(label);
        label = new Label(16, 1, "付费型式3");
        sheet.addCell(label);
        label = new Label(17, 1, "费用3");
        sheet.addCell(label);
        label = new Label(18, 1, "付费型式4");
        sheet.addCell(label);
        label = new Label(19, 1, "费用4");
        sheet.addCell(label);
        label = new Label(20, 1, "总计");
        sheet.addCell(label);

    }
    public void exportFirstRow(WritableSheet sheet) throws WriteException {
        Label label;
        label = new Label(0, 0, "导入：中国质量认证中心杭州分中心企业/ 导出： 中国质量认证中心杭州分中心培训报名表 ");
        sheet.addCell(label);

    }

    @RequestMapping(value = "/admin/uploadFile", method = RequestMethod.POST)//上传Excel
    public
    @ResponseBody
    HashMap<String, String> uploadFile(@RequestParam(value = "input", required = true) MultipartFile file, int fileType, String createYear) throws IOException, BiffException {

        //createYear = new String(createYear.getBytes("ISO-8859-1"), "UTF-8");
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("false", " ");//标志
        if (file != null) {

            String myFileName = file.getOriginalFilename();
            //如果名称不为“”,说明该文件存在，否则说明该文件不存在
            System.out.println(myFileName);//Excel已经读入内存
            map.put("true", " ");//返回成功
            //是学生信息

            insertStuInfo(file);
        }
        return map;
    }

    /**
     * 导入培养计划
     *
     * @param file
     * @throws IOException
     * @throws BiffException
     */
    private void insertStuPlan(MultipartFile file) throws IOException, BiffException {
        Workbook workbook = Workbook.getWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheet(0);
        int rowNums = sheet.getRows();
        int col = 1;
        StuPlan stuPlan;
        System.out.println("导入开始");
        for (int row = 1; row < rowNums; row++) {
            stuPlan = new StuPlan();
            //学期 学院 届数 专业 课程编号 课程名称 学分 课程属性 开设单位 班级号 所属平台
            stuPlan.setSemester(sheet.getCell(col++, row).getContents());
            stuPlan.setCollege(sheet.getCell(col++, row).getContents());
            stuPlan.setTh(sheet.getCell(col++, row).getContents());
            stuPlan.setMajor(sheet.getCell(col++, row).getContents());
            stuPlan.setCourseNo(sheet.getCell(col++, row).getContents());
            stuPlan.setCourseName(sheet.getCell(col++, row).getContents());
            stuPlan.setCredit(Float.valueOf(sheet.getCell(col++, row).getContents()));
            stuPlan.setCourseAttr(sheet.getCell(col++, row).getContents());
            stuPlan.setCourseDepart(sheet.getCell(col++, row).getContents());
            stuPlan.setCno(sheet.getCell(col++, row).getContents());
            stuPlan.setPlatform(sheet.getCell(col, row).getContents());
            col = 1;
            stuService.setStuPlan(stuPlan);
        }
        System.out.println("导入完成");
    }

    /**
     * 导入学生成绩
     *
     * @param file
     * @throws IOException
     * @throws BiffException
     */
    private void insertStuGrade(MultipartFile file) throws IOException, BiffException {
        Workbook workbook = Workbook.getWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheet(0);
        int rowNums = sheet.getRows();
        int col = 0;
        StuGrade stuGrade;
        System.out.println("导入开始");
        for (int row = 1; row < rowNums; row++) {
            if (sheet.getCell(col, row).getContents().equals(""))
                break;

            //用于测试
            //if (sheet.getCell(col, row).getContents().equals(stu_info)) {
            stuGrade = new StuGrade();
            //学号 姓名 开课学期 班级 课程编号 课程名称 平时成绩 实验成绩 总成绩 成绩标志 课程性质 课程属性 学时 学分 绩点 开课单位 录入人 考试性质 重补学期
            stuGrade.setSno(sheet.getCell(col++, row).getContents());
            stuGrade.setName(sheet.getCell(col++, row).getContents());
            stuGrade.setSemester(sheet.getCell(col++, row).getContents());
            stuGrade.setCno(sheet.getCell(col++, row).getContents());
            stuGrade.setCourseNo(sheet.getCell(col++, row).getContents());
            stuGrade.setCourseName(sheet.getCell(col++, row).getContents());
            stuGrade.setUsualGrade(sheet.getCell(col++, row).getContents());
            stuGrade.setExperGrade(sheet.getCell(col++, row).getContents());
            stuGrade.setTotalGrade(convertTotalGrade(sheet.getCell(col++, row).getContents()));
            stuGrade.setGradeId(sheet.getCell(col++, row).getContents());
            stuGrade.setCoursePro(sheet.getCell(col++, row).getContents());
            stuGrade.setCourseAttr(sheet.getCell(col++, row).getContents());
            stuGrade.setPeriod(sheet.getCell(col++, row).getContents());
            stuGrade.setCredit(Float.valueOf(sheet.getCell(col++, row).getContents()));

            stuGrade.setGpa(sheet.getCell(col++, row).getContents());
            stuGrade.setCourseDepart(sheet.getCell(col++, row).getContents());
            stuGrade.setTypeMan(sheet.getCell(col++, row).getContents());
            stuGrade.setExamPro(sheet.getCell(col++, row).getContents());
            stuGrade.setReSemester(sheet.getCell(col++, row).getContents());
            stuGrade.setRemark(sheet.getCell(col++, row).getContents());
            stuGrade.setStatus(sheet.getCell(col, row).getContents());
            col = 0;
            stuService.setStuGrade(stuGrade);
            //}
        }
        System.out.println("导入完成");
    }

    private String convertTotalGrade(String totalGrade){
        if (totalGrade.equals("优")){
            return "95";
        }else if(totalGrade.equals("良")){
            return "85";
        }else if(totalGrade.equals("中")){
            return "75";
        }else if(totalGrade.equals("及格")){
            return "65";
        }else if(totalGrade.equals("不及格")){
            return "0";
        }else {
            return totalGrade;
        }
    }


    /**
     * 导入学生信息
     *
     * @param file
     * @throws IOException
     * @throws BiffException
     */
    private void insertStuInfo(MultipartFile file) throws IOException, BiffException {
        Workbook workbook = Workbook.getWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheet(0);
        int rowNums = sheet.getRows();
        int col = 1;
        Company company;
        System.out.println("导入开始");
        for (int row = 2; row < rowNums; row++) {
            System.out.printf("1");
            //用于测试
//            String sno = sheet.getCell(col, row).getContents();
//            if (sno.equals(stu_info)){
            company = new Company();
            company.setClassnum(sheet.getCell(col++, row).getContents());
            company.setFid(sheet.getCell(col++, row).getContents());
            company.setRname(sheet.getCell(col++, row).getContents());
            company.setName(sheet.getCell(col++, row).getContents());
            company.setSex(sheet.getCell(col++, row).getContents());
            company.setIdcard(sheet.getCell(col++, row).getContents());
            company.setBillname(sheet.getCell(col++, row).getContents());
            company.setAddress(sheet.getCell(col++, row).getContents());
            company.setPhone(sheet.getCell(col++, row).getContents());
            company.setStay(sheet.getCell(col++, row).getContents());
            company.setDay(sheet.getCell(col++, row).getContents());

            company.setPayway1(sheet.getCell(col++, row).getContents());
            company.setFare1(sheet.getCell(col++, row).getContents());

            company.setPayway2(sheet.getCell(col++, row).getContents());
            company.setFare2(sheet.getCell(col++, row).getContents());

            company.setPayway3(sheet.getCell(col++, row).getContents());
            company.setFare3(sheet.getCell(col++, row).getContents());

            company.setPayway4(sheet.getCell(col++, row).getContents());
            company.setFare4(sheet.getCell(col++, row).getContents());
            company.setSum(sheet.getCell(col++, row).getContents());
                //stuInfo.setEnterDate(sheet.getCell(col, row).getContents());
                //stuInfo.setCreateYear(createYear);
                col = 1;
                companyservice.setCompanyInfo(company);
//            }
        }
        System.out.println("导入完成");
    }
}
