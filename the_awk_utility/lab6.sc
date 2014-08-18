#!/bin/bash
BEGIN{
    FS=":"
    RS="\n"
    print "\t\t  ***FIRST QUARTERLY REPORT***"
    print "\t\t***CAMPAIGN 2004 CONTRIBUTIONS***"
    print "------------------------------------------\
-----------------------------------"
    printf "%-20s%-15s   %s  |  %s  |  %s  | %s\n",\
	   "NAME", "PHONE", "Jan", "Feb", "Mar", "Total Donated"
    print "------------------------------------------\
-----------------------------------"
}

{
    $6 = $3 + $4 +$5
    printf "%-20s%-15s%8.2f%8.2f%8.2f  %-8.2f\n", $1, $2, $3, $4, $5, $6
    total += $6
    maxtotal = (NR == 1) ? $6 : maxtotal > $6 ? maxtotal : $6
    if ($6 > 500) name[i++] = $1 "--" $2
}

END{
    print "------------------------------------------\
-----------------------------------"
    print "\t\t\t\tSUMARY"
    print "------------------------------------------\
-----------------------------------"
    printf "The campaign received a total of $%.2f for this quarter.\n", total
    printf "The average donation for the %d contributors was $%.2f.\n",
	   NR, total/NR
    printf "The highest total contribution was $%.2f.\n", maxtotal
    print "\n\t\t\t***THANKS Dan***"
    print "The following people donated over $500 to the campaign."
    print "They are eligible for the quarterly drawing!!"
    printf "Listed are their names (sorted by last names) and phone numbers:"
    for (j = 0; j <= i; j++) print "\t"name[j] | "sort -k 2"
    close("sort -k 2") 
    printf "\t\tThanks to all of you for your continued support!\n"
}
