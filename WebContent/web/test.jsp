 <html>
<body>    
<script language="javascript" src="../js/jquery-1.8.3.js"></script>    
<script type="text/javascript">   
$(document).ready(function(){   
            $("td:eq(2)",$("tr")).hide();   
           $("td:eq(3)",$("tr")).hide();   
            $("td:eq(4)",$("tr")).hide();   
          $("#button1").click(function(){   
                    $("td:eq(2)",$("tr")).toggle(1000); //设置为0表示不用动画 ，1000就1秒的时间来展示或者隐藏  
                    $("td:eq(3)",$("tr")).toggle(1000);    
                 $("td:eq(4)",$("tr")).toggle(1000);    
                 });       
    });         
     
</script>   
<input type="button" id="button1" value="隐藏/显示后三列"/>    
<table id="mytable"  border="1"  cellpadding="0"  
   cellspacing="0" bordercolor="#a3b0dc" style="border-collapse:collapse;">   
   <tr >   
       <td width="200">第一列</td>   
        <td  width="200">第二列</td>   
      <td  width="200">第三列</td>   
      <td  width="200">第四列</td>   
       <td  width="200">第五列</td>   
   </tr>     
   <tr><td>id</td><td>id1</td><td>id2</td><td>id3</td><td>id4</td></tr>         
   <tr><td>id</td><td>id1</td><td>id2</td><td>id3</td><td>id4</td></tr>        
   <tr><td>id</td><td>id1</td><td>id2</td><td>id3</td><td>id4</td></tr>   
      
    <tr><td>id</td><td>id1</td><td>id2</td><td>id3</td><td>id4</td></tr>         
  <tr><td>id</td><td>id1</td><td>id2</td><td>id3</td><td>id4</td></tr>   
</table>     
</body>  
</html>
————————————————
版权声明：本文为CSDN博主「newyear1988」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/newyear1988/article/details/7402593