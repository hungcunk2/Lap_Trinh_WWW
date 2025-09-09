<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            background-color: #87CEEB;
            font-family: Arial, sans-serif;
            padding: 20px;
        }

        .form-container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #87CEEB;
            padding: 20px;
        }

        .form-row {
            display: flex;
            align-items: center;
            margin-bottom: 15px;
            gap: 10px;
        }

        .form-label {
            color: white;
            font-weight: bold;
            min-width: 120px;
            text-align: left;
        }

        .form-input {
            padding: 5px;
            border: 1px solid #ccc;
            background-color: white;
        }

        .form-input.wide {
            width: 200px;
        }

        .form-input.medium {
            width: 150px;
        }

        .form-input.small {
            width: 100px;
        }

        .date-inputs {
            display: flex;
            gap: 5px;
        }

        .date-inputs select {
            padding: 5px;
            border: 1px solid #ccc;
            background-color: white;
        }

        .radio-group {
            display: flex;
            gap: 15px;
            align-items: center;
        }

        .radio-group input[type="radio"] {
            margin-right: 5px;
        }

        .radio-group label {
            color: white;
            font-weight: normal;
        }

        .textarea {
            width: 200px;
            height: 60px;
            padding: 5px;
            border: 1px solid #ccc;
            background-color: white;
            resize: vertical;
        }

        .checkbox-group {
            display: flex;
            gap: 15px;
            align-items: center;
            flex-wrap: wrap;
        }

        .checkbox-group input[type="checkbox"] {
            margin-right: 5px;
        }

        .checkbox-group label {
            color: white;
            font-weight: normal;
        }

        .qualification-table {
            border: 2px solid #333;
            background-color: #87CEEB;
            margin-top: 10px;
        }

        .qualification-table table {
            width: 100%;
            border-collapse: collapse;
        }

        .qualification-table th,
        .qualification-table td {
            border: 1px solid #333;
            padding: 8px;
            text-align: center;
        }

        .qualification-table th {
            background-color: #6BB6D6;
            color: white;
            font-weight: bold;
        }

        .qualification-table td {
            background-color: #87CEEB;
            color: white;
        }
        .qualification-table input {
            width: 100%;
            padding: 3px;
            border: 1px solid #ccc;
            background-color: white;
        }

        .course-options {
            display: flex;
            gap: 20px;
            align-items: center;
            flex-wrap: wrap;
        }

        .course-options input[type="radio"] {
            margin-right: 5px;
        }

        .course-options label {
            color: white;
            font-weight: normal;
        }

        .button-group {
            text-align: center;
            margin-top: 20px;
            gap: 10px;
            display: flex;
            justify-content: center;
        }

        .btn {
            padding: 8px 20px;
            border: 1px solid #333;
            background-color: #f0f0f0;
            cursor: pointer;
            font-weight: bold;
        }

        .btn:hover {
            background-color: #e0e0e0;
        }

        .hint-text {
            color: white;
            font-size: 12px;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<div class="form-container">
    <form action="registration-form" name="formDangKy" method="GET">
        <div class="form-row">
            <label class="form-label">First name:</label>
            <input type="text" name="txtFName" class="form-input wide">
            <span class="hint-text">(max 30 characters a-z and A-Z)</span>
        </div>

        <div class="form-row">
            <label class="form-label">Last name:</label>
            <input type="text" name="txtLName" class="form-input wide">
            <span class="hint-text">(max 30 characters a-z and A-Z)</span>
        </div>

        <div class="form-row">
            <label class="form-label">Date of birth:</label>
            <div class="date-inputs">
                <select name="day">
                    <option>Day</option>
                    <option>1</option>
                    <option>2</option>
                    <!-- Add more days -->
                </select>
                <select name="month">
                    <option>Month</option>
                    <option>January</option>
                    <option>February</option>
                    <!-- Add more months -->
                </select>
                <select name="year">
                    <option>Year</option>
                    <option>2024</option>
                    <option>2023</option>
                    <!-- Add more years -->
                </select>
            </div>
        </div>

        <div class="form-row">
            <label class="form-label">Email:</label>
            <input type="email" name="email" class="form-input wide">
        </div>

        <div class="form-row">
            <label class="form-label">Mobile number:</label>
            <input type="tel" class="form-input wide">
            <span class="hint-text">(10 digit number)</span>
        </div>
        <div class="form-row">
            <label class="form-label">Gender:</label>
            <div class="radio-group">
                <label><input type="radio" name="gender" value="male"> Male</label>
                <label><input type="radio" name="gender" value="female"> Female</label>
            </div>
        </div>

        <div class="form-row">
            <label class="form-label">Address:</label>
            <textarea class="textarea"></textarea>
        </div>

        <div class="form-row">
            <label class="form-label">City:</label>
            <input type="text" class="form-input wide">
            <span class="hint-text">(max 30 characters a-z and A-Z)</span>
        </div>

        <div class="form-row">
            <label class="form-label">Pin Code:</label>
            <input type="text" class="form-input medium">
            <span class="hint-text">(6 digit number)</span>
        </div>

        <div class="form-row">
            <label class="form-label">State:</label>
            <input type="text" class="form-input wide">
            <span class="hint-text">(max 30 characters a-z and A-Z)</span>
        </div>

        <div class="form-row">
            <label class="form-label">Country:</label>
            <input type="text" class="form-input medium" value="India">
        </div>

        <div class="form-row">
            <label class="form-label">Hobbies:</label>
            <div class="checkbox-group">
                <label><input type="checkbox" name="hobbies" value="drawing"> Drawing</label>
                <label><input type="checkbox" name="hobbies" value="singing"> Singing</label>
                <label><input type="checkbox" name="hobbies" value="dancing"> Dancing</label>
                <label><input type="checkbox" name="hobbies" value="sketching"> Sketching</label>
                <label><input type="checkbox" name="hobbies" value="others"> Others</label>
                <input type="text" class="form-input medium">
            </div>
        </div>

        <div class="form-row">
            <label class="form-label">Qualification:</label>
            <div class="qualification-table">
                <table>
                    <thead>
                    <tr>
                        <th></th>
                        <th>Sl.No.</th>
                        <th>Examination</th>
                        <th>Board</th>
                        <th>Percentage</th>
                        <th>Year of Passing</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Class X</td>
                        <td><input type="text"></td>
                        <td><input type="text"></td>
                        <td><input type="text"></td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>Class XII</td>
                        <td><input type="text"></td>
                        <td><input type="text"></td>
                        <td><input type="text"></td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>Graduation</td>
                        <td><input type="text"></td>
                        <td><input type="text"></td>
                        <td><input type="text"></td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>Masters</td>
                        <td><input type="text"></td>
                        <td><input type="text"></td>
                        <td><input type="text"></td>
                        <td><input type="text"></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="form-row">
            <label class="form-label">Course applied for:</label>
            <div class="course-options">
                <label><input type="radio" name="course" value="bca"> BCA</label>
                <label><input type="radio" name="course" value="bcom"> B.Com</label>
                <label><input type="radio" name="course" value="bsc"> B.Sc</label>
                <label><input type="radio" name="course" value="ba"> B.A</label>
            </div>
        </div>

        <div class="button-group">
            <button type="submit" class="btn">Submit</button>
            <button type="reset" class="btn">Reset</button>
        </div>
    </form>
</div>
</body>
</html>
