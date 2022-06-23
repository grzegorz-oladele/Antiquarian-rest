<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ include file="header.jsp" %>
<main>
    <section class="form-login">
        <div class="container">
            <form class="form" method="post">
                <div><label> User Name : <input type="text" name="username"/> </label></div>
                <div class="margin-left"><label> Password: <input type="password" name="password"/> </label></div>
                <div class="margin-left"><button type="submit">Zaloguj się</button></div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>
    </section>
</main>
<%@include file="footer.jsp" %>