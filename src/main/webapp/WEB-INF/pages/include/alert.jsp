<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="alert-information">
    <c:forEach var="message" items="${messages}">
        <div class="alert alert-${message.level}">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            ${ message.message }
        </div>
    </c:forEach>
</div>