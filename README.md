# Thymeleaf

Thymeleaf is a view framework. It works very well with Spring MVC. The key to use it is to link the view, model, and controller together. 

A static View is presented in HTML, it may dynamically interact with controller using Thymeleaf facelet to update data to present or persist the user input. Model link the Controller with View, carrying the data back or forward between Controller and View. 

*Post a form*

It commit user input via a Controller.  

`<form action="#" th:action="@{/clients}" th:object="${clientDto}" method="post">
</form>`

Attributes:

th:action must be used with a link to uri expression `@{/clients}`, pointing to controller method handler. 

th:object must be used with a variable experssion `${clientDto}` pointing to form backing bean name(instance variable name).


*Add an text input to a form*

`<input type="text" th:field="*{email}"/>`

the above is a shortcut, which is equal to 

`<input type="text" id="email" name="email" th:value="*{email}"/>`

Attributes: 

`th:field` musts be used with a selection variable expression `*{email}`, which mapping the current field to the Model attribute(property).

