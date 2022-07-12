<%@ attribute name="pageLink" required="true" %>
<%@ attribute name="page" required="true" type="org.springframework.data.domain.Page" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:doBody/>
<c:if test="${page.totalPages > 0}">
    <div>
        <label>Page : </label>
        <c:forEach begin="1" varStatus="status" end="${page.totalPages}">
            <a style="text-decoration: none"
               class="${page.number+1 eq status.count ? 'alert-container' : ''}"
               href="${pageLink}/?page=${status.index}&size=${page.size}">${status.count}
            </a>
        </c:forEach>
    </div>
</c:if>