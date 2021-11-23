<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<body>
<h3>Страница для всех работников</h3>

<security:authorize access="hasRole('A')">
Для пишущих
<input type="button" value="Внесение информации в уик"
       onclick="window.location.href = '/update-information-station/5'"/>
<br>
Для пишущих
<input type="button" value="Внесение голосов за кандидатов"
       onclick="window.location.href = '/votes_for_candidates'"/>
<br>
</security:authorize>

<security:authorize access="hasRole('B)">
Для смотрящих
<input type="button" value="Просмотр процента посещения для тиков"
       onclick="window.location.href = '/tiks'"/>
<br>
Для смотрящих
<input type="button" value="Просмотр процента голосов за кандидатов"
       onclick="window.location.href = '/votes-info'"/>
<br>
Для смотрящих
<input type="button" value="Просмотр посещаемости в МСК"
       onclick="window.location.href = '/all_attendance'"/>
</security:authorize>

</body>
</html>