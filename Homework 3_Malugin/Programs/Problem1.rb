# Compile: ruby Problem1.rb
# Run by connecting to MariaDB. After connecting to MariaDB, use command use TTU; This connects to the TTU database within MariaDB. Now select * from students to display all data in table students.


!/usr/bin/ruby -w
require 'mysql2'

client = Mysql2::Client.new(:host => "localhost", :username => "root",:password=> "coursework")
 
results = client.query("CREATE DATABASE TTU")
results = client.query("USE TTU")
results = client.query("CREATE TABLE students (tnumber char(8) primary key,
firstname varchar(20) NOT NULL,
lastname varchar(20) NOT NULL,
dateofbirth date,
credits numeric(3,0))")

results = client.query("CREATE INDEX idx_lastname on students(lastname)")

results = client.query("INSERT INTO students (tnumber,firstname,lastname,dateofbirth,credits) VALUES('00001234','Joe','Smith','1950-08-12','35')")

results = client.query("Select tnumber, firstname, lastname, DATE_FORMAT(dateofbirth, '%m/%d/%Y') as newdateofbirth, credits from students")

printf("%-10s%-15s%-15s%-15s%-15s\n","Tnumber","First Name","Last Name","Date of Birth","Credits")



results.each do |row|

 
  printf("%-10s%-15s%-15s%-15s%-15s\n",row["tnumber"],row["firstname"],row["lastname"],row["newdateofbirth"],row["credits"])

end
