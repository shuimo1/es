<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/12
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script>
      function a3() {
          $.getJSON("http://localhost:9200/books/book/_search", function (d) {
              alert(d.took);
          });
      }
          //添加
       function a4(){
           var x={"title":"三国演义","price":444};
           var d=JSON.stringify(x);
           $.ajax({
               url:"http://localhost:9200/books/book",
               method:"post",
               data:d,
               contentType:"application/json",
               success:function(m){alert(m);}
           });

      }
      function a5(){
           $.ajax({
               url:"http://localhost:9200/books/book/AV00diT6tncdU2jurBUO",
               method:"delete",
               success:function(d){
                   alert(d);
               }
           });
      }
    </script>
  </head>
  <body>
      <button onclick="a4()">访问</button>
  </body>
</html>
