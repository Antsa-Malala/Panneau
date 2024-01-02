<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Prevision de coupure de courant</title>
    <link rel="stylesheet" href="./css/liste.css">
    <style>
        @font-face {
            font-family: 'The Smile';
            src: url('css\The Smile.otf') format('opentype');
        }
    </style>
</head>
<body>
    <h3>Faire une prevision</h3>
    <form action="VoirPrevision" method="post">
        <label for="">Date à prévoir</label>
        <input type="date" name="datePrevision">
        <input type="submit" value="OK">
    </form>
</body>
</html>