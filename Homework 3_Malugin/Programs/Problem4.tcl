# This program uses TCL. Determines if a student has 60 or more credit hrs to be able to register for CSC 3300
# Compile and run: tclsh Problem4.tcl
	
    package require mysqltcl
    set m [mysql::connect -user root -db TTU -password coursework]
    
    puts [format "%8s %11s %10s" "First Name" "Last Name" "Can Take"]
    mysql::sel $m {select firstname ,lastname,case when credits >=60 then "YES" else "NO" end as take_csc3300 from students} 
    mysqlmap $m {fn ln yesno} {
    
      puts [format "%-12s %-14s %-8s" $fn $ln $yesno]
    
    }

    
    
    mysql::close $m
