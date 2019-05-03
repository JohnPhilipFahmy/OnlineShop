<%@page import="orm.User"%>
<%@page import="orm.Item"%>
<%@page import="java.util.List"%>
<%@page import="bl.classses.ItemBL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>show item</title>
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
            #search{

                width: auto;
                height: 350px;
                margin-left: auto;
                margin-right: auto;
                position: absolute;
                top:140px;
                left: 870px;


            }
            #showItem_table{
                width: auto;
                height: 350px;
                margin-left: auto;
                margin-right: auto;
                position: absolute;
                top:170px;
                left: 200px;

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


            <%
                ItemBL itemBL = new ItemBL();
                List<Item> items = itemBL.finaAll();
                HttpSession session1 = request.getSession();
                List<Item> items2 = (List<Item>) session1.getAttribute("items");

                HttpSession userInfo = request.getSession();
                User user=(User ) session1.getAttribute("user");
              System.out.println( "user id is is "+user.getUserId());
                 
            %>
        </nav>
        <div id="search" >   <form action="/Shop/search_servlet">
                <input type="hidden" name="jspName" value="show"  />
                <input type="text" name="search" value="search" />
                <input type="submit" value="search" />

            </form>

        </div>


        <div  id="showItem_table">



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
                    <th>quantity</th>
                    <th>Edit</th>
                    <th>delete</th>
                </tr>
                <%
                    if (items2 != null) {
                        for (Item item : items2) {
                %>

                <tr>

                    <th><%=item.getItemId()%></th>
                    <th><%=item.getItemTybe()%></th>
                    <th><%=item.getItemName()%></th>
                    <th><%=item.getPrice()%></th>
                    <th><%=item.isOffer()%></th>
                    <th><%=item.getPriceAfterOffer()%></th>
                    <th><%=item.getOfferStart()%></th>
                    <th><%=item.getPriceAfterOffer()%></th>
                    <th><%=item.getQuantity()%> k.gm</th>

                    <th>
                        <form action="../../EditPageCheack">  
                            <input type="hidden" name="john" value=<%=item.getItemId()%> readonly="readonly"  />
                            <input type="submit" value="edit" name="john1" />    
                        </form>
                    </th>
                    <th>
                        <form action="../../deletePage">  
                            <input type="hidden" name="delete" value=<%=item.getItemId()%> readonly="readonly"  />
                            <input type="submit" value="delete" name="delete" />    
                        </form>
                    </th>
                </tr>

                <%}
                } else {

                    for (Item item : items) {
                %>

                <tr>

                    <th><%=item.getItemId()%></th>
                    <th><%=item.getItemTybe()%></th>
                    <th><%=item.getItemName()%></th>
                    <th><%=item.getPrice()%></th>
                    <th><%=item.isOffer()%></th>
                    <th><%=item.getPriceAfterOffer()%></th>
                    <th><%=item.getOfferStart()%></th>
                    <th><%=item.getPriceAfterOffer()%></th>
                    <th><%=item.getQuantity()%> k.gm</th>

                    <th>
                        <form action="../../EditPageCheack">  
                            <input type="hidden" name="john" value=<%=item.getItemId()%> readonly="readonly"  />
                            <input type="submit" value="edit" name="john1" />    
                        </form>
                    </th>
                    <th>
                        <form action="../../deletePage">  
                            <input type="hidden" name="delete" value=<%=item.getItemId()%> readonly="readonly"  />
                            <input type="submit" value="delete" name="delete" />    
                        </form>
                    </th>
                </tr>

                <% }
                    }
                %>


            </table> 




        </div>

    </body>
</html>
