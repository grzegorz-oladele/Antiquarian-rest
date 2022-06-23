<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<main>
    <section>
        <div class="container index-view">
            <div class="product count">
                <p>Produktów w magazynie: <c:url value="${productsCount}"/></p>
            </div>
            <div class="category count">
                <p>Liczba kategorii: <c:url value="${categoriesCount}"/></p>
            </div>
        </div>
    </section>
</main>
<%@include file="footer.jsp" %>