
<%@page import="orm.User"%>
<%@page import="java.util.List"%>
<%@page import="orm.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{width: 1000px;
                 height: 1300px;
                 background: linear-gradient(to bottom,black,white ,black ); 
            }


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

            #showItem_table{
                width: auto;
                height: 350px;
                margin-left: auto;
                margin-right: auto;
                position: absolute;
                top:150px;
                left: 360px;

            }
            #Quantity{border-radius: 70%;}
            table, th, td {
                border: 1px solid black;
                border-spacing: 5px;
                border-collapse: collapse;
                padding: 15px;
                text-align: left;
                background-color: #f1f1c1;
            }
            #totalText{ width: auto;

                        margin-left: auto;
                        margin-right: auto;
                        position: absolute;
                        top:350px;
                        left: 800px;}

        </style>
        <script type="text/javascript" src="../../JS/cart-js.js"></script>

    </head>


    <body>

        <%
           
            HttpSession session1 = request.getSession();
          
            List<Item> items1 = (List<Item>) session1.getAttribute("item1");
           session1.setAttribute("item", items1);
        
        
   User user = (User) session1.getAttribute("user");
                System.out.println("user id is is cart" + user.getUserId());

                session1.setAttribute("user", user);
                int userId =user.getUserId();
        %>

        <nav id="mainNiv">
            <ul id="navmenu">
                

                <li class="ourPage"><a href="../about.html" target="_blank">ABOUT</a></li>
                <a href="itemShow_Page.jsp"></a>

                <li class="ourPage"><a href="../contact.html" target="_blank">CONTACT</a></li>
                
            </ul>



        </nav>



        <div  id="showItem_table">

            <table >
                <tr>

                    <th>Id</th>
                    <th>Name</th>

                    <th>Price</th>

                    <th>Quantity</th>
                    <th>Total Price</th>
                    <th>Remove from cart</th>
                </tr>



                <%
                    for (Item item : items1) {
                     if (item.getItemId()!=0){
                     System.out.println("john");
                     
                     

                %>
                <%  
                    int price = Integer.parseInt(item.getPrice());
                    int quantity = Integer.parseInt(item.getQuantity());
                    int Total = price * quantity;

                %>
           
                <tr>
                         
                    <th><%= item.getItemId()%></th>
                    <th><%= item.getItemName()%></th>  
                    <th><%= item.getPrice()%></th>


                    <th><%= item.getQuantity()%></th>
                    <th><%=Total%></th>
                    <form action="../../CartInfoCheak">
                    <th>
                    <input type="hidden" name="itemId" value="<%= item.getItemId()%>"/>
                    <input type="hidden" name="userId" value="<%= userId%>"/>
                    <input type="submit" id="addToCart" value="Remove from cart" name="removeFromCart" />
                    </th>
                </form>
                </tr>
               
                <%

                    }}
session1.setAttribute("item",items1);
                %>


            </table> 


                <form action="../../order">
    
<input type="submit" id="orders" value="confirm order"  />
                </form>

        </div>















    </body>



</html>
