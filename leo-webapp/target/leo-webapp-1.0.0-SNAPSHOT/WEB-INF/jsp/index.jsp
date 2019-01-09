<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<!DOCTYPE html>
<html>
<head>
    <title>中国质量认证中心杭州分中心</title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
    function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //for-mobile-apps -->
    <!-- js -->
    <script src="/assets/table/js/jquery-2.1.3.min.js" type="text/javascript"></script>
    <!-- //js -->
    <link href="/assets/table/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href='//fonts.googleapis.com/css?family=Poppins:400,300,500,600,700' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="main">
    <h1 class="w3layouts_head">中国质量认证中心杭州分中心</h1>
    <div class="w3layouts_main_grid">
        <div  class="w3_form_post">
            <div class="w3_agileits_main_grid w3l_main_grid">
                <div class="agileits_grid">
                    <h5>身份证号 </h5>
                    <input id="idcard"type="long"  placeholder="ex : 330522************(必填)" required="">
                </div>
            </div>
            <div class="w3_agileits_main_grid w3l_main_grid">
                <div class="agileits_grid">
                    <h5>工厂编号 </h5>
                    <input id="fid"type="long" name="Email" placeholder="ex : A112531(选填)" required="">
                </div>
            </div>
            <div class="w3_agileits_main_grid w3l_main_grid">
                <div class="agileits_grid">
                    <h5 >姓名 </h5>
                    <div class="nam">
                        <input type="text" id="name" required="">
                    </div>
                    <div class="nam1" >
                        <h5 >性别</h5>
                        <select id="sex"  required="">
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>

            <div class="w3_agileits_main_grid w3l_main_grid">
                <div class="agileits_grid">
                    <h5>联系手机 </h5>
                    <input id="phone"type="long"  placeholder="ex : 189********" required="">
                </div>
            </div>

            <div class="w3_agileits_main_grid w3l_main_grid">
                <div class="agileits_grid">
                    <h5>报名企业 </h5>
                    <input id="rname"type="long" name="Email"  required="">${companyRelation.rname}
                </div>
            </div>
            <div class="w3_agileits_main_grid w3l_main_grid">
                <div class="agileits_grid">
                    <h5>开票单位 </h5>
                    <input id="billname"type="long" name="Email" value="" required="">${companyRelation.billname}
                </div>
            </div>
            <div class="w3_agileits_main_grid w3l_main_grid">
                <div class="agileits_grid">
                    <h5>地址（寄送发票地址） </h5>
                    <input id="address"type="long" name="Email" required="">
                </div>
            </div>
            <div class="w3_agileits_main_grid w3l_main_grid">
                <div class="agileits_grid">
                    <h5>上课班级</h5>
                    <input id="classnum"type="long" name="Email" required=""placeholder="管理员通知(必填)">
                </div>
            </div>

            <div class="w3_agileits_main_grid w3l_main_grid">
                <div class="wthree_grid">
                    <h5>是否住宿</h5>
                    <div class="nam2" >
                        <select id="category" required="" class="pay_way">
                            <option value="">请选择(必选)</option>
                            <option value="不住">不住</option>
                            <option value="单间">单间</option>
                            <option value="标间">标间</option>
                        </select>
                    </div>
                </div>
                    <div class="nam3">
                        <input id="day" placeholder="入住天数(必填)" style="display:none;">
                        <h5 id="sum">学费总计:</h5>
                    </div>

                    <div class="clear"></div>
                </div>
            </div>
            <div class="w3_agileits_main_grid w3l_main_grid">
                <div class="agileits_grid">
                    <h5 >付费方式 </h5>
                    <div class="nam2" >
                        <select id="payway1" required="" class="pay_way">
                            <option value="现金">现金</option>
                            <option value="转账">转账</option>
                            <option value="微信">微信</option>
                            <option value="支付宝">支付宝</option>
                        </select>
                    </div>
                    <div class="nam3">
                        <input type="text1" id="fare1" required=""placeholder="此方式金额">
                    </div>

                    <div class="clear"></div>
                </div>
            </div>
            <h6 ><a id="more1" href="javascript:void(0);">点击更多付费方式</a> </h6>
            <div class="w3_agileits_main_grid w3l_main_grid" id="hide1"style="display:none;">
                <div class="agileits_grid">
                    <h5 >付费方式 </h5>
                    <div class="nam2" >
                        <select id="payway2" required="" class="pay_way">
                            <option value="现金">现金</option>
                            <option value="转账">转账</option>
                            <option value="微信">微信</option>
                            <option value="支付宝">支付宝</option>
                        </select>
                    </div>
                    <div class="nam3">
                        <input type="text1" id="fare2" required=""placeholder="此方式金额">
                    </div>

                    <div class="clear"></div>
                </div>
            </div>
            <h6 ><a id="more2" href="javascript:void(0);"style="display:none;">点击更多付费方式</a> </h6>
            <div class="w3_agileits_main_grid w3l_main_grid" id="hide2"style="display:none;">
                <div class="agileits_grid">
                    <h5 >付费方式 </h5>
                    <div class="nam2" >
                        <select id="payway3" required="" class="pay_way">
                            <option value="现金">现金</option>
                            <option value="转账">转账</option>
                            <option value="微信">微信</option>
                            <option value="支付宝">支付宝</option>
                        </select>
                    </div>
                    <div class="nam3">
                        <input type="text1" id="fare3" required=""placeholder="此方式金额">
                    </div>

                    <div class="clear"></div>
                </div>
            </div>
            <h6 ><a id="more3" href="javascript:void(0);"style="display:none;">点击更多付费方式</a> </h6>
            <div class="w3_agileits_main_grid w3l_main_grid" id="hide3"style="display:none;">
                <div class="agileits_grid">
                    <h5 >付费方式 </h5>
                    <div class="nam2" >
                        <select id="payway4" required="" class="pay_way">
                            <option value="现金">现金</option>
                            <option value="转账">转账</option>
                            <option value="微信">微信</option>
                            <option value="支付宝">支付宝</option>
                        </select>
                    </div>
                    <div class="nam3">
                        <input type="text1" id="fare4" required=""placeholder="此方式金额">
                    </div>

                    <div class="clear"></div>
                </div>
            </div>
            <h6 ><a id="close" href="javascript:void(0);"style="display:none;">收起</a> </h6>



            <div class="w3_main_grid">

                <div class="w3_main_grid_right">
                    <input id="mit"type="submit" value="提交">
                </div>
                <div class="clear"> </div>
            </div>
        </div>
    </div>
    <!-- Calendar -->
    <link rel="stylesheet" href="/assets/table/css/jquery-ui.css" />
   <!--<script src="/assets/table/js/jquery-ui.js"></script>-->
    <script>
        var basePath = (function() {
            var url = window.location + "";
            var h = url.split("//");
            var x = h[1].split("/");
            return h[0] + "//" + window.location.host + "/" + x[1] ;
        })();
        /*  $(function() {
            $( "#datepicker,#datepicker1" ).datepicker();
        });
        $(document).ready(function(){
            $("#mit").click(function(){
              alert($("#sex").val());
            });
        });*/
        $("#fid").blur(function(){
            $.ajax({
                url:basePath +"admin/company/getCompanyByfid?fid="+ $("#fid").val(),
                type:"get",
                dataType:'json',
                success:function (data){
                    $("#rname").val(data.rname);
                    $("#billname").val(data.billname);
                    $("#address").val(data.address);
                }
            })

        });
        $("#idcard").blur(function(){
            $.ajax({
                url:basePath +"admin/company/getCompanyByid?idcard="+ $("#idcard").val(),
                type:"get",
                dataType:'json',
                success:function (data){
                    $("#rname").val(data.rname);
                    $("#billname").val(data.billname);
                    $("#address").val(data.address);

                    $("#idcard").val(data.idcard);
                            $("#name").val(data.name);
                            $("#sex").val(data.sex);
                           $("#phone").val(data.phone);
                            $("#fid").val(data.fid);
                          $("#rname").val(data.  rname);
                         $("#billname").val(data.   billname);
                           $("#address").val(data. address);
                         $("#category").val(data.stay);
                          $("#fare1").val(data.  fare1);
                            $("#payway1").val(data.payway1);
                           $("#fare2").val(data. fare2);
                            $("#payway2").val(data.payway2);
                            $("#fare3").val(data.fare3);
                           $("#payway3").val(data. payway3);
                            $("#fare4").val(data.fare4);
                            $("#payway4").val(data.payway4);
                            $("#classnum").val(data.classnum);
                    $("#sum").replaceWith( "<h4 id=\'sum\'style=\'color:greenyellow;font-weight:bold\' >学费总计:"+data.sum+"</h4>");
                }
            })

        });
        $("#day").blur(function(){
            if($("#day").val()=="")
            {
                $("#day").val("no")
            }
            $.ajax({
                url:basePath +"admin/company/getSum",
                type:"post",
                dataType:'json',
                data:{
                    classnum:$("#classnum").val(),
                    category:$("#category").val(),
                    day:$("#day").val()
                },
                success:function (data){
                    $("#sum").replaceWith( "<h4 id=\'sum\'style=\'color:greenyellow;font-weight:bold\' >学费总计:"+data.sum+"</h4>");
                }
        })
        });
        $("#category").change(function(){
          if($("#category").val()=="单间"||$("#category").val()=="标间")
          {
              $("#day").show();
          }else{$(
                  "#day").hide();
              $("#day").val("no");
              $.ajax({
                  url:basePath +"admin/company/getSum",
                  type:"post",
                  dataType:'json',
                  data:{
                      classnum:$("#classnum").val(),
                      category:$("#category").val(),
                      day:$("#day").val()
                  },
                  success:function (data){
                      $("#sum").replaceWith( "<h4 id=\'sum\'style=\'color:greenyellow;font-weight:bold\' >学费总计:"+data.sum+"</h4>");
                  }
              })
          }


        });

         $("#mit").on("click",function (){
             if($("#day").val()=="")
             {
                 $("#day").val("no")
             }
            $.ajax({
                url:basePath +"admin/company/setCompany",
                type:"post",
                data:{
                    idcard:$("#idcard").val(),
                    name:$("#name").val(),
                    sex:$("#sex").val(),
                    phone:$("#phone").val(),
                    fid:$("#fid").val(),
                    rname:$("#rname").val(),
                    billname:$("#billname").val(),
                    address:$("#address").val(),
                    category:$("#category").val(),
                    fare1:$("#fare1").val(),
                    payway1:$("#payway1").val(),
                    fare2:$("#fare2").val(),
                    payway2:$("#payway2").val(),
                    fare3:$("#fare3").val(),
                    payway3:$("#payway3").val(),
                    fare4:$("#fare4").val(),
                    payway4:$("#payway4").val(),
                    classnum:$("#classnum").val(),
                    day:$("#day").val()
                },
                success:function (){
                    window.location.href=basePath+"successful";
                },
                error: function (data) {
                    alert("失败，请确认您上课班级正确");
                }
            })
        });
        $("#more1").on("click",function (){
          $("#hide1").show();
            $("#more1").hide();
            $("#more2").show();
        });
        $("#more2").on("click",function (){
            $("#hide2").show();
            $("#more2").hide();
            $("#more3").show();
        });
        $("#more3").on("click",function (){
            $("#hide3").show();
            $("#more3").hide();
            $("#close").show();
        });
        $("#close").on("click",function (){
            $("#hide1").hide();
            $("#hide2").hide();
            $("#hide3").hide();
            $("#more1").show();
            $("#close").hide();
        });
    </script>
    <!-- //Calendar -->
    <div class="agileits_copyright">
        <p>© 2017 CQC. All rights reserved </p>
    </div>
</div>
</body>
</html>