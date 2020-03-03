<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Title</title>
    <style>
        body{
            font-family:SimHei;
        }
        /*.color{*/
            /*color: green;*/
        /*}*/
        /*.pos{*/
            /*position:absolute;*/
            /*left:200px;*/
            /*top:5px;*/
            /*width: 200px;*/
            /*font-size: 10px;*/
        /*}*/
    </style>
</head>
<body>
<div class="color pos">

    你好，${name}


    <h4>明细</h4>
    <table border="1" cellspacing="0" cellpadding="0">
        <tr>
            <td width="5%">序号</td>
            <td width="15%">列1</td>
            <td width="12%">列2</td>
            <td width="12%">列3</td>
            <td width="12%">列4</td>
            <td>列5</td>
        </tr>
				<#list detailList as ad>
					<tr>
                        <td>${ad_index+1}</td>
                        <td>${ad.column1}</td>
                        <td>${ad.column2}</td>
                        <td>${ad.column3}</td>
                        <td>${ad.column4}</td>
                        <td>${ad.column5}</td>
                    </tr>
                </#list>
    </table>

    <br/>
    <img src="logo.png" width="600px"/>

</div>
</body>
</html>