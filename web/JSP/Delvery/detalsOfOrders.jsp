    
<%@page import="daoClasses.ItemDAO"%>
<%@page import="orm.Item"%>
<%@page import="orm.OrderItem"%>
<%@page import="daoClasses.OrderItemDAO"%>
<%@page import="orm.Order"%>
<%@page import="java.util.List"%>
<%@page import="daoClasses.OrderDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{width: 1000px;
                 height: 1300px;
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

            #showItem_table{
                width: auto;
                height: 350px;
                margin-left: auto;
                margin-right: auto;
                position: absolute;
                top:150px;
                left: 350px;

            }

            table, th, td {
                border: 1px solid black;
                border-spacing: 5px;
                border-collapse: collapse;
                padding: 15px;
                text-align: left;
                background-color: #f1f1c1;
            }

        </style>

    </head>


    <body>



        <nav id="mainNiv">
            <ul id="navmenu">
              
                <li class="ourPage"><a href="../about.html" target="_blank">ABOUT</a></li>

                <li class="ourPage"><a href="../contact.html" target="_blank">CONTACT</a></li>

            </ul>



        </nav>
     


        <div  id="showItem_table">
            <form action="../Delvery/userInfo.jsp">
                            <input type="hidden" name="userId" value=<%=request.getParameter("userId")%> />
                            
                        <input type="submit" value="customer Info" name="ShowDetails" />
                        
                        </form>
            <table >
                <tr>
                     <th>order Id</th>
                    <th>Item Name</th>
                   
                    <th>Quantity</th>
 

                </tr>
                
                <%
                 int orderId=Integer.parseInt( request.getParameter("orderId"));
                OrderItemDAO orderItemDAO=new OrderItemDAO();
               List<OrderItem> orderItem= orderItemDAO.findByFKOrder(orderId);
               
                %>
                <%
                for(OrderItem orderItem1:orderItem){
              ItemDAO itemDAO=new ItemDAO();
             Item item= itemDAO.find(orderItem1.getFkItem());
             
                %>
                <tr>
                    <th><%=orderItem1.getFkOrder()%></th>
                    <th><%= item.getItemName()%></th>
                    
                     <th><%= orderItem1.getQuantity() %></th>
                    

                    
                </tr>
                <%}%>
                
            </table> 




        </div>

    </body>
</html>
