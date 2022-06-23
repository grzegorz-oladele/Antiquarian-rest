<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<main>
    <section class="category">
        <div class="container">
            <div class="antiquarian-form">
                <form:form modelAttribute="category" method="post">
                    <label for="name">Podaj nazwę kategorii:</label>
                    <form:input path="name"/>
                    <form:errors path="name" cssClass="error"/>
                    <button type="submit">Zapisz</button>
                </form:form>
            </div>
        </div>
    </section>
    <section class="category-tab">
        <div class="table">
            <table>
                <thead>
                <tr>
                    <th>L.P.</th>
                    <th>Kategoria</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${categories}" varStatus="loop" var="cat">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td>${cat.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
</main>
<%@include file="footer.jsp" %>