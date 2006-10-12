<%@ include file="/WEB-INF/jsp/include.jsp"%>

<html>
  <head>
    <title>Show file</title>
    <%@ include file="/WEB-INF/jsp/head.jsp"%>
    <link href="jhighlight.css" rel="stylesheet" type="text/css"/>
  </head>

  <body>
    <%@ include file="/WEB-INF/jsp/top.jsp"%>

    <c:url value="blame.svn" var="blameUrl">
      <c:param name="path" value="${command.path}${entry.name}" />
    </c:url>

    <c:url value="get.svn" var="downloadUrl">
      <c:param name="path" value="${command.path}${entry.name}" />
    </c:url>

    <c:url value="showlog.svn" var="showLogUrl">
      <c:param name="path" value="${command.path}${entry.name}" />
    </c:url>
    
    <p class="sventonHeader">
    Show File - <c:out value="${command.target}"/>
    </p>

    <table class="sventonFunctionLinksTable">
      <tr>
        <td><a href="<c:out value="${showLogUrl}&revision=${command.revision}"/>">[Show log]</a></td>
        <td><a href="<c:out value="${downloadUrl}&revision=${command.revision}"/>">[Download]</a></td>
        <td><a href="#">[Diff with previous]</a></td>
        <td><a href="<c:out value="${blameUrl}&revision=${command.revision}"/>">[Blame]</a></td>
      </tr>
    </table>

    <c:choose>
      <c:when test="${empty fileContents}">
<p>
  <a href="<c:out value="${downloadUrl}&revision=${command.revision}"/>&disp=inline">
    <img src="<c:out value="${downloadUrl}&revision=${command.revision}"/>&disp=thumb"/>
  </a>
</p>
      </c:when>
     	<c:otherwise>
<p>
<pre>
<c:out value="${fileContents}" escapeXml="false"/>
</pre>
</p>
</c:otherwise>
</c:choose>
<br>
<%@ include file="/WEB-INF/jsp/foot.jsp"%>
  </body>
</html>