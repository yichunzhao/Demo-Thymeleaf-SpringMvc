# Thymeleaf

Thymeleaf is a view framework. It works well with Spring MVC. The key to use it is to link the view, model, and controller together. 

A static View is presented in HTML, it may dynamically interact with controller using Thymeleaf facelet to update data to present or persist the user input. Model link the Controller with View, carrying the data back or forward between Controller and View. 

*Post a form*

It commit user input via a Controller.  

`<form action="#" th:action="@{/clients}" th:object="${clientDto}" method="post"></form>`

Attributes:

`th:action` must be used with a link to uri expression `@{/clients}`, pointing to controller method handler. 

`th:object` must be used with a variable experssion `${clientDto}` pointing to form backing bean name, i.e. Model. 

method: one of http method. 


*Add an text input to a form*

`<input type="text" th:field="*{email}"/>`

the above is a shortcut, which is similar to 

`<input type="text" id="email" name="email" th:value="*{email}"/>`

but actually more than the above, `th:text="*{...}"` applying the dataformatters that having been regsitered in the Spring, thus the data can be displyed correctly. 

Attributes: 

`th:field` musts be used with a selection variable expression `*{email}`, which mapping the current field to the Model attribute(property).


*Form validation and erro messages*

A form input may need a validation, and show error message alone with the fields. 

'<span th:if="${#fields.hasErrors('firstName')}" th:errors="*{firstName}">Incorrect date</span>'

If this field has validation errors, then listing errors of this field one by one. 

Attributes: 

`th:if="${#fields.hasErrors('firstName')}"` A function that takes a field expression as an argument and determines if the field has errors. 

`th:errors="*{firstName}`  showing a list of errors triggered by this field input.  





