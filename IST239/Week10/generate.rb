#!/usr/bin/env ruby

require "mysql"

def insertData(dbh)
    #idNum = rand(4)
    #idNum = rand(0..4)
    idNum = rand(5) 
    dbh.query("INSERT INTO Student (deptId)
        VALUES
        ('#{idNum}')
    ")
end


begin
    dbname = "ist239"
    # connect to the MySQL server
    dbh = Mysql.real_connect("localhost", "ist239", "password", dbname)
    # get server version string and display it
    puts "Server version: " + dbh.get_server_info
    (1..10).each do
        insertData(dbh)
    end

rescue Mysql::Error => e
    puts "Error code: #{e.errno}"
    puts "Error message: #{e.error}"
    puts "Error SQLSTATE: #{e.sqlstate}" if e.respond_to?("sqlstate")
ensure
    # disconnect from server
    dbh.close if dbh
end
