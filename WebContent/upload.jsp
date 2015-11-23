<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Video Upload</title>
</head>
<body>
<center>
    <h1>Video Upload</h1>
    <form method="post" action="upload_servlet"
        enctype="multipart/form-data">
        <label for="video">Select video to upload: </label>
        <input type="file" name="video" id="video" size="60" />
        <br />
        <br /> 
        <input type="submit" value="Upload" />
    </form>
</center>
</body>
</html>