<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<main>
    <section class="form-registration">
        <form:form class="form" modelAttribute="user" method="post">
            <div><label for="username">Nazwa użytkownika: <form:input path="username"
                                                                      placeholder="Podaj nazwę użytkownika"/></label>
            </div>
            <div><label for="password">Podaj hasło: <form:password path="password" placeholder="Podaj hasło"/></label>
            </div>
            <div><label for="password2">Powtórz hasło: <input name="password2" id="password2" type="password"
                                                              placeholder="Powtórz hasło"></label></div>
            <div><label for="email">Podaj email: <form:input path="email" placeholder="Podaj email"/></label></div>
            <div>
                <button type="submit">Zarejestruj</button>
            </div>
        </form:form>
    </section>
</main>
<%@include file="footer.jsp" %>