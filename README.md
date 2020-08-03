# demothymeleaf

*Post a form

<form action="#" th:action="@{/clients}" th:object="${clientDto}" method="post">

Attributes:

th:action must be used with a link to uri expression @{/clients}, pointing to controller method handler. 

th:object must be used with a variable experssion ${clientDto} pointing to form backing bean name(instance variable name).



*Add an input to a form

<input type="text" th:field="*{email}"/> 

the above is a shortcut, which is equal to 
<input type="text" id="email" name="email" th:value="*{email}"/>

Attributes: 

th:field musts be used with a selection variable expression *{email}, which pointing the current field to the Model attribute(property), and make them bound. 

