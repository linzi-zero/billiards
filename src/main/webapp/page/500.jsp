<%@ page language="java" contentType="text/html; charset=GBK"
    isErrorPage="true" pageEncoding="UTF-8"%>
 <%
   response.setStatus(200);
 System.out.println("----------出错了,web.xml");
   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/index.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>错误信息</title>
</head>
<body>
  <div id="error">
  	服务器内部错误!
  </div>
</body>
</html>