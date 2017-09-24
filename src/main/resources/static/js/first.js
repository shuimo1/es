/**
 * Created by Administrator on 2017/9/21.
 */
//创建索引
function  createIndex() {
    // $.post("http://localhost:9200/bikes/bike",function(d){alert(d);});
    var json={"title":"ofo","price":789};
    //将json对象转换为string
    var json2=JSON.stringify(json);
    $.ajax({
        url:"http://localhost:9200/bikes/bike",
        method:"post",
        data:json2,
        contentType:"application/json"
    });
}
function search(){
    $.getJSON("http://localhost:9200/_search?q=title:红",function(d){
         callc3(d);
    });
}