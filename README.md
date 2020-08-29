# Formed-based Spring Security using Database


*User-password authentication* 

One of the most common ways to authenticate a user by validating username and password.

*Reading the username and passowrd*

reading name password froma Customised login page

*Storage mechanisms* 

User security details is stored in a Relational database.

*UserDetailsService*

Core interface which loads user-specific security details. 

*PasswordEncoder*

Service interface for encoding password. Normally we use BCryptPasswordEncoder.

*AuthenticationProvider*

Indicate a class that can process Authentication. 



# Thymeleaf

Thymeleaf is a view framework. It works well with Spring MVC. The key to use it is to link the view, model, and controller together. 

A static View is presented in HTML, it may dynamically interact with controller using Thymeleaf facelet to update data to present or persist the user input. A Model links a Controller with a View, carrying the data back or forward between Controller and View. 

*Post a form*

It commits inputs to a Controller.  

`<form action="#" th:action="@{/clients}" th:object="${clientDto}" method="post"></form>`

Attributes:

`th:action` must be used with a link to uri expression `@{/clients}`, so as to point to a controller method handler. 

`th:object` must be used with a variable experssion `${clientDto}` pointing to a form backing bean, i.e. a `@ModelAttribute` instance name. 

method: is one of http method. 


*Add an text input to a form*

`<input type="text" th:field="*{email}"/>`

the above is a shortcut, similar to 

`<input type="text" id="email" name="email" th:value="*{email}"/>`

but actually more than the above, `th:text="*{...}"` applying the dataformatters that having been regsitered in the Spring, thus the data can be displyed correctly. 

Attributes: 

`th:field` musts be used with a selection variable expression `*{email}`, which mapping the current field to the Model attribute(property).


*Form validation and erro messages*

A form input may need a validation, and show error message with the fields. 

'<span th:if="${#fields.hasErrors('firstName')}" th:errors="*{firstName}">Incorrect date</span>'

The sematics of the above: If this field has validation errors, then listing them one by one. 

Attributes: 

`th:if="${#fields.hasErrors('firstName')}"` A function that takes a field expression as an argument and determines if the field has errors. 

`th:errors="*{firstName}`  showing a list of errors associated with the field.  

*Fragment*

A fragment defines a common view that can be included in many other views. 

Frgaments can be put in an independent html file. 

```
<div th:fragment="navBar">
    <nav role="navigation" aria-label="main menu">
        <a href="/">Home</a>|
        <a href="/createclient">Create Client</a>|
        <a href="/showclients">Show Existing Clients</a>|
        <a href="/showrooms">Show Rooms</a>
    </nav>
</div>
```

Using `th:replace=fragments.html::navBar` to reuse it at the point that needs it.

```
<header>
    <div th:replace="fragments.html :: navBar"></div>
</header>
```

*conditional fragment inclusion* 

Else-if syntax and Spel expression to determin which fragment is included in a view. 

````
<div th:replace="${#strings.isEmpty(currentUser)} ?
     ~{fragments :: navBar} : ~{fragments :: navBarLogout}">
</div>
````

*Thymeleaf expressions*

https://www.baeldung.com/spring-thymeleaf-3-expressions

