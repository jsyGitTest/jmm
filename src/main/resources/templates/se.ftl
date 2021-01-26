<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Title</title>
    <style>
        body{
            font-family:SimHei;
        }

    </style>
</head>
<body>
<div class="color pos">


    <#list list as item>
        ${item.content}
            <#list item.getPicsList as pic>
                ${pic}

            </#list>



    </#list>

</div>
</body>
</html>