<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td colspan="3"><input type="text" readonly value="${output}"/></td>
        <td>
            <form action="/calc/calc" method="POST">
                <input type="submit" name="ce" value="CE"/></form>
        </td>
    </tr>
    <tr>
        <form action="/calc/calc" method="GET">
            <td><input type="submit" name="arg" value="7"/></td>
            <td><input type="submit" name="arg" value="8"/></td>
            <td><input type="submit" name="arg" value="9"/></td>
        </form>
        <form action="/calc/calc" method="POST">
            <td><input type="submit" name="operator" value="+"/></td>
        </form>
    </tr>
    <tr>
        <form action="/calc/calc" method="GET">
            <td><input type="submit" name="arg" value="4"/></td>
            <td><input type="submit" name="arg" value="5"/></td>
            <td><input type="submit" name="arg" value="6"/></td>
        </form>
        <form action="/calc/calc" method="POST">
            <td><input type="submit" name="operator" value="-"/></td>
        </form>
    </tr>
    <tr>
        <form action="/calc/calc" method="GET">
            <td><input type="submit" name="arg" value="1"/></td>
            <td><input type="submit" name="arg" value="2"/></td>
            <td><input type="submit" name="arg" value="3"/></td>
        </form>
        <form action="/calc/calc" method="POST">
            <td><input type="submit" name="evaluate" value="="/></td>
        </form>
    </tr>
    <form action="/calc/calc" method="GET">
        <tr>
            <td><input type="submit" name="arg" value="0"/></td>
            <td/>
            <td/>
            <td/>
        </tr>
    </form>
</table>
</body>
</html>