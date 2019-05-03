

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogIn Page</title>
        <style>
            body{width: 1000px;
                 height: 1300px;
                 background: linear-gradient(to bottom,black,white ,black );  }


            #bage
            {
                width: auto;
                height: 350px;
                margin-left: auto;
                margin-right: auto;
                position: absolute;
                top:100px;
                left: 200px;

            }

            #EmailInput{margin-left:55px;
                        margin-top:30px;}

            #passwordInput{margin-left:32px;}


            #userTybe{margin-left:55px;}
            #button{margin-left:200px; }
            #msg{margin-left:250px;
                 margin-top:250px;  
                 background-color:wheat;
                 width: 200px;
                 border-radius: 100px 100px 100px 100px;}

        </style>
        
        
        <%
            String validate = request.getParameter("validate");
            String msg = "";
            if (validate != null && validate.equals("false")) {
                msg = "Invalid Username or Password";
            }

        %>

    </head>


    <body>



        <div id="msg">  <span style="color: red" ><%= msg%> </span></div>
        <div id="bage">
            <form method="POST" action="../LoginnCheak">
                <br><br>
                <label for="text" id="Email">Email:-</label>
                <input type="text" id="EmailInput" name="Email" >

                <br><br>


                <label for="password" id="password">password:- </label>
                <input type="password" name="password" id="passwordInput"> 
                <br><br>



                <br><br>
                <br>
                <input type="Submit" id="button" name="button" value="Sign Up">

            </form>

        </div>


    </body>
</html>
