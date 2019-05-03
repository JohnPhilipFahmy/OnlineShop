

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
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


            #ItemName{bottom:100px;}
            #ItemNameInput{margin-left:30px;
                           margin-top: 80px;}
            #PriceInput{margin-left:65px;
            }


            #PriceUnitInput{margin-left:48px;}
            .PriceUnit{margin-left:0px}

            #OfferInput{margin-left:65px;}
            #OfferStartInput{margin-left:35px;}
            #OfferEndInput{margin-left:40px;}
            #quantityInput{margin-left:45px;}
            #PriceAfterOfferInput{margin-left:0px;}


            #button{margin-left:200px; }
            #ItemTybe{margin-left:30px;}

        </style>
      
    </head>


    <body>


      

        <div id="bage">

            <form method="POST" action="../../AddItem">

                <label for="text" id="ItemName">ItemName:-</label>
                <input type="text" id="ItemNameInput" name="ItemName" ><br><br>




                <label for="text" id="Price">Price:-</label>
                <input type="text" id="PriceInput" name="Price" >


                <br><br>

                <label for="text" id="Offer">Offer:-</label>
                <input type="text" id="OfferInput" name="Offer">

                <br><br>
                <label for="text" id="PriceAfterOffer">PriceAfterOffer:-</label>
                <input type="text" id="PriceAfterOfferInput" name="PriceAfterOffer" />

                <br><br>
                <label for="OfferStart" id="OfferStart">OfferStart:- </label>
                <input type="text" name="OfferStart" id="OfferStartInput">
                <br><br>
                <label for="OfferStart" id="OfferEnd">OfferEnd:- </label>
                <input type="text" name="OfferEnd" id="OfferEndInput">
                <br><br>
                <label for="OfferStart" id="quantity">quantity:- </label>
                <input type="text" name="quantity" id="quantityInput">
                <br><br>

                <label for="text" class="ItemTybe"> Item type:- </label>
                <select name="ItemTybe" id="ItemTybe" >
                    <option>vegetables</option>
                    <option>Fruit</option>


                </select>
                <br><br>
                <label for="text" class="PriceUnit">  PriceUnit:- </label>
                <select  id="PriceUnitInput" name="PriceUnit" >
                    <option >L.E</option>
                    <option >Dollar</option>

                </select>



                <br><br>

                <input type="Submit" id="button" name="button" value="insert">
              
            </form>

    </div>

    </body>
</html>
