<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Form</title>
</head>
<body>
    <h2>Student Registration Form</h2>
    <form action="saveStudent" method="post">
        <label for="studentId">Student ID:</label>
        <input type="number" id="studentId" name="studentId" required><br><br>
 
        <label for="studentName">Student Name:</label>
        <input type="text" id="studentName" name="studentName" required><br><br>
 
        <button type="submit">Submit</button>
    </form>
</body>
</html>