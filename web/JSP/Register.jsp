
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <style>
            body{width: 1000px;
                 height: 700px;
                 background: linear-gradient(to bottom,black,white ,black );  }


            #mainNiv{width: 1100px;
                     height: 90px;
                     background: linear-gradient(to bottom,black,white ,black ); 
                     margin-left: auto;
                     margin-right: auto;

                     left: 120px;
                     position: absolute;
                     bottom:500px;

            }


            .ourPage{
                float: left;
                list-style-type: none;


                margin: 10px;}
            li {
                float: left;
            }

            li a {
                display: white;
                color: black;
                text-align: center;
                padding: 16px;
                text-decoration: none;
                font-size:30px; 
            }

            li a:hover {
                background-color:white;
                border-radius:  90px 90px 90px 90px;
            }



            li {
                float: left;
            }



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


            #firstName{bottom:100px;}
            #firstNameInput{margin-left:30px;
                            margin-top: 80px;}

            #lastName{margin-left:0px;}
            #lastNameInput{margin-left:33px;}

            #GenderInput{margin-left:48px;}
            .Gender{margin-left:0px}

            #EmailInput{margin-left:55px;}

            #passwordInput{margin-left:30px;}

            #addressInput{margin-left:46px;}
            #button{margin-left:200px; }
            #userTybe{margin-left:30px;}

        </style>
<%
String validate=request.getParameter("validate");
String msg="'";
if(validate!=null&&validate.equals("false")){
msg="error in data please try agin";
}
%>
    </head>


    <body>


        <nav id="mainNiv">
            <ul id="navmenu">
                <li class="ourPage"><a href="mainPage.html" >HOME</a></li>

                <li class="ourPage"><a href="#ABOUT" target="_blank">ABOUT</a></li>

                <li class="ourPage"><a href="contact.html" target="_blank">CONTACT</a></li>
            </ul>



        </nav>


        <div id="bage">



            <form method="POST" action="../RegisterCheak">

                <label for="text" id="firstName">first Name:-</label>
                <input type="text" id="firstNameInput" name="firstName" ><br><br>


                <label for="text" id="lastName">last Name:-</label>
                <input type="text" id="lastNameInput" name="lastName" >


                <br><br>
                <label for="text" id="PhoneNumber">Phone Number:-</label>
                <input type="text" id="PhoneNumberInput" name="PhoneNumber" >


                <br><br>

                <label for="text" id="Email">Email:-</label>
                <input type="text" id="EmailInput" name="Email" >

                <br><br>
                <label for="text" id="password"> Password:-</label>
                <input type="password" id="passwordInput" name="password" />

                <br><br>
                <label for="address" id="address">address- </label>
                <input type="text" name="address" id="addressInput">
                <br><br>


                <label for="text" class="userTybe"> User type:- </label>
                <select name="userTybe" id="userTybe" >
                    <option>customer</option>
                    <option>manager</option>
                    <option>delivery</option>
                </select>
                <br><br>
                <label for="text" class="Gender">  Gender:- </label>
                <select  id="GenderInput" name="Gender" >
                    <option >Male</option>
                    <option >Female</option>

                </select>



                <br><br>

                <input type="Submit" id="button" name="button" value="Sign Up">
                <%= msg%>
            </form>

        </div>


    </body>
</html>
