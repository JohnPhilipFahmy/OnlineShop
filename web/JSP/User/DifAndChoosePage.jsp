
<%@page import="orm.User"%>
<%@page import="bl.classses.ItemBL"%>
<%@page import="orm.Item"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>choice items </title>
        <style>
            body{width: 1000px;
                 height: 1300px;
                 background: linear-gradient(to bottom,black,white ,black ); 
                 float: left;
            }


            #mainNiv{width: 1100px;
                     height: 90px;
                     background: linear-gradient(to bottom,black,white ,black ); 
                     margin-left: auto;
                     margin-right: auto;

                     left: 90px;
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
                float: left;
                width: auto;
                height: 350px;
                margin-left: auto;
                margin-right: auto;
                position: absolute;
                top:100px;
                left: 200px;

            }
            #search{
                float: left;
                width: auto;
                height: 350px;
                margin-left: auto;
                margin-right: auto;
                position: absolute;
                top:140px;
                left: 870px;


            }
            #showItem_table{
                float: left;
                width: auto;
                height: 350px;
                margin-left: auto;
                margin-right: auto;
                position: absolute;
                top:180px;
                left: 100px;
                float: left;
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
            #msg{
                background-color: black;
                width: 100px;;

                margin-left: auto;
                margin-right: auto;
                margin-bottom: 10px;

                top:100px;
                left: 20px;
            }
            #go_to_cart{

                width: 100px;;

                margin-left: 700px;
                margin-right: auto;
                margin-top:  10px;
                margin-bottom:   10px;
                top:100px;
                left: 20px;


            }
        </style>

    </head>


    <body>



        <nav id="mainNiv">
            <ul id="navmenu">


                <li class="ourPage"><a href="../about.html" target="_blank">ABOUT</a></li>

                <li class="ourPage"><a href="../contact.html" target="_blank">CONTACT</a></li>
                <li class="ourPage"><a href="../../my_orders" target="_blank">My Orders</a></li>
            </ul>

            <%
                HttpSession session1 = request.getSession();
               
                List<Item> items1 = (List<Item>) session1.getAttribute("item");
                session1.setAttribute("item", items1);

                String msg = "";
                String validate = request.getParameter("validate");
                if (validate != null && validate.equals("false")) {
                    msg = "Plz select items ";

                }
                ItemBL itemBL = new ItemBL();
                List<Item> items = itemBL.finaAll();
                HttpSession session2 = request.getSession();
                List<Item> items2 = (List<Item>) session2.getAttribute("items");

                User user = (User) session1.getAttribute("user");
                System.out.println("user id is is difPage" + user.getUserId());

                session1.setAttribute("user", user);
            %>

        </nav>

        <div id="search" >   <form action="/Shop/search_servlet">
                <input type="hidden" name="jspName" value="dif"  />
                <input type="text" name="search" value="search" />
                <input type="submit" value="search" />

            </form>

        </div>



        <div  id="showItem_table">
            <div id="msg">  <span style="color: red" ><%= msg%> </span></div>



            <div id="go_to_cart">
                <form action="../User/Cart.jsp" >


                    <input type="submit" id="cart" value="cart" name="Quantity" />


                </form>
            </div>




            <table >
                <tr>
                    <th>ID</th>
                    <th>Type</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Offer</th>
                    <th>Price after offer</th>
                    <th>Offer start</th>
                    <th>Offer end</th>
                    <th>Quantity </th>
                    <th>add to cart</th>
                </tr>

                <%
                    if (items2 != null) {
                        for (Item item : items2) {
                %>

                <tr>
                <form action="../../addToCartAction">
                    <th><%= item.getItemId()%></th>
                    <th><%= item.getItemTybe()%></th>
                    <th><%= item.getItemName()%></th>
                    <th><%= item.getPrice()%></th>
                    <th><%= item.isOffer()%></th>
                    <th><%= item.getPriceAfterOffer()%></th>
                    <th><%= item.getOfferStart()%></th>
                    <th><%= item.getOfferEnd()%></th>


                    <th>

                        <input type="submit" id="Quantity" value="-" name="Quantity" onclick="reduction()"/>
                        <input type="text" id='num<%= item.getItemId()%>' name="count" value="1" >
                        <input type="button" id="Quantity" value="+" name="Quantity" onclick="add('num<%= item.getItemId()%>')"/>


                    </th> 


                    <th> 
                        <input type="hidden" name="itemId" value="<%= item.getItemId()%>"/>
                        <input type="hidden" name="itemName" value="<%= item.getItemName()%>"/>
                        <input type="hidden" name="itemPrice" value="<%= item.getPrice()%>"/>

                        <input type="submit" value="add to cart"  />
                    </th>
                </form>
                </tr>

                <%
                    }
                } else {

                    for (Item item : items) {

                %>

                <tr>
                <form action="../../addToCartAction">
                    <th><%= item.getItemId()%></th>
                    <th><%= item.getItemTybe()%></th>
                    <th><%= item.getItemName()%></th>
                    <th><%= item.getPrice()%></th>
                    <th><%= item.isOffer()%></th>
                    <th><%= item.getPriceAfterOffer()%></th>
                    <th><%= item.getOfferStart()%></th>
                    <th><%= item.getOfferEnd()%></th>


                    <th>

                        <input type="submit" id="Quantity" value="-" name="Quantity" onclick="reduction()"/>
                        <input type="text" id='num<%= item.getItemId()%>' name="count" value="1" >
                        <input type="button" id="Quantity" value="+" name="Quantity" onclick="add('num<%= item.getItemId()%>')"/>


                    </th> 


                    <th> 
                        <input type="hidden" name="itemId" value="<%= item.getItemId()%>"/>
                        <input type="hidden" name="itemName" value="<%= item.getItemName()%>"/>
                        <input type="hidden" name="itemPrice" value="<%= item.getPrice()%>"/>

                        <input type="submit" value="add to cart"  />
                    </th>
                </form>
                </tr>
                <%
                        }
                    }


                %>




            </table> 








        </div>





        <script >
            function add(mId) {

                var x = document.getElementById(mId);
                x.value = (x.value) - (-1);


            }
            function reduction() {
                var x = document.getElementById("num");
                if (x.value > 0) {

                    x.value = (x.value) - 1;
                }
            }


        </script>
    </body>
</html>
