<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>在Form表单中使用验证码</title>
    <script type="text/javascript">
    //刷新验证码,验证码后的随机数是必须的，这样才能保证下次图片改变
    function changeImg(obj,createTypeFlag){
        document.getElementById(obj.id).src="${pageContext.request.contextPath}/DrawImage?createTypeFlag="+createTypeFlag+"&"+Math.random();
    }
    </script>
  </head>
  
  <body>
        <form action="${pageContext.request.contextPath}/CheckServlet" method="post">
            验证码：<input type="text" name="validateCode"/>
            <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/DrawImage" id="validateCodeImg" onclick="changeImg(this,'nl')">
            <a id="validateCodeImg" href="javascript:void(0)" onclick="changeImg(this,'nl')">看不清，换一张</a>
            <br/>
            <input type="submit" value="提交">
            <br/>
            <%--  
            中文验证码：<input type="text" name="validateCode"/>
            <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/DrawImage?createTypeFlag=ch" id="validateCodeImg2" onclick="changeImg(this,'ch')">
            <a id="validateCodeImg2" href="javascript:void(0)" onclick="changeImg(this,'ch')">看不清，换一张</a>
            <br/>
            <input type="submit" value="提交">
            <br/>
            数字验证码：<input type="text" name="validateCode"/>
            <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/DrawImage?createTypeFlag=n" id="validateCodeImg3" onclick="changeImg(this,'n')">
            <a id="validateCodeImg3" href="javascript:void(0)" onclick="changeImg(this,'n')">看不清，换一张</a>
            <br/>
            <input type="submit" value="提交">
            <br/> --%>
             
        </form>
  </body>
</html>