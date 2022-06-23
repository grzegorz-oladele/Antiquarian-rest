<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<div class="container">
    <section class="product-form">
        <h3>Dodaj produkt</h3>
        <div class="antiquarian-form">
            <form:form class="form" modelAttribute="product" method="post">
            <div><label for="name">Nazwa: <form:input path="name" placeholder="Podaj nazwę produktu"/><form:errors
                    path="name" cssClass="error"/></label></div>
            <div><label for="description">Opis: <form:input path="description" placeholder="Podaj opis"/><form:errors
                    path="description" cssClass="error"/></label></div>
            <div><label for="productCode">Kod produktu: <form:input path="productCode"
                                                                    placeholder="Podaj kod produktu"/><form:errors
                    path="productCode" cssClass="error" element="div"/></label></div>
            <div><label for="category">Wybierz kategorię: <form:select path="category" itemValue="id" itemLabel="name"
                                                                       items="${categories}"/></label></div>
            <div>
                <button type="submit">Dodaj</button>
                </form:form>
            </div>
    </section>
    <section class="true-tab">
        <div class="table">
            <h4>Produkty dostępne na stanie</h4>
            <table>
                <thead>
                <tr>
                    <th>L.P.</th>
                    <th>Nazwa</th>
                    <th>Opis</th>
                    <th>Kategoria</th>
                    <th>Kod produktu</th>
                    <th>Data dodania</th>
                    <th>Co chcesz zrobić</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${allTrue}" varStatus="loop" var="alt">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td>${alt.name}</td>
                        <td>${alt.description}</td>
                        <td>${alt.category.name}</td>
                        <td class="product-code">${alt.productCode}</td>
                        <td>${alt.date}</td>
                        <td>
                            <a href="<c:url value="/delete?id=${alt.id}"/>">
                                <button type="button">Usuń</button>
                            </a>
                            <a href="<c:url value="/update-false?id=${alt.id}"/>">
                                <button type="button">Sprzedane</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
    <section class="false-tab">
        <div class="table">
            <h4>Archiwalne produkty</h4>
            <table>
                <thead>
                <tr>
                    <th>L.P.</th>
                    <th>Nazwa</th>
                    <th>Opis</th>
                    <th>Kategoria</th>
                    <th>Kod produktu</th>
                    <th>Data dodania</th>
                    <th>Co chcesz zrobić</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${allFalse}" varStatus="loop" var="alf">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td>${alf.name}</td>
                        <td>${alf.description}</td>
                        <td>${alf.category.name}</td>
                        <td class="product-code">${alf.productCode}</td>
                        <td>${alf.date}</td>
                        <td>
                            <a href="<c:url value="/delete?id=${alf.id}"/>">
                                <button type="button">Usuń</button>
                            </a>
                            <a href="<c:url value="/update-true?id=${alf.id}"/>">
                                <button type="button">Niesprzedane</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
</div>
<%@include file="footer.jsp" %>

