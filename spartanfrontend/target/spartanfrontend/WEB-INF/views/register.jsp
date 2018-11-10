<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!------ Include the above in your HEAD tag ---------->


<!--Pulling Awesome Font -->
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<style>
@import url(http://fonts.googleapis.com/css?family=Roboto:400);
body {
  background-color:#fff;
  -webkit-font-smoothing: antialiased;
  font: normal 14px Roboto,arial,sans-serif;
}
#justpushtobottom{
 padding-bottom: 25%;
}

.stylingerror
{
color: red;

}
.container {
    padding-top: 1%;
    padding-right: 5%;
    padding-left: 5%;
    
}

.form-login {
    background-color: #D7D7D7;
    padding-top: 10px;
    padding-bottom: 20px;
    padding-left: 20px;
    padding-right: 20px;
    border-radius: 15px;
    border-color:#d2d2d2;
    border-width: 5px;
    box-shadow:0 1px 0 #cfcfcf;
}

h4 { 
 border:0 solid #fff; 
 border-bottom-width:1px;
 padding-bottom:10px;
 text-align: center;
}

.form-control {
    border-radius: 10px;
}

.wrapper {
    text-align: center;
}
</style>

<div class="container">
<div id="justpushtobottom"></div>
    <div class="row">
        <div>
            <div class="form-login">
            <h4>Register</h4>
            <form:form modelAttribute="ud" action="addUser" method="post">
			 <form:input type="text" id="Name" class="form-control input-sm chat-input" placeholder="Name" path="user_Name"/>
			 <form:errors  path="user_Name" class="stylingerror"/>
            <br/> 
            
            <form:input type="text" id="E-mail Address" class="form-control input-sm chat-input" placeholder="E-mail Address" path="emailid"/>
            <form:errors  path="emailid" class="stylingerror"/>
            <br/> 
            <form:input type="text" id="Mobile Number" class="form-control input-sm chat-input" placeholder="Mobile Number" path="phno"/>
            <form:errors  path="phno" class="stylingerror"/>
           <br/> 
            <form:input type="text" id="userPassword" class="form-control input-sm chat-input" placeholder="password" path="user_Password"/>
            <form:errors  path="user_Password" class="stylingerror"/>
            <br/> 
            <div class="wrapper">
            <span class="group-btn">     
                <input type="submit" class="btn btn-primary btn-md" value="Register"> <i class="fa fa-sign-in"></i>
            </span>
            </div>
            </form:form>
            
	            
            </div>
        
        </div>
    </div>
</div>

